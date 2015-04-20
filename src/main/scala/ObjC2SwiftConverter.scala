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

class ObjC2SwiftConverter(_root: Translation_unitContext) extends ObjCBaseVisitor[String] {
  val root = _root
  val visited = new ParseTreeProperty[Boolean]()

  def getResult: String = {
    visit(root)
  }

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = for(i <- 0 until node.getChildCount) yield node.getChild(i)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String = {
    nodes.map(visit(_)).filter(_ != null).mkString(glue)
  }

  def indentLevel(node: ParserRuleContext): Int = {
    node.depth() match {
      case n if (n < 4) => 0 // class
      case n if (n < 8) => 1 // method
      case _ => 2 // TODO count number of compound_statement's
    }
  }

  def indent(node: ParserRuleContext): String = {
    "    " * indentLevel(node)
  }

  //
  // TODO: Convert to Swift's Type
  //
  // Supported type:
  //   id           => AnyObject
  //   (signed) int => Int
  //   unsigned int => UInt
  //
  def convertTypeName(ctx: Type_nameContext): String = {
    val defaultType = "AnyObject"
    Option(ctx.specifier_qualifier_list().type_specifier()) match {
      case None => defaultType
      case Some(contexts) =>
        val type_specifier_ctxs: collection.mutable.Buffer[Type_specifierContext] = contexts
        type_specifier_ctxs.foldLeft(defaultType)((s, type_specifier_ctx) => {
          visit(type_specifier_ctx) match {
            case "Int" if s == "unsigned" => "UInt"
            case "Int" if s == "UInt" => "UInt"
            case t if t != "" => t
            case _ => s
          }
        })
    }
  }

  def convertParameter(sb: StringBuilder, ctx: Keyword_declaratorContext): StringBuilder = {
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

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Class_implementationContext = {
    val list = root.external_declaration
    for (extDclCtx <- list) {
      for (ctx <- extDclCtx.children if ctx.isInstanceOf[Class_implementationContext]) {
        val implCtx = ctx.asInstanceOf[Class_implementationContext]
        if(implCtx.class_name.getText == classCtx.class_name.getText)
          return implCtx
      }
    }

    null
  }

  def findCorrespondingMethodDefinition(declCtx: Instance_method_declarationContext): Option[Instance_method_definitionContext] = {
    val classCtx = declCtx.parent.parent.asInstanceOf[Class_interfaceContext]
    val implCtx = findCorrespondingClassImplementation(classCtx)
    if (implCtx == null) {
      return None
    }

    for (ctx <- implCtx.implementation_definition_list.children if ctx.isInstanceOf[Instance_method_definitionContext]) {
      val defCtx = ctx.asInstanceOf[Instance_method_definitionContext]
      if(defCtx.method_definition.method_selector.getText == declCtx.method_declaration.method_selector.getText) {
        return Some(defCtx)
      }
    }

    None

  }

  override def visitTranslation_unit(ctx: Translation_unitContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitExternal_declaration(ctx: External_declarationContext): String = {
    concatChildResults(ctx, "\n\n")
  }

  override def visitClass_interface(ctx: Class_interfaceContext): String = {
    val sb = new StringBuilder()
    sb.append("class " + ctx.class_name.getText)

    if(ctx.superclass_name() != null) {
      sb.append(" : ")
      sb.append(ctx.superclass_name().getText)
    }
    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[Protocol_nameContext])
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

    val implCtx = findCorrespondingClassImplementation(ctx)
    if(implCtx != null) {
      val result = visit(implCtx.implementation_definition_list)
      if(result != null) {
        sb.append(result)
      }
    }

    sb.append("}")

    sb.toString()
  }

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    val sb = new StringBuilder()
    sb.append("extension " + ctx.class_name.getText)

    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[Protocol_nameContext])
        .map(_.getText)
      sb.append(" : " + protocols.mkString(", "))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      val result = visit(ctx.interface_declaration_list())
      if(result != null) {
        sb.append(result)
      }
    }
    sb.append("}")

    sb.toString()
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext): String = {
    concatChildResults(ctx, "\n")
  }

  /**
   * Convert instance method declaration(interface) in Objective-C to Swift code.
   *
   * @param ctx the parse tree
   * @return Strings of Swift code
   **/
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String = {

    val sb = new StringBuilder()

    sb.append(indent(ctx) + "func")

    val method_declaration_ctx: Method_declarationContext = ctx.method_declaration()

    //
    // Method name.
    //
    val method_selector_ctx: Method_selectorContext = method_declaration_ctx.method_selector()

    Option(method_selector_ctx.selector()) match {
      case Some(c) => sb.append(" " + c.getText + "()") // No parameter.
      case None    =>
        Option(method_selector_ctx.keyword_declarator(0).selector()) match {
          case None => // Syntax error? No method name.
          case Some(c) =>
            // Has parameters.
            sb.append(" " + c.getText + "(")
            method_selector_ctx.keyword_declarator().zipWithIndex.foreach {
              case (c: Keyword_declaratorContext, 0) => convertParameter(sb, c)
              case (c: Keyword_declaratorContext, i) => convertParameter(sb.append(", "), c)
            }
            sb.append(")")
        }
    }

    //
    // Method type.
    //
    // Currently, supported type:
    //   id => AnyObject
    //   (signed) int => Int
    //   unsigned int => UInt
    //
    // TODO: Convert to Swift's Type
    //   char (char *), float, double, NSObject, etc..
    //
    sb.append(Option(method_declaration_ctx.method_type()) match {
      case Some(method_type_ctx) => visit(method_type_ctx)
      case _ => " -> AnyObject" // id type
    })

    sb.append(" {\n")

    findCorrespondingMethodDefinition(ctx) match {
      case None =>
      case Some(impl) =>
        visited.put(impl, true)
        sb.append(visit(impl.method_definition.compound_statement))
    }

    sb.append(indent(ctx) + "}\n")

    sb.toString()
  }

  /**
   * Return method type as Swift rule.
   *
   * @param ctx the parse tree
   * @return Swift method type
   **/
  override def visitMethod_type(ctx: Method_typeContext): String =
    convertTypeName(ctx.type_name()) match {
      case "void" => "" // No return type
      case s => " -> " + s
    }

  override def visitClass_implementation(ctx: Class_implementationContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext): String = {
    concatChildResults(ctx, "")
  }

  /**
   * Convert instance method definition(implementation) in Objective-C to Swift code.
   *
   * @param ctx the parse tree
   * @return Strings of Swift code
   **/
  override def visitInstance_method_definition(ctx: Instance_method_definitionContext): String =
    Option(visited.get(ctx)) match {
      case None => visit(ctx.method_definition().compound_statement()) // TODO Print Method Definition
      case _ => "" // Already printed
    }

  override def visitCompound_statement(ctx: Compound_statementContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitStatement_list(ctx: Statement_listContext): String = {
    concatChildResults(ctx, "\n")
  }

  override def visitStatement(ctx: StatementContext): String = {
    indent(ctx) + "// statement\n" // TODO
  }

  /**
   * Convert Objective-C type to Swift type.
   *
   * @param ctx the parse tree
   * @return Swift type strings
   *
   * TODO: Implement other types
   *
   **/
  override def visitType_specifier(ctx: Type_specifierContext): String =
    ctx.getText match {
      case "void" => "void"
      case "int" => "Int"
      case "long" => "Int"
      case "short" => "Int"
      case "id" => "AnyObject"
      case s if s != "" => s
      case _ => "AnyObject"
    }
}
