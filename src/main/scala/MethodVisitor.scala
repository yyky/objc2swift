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
  self: ObjCBaseVisitor[String] =>

  /**
   * Convert instance method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's instance method code
   */
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String = {
    val sb = new StringBuilder()

    // Public method
    sb.append(indent(ctx) + "func")
    sb.append(Option(ctx.method_declaration()).map(visit).getOrElse(""))

    sb.toString()
  }

  override def visitClass_method_declaration(ctx: Class_method_declarationContext): String = {
    val sb = new StringBuilder()

    // class method
    sb.append(indent(ctx) + "class func")
    sb.append(Option(ctx.method_declaration()).map(visit).getOrElse(""))

    sb.toString()
  }

  /**
   * Convert method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's method code
   */
  override def visitMethod_declaration(ctx: Method_declarationContext): String = {
    val sb = new StringBuilder()

    findCorrespondingMethodDefinition(ctx) match {
      case Some(impl: Method_definitionContext) =>
        sb.append(visit(impl))
      case None =>
        // Has no definition
        val method_selector = ctx.method_selector()
        val method_type = Option(ctx.method_type())
        sb.append(createMethodHeader(method_selector, method_type))

        // TODO: Check parent is protocol or not
        //sb.append(" {\n")
        //sb.append(indent(ctx) + "}")
    }

    sb.toString()
  }

  /**
   * Convert instance method definition(implementation) in Objective-C to Swift code.
   *
   * @param ctx the parse tree
   * @return Strings of Swift code
   */
  override def visitInstance_method_definition(ctx: Instance_method_definitionContext): String =
    isVisited(ctx.method_definition()) match {
      case true => "" // Already printed
      case false =>
        // Private method
        val sb = new StringBuilder()
        sb.append(indent(ctx) + "private func")
        sb.append(visit(ctx.method_definition()))
        sb.toString()
    }

  override def visitClass_method_definition(ctx: Class_method_definitionContext): String =
    isVisited(ctx.method_definition()) match {
      case true => "" // Already printed
      case false =>
        // Private class method
        val sb = new StringBuilder()
        sb.append(indent(ctx) + "private class func")
        sb.append(visit(ctx.method_definition()))
        sb.toString()
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
      case None => sb.append("-> AnyObject") // Default
      case Some(c) => visit(c) match {
        case s if s != "" => sb.append(" -> " + s)
        case _            => // void
      }
    }

    sb.toString()
  }

  override def visitMethod_selector(ctx: Method_selectorContext): String = {
    val sb = new StringBuilder()

    Option(ctx.selector()) match {
      case Some(s) => sb.append(s.getText + "()") // No parameters
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
    val selector: String = Option(ctx.selector()).map(_.getText).getOrElse("")

    // Parameter's Internal name
    val paramName: String = ctx.IDENTIFIER().getText

    // Parameter's Type
    val it = ctx.method_type().toIterator
    val paramType: String = it.map(visit).find(_ != "").getOrElse("")

    // Separator
    val sep: String = selector match {
      case s if s == ""        => "" // No external name
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
  override def visitMethod_type(ctx: Method_typeContext): String = {
    val defaultType = "AnyObject"
    val specifier_qualifier_list = ctx.type_name().specifier_qualifier_list()
    val type_specifier = Option(specifier_qualifier_list.type_specifier())

    (type_specifier match {
      case None => defaultType
      case Some(contexts) =>
        contexts.foldLeft(defaultType)((s, c) =>
          visit(c) match {
            case "Int8" if s == "unsigned"  => "UInt8"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "Int32"    => "Int64"
            case "Int32" if s == "UInt32"   => "UInt64"
            case t if t != ""               => t
            case _                          => s
          }
        )
    }) match {
      case "void" => "" // No return type
      case s      => s
    }
  }
}
