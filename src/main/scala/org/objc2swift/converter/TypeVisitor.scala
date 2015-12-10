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
import scala.collection.mutable

/**
 * Implements visit methods for type contexts.
 */
trait TypeVisitor {
  this: ObjC2SwiftBaseConverter =>

  import org.objc2swift.converter.util._

  override def visitTypeName(ctx: TypeNameContext): String = visitChildren(ctx)

  override def visitSpecifierQualifierList(ctx: SpecifierQualifierListContext): String
    = processTypeSpecifierList(ctx.typeSpecifier().toList)

  override def visitAbstractDeclarator(ctx: AbstractDeclaratorContext): String = "" // ?

  override def visitTypeSpecifier(ctx: TypeSpecifierContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("void")           => "Void"
      case TerminalText("id")             => "AnyObject"
      case TerminalText("char")           => "Int8"
      case TerminalText("short")          => "Int16"
      case TerminalText("int")            => "Int32"
      case TerminalText("long")           => "Int64"
      case TerminalText("float")          => "Float"
      case TerminalText("double")         => "Double"
      case TerminalText(s) if !s.isEmpty  => s
      case _: TerminalNode                => "AnyObject"
      case ClassNameText("NSInteger")     => "Int"
      case ClassNameText("NSUInteger")    => "UInt"
      case ClassNameText("NSArray")       => "[AnyObject]"
      case ClassNameText("NSDictionary")  => "[AnyObject: AnyObject]"
      case ClassNameText("SEL")           => "Selector"
      case ClassNameText("BOOL")          => "Bool"
      case ClassNameText(s) if !s.isEmpty => s
      case _: ClassNameContext           => "AnyObject"
      case c: PointerContext              => visit(c)
      case c                              => c.getText
    }

  override def visitPointer(ctx: PointerContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("*") => "" // NOOP
      case c: DeclarationSpecifiersContext => visit(c)
    }

  def processTypeSpecifierList(ctxs: List[TypeSpecifierContext]): String = {
    ctxs.foldRight("") { (ctx, folded) =>
      (visit(ctx), folded) match {
        case ("Int64", "Int64") => "Int64" // long long
        case ("unsigned", "") => "UInt" // unsigned only
        case ("unsigned", t) if t.startsWith("Int") => "U" + t
        case ("signed", t) if t.startsWith("Int")   => t
        case (t, "") => t
        case (_, t)  => t
      }
    }
  }
}
