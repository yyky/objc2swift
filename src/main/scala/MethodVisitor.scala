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
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String = {
    val dcl = Option(ctx.method_declaration()).map(visit).getOrElse("")
    s"${indent(ctx)}${optional(ctx)}func$dcl"
  }

  /**
   * Returns translated text of class method declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitClass_method_declaration(ctx: Class_method_declarationContext): String = {
    val dcl = Option(ctx.method_declaration()).map(visit).getOrElse("")
    s"${indent(ctx)}${optional(ctx)}class func$dcl"
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
        val method_selector = ctx.method_selector()
        val method_type = Option(ctx.method_type())
        val hd = createMethodHeader(method_selector, method_type)

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
   * @return Strings of Swift code
   */
  override def visitInstance_method_definition(ctx: Instance_method_definitionContext): String =
    isVisited(ctx.method_definition()) match {
      case true => "" // Already printed
      case false => s"${indent(ctx)}func${visit(ctx.method_definition())}"
    }

  override def visitClass_method_definition(ctx: Class_method_definitionContext): String =
    isVisited(ctx.method_definition()) match {
      case true => "" // Already printed
      case false => s"${indent(ctx)}class func${visit(ctx.method_definition())}"
    }

  override def visitMethod_definition(ctx: Method_definitionContext): String = {
    val sb = new StringBuilder
    val method_selector: Method_selectorContext = ctx.method_selector()
    val method_type: Option[Method_typeContext] = Option(ctx.method_type())

    sb.append(createMethodHeader(method_selector, method_type))
    sb.append(" {\n")
    sb.append(visit(ctx.compound_statement()) + "\n")
    sb.append(indent(ctx) + "}")

    sb.toString()
  }

  def createMethodHeader(sctx: Method_selectorContext, tctx: Option[Method_typeContext]): String = {

    val sb = new StringBuilder()

    // Method selector and parameters
    sb.append(" " + visit(sctx))

    //
    // Method type.
    //
    // Currently, supported types are:
    //   void, id(AnyObject), short/int/long, float/double, ...
    //
    // TODO: Support more types
    //
    tctx match {
      case None => sb.append(" -> AnyObject") // Default
      case Some(c) => visit(c) match {
        case s if !s.isEmpty => sb.append(" -> " + s)
        case _            => // void
      }
    }

    sb.toString()
  }

  override def visitMethod_selector(ctx: Method_selectorContext): String = {
    val sb = new StringBuilder()

    Option(ctx.selector()) match {
      case Some(s) => sb.append(visit(s) + "()") // No parameters
      case _ =>
        Option(ctx.keyword_declarator()) match {
          case None => // TODO: Syntax error
          case Some(ctxs) => ctxs.zipWithIndex.foreach {
            case (c, 0) => sb.append(visit(c).format("("))
            case (c, i) => sb.append(", " + visit(c).format(" "))
          }
        }
        sb.append(")")
    }
    sb.toString()
  }

  /**
   * Construtor of method parameter.
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

    sep + paramName + ": " + paramType
  }

  /**
   * Return method/parameter type on Swift rule.
   *
   * @param ctx the parse tree
   * @return Swift method type
   */
  override def visitMethod_type(ctx: Method_typeContext): String =
    Option(ctx.type_name.specifier_qualifier_list) match {
      case Some(s) =>
        Option(s.type_specifier()).map(concatType(_)).getOrElse("AnyObject") match {
          case "void" => ""
          case t => t
        }
      case _ => "AnyObject"
    }
}
