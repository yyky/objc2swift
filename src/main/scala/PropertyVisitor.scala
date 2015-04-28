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

trait PropertyVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  override def visitProperty_declaration(ctx: ObjCParser.Property_declarationContext): String = {
    val sb = new StringBuilder()
    var property_attributes = ""
    var read_only = ""

    sb.append(indent(ctx))

    Option(ctx.property_attributes_declaration()) match {
      case None =>
      case Some(p) =>
        visit(p) match {
          case s if s == "weak" => property_attributes = s
          case s if s == "readonly" => read_only = "{ get{} }"
          case _ =>
        }
    }

    Option(ctx.struct_declaration()) match {
      case None =>
      case Some(struct_declaration) =>
        var type_of_variable = ""
        val specifier_qualifier_list = struct_declaration.specifier_qualifier_list()
        val struct_declarator_list = struct_declaration.struct_declarator_list()
        var weak = ""
        var optional = "?"

        specifier_qualifier_list.type_specifier().foreach { i =>
          visit(i) match {
            case s if s == "IBOutlet" =>
              sb.append("@" + s + " " + property_attributes + " ")
            case s =>
              type_of_variable = s
          }

          Option(i.protocol_reference_list()) match {
            case None =>
            case Some(protocol_reference_list) =>
              val protocol_name = protocol_reference_list.protocol_list().protocol_name()
              weak = "weak "

              if(protocol_name.length == 1){
                type_of_variable = visit(protocol_name.head)
              }else if(protocol_name.length > 1){
                var protocol_names = ""
                protocol_name.foreach (
                  protocol_names += visit(_) + ","
                )
                type_of_variable = "protocol<" + protocol_names.stripSuffix(",") + ">"
                optional = ""
              }
          }
        }

        struct_declarator_list.struct_declarator.foreach { j =>
          Option(j.declarator.direct_declarator()) match {
            case None =>
            case Some(direct_declarator) =>
              val identifier = direct_declarator.identifier().getText
              sb.append(weak + "var " + identifier + ":" + type_of_variable + optional + read_only)
          }
        }
    }

    sb.toString()
  }

  override def visitProperty_attributes_declaration(ctx: Property_attributes_declarationContext) =visit(ctx.property_attributes_list)
  override def visitProperty_attributes_list(ctx: Property_attributes_listContext) = {
    ctx.property_attribute().map(visit).mkString(", ")
  }
  override def visitProperty_attribute(ctx: Property_attributeContext) = ctx.getText
}
