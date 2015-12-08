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

import java.io.{ByteArrayInputStream, InputStream}

import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream, ParserRuleContext}

class ObjC2SwiftConverter(parser: ObjCParser) extends ObjCBaseVisitor[String]
  with RootVisitor
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
  with TerminalNodeVisitor
  with UtilMethods
  with UtilObjects
  with ErrorHandler {

  parser.removeErrorListeners()
  parser.addErrorListener(this)

  protected val root = parser.translationUnit()
  def getResult() = visit(root)

  override def visit(tree: ParseTree): String =
    if(!isVisited(tree)) {
      setVisited(tree)

      lineError(tree).map { error =>
        val ctx = tree.asInstanceOf[ParserRuleContext]
        val (message, source) = error
        s"""
           |${indent(ctx)}// ${message}
            |${indent(ctx)}// ${source}
            |
         """.stripMargin + super.visit(tree)
      }.getOrElse(super.visit(tree))
    } else {
      ""
    }
}

object ObjC2SwiftConverter {
  def generateParser(input: InputStream) = {
    val lexer = new ObjCLexer(new ANTLRInputStream(input))
    val tokens = new CommonTokenStream(lexer)
    new ObjCParser(tokens)
  }

  def generateParser(input: String) : ObjCParser =
    generateParser(new ByteArrayInputStream(input.getBytes()))
}