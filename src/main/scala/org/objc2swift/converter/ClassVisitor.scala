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

trait ClassVisitor {
  this: ObjC2SwiftBaseConverter with RootVisitor =>

  override def visitClassName(ctx: ClassNameContext): String = ctx.getText

  override def visitSuperclassName(ctx: SuperclassNameContext): String = ctx.getText

  override def visitClassInterface(ctx: ClassInterfaceContext): String = {
    val head = List(
      ctx.className().map(visit).map { s => s"class $s" },
      ctx.superclassName().map(visit).map { s => s": $s" },
      ctx.protocolReferenceList().map(visit).map { s => s", $s"}
    ).flatten.mkString("")

    val body = List(
      ctx.interfaceDeclarationList().map(visit),
      ctx.correspondingClassImplementation(root).flatMap(_.implementationDefinitionList).map(visit)
    ).flatten.mkString("\n")

    s"""
       |$head {
       |${indent(body)}
       |}
     """.stripMargin
  }

  override def visitInterfaceDeclarationList(ctx: InterfaceDeclarationListContext): String =
    visitChildren(ctx, "\n\n")

  override def visitImplementationDefinitionList(ctx: ImplementationDefinitionListContext): String =
    visitChildren(ctx, "\n\n")

  // ignore implementation with no corresponding interface.
  override def visitClassImplementation(ctx: ClassImplementationContext): String = ""

  override def visitCategoryName(ctx: CategoryNameContext) = ctx.getText

  override def visitCategoryInterface(ctx: CategoryInterfaceContext): String = {
    // TODO: convert unnamed-category members as private.
    if(ctx.categoryName == null) {
      return ""
    }

    val head = List(
      ctx.className().map(visit).map{s => s"extension $s"},
      ctx.protocolReferenceList().map(visit).map{s => s": $s"}
    ).flatten.mkString("")

    val body = List(
      ctx.interfaceDeclarationList().map(visit),
      ctx.correspondingCategoryImplementation(root).map(visit)
    ).flatten.mkString("\n\n")

    s"""
       |$head {
       |${indent(body)}
       |}
     """.stripMargin
  }

  // ignore category implementation with no corresponding interface.
  override def visitCategoryImplementation(ctx: CategoryImplementationContext): String = ""
}
