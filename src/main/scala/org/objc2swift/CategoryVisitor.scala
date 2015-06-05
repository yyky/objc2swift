/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift

import org.objc2swift.ObjCParser._

trait CategoryVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  override def visitCategory_name(ctx: Category_nameContext) = ctx.getText

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    // ignore class-extension (unnamed-category).
    if(ctx.category_name == null) {
      return ""
    }

    val sb = new StringBuilder()

    // extension [CLASS-NAME]
    sb.append("extension " + visit(ctx.class_name))
    Option(ctx.protocol_reference_list) match {
      case Some(c) => sb.append(", " + visit(c))
      case None =>
    }

    sb.append(" {\n")
    Option(ctx.interface_declaration_list) match {
      case Some(c) => sb.append(visit(c) + "\n\n")
      case None =>
    }

    findCorrespondingCategoryImplementation(ctx) match {
      case Some(c) => sb.append(visit(c.implementation_definition_list()) + "\n")
      case None =>
    }

    sb.append("}")

    sb.toString()
  }

  // ignore category implementation with no corresponding interface.
  override def visitCategory_implementation(ctx: Category_implementationContext): String = ""
}
