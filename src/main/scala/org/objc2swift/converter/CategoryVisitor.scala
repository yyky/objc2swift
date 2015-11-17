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
import scala.collection.JavaConversions._

protected trait CategoryVisitor {
  this: ObjC2SwiftConverter =>

  override def visitCategory_name(ctx: Category_nameContext) = ctx.getText

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    // ignore class-extension (unnamed-category).
    if(ctx.category_name == null) {
      return ""
    }

    val sb = new StringBuilder()

    // extension [CLASS-NAME]
    sb.append("extension " + visit(ctx.class_name))
    Option(ctx.protocol_reference_list).foreach { c =>
      sb.append(", " + visit(c))
    }

    sb.append(" {\n")
    Option(ctx.interface_declaration_list).foreach { c =>
      sb.append(visit(c) + "\n\n")
    }

    findCorrespondingCategoryImplementation(ctx).foreach { c =>
      sb.append(visit(c.implementation_definition_list()) + "\n")
    }

    sb.append("}")

    sb.toString()
  }

  // ignore category implementation with no corresponding interface.
  override def visitCategory_implementation(ctx: Category_implementationContext): String = ""

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext] = {
    val className = catCtx.class_name.getText
    val categoryName = catCtx.category_name.getText

    {
      for {
        extDclCtx <- root.external_declaration.toStream
        implCtx <- Option(extDclCtx.category_implementation())
        if implCtx.class_name.getText == className
        if implCtx.category_name.getText == categoryName
      } yield implCtx
    }.headOption
  }
}
