/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift

import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._

/**
 * Implements visit methods for type contexts.
 */
protected trait TypeVisitor extends BaseConverter {
  /**
   * Returns translated text of type_specifier context.
   *
   * @param ctx the parse tree
   * @return Swift type strings
   *
   * TODO: Implement other types
   *
   */
  override def visitType_specifier(ctx: Type_specifierContext): String = {
    ctx.children.map {
      case TerminalText("void")           => "void"
      case TerminalText("id")             => "AnyObject"
      case TerminalText("short")          => "Int8"
      case TerminalText("int")            => "Int"
      case TerminalText("long")           => "Int"
      case TerminalText("float")          => "Float"
      case TerminalText("double")         => "Double"
      case TerminalText(s) if !s.isEmpty  => s
      case _: TerminalNode                => "AnyObject"
      case ClassNameText("NSInteger")     => "Int"
      case ClassNameText("NSUInteger")    => "UInt"
      case ClassNameText("NSArray")       => "[AnyObject]"
      case ClassNameText("NSDictionary")  => "[NSObject: AnyObject]"
      case ClassNameText("SEL")           => "Selector"
      case ClassNameText("BOOL")          => "Bool"
      case ClassNameText(s) if !s.isEmpty => s
      case _: Class_nameContext           => "AnyObject"
      case c: PointerContext              => visit(c)
      case c                              => c.getText
    }.mkString
  }

  /**
   * Returns concatenated number type text.
   * @param prefix Prefix text of current types.
   * @param ctx Current type_specifier context
   * @return Concatenated and translated number type text
   */
  private def concatNumberType(prefix: String, ctx: Type_specifierContext): String =
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
   * @param types List of type_specifier context
   * @return Concatenated and translated type text
   */
  def concatType(types: TSContexts): String =
    types.foldLeft("")(concatNumberType) match {
      case "unsigned" => "UInt"
      case s          => s
    }
}
