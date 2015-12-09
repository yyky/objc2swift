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
  this: ObjC2SwiftBaseConverter
    with UtilMethods =>

  import org.objc2swift.converter.util._

  override def visitExpression(ctx: ExpressionContext) = concatChildResults(ctx, "")

  override def visitSelectorExpression(ctx: SelectorExpressionContext): String =
    s""""${visit(ctx.selectorName())}""""

  override def visitSelectorName(ctx: SelectorNameContext): String = ctx.getText

  override def visitArrayExpression(ctx: ArrayExpressionContext) = {
    s"[${ctx.postfixExpression.map(visit).mkString(", ")}]"
  }

  override def visitDictionaryExpression(ctx: DictionaryExpressionContext) =
    ctx.dictionaryPair.toList match {
      case Nil => "[:]"
      case list => s"[${list.map(visit).mkString(", ")}]"
    }

  override def visitDictionaryPair(ctx: DictionaryPairContext): String =
    Option(ctx.expression()) match {
      case Some(s) => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.expression())}"
      case None    => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.postfixExpression(1))}"
    }

  override def visitBoxExpression(ctx: BoxExpressionContext): String =
    ctx match {
      case ConstantBox(c) => visit(c)
      case ExpressionBox(c) => s"(${visit(c)})"
      case PostfixExpressionBox(c) => s"(${visit(c)})"
    }

  override def visitBlockExpression(ctx: BlockExpressionContext): String = {
    val blockType = (ctx.blockParameters, ctx.typeSpecifier) match {
      case (null, null) => ""
      case (null, t) =>
        s"() -> ${visit(t)} in"
      case (b, null) =>
        s"${visit(b)} in"
      case (b, t) =>
        s"${visit(b)} -> ${visit(t)} in"
    }

    s"""|{$blockType
        |${visit(ctx.compoundStatement)}
        |${indent(ctx)}}""".stripMargin
  }

  override def visitBlockParameters(ctx: BlockParametersContext): String =
    s"(${ctx.typeVariableDeclarator.map(visit).mkString(", ")})"


  override def visitConditionalExpression(ctx: ConditionalExpressionContext): String = {
    val left = visit(ctx.logicalOrExpression())
    val conds = ctx.conditionalExpression()
    conds.length match {
      case 0 => left
      case 1 => s"$left ?? ${visit(conds(0))}"
      case 2 => s"$left ? ${visit(conds(0))} : ${visit(conds(1))}"
    }
  }

  override def visitCastExpression(ctx: CastExpressionContext): String =
    Option(ctx.typeName()) match {
      case Some(typeName) => s"${visit(ctx.castExpression)} as! ${visit(typeName)}"
      case None => visit(ctx.unaryExpression())
    }

  override def visitPrimaryExpression(ctx: PrimaryExpressionContext): String = {
    if (ctx.getChildCount == 3 && ctx.getChild(0).getText == "(" && ctx.getChild(2).getText == ")") {
      return s"(${visit(ctx.getChild(1))})"
    }

    {
      Option(ctx.IDENTIFIER).map { identifier =>
        identifier.getText match {
          case "YES" => "true"
          case "NO"  => "false"
          case other => other
        }
      } orElse
      Option(ctx.STRING_LITERAL).map(_.getText.substring(1)) orElse
      Option(ctx.constant).map(visit)
    }.getOrElse {
      ctx.getText match {
        case x @ ("self" | "super") => x
        case _ => visitChildren(ctx)
      }
    }
  }

  override def visitArgumentExpressionList(ctx: ArgumentExpressionListContext) = concatChildResults(ctx, ", ")
  override def visitAssignmentExpression(ctx: AssignmentExpressionContext): String = concatChildResults(ctx, " ")

  override def visitEqualityExpression(ctx: EqualityExpressionContext)       = processBinaryExpression(ctx)
  override def visitRelationalExpression(ctx: RelationalExpressionContext)   = processBinaryExpression(ctx)
  override def visitLogicalOrExpression(ctx: LogicalOrExpressionContext)   = processBinaryExpression(ctx)
  override def visitLogicalAndExpression(ctx: LogicalAndExpressionContext) = processBinaryExpression(ctx)
  override def visitAdditiveExpression(ctx: AdditiveExpressionContext)       = processBinaryExpression(ctx)
  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) = processBinaryExpression(ctx)

  override def visitInclusiveOrExpression(ctx: InclusiveOrExpressionContext) = processBinaryExpression(ctx)
  override def visitExclusiveOrExpression(ctx: ExclusiveOrExpressionContext) = processBinaryExpression(ctx)
  override def visitAndExpression(ctx: AndExpressionContext) =  processBinaryExpression(ctx)
  override def visitShiftExpression(ctx: ShiftExpressionContext) =  processBinaryExpression(ctx)

  override def visitUnaryExpression(ctx: UnaryExpressionContext)             = processUnaryExpression(ctx)
  override def visitPostfixExpression(ctx: PostfixExpressionContext)         = processUnaryExpression(ctx)

  override def visitAssignmentOperator(ctx: AssignmentOperatorContext) = ctx.getText
  override def visitUnaryOperator(ctx: UnaryOperatorContext) = ctx.getText

  private def processBinaryExpression(ctx: ParserRuleContext): String = {
    ctx.children.map {
      case TerminalText(s) => s
      case c               => visit(c)
    }.mkString(" ")
  }

  private def processUnaryExpression(ctx: ParserRuleContext): String = {
    ctx.children.map {
      case TerminalText(s) => s
      case c               => visit(c)
    }.mkString
  }
}
