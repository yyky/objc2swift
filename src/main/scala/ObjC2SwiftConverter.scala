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
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import collection.JavaConversions._

class ObjC2SwiftConverter extends ObjCBaseVisitor[String] {
  val properties = new ParseTreeProperty[String]()

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = for(i <- 0 until node.getChildCount) yield node.getChild(i)
    return concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String = {
    val sb = new StringBuilder()
    for(node <- nodes) {
      if(sb.length > 0)
        sb.append(glue)

      val r = visit(node)
      if(r != null)
        sb.append(r)
    }
    return sb.toString
  }

  //
  // TODO: Convert to Swift's Type
  //
  // Supported type:
  //   id           => AnyObject
  //   (signed) int => Int
  //   unsigned int => UInt
  //
  def convertTypeName(ctx: ObjCParser.Type_nameContext): String = {
    val defaultType = "AnyObject"
    Option(ctx.specifier_qualifier_list().type_specifier()) match {
      case None => defaultType
      case Some(contexts) =>
        val type_specifier_ctxs: collection.mutable.Buffer[ObjCParser.Type_specifierContext] = contexts
        type_specifier_ctxs.foldLeft(defaultType)((type_str, context) => {
          context.getText match {
            case "id" => defaultType
            case "void" => ""
            case "unsigned" => "unsigned"
            case "int" if type_str == "unsigned" => "UInt"
            case "int" => "Int"
            case _ => type_str
          }
        })
    }
  }

  def convertParameter(sb: StringBuilder, ctx: ObjCParser.Keyword_declaratorContext): StringBuilder = {
    // Parameter name.
    sb.append(ctx.IDENTIFIER() + ": ")

    // Parameter type.
    sb.append(Option(ctx.method_type()) match {
      case None => "AnyObject" // Type is not specified.
      case Some(contexts) =>
        // TODO: Convert to Swift's Type
        convertTypeName(contexts.get(0).type_name) match {
          case s if s != "" => s
          case _ => "" // Syntax error?
        }
    })
  }

  override def visitTranslation_unit(ctx: ObjCParser.Translation_unitContext): String = {
    return concatChildResults(ctx, "\n")
  }

  override def visitExternal_declaration(ctx: ObjCParser.External_declarationContext): String = {
    return concatChildResults(ctx, "\n")
  }

  override def visitClass_interface(ctx: ObjCParser.Class_interfaceContext): String = {
    val sb = new StringBuilder()
    sb.append("class " + ctx.class_name.getText())

    if(ctx.superclass_name() != null) {
      sb.append(" : ")
      sb.append(ctx.superclass_name().getText())
    }
    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[ObjCParser.Protocol_nameContext])
        .map(_.getText)
      sb.append(", " + protocols.mkString(", "))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      val result = visit(ctx.interface_declaration_list())
      if(result != null) {
        sb.append(result)
      }
    }

    sb.append("\n}\n\n")

    return sb.toString()
  }

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    val sb = new StringBuilder()
    sb.append("extension " + ctx.class_name.getText())

    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[ObjCParser.Protocol_nameContext])
        .map(_.getText)
      sb.append(" : " + protocols.mkString(", "))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      val result = visit(ctx.interface_declaration_list())
      if(result != null) {
        sb.append(result)
        sb.append("\n")
      }
    }

    sb.append("}")

    return sb.toString()
  }

  override def visitInterface_declaration_list(ctx: ObjCParser.Interface_declaration_listContext): String = {
    concatChildResults(ctx, "\n")
  }

  override def visitProperty_declaration(ctx: ObjCParser.Property_declarationContext): String = {
    val sb = new StringBuilder()
    var type_of_variable = ""
    var property_attributes = ""

    if (ctx.property_attributes_declaration() != null) {
      ctx.property_attributes_declaration().property_attributes_list().property_attribute().foreach { k =>
        if (k.getText() == "weak" || k.getText == "strong") {
          property_attributes = k.getText()
        }
      }
    }

    if (ctx.struct_declaration() != null) {
      val specifier_qualifier_list = ctx.struct_declaration().specifier_qualifier_list()
      val struct_declarator_list = ctx.struct_declaration().struct_declarator_list()

      specifier_qualifier_list.type_specifier().foreach { i =>
        val class_name = i.class_name.getText()
        if (class_name == "IBOutlet") {
          sb.append("\t@" + class_name + " " + property_attributes + " ")
        } else {
          type_of_variable = class_name
        }
      }

      struct_declarator_list.struct_declarator.foreach { j =>
        val direct_declarator = j.declarator.direct_declarator()
        if (direct_declarator != null) {
          val identifier = direct_declarator.identifier().getText()
          sb.append("var " + identifier + ":" + type_of_variable + "!")
        }
      }
    }

    return sb.toString()
  }

  override def visitInstance_method_declaration(ctx: ObjCParser.Instance_method_declarationContext): String = {

    val sb = new StringBuilder()

    sb.append("    func ")

    val method_declaration_ctx: ObjCParser.Method_declarationContext = ctx.method_declaration()

    //
    // Method name.
    //
    val method_selector_ctx: ObjCParser.Method_selectorContext = method_declaration_ctx.method_selector()

    Option(method_selector_ctx.selector()) match {
      case Some(c) => sb.append(c.getText + "()") // No parameter.
      case None    =>
        Option(method_selector_ctx.keyword_declarator(0).selector()) match {
          case None => // Syntax error? No method name.
          case Some(c) =>
            // Has parameters.
            sb.append(c.getText + "(")
            method_selector_ctx.keyword_declarator().zipWithIndex.foreach {
              case (c: ObjCParser.Keyword_declaratorContext, 0) => convertParameter(sb, c)
              case (c: ObjCParser.Keyword_declaratorContext, i) => convertParameter(sb.append(", "), c)
            }
            sb.append(")")
        }
    }

    //
    // Method type.
    //
    // TODO: Convert to Swift's Type
    //
    // Supported type:
    //   (signed) int => Int
    //   unsigned int => UInt
    //
    val type_name_ctx: ObjCParser.Type_nameContext = method_declaration_ctx.method_type().type_name()

    convertTypeName(type_name_ctx) match {
      case s if s != "" => sb.append(" -> " + s)
      case _ => // No return type
    }

    sb.append(" {\n")

    //
    // TODO: Implement method's body
    //

    sb.append("    }")

    sb.toString()

  }

}
