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

  override def visitClassName(ctx: ClassNameContext): String = ctx.getText

  override def visitSuperclassName(ctx: SuperclassNameContext): String = ctx.getText

  override def visitClassInterface(ctx: ClassInterfaceContext): String = {
    val head = List(
      ctx.className.toOption.map(visit).map { s => s"class $s" },
      ctx.superclassName.toOption.map(visit).map { s => s": $s" },
      ctx.protocolReferenceList.toOption.map(visit).map { s => s", $s"}
    ).flatten.mkString("")

    val body = List(
      ctx.interfaceDeclarationList.toOption.map(visit),
      ctx.correspondingClassImplementation(root).flatMap(_.implementationDefinitionList.toOption).map(visit)
    ).flatten.mkString("\n")

    s"${head} {\n${body}\n}"
  }

  override def visitInterfaceDeclarationList(ctx: InterfaceDeclarationListContext): String =
    concatChildResults(ctx, "\n\n")

  override def visitImplementationDefinitionList(ctx: ImplementationDefinitionListContext): String =
    concatChildResults(ctx, "\n\n")

  // ignore implementation with no corresponding interface.
  override def visitClassImplementation(ctx: ClassImplementationContext): String = ""
}
