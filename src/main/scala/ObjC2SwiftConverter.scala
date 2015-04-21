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
      case n if n < 4 => 0 // class
      case n if n < 8 => 1 // method
      case _ => 2 // TODO count number of compound_statement's
    }
  }

  def indent(node: ParserRuleContext): String = {
    "    " * indentLevel(node)
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
    Option(findCorrespondingClassImplementation(classCtx)) match {
      case None =>
      case Some(implCtx) =>
        for (ctx <- implCtx.implementation_definition_list.children if ctx.isInstanceOf[Instance_method_definitionContext]) {
          val defCtx = ctx.asInstanceOf[Instance_method_definitionContext]
          if (defCtx.method_definition.method_selector.getText == declCtx.method_declaration.method_selector.getText) {
            return Some(defCtx)
          }
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
   * Convert instance method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's instance method code
   **/
  override def visitInstance_method_declaration(ctx: Instance_method_declarationContext): String = {
    val sb = new StringBuilder()

    sb.append(indent(ctx) + "func")
    sb.append(visit(ctx.method_declaration()))

    sb.toString()
  }

  /**
   * Convert method declaration(interface).
   *
   * @param ctx the parse tree
   * @return Strings of Swift's method code
   **/
  override def visitMethod_declaration(ctx: Method_declarationContext): String = {
    val sb = new StringBuilder()

    val method_selector_ctx: Method_selectorContext = ctx.method_selector()

    sb.append(" " + visit(method_selector_ctx))

    //
    // Method type.
    //
    // Currently, supported types are:
    //   void, id(AnyObject), short/int/long, float/double, ...
    //
    // TODO: Support more types
    //
    Option(ctx.method_type()) match {
      case Some(method_type_ctx) => visit(method_type_ctx) match {
        case s if s != "" => sb.append(" -> " + s)
        case _ =>
      }
      case _ => sb.append(" -> AnyObject") // id type
    }

    sb.append(" {\n")

    //
    // TODO: Support class method
    //
    findCorrespondingMethodDefinition(ctx.parent.asInstanceOf[Instance_method_declarationContext]) match {
      case None =>
      case Some(impl) =>
        visited.put(impl, true)
        sb.append(visit(impl.method_definition.compound_statement))
        sb.append("\n")
    }

    sb.append(indent(ctx) + "}\n")

    sb.toString()
  }

  override def visitMethod_selector(ctx: Method_selectorContext): String = {
    Option(ctx.selector()) match {
      case Some(s) => s.getText + "()"
      case _ =>
        Option(ctx.keyword_declarator()) match {
          case None => "" // TODO: Syntax error
          case Some(ctxs) => ctxs.iterator().foldLeft("")((s, c) => {
            s match {
              case "" => s + visit(c).format("(") // method name and first param
              case _  => s + ", " + visit(c).format(" ") // other params
            }
          }) + ")"
        }
    }
  }

  /**
   * Construtor of method parameter.
   *
   * @param ctx the parse tree
   * @return parameter code
   **/
  override def visitKeyword_declarator(ctx: Keyword_declaratorContext): String = {
    val sb = new StringBuilder()

    // Method name or Parameter's External name
    Option(ctx.selector()) match {
      case Some(s) => sb.append(s.getText)
      case _ =>
    }
    sb.append("%s")

    // Parameter's Internal name
    sb.append(ctx.IDENTIFIER().getText + ":")

    // Parameter's Type
    sb.append(ctx.method_type().foldLeft("")((s, c) => {
      visit(c) match {
        case s2 if s == "" && s2 != "" => s2
        case _ => s
      }
    }))

    sb.toString()
  }

  /**
   * Return method type as Swift rule.
   *
   * @param ctx the parse tree
   * @return Swift method type
   **/
  override def visitMethod_type(ctx: Method_typeContext): String = {
    val defaultType = "AnyObject"
    (Option(ctx.type_name().specifier_qualifier_list().type_specifier()) match {
      case None => defaultType
      case Some(contexts) =>
        val type_specifier_ctxs: collection.mutable.Buffer[Type_specifierContext] = contexts
        type_specifier_ctxs.foldLeft(defaultType)((s, type_specifier_ctx) => {
          visit(type_specifier_ctx) match {
            case "Int8" if s == "unsigned" => "UInt8"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "unsigned" => "UInt32"
            case "Int32" if s == "Int32" => "Int64"
            case "Int32" if s == "UInt32" => "UInt64"
            case t if t != "" => t
            case _ => s
          }
        })
    }) match {
      case "void" => "" // No return type
      case s => s
    }
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
      case "void"   => "void"
      case "id"     => "AnyObject"
      case "short"  => "Int8"
      case "int"    => "Int32"
      case "long"   => "Int32"
      case "float"  => "Float"
      case "double" => "Double"
      case s if s != "" => s
      case _ => "AnyObject"
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
    indent(ctx) + concatChildResults(ctx, " ") // TODO
  }

  override def visitJump_statement(ctx: Jump_statementContext): String = {
    ctx.getChild(0).getText match {
      case "return" => "return " + visit(ctx.expression)
      case _ => "" // TODO
    }
  }

  /*
     * Expressions
     */
  override def visitMessage_expression(ctx: Message_expressionContext): String = {
    val sel = ctx.message_selector()

    val sb = new StringBuilder()
    sb.append(visit(ctx.receiver))
    sb.append(".")

    if(sel.keyword_argument.length == 0) { // no argument
      sb.append(sel.selector.getText + "()")
    } else {
      for (i <- 0 until sel.keyword_argument.length) {
        val arg = sel.keyword_argument(i)
        if(i > 0)
          sb.append(", ")

        if(i == 0) {
          sb.append(arg.selector().getText)
          sb.append("(")
          sb.append(visit(arg.expression))
        } else {
          sb.append(arg.selector().getText + ": ")
          sb.append(visit(arg.expression))
        }
      }
      sb.append(")")
    }
    sb.toString()
  }

  override def visitPrimary_expression(ctx: Primary_expressionContext): String = {
    // TODO need to support more

    if(ctx.message_expression != null)
      return visit(ctx.message_expression)

    if(ctx.STRING_LITERAL != null)
      return ctx.STRING_LITERAL().getText.substring(1)

    ctx.getText
  }

}
