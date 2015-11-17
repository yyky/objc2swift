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

import org.objc2swift.ObjCParser._
import scala.collection.JavaConversions._

protected trait PropertyVisitor {
  this: ObjC2SwiftConverter =>

  object PropertyAttribute {
    def unapply(ctx: Property_attributeContext): Option[String] =
      ctx.getText match {
        case "" => None
        case s  => Some(s)
      }
  }

  override def visitProperty_declaration(ctx: Property_declarationContext): String = {
    val sb = new StringBuilder()
    val getter_setter_statement = new StringBuilder()
    val getter_statement = new StringBuilder()
    val setter_statement = new StringBuilder()
    var weak = ""
    val read_only = new StringBuilder()
    var _isOriginalGetter = false
    var _isOriginalSetter = false
    var _originalGetterStatement = ""
    var _originalSetterStatement = ""

    sb.append(indent(ctx))

    Option(ctx.property_attributes_declaration()).foreach { p =>
      p.property_attributes_list().property_attribute().foreach {
        case PropertyAttribute("weak") => weak = "weak "
        case PropertyAttribute("readonly") =>
          read_only.append(" { get{} }")
        case PropertyAttribute(s) if s.split("=")(0) == "getter" =>
          val t = parseGetterStatement(ctx, s, getter_statement)
          _isOriginalGetter = t._1
          _originalGetterStatement = t._2
        case PropertyAttribute(s) if s.split("=")(0) == "setter" =>
          val t = parseSetterStatement(ctx, s ,setter_statement)
          _isOriginalSetter = t._1
          _originalSetterStatement = t._2
        case _ =>
      }
    }

    if (_isOriginalGetter && _isOriginalSetter) {
      getter_statement.insert(0, " {\n")
      getter_statement.append("\n")
    }

    if(_isOriginalGetter && !_isOriginalSetter){
      getter_statement.insert(0, " {\n")
    }

    if(_isOriginalGetter || _isOriginalSetter){
      getter_setter_statement.append(getter_statement)
      getter_setter_statement.append(setter_statement)
      getter_setter_statement.append("\n" + indentString + "}")
    }

    Option(ctx.struct_declaration()).foreach { struct_declaration =>
      var type_of_variable = ""
      val specifier_qualifier_list = struct_declaration.specifier_qualifier_list()
      val struct_declarator_list = struct_declaration.struct_declarator_list()
      var optional = "?"

      type_of_variable = getTypeSpecifier(specifier_qualifier_list, sb)

      Option(ctx.ib_outlet_specifier()).foreach { o =>
        o.IDENTIFIER().getText match {
          case "IBOutletCollection" =>
            sb.append("@IBOutlet ")
            type_of_variable = "[" + o.class_name().getText + "]"
            optional = "!"
          case "IBOutlet" =>
            sb.append("@IBOutlet ")
            optional = "!"
          case _ =>
        }
      }

      for{
        type_specifier <- specifier_qualifier_list.type_specifier()
        protocol_reference_list <- Option(type_specifier.protocol_reference_list())
      }{
        val protocol_name = protocol_reference_list.protocol_list().protocol_name()
        weak = "weak "

        if(protocol_name.length == 1){
          type_of_variable = visit(protocol_name.head)
        }else if(protocol_name.length > 1){
          type_of_variable = setProtocolName(protocol_name)
          optional = ""
        }
      }

      for{
        list <- struct_declarator_list.struct_declarator
        direct_declarator <- Option(list.declarator.direct_declarator())
      }{
        val identifier = direct_declarator.identifier().getText

        getGetterAndSetterStatement(
          ctx,
          direct_declarator,
          _isOriginalGetter,
          _isOriginalSetter,
          read_only,
          getter_statement,
          setter_statement,
          getter_setter_statement
        )

        sb.append(s"${weak}var $identifier: $type_of_variable$optional$getter_setter_statement")
      }

    }

    sb.toString()
  }

  override def visitProperty_attributes_declaration(ctx: Property_attributes_declarationContext) =visit(ctx.property_attributes_list)
  override def visitProperty_attributes_list(ctx: Property_attributes_listContext) = {
    ctx.property_attribute().map(visit).mkString(", ")
  }
  override def visitProperty_attribute(ctx: Property_attributeContext) = ctx.getText

  private def getTypeSpecifier(ctx: Specifier_qualifier_listContext, sb: StringBuilder): String = {
    var type_of_variable = ""
    ctx.type_specifier().map(visit).foreach {
      case "IBOutlet" => sb.append("@IBOutlet ")
      case s => type_of_variable = s
    }

    type_of_variable
  }

  private def parseGetterStatement(ctx: ObjCParser.Property_declarationContext, s: String, getter_statement: StringBuilder): (Boolean, String) = {
    val getter_method_name = s.split("=")(1).replaceAll(" ","")
    val (isOriginalGetter,originalGetterStatement) = findGetterOrSetterMethod(ctx,getter_method_name)

    getter_statement.append(
      indentString * 2 + "get {\n"
        + indentString + originalGetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalGetter, originalGetterStatement)
  }

  private def parseSetterStatement(ctx: ObjCParser.Property_declarationContext, s: String, setter_statement: StringBuilder): (Boolean, String) = {
    val setter_method_name = s.split("=")(1).replaceAll(" |:","")
    val (isOriginalSetter,originalSetterStatement) = findGetterOrSetterMethod(ctx,setter_method_name)

    setter_statement.append(
      indentString * 2 + "set {\n"
        + indentString + originalSetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalSetter, originalSetterStatement)
  }

  private def setProtocolName(protocol_name: Seq[Protocol_nameContext]): String =
    s"protocol<${protocol_name.map(visit).mkString(", ")}>"

  private def getGetterAndSetterStatement(ctx:ObjCParser.Property_declarationContext,
                                  direct_declarator:Direct_declaratorContext,
                                  isOriginalGetter:Boolean,
                                  isOriginalSetter:Boolean,
                                  readOnly:StringBuilder,
                                  getterStatement:StringBuilder,
                                  setterStatement:StringBuilder,
                                  getterSetterStatement:StringBuilder) {

    val identifier = direct_declarator.identifier().getText
    val getterStr = " {\n" + indentString * 2 + "get {\n" + indentString * 3 + "return self." + identifier + "\n" + indentString * 2 + "}\n"
    val defaultSetterStr = "set" + identifier.capitalize

    //no getter and setter only
    if (!isOriginalGetter && isOriginalSetter) {
      getterSetterStatement.insert(0, getterStr)
    }

    if (!isOriginalGetter && !isOriginalSetter) {
      val (isDefaultGetter,defaultGetterStatement) = findGetterOrSetterMethod(ctx,identifier)
      val (isDefaultSetter,defaultSetterStatement) = findGetterOrSetterMethod(ctx,defaultSetterStr)

      //you dont use default getter and original getter.only readonly
      if(readOnly.toString() == " { get{} }" && !isOriginalGetter && !isDefaultGetter){
        getterSetterStatement.append(getterStr + indentString + "}")
      }

      //default getter or setter
      if (isDefaultGetter || isDefaultSetter) {
        getterSetterStatement.append(" {\n")

        if (isDefaultGetter) {
          getterStatement.append(
            indentString * 2 + "get {\n"
              + indentString + defaultGetterStatement
              + indentString * 2 + "}"
          )
        }

        if (isDefaultSetter) {
          if (!isDefaultGetter) {
            //set getter when you use only default setter
            getterStatement.append(
              indentString * 2 + "get {\n"
                + indentString * 3 + "return self." + identifier + "\n"
                + indentString * 2 + "}\n"
            )
          }
          setterStatement.append(
            indentString * 2 + "set {\n"
              + indentString + defaultSetterStatement
              + indentString * 2 + "}"
          )
        }

        //when you use both default getter and setter
        if (isDefaultGetter && isDefaultSetter) {
          getterStatement.append("\n")
        }

        getterSetterStatement.append(getterStatement)
        getterSetterStatement.append(setterStatement)
        getterSetterStatement.append("\n" + indentString + "}")
      }
    }
  }

  private def findGetterOrSetterMethod(declCtx: Property_declarationContext,selector:String):(Boolean,String) = {
    val buffer = for {
      extDclCtx <- root.external_declaration
      cl <- Option(extDclCtx.class_implementation)
      impl <- Option(cl.implementation_definition_list())
      instanceMethodDefinition = impl.instance_method_definition()
    } yield parseInstanceMethodDefinition(instanceMethodDefinition, selector)

    buffer.lastOption.getOrElse((false, ""))
  }

  private def getSetterSelectorText(ctx:Instance_method_definitionContext):String = {
    ctx.method_definition().method_selector.keyword_declarator()
      .flatMap(i => Option(i.selector.getText))
      .lastOption
      .getOrElse("")
  }

  private def getCompoundStatement(ctx:Instance_method_definitionContext):Compound_statementContext = {
    val compound = ctx.method_definition().compound_statement()
    for {
      l <- compound.statement_list()
      m <- l.statement()
      n <- Option(m.expression())
      if n.getText.startsWith("_")
    } setUSSetter(n)

    compound
  }

  private def parseInstanceMethodDefinition(instanceMethodDefinition: Seq[Instance_method_definitionContext], selector: String): (Boolean, String) = {
    val getterOrSetterStatements =
      instanceMethodDefinition.flatMap { i =>
        val setterSelectorText = getSetterSelectorText(i)
        val getterSelectorText = i.method_definition().method_selector.getText

        if (selector == setterSelectorText || selector == getterSelectorText)
          Some(visit(getCompoundStatement(i)))
        else
          None
      }

    (getterOrSetterStatements.nonEmpty, getterOrSetterStatements.mkString)
  }
}
