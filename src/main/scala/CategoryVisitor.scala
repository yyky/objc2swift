/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import ObjCParser._
import collection.JavaConversions._

trait CategoryVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext] = {
    val className = catCtx.class_name.getText
    val categoryName = catCtx.category_name.getText

    for(extDclCtx <- root.external_declaration) {
      Option(extDclCtx.category_implementation) match {
        case Some(implCtx) =>
          (implCtx.class_name.getText, implCtx.category_name.getText) match {
            case (`className`, `categoryName`) => return Some(implCtx)
            case _ =>
          }
        case None =>
      }
    }
    None
  }

  override def visitCategory_name(ctx: Category_nameContext) = ctx.getText

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
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
      case Some(c) => sb.append(visit(c) + "\n")
      case None =>
    }

    sb.append("}")

    sb.toString()
  }

  override def visitCategory_implementation(ctx: Category_implementationContext): String = {
    visit(ctx.implementation_definition_list)
  }
}
