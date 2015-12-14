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

import scala.collection.JavaConversions._

/**
 * Implements visit methods for method-contexts.
 */
trait MethodVisitor {
  this: ObjC2SwiftBaseConverter
    with RootVisitor
    with ClassVisitor =>


  /**
   * instance_method_declaration:
   *   ('-' method_declaration);
   *
   * @param ctx
   * @return
   */
  override def visitInstanceMethodDeclaration(ctx: InstanceMethodDeclarationContext): String =
    s"${visit(ctx.methodDeclaration())}"


  /**
   * class_method_declaration:
   *   ('+' method_declaration);
   *
   * @param ctx
   * @return
   */
  override def visitClassMethodDeclaration(ctx: ClassMethodDeclarationContext): String =
    s"class ${visit(ctx.methodDeclaration())}"


  /**
   * method_declaration:
	 *   ( method_type )? method_selector ';' ;
   *
   * @param ctx
   * @return
   */
  override def visitMethodDeclaration(ctx: MethodDeclarationContext): String =
    findMethodDefinition(ctx) match {
      case Some(impl: MethodDefinitionContext) =>
        visit(impl)

      // no definition
      case _ =>
        val sel = ctx.methodSelector().get
        val mType = ctx.methodType()
        val mDecl = methodDeclaration(sel, mType)

        // Check ancestor is protocol or not
        ctx.parent.parent.parent match {
          case _: ProtocolDeclarationContext => mDecl
          case _ => s"$mDecl {\n}"
        }
    }


  /**
   * instance_method_definition:
   *   ('-' method_definition) ;
   *
   * @param ctx
   * @return
   */
  override def visitInstanceMethodDefinition(ctx: InstanceMethodDefinitionContext): String =
    ctx.methodDefinition() match {
      case Some(c) if !isVisited(c) => visit(c)
      case _ => "" // Already printed
    }


  /**
   * class_method_definition:
	 *   ('+' method_definition);
   *
   * @param ctx
   * @return
   */
  override def visitClassMethodDefinition(ctx: ClassMethodDefinitionContext): String =
    ctx.methodDefinition() match {
      case Some(c) if !isVisited(c) => s"class ${visit(c)}"
      case _ => "" // Already printed
    }


  /**
   * method_definition:
   *   (method_type)? method_selector (init_declarator_list)? ';'? compound_statement;
   *
   * @param ctx
   * @return
   */
  override def visitMethodDefinition(ctx: MethodDefinitionContext): String = {
    val sel = ctx.methodSelector().get
    val mType = ctx.methodType()
    val mDecl = methodDeclaration(sel, mType)
    val body = visit(ctx.compoundStatement())

    s"""|$mDecl {
        |${indent(body)}
        |}""".stripMargin
  }


  /**
   * method_type:
   *   '(' type_name ')';
   *
   * @param ctx
   * @return
   */
  override def visitMethodType(ctx: MethodTypeContext): String =
    visitChildren(ctx)


  /**
   * method_selector:
   *   selector
   *   |  (keyword_declarator+ (parameter_list)? )
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitMethodSelector(ctx: MethodSelectorContext): String =
    ctx.selector() match {
      case Some(s) => s"${visit(s)}()" // No parameters
      case None =>
        val name = visit(ctx.keywordDeclarator(0).selector())
        val headParam = processKeywordDeclarator(ctx.keywordDeclarator(0), isHead = true)
        val rest = ctx.keywordDeclarator().tail.foldLeft("")(_ + ", " + visitKeywordDeclarator(_))

        s"$name($headParam$rest)"
    }


  /**
   * keyword_declarator:
   *   selector? ':' method_type* IDENTIFIER;
   *
   * @param ctx
   * @return
   */
  override def visitKeywordDeclarator(ctx: KeywordDeclaratorContext): String =
    processKeywordDeclarator(ctx, isHead = false)


  private def findMethodDefinition(declCtx: MethodDeclarationContext): Option[MethodDefinitionContext] = {
    val selector = visit(declCtx.methodSelector())
    (declCtx.parent.parent.parent match {
      case classCtx: ClassInterfaceContext =>
        for {
          classImpl <- findClassImplementation(classCtx)
          implDefList <- classImpl.implementationDefinitionList()
        } yield implDefList

      case catCtx: CategoryInterfaceContext =>
        for {
          catImpl <- findCategoryImplementation(catCtx)
          impDefList <- catImpl.implementationDefinitionList()
        } yield impDefList

      case _ =>
        None

    }) flatMap { implDefList =>
      declCtx.parent match {
        case _: InstanceMethodDeclarationContext =>
          val insMethDefList = implDefList.instanceMethodDefinition().flatMap(_.methodDefinition())
          insMethDefList.find(d => visit(d.methodSelector()) == selector)
        case _: ClassMethodDeclarationContext =>
          val clsMethDefList = implDefList.instanceMethodDefinition().flatMap(_.methodDefinition())
          clsMethDefList.find(d => visit(d.methodSelector()) == selector)
      }
    }
  }


  private def methodDeclaration(mSel: MethodSelectorContext, mType: Option[MethodTypeContext]): String = {
    val mSelText = visit(mSel)
    mType.map(visit) match {
      case Some("IBAction") => s"@IBAction func $mSelText" // IBAction
      case Some("Void")     => s"func $mSelText" // void
      case Some(retType)    => s"func $mSelText -> $retType"
      case None             => s"func $mSelText -> AnyObject"
    }
  }


  private def processKeywordDeclarator(ctx: KeywordDeclaratorContext, isHead: Boolean): String = {
    val paramName = ctx.IDENTIFIER().get.getText
    val paramType = visitList(ctx.methodType())
    val selector = visit(ctx.selector())

    if(isHead || selector == paramName)
      s"$paramName: $paramType"
    else
      s"$selector $paramName: $paramType"
  }

}
