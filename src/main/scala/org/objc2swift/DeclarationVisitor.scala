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
import org.antlr.v4.runtime.tree.TerminalNode
import scala.collection.JavaConversions._

/**
 * Implements visit methods for declaration contexts.
 */
trait DeclarationVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  /**
   * Returns translated text of declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclaration(ctx: DeclarationContext): String = {
    val builder = List.newBuilder[String]
    val specifiers = List.newBuilder[String]
    val ds = ctx.declaration_specifiers()

    // prefixes: static, const, etc..
    specifiers += visit(ds)
    val prefixes = specifiers.result().filter(!_.isEmpty)

    // Type
    Option(ds.type_specifier()) match {
      case Some(ls) =>
        // Support Enumeration
        Option(ls(0).enum_specifier()) match {
          case Some(e) => builder += visit(e)
          case None =>
        }

        Option(ctx.init_declarator_list()) match {
          case Some(c) =>
            // Single declaration with initializer, or list of declarations.
            val currentType = concatType(ls)
            c.init_declarator().foreach {
              builder += visitInit_declarator(_, currentType, prefixes)
            }
          case None =>
            // Short style declaration
            builder += buildShortDeclaration(ls, prefixes).map(indent(ctx) + _).getOrElse("")
        }
      case None => // No Type
    }

    builder.result().filter(!_.isEmpty).mkString("\n") + "\n"
  }

  private def visitInit_declarator(ctx: Init_declaratorContext, typeName: String, prefixes: List[String]): String = {
    Option(ctx.declarator().direct_declarator().identifier()) match {
      case Some(s) =>
        buildInitDeclaration(ctx, typeName, prefixes).map(indent(ctx) + _).getOrElse("")
      case None =>
        // not variables declaration? ex) NSLog(foo)
        Option(ctx.declarator().direct_declarator().declarator()) match {
          case Some(s) => s"$indentString$typeName(${visit(s)})"
          case None => ""
        }
    }
  }

  /**
   * Returns translated text of short style declaration.
   *
   * Called for single and no initializer declaration. Find id from class_name
   *
   * @param ctxs List of type_specifier contexts.
   * @param prefixes prefix specifiers
   * @return translated text
   */
  private def buildShortDeclaration(ctxs: TSContexts, prefixes: List[String]): Option[String] = {
    val builder = List.newBuilder[String]

    Option(ctxs.last.class_name()).map(visit) match {
      case Some(name) if !name.isEmpty =>
        prefixes.mkString(" ").split(" ").find(_ == "let") match {
          case Some(s) => builder += prefixes.mkString(" ")
          case None    => builder += prefixes.mkString(" "); builder += "var"
        }
        builder += s"$name: ${concatType(ctxs.init)}"
        Some(builder.result().filter(!_.isEmpty).mkString(" "))
      case _ => None
    }
  }

  /**
   * Returns translated text of init_declarator context.
   *
   * @param ctx init_declarator context
   * @param tp type name
   * @param prefixes Prefix specifiers
   * @return translated text
   */
  private def buildInitDeclaration(ctx: Init_declaratorContext, tp: String, prefixes: List[String]): Option[String] = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("=")     => // NOOP
      case c: DeclaratorContext  =>
        val declarator = visit(c)
        builder += prefixes.mkString(" ")
        prefixes.mkString(" ").split(" ").find(_ == "let") match {
          case Some(s) => builder += s"$declarator: $tp"
          case None    =>
            declarator.split(" ").find(_ == "let") match {
              case Some(s) => builder += s"$declarator: $tp"
              case None    => builder += s"var $declarator: $tp"
            }
        }
      case c: InitializerContext => builder += s"= ${visit(c)}"
    }

    builder.result().filter(!_.isEmpty).mkString(" ") match {
      case s if !s.isEmpty => Some(s)
      case _               => None
    }
  }

  /**
   * Returns translated text of declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case c: Direct_declaratorContext => builder += visit(c)
      case c: PointerContext           => builder += visit(c)
      case _ =>
    }

    builder.result().filter(!_.isEmpty).mkString(" ")
  }

  /**
   * Returns translated text of direct_declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDirect_declarator(ctx: Direct_declaratorContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case TerminalText("(") => builder += "("
      case TerminalText(")") => builder += ")"
      case _: TerminalNode   => // NOOP
      case c                 => builder += visit(c)
    }

    builder.result().mkString
  }

  /**
   * Returns translated initializer context.
   *
   * @param ctx the parse tree
   **/
  override def visitInitializer(ctx: InitializerContext): String = concatChildResults(ctx, "")

  override def visitType_variable_declarator(ctx: Type_variable_declaratorContext): String =
    Option(ctx.declaration_specifiers().type_specifier()) match {
      case Some(ls) =>
        Option(ctx.declarator().direct_declarator().identifier())
          .map(visit).map(_ + ": " + concatType(ls)).getOrElse("")
      case None => "" // No Type
    }

  /**
   * Returns translated text of pointer context.
   *
   * @param ctx the parse tree
   **/
  override def visitPointer(ctx: PointerContext): String = {
    val builder = List.newBuilder[String]
    ctx.children.foreach {
      case TerminalText("*") => // NOOP
      case c: Declaration_specifiersContext => builder += visit(c)
      case c: PointerContext => // TODO: Do something if you need
    }
    builder.result().mkString
  }

  /**
   * Returns translated text of declaration_specifiers context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclaration_specifiers(ctx: Declaration_specifiersContext): String = {
    val builder = List.newBuilder[String]
    ctx.children.foreach {
      case c: Type_qualifierContext          => builder += visit(c)
      case c: Storage_class_specifierContext => builder += visit(c)
      case _ => // TODO: Do something if you need
    }
    builder.result().filter(!_.isEmpty).mkString(" ")
  }

  /**
   * Returns translated text of type_qualifier context.
   *
   * [Supported qualifier]
   * - const
   *
   * @param ctx the parse tree
   **/
  override def visitType_qualifier(ctx: Type_qualifierContext): String = {
    val builder = List.newBuilder[String]
    ctx.children.foreach {
      case TerminalText("const") => builder += "let"
      case _ => // TODO: Do something if you need
    }
    builder.result().mkString
  }

  /**
   * Returns translated text of storage_class_specifier context.
   *
   * [Supported specifier]
   * - static
   *
   * @param ctx the parse tree
   **/
  override def visitStorage_class_specifier(ctx: Storage_class_specifierContext): String =
    ctx.getText match {
      case "static" => "static"
      case _ => "" // TODO: Do something if you need
    }

}
