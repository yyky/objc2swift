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
            case Some(cn) if s == "" => cn.getText
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
            // Single and no initializer declaration. Find from class_name
            ls.foldLeft("")((s, c) =>
              Option(c.class_name()) match {
                case Some(cn) if s == "" => cn.getText
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
              sb.append("var ")

              // Identifier
              sb.append(c2.declarator().direct_declarator().identifier().getText)

              // Initializer
              Option(c2.initializer()) match {
                case Some(c3) => sb.append(" = " + visit(c3))
                case _ => sb.append(": " + typeName) // No initializer
              }

              sb.append("\n")
            }
        }
    }

    sb.toString()
  }

}
