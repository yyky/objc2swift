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

trait TypeVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  /**
   * Convert Objective-C type to Swift type.
   *
   * @param ctx the parse tree
   * @return Swift type strings
   *
   * TODO: Implement other types
   *
   */
  override def visitType_specifier(ctx: Type_specifierContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      sb.append(element match {
        case TerminalText("void") => "void"
        case TerminalText("id") => "AnyObject"
        case TerminalText("short") => "Int8"
        case TerminalText("int") => "Int32"
        case TerminalText("long") => "Int32"
        case TerminalText("float") => "Float"
        case TerminalText("double") => "Double"
        case TerminalText(s) if s != "" => s
        case _: TerminalNode => "AnyObject"
        case className: Class_nameContext =>
          className.getText match {
            case "NSInteger" => "Int32"
            case "NSUInteger" => "UInt32"
            case "NSArray" => "[AnyObject]"
            case "NSDictionary" => "[NSObject : AnyObject]"
            case "SEL" => "Selector"
            case "BOOL" => "Bool"
            case s if s != "" => s
            case _ => "AnyObject"
          }
        case pointer: PointerContext => visit(pointer)
        case _ => element.getText
      })
    }

    sb.toString()
  }

}
