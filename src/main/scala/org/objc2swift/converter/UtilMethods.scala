package org.objc2swift.converter

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import org.objc2swift.ObjCParser._

/**
 * Created by takesano on 15/11/16.
 */
trait UtilMethods {
  this: ObjC2SwiftConverter =>

  /*
   * Visited Flag
   */
  private val visited = new ParseTreeProperty[Boolean]

  def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)
  def setVisited(node: ParseTree) = visited.put(node, true)

  /*
   * Indent
   */
  protected val indentString = " " * 4

  def indentLevel(node: ParserRuleContext): Int = {
    def parents =
      Stream.from(0)
        .scanLeft(node.parent) { (list, _) => list.parent }
        .takeWhile(_ != null)
    parents.count {
      case _: External_declarationContext => true
      case _: Compound_statementContext   => true
      case _ => false
    }
  }

  def indent(node: ParserRuleContext): String = indentString * indentLevel(node)

  /*
   * Concat output string
   */
  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = (0 until node.getChildCount).map(node.getChild)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String =
    nodes.view.map(visit).filter(_ != null).filter(_.nonEmpty).mkString(glue)
}
