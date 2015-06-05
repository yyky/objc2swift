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

import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty, TerminalNode}
import org.antlr.v4.runtime.{ParserRuleContext, RuleContext}

import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._

protected abstract class BaseConverter extends ObjCBaseVisitor[String] {
  type TSContexts = scala.collection.mutable.Buffer[Type_specifierContext]

  object TerminalText {
    def unapply(node: TerminalNode): Option[String] = Option(node.getSymbol.getText)
  }

  object ClassNameText {
    def unapply(node: Class_nameContext): Option[String] = Option(node.getText)
  }

  object ConstantBox {
    def unapply(ctx: Box_expressionContext): Option[ConstantContext] = Option(ctx.constant())
  }

  object ExpressionBox {
    def unapply(ctx: Box_expressionContext): Option[ExpressionContext] = Option(ctx.expression())
  }

  object PostfixExpressionBox {
    def unapply(ctx: Box_expressionContext): Option[Postfix_expressionContext] = Option(ctx.postfix_expression())
  }

  protected val root: Translation_unitContext

  private val visited = new ParseTreeProperty[Boolean]()
  val indentString = " " * 4

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = for(i <- 0 until node.getChildCount) yield node.getChild(i)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String =
    nodes.map(visit).collect{ case s: String if !s.isEmpty => s }.mkString(glue)

  def indentLevel(node: ParserRuleContext): Int = {
    var level = 0
    var ptr: RuleContext = node

    while(ptr.parent != null) {
      ptr match {
        case _: External_declarationContext => level += 1
        case _: Compound_statementContext   => level += 1
        case _ =>
      }
      ptr = ptr.parent
      level
    }
    level
  }

  def indent(node: ParserRuleContext): String = indentString * indentLevel(node)

  override def visit(tree: ParseTree): String = {
    isVisited(tree) match {
      case true => ""
      case false =>
        setVisited(tree)
        super.visit(tree)
    }
  }

  /**
   * Returns if node was visited or not
   *
   * @param node parse tree
   * @return true if node was visited, otherwise false
   */
  def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)

  def setVisited(node: ParseTree) {
    visited.put(node, true)
  }

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext]

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext]

  def findCorrespondingMethodDefinition(declCtx: Method_declarationContext): Option[Method_definitionContext]

  def optional(node: ParserRuleContext): String

  def isUSSetter(node: ParseTree): Boolean

  def setUSSetter(node: ParseTree)

  def concatType(types: TSContexts): String // overridden in TypeVisitor

  override def visitTranslation_unit(ctx: Translation_unitContext): String =
    ctx.external_declaration().map(visit).filter(_ != "").mkString("\n\n")

  override def visitExternal_declaration(ctx: External_declarationContext): String =
    concatChildResults(ctx, "")

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String = ctx.getText

  override def visitSelector(ctx: SelectorContext): String = ctx.getText

}
