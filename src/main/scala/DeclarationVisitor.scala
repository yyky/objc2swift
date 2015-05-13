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
import org.antlr.v4.runtime.tree.TerminalNode
import collection.JavaConversions._

trait DeclarationVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  override def visitDeclaration(ctx: DeclarationContext): String = {
    var res = List.empty[String]

    // Type
    Option(ctx.declaration_specifiers.type_specifier()) match {
      case Some(ls) =>
        // Support Enumeration
        res = Option(ls(0).enum_specifier()) match {
          case Some(e) => visit(e) :: res
          case None => res
        }
        res = Option(ctx.init_declarator_list()) match {
          case Some(c) =>
            // single declaration with initializer, or multiple declaration.
            // Find id from init_declarator_list
            val typeName = concatType(ls)
            c.init_declarator().foldLeft(List.empty[String])((z, c2) => {
              Option(c2.declarator().direct_declarator().identifier()) match {
                case Some(s) => concatInitDeclaratorContext(c2, typeName) :: z
                case None => // not variables declaration?
                  ctx.children.foldLeft(List.empty[String])((z2, c3) => {
                    c3 match {
                      case TerminalText(";") => "\n" :: z2
                      case _: TerminalNode => z2
                      case element => visit(element) + " " :: z2
                    }
                  }).reverse.mkString :: z
              }
            }).reverse.mkString("\n") :: res
          case None => concatShortDeclaration(ls) :: res
        }
      case None => // No Type
    }

    res.reverse.mkString("\n") + "\n"
  }

  /**
   * Returns translated text of short style declaration.
   *
   * Called for single and no initializer declaration. Find id from class_name
   */
  private def concatShortDeclaration(types: TSContexts): String =
    Option(types.last.class_name()) match {
      case Some(s) => visit(s) match {
        case t if t != "" => s"${indent(s)}var $t: ${concatType(types.init)}"
        case _ => ""
      }
      case None => ""
    }

  /**
   * Returns translated text of init_declarator context.
   * @param ctx init_declarator context
   * @param tp type name
   * @return translated text
   */
  private def concatInitDeclaratorContext(ctx: Init_declaratorContext, tp: String): String =
    ctx.children.foldLeft(List.empty[String])((z, c) => {
      c match {
        case TerminalText("=") => " = " :: z
        case _: DeclaratorContext => s"var ${visit(c)}: $tp" :: z
        case _: InitializerContext => visit(c) :: z
        case _ => z
      }
    }).reverse.mkString(indent(ctx), "", "")

  /**
   * Returns translated text of declarator context.
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String = concatChildResults(ctx, "")

  /**
   * Returns translated text of direct_declarator context.
   * @param ctx the parse tree
   **/
  override def visitDirect_declarator(ctx: Direct_declaratorContext): String =
    ctx.children.foldLeft(List.empty[String])((z, c) => {
      c match {
        case TerminalText("(") => "(" :: z
        case TerminalText(")") => ")" :: z
        case _: TerminalNode => z
        case _ => visit(c) :: z
      }
    }).reverse.mkString

  /**
   * Returns translated initializer context.
   * @param ctx the parse tree
   **/
  override def visitInitializer(ctx: InitializerContext): String = concatChildResults(ctx, "")

  override def visitType_variable_declarator(ctx: Type_variable_declaratorContext): String =
    Option(ctx.declaration_specifiers().type_specifier()) match {
      case Some(ls) =>
        /*
        val typeName = ls.foldLeft("")((s, c) =>
          Option(c.class_name()) match {
            case Some(cn) if s == "" => visit(cn)
            case Some(cn) => s // Not type name?
            case None => concatNumberType(s, c)
          }
        )
        */
        Option(ctx.declarator().direct_declarator().identifier())
          .map(visit).map(_ + ": " + concatType(ls)).getOrElse("")
      case None => "" // No Type
    }

}
