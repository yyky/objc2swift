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

import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty, TerminalNode}
import org.antlr.v4.runtime.{ParserRuleContext, RuleContext}
import org.objc2swift.converter.ObjCParser._
import org.objc2swift.util.antlr._

import scala.collection.JavaConversions._

protected trait ProtocolVisitor {
  this: ObjC2SwiftConverter =>

  private val usSetters = new ParseTreeProperty[Boolean]()

  def isUSSetter(node: ParseTree) =
    Option(usSetters.get(node)).filter(identity).nonEmpty

  def setUSSetter(node: ParseTree) =
    usSetters.put(node, true)

  /**
   * Returns translated text of protocol_declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_declaration(ctx: Protocol_declarationContext): String = {

    val head = List(
      ctx.protocol_name.toOption.map(visit).map{s => s"protocol $s"},
      ctx.protocol_reference_list.toOption.map(visit).map{s => s": $s"}
    ).flatten.mkString("")

    // TODO: support @optional annotation.
    val body = ctx.interface_declaration_list.toList.map(visit).mkString("\n")

    s"$head {\n$body\n}"
  }

  /**
   * Returns translated text of protocol_reference_list context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_reference_list(ctx: Protocol_reference_listContext): String =
    visit(ctx.protocol_list)

  /**
   * Returns translated text of protocol_list context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_list(ctx: Protocol_listContext): String =
    ctx.protocol_name.map(visit).mkString(", ")

  /**
   * Returns translated text of protocol_name context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_name(ctx: Protocol_nameContext): String = ctx.getText

  /**
   * Returns translated text of protocol_declaration_list context.
   *
   * NOTE: Forward declaration is not needed on swift.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_declaration_list(ctx: Protocol_declaration_listContext): String = ""

}
