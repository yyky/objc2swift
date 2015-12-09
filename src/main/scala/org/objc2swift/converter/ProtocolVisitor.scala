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

trait ProtocolVisitor {
  this: ObjC2SwiftBaseConverter =>

  /**
   * Returns translated text of protocolDeclaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolDeclaration(ctx: ProtocolDeclarationContext): String = {

    val head = List(
      ctx.protocolName.toOption.map(visit).map{s => s"protocol $s"},
      ctx.protocolReferenceList.toOption.map(visit).map{s => s": $s"}
    ).flatten.mkString("")

    // TODO: support @optional annotation.
    val body = ctx.interfaceDeclarationList.toList.map(visit).mkString("\n")

    s"$head {\n$body\n}"
  }

  /**
   * Returns translated text of protocolReferenceList context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolReferenceList(ctx: ProtocolReferenceListContext): String =
    visit(ctx.protocolList)

  /**
   * Returns translated text of protocolList context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolList(ctx: ProtocolListContext): String =
    ctx.protocolName.map(visit).mkString(", ")

  /**
   * Returns translated text of protocolName context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolName(ctx: ProtocolNameContext): String = ctx.getText

  /**
   * Returns translated text of protocolDeclarationList context.
   *
   * NOTE: Forward declaration is not needed on swift.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolDeclarationList(ctx: ProtocolDeclarationListContext): String = ""

}
