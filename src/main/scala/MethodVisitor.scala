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

    // Public method
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

    //
    // TODO: Support class method
    //
    findCorrespondingMethodDefinition(ctx.parent.asInstanceOf[Instance_method_declarationContext]) match {
      case None => {
        // Has no definition
        val method_selector: Method_selectorContext = ctx.method_selector()
        val method_type: Option[Method_typeContext] = Option(ctx.method_type())
        sb.append(createMethodHeader(method_selector, method_type))
        sb.append(" {\n\n}\n")
      }
      case Some(impl) =>
        visited.put(impl, true)
        // Delegate to method definition visitor
        sb.append(visit(impl.method_definition))
    }

    sb.toString()
  }

  /**
   * Convert instance method definition(implementation) in Objective-C to Swift code.
   *
   * @param ctx the parse tree
   * @return Strings of Swift code
   **/
  override def visitInstance_method_definition(ctx: Instance_method_definitionContext): String =
    Option(visited.get(ctx)) match {
      case Some(c) => "" // Already printed
      case _ =>
        // Private method
        visited.put(ctx, true)
        val sb = new StringBuilder()
        sb.append(indent(ctx) + "private func")
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
    sb.append(indent(ctx) + "}\n")

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
    val retType: String = tctx match {
      case Some(method_type_ctx) => visit(method_type_ctx) match {
        case s if s != "" => " -> " + s
        case _ => ""
      }
      case _ => " -> AnyObject" // id type
    }
    sb.append(retType)

    sb.toString()
  }

  override def visitMethod_selector(ctx: Method_selectorContext): String =
    Option(ctx.selector()) match {
      case Some(s) => s.getText + "()"
      case _ =>
        Option(ctx.keyword_declarator()) match {
          case None => "" // TODO: Syntax error
          case Some(ctxs) => ctxs.iterator().foldLeft("")((res, c) => {
            res match {
              case "" => res + visit(c).format("(") // method name and first param
              case _  => res + ", " + visit(c).format(" ") // other params
            }
          }) + ")"
        }
    }

  /**
   * Construtor of method parameter.
   *
   * @param ctx the parse tree
   * @return parameter code
   **/
  override def visitKeyword_declarator(ctx: Keyword_declaratorContext): String = {
    // Method name or Parameter's External name
    val selector = Option(ctx.selector()).map(_.getText).getOrElse("")

    // Parameter's Internal name
    val paramName: String = ctx.IDENTIFIER().getText

    // Parameter's Type
    val it = ctx.method_type().toIterator
    val paramType: String = it.map(visit(_)).find(s => s != "").getOrElse("")

    // Separator
    val sep: String = selector match {
      case s if s == "" => "" // No external name
      case s if s == paramName => "" // Same name
      case _ => selector + "%s"
    }

    sep + paramName + ": " + paramType
  }

  /**
   * Return method/parameter type on Swift rule.
   *
   * @param ctx the parse tree
   * @return Swift method type
   **/
  override def visitMethod_type(ctx: Method_typeContext): String = {
    val defaultType = "AnyObject"
    (Option(ctx.type_name().specifier_qualifier_list().type_specifier()) match {
      case None => defaultType
      case Some(contexts) =>
        val type_specifier_ctxs: collection.mutable.Buffer[Type_specifierContext] = contexts
        type_specifier_ctxs.foldLeft(defaultType)((s, type_specifier_ctx) => {
          visit(type_specifier_ctx) match {
            case "Int8" if s == "unsigned" => "UInt8"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "Int32" => "Int64"
            case "Int32" if s == "UInt32" => "UInt64"
            case t if t != "" => t
            case _ => s
          }
        })
    }) match {
      case "void" => "" // No return type
      case s => s
    }
  }

}
