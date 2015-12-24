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

import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty, RuleNode, TerminalNode}

abstract class ObjC2SwiftBaseConverter extends ObjCBaseVisitor[String] {
  def getResult(): String

  private val visited = new ParseTreeProperty[Boolean]
  protected def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)
  protected def setVisited(node: ParseTree) = visited.put(node, true)

  override def defaultResult(): String = ""

  override def visit(tree: ParseTree): String = {
    setVisited(tree)
    super.visit(tree)
  }

  def visitOption[T <: ParseTree](optionNode: Option[ParseTree]): String =
    optionNode.map(visit).getOrElse(defaultResult())

  def visitOptionAs[T <: ParseTree](optionNode: Option[T])(pf: PartialFunction[T, String]): String =
    optionNode.collect(pf).getOrElse(defaultResult())

  def visitList[T <: ParseTree](nodes: List[T]): String =
    visitList(nodes, " ")

  def visitList[T <: ParseTree](nodes: List[T], glue: String): String =
    nodes.map(visit).filter(_.nonEmpty).mkString(glue)

  def visitListAs[T <: ParseTree](nodes: List[T])(pf: PartialFunction[T, String]): String =
    visitListAs(nodes, " ")(pf)

  def visitListAs[T <: ParseTree](nodes: List[T], glue: String)(pf: PartialFunction[T, String]): String =
    nodes.collect(pf).filter(_.nonEmpty).mkString(glue)

  override def visitChildren(node: RuleNode): String = visitChildren(node, " ")

  def visitChildren(node: RuleNode, glue: String): String =
    visitList(Range(0, node.getChildCount).toList.map(node.getChild), glue)

  def visitChildrenAs(node: RuleNode)(pf: PartialFunction[ParseTree, String]): String =
    visitChildrenAs(node, " ")(pf)

  def visitChildrenAs(node: RuleNode, glue: String)(pf: PartialFunction[ParseTree, String]): String =
    visitListAs(Range(0, node.getChildCount).toList.map(node.getChild), glue)(pf)

  protected val indentString = " " * 4
  protected def indent(source: String): String =
    source.split("\n").map(indentString + _).mkString("\n")


  protected object Token {
    def unapply(node: TerminalNode): Option[Int] = Option(node.getSymbol.getType)
  }

  protected object TokenString {
    def unapply(node: TerminalNode): Option[(Int, String)] = Option(node.getSymbol).map(s => (s.getType, s.getText))
  }
}