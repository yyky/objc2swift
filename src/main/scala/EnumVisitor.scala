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

trait EnumVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  override def visitEnum_specifier(ctx: Enum_specifierContext): String = {
    Option(ctx.identifier()) match {
      case None => ""
      case Some(name) => visitEnum_specifier(ctx, name.getText)
    }
  }

  def visitEnum_specifier(ctx: Enum_specifierContext, identifier: String): String = {
    val typeStr = "Int"
    val enumeratorString = Option(ctx.enumerator_list()) match {
      case None => ""
      case Some(list) => "{\n" + visit(list) + "}\n"
    }

    List("enum", identifier, ":", typeStr, enumeratorString).mkString(" ")
  }

  override def visitEnumerator_list(ctx: Enumerator_listContext): String = {
    val enumeratorList = ctx.children.collect {
      case element: EnumeratorContext => visit(element)
    }

    enumeratorList.mkString(indentString, ",\n" + indentString, "\n")
  }

  override def visitEnumerator(ctx: EnumeratorContext): String = {
    var strList = List("case")
    strList = ctx.identifier().getText :: strList

    Option(ctx.constant_expression()) match {
      case None =>
      case Some(constant) => strList = "= " + visit(constant) :: strList
    }

    strList.reverse.mkString(" ")
  }
}
