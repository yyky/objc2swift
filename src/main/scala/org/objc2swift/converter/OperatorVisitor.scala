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

import org.objc2swift.converter.ObjCParser._

protected trait OperatorVisitor {
  this: ObjC2SwiftConverter =>

  override def visitAssignment_operator(ctx: Assignment_operatorContext) = ctx.getText
  override def visitUnary_operator(ctx: Unary_operatorContext) = ctx.getText
}
