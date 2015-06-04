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

import org.antlr.v4.runtime.{ANTLRInputStream, ParserRuleContext, CommonTokenStream}
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.objc2swift.ObjCParser._

class ObjC2SwiftConverter(input: InputStream)
  extends ObjCBaseVisitor[String]
  with ClassVisitor
  with CategoryVisitor
  with ProtocolVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with StatementVisitor
  with ExpressionVisitor
  with OperatorVisitor
  with TypeVisitor
  with EnumVisitor {

  private val lexer = new ObjCLexer(new ANTLRInputStream(input))
  private val tokens = new CommonTokenStream(lexer)
  private val parser = new ObjCParser(tokens)

  protected val root = parser.translation_unit

  def this(inputString: String) {
    this(new ByteArrayInputStream(inputString.getBytes))
  }

  def getResult() = visit(root)

  def getParseTree() = {
    val lines = List.newBuilder[String]
    new ParseTreeWalker().walk(new ObjCBaseListener() {
      override def enterEveryRule(ctx: ParserRuleContext): Unit = {
        lines +=
          (ctx.depth - 1) + "  " * ctx.depth +
            parser.getRuleNames()(ctx.getRuleIndex) + ": " + "'" + ctx.getStart.getText.replace("\n\r\t", " ") + "'"
      }
    }, root)
    lines.result().mkString("\n")
  }

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String = ctx.getText

  override def visitSelector(ctx: SelectorContext): String = ctx.getText
}
