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

import org.antlr.v4.runtime._
import jp.co.yahoo.objc2swift.converter.ObjCParser._
import scala.collection.JavaConversions._

trait BlockVisitor {
  this: ObjC2SwiftBaseConverter =>

  import jp.co.yahoo.objc2swift.converter.util._

  /**
   * block_expression:
   *   '^' type_specifier? block_parameters? compound_statement;
   *
   * @param ctx
   * @return
   */
  override def visitBlockExpression(ctx: BlockExpressionContext): String = {
    val voidToNone = {s: String => if(s == "Void") None else Some(s)}
    val params = ctx.blockParameters().map(visit).flatMap(voidToNone)
    val retType = ctx.typeSpecifier().map(visit).flatMap(voidToNone)

    val blockType = (params, retType) match {
      case (Some(p), Some(r)) =>
        s"$p -> $r in"
      case (Some(p), None) =>
        s"$p in"
      case (None, Some(r)) =>
        s"Void -> $r in"
      case _ => ""
    }

    val body = visitOption(ctx.compoundStatement())

    (blockType, body) match {
      case ("", "") =>
        "{}"
      case (t, b) if b.lines.size <= 1 =>
        s"{ ${List(t, b.stripPrefix("return ")).filter(_.nonEmpty).mkString(" ")} }"
      case _ =>
        s"""|{ $blockType
           |${indent(body)}
           |}""".stripMargin
    }
  }

  /**
   * block_parameters:
   *   '(' (type_variable_declarator | type_name | 'void')?
   *       (',' (type_variable_declarator | type_name) )*
   *   ')';
   *
   * @param ctx
   * @return
   */
  override def visitBlockParameters(ctx: BlockParametersContext): String =
    visitChildren(ctx, ", ") match {
      case "Void" | "" => "Void"
      case s => s"($s)"
    }

  /**
   * block_type:
   *   type_specifier '(' '^' type_specifier? ')' block_parameters? ;
   *
   * @param ctx
   * @return
   */
  override def visitBlockType(ctx: BlockTypeContext): String = ctx.typeSpecifier() match {
    case List(returnType, blockName) =>
      "var " + s"${visit(blockName)}: ${visitOption(ctx.blockParameters())} -> ${visit(returnType)}"
    case List(returnType) =>
      val params = visitOption(ctx.blockParameters()).replaceAll("[a-zA-Z0-9]+: ", "") // strip param-name
      s"$params -> ${visit(returnType)}"
    case _ =>
      defaultResult()
  }
}
