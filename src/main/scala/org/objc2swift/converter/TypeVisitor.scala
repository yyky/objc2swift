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

  @deprecated("", "")
  type TSContexts = mutable.Buffer[TypeSpecifierContext]

  /**
   * Returns translated text of typeSpecifier context.
   *
   * @param ctx the parse tree
   * @return Swift type strings
   *
   * TODO: Implement other types
   *
   */
  override def visitTypeSpecifier(ctx: TypeSpecifierContext): String = {
    ctx.children.map {
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
    }.mkString
  }

  /**
   * Returns translated text of pointer context.
   *
   * @param ctx the parse tree
   **/
  override def visitPointer(ctx: PointerContext): String = {
    ctx.children.map {
      case TerminalText("*") => "" // NOOP
      case c: DeclarationSpecifiersContext => visit(c)
      case c: PointerContext => "" // TODO: Do something if you need
    }.mkString
  }

  def processTypeSpecifierList(ctxs: List[TypeSpecifierContext]): String = {
    ctxs.foldRight("") { (ctx, folded) =>
      (folded, visit(ctx)) match {
        case ("Int64", "Int64") => "Int64" // long long
        case ("unsigned", t) if t.startsWith("Int") => "U" + t
        case ("signed", t)   => t
        case (_, "")         => folded
        case (_, t)          => t
      }
    }
  }

  /**
   * Returns concatenated number type text.
   * @param prefix Prefix text of current types.
   * @param ctx Current typeSpecifier context
   * @return Concatenated and translated number type text
   */
  @deprecated("", "")
  private def concatNumberType(prefix: String, ctx: TypeSpecifierContext): String =
    (prefix, visit(ctx)) match {
      case ("unsigned", "Int8") => "UInt8"
      case ("unsigned", "Int")  => "UInt"
      case ("Int", "Int")       => "Int64"
      case ("UInt", "Int")      => "UInt64"
      case ("signed", t)        => t
      case (_, "")              => prefix
      case (_, t)               => t
    }

  /**
   * Return concatenated type text.
   * @param types List of typeSpecifier context
   * @return Concatenated and translated type text
   */
  @deprecated("", "")
  def concatType(types: TSContexts): String =
    types.foldLeft("")(concatNumberType) match {
      case "unsigned" => "UInt"
      case s          => s
    }
}
