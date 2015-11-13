/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift

import java.io.{ByteArrayInputStream, InputStream}

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTreeWalker

class ObjC2SwiftConverter(input: InputStream) extends BaseConverter(input)
  with ClassVisitor
  with CategoryVisitor
  with ProtocolVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with StatementVisitor
  with ExpressionVisitor
  with MessageVisitor
  with OperatorVisitor
  with TypeVisitor
  with EnumVisitor
  with ErrorHandler {

  parser.removeErrorListeners()
  parser.addErrorListener(this)

  def this(inputString: String) {
    this(new ByteArrayInputStream(inputString.getBytes))
  }

  def getParseTree() = {
    val lines = List.newBuilder[String]
    new ParseTreeWalker().walk(new ObjCBaseListener() {
      override def enterEveryRule(ctx: ParserRuleContext) {
        lines +=
          (ctx.depth - 1) + "  " * ctx.depth +
            parser.getRuleNames()(ctx.getRuleIndex) + ": " + "'" + ctx.getStart.getText.replace("\n\r\t", " ") + "'"
      }
    }, root)
    lines.result().mkString("\n")
  }
}
