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
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.TerminalNode
import collection.JavaConversions._

trait ExpressionVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  def visitBinaryOperator(ctx: ParserRuleContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => sb.append(" " + symbol.getSymbol.getText + " ")
        case _ => sb.append(visit(element))
      }
    }

    sb.toString()
  }
  override def visitMessage_expression(ctx: Message_expressionContext): String = {
    val sel = ctx.message_selector()

    val sb = new StringBuilder()
    sb.append(visit(ctx.receiver))
    sb.append(".")

    if(sel.keyword_argument.length == 0) { // no argument
      sb.append(sel.selector.getText + "()")
    } else {
      for (i <- 0 until sel.keyword_argument.length) {
        val arg = sel.keyword_argument(i)
        if(i > 0)
          sb.append(", ")

        if(i == 0) {
          sb.append(arg.selector().getText)
          sb.append("(")
          sb.append(visit(arg.expression))
        } else {
          sb.append(arg.selector().getText + ": ")
          sb.append(visit(arg.expression))
        }
      }
      sb.append(")")
    }
    sb.toString()
  }

  override def visitPrimary_expression(ctx: Primary_expressionContext): String = {
    // TODO need to support more

    if(ctx.message_expression != null)
      return visit(ctx.message_expression)

    if(ctx.STRING_LITERAL != null)
      return ctx.STRING_LITERAL().getText.substring(1)

    ctx.getText
  }

  override def visitExpression(ctx: ExpressionContext): String = {
    concatChildResults(ctx, "")
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

  override def visitEquality_expression(ctx: Equality_expressionContext)       = visitBinaryOperator(ctx)
  override def visitRelational_expression(ctx: Relational_expressionContext)   = visitBinaryOperator(ctx)
  override def visitLogical_or_expression(ctx: Logical_or_expressionContext)   = visitBinaryOperator(ctx)
  override def visitLogical_and_expression(ctx: Logical_and_expressionContext) = visitBinaryOperator(ctx)
  override def visitAdditive_expression(ctx: Additive_expressionContext)       = visitBinaryOperator(ctx)
  override def visitMultiplicative_expression(ctx: Multiplicative_expressionContext) = visitBinaryOperator(ctx)
  override def visitAssignment_expression(ctx: Assignment_expressionContext)   = visitBinaryOperator(ctx)
}
