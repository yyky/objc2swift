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
      case Some(property_attributes_declaration) =>
        property_attributes_declaration.property_attributes_list().property_attribute().foreach (
          visit(_) match {
            case s if s == "weak" => property_attributes = s
            case s if s == "readonly" => read_only = "{ get{} }"
            case _ =>
          }
        )
    }

    Option(ctx.struct_declaration()) match {
      case None =>
      case Some(struct_declaration) =>
        var type_of_variable = ""
        val specifier_qualifier_list = struct_declaration.specifier_qualifier_list()
        val struct_declarator_list = struct_declaration.struct_declarator_list()
        var unowned_unsafe = ""
        var optional = "?"

        specifier_qualifier_list.type_specifier().foreach { i =>
          type_of_variable = visit(i)

          Option(i.protocol_reference_list()) match {
            case None =>
            case Some(protocol_reference_list) =>
              val protocol_name = protocol_reference_list.protocol_list().protocol_name()
              unowned_unsafe = "unowned(unsafe) "

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

        Option(ctx.ib_outlet_specifier()).foreach { o =>
          o.IDENTIFIER().getText match {
              /*
            case "IBOutletCollection" =>
              sb.append("@IBOutlet " + property_attributes + " ")
              optional = "!"
              */
            case "IBOutlet" =>
              sb.append("@IBOutlet " + property_attributes + " ")
              optional = "!"
            case s if !s.isEmpty =>
              // TODO: Implement appropriately
              sb.append("@" + s + " " + property_attributes + " ")
              optional = "!"
            case _ =>
          }
        }

        struct_declarator_list.struct_declarator.foreach { j =>
          Option(j.declarator.direct_declarator()) match {
            case None =>
            case Some(direct_declarator) =>
              val identifier = direct_declarator.identifier().getText
              sb.append(unowned_unsafe + "var " + identifier + ":" + type_of_variable + optional + read_only)
          }
        }
    }

    sb.toString()
  }

  override def visitProperty_attribute(ctx: Property_attributeContext) = ctx.getText
}
