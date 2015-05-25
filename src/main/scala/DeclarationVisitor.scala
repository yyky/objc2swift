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

    // Static, etc
    val prefix = Option(ctx.declaration_specifiers().storage_class_specifier()) match {
      case Some(ls) => ls.map(visit).filter(!_.isEmpty).mkString(" ")
      case _ => ""
    }

    // Type
    Option(ctx.declaration_specifiers.type_specifier()) match {
      case Some(ls) =>
        // Support Enumeration
        Option(ls(0).enum_specifier()) match {
          case Some(e) => builder += visit(e)
          case None =>
        }
        Option(ctx.init_declarator_list()) match {
          case Some(c) =>
            // single declaration with initializer, or multiple declaration.
            // Find id from init_declarator_list
            val typeName = concatType(ls)
            c.init_declarator().foreach(c2 => {
              Option(c2.declarator().direct_declarator().identifier()) match {
                case Some(s) => builder += concatInitDeclaratorContext(c2, typeName, prefix)
                case None => // not variables declaration? ex) NSLog(foo)
                  Option(c2.declarator().direct_declarator().declarator()) match {
                    case Some(s) => builder += s"$indentString$typeName(${visit(s)})"
                    case None =>
                  }
              }
            })
          case None => builder += concatShortDeclaration(ls)
        }
      case None => // No Type
    }

    builder.result().filter(!_.isEmpty).mkString("\n") + "\n"
  }

  /**
   * Returns translated text of short style declaration.
   *
   * Called for single and no initializer declaration. Find id from class_name
   */
  private def concatShortDeclaration(types: TSContexts): String =
    Option(types.last.class_name()) match {
      case Some(s) => visit(s) match {
        case t if !t.isEmpty => s"${indent(s)}var $t: ${concatType(types.init)}"
        case _ => ""
      }
      case None => ""
    }

  /**
   * Returns translated text of init_declarator context.
   *
   * @param ctx init_declarator context
   * @param tp type name
   * @param prefix Prefix specifier
   * @return translated text
   */
  private def concatInitDeclaratorContext(ctx: Init_declaratorContext, tp: String, prefix: String): String = {
    val builder = List.newBuilder[String]

    prefix match {
      case s if !s.isEmpty => builder += s"${indent(ctx)}$s "
      case _               => builder += indent(ctx)
    }

    ctx.children.foreach {
      case TerminalText("=") => // NOOP
      case c: DeclaratorContext  => builder += s"${visit(c)}: $tp"
      case c: InitializerContext => builder += s" = ${visit(c)}"
    }

    builder.result().mkString
  }

  /**
   * Returns translated text of declarator context.
   * @param ctx the parse tree
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String = {
    val builder = List.newBuilder[String]

    ctx.children.foreach {
      case c: Direct_declaratorContext =>
        ctx.getParent match {
          case p: Init_declaratorContext =>
            builder.result().find(_ == "let") match {
              case Some(x) => builder += visit(c)
              case None    => builder += s"var ${visit(c)}"
            }
          case _ => builder += visit(c)
        }
      case c: PointerContext => builder += visit(c)
    }

    builder.result().filter(!_.isEmpty).mkString(" ")
  }

  /**
   * Returns translated text of direct_declarator context.
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
   * @param ctx the parse tree
   **/
  override def visitStorage_class_specifier(ctx: Storage_class_specifierContext): String =
    ctx.getText match {
      case "static" => "static"
      case _ => "" // TODO: Do something if you need
    }

}
