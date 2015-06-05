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

import java.io.{ByteArrayInputStream, InputStream}

import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream, ParserRuleContext, RuleContext}

import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._

protected abstract class BaseConverter(input: InputStream) extends ObjCBaseVisitor[String] with UtilObjects {
  type TSContexts = scala.collection.mutable.Buffer[Type_specifierContext]

  def this(inputString: String) {
    this(new ByteArrayInputStream(inputString.getBytes))
  }

  protected lazy val parser = {
    val lexer = new ObjCLexer(new ANTLRInputStream(input))
    val tokens = new CommonTokenStream(lexer)
    new ObjCParser(tokens)
  }

  protected lazy val root = parser.translation_unit()

  protected val indentString = " " * 4
  private val visited = new ParseTreeProperty[Boolean]()
  protected val errors = collection.mutable.Map[Int, (String, String)]()

  def getResult() = visit(root)

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

  override def visit(tree: ParseTree): String =
    if(!isVisited(tree)) {
      setVisited(tree)

      lineError(tree) match {
        case Some(error) =>
          val ctx = tree.asInstanceOf[ParserRuleContext]
          val (message, source) = error
          s"""
             |${indent(ctx)}// ${message}
             |${indent(ctx)}// ${source}
             |
           """.stripMargin + super.visit(tree)

        case None => super.visit(tree)
      }
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

  override def visitTranslation_unit(ctx: Translation_unitContext): String =
    ctx.external_declaration().map(visit).filter(_ != "").mkString("\n\n")

  override def visitExternal_declaration(ctx: External_declarationContext): String =
    concatChildResults(ctx, "")

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String = ctx.getText

  override def visitSelector(ctx: SelectorContext): String = ctx.getText

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext]

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext]

  def findCorrespondingMethodDefinition(declCtx: Method_declarationContext): Option[Method_definitionContext]

  def optional(node: ParserRuleContext): String

  def isUSSetter(node: ParseTree): Boolean

  def setUSSetter(node: ParseTree)

  def concatType(types: TSContexts): String // overridden in TypeVisitor
}
