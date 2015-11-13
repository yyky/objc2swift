/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift

import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._

protected trait StatementVisitor extends BaseConverter {
  /**
   * Returns translated text of compound_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitCompound_statement(ctx: Compound_statementContext): String =
    concatChildResults(ctx, "")

  /**
   * Returns translated text of statement_list context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatement_list(ctx: Statement_listContext): String =
    ctx.statement().map(visit).filter(_.nonEmpty).mkString("\n") + "\n"

  /**
   * Returns translated text of statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatement(ctx: StatementContext): String = {
    ctx.children.map {
      case TerminalText(";") => ""
      case c: Labeled_statementContext =>
        s"${indent(ctx)}${visit(c)}".stripPrefix(indentString)
      case c =>
        s"${indent(ctx)}${visit(c)}"
    }.mkString(" ")
  }

  /**
   * Returns translated text of jump_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitJump_statement(ctx: Jump_statementContext): String =
    ctx.getChild(0).getText match {
      case "return" => s"return ${Option(ctx.expression).map(visit).getOrElse("")}".stripSuffix(" ")
      case "break"  => "" // TODO not implemented
      case _        => "" // TODO
    }

  /**
   * Returns translated text of selection_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelection_statement(ctx: Selection_statementContext): String = {
    ctx.children.collect {
      case TerminalText("if")     => "if"
      case TerminalText("else")   => "else"
      case TerminalText("switch") => "switch"
      case c: ExpressionContext   => visit(c)
      case c: StatementContext    => visitBodyStatement(c).stripLineEnd
    }.mkString(" ") + "\n"
  }

  /**
   * Returns translated text of labeled_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitLabeled_statement(ctx: Labeled_statementContext): String = {
    //TODO fix indent bug
    ctx.children.map {
      case TerminalText("case")    => "case "
      case TerminalText("default") => "default"
      case TerminalText(":")       => ":\n"
      case element                 => visit(element)
    }.mkString
  }

  /**
   * Returns translated text of for_in_statement.
   *
   * @param ctx the parse tree
   **/
  override def visitFor_in_statement(ctx: For_in_statementContext): String = {
    ctx.children.collect {
      case TerminalText("for")                => "for"
      case TerminalText("in")                 => "in"
      case c: ExpressionContext               => visit(c)
      case c: Type_variable_declaratorContext => visit(c)
      case c: StatementContext                => visitBodyStatement(c)
    }.mkString(" ")
  }

  /**
   * Returns translated text of for_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitFor_statement(ctx: For_statementContext): String = {
    ctx.children.flatMap {
      case TerminalText("for")                   => Some("for ")
      case TerminalText(";")                     => Some("; ")
      case c: ExpressionContext                  => Some(visit(c))
      case d: Declaration_specifiersContext      =>
        for {
          _ <- Option(d.type_specifier())
          y <- Option(ctx.init_declarator_list())
        } yield declaratorListString(y)
      case c: StatementContext                   => Some(s" ${visitBodyStatement(c)}")
      case _ => None
    }.mkString
  }

  /**
   * Returns translated text of while_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitWhile_statement(ctx: While_statementContext): String = {
    ctx.children.collect {
      case TerminalText("while") => "while"
      case c: ExpressionContext  => visit(c)
      case c: StatementContext   => visitBodyStatement(c)
    }.mkString(" ")
  }

  /**
   * Returns translated text of do_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitDo_statement(ctx: Do_statementContext): String = {
    ctx.children.collect {
      case TerminalText("do")    => "do {\n"
      case TerminalText("while") => s"${indent(ctx)}} while"
      case c: ExpressionContext  => s" ${visit(c)}\n"
      case c: StatementContext   => visitChildren(c)
    }.mkString
  }

  private def visitBodyStatement(ctx: StatementContext): String = {
    val statements =
      if (ctx.compound_statement() != null) visitChildren(ctx)
      else s"$indentString${visit(ctx)}"

    s"""|{
        |${statements.stripLineEnd}
        |${indent(ctx)}}
        |""".stripMargin
  }

  private def declaratorOption(ctx: Init_declaratorContext): Option[String] =
    for {
      id <- Option(ctx.declarator().direct_declarator().identifier())
      init <- Option(ctx.initializer())
    } yield s"${visit(id)} = ${visit(init)}"

  private def declaratorListString(ctx: Init_declarator_listContext): String = {
    val list =
      ctx.init_declarator()
        .flatMap(declaratorOption(_))
        .mkString(", ")

    if (list.nonEmpty) s"var $list" else ""
  }
}
