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

import org.antlr.v4.runtime.tree.{TerminalNode, RuleNode, ParseTreeProperty, ParseTree}

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

  def visit(optionNode: Option[ParseTree]): String =
    optionNode.map(visit).getOrElse("")

  def visitList(nodes: List[ParseTree]): String =
    visitList(nodes, " ")

  def visitList(nodes: List[ParseTree], glue: String): String =
    nodes.map(visit).filter(_.nonEmpty).mkString(glue)

  def visitListAs(nodes: List[ParseTree])(pf: PartialFunction[ParseTree, String]): String =
    visitListAs(nodes, " ")(pf)

  def visitListAs(nodes: List[ParseTree], glue: String)(pf: PartialFunction[ParseTree, String]): String =
    nodes.collect(pf).filter(_.nonEmpty).mkString(glue)

  override def visitChildren(node: RuleNode): String = visitChildren(node, " ")

  def visitChildren(node: RuleNode, glue: String): String =
    visitList(Range(0, node.getChildCount).toList.map(node.getChild(_)), glue)

  def visitChildrenAs(node: RuleNode)(pf: PartialFunction[ParseTree, String]): String =
    visitChildrenAs(node, " ")(pf)

  def visitChildrenAs(node: RuleNode, glue: String)(pf: PartialFunction[ParseTree, String]): String =
    visitListAs(Range(0, node.getChildCount).toList.map(node.getChild(_)), glue)(pf)

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