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

  override def visitStatement_list(ctx: Statement_listContext): String = {
    concatChildResults(ctx, "\n") + "\n"
  }

  override def visitStatement(ctx: StatementContext): String = {
    indent(ctx) + concatChildResults(ctx, " ") // TODO
  }

  override def visitCompound_statement(ctx: Compound_statementContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitJump_statement(ctx: Jump_statementContext): String = {
    ctx.getChild(0).getText match {
      case "return" => "return" + (Option(ctx.expression) match {
        case None => ""
        case Some(exp) => " " + visit(exp)
      })
      case "break" => "" // TODO not implemented
      case _ => "" // TODO
    }
  }

  override def visitSelection_statement(ctx: Selection_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case TerminalText("if") => sb.append("if")
        case TerminalText("switch") => sb.append("switch")
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

  override def visitLabeled_statement(ctx: Labeled_statementContext): String = {
    val sb = new StringBuilder()

    //TODO fix indent bug
    for (element <- ctx.children) {
      element match {
        case TerminalText("case") => sb.append("case ")
        case TerminalText("default") => sb.append("default")
        case TerminalText(":") => sb.append(":\n")
        case _ => sb.append(visit(element))
      }
    }
    sb.toString()
  }

  override def visitFor_in_statement(ctx: For_in_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case TerminalText("for") => sb.append("for")
        case TerminalText("in") => sb.append(" in ")
        case TerminalText("(") | TerminalText(")") => sb.append(" ")
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(visitChildren(statement))
          sb.append(indent(statement) +  "}\n")
        case typeVariable: Type_variable_declaratorContext => sb.append(visit(typeVariable))
        case _ =>
      }
    }
    sb.toString()
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
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case TerminalText("for") => sb.append("for")
        case TerminalText("(") | TerminalText(")") => sb.append(" ")
        case TerminalText(";") => sb.append("; ")
        case d: Declaration_specifiersContext =>
          // TODO: Merge with visitDeclaration()
          Option(d.type_specifier()) match {
            case Some(list) =>
              // Other declaration. Find from init_declarator_list
              Option(ctx.init_declarator_list()) match {
                case Some(c) => sb.append(concatDeclaratorList(c))
                case None =>
              }
            case None => // No Type info
          }
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
