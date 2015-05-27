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
  override def visitStatement(ctx: StatementContext): String =
    indent(ctx) + concatChildResults(ctx, " ")

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

    for (element <- ctx.children) {
      element match {
        case TerminalText("if")                    => builder += "if"
        case TerminalText("switch")                => builder += "switch"
        case TerminalText("(") | TerminalText(")") => builder += " "
        case c: ExpressionContext                  => builder += visit(c)
        case c: StatementContext                   =>
          val statements = Option(c.compound_statement()) match {
            case Some(s) => visitChildren(c)
            case None => s"$indentString${visit(c)}\n"
          }
          builder +=
            s"""{
               |$statements
               |${indent(ctx)}}
               |""".stripMargin
        case _ =>
      }
    }

    builder.result().mkString
  }


  /**
   * Returns translated text of labeled_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitLabeled_statement(ctx: Labeled_statementContext): String = {
    val builder = List.newBuilder[String]

    //TODO fix indent bug
    for (element <- ctx.children) {
      element match {
        case TerminalText("case")    => builder += "case "
        case TerminalText("default") => builder += "default"
        case TerminalText(":")       => builder += ":\n"
        case _                       => builder += visit(element)
      }
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

    for (element <- ctx.children) {
      element match {
        case TerminalText("for")                   => builder += "for"
        case TerminalText("in")                    => builder += " in "
        case TerminalText("(") | TerminalText(")") => builder += " "
        case c: ExpressionContext                  => builder += visit(c)
        case c: Type_variable_declaratorContext    => builder += visit(c)
        case c: StatementContext                   => builder +=
          s"""{
             |${visit(c)}
             |${indent(ctx)}}
           """.stripMargin
        case _ =>
      }
    }

    builder.result().mkString
  }

  /**
   * Returns translated text of for_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitFor_statement(ctx: For_statementContext): String = {
    val builder = List.newBuilder[String]

    for (element <- ctx.children) {
      element match {
        case TerminalText("for")                   => builder += "for"
        case TerminalText("(") | TerminalText(")") => builder += " "
        case TerminalText(";")                     => builder += "; "
        case c: ExpressionContext                  => builder += visit(c)
        case d: Declaration_specifiersContext      =>
          for {
            x <- Option(d.type_specifier())
            y <- Option(ctx.init_declarator_list())
          } builder += declaratorListString(y)
        case c: StatementContext                   =>
          val statements = Option(c.compound_statement()) match {
            case Some(s) => visitChildren(c)
            case None => s"$indentString${visit(c)}\n"
          }
          builder +=
            s"""{
               |$statements
               |${indent(ctx)}}
               |""".stripMargin
        case _ =>
      }
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

    for (element <- ctx.children) {
      element match {
        case TerminalText("while")                 => builder += "while"
        case TerminalText("(") | TerminalText(")") => builder += " "
        case c: ExpressionContext                  => builder += visit(c)
        case c: StatementContext                   => builder +=
          s"""{
             |${visitChildren(c)}
             |${indent(ctx)}}
             |""".stripMargin
        case _ =>
      }
    }

    builder.result().mkString
  }

  /**
   * Returns translated text of do_statement context.
   *
   * @param ctx the parse tree
   **/
  override def visitDo_statement(ctx: Do_statementContext): String = {
    val builder = List.newBuilder[String]

    for (element <- ctx.children) {
      element match {
        case TerminalText("do")    => builder += "do"
        case TerminalText("while") => builder += "while"
        case TerminalText("(")     => builder += " "
        case TerminalText(")")     => builder += "\n"
        case c: ExpressionContext  => builder += visit(c)
        case c: StatementContext   => builder +=
          s""" {
             |${visitChildren(c)}
             |${indent(c)}} """.stripMargin
        case _ =>
      }
    }

    builder.result().mkString
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
