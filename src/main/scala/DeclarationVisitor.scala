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
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree, ParseTreeProperty}
import collection.JavaConversions._

trait DeclarationVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  object ClassName {
    def unapply(node: ParserRuleContext): Option[String] =
      node match {
        case c: Type_specifierContext =>
          Option(c.class_name()) match {
            case Some(cn) => Option(visit(cn))
            case _ => None
          }
        case _ => None
      }
  }

  object EnumTypeSpecifier {
    def unapply(ctx: Enum_specifierContext): Option[String] =
      Option(ctx.type_name()) match {
        case Some(c) =>
          Option(c.specifier_qualifier_list()) match {
            case Some(s) =>
              Option(s.type_specifier()) match {
                case Some(list) => Option(visit(list.get(0)))
                case None => None
              }
            case None => None
          }
        case _ => None
      }
  }

  override def visitEnumerator(ctx: EnumeratorContext): String = {
    val sb = new StringBuilder()
    sb.append(indent(ctx) + "case ")
    sb.append(visit(ctx.identifier()))
    Option(ctx.constant_expression()) match {
      case Some(e) => sb.append(" = " + visit(e))
      case None =>
    }
    sb.toString()
  }

  override def visitEnumerator_list(ctx: Enumerator_listContext): String =
    ctx.enumerator().map(visit).mkString("\n")

  def enumName(ctx: Declaration_specifiersContext): String =
    Option(ctx.type_specifier()) match {
      case None => ""
      case Some(list) =>
        list.size match {
          case n if n >= 2 => visit(list.get(1).class_name())
          case n if n >= 1 =>
            Option(list.get(0).enum_specifier()) match {
              case Some(e) => Option(e.identifier()).map(visit).getOrElse("")
              case _ => ""
            }
        }
    }

  def makeEnum(ctx: Enum_specifierContext, dcl: Declaration_specifiersContext): String = {
    val sb = new StringBuilder()
    sb.append("enum")
    enumName(dcl) match {
      case s if s != "" => sb.append(" " + s)
      case _ =>
    }
    ctx match {
      case EnumTypeSpecifier(s) => sb.append(": " + s)
      case _ =>
    }
    sb.append(" {\n")
    Option(ctx.enumerator_list()) match {
      case Some(el) => sb.append(visit(el) + "\n")
      case _ =>
    }
    sb.append("}")
    sb.toString()
  }

  override def visitDeclaration(ctx: DeclarationContext): String = {
    val sb = new StringBuilder()

    val declaration_specifiers = ctx.declaration_specifiers()

    // Type
    Option(declaration_specifiers.type_specifier()) match {
      case None => // No Type
      case Some(ls) =>

        // Support Enumeration
        Option(ls.get(0).enum_specifier()) match {
          case Some(e) => return makeEnum(e, declaration_specifiers)
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

        if(sb.isEmpty && ls.size == 1) {
          sb.append(Option(ls.get(0).enum_specifier()).map(visit).getOrElse(""))
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
