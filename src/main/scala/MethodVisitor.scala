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

/**
 * Implements visit methods for method-contexts.
 */
trait MethodVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  /**
   * Returns translated text of instance method declaration context.
   *
   * @param ctx the parse tree
   * @return Strings of Swift's instance method code
   */
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String =
    Option(ctx.method_declaration()).map(c =>
      s"${indent(ctx)}${optional(ctx)}${visit(c)}".stripSuffix(" ")
    ).getOrElse("")

  /**
   * Returns translated text of class method declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitClass_method_declaration(ctx: Class_method_declarationContext): String =
    Option(ctx.method_declaration()).map(c =>
      s"${indent(ctx)}${optional(ctx)}class ${visit(c)}".stripSuffix(" ")
    ).getOrElse("")

  /**
   * Returns translated text of method definition context.
   *
   * @param ctx the parse tree
   * @return Strings of Swift code
   */
  override def visitInstance_method_definition(ctx: Instance_method_definitionContext): String =
    ctx.method_definition() match {
      case c if !isVisited(c) => s"${indent(ctx)}${visit(c)}".stripSuffix(" ")
      case _ => "" // Already printed
    }

  /**
   * Returns translated text of class method definition context.
   *
   * @param ctx the parse tree
   **/
  override def visitClass_method_definition(ctx: Class_method_definitionContext): String =
    ctx.method_definition() match {
      case c if !isVisited(c) => s"${indent(ctx)}class ${visit(c)}".stripSuffix(" ")
      case _ => "" // Already printed
    }

  /**
   * Returns translated text of method declaration context.
   *
   * @param ctx the parse tree
   * @return Strings of Swift's method code
   */
  override def visitMethod_declaration(ctx: Method_declarationContext): String =
    findCorrespondingMethodDefinition(ctx) match {
      case Some(impl: Method_definitionContext) => visit(impl)
      case _ =>
        // Has no definition
        val slct = ctx.method_selector()
        val tp = Option(ctx.method_type())
        val hd = createMethodHeader(slct, tp)

        // Check ancestor is protocol or not
        ctx.parent.parent.parent match {
          case _: Protocol_declarationContext => hd
          case _ => s"$hd {\n${indent(ctx)}}"
        }
    }

  /**
   * Returns translated text of method definition context.
   *
   * @param ctx the parse tree
   **/
  override def visitMethod_definition(ctx: Method_definitionContext): String = {
    val builder = List.newBuilder[String]
    val slct = ctx.method_selector()
    val tp = Option(ctx.method_type())
    val hd = createMethodHeader(slct, tp)

    builder += s"$hd {\n"
    builder += visit(ctx.compound_statement())
    builder += s"${indent(ctx)}}"

    builder.result().mkString
  }

  /**
   * Returns translated text of method selector context.
   * @param ctx the parse tree
   **/
  override def visitMethod_selector(ctx: Method_selectorContext): String =
    Option(ctx.selector()) match {
      case Some(s) => s"${visit(s)}()" // No parameters
      case _ =>
        val builder = List.newBuilder[String]
        ctx.keyword_declarator().zipWithIndex.foreach {
          case (c, 0) => builder += visit(c).format("(")
          case (c, i) => builder += s", ${visit(c).format(" ")}"
        }
        builder += ")"
        builder.result().mkString
    }

  /**
   * Returns translated text of keyword declarator
   *
   * @param ctx the parse tree
   * @return parameter code
   */
  override def visitKeyword_declarator(ctx: Keyword_declaratorContext): String = {
    // Method name or Parameter's External name
    val selector = Option(ctx.selector()).map(visit).getOrElse("")

    // Parameter's Internal name
    val paramName = ctx.IDENTIFIER().getText

    // Parameter's Type
    val it = ctx.method_type().toIterator
    val paramType = it.map(visit).find(_ != "").getOrElse("")

    // Separator
    val sep = selector match {
      case s if s.isEmpty      => "" // No external name
      case s if s == paramName => "" // Same name
      case _                   => selector + "%s"
    }

    s"$sep$paramName: $paramType"
  }

  /**
   * Return method/parameter type on Swift rule.
   *
   * @param ctx the parse tree
   * @return Swift method type
   */
  override def visitMethod_type(ctx: Method_typeContext): String = {
    val retType = (for {
      x <- Option(ctx.type_name().specifier_qualifier_list())
      y <- Option(x.type_specifier())
    } yield y).map(concatType(_)).getOrElse("AnyObject")

    retType match {
      case "void" => ""
      case _      => retType
    }
  }

  /**
   * Returns method header text.
   * @param sctx method_selector_context tree
   * @param tctx method_type_context tree (Optional)
   * @return Translated text of method header contexts.
   */
  private def createMethodHeader(sctx: Method_selectorContext, tctx: Option[Method_typeContext]): String =
    tctx match {
      case Some(c) => visit(c) match {
        case s if !s.isEmpty => s"func ${visit(sctx)} -> $s"
        case _               => s"func ${visit(sctx)}" // void
      }
      case None              => s"func ${visit(sctx)} -> AnyObject" // Default
    }

}
