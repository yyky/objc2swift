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

  override def visitCompound_statement(ctx: Compound_statementContext): String =
    concatChildResults(ctx, "")

  override def visitStatement_list(ctx: Statement_listContext): String =
    ctx.statement().map(visit).filter(!_.isEmpty).mkString("\n") + "\n"

  override def visitStatement(ctx: StatementContext): String = {
    indent(ctx) + concatChildResults(ctx, " ") // TODO
    //concatChildResults(ctx, " ") // TODO
  }

  override def visitJump_statement(ctx: Jump_statementContext): String =
    ctx.getChild(0).getText match {
      case "return" => s"return ${Option(ctx.expression).map(visit).getOrElse("")}".trim
      case "break"  => "" // TODO not implemented
      case _        => "" // TODO
    }

  override def visitSelection_statement(ctx: Selection_statementContext): String = {
    val builder = List.newBuilder[String]

    for (element <- ctx.children) {
      element match {
        case TerminalText("if")                    => builder += "if"
        case TerminalText("switch")                => builder += "switch"
        case TerminalText("(") | TerminalText(")") => builder += " "
        case expression: ExpressionContext         => builder += visit(expression)
        case statement: StatementContext           =>
          builder += "{\n"
          Option(statement.compound_statement()) match {
            case Some(s) => builder += visitChildren(statement)
            case None => builder += indentString + visit(statement) + "\n"
          }
          builder += indent(ctx) + "}\n"
          /*
          builder +=
            s"""{
               |${visit(statement)}
               |${indent(ctx)}}
               |""".stripMargin
               */
          /*
          builder += "{\n"
          statement.children.foreach {
            case TerminalText(s) =>
            case c => builder += s"${indent(ctx) + indentString}${visit(c)}\n"
          }
          builder += s"${indent(ctx)}}\n"
          */
        case _ =>
      }
    }

    builder.result().mkString
  }

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

  override def visitFor_in_statement(ctx: For_in_statementContext): String = {
    val builder = List.newBuilder[String]

    for (element <- ctx.children) {
      element match {
        case TerminalText("for")                   => builder += "for"
        case TerminalText("in")                    => builder += " in "
        case TerminalText("(") | TerminalText(")") => builder += " "
        case expression: ExpressionContext         => builder += visit(expression)
        case statement: StatementContext           => builder += "{\n" + visit(statement) + indent(ctx) + "}\n"
          /*
          builder +=
            s"""{
               |${visit(statement)}
               |${indent(ctx)}}
             """.stripMargin
             */
        case typeVariable: Type_variable_declaratorContext => builder += visit(typeVariable)
        case _ =>
      }
    }

    builder.result().mkString
  }

  def concatDeclaratorList(ctx: Init_declarator_listContext): String =
    ctx.init_declarator().map(c => {
      Option(c.declarator().direct_declarator().identifier()) match {
        case Some(id) =>
          Option(c.initializer()) match {
            case Some(init) => visit(id) + " = " + visit(init)
            case None => ""
          }
        case None => ""
      }
    }).filter(_ != "").mkString(", ") match {
      case s if s != "" => "var " + s
      case _ => ""
    }

  override def visitFor_statement(ctx: For_statementContext): String = {
    val builder = List.newBuilder[String]

    for (element <- ctx.children) {
      element match {
        case TerminalText("for")                   => builder += "for"
        case TerminalText("(") | TerminalText(")") => builder += " "
        case TerminalText(";")                     => builder += "; "
        case d: Declaration_specifiersContext =>
          // TODO: Merge with visitDeclaration()
          for {
            x <- Option(d.type_specifier())
            y <- Option(ctx.init_declarator_list())
          } builder += concatDeclaratorList(y)
          /*
          Option(d.type_specifier()) match {
            case Some(list) =>
              // Other declaration. Find from init_declarator_list
              Option(ctx.init_declarator_list()) match {
                case Some(c) => sb.append(concatDeclaratorList(c))
                case None =>
              }
            case None => // No Type info
          }
          */
        case expression: ExpressionContext => builder += visit(expression)
        case statement: StatementContext =>
          builder +=
            s"""{
               |${visit(statement)}
               |${indent(ctx)}}
             """.stripMargin
        case _ =>
      }
    }
    builder.result().mkString
  }

  override def visitWhile_statement(ctx: While_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case TerminalText("while") => sb.append("while")
        case TerminalText("(") | TerminalText(")") => sb.append(" ")
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(visitChildren(statement))
          sb.append(indent(statement) +  "}\n")
        case _ =>
      }
    }
    sb.toString()
  }

  override def visitDo_statement(ctx: Do_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case TerminalText("do") => sb.append("do")
        case TerminalText("while") => sb.append("while")
        case TerminalText("(") => sb.append(" ")
        case TerminalText(")") => sb.append("\n")
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append(" {\n")
          sb.append(visitChildren(statement))
          sb.append(indent(statement) +  "} ")
        case _ =>
      }
    }
    sb.toString()
  }

}
