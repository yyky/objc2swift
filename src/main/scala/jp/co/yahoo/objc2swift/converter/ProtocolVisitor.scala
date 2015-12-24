/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package jp.co.yahoo.objc2swift.converter

import jp.co.yahoo.objc2swift.converter.ObjCParser._

trait ProtocolVisitor {
  this: ObjC2SwiftBaseConverter =>

  /**
   * protocol_declaration:
   *   '@protocol' ( protocol_name ( protocol_reference_list )?
   *     (interface_declaration_list | '@optional' | '@required')*
   *   )
   *   '@end';
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolDeclaration(ctx: ProtocolDeclarationContext): String = {

    val head =
      s"protocol ${visitOption(ctx.protocolName())}" +
      ctx.protocolReferenceList().map {": " + visit(_)}.mkString

    var optional = false
    val body = visitChildrenAs(ctx, "\n") {
      case c: InterfaceDeclarationListContext =>
        if(optional)
          visit(c)
            .split("\n")
            .map(s => if(s.nonEmpty) s"optional $s" else s)
            .mkString("\n")
        else
          visit(c)
      case Token(OPTIONAL) =>
        optional = true
        ""
      case TokenString(_, "@required") => // TODO add new token
        optional = false
        ""
    }

    s"""$head {
       |${indent(body)}
       |}""".stripMargin
  }

  /**
   * protocol_reference_list:
   *   ('<' protocol_list '>');
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolReferenceList(ctx: ProtocolReferenceListContext): String =
    visitChildren(ctx)

  /**
   * protocol_list:
   *   protocol_name (',' protocol_name)*;
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolList(ctx: ProtocolListContext): String =
    visitList(ctx.protocolName(), ", ")

  /**
   * protocol_name:
   *   IDENTIFIER;
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolName(ctx: ProtocolNameContext): String =
    ctx.getText

  /**
   * protocol_declaration_list:
   *   ('@protocol' protocol_list';') ;
   *
   * MEMO: Forward declaration is not needed on swift.
   *
   * @param ctx the parse tree
   **/
  override def visitProtocolDeclarationList(ctx: ProtocolDeclarationListContext): String =
    ""

}
