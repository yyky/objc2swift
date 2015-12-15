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

import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.tree.ParseTreeProperty
import org.objc2swift.converter.ObjCParser._
import org.objc2swift.converter.util.Token

import scala.collection.JavaConversions._

trait EnumVisitor {
  this: ObjC2SwiftBaseConverter =>

  /**
   * enum_specifier:
   *   'enum' (IDENTIFIER? ':' type_name)?
   *     ( identifier ('{' enumerator_list '}')?
   *     | '{' enumerator_list '}')
   *     | 'NS_OPTIONS' '(' type_name ',' identifier ')' '{' enumerator_list '}'
   *     | 'NS_ENUM' '(' type_name ',' identifier ')' '{' enumerator_list '}' ;
   *
   * @param ctx
   * @return
   */
  override def visitEnumSpecifier(ctx: EnumSpecifierContext): String =
    s"""enum ${enumIdentifier(ctx)} : ${enumType(ctx)} {
       |${indent(visit(ctx.enumeratorList()))}
       |}""".stripMargin


  /**
   * enumerator_list:
   *   enumerator (',' enumerator)* ','? ;
   *
   * @param ctx
   * @return
   */
  override def visitEnumeratorList(ctx: EnumeratorListContext): String =
    visitChildren(ctx, "\n")

  /**
   * enumerator:
   *   identifier ('=' constant_expression)?;
   *
   * @param ctx
   * @return
   */
  override def visitEnumerator(ctx: EnumeratorContext): String =
    "case " + visitChildrenAs(ctx) {
      case c: IdentifierContext => enumCaseIdentifier(c)
      case Token(ASSIGN) => "="
      case c: ConstantExpressionContext => visit(c)
    }

  private def enumIdentifier(ctx: EnumSpecifierContext): String = {
    ctx.identifier() match {
      case Some(c: IdentifierContext) => visit(c)

      // MEMO case: typedef enum{ ... } identifier;
      case None =>
        // declaration_specifiers > type_specifier > enum_specifier
        Option(ctx.parent.parent) flatMap {
          case c: DeclarationSpecifiersContext =>
            for {
              typeSpec <- c.typeSpecifier().lastOption
              className <- typeSpec.className()
            } yield visit(className)
          case _ => None
        } getOrElse defaultResult()
    }
  }

  private def enumType(ctx: EnumSpecifierContext): String =
    ctx.typeName().map(visit) getOrElse "Int"

  private def enumCaseIdentifier(ctx: IdentifierContext): String = {
    ctx.parent.parent.parent match {
      case e: EnumSpecifierContext =>
        val origId = visit(ctx)
        val enumId = enumIdentifier(e)
        val strippedId = origId.stripPrefix(enumId)

        if(strippedId.matches("[0-9].*"))
          "_" + strippedId
        else
          strippedId

      case _ =>
        defaultResult()
    }
  }
}
