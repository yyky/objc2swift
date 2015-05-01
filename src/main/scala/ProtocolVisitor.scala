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
import collection.JavaConversions._

trait ProtocolVisitor extends Converter {

  object ProtocolList {
    def unapply(o: Option[Protocol_reference_listContext]): Option[String] =
      o match {
        case Some(c) => Option(visit(c))
        case None => None
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

    Option(ctx.interface_declaration_list()) match {
      case Some(list) => sb.append(list.map(visit).mkString("\n") + "\n")
      case None =>
    }

    sb.append("}")

    sb.toString()
  }


  override def visitProtocol_reference_list(ctx: Protocol_reference_listContext) = visit(ctx.protocol_list)

  override def visitProtocol_list(ctx: Protocol_listContext): String =
    ctx.protocol_name.map(visit).mkString(", ")

  override def visitProtocol_name(ctx: Protocol_nameContext): String = ctx.getText

  // TODO: Forward declaration
  override def visitProtocol_declaration_list(ctx: Protocol_declaration_listContext) = ""
}
