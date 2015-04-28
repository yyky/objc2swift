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
import org.antlr.v4.runtime.tree.TerminalNode
import collection.JavaConversions._

trait StatementVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  override def visitStatement_list(ctx: Statement_listContext): String = {
    concatChildResults(ctx, "\n")
  }

  override def visitStatement(ctx: StatementContext): String = {
    indent(ctx) + concatChildResults(ctx, " ") // TODO
  }

  override def visitCompound_statement(ctx: Compound_statementContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitJump_statement(ctx: Jump_statementContext): String = {
    ctx.getChild(0).getText match {
      case "return" => "return " + visit(ctx.expression)
      case "break" => "" // TODO not implemented
      case _ => "" // TODO
    }
  }

  override def visitSelection_statement(ctx: Selection_statementContext): String = {
    val sb = new StringBuilder()
    var statement_kind = ""

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => {
          symbol.getSymbol.getText match {
            case s if s == "if" || s == "switch" => {
              sb.append(s)
              statement_kind = s
            }
            case "(" | ")" => sb.append(" ")
            case _ => null
          }
        }
        case expression: ExpressionContext => {
          sb.append(visit(expression))
        }
        case statement: StatementContext => {
          sb.append("{\n")

          if (statement_kind == "if") {
            sb.append(indentString)
          }
          sb.append(visitChildren(statement) + "\n")
          sb.append(indent(statement) +  "}\n")
        }
        case _ => null
      }
    }

    sb.toString()
  }

  override def visitLabeled_statement(ctx: Labeled_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => {
          symbol.getSymbol.getText match {
            case "case" => sb.append("case ")
            case "default" => sb.append("default")
            case ":" => sb.append(":\n" + indentString)
            case _ => null
          }
        }
        case _ => sb.append(visit(element))
        //TODO fix indent bug
      }
    }
    sb.toString()
  }

  override def visitFor_in_statement(ctx: For_in_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode =>
          symbol.getSymbol.getText match {
            case "for" => sb.append("for")
            case "in" => sb.append(" in ")
            case "(" | ")" => sb.append(" ")
            case _ => null
          }
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(indentString + visitChildren(statement) + "\n")
          sb.append(indent(statement) +  "}\n")
        case typeVariable: Type_variable_declaratorContext => sb.append(visit(typeVariable))
        case _ => null
      }
    }
    sb.toString()
  }

  override def visitFor_statement(ctx: For_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode =>
          symbol.getSymbol.getText match {
            case "for" => sb.append("for")
            case "(" | ")" => sb.append(" ")
            case ";" => sb.append("; ")
            case _ => null
          }
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(indentString + visitChildren(statement) + "\n")
          sb.append(indent(statement) +  "}\n")
        case _ => null
      }
    }
    sb.toString()
  }

  override def visitWhile_statement(ctx: While_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode =>
          symbol.getSymbol.getText match {
            case "while" => sb.append("while")
            case "(" | ")" => sb.append(" ")
            case _ => null
          }
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(indentString + visitChildren(statement) + "\n")
          sb.append(indent(statement) +  "}\n")
        case _ => null
      }
    }
    sb.toString()
  }

  override def visitDo_statement(ctx: Do_statementContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode =>
          symbol.getSymbol.getText match {
            case "do" => sb.append("do ")
            case "while" => sb.append("while")
            case "(" | ")" => sb.append(" ")
            case _ => null
          }
        case expression: ExpressionContext => sb.append(visit(expression))
        case statement: StatementContext =>
          sb.append("{\n")
          sb.append(indentString + visitChildren(statement) + "\n")
          sb.append(indent(statement) +  "} ")
        case _ => null
      }
    }
    sb.toString()
  }

}
