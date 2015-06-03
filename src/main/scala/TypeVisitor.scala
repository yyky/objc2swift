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
 * Implements visit methods for type contexts.
 */
trait TypeVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

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
    val builder = List.newBuilder[String]

    ctx.children map {
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
    } foreach { builder += _ }

    builder.result().mkString
  }

}
