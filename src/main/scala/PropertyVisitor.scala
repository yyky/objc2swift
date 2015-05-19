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
    var weak = ""
    val read_only = new StringBuilder()
    var getter_method_name = ""
    var setter_method_name = ""
    var _isOriginalGetter = false
    var _isOriginalSetter = false
    var _originalGetterStatement = ""
    var _originalSetterStatement = ""

    sb.append(indent(ctx))

    Option(ctx.property_attributes_declaration()) match {
      case None =>
      case Some(p) => {
        visit(p).split(", ").foreach { i =>
          i match {
            case s if s == "weak" => weak = "weak "
            case s if s == "readonly" => {
              read_only.append("{ get{} }")
            }
            case s if s.split("=")(0) == "getter" => {
              getter_method_name = s.split("=")(1).replaceAll(" ","")
              val (isOriginalGetter,originalGetterStatement) = findGetterOrSetterMethod(ctx,getter_method_name)
              _isOriginalGetter = isOriginalGetter
              _originalGetterStatement = originalGetterStatement

              getter_statement.append(
                indentString * 2 + "get{\n"
                + indentString + originalGetterStatement
                + indentString * 2 + "}"
              )
            }
            case s if s.split("=")(0) == "setter" => {
              setter_method_name = s.split("=")(1).replaceAll(" |:","")
              val (isOriginalSetter,originalSetterStatement) = findGetterOrSetterMethod(ctx,setter_method_name)
              _isOriginalSetter = isOriginalSetter
              _originalSetterStatement = originalSetterStatement

              setter_statement.append(
                indentString * 2 + "set{\n"
                + indentString + originalSetterStatement
                + indentString * 2 + "}"
              )
            }
            case _ =>
          }
        }
      }
    }

    if(_isOriginalGetter && _isOriginalSetter){
      getter_statement.insert(0,"{\n")
      getter_statement.append("\n")
    }

    if(_isOriginalGetter && !_isOriginalSetter){
      getter_statement.insert(0,"{\n")
    }

    if(_isOriginalGetter || _isOriginalSetter){
      getter_setter_statement.append(getter_statement)
      getter_setter_statement.append(setter_statement)
      getter_setter_statement.append("\n" + indentString + "}")
    }

    Option(ctx.struct_declaration()) match {
      case None =>
      case Some(struct_declaration) =>
        var type_of_variable = ""
        val specifier_qualifier_list = struct_declaration.specifier_qualifier_list()
        val struct_declarator_list = struct_declaration.struct_declarator_list()
        var optional = "?"

        specifier_qualifier_list.type_specifier().foreach { i =>
          visit(i) match {
            case s if s == "IBOutlet" =>
              sb.append("@" + s + " ")
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
              val getterStr = "{\n" + indentString * 2 + "get{\n" + indentString * 3 + "return self." + identifier + "\n" + indentString * 2 + "}\n"
              val defaultSetterStr = "set" + identifier.capitalize


              //no getter and only readonly
              if(read_only.toString() == "{ get{} }" && !_isOriginalGetter){
                getter_setter_statement.append(getterStr + indentString + "}")
              }

              //no getter and setter only
              if(!_isOriginalGetter && _isOriginalSetter){
                getter_setter_statement.insert(0,getterStr)
              }

              if(!_isOriginalGetter && !_isOriginalSetter){
                var (isDefaultGetter,defaultGetterStatement) = findGetterOrSetterMethod(ctx,identifier)
                var (isDefaultSetter,defaultSetterStatement) = findGetterOrSetterMethod(ctx,defaultSetterStr)
                //default getter or setter
                if (isDefaultGetter || isDefaultSetter) {
                  getter_setter_statement.append("{\n")

                  if (isDefaultGetter) {
                    getter_statement.append(
                      indentString * 2 + "get{\n"
                        + indentString + defaultGetterStatement
                        + indentString * 2 + "}"
                    )
                  }

                  if (isDefaultSetter) {
                    setter_statement.append(
                      indentString * 2 + "set{\n"
                        + indentString + defaultSetterStatement
                        + indentString * 2 + "}"
                    )
                  }

                  //when you use both default getter and setter
                  if (getter_statement.length != 0 && setter_statement.length != 0) {
                    getter_statement.append("\n")
                  }

                  getter_setter_statement.append(getter_statement)
                  getter_setter_statement.append(setter_statement)
                  getter_setter_statement.append("\n" + indentString + "}")
                }
              }

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

  def findGetterOrSetterMethod(declCtx: Property_declarationContext,selector:String):(Boolean,String) = {
    val sb = new StringBuilder()
    var isGetterOrSetterMethod = false

    for (extDclCtx <- root.external_declaration) {
      Option(extDclCtx.class_implementation) match {
        case Some(implCtx) => {
          val instanceMethodDefinition = implCtx
            .implementation_definition_list()
            .instance_method_definition()

          instanceMethodDefinition.foreach{ i =>
            val methodSelector = i.method_definition().method_selector
            var setterSelectorText = ""
            val getterSelectorText = i.method_definition().method_selector.getText

            methodSelector.keyword_declarator().foreach {j =>
              Option(j.selector.getText) match {
                case Some(k) => setterSelectorText = k
                case None =>
              }
            }

            if(selector == setterSelectorText || selector == getterSelectorText){
              val compound = i.method_definition().compound_statement()
              compound.statement_list().foreach{l =>
                l.statement().foreach{m =>
                  Option(m.expression()) match {
                    case Some(l) => {
                      if(l.getText.indexOf("_") == 0){
                        setUSSetter(m.expression())
                      }
                    }
                    case None =>
                  }
                }
              }

              isGetterOrSetterMethod = true

              sb.append(visit(compound))
            }
          }
        }
        case None =>
      }
    }

    (isGetterOrSetterMethod,sb.toString())
  }
}
