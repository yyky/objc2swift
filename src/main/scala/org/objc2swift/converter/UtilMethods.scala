package org.objc2swift.converter

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import org.objc2swift.converter.ObjCParser._

/**
 * Created by takesano on 15/11/16.
 */
trait UtilMethods {
  this: ObjC2SwiftConverter =>

  protected val indentString = " " * 4

  def indentLevel(node: ParserRuleContext): Int = {
    def parents =
      Stream.from(0)
        .scanLeft(node.parent) { (list, _) => list.parent }
        .takeWhile(_ != null)
    parents.count {
      case _: ExternalDeclarationContext => true
      case _: CompoundStatementContext   => true
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
