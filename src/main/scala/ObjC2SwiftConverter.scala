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
import org.antlr.v4.runtime.{CommonToken, ParserRuleContext}
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree, ParseTreeProperty}
import collection.JavaConversions._

class ObjC2SwiftConverter(_root: Translation_unitContext)
  extends ObjCBaseVisitor[String]
  with ExternalDeclarationVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with StatementVisitor {

  val root = _root

  def visitBinaryOperator(ctx: ParserRuleContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      element match {
        case symbol: TerminalNode => sb.append(" " + symbol.getSymbol.getText + " ")
        case _ => sb.append(visit(element))
      }
    }

    sb.toString()
  }

  /**
   * Convert Objective-C type to Swift type.
   *
   * @param ctx the parse tree
   * @return Swift type strings
   *
   * TODO: Implement other types
   *
   */
  override def visitType_specifier(ctx: Type_specifierContext): String =
    ctx.getText match {
      case "void"   => "void"
      case "id"     => "AnyObject"
      case "short"  => "Int8"
      case "int"    => "Int32"
      case "long"   => "Int32"
      case "float"  => "Float"
      case "double" => "Double"
      case "NSInteger" | "NSUInteger" => "Int"
      case "NSArray" => "[AnyObject]"
      case "NSDictionary" => "[NSObject : AnyObject]"
      case "SEL" => "Selector"
      case "BOOL" => "Bool"
      case s if s != "" => s
      case _ => "AnyObject"
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

  override def visitExpression(ctx: ExpressionContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitEquality_expression(ctx: Equality_expressionContext): String = {
    visitBinaryOperator(ctx)

  }

  override def visitRelational_expression(ctx: Relational_expressionContext): String = {
    visitBinaryOperator(ctx)

  }

  override def visitLogical_or_expression(ctx: Logical_or_expressionContext): String = {
    visitBinaryOperator(ctx)

  }

  override def visitLogical_and_expression(ctx: Logical_and_expressionContext): String = {
    visitBinaryOperator(ctx)

  }

  override def visitAdditive_expression(ctx: Additive_expressionContext): String = {
    visitBinaryOperator(ctx)
  }

  override def visitMultiplicative_expression(ctx: Multiplicative_expressionContext): String = {
    visitBinaryOperator(ctx)
  }

  override def visitAssignment_expression(ctx: Assignment_expressionContext): String = {
    concatChildResults(ctx, " ")
  }

  override def visitAssignment_operator(ctx: Assignment_operatorContext): String = {
    ctx.getText
  }
}
