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
import org.antlr.v4.runtime.RuleContext
import collection.JavaConversions._

trait EnumVisitor extends Converter {

  self: ObjCBaseVisitor[String] =>

  def findDeclarationSpecifiers(ctx: RuleContext): Option[Declaration_specifiersContext] =
    ctx match {
      case c: Declaration_specifiersContext => Some(c)
      case c: Translation_unitContext => None
      case _ => findDeclarationSpecifiers(ctx.parent)
    }

  def getClassName(ctx: Declaration_specifiersContext): String =
    Option(ctx.type_specifier()) match {
      case Some(list) if list.size >= 2 =>
        Option(list(1).class_name()).map(visit).getOrElse("")
      case _ => ""
    }

  /**
   * Get name of enumerator.
   * @param ctx
   * @return
   */
  def getEnumName(ctx: Enum_specifierContext): String =
    Option(ctx.identifier()) match {
      case Some(id) => visit(id)
      case None =>
        findDeclarationSpecifiers(ctx) match {
          case Some(d) => getClassName(d)
          case None => ""
        }
    }

  override def visitEnum_specifier(ctx: Enum_specifierContext): String =
    getEnumName(ctx) match {
      case id if id != "" => visitEnum_specifier(ctx, id)
      case _ => ""
    }

  def visitEnum_specifier(ctx: Enum_specifierContext, identifier: String): String = {
    val typeStr = "Int"
    val enumeratorString = Option(ctx.enumerator_list()) match {
      case None => ""
      case Some(list) => "{\n" + visit(list) + "\n}\n"
    }

    List("enum", identifier, ":", typeStr, enumeratorString).mkString(" ")
  }

  override def visitEnumerator_list(ctx: Enumerator_listContext): String = {
    val enumeratorList = ctx.children.collect {
      case element: EnumeratorContext => indent(ctx) + visit(element)
    }
    enumeratorList.mkString("\n")
  }

  override def visitEnumerator(ctx: EnumeratorContext): String = {
    val id = visit(ctx.identifier())
    var strList = List("case " + id)

    strList = Option(ctx.constant_expression()) match {
      case None => strList
      case Some(constant) => visit(constant) :: strList
    }
    strList.reverse.mkString(" = ")
  }

}
