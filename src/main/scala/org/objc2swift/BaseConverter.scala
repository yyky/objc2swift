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

import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import org.antlr.v4.runtime.ParserRuleContext

import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._
import scala.collection.mutable

protected abstract class BaseConverter(parser: ObjCParser) extends ObjCBaseVisitor[String] with UtilObjects {
  protected val root = parser.translation_unit()

  type TSContexts = mutable.Buffer[Type_specifierContext]

  protected val indentString = " " * 4
  private val visited = new ParseTreeProperty[Boolean]
  protected val errors = mutable.Map[Int, (String, String)]()

  def getResult() = visit(root)

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = (0 until node.getChildCount).map(node.getChild)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String =
    nodes.view.map(visit).filter(_ != null).filter(_.nonEmpty).mkString(glue)

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

  def lineError(tree: ParseTree): Option[(String, String)] = tree match {
    case ctx: ParserRuleContext =>
      val line = ctx.getStart.getLine
      if(errors.contains(line)) {
        val error = errors(line)
        errors.remove(line)
        Some(error)
      } else {
        None
      }
    case _ => None
  }

  /**
   * Returns if node was visited or not
   *
   * @param node parse tree
   * @return true if node was visited, otherwise false
   */
  def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)

  def setVisited(node: ParseTree) = visited.put(node, true)

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext]

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext]

  def findCorrespondingMethodDefinition(declCtx: Method_declarationContext): Option[Method_definitionContext]

  def optional(node: ParserRuleContext): String

  def isUSSetter(node: ParseTree): Boolean

  def setUSSetter(node: ParseTree)

  def concatType(types: TSContexts): String // overridden in TypeVisitor
}
