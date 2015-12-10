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

trait StatementVisitor {
  this: ObjC2SwiftBaseConverter =>

  import org.objc2swift.converter.util._

  /**
   * Returns translated text of compoundStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitCompoundStatement(ctx: CompoundStatementContext): String =
    visitChildren(ctx)

  /**
   * Returns translated text of statementList context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatementList(ctx: StatementListContext): String =
    visitChildren(ctx, "\n")

  /**
   * Returns translated text of statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatement(ctx: StatementContext): String =
    visitChildrenAs(ctx) {
      case TerminalText(";") => ""
      case c => visit(c)
    }

  /**
   * Returns translated text of jumpStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitJumpStatement(ctx: JumpStatementContext): String =
    ctx.getChild(0).getText match {
      case "return" => s"return ${ctx.expression().map(visit).getOrElse("")}".stripSuffix(" ")
      case "break"  => "" // TODO not implemented
      case _        => "" // TODO
    }

  /**
   * Returns translated text of selectionStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelectionStatement(ctx: SelectionStatementContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("if")     => "if"
      case TerminalText("else")   => "else"
      case TerminalText("switch") => "switch"
      case c: ExpressionContext   => visit(c)
      case c: StatementContext    => visitBodyStatement(c).stripLineEnd
    }

  /**
   * Returns translated text of labeledStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitLabeledStatement(ctx: LabeledStatementContext): String =
    //TODO fix indent bug
    visitChildrenAs(ctx, "") {
      case TerminalText("case")    => "case "
      case TerminalText("default") => "default"
      case TerminalText(":")       => ":\n"
      case element                 => visit(element)
    }

  /**
   * Returns translated text of forInStatement.
   *
   * @param ctx the parse tree
   **/
  override def visitForInStatement(ctx: ForInStatementContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("for")                => "for"
      case TerminalText("in")                 => "in"
      case c: ExpressionContext               => visit(c)
      case c: TypeVariableDeclaratorContext => visit(c)
      case c: StatementContext                => visitBodyStatement(c)
    }

  /**
   * Returns translated text of forStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitForStatement(ctx: ForStatementContext): String =
    visitChildrenAs(ctx, "") {
      case TerminalText("for")                   => "for "
      case TerminalText(";")                     => "; "
      case c: ExpressionContext                  => visit(c)
      case d: DeclarationSpecifiersContext       => ctx.initDeclaratorList().map(declaratorListString) getOrElse ""
      case c: StatementContext                   => s" ${visitBodyStatement(c)}"
    }

  /**
   * Returns translated text of whileStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitWhileStatement(ctx: WhileStatementContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("while") => "while"
      case c: ExpressionContext  => visit(c)
      case c: StatementContext   => visitBodyStatement(c)
    }

  /**
   * Returns translated text of doStatement context.
   *
   * @param ctx the parse tree
   **/
  override def visitDoStatement(ctx: DoStatementContext): String =
    visitChildrenAs(ctx, "") {
      case TerminalText("do")    => "repeat {\n"
      case TerminalText("while") => s"} while"
      case c: ExpressionContext  => s" ${visit(c)}\n"
      case c: StatementContext   => indent(visitChildren(c)) + "\n"
    }

  private def visitBodyStatement(ctx: StatementContext): String = {
    val statements =
      if (ctx.compoundStatement() != null) visitChildren(ctx)
      else s"$indentString${visit(ctx)}"

    s"""|{
        |${indent(statements.stripLineEnd)}
        |}
        |""".stripMargin
  }

  private def declaratorOption(ctx: InitDeclaratorContext): Option[String] =
    for {
      id <- ctx.declarator().flatMap(_.directDeclarator()).flatMap(_.identifier())
      init <- ctx.initializer()
    } yield s"${visit(id)} = ${visit(init)}"

  private def declaratorListString(ctx: InitDeclaratorListContext): String = {
    val list =
      ctx.initDeclarator()
        .flatMap(declaratorOption(_))
        .mkString(", ")

    if (list.nonEmpty) s"var $list" else ""
  }
}
