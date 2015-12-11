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

trait ClassVisitor {
  this: ObjC2SwiftBaseConverter with RootVisitor =>

  /**
   * class_name: IDENTIFIER;
   *
   * @param ctx
   * @return
   */
  override def visitClassName(ctx: ClassNameContext): String = ctx.getText

  /**
   * superclass_name: IDENTIFIER;
   *
   * @param ctx
   * @return
   */
  override def visitSuperclassName(ctx: SuperclassNameContext): String = ctx.getText

  /**
   * class_interface:
	 *   '@interface'
   *   class_name (':' superclass_name)?
   *   protocol_reference_list?
   *   instance_variables?
   *   interface_declaration_list?
   *   '@end';
   *
   * @param ctx
   * @return
   */
  override def visitClassInterface(ctx: ClassInterfaceContext): String = {
    val head = s"class ${visit(ctx.className())}" + List(
      ctx.superclassName().map(c => s": ${visit(c)}"),
      ctx.protocolReferenceList().map(c => s", ${visit(c)}")
    ).flatten.mkString

    val body = List(
      ctx.interfaceDeclarationList().map(visit),
      for {
        classImpl <- findClassImplementation(ctx)
        implDefList <- classImpl.implementationDefinitionList()
      } yield visit(implDefList)
    ).flatten.mkString("\n")

    s"""
       |$head {
       |${indent(body)}
       |}
     """.stripMargin
  }

  /**
   * interface_declaration_list:
	 *   (declaration | class_method_declaration | instance_method_declaration | property_declaration)+
	 *   ;
   *
   * @param ctx
   * @return
   */
  override def visitInterfaceDeclarationList(ctx: InterfaceDeclarationListContext): String =
    visitChildrenAs(ctx, "\n\n") {
      case c if !isVisited(c) => visit(c)
    }

  /**
   * implementation_definition_list:
   *   ( function_definition
   *   | declaration
   *   | class_method_definition
   *   | instance_method_definition
   *   | property_implementation
   *   )+
   * ;
   *
   * @param ctx
   * @return
   */
  override def visitImplementationDefinitionList(ctx: ImplementationDefinitionListContext): String =
    visitChildrenAs(ctx, "\n\n") {
      case c if !isVisited(c) => visit(c)
    }


  /**
   * MEMO: ignore implementation with no corresponding interface.
   *
   * class_implementation:
   *   '@implementation'
   *   (
   *   class_name ( ':' superclass_name )?
   *   instance_variables?
   *   ( implementation_definition_list )?
   *   )
   *   '@end';
   *
   * @param ctx
   * @return
   */
  override def visitClassImplementation(ctx: ClassImplementationContext): String = ""

  /**
   * category_name:
	 *   IDENTIFIER;
   *
   * @param ctx
   * @return
   */
  override def visitCategoryName(ctx: CategoryNameContext) = ctx.getText

  /**
   * category_interface:
	 *   '@interface'
   *   class_name '(' category_name? ')'
   *   protocol_reference_list?
   *   instance_variables?
   *   interface_declaration_list?
   *   '@end';
   *
   * @param ctx
   * @return
   */
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
      findCategoryImplementation(ctx).map(visit)
    ).flatten.mkString("\n\n")

    s"""
       |$head {
       |${indent(body)}
       |}
     """.stripMargin
  }

  /**
   * MEMO: ignore category implementation with no corresponding interface.
   *
   * category_implementation:
	 *   '@implementation'(
   *   class_name '(' category_name ')'
   *   ( implementation_definition_list )?
   *   )'@end';
   *
   * @param ctx
   * @return
   */
  override def visitCategoryImplementation(ctx: CategoryImplementationContext): String = ""

  /**
   * finds the corresponding class implementation with the same class name.
   *
   * @param ctx the interface context
   * @return Some implementation context when found, else None.
   */
  protected def findClassImplementation(ctx: ClassInterfaceContext): Option[ClassImplementationContext] = {
    val className = ctx.className().get.getText

    {
      for {
        extDclCtx <- root.externalDeclaration().toStream
        implCtx <- extDclCtx.classImplementation()
        if implCtx.className().get.getText == className
      } yield implCtx
    }.headOption
  }

  /**
   * finds the corresponding class implementation with the same class name.
   *
   * @param ctx the interface context
   * @return Some implementation context when found, else None.
   */
  protected def findCategoryImplementation(ctx: CategoryInterfaceContext): Option[CategoryImplementationContext] = {
    val className = ctx.className().get.getText
    val categoryName = ctx.categoryName().get.getText

    {
      for {
        extDclCtx <- root.externalDeclaration().toStream
        implCtx <- extDclCtx.categoryImplementation()
        if implCtx.className().get.getText == className
        if implCtx.categoryName().get.getText == categoryName
      } yield implCtx
    }.headOption
  }
}
