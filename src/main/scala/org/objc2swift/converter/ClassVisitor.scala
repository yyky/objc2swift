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

import org.antlr.v4.runtime.ParserRuleContext
import org.objc2swift.converter.ObjCParser._

trait ClassVisitor {
  this: ObjC2SwiftBaseConverter with RootVisitor =>

  /**
   * interface_declaration_list:
   *   (declaration | class_method_declaration | instance_method_declaration | property_declaration)+
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitInterfaceDeclarationList(ctx: InterfaceDeclarationListContext): String =
    visitChildrenAs(ctx, "\n") {
      case c if !isVisited(c) =>
        visit(c) match {
          case r if r.lines.size > 1 => r + "\n"
          case r => r
        }
    }

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
    val head = classDeclarationHead(ctx.className(), ctx.superclassName(), ctx.protocolReferenceList())
    val body = {
      val extCatOpt = findClassExtensionCategoryInterface(ctx)
      val implOpt = findClassImplementation(ctx)

      List(
        // ivars in interface
        ctx.instanceVariables().map(visit),

        // ivars in class extension
        for {
          extCat <- extCatOpt
          insVar <- extCat.instanceVariables()
        } yield toPrivate(visit(insVar)),

        // properties in class extension
        for {
          extCat <- extCatOpt
          intf <- extCat.interfaceDeclarationList()
          props = intf.propertyDeclaration()
        } yield toPrivate(visitList(props, "\n")),

        // properties in implementation
        for {
          impl <- implOpt
          insVar <- impl.instanceVariables()
        } yield toPrivate(visit(insVar)),

        // declarations in interface
        ctx.interfaceDeclarationList().map(visit),

       // declarations in implementation
        for {
          impl <- implOpt
          implDefList <- impl.implementationDefinitionList()
        } yield visit(implDefList)

      ).flatten.mkString("\n\n")
    }

    s"""$head {
       |${indent(body)}
       |}""".stripMargin
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
    visitChildrenAs(ctx, "\n") {
      case c if !isVisited(c) =>
        visit(c) match {
          case r if r.lines.size > 1 => r + "\n"
          case r => r
        }
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
    val head = classDeclarationHead(ctx.className(), None, ctx.protocolReferenceList(), isExtension = true)
    if(ctx.categoryName().isEmpty) {
      if(ctx.protocolReferenceList().nonEmpty) {
        s"private $head {\n}"
      } else
        ""
    } else {
      val body = List(
        ctx.interfaceDeclarationList().map(visit),
        findCategoryImplementation(ctx).map(visit)
      ).flatten.mkString("\n\n")

      s"""$head {
         |${indent(body)}
         |}""".stripMargin
    }
  }

  private def classDeclarationHead(className: Option[ClassNameContext], superclassName: Option[SuperclassNameContext], protocolReferenceList: Option[ProtocolReferenceListContext], isExtension: Boolean = false): String = {
    (if(!isExtension) "class " else "extension ") + List(
      className.map(visit),
      superclassName.map(c => s": ${visit(c)}"),
      protocolReferenceList.map{ (if(superclassName.isEmpty) ": " else ", ") + visit(_) }
    ).flatten.mkString
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
   * category_name:
   *   IDENTIFIER;
   *
   * @param ctx
   * @return
   */
  override def visitCategoryName(ctx: CategoryNameContext) = ctx.getText


  /**
   * instance_variables
   *   : '{' struct_declaration* '}'
   *   |   '{' visibility_specification struct_declaration+ '}'
   *   |   '{' struct_declaration+ instance_variables '}'
   *   |   '{' visibility_specification struct_declaration+ instance_variables '}'
   *   ;
   */
  override def visitInstanceVariables(ctx: InstanceVariablesContext): String = {
     visitList(ctx.structDeclaration(), "\n")
  }

  /**
   * finds the corresponding class implementation with the same class name.
   *
   * @param ctx the interface context
   * @return Some implementation context when found, else None.
   */
  protected def findClassImplementation(ctx: ClassInterfaceContext): Option[ClassImplementationContext] = {
    if(root == null)
      return None

    val className = visit(ctx.className())
    for {
      extDclCtx <- root.externalDeclaration().toStream
      implCtx <- extDclCtx.classImplementation()
      if visit(implCtx.className()) == className
    } yield implCtx
  }.headOption


  /**
   * finds the corresponding class implementation with the same class name.
   *
   * @param ctx the interface context
   * @return Some implementation context when found, else None.
   */
  protected def findClassExtensionCategoryInterface(ctx: ClassInterfaceContext): Option[CategoryInterfaceContext] = {
    if(root == null)
      return None

    val className = visit(ctx.className())

    for {
      extDclCtx <- root.externalDeclaration().toStream
      implCtx <- extDclCtx.categoryInterface()
      if visit(implCtx.className()) == className && implCtx.categoryName().isEmpty
    } yield implCtx
  }.headOption



  /**
   * finds the corresponding class implementation with the same class name.
   *
   * @param ctx the interface context
   * @return Some implementation context when found, else None.
   */
  protected def findCategoryImplementation(ctx: CategoryInterfaceContext): Option[CategoryImplementationContext] = {
    if(root == null)
      return None

    val className = visit(ctx.className())
    val categoryName = visit(ctx.categoryName())

    for {
      extDclCtx <- root.externalDeclaration().toStream
      implCtx <- extDclCtx.categoryImplementation()
      if visit(implCtx.className()) == className &&
         visit(implCtx.categoryName()) == categoryName
    } yield implCtx
  }.headOption


  protected def currentClassName(ctx: ParserRuleContext): Option[String] =
    Stream.from(0)
      .scanLeft(ctx.parent) { (list, _) => list.parent }
      .takeWhile(_ != null)
      .collectFirst {
        case c: ClassInterfaceContext => visit(c.className())
        case c: ClassImplementationContext => visit(c.className())
        case c: CategoryInterfaceContext => visit(c.className())
        case c: CategoryImplementationContext => visit(c.className())
      }

  private def toPrivate(result: String): String =
    result.replaceAll("(?m)(^@IBOutlet |^)", "$1private ")

}
