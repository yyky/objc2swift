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
trait OperationVisitor {
  this: ObjC2SwiftBaseConverter
    with UtilMethods =>

  import org.objc2swift.converter.util._

  override def visitAssignmentExpression(ctx: AssignmentExpressionContext): String = visitChildren(ctx)

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
