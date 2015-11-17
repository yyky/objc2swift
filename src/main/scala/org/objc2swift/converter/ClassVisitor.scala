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

import org.objc2swift.util.antlr._
import org.objc2swift.converter.ObjCParser._
import scala.collection.JavaConversions._

protected trait ClassVisitor {
  this: ObjC2SwiftConverter =>

  override def visitClass_name(ctx: Class_nameContext): String = ctx.getText

  override def visitSuperclass_name(ctx: Superclass_nameContext): String = ctx.getText

  override def visitClass_interface(ctx: Class_interfaceContext): String = {
    val head = List(
      ctx.class_name.toOption.map(visit).map { s => s"class $s" },
      ctx.superclass_name.toOption.map(visit).map { s => s": $s" },
      ctx.protocol_reference_list.toOption.map(visit).map { s => s", $s"}
    ).flatten.mkString("")

    val body = List(
      ctx.interface_declaration_list.toOption.map(visit),
      findCorrespondingClassImplementation(ctx).flatMap(_.implementation_definition_list.toOption).map(visit)
    ).flatten.mkString("\n")

    s"${head} {\n${body}\n}"
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext): String =
    concatChildResults(ctx, "\n\n")

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext): String =
    concatChildResults(ctx, "\n\n")

  // ignore implementation with no corresponding interface.
  override def visitClass_implementation(ctx: Class_implementationContext): String = ""

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext] = {
    val className = classCtx.class_name.getText

    {
      for {
        extDclCtx <- root.external_declaration.toStream
        implCtx <- Option(extDclCtx.class_implementation())
        if implCtx.class_name.getText == className
      } yield implCtx
    }.headOption
  }
}
