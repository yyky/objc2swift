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

import org.antlr.v4.runtime._
import org.objc2swift.converter.ObjCParser._
import scala.collection.JavaConversions._

/**
 * Implements visit methods for expression contexts.
 */
trait BlockVisitor {
  this: ObjC2SwiftBaseConverter
    with UtilMethods =>

  import org.objc2swift.converter.util._

  override def visitBlockExpression(ctx: BlockExpressionContext): String = {
    val blockType = (ctx.blockParameters, ctx.typeSpecifier) match {
      case (null, null) => ""
      case (null, t) =>
        s"() -> ${visit(t)} in"
      case (b, null) =>
        s"${visit(b)} in"
      case (b, t) =>
        s"${visit(b)} -> ${visit(t)} in"
    }

    s"""|{$blockType
        |${visit(ctx.compoundStatement)}
        |${indent(ctx)}}""".stripMargin
  }

  override def visitBlockParameters(ctx: BlockParametersContext): String =
    s"(${ctx.typeVariableDeclarator.map(visit).mkString(", ")})"

  override def visitBlockType(ctx: BlockTypeContext): String = "" // TODO
}
