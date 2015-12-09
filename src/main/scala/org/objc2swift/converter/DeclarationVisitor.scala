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

import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

/**
 * Implements visit methods for declaration contexts.
 */
trait DeclarationVisitor {
  this: ObjC2SwiftBaseConverter
    with TypeVisitor
    with UtilMethods =>

  import org.objc2swift.converter.util._

  /**
   * Returns translated text of declaration context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclaration(ctx: DeclarationContext): String = {
    val builder = List.newBuilder[String]
    val specifiers = List.newBuilder[String]
    val ds = ctx.declarationSpecifiers()

    // prefixes: static, const, etc..
    specifiers += visit(ds)
    val prefixes = specifiers.result().filter(_.nonEmpty)

    // Type
    Option(ds.typeSpecifier()).foreach { ls =>
      // Support Enumeration
      Option(ls(0).enumSpecifier()).foreach { e =>
        builder += visit(e)
      }

      Option(ctx.initDeclaratorList()) match {
        case Some(c) =>
          // Single declaration with initializer, or list of declarations.
          val currentType = concatType(ls)
          c.initDeclarator().foreach {
            builder += visitInitDeclarator(_, currentType, prefixes)
          }
        case None =>
          // Short style declaration
          builder += buildShortDeclaration(ls, prefixes).map(indent(ctx) + _).getOrElse("")
      }
    }

    builder.result().filter(_.nonEmpty).mkString("\n") + "\n"
  }

  private def visitInitDeclarator(ctx: InitDeclaratorContext, typeName: String, prefixes: List[String]): String = {
    {
      Option(ctx.declarator().directDeclarator().identifier()).map { _ =>
        buildInitDeclaration(ctx, typeName, prefixes).map(indent(ctx) + _).getOrElse("")
      } orElse
      // not variables declaration? ex) NSLog(foo)
      Option(ctx.declarator().directDeclarator().declarator()).map { s =>
        s"$indentString$typeName(${visit(s)})"
      }
    }.getOrElse("")
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
    Option(ctxs.last.className()).map(visit).filter(_.nonEmpty).map { name =>
      List(
        prefixes.mkString(" "),
        if (prefixes.mkString(" ").split(" ").contains("let")) "" else "var",
        s"$name: ${concatType(ctxs.init)}").filter(_.nonEmpty).mkString(" ")
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
  private def buildInitDeclaration(ctx: InitDeclaratorContext, tp: String, prefixes: List[String]): Option[String] = {
    ctx.children.map {
      case TerminalText("=") => "" // NOOP
      case c: DeclaratorContext  => {
        val declarator = visit(c)
        List(
          prefixes.mkString(" "),
          if (
            prefixes.mkString(" ").split(" ").contains("let") ||
            declarator.split(" ").contains("let")) "" else "var",
          s"$declarator: $tp").filter(_.nonEmpty).mkString(" ")
      }
      case c: InitializerContext => s"= ${visit(c)}"
    }.filter(_.nonEmpty).mkString(" ") match {
      case "" => None
      case s  => Some(s)
    }
  }

  /**
   * Returns translated text of declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String = {
    ctx.children.collect {
      case c: DirectDeclaratorContext => visit(c)
      case c: PointerContext           => visit(c)
    }.filter(_.nonEmpty).mkString(" ")
  }

  /**
   * Returns translated text of direct_declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDirectDeclarator(ctx: DirectDeclaratorContext): String = {
    ctx.children.map {
      case TerminalText("(") => "("
      case TerminalText(")") => ")"
      case _: TerminalNode   => "" // NOOP
      case c                 => visit(c)
    }.mkString
  }

  /**
   * Returns translated initializer context.
   *
   * @param ctx the parse tree
   **/
  override def visitInitializer(ctx: InitializerContext): String = concatChildResults(ctx, "")

  override def visitTypeVariableDeclarator(ctx: TypeVariableDeclaratorContext): String =
    Option(ctx.declarationSpecifiers().typeSpecifier()).flatMap { ls =>
      Option(ctx.declarator().directDeclarator().identifier())
        .map(visit).map(_ + ": " + concatType(ls))
    }.getOrElse("")

  /**
   * Returns translated text of declaration_specifiers context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclarationSpecifiers(ctx: DeclarationSpecifiersContext): String = {
    ctx.children.map {
      case c: TypeQualifierContext          => visit(c)
      case c: StorageClassSpecifierContext => visit(c)
      case _ => "" // TODO: Do something if you need
    }.filter(_.nonEmpty).mkString(" ")
  }

  /**
   * Returns translated text of type_qualifier context.
   *
   * [Supported qualifier]
   * - const
   *
   * @param ctx the parse tree
   **/
  override def visitTypeQualifier(ctx: TypeQualifierContext): String = {
    ctx.children.map {
      case TerminalText("const") => "let"
      case _ => "" // TODO: Do something if you need
    }.mkString
  }

  /**
   * Returns translated text of storage_class_specifier context.
   *
   * [Supported specifier]
   * - static
   *
   * @param ctx the parse tree
   **/
  override def visitStorageClassSpecifier(ctx: StorageClassSpecifierContext): String = {
    ctx.getText match {
      case s @ "static" => s
      case _ => "" // TODO: Do something if you need
    }
  }

}
