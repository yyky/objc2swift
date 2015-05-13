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
    val sb = new StringBuilder()

    val declaration_specifiers = ctx.declaration_specifiers()

    // Type
    Option(declaration_specifiers.type_specifier()) match {
      case None => // No Type
      case Some(ls) =>

        // Support Enumeration
        Option(ls(0).enum_specifier()) match {
          case Some(e) => return visit(e)
          case None =>
        }

        // TODO: Merge type name conversion (ref. MethodVisitor)
        val typeName = ls.foldLeft("")((s, c) =>
          Option(c.class_name()) match {
            case Some(cn) if s == "" => visit(cn)
            case Some(cn) => s // Not type name?
            case None =>
              visit(c) match {
                case "Int8" if s == "unsigned" => "UInt8"
                case "Int32" if s == "unsigned" => "UInt32"
                case "Int32" if s == "unsigned" => "UInt32"
                case "Int32" if s == "Int32" => "Int64"
                case "Int32" if s == "UInt32" => "UInt64"
                case t if t != "" => t
                case _ => s
              }
          }
        )

        Option(ctx.init_declarator_list()) match {
          case None =>
            // Single and no initializer declaration. Find id from class_name
            ls.foldLeft("")((s, c) =>
              Option(c.class_name()) match {
                case Some(cn) if s == "" => visit(cn)
                case _ => s
              }
            ) match {
              case s if s != "" =>
                sb.append(indent(ctx))
                sb.append("var ")
                sb.append(s)
                sb.append(": " + typeName)
                sb.append("\n")
              case _ => // No identifier
            }
          case Some(c) =>
            // Other declaration. Find from init_declarator_list
            c.init_declarator().foreach { c2 =>
              sb.append(indent(ctx))

              val dd = c2.declarator().direct_declarator()

              Option(dd.identifier()) match {
                case None => // not variables declaration?
                  ctx.children.foreach {
                    case TerminalText(";") => sb.append("\n")
                    case _: TerminalNode =>
                    case element => sb.append(visit(element) + " ")
                  }
                case Some(id) => // variables declaration
                  sb.append("var ")

                  // Identifier
                  sb.append(visit(id))
                  sb.append(": " + typeName)

                  // Initializer
                  sb.append(Option(c2.initializer()).map(visit).map(" = " + _).getOrElse(""))

                  sb.append("\n")
              }

            }
        }
    }

    sb.toString()
  }

  override def visitType_variable_declarator(ctx: Type_variable_declaratorContext): String = {

    val sb = new StringBuilder()

    val declaration_specifiers = ctx.declaration_specifiers()

    // Type
    Option(declaration_specifiers.type_specifier()) match {
      case None => // No Type
      case Some(ls) =>

        // TODO: Merge type name conversion (ref. MethodVisitor)
        val typeName = ls.foldLeft("")((s, c) =>
          Option(c.class_name()) match {
            case Some(cn) if s == "" => visit(cn)
            case Some(cn) => s // Not type name?
            case None =>
              visit(c) match {
                case "Int8" if s == "unsigned" => "UInt8"
                case "Int32" if s == "unsigned" => "UInt32"
                case "Int32" if s == "unsigned" => "UInt32"
                case "Int32" if s == "Int32" => "Int64"
                case "Int32" if s == "UInt32" => "UInt64"
                case t if t != "" => t
                case _ => s
              }
          }
        )

        val dd = ctx.declarator().direct_declarator()

        // Identifier
        Option(dd.identifier()) match {
          case Some(id) => // variables declaration
            sb.append(visit(id))
            sb.append(": " + typeName)
          case _ =>
        }
    }

    sb.toString()
  }

  override def visitDeclarator(ctx: DeclaratorContext): String = concatChildResults(ctx, "")

  override def visitDirect_declarator(ctx: Direct_declaratorContext): String =
    ctx.children.foldLeft(List.empty[String])((z, c) => {
      c match {
        case TerminalText("(") => "(" :: z
        case TerminalText(")") => ")" :: z
        case _: TerminalNode => z
        case _ => visit(c) :: z
      }
    }).reverse.mkString

}
