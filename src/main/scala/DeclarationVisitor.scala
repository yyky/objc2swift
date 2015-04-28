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
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree, ParseTreeProperty}
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
                  for (element <- ctx.children) {
                    element match {
                      case symbol: TerminalNode =>
                        symbol.getSymbol.getText match {
                          case ";" => sb.append("\n")
                          case _ =>
                        }
                      case _ => sb.append(visit(element) + " ")
                    }
                  }
                case Some(id) => // variables declaration
                  sb.append("var ")

                  // Identifier
                  sb.append(visit(id))

                  // Initializer
                  Option(c2.initializer()) match {
                    case Some(c3) => sb.append(" = " + visit(c3))
                    case _ => sb.append(": " + typeName) // No initializer
                  }
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

  override def visitDeclarator(ctx: DeclaratorContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitDirect_declarator(ctx: Direct_declaratorContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => {
          symbol.getSymbol.getText match {
            case "(" | ")" => sb.append(symbol.getSymbol.getText)
            case _ => null
          }
        }
        case _ => sb.append(visit(element))
      }
    }

    sb.toString()
  }

}
