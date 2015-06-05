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

import org.objc2swift.ObjCParser._
import org.antlr.v4.runtime.tree.TerminalNode
import scala.collection.JavaConversions._

trait ProtocolVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  object ProtocolList {
    def unapply(o: Option[Protocol_reference_listContext]): Option[String] =
      o match {
        case Some(c) => Option(visit(c))
        case None => None
      }
  }

  object OptionalAnnotation {
    def unapply(node: TerminalNode): Option[Boolean] =
      node.getSymbol.getText match {
        case "@optional" => Some(true)
        case "@required" => Some(false)
        case _ => None
      }
  }

  /**
   * Returns translated text of protocol_declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocol_declaration(ctx: Protocol_declarationContext): String = {
    val builder = List.newBuilder[String]

    Option(ctx.protocol_reference_list()) match {
      case ProtocolList(a) => builder += s"protocol ${visit(ctx.protocol_name)}: $a {\n"
      case _               => builder += s"protocol ${visit(ctx.protocol_name)} {\n"
    }

    // Support Optional Annotation
    isOptionalProtocol = false

    ctx.children.foreach {
      case OptionalAnnotation(b) => isOptionalProtocol = b
      case c: Interface_declaration_listContext => builder += s"${visit(c)}\n"
      case _ =>
    }

    builder += "}"

    builder.result().mkString
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
