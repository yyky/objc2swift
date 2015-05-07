/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import ObjCParser._
import org.antlr.v4.runtime.tree.TerminalNode
import collection.JavaConversions._

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

  override def visitProtocol_declaration(ctx: Protocol_declarationContext): String = {
    val sb = new StringBuilder()

    sb.append("protocol")

    val name = visit(ctx.protocol_name())
    sb.append(" " + name + " ")

    Option(ctx.protocol_reference_list()) match {
      case ProtocolList(p) => sb.append(": " + p + " ")
      case _ =>
    }

    sb.append("{\n")

    // Support Optional Annotation
    isOptionalProtocol = false
    ctx.children.foreach {
      case OptionalAnnotation(bool) => isOptionalProtocol = bool
      case list: Interface_declaration_listContext => sb.append(visit(list) + "\n")
      case _ =>
    }

    sb.append("}")

    sb.toString()
  }

  override def visitProtocol_reference_list(ctx: Protocol_reference_listContext) =
    visit(ctx.protocol_list)

  override def visitProtocol_list(ctx: Protocol_listContext): String =
    ctx.protocol_name.map(visit).mkString(", ")

  override def visitProtocol_name(ctx: Protocol_nameContext): String = ctx.getText

  // Forward declaration. No need on swift.
  override def visitProtocol_declaration_list(ctx: Protocol_declaration_listContext) = ""

}
