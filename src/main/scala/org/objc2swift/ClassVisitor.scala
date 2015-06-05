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

protected trait ClassVisitor extends BaseConverter {
  override def visitClass_name(ctx: Class_nameContext): String = ctx.getText

  override def visitSuperclass_name(ctx: Superclass_nameContext): String = ctx.getText

  override def visitClass_interface(ctx: Class_interfaceContext): String = {
    val builder = List.newBuilder[String]

    // class [CLASS-NAME] : [SUPERCLASS], [PROTOCOL1, PROTOCOL2, ...]
    builder += s"class ${visit(ctx.class_name())}"
    builder += Option(ctx.superclass_name()).map(c => s": ${visit(c)}").getOrElse("")
    builder += Option(ctx.protocol_reference_list()).map(c => s", ${visit(c)}").getOrElse("")

    // TODO merge class-ext (aka unnamed-category)

    // implementation of class
    builder += " {\n\n"

    // TODO collect instance-vars from @intf, @impl and class-ext

    // TODO only insert \n\n in between method blocks.
    builder += Option(ctx.interface_declaration_list()).map(c => s"${visit(c)}\n\n").getOrElse("")

    builder += (for {
      clsImpl <- findCorrespondingClassImplementation(ctx)
      dfs <- Option(clsImpl.implementation_definition_list())
    } yield s"${visit(dfs)}\n").getOrElse("")

    builder += "\n}"

    builder.result().mkString
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext): String =
    concatChildResults(ctx, "\n\n")

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext): String =
    concatChildResults(ctx, "\n\n")

  // ignore implementation with no corresponding interface.
  override def visitClass_implementation(ctx: Class_implementationContext): String = ""
}