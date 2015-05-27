/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import ObjCParser._
import collection.JavaConversions._

trait StatementVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

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
    ctx.statement().map(visit).filter(!_.isEmpty).mkString("\n") + "\n"

  /**
   * Returns translated text of statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitStatement(ctx: StatementContext): String = {
    val builder = List.newBuilder[String]
    ctx.children.foreach {
      case TerminalText(";") =>
      case c: Labeled_statementContext =>
        builder += s"${indent(ctx)}${visit(c)}".stripPrefix(indentString)
      case c =>
        builder += s"${indent(ctx)}${visit(c)}"
    }
    builder.result().mkString(" ")
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
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("if")     => builder += "if"
      case TerminalText("switch") => builder += "switch"
      case c: ExpressionContext   => builder += visit(c)
      case c: StatementContext    => builder += visitBodyStatement(c)
      case _ =>
    }

    builder.result().mkString(" ")
  }

  /**
   * Returns translated text of labeled_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitLabeled_statement(ctx: Labeled_statementContext): String = {
    val builder = List.newBuilder[String]

    //TODO fix indent bug
    ctx.children.foreach {
      case TerminalText("case")    => builder += "case "
      case TerminalText("default") => builder += "default"
      case TerminalText(":")       => builder += ":\n"
      case element                 => builder += visit(element)
    }

    builder.result().mkString
  }

  /**
   * Returns translated text of for_in_statement.
   *
   * @param ctx the parse tree
   **/
  override def visitFor_in_statement(ctx: For_in_statementContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("for")                => builder += "for"
      case TerminalText("in")                 => builder += "in"
      case c: ExpressionContext               => builder += visit(c)
      case c: Type_variable_declaratorContext => builder += visit(c)
      case c: StatementContext                => builder += visitBodyStatement(c)
      case _ =>
    }

    builder.result().mkString(" ")
  }

  /**
   * Returns translated text of for_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitFor_statement(ctx: For_statementContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("for")                   => builder += "for "
      case TerminalText(";")                     => builder += "; "
      case c: ExpressionContext                  => builder += visit(c)
      case d: Declaration_specifiersContext      =>
        for {
          x <- Option(d.type_specifier())
          y <- Option(ctx.init_declarator_list())
        } builder += declaratorListString(y)
      case c: StatementContext                   => builder += s" ${visitBodyStatement(c)}"
      case _ =>
    }

    builder.result().mkString
  }

  /**
   * Returns translated text of while_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitWhile_statement(ctx: While_statementContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("while") => builder += "while"
      case c: ExpressionContext  => builder += visit(c)
      case c: StatementContext   => builder += visitBodyStatement(c)
      case _ =>
    }

    builder.result().mkString(" ")
  }

  /**
   * Returns translated text of do_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitDo_statement(ctx: Do_statementContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("do")    => builder += "do {\n"
      case TerminalText("while") => builder += s"${indent(ctx)}} while"
      case c: ExpressionContext  => builder += s" ${visit(c)}\n"
      case c: StatementContext   => builder += visitChildren(c)
      case _ =>
    }

    builder.result().mkString
  }

  private def visitBodyStatement(ctx: StatementContext): String = {
    val statements = Option(ctx.compound_statement()) match {
      case Some(s) => visitChildren(ctx)
      case None    => s"$indentString${visit(ctx)}"
    }
    s"""{
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
    val list = ctx.init_declarator()
      .map(declaratorOption(_).getOrElse(""))
      .filter(_ != "")
      .mkString(", ")
    list match {
      case s if !s.isEmpty => s"var $list"
      case _ => ""
    }
  }
}
