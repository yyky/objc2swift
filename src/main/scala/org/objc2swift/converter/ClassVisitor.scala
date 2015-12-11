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
    val head = s"class ${visit(ctx.className())}" + List(
      ctx.superclassName().map(c => s": ${visit(c)}"),
      ctx.protocolReferenceList().map(c => s", ${visit(c)}")
    ).flatten.mkString

    val body = List(
      ctx.interfaceDeclarationList().map(visit),
      for {
        classImpl <- ctx.correspondingClassImplementation(root)
        implDefList <- classImpl.implementationDefinitionList()
      } yield visit(implDefList)
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
    if(ctx.categoryName().isEmpty) {
      return ""
    }

    val head = List(
      ctx.className().map( c => s"extension ${visit(c)}" ),
      ctx.protocolReferenceList().map( c => s": ${visit(c)}" )
    ).flatten.mkString

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
