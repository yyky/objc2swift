/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift.converter

import org.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

trait PropertyVisitor {
  this: ObjC2SwiftBaseConverter with RootVisitor =>

  object PropertyAttribute {
    def unapply(ctx: PropertyAttributeContext): Option[String] =
      ctx.getText match {
        case "" => None
        case s  => Some(s)
      }
  }

  override def visitPropertyDeclaration(ctx: PropertyDeclarationContext): String = {
    val sb = new StringBuilder()
    val getterSetterStatement = new StringBuilder()
    val getterStatement = new StringBuilder()
    val setterStatement = new StringBuilder()
    var weak = ""
    val readOnly = new StringBuilder()
    var IsOriginalGetter = false
    var IsOriginalSetter = false
    var OriginalGetterStatement = ""
    var OriginalSetterStatement = ""

    ctx.propertyAttributesDeclaration().foreach { p =>
      p.propertyAttributesList().get.propertyAttribute().foreach {
        case PropertyAttribute("weak") => weak = "weak "
        case PropertyAttribute("readonly") =>
          readOnly.append(" { get{} }")
        case PropertyAttribute(s) if s.split("=")(0) == "getter" =>
          val t = parseGetterStatement(ctx, s, getterStatement)
          IsOriginalGetter = t._1
          OriginalGetterStatement = t._2
        case PropertyAttribute(s) if s.split("=")(0) == "setter" =>
          val t = parseSetterStatement(ctx, s ,setterStatement)
          IsOriginalSetter = t._1
          OriginalSetterStatement = t._2
        case _ =>
      }
    }

    if (IsOriginalGetter && IsOriginalSetter) {
      getterStatement.insert(0, " {\n")
      getterStatement.append("\n")
    }

    if(IsOriginalGetter && !IsOriginalSetter){
      getterStatement.insert(0, " {\n")
    }

    if(IsOriginalGetter || IsOriginalSetter){
      getterSetterStatement.append(getterStatement)
      getterSetterStatement.append(setterStatement)
      getterSetterStatement.append("\n" + indentString + "}")
    }

    ctx.structDeclaration().foreach { structDeclaration =>
      var typeOfVariable = ""
      val specifierQualifierList = structDeclaration.specifierQualifierList().get
      val structDeclaratorList = structDeclaration.structDeclaratorList().get
      var optional = ""

      typeOfVariable = getTypeSpecifier(specifierQualifierList, sb)

      ctx.ibOutletSpecifier().foreach { o =>
        o.IDENTIFIER().get.getText match {
          case "IBOutletCollection" =>
            sb.append("@IBOutlet ")
            typeOfVariable = "[" + o.className().get.getText + "]"
            optional = "!"
          case "IBOutlet" =>
            sb.append("@IBOutlet ")
            optional = "!"
          case _ =>
        }
      }

      for{
        typeSpecifier <- specifierQualifierList.typeSpecifier()
        protocolReferenceList <- typeSpecifier.protocolReferenceList()
      }{
        val protocolName = protocolReferenceList.protocolList().get.protocolName()
        weak = "weak "

        if(protocolName.length == 1){
          typeOfVariable = visit(protocolName.head)
        }else if(protocolName.length > 1){
          typeOfVariable = setProtocolName(protocolName)
          optional = ""
        }
      }

      for{
        list <- structDeclaratorList.structDeclarator()
        directDeclarator <- list.declarator().flatMap(_.directDeclarator())
      }{
        val identifier = directDeclarator.identifier().get.getText

        getGetterAndSetterStatement(
          ctx,
          directDeclarator,
          IsOriginalGetter,
          IsOriginalSetter,
          readOnly,
          getterStatement,
          setterStatement,
          getterSetterStatement
        )

        sb.append(s"${weak}var $identifier: $typeOfVariable$optional$getterSetterStatement")
      }

    }

    sb.toString()
  }

  override def visitPropertyAttributesDeclaration(ctx: PropertyAttributesDeclarationContext) = visit(ctx.propertyAttributesList().get)
  override def visitPropertyAttributesList(ctx: PropertyAttributesListContext) = {
    ctx.propertyAttribute().map(visit).mkString(", ")
  }
  override def visitPropertyAttribute(ctx: PropertyAttributeContext) = ctx.getText

  private def getTypeSpecifier(ctx: SpecifierQualifierListContext, sb: StringBuilder): String = {
    var typeOfVariable = ""
    ctx.typeSpecifier().map(visit).foreach {
      case "IBOutlet" => sb.append("@IBOutlet ")
      case s => typeOfVariable = s
    }

    typeOfVariable
  }

  private def parseGetterStatement(ctx: ObjCParser.PropertyDeclarationContext, s: String, getterStatement: StringBuilder): (Boolean, String) = {
    val getterMethodName = s.split("=")(1).replaceAll(" ","")
    val (isOriginalGetter,originalGetterStatement) = findGetterOrSetterMethod(ctx,getterMethodName)

    getterStatement.append(
      indentString * 2 + "get {\n"
        + indentString + originalGetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalGetter, originalGetterStatement)
  }

  private def parseSetterStatement(ctx: ObjCParser.PropertyDeclarationContext, s: String, setterStatement: StringBuilder): (Boolean, String) = {
    val setterMethodName = s.split("=")(1).replaceAll(" |:","")
    val (isOriginalSetter,originalSetterStatement) = findGetterOrSetterMethod(ctx,setterMethodName)

    setterStatement.append(
      indentString * 2 + "set {\n"
        + indentString + originalSetterStatement
        + indentString * 2 + "}"
    )

    (isOriginalSetter, originalSetterStatement)
  }

  private def setProtocolName(protocolName: Seq[ProtocolNameContext]): String =
    s"protocol<${protocolName.map(visit).mkString(", ")}>"

  private def getGetterAndSetterStatement(ctx:ObjCParser.PropertyDeclarationContext,
                                  directDeclarator:DirectDeclaratorContext,
                                  isOriginalGetter:Boolean,
                                  isOriginalSetter:Boolean,
                                  readOnly:StringBuilder,
                                  getterStatement:StringBuilder,
                                  setterStatement:StringBuilder,
                                  getterSetterStatement:StringBuilder) {

    val identifier = directDeclarator.identifier().get.getText
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

  private def findGetterOrSetterMethod(declCtx: PropertyDeclarationContext,selector:String):(Boolean,String) = {
    // TODO fix this
    if(root == null) {
      return (false, "")
    }

    val buffer = for {
      extDclCtx <- root.externalDeclaration()
      cl <- extDclCtx.classImplementation()
      impl <- cl.implementationDefinitionList()
      instanceMethodDefinition = impl.instanceMethodDefinition()
    } yield parseInstanceMethodDefinition(instanceMethodDefinition, selector)

    buffer.lastOption.getOrElse((false, ""))
  }

  private def getSetterSelectorText(ctx:InstanceMethodDefinitionContext):String = {
    ctx.methodDefinition().get.methodSelector().get.keywordDeclarator()
      .map(i => i.selector.get.getText)
      .lastOption
      .getOrElse("")
  }

  private def getCompoundStatement(ctx:InstanceMethodDefinitionContext):CompoundStatementContext = ctx.methodDefinition().get.compoundStatement().get

  private def parseInstanceMethodDefinition(instanceMethodDefinition: Seq[InstanceMethodDefinitionContext], selector: String): (Boolean, String) = {
    val getterOrSetterStatements =
      instanceMethodDefinition.flatMap { i =>
        val setterSelectorText = getSetterSelectorText(i)
        val getterSelectorText = i.methodDefinition().get.methodSelector().get.getText

        if (selector == setterSelectorText || selector == getterSelectorText) {
          setVisited(i)
          Some(visit(getCompoundStatement(i)))
        }
        else
          None
      }

    (getterOrSetterStatements.nonEmpty, getterOrSetterStatements.mkString)
  }
}
