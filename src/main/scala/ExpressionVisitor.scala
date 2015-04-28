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

  def visitUnaryOperator(ctx: ParserRuleContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => sb.append(symbol.getSymbol.getText)
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

  /*
   * Expressions
   */
  /*
  override def visitMessage_expression(ctx: Message_expressionContext): String = {
    val sel = ctx.message_selector()
    val rcv = visit(ctx.receiver)

    // TODO: stringWithFormat conversion
    rcv match {
      case "NSString" =>
        Option(sel.keyword_argument()) match {
          case Some(k) if k.length != 0 =>
            val p1 = k.get(0)
            Option(p1.selector()) match {
              case None => commonMessageExpression(ctx)
              case Some(s) => s.getText match {
                case s2 if s2 == "stringWithFormat" => stringWithFormat(sel)
                case _ => commonMessageExpression(ctx)
              }
            }
          case _ => commonMessageExpression(ctx)
        }
      case _ => commonMessageExpression(ctx)
    }

  }
  */

  override def visitPrimary_expression(ctx: Primary_expressionContext): String = {
    // TODO need to support more

    if(ctx.message_expression != null)
      return visit(ctx.message_expression)

    if(ctx.STRING_LITERAL != null)
      return ctx.STRING_LITERAL().getText.substring(1)

    ctx.getText
  }

  override def visitExpression(ctx: ExpressionContext): String = concatChildResults(ctx, "")

  override def visitEquality_expression(ctx: Equality_expressionContext)       = visitBinaryOperator(ctx)
  override def visitRelational_expression(ctx: Relational_expressionContext)   = visitBinaryOperator(ctx)
  override def visitLogical_or_expression(ctx: Logical_or_expressionContext)   = visitBinaryOperator(ctx)
  override def visitLogical_and_expression(ctx: Logical_and_expressionContext) = visitBinaryOperator(ctx)
  override def visitAdditive_expression(ctx: Additive_expressionContext)       = visitBinaryOperator(ctx)
  override def visitMultiplicative_expression(ctx: Multiplicative_expressionContext) = visitBinaryOperator(ctx)

  override def visitAssignment_expression(ctx: Assignment_expressionContext): String = concatChildResults(ctx, " ")

  override def visitUnary_expression(ctx: Unary_expressionContext)             = visitUnaryOperator(ctx)
  override def visitPostfix_expression(ctx: Postfix_expressionContext)         = visitUnaryOperator(ctx)
}
