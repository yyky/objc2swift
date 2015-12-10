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
import org.objc2swift.converter.ObjCParser._
import scala.collection.JavaConversions._

/**
 * Implements visit methods for expression contexts.
 */
trait ExpressionVisitor {
  this: ObjC2SwiftBaseConverter =>

  import org.objc2swift.converter.util._

  override def visitExpression(ctx: ExpressionContext) = visitChildren(ctx)

  override def visitSelectorExpression(ctx: SelectorExpressionContext): String =
    visitChildrenAs(ctx) {
      case c: SelectorNameContext => s""""${visit(c)}""""
    }

  override def visitSelectorName(ctx: SelectorNameContext): String = ctx.getText

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
    val left = ctx.logicalOrExpression().map(visit) getOrElse ""
    val conds = ctx.conditionalExpression()
    conds.length match {
      case 0 => left
      case 1 => s"$left ?? ${visit(conds(0))}"
      case 2 => s"$left ? ${visit(conds(0))} : ${visit(conds(1))}"
    }
  }

  override def visitCastExpression(ctx: CastExpressionContext): String =
    (ctx.typeName(), ctx.castExpression()) match {
      case (Some(typeName), Some(castExpression)) => s"${visit(castExpression)} as! ${visit(typeName)}"
      case _ => visit(ctx.unaryExpression())
    }

  override def visitPrimaryExpression(ctx: PrimaryExpressionContext): String = {
    if (ctx.getChildCount == 3 && ctx.getChild(0).getText == "(" && ctx.getChild(2).getText == ")") {
      return s"(${visit(ctx.getChild(1))})"
    }

    {
      ctx.IDENTIFIER().map { identifier =>
        identifier.getText match {
          case "YES" => "true"
          case "NO"  => "false"
          case other => other
        }
      } orElse
      ctx.STRING_LITERAL().map(_.getText.substring(1)) orElse
      ctx.constant().map(visit)
    }.getOrElse {
      ctx.getText match {
        case x @ ("self" | "super") => x
        case _ => visitChildren(ctx)
      }
    }
  }

  override def visitArgumentExpressionList(ctx: ArgumentExpressionListContext) = visitChildren(ctx, ", ")
}
