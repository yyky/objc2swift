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

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree}
import org.objc2swift.converter.ObjCParser._
import org.objc2swift.converter.util.{NSStringLiteral, IdentifierText, TerminalText}
import scala.collection.JavaConversions._

/**
 * Implements visit methods for expression contexts.
 */
trait ExpressionVisitor {
  this: ObjC2SwiftBaseConverter =>

  override def visitExpression(ctx: ExpressionContext) =
    visitChildren(ctx)

  override def visitSelectorExpression(ctx: SelectorExpressionContext): String =
    visitChildrenAs(ctx) {
      case c: SelectorNameContext => "\"" + visit(c) + "\""
    }

  override def visitSelectorName(ctx: SelectorNameContext): String =
    ctx.getText

  override def visitArrayExpression(ctx: ArrayExpressionContext) = {
    s"[${ctx.postfixExpression().map(visit).mkString(", ")}]"
  }

  override def visitDictionaryExpression(ctx: DictionaryExpressionContext) =
    ctx.dictionaryPair() match {
      case Nil => "[:]"
      case list => s"[${list.map(visit).mkString(", ")}]"
    }

  override def visitDictionaryPair(ctx: DictionaryPairContext): String =
    ctx.expression() match {
      case Some(s) => s"${visit(ctx.postfixExpression(0))}: ${ctx.expression().map(visit)}"
      case None    => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.postfixExpression(1))}"
    }

  override def visitBoxExpression(ctx: BoxExpressionContext): String =
    visitChildrenAs(ctx) {
      case c: ConstantContext => visit(c)
      case c: ExpressionContext => s"(${visit(c)})"
      case c: PostfixExpressionContext => s"(${visit(c)})"
    }

  override def visitConditionalExpression(ctx: ConditionalExpressionContext): String = {
    val cond = ctx.logicalOrExpression().map(visit) getOrElse defaultResult()
    ctx.conditionalExpression() match {
      case List() => cond
      case List(right) => s"$cond ?? ${visit(right)}"
      case List(left, right) => s"$cond ? ${visit(left)} : ${visit(right)}"
    }
  }

  override def visitCastExpression(ctx: CastExpressionContext): String =
    (ctx.typeName(), ctx.castExpression()) match {
      case (Some(typeName), Some(castExpression)) => s"${visit(castExpression)} as! ${visit(typeName)}"
      case _ => visit(ctx.unaryExpression())
    }

  override def visitPrimaryExpression(ctx: PrimaryExpressionContext): String = {
    ctx.children.toList match {
      case List(TerminalText("("), c: ExpressionContext, TerminalText(")")) =>
        s"(${visit(c)})"

      case List(c) => c match {
        case IdentifierText(t) => t match {
          case "YES" => "true"
          case "NO" => "false"
          case _ => t
        }

        case c: ConstantContext => visit(c)
        case NSStringLiteral(t) => t.substring(1)
        case TerminalText("self")  => "self"
        case TerminalText("super") => "super"
        case _ => visitChildren(ctx)
      }
    }
  }

  override def visitArgumentExpressionList(ctx: ArgumentExpressionListContext) =
    visitChildren(ctx, ", ")

  override def visitAssignmentExpression(ctx: AssignmentExpressionContext): String =
    visitChildren(ctx)

  override def visitEqualityExpression(ctx: EqualityExpressionContext) =
    processBinaryExpression(ctx)

  override def visitRelationalExpression(ctx: RelationalExpressionContext) =
    processBinaryExpression(ctx)

  override def visitLogicalOrExpression(ctx: LogicalOrExpressionContext) =
    processBinaryExpression(ctx)

  override def visitLogicalAndExpression(ctx: LogicalAndExpressionContext) =
    processBinaryExpression(ctx)

  override def visitAdditiveExpression(ctx: AdditiveExpressionContext) =
    processBinaryExpression(ctx)

  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) =
    processBinaryExpression(ctx)

  override def visitInclusiveOrExpression(ctx: InclusiveOrExpressionContext) =
    processBinaryExpression(ctx)

  override def visitExclusiveOrExpression(ctx: ExclusiveOrExpressionContext) =
    processBinaryExpression(ctx)

  override def visitAndExpression(ctx: AndExpressionContext) =
    processBinaryExpression(ctx)

  override def visitShiftExpression(ctx: ShiftExpressionContext) =
    processBinaryExpression(ctx)

  override def visitUnaryExpression(ctx: UnaryExpressionContext) =
    processUnaryExpression(ctx)

  override def visitPostfixExpression(ctx: PostfixExpressionContext) =
    processUnaryExpression(ctx)

  override def visitAssignmentOperator(ctx: AssignmentOperatorContext) =
    ctx.getText

  override def visitUnaryOperator(ctx: UnaryOperatorContext) =
    ctx.getText

  private def processBinaryExpression(ctx: ParserRuleContext): String =
    visitChildrenAs(ctx) {
      case TerminalText(s) => s
      case c               => visit(c)
    }

  private def processUnaryExpression(ctx: ParserRuleContext): String =
    visitChildrenAs(ctx, "") {
      case TerminalText(s) => s
      case c               => visit(c)
    }
}
