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

trait MethodVisitor extends Converter {

  self: ObjC2SwiftConverter =>

  /**
   * Convert instance method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's instance method code
   **/
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String = {
    val sb = new StringBuilder()

    sb.append(indent(ctx) + "func")

    sb.append(Option(ctx.method_declaration()).map(visit(_)).getOrElse(""))

    sb.toString()
  }

  /**
   * Convert method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's method code
   **/
  override def visitMethod_declaration(ctx: Method_declarationContext): String = {
    val sb = new StringBuilder()

    val method_selector_ctx: Method_selectorContext = ctx.method_selector()

    sb.append(" " + visit(method_selector_ctx))

    //
    // Method type.
    //
    // Currently, supported types are:
    //   void, id(AnyObject), short/int/long, float/double, ...
    //
    // TODO: Support more types
    //
    Option(ctx.method_type()) match {
      case Some(method_type_ctx) => visit(method_type_ctx) match {
        case s if s != "" => sb.append(" -> " + s)
        case _ =>
      }
      case _ => sb.append(" -> AnyObject") // id type
    }

    sb.append(" {\n")

    //
    // TODO: Support class method
    //
    findCorrespondingMethodDefinition(ctx.parent.asInstanceOf[Instance_method_declarationContext]) match {
      case None =>
      case Some(impl) =>
        visited.put(impl, true)
        sb.append(visit(impl.method_definition.compound_statement))
        sb.append("\n")
    }

    sb.append(indent(ctx) + "}\n")

    sb.toString()
  }

}
