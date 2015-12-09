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

import org.antlr.v4.runtime.tree.{ParseTreeProperty, ParseTree}
import org.antlr.v4.runtime.{RuleContext, ANTLRInputStream, CommonTokenStream, ParserRuleContext}
import org.objc2swift.converter.ObjCParser.TranslationUnitContext

abstract class ObjC2SwiftBaseConverter extends ObjCBaseVisitor[String] {
  def getResult(): String

  private val visited = new ParseTreeProperty[Boolean]
  protected def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)
  protected def setVisited(node: ParseTree) = visited.put(node, true)

  override def visit(tree: ParseTree): String =
    if(!isVisited(tree)) {
      setVisited(tree)
      visitImpl(tree)
    } else {
      ""
    }

  protected def visitImpl(tree: ParseTree): String = super.visit(tree)
}

class ObjC2SwiftConverter(parser: ObjCParser) extends ObjC2SwiftBaseConverter
  with RootVisitor
  with ClassVisitor
  with ProtocolVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with EnumVisitor
  with StatementVisitor
  with ExpressionVisitor
  with MessageVisitor
  with TypeVisitor
  with TerminalNodeVisitor
  with UtilMethods
  with ErrorHandler {

  protected val root = parser.translationUnit()

  override def getResult() = visit(root)

  parser.removeErrorListeners()
  parser.addErrorListener(this)

  override def visitImpl(tree: ParseTree): String =
    lineError(tree) match {
      case Some(error) =>
        val ctx = tree.asInstanceOf[ParserRuleContext]
        val (message, source) = error
        s"""
           |${indent(ctx)}// ${message}
            |${indent(ctx)}// ${source}
            |
         """.stripMargin + super.visitImpl(tree)
      case None =>
        super.visitImpl(tree)
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