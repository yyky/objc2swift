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
    val getter_setter_statement = new StringBuilder()
    val getter_statement = new StringBuilder()
    val setter_statement = new StringBuilder()
    var property_attributes = ""
    var read_only = new StringBuilder()
    var getter_method_name = ""
    var setter_method_name = ""

    sb.append(indent(ctx))

    Option(ctx.property_attributes_declaration()) match {
      case None =>
      case Some(p) => {
        visit(p).split(", ").foreach { i =>
          i match {
            case s if s == "weak" => property_attributes = s
            case s if s == "readonly" => {
              read_only.append("{ get{} }")
            }
            case s if s.split("=")(0) == "getter" => {
              getter_method_name = s.split("=")(1).replaceAll(" ","")

              getter_statement.append(
                indentString * 2 + "get{\n"
                + indentString + findGetterMethod(ctx,getter_method_name) + "\n"
                + indentString * 2 + "}"
              )
            }
            case s if s.split("=")(0) == "setter" => {
              setter_method_name = s.split("=")(1).replaceAll(" |:","")

              setter_statement.append(
                indentString * 2 + "set{\n"
                + indentString + findGetterMethod(ctx,setter_method_name) + "\n"
                + indentString * 2 + "}"
              )
            }
            case _ =>
          }
        }
      }
    }

    if(getter_statement.length != 0 && setter_statement.length != 0) {
      getter_statement.append("\n")
    }

    if(getter_statement.length != 0 || setter_statement.length != 0) {
      getter_statement.insert(0,"{\n")
      getter_setter_statement.append(getter_statement)
      getter_setter_statement.append(setter_statement)
      getter_setter_statement.append("\n" + indentString + "}")
    }

    if(read_only.toString() == "{ get{} }" && getter_statement.length == 0){
      getter_setter_statement.append(read_only.toString())
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
              sb.append(weak + "var " + identifier + ":" + type_of_variable + optional + getter_setter_statement)
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

  def findGetterMethod(declCtx: Property_declarationContext,selector:String):String = {
    val sb = new StringBuilder()


    for (extDclCtx <- root.external_declaration) {
      Option(extDclCtx.class_implementation) match {
        case Some(implCtx) => {
          val instanceMethodDefinition = implCtx
            .implementation_definition_list()
            .instance_method_definition()

          instanceMethodDefinition.foreach{ i =>
            var methodSelector = i.method_definition().method_selector
            var setterSelectorText = ""
            var getterSelectorText = i.method_definition().method_selector.getText

            methodSelector.keyword_declarator().foreach {j =>
              Option(j.selector.getText) match {
                case Some(k) => setterSelectorText = k
                case None =>
              }
            }

            if(selector == setterSelectorText || selector == getterSelectorText){
              val compound = i.method_definition().compound_statement()

              sb.append(visit(compound))
            }
          }
        }
        case None =>
      }
    }

    sb.toString()
  }
}
