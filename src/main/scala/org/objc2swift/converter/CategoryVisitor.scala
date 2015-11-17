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

import org.objc2swift.converter.ObjCParser._
import org.objc2swift.util.antlr._
import scala.collection.JavaConversions._

protected trait CategoryVisitor {
  this: ObjC2SwiftConverter =>

  override def visitCategory_name(ctx: Category_nameContext) = ctx.getText

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    // TODO: convert unnamed-category members as private.
    if(ctx.category_name == null) {
      return ""
    }

    val head = List(
      ctx.class_name.toOption.map(visit).map{s => s"extension $s"},
      ctx.protocol_reference_list.toOption.map(visit).map{s => s": $s"}
    ).flatten.mkString("")

    val body = List(
      ctx.interface_declaration_list.toOption.map(visit),
      ctx.correspondingCategoryImplementation(root).map(visit)
    ).flatten.mkString("\n\n")

    s"$head {\n$body\n}"
  }

  // ignore category implementation with no corresponding interface.
  override def visitCategory_implementation(ctx: Category_implementationContext): String = ""
}
