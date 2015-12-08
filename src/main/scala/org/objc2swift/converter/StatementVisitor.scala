/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift.converter

import org.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

protected trait StatementVisitor {
  this: ObjC2SwiftConverter =>

  import org.objc2swift.converter.util._

  /**
   * Returns translated text of compoundStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitCompoundStatement(ctx: CompoundStatementContext): String =
    concatChildResults(ctx, "")

  /**
   * Returns translated text of statementList context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatementList(ctx: StatementListContext): String =
    ctx.statement().map(visit).filter(_.nonEmpty).mkString("\n") + "\n"

  /**
   * Returns translated text of statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatement(ctx: StatementContext): String = {
    ctx.children.map {
      case TerminalText(";") => ""
      case c: LabeledStatementContext =>
        s"${indent(ctx)}${visit(c)}".stripPrefix(indentString)
      case c =>
        s"${indent(ctx)}${visit(c)}"
    }.mkString(" ")
  }

  /**
   * Returns translated text of jumpStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitJumpStatement(ctx: JumpStatementContext): String =
    ctx.getChild(0).getText match {
      case "return" => s"return ${Option(ctx.expression).map(visit).getOrElse("")}".stripSuffix(" ")
      case "break"  => "" // TODO not implemented
      case _        => "" // TODO
    }

  /**
   * Returns translated text of selectionStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelectionStatement(ctx: SelectionStatementContext): String = {
    ctx.children.collect {
      case TerminalText("if")     => "if"
      case TerminalText("else")   => "else"
      case TerminalText("switch") => "switch"
      case c: ExpressionContext   => visit(c)
      case c: StatementContext    => visitBodyStatement(c).stripLineEnd
    }.mkString(" ") + "\n"
  }

  /**
   * Returns translated text of labeledStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitLabeledStatement(ctx: LabeledStatementContext): String = {
    //TODO fix indent bug
    ctx.children.map {
      case TerminalText("case")    => "case "
      case TerminalText("default") => "default"
      case TerminalText(":")       => ":\n"
      case element                 => visit(element)
    }.mkString
  }

  /**
   * Returns translated text of forInStatement.
   *
   * @param ctx the parse tree
   **/
  override def visitForInStatement(ctx: ForInStatementContext): String = {
    ctx.children.collect {
      case TerminalText("for")                => "for"
      case TerminalText("in")                 => "in"
      case c: ExpressionContext               => visit(c)
      case c: TypeVariableDeclaratorContext => visit(c)
      case c: StatementContext                => visitBodyStatement(c)
    }.mkString(" ")
  }

  /**
   * Returns translated text of forStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitForStatement(ctx: ForStatementContext): String = {
    ctx.children.flatMap {
      case TerminalText("for")                   => Some("for ")
      case TerminalText(";")                     => Some("; ")
      case c: ExpressionContext                  => Some(visit(c))
      case d: DeclarationSpecifiersContext      =>
        for {
          _ <- Option(d.typeSpecifier())
          y <- Option(ctx.initDeclaratorList())
        } yield declaratorListString(y)
      case c: StatementContext                   => Some(s" ${visitBodyStatement(c)}")
      case _ => None
    }.mkString
  }

  /**
   * Returns translated text of whileStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitWhileStatement(ctx: WhileStatementContext): String = {
    ctx.children.collect {
      case TerminalText("while") => "while"
      case c: ExpressionContext  => visit(c)
      case c: StatementContext   => visitBodyStatement(c)
    }.mkString(" ")
  }

  /**
   * Returns translated text of doStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitDoStatement(ctx: DoStatementContext): String = {
    ctx.children.collect {
      case TerminalText("do")    => "do {\n"
      case TerminalText("while") => s"${indent(ctx)}} while"
      case c: ExpressionContext  => s" ${visit(c)}\n"
      case c: StatementContext   => visitChildren(c)
    }.mkString
  }

  private def visitBodyStatement(ctx: StatementContext): String = {
    val statements =
      if (ctx.compoundStatement() != null) visitChildren(ctx)
      else s"$indentString${visit(ctx)}"

    s"""|{
        |${statements.stripLineEnd}
        |${indent(ctx)}}
        |""".stripMargin
  }

  private def declaratorOption(ctx: InitDeclaratorContext): Option[String] =
    for {
      id <- Option(ctx.declarator().directDeclarator().identifier())
      init <- Option(ctx.initializer())
    } yield s"${visit(id)} = ${visit(init)}"

  private def declaratorListString(ctx: InitDeclaratorListContext): String = {
    val list =
      ctx.initDeclarator()
        .flatMap(declaratorOption(_))
        .mkString(", ")

    if (list.nonEmpty) s"var $list" else ""
  }
}
