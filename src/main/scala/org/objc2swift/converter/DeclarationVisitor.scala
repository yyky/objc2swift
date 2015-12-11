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

import org.antlr.v4.runtime.RuleContext
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
      processAsVarDeclaration(ctx) orElse
      processAsSingleVarDeclaration(ctx) getOrElse
      ""
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
      case c: TypeQualifierContext         => visit(c)
      case c: StorageClassSpecifierContext => visit(c)
    }

  /**
   * Returns translated text of declarator context.
   *
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String =
    visitChildren(ctx)

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
  override def visitInitializer(ctx: InitializerContext): String =
    visitChildren(ctx)

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
  override def visitTypeQualifier(ctx: TypeQualifierContext): String = ""

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


  private def processAsFunctionCall(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      funcName <- firstTypeSpec.className() // MEMO this is strange

      initDeclList <- ctx.initDeclaratorList()
      initDecl <- initDeclList.initDeclarator().headOption
      decl <- initDecl.declarator()
      dirDecl <- decl.directDeclarator()
      decl2 <- dirDecl.declarator()
      dirDecl2 <- decl2.directDeclarator()
    } yield s"${visit(funcName)}(${visit(dirDecl2)})"
  }

  private def processAsEnum(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      enumSpec <- firstTypeSpec.enumSpecifier()
    } yield visit(enumSpec)
  }


  private def processAsVarDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      initDeclList <- ctx.initDeclaratorList()
    } yield initDeclList.initDeclarator().map { // foreach init-declarator
      visitChildrenAs(_) {
        case c: DeclaratorContext  => varDeclaration(ctx, declSpec, declSpec.typeSpecifier(), c)
        case TerminalText("=") => "="
        case c: InitializerContext => visit(c)
      }
    }.mkString("\n")
  }


  private def processAsSingleVarDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      lastTypeSpec <- declSpec.typeSpecifier().lastOption
      varName <- lastTypeSpec.className() // MEMO this is strange
    } yield varDeclaration(ctx, declSpec, declSpec.typeSpecifier().init, varName)
  }


  private def varDeclaration(ctx: DeclarationContext, declSpec: DeclarationSpecifiersContext,
                             typeSpecs: List[TypeSpecifierContext], varName: RuleContext): String = {
    List(
      visit(declSpec),
      letOrVar(ctx),
      visit(varName) + ":",
      processTypeSpecifierList(typeSpecs)
    ).filter(_.nonEmpty).mkString(" ")
  }

  private def letOrVar(ctx: DeclarationContext): String =
    if(ctx.declarationSpecifiers().exists(isConstantDeclaration)) "let" else "var"

  private def isConstantDeclaration(ctx: DeclarationSpecifiersContext): Boolean =
    ctx.typeQualifier().exists {
      _.children.exists {
        case TerminalText("const") => true
        case _ => false
      }
    }
}
