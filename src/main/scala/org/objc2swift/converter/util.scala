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

import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.converter.ObjCParser._

package object util {
  def stringFormat(v: ObjC2SwiftBaseConverter, exps: List[_ <: RuleContext]): String = exps match {
    case head :: tail if tail.nonEmpty =>
      val format = v.visit(head)
      if(format.matches("^\".*\"$") && "%[0-9.\\-+#]+[a-z@]+".r.findFirstIn(format).isEmpty) {
        val params = tail.map(c => s"""\\(${v.visit(c)})""")
        (("" +: params) zip "(%[a-z@]+)".r.split(format))
          .map{ case (s, p) => s + p }
          .mkString
      } else {
        s"String(format: ${format}, ${v.visitList(tail, ", ")})"
      }

    case head :: Nil =>
      v.visit(head)

    case _ =>
      v.defaultResult()
  }

  object TerminalText {
    def unapply(node: TerminalNode): Option[String] = Option(node.getSymbol.getText)
  }

  object IdentifierText {
    def unapply(node: TerminalNode): Option[String] =
      if(node.getSymbol.getType == IDENTIFIER)
        Some(node.getSymbol.getText)
      else
        None
  }

  object NSStringLiteral {
    def unapply(node: TerminalNode): Option[String] =
      if(node.getSymbol.getType == STRING_LITERAL)
        Some(node.getSymbol.getText)
      else
        None
  }

  object ClassNameText {
    def unapply(node: ClassNameContext): Option[String] = Option(node.getText)
  }
}
