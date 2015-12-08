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

import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.converter.ObjCParser._

package object util {
  object TerminalText {
    def unapply(node: TerminalNode): Option[String] = Option(node.getSymbol.getText)
  }

  object ClassNameText {
    def unapply(node: ClassNameContext): Option[String] = Option(node.getText)
  }

  object ConstantBox {
    def unapply(ctx: BoxExpressionContext): Option[ConstantContext] = Option(ctx.constant())
  }

  object ExpressionBox {
    def unapply(ctx: BoxExpressionContext): Option[ExpressionContext] = Option(ctx.expression())
  }

  object PostfixExpressionBox {
    def unapply(ctx: BoxExpressionContext): Option[PostfixExpressionContext] = Option(ctx.postfixExpression())
  }
}
