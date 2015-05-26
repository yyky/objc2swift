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
    var sb = new StringBuilder()
    var getter_setter_statement = new StringBuilder()
    var getter_statement = new StringBuilder()
    var setter_statement = new StringBuilder()
    var weak = ""
    val read_only = new StringBuilder()
    var _isOriginalGetter = false
    var _isOriginalSetter = false
    var _originalGetterStatement = ""
    var _originalSetterStatement = ""

    sb.append(indent(ctx))

    Option(ctx.property_attributes_declaration()) match {
      case None =>
      case Some(p) =>
        visit(p).split(", ").foreach {
          case s if s == "weak" => weak = "weak "
          case s if s == "readonly" =>
            read_only.append("{ get{} }")
          case s if s.split("=")(0) == "getter" =>
            val t = parseGetterStatement(ctx,s,getter_statement)
            _isOriginalGetter = t._1
            _originalGetterStatement = t._2
            getter_statement = t._3
          case s if s.split("=")(0) == "setter" =>
            val t = parseSetterStatement(ctx,s,setter_statement)
            _isOriginalSetter = t._1
            _originalSetterStatement = t._2
            setter_statement = t._3
          case _ =>
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

        Option(ctx.ib_outlet_specifier()).foreach { o =>
          o.IDENTIFIER().getText match {
              /*
            case "IBOutletCollection" =>
              sb.append("@IBOutlet " + property_attributes + " ")
              optional = "!"
              */
            case "IBOutlet" =>
              //sb.append("@IBOutlet " + property_attributes + " ")
              sb.append("@IBOutlet ")
              optional = "!"
            case s if !s.isEmpty =>
              // TODO: Implement appropriately
              //sb.append("@" + s + " " + property_attributes + " ")
              sb.append("@" + s + " ")
              optional = "!"
            case _ =>
          }
        }

        val t = getTypeSpecifier(specifier_qualifier_list,sb)
        type_of_variable = t._1
        sb = t._2

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

          getter_setter_statement = getGetterAndSetterStatement(
            ctx,
            direct_declarator,
            _isOriginalGetter,
            _isOriginalSetter,
            read_only,
            getter_statement,
            setter_statement,
            getter_setter_statement
          )

          sb.append(weak + "var " + identifier + ":" + type_of_variable + optional + getter_setter_statement)
        }

    }

    sb.toString()
  }

  override def visitProperty_attributes_declaration(ctx: Property_attributes_declarationContext) =visit(ctx.property_attributes_list)
  override def visitProperty_attributes_list(ctx: Property_attributes_listContext) = {
    ctx.property_attribute().map(visit).mkString(", ")
  }
  override def visitProperty_attribute(ctx: Property_attributeContext) = ctx.getText

  def getTypeSpecifier(ctx:Specifier_qualifier_listContext,sb:StringBuilder):(String,StringBuilder) = {
    var type_of_variable = ""
    ctx.type_specifier().foreach { i =>
      visit(i) match {
        case s if s == "IBOutlet" =>
          sb.append("@" + s + " ")
        case s =>
          type_of_variable = s
      }
    }

    (type_of_variable,sb)
  }

  def parseGetterStatement(ctx:ObjCParser.Property_declarationContext,s:String,getter_statement:StringBuilder):(Boolean,String,StringBuilder) = {
    val getter_method_name = s.split("=")(1).replaceAll(" ","")
    val (isOriginalGetter,originalGetterStatement) = findGetterOrSetterMethod(ctx,getter_method_name)

    getter_statement.append(
      indentString * 2 + "get{\n"
        + indentString + originalGetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalGetter,originalGetterStatement,getter_statement)
  }

  def parseSetterStatement(ctx:ObjCParser.Property_declarationContext,s:String,setter_statement:StringBuilder):(Boolean,String,StringBuilder) = {
    val setter_method_name = s.split("=")(1).replaceAll(" |:","")
    val (isOriginalSetter,originalSetterStatement) = findGetterOrSetterMethod(ctx,setter_method_name)

    setter_statement.append(
      indentString * 2 + "set{\n"
        + indentString + originalSetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalSetter,originalSetterStatement,setter_statement)
  }

  def setProtocolName(protocol_name:scala.collection.mutable.Buffer[Protocol_nameContext]): String ={
    var protocol_names = ""
    protocol_name.foreach (
      protocol_names += visit(_) + ","
    )
    "protocol<" + protocol_names.stripSuffix(",") + ">"
  }

  def getGetterAndSetterStatement(ctx:ObjCParser.Property_declarationContext,
                                  direct_declarator:Direct_declaratorContext,
                                  isOriginalGetter:Boolean,
                                  isOriginalSetter:Boolean,
                                  readOnly:StringBuilder,
                                  getterStatement:StringBuilder,
                                  setterStatement:StringBuilder,
                                  getterSetterStatement:StringBuilder):StringBuilder = {

    val identifier = direct_declarator.identifier().getText
    val getterStr = "{\n" + indentString * 2 + "get{\n" + indentString * 3 + "return self." + identifier + "\n" + indentString * 2 + "}\n"
    val defaultSetterStr = "set" + identifier.capitalize

    //no getter and only readonly
    if(readOnly.toString() == "{ get{} }" && !isOriginalGetter){
      getterSetterStatement.append(getterStr + indentString + "}")
    }

    //no getter and setter only
    if(!isOriginalGetter && isOriginalSetter){
      getterSetterStatement.insert(0,getterStr)
    }

    if(!isOriginalGetter && !isOriginalSetter){
      val (isDefaultGetter,defaultGetterStatement) = findGetterOrSetterMethod(ctx,identifier)
      val (isDefaultSetter,defaultSetterStatement) = findGetterOrSetterMethod(ctx,defaultSetterStr)
      //default getter or setter
      if (isDefaultGetter || isDefaultSetter) {
        getterSetterStatement.append("{\n")

        if (isDefaultGetter) {
          getterStatement.append(
            indentString * 2 + "get{\n"
              + indentString + defaultGetterStatement
              + indentString * 2 + "}"
          )
        }

        if (isDefaultSetter) {
          if (!isDefaultGetter) {
            //set getter when you use only default setter
            getterStatement.append(
              indentString * 2 + "get{\n"
                + indentString * 3 + "return self." + identifier + "\n"
                + indentString * 2 + "}\n"
            )
          }
          setterStatement.append(
            indentString * 2 + "set{\n"
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

    getterSetterStatement
  }

  def findGetterOrSetterMethod(declCtx: Property_declarationContext,selector:String):(Boolean,String) = {
    var _str = ""
    var _isGetterOrSetterMethod = false

    val buffer = for {
      extDclCtx <- root.external_declaration
      cl <- Option(extDclCtx.class_implementation)
      instanceMethodDefinition = cl.implementation_definition_list().instance_method_definition()
    } yield parseInstanceMethodDefinition(instanceMethodDefinition,selector)

    buffer.map(t => {
      _isGetterOrSetterMethod = t._1
      _str = t._2
    })

    (_isGetterOrSetterMethod,_str)
  }

  def getSetterSelectorText(ctx:Instance_method_definitionContext):String = {
    val methodSelector = ctx.method_definition().method_selector
    var setterSelectorText = ""
    methodSelector.keyword_declarator().foreach {j =>
      Option(j.selector.getText) match {
        case Some(k) => setterSelectorText = k
        case None =>
      }
    }

    setterSelectorText
  }

  def getCompoundStatement(ctx:Instance_method_definitionContext):Compound_statementContext = {
    val compound = ctx.method_definition().compound_statement()
    compound.statement_list().foreach{l =>
      l.statement().foreach{m =>
        Option(m.expression()) match {
          case Some(n) =>
            if(n.getText.indexOf("_") == 0){
              setUSSetter(m.expression())
            }
          case None =>
        }
      }
    }

    compound
  }

  def parseInstanceMethodDefinition(instanceMethodDefinition:scala.collection.mutable.Buffer[Instance_method_definitionContext],selector:String):(Boolean,String) = {
    val sb = new StringBuilder()
    var isGetterOrSetterMethod = false

    instanceMethodDefinition.foreach{ i =>
      var setterSelectorText = ""
      val getterSelectorText = i.method_definition().method_selector.getText

      setterSelectorText = getSetterSelectorText(i)

      if(selector == setterSelectorText || selector == getterSelectorText){
        val compound = getCompoundStatement(i)

        isGetterOrSetterMethod = true

        sb.append(visit(compound))
      }
    }

    (isGetterOrSetterMethod,sb.toString())
  }
}