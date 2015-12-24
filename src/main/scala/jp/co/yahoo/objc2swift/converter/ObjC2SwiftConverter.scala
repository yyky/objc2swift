/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package jp.co.yahoo.objc2swift.converter

import java.io.{ByteArrayInputStream, InputStream}

import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

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
  with BlockVisitor
  with MessageVisitor
  with TerminalNodeVisitor
  with ErrorHandler {

  parser.removeErrorListeners()
  parser.addErrorListener(this)

  protected val root = parser.translationUnit()
  override def getResult() = visit(root)

  override def visit(tree: ParseTree): String = {
    setVisited(tree)
    lineError(tree) match {
      case Some(Error(message)) => s"// $message"
      case None => super.visit(tree)
    }
  }
}

object ObjC2SwiftConverter {
  val Version = "1.0"

  def generateParser(input: InputStream) = {
    val lexer = new ObjCLexer(new ANTLRInputStream(input))
    val tokens = new CommonTokenStream(lexer)
    new ObjCParser(tokens)
  }

  def generateParser(input: String) : ObjCParser =
    generateParser(new ByteArrayInputStream(input.getBytes()))
}