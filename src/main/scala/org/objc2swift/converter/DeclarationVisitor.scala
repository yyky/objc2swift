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
  this: ObjC2SwiftBaseConverter with TypeVisitor =>

  import org.objc2swift.converter.util._

  /**
   * declaration:
   *   declaration_specifiers init_declarator_list? ';';
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitDeclaration(ctx: DeclarationContext): String = {
    processAsFunctionCall(ctx) orElse
      processAsEnum(ctx) orElse
      processAsVarDeclaration(ctx) getOrElse
      ""
  }

  private def processAsFunctionCall(ctx: DeclarationContext): Option[String] =
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      funcName <- firstTypeSpec.className()

      initDeclList <- ctx.initDeclaratorList()
      initDecl <- initDeclList.initDeclarator().headOption
      decl <- initDecl.declarator()
      dirDecl <- decl.directDeclarator()
      decl2 <- dirDecl.declarator()
      dirDecl2 <- decl2.directDeclarator()
    } yield s"${visit(funcName)}(${visit(dirDecl2)})"


  private def processAsEnum(ctx: DeclarationContext): Option[String] =
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      enumSpec <- firstTypeSpec.enumSpecifier()
    } yield visit(enumSpec)


  private def processAsVarDeclaration(ctx: DeclarationContext): Option[String] = {
    val declSpec = ctx.declarationSpecifiers().get // required
    val typeSpecs = declSpec.typeSpecifier()
    val builder = List.newBuilder[String]

    // prefixes: static, const, etc..
    val prefix = visit(declSpec)

    // Type
    ctx.initDeclaratorList() match {
      case Some(c) =>
        // Single declaration with initializer, or list of declarations.
        val currentType = processTypeSpecifierList(typeSpecs)
        c.initDeclarator().foreach {
          builder += visitInitDeclarator(_, currentType, prefix)
        }
      case None =>
        // Short style declaration
        builder += buildShortDeclaration(typeSpecs, prefix).getOrElse("")
    }

    val result = builder.result().filter(_.nonEmpty).mkString("\n")
    Option(result)
  }

  /**
   * declaration_specifiers:
   *   (arc_behaviour_specifier | storage_class_specifier | type_specifier | type_qualifier)+ ;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitDeclarationSpecifiers(ctx: DeclarationSpecifiersContext): String =
    visitChildrenAs(ctx) {
      case c: TypeQualifierContext          => visit(c)
      case c: StorageClassSpecifierContext => visit(c)
    }

  /**
   * Returns translated text of declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String =
    visitChildrenAs(ctx) {
      case c: DirectDeclaratorContext => visit(c)
      case c: PointerContext           => visit(c)
    }

  /**
   * Returns translated text of direct_declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDirectDeclarator(ctx: DirectDeclaratorContext): String =
    visitChildrenAs(ctx, "") {
      case TerminalText("(") => "("
      case TerminalText(")") => ")"
      case _: TerminalNode   => "" // NOOP
      case c                 => visit(c)
    }

  /**
   * Returns translated initializer context.
   *
   * @param ctx the parse tree
   **/
  override def visitInitializer(ctx: InitializerContext): String = visitChildren(ctx)

  override def visitTypeVariableDeclarator(ctx: TypeVariableDeclaratorContext): String =
    ctx.declarationSpecifiers().map(_.typeSpecifier()).flatMap { ls =>
      ctx.declarator().flatMap(_.directDeclarator()).flatMap(_.identifier()).map(visit).map(_ + ": " + processTypeSpecifierList(ls))
    }.getOrElse("")

  /**
   * Returns translated text of type_qualifier context.
   *
   * [Supported qualifier]
   * - const
   *
   * @param ctx the parse tree
   **/
  override def visitTypeQualifier(ctx: TypeQualifierContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("const") => "let"
    }

  /**
   * Returns translated text of storage_class_specifier context.
   *
   * [Supported specifier]
   * - static
   *
   * @param ctx the parse tree
   **/
  override def visitStorageClassSpecifier(ctx: StorageClassSpecifierContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("static") => "static"
    }

  /**
   * Returns translated text of init_declarator context.
   *
   * @param ctx init_declarator context
   * @param tp type name
   * @param prefix Prefix specifiers
   * @return translated text
   */
  private def buildInitDeclaration(ctx: InitDeclaratorContext, tp: String, prefix: String): Option[String] = {
    visitChildrenAs(ctx) {
      case TerminalText("=") => "" // NOOP
      case c: DeclaratorContext  => {
        val declarator = visit(c)
        List(
          prefix,
          if (
            prefix.split(" ").contains("let") ||
              declarator.split(" ").contains("let")) "" else "var",
          s"$declarator: $tp").filter(_.nonEmpty).mkString(" ")
      }
      case c: InitializerContext => s"= ${visit(c)}"
    } match {
      case "" => None
      case s  => Some(s)
    }
  }

  private def visitInitDeclarator(ctx: InitDeclaratorContext, typeName: String, prefix: String): String = {
    {
      ctx.declarator().flatMap(_.directDeclarator()).flatMap(_.identifier()).map { _ =>
        buildInitDeclaration(ctx, typeName, prefix).getOrElse("")
      }
    }.getOrElse("")
  }

  /**
   * Returns translated text of short style declaration.
   *
   * Called for single and no initializer declaration. Find id from class_name
   *
   * @param ctxs List of type_specifier contexts.
   * @param prefix prefix specifiers
   * @return translated text
   */
  private def buildShortDeclaration(ctxs: List[TypeSpecifierContext], prefix: String): Option[String] = {
    ctxs.last.className().map(visit).filter(_.nonEmpty).map { name =>
      List(
        prefix,
        if (prefix.split(" ").contains("let")) "" else "var",
        s"$name: ${processTypeSpecifierList(ctxs.init)}").filter(_.nonEmpty).mkString(" ")
    }
  }

}
