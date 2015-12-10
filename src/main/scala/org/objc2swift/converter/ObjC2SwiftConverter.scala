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

import org.antlr.v4.runtime.tree.{RuleNode, ParseTreeProperty, ParseTree}
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
      super.visit(tree)
    } else {
      defaultResult()
    }

  override def visitChildren(node: RuleNode): String = visitChildren(node, " ")

  def visitChildren(node: RuleNode, glue: String): String =
    Range(0, node.getChildCount).map(node.getChild(_)).map(visit).filter(_.nonEmpty).mkString(glue)

  def visitChildrenAs(node: RuleNode)(pf: PartialFunction[ParseTree, String]): String =
    visitChildrenAs(node, " ")(pf)

  def visitChildrenAs(node: RuleNode, glue: String)(pf: PartialFunction[ParseTree, String]): String =
    Range(0, node.getChildCount).map(node.getChild(_)).collect(pf).filter(_.nonEmpty).mkString(glue)

  def visit(optionNode: Option[ParseTree]): String =
    optionNode.map(visit).getOrElse("")

  override def defaultResult(): String = ""

  protected val indentString = " " * 4
  protected def indent(source: String): String =
    source.split("\n").map(indentString + _).mkString("\n")

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
  with BlockVisitor
  with MessageVisitor
  with OperationVisitor
  with TypeVisitor
  with TerminalNodeVisitor
  with ErrorHandler {

  protected val root = parser.translationUnit()

  override def getResult() = visit(root)

  parser.removeErrorListeners()
  parser.addErrorListener(this)
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