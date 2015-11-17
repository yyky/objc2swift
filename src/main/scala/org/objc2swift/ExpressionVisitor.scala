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
import org.antlr.v4.runtime._
import scala.collection.JavaConversions._

/**
 * Implements visit methods for expression contexts.
 */
protected trait ExpressionVisitor {
  this: ObjC2SwiftConverter =>

  /**
   * Returns translated text of binary expression contexts (equality, relational, etc..)
   *
   * @param ctx parse tree
   * @return translated text
   */
  def visitBinaryExpression(ctx: ParserRuleContext): String = {
    ctx.children.map {
      case TerminalText(s) => s" $s "
      case c               => visit(c)
    }.mkString
  }

  /**
   * Returns translated text of unary expression contexts
   *
   * @param ctx parse tree
   * @return translated text
   */
  def visitUnaryExpression(ctx: ParserRuleContext): String = {
    ctx.children.map {
      case TerminalText(s) => s
      case c               => visit(c)
    }.mkString
  }

  /**
   * Returns translated text of message_expression context.
   *
   * @param ctx the parse tree
   **/
  override def visitMessage_expression(ctx: Message_expressionContext): String =
    ctx match {
      case StringWithFormatMessageExpression(s) => s
      case AllocMessageExpression(s)            => s
      case InitMessageExpression(s)             => s
      case _ => {
        val sel = ctx.message_selector()
        val method = Option(sel.selector()) match {
          case Some(s) => s"${s.getText}()" // no argument
          case None => {
            val head :: tail = sel.keyword_argument.toList
            val firstArg = s"${head.selector.getText}(${visit(head.expression)}"
            val restArgs = tail.map { c => s", ${c.selector.getText}: ${visit(c.expression)}" }
            s"$firstArg${restArgs.mkString})"
          }
        }

        s"${visit(ctx.receiver)}.$method"
      }
    }

  /**
   * Returns translated text of selector_expression context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelector_expression(ctx: Selector_expressionContext): String =
    s""""${visit(ctx.selector_name())}""""

  /**
   * Returns translated text of selector_name context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelector_name(ctx: Selector_nameContext): String = ctx.getText

  override def visitArray_expression(ctx: Array_expressionContext) = {
    s"[${ctx.postfix_expression.map(visit).mkString(", ")}]"
  }


  override def visitDictionary_expression(ctx: Dictionary_expressionContext) = {
    s"[${ctx.dictionary_pair.map(visit).mkString(", ")}]"
  }

  /**
   * Returns translated text of dictionary_pair context.
   *
   * @param ctx the parse tree
   **/
  override def visitDictionary_pair(ctx: Dictionary_pairContext): String =
    Option(ctx.expression()) match {
      case Some(s) => s"${visit(ctx.postfix_expression(0))}: ${visit(ctx.expression())}"
      case None    => s"${visit(ctx.postfix_expression(0))}: ${visit(ctx.postfix_expression(1))}"
    }

  /**
   * Returns translated text of box_expression context.
   *
   * @param ctx the parse tree
   **/
  override def visitBox_expression(ctx: Box_expressionContext): String =
    ctx match {
      case ConstantBox(c) => visit(c)
      case ExpressionBox(c) => visit(c)
      case PostfixExpressionBox(c) => visit(c)
    }

  override def visitBlock_expression(ctx: Block_expressionContext): String = {
    val blockType = (ctx.block_parameters, ctx.type_specifier) match {
      case (null, null) => ""
      case (null, t) =>
        s"() -> ${visit(t)} in"
      case (b, null) =>
        s"${visit(b)} in"
      case (b, t) =>
        s"${visit(b)} -> ${visit(t)} in"
    }

    s"""|{$blockType
        |${visit(ctx.compound_statement)}
        |${indent(ctx)}}""".stripMargin
  }

  override def visitBlock_parameters(ctx: Block_parametersContext): String =
    s"(${ctx.type_variable_declarator.map(visit).mkString(", ")})"


  /**
   * Returns translated text of conditional_expression context.
   *
   * @param ctx the parse tree
   **/
  override def visitConditional_expression(ctx: Conditional_expressionContext): String = {
    val left = visit(ctx.logical_or_expression())
    val conds = ctx.conditional_expression()
    conds.length match {
      case 0 => left
      case 1 => s"$left ?? ${visit(conds(0))}"
      case 2 => s"$left ? ${visit(conds(0))} : ${visit(conds(1))}"
    }
  }

  override def visitPrimary_expression(ctx: Primary_expressionContext): String = {
    if (ctx.getChildCount == 3 && ctx.getChild(0).getText == "(" && ctx.getChild(2).getText == ")") {
      return s"(${visit(ctx.getChild(1))})"
    }

    {
      Option(ctx.IDENTIFIER).map { identifier =>
        identifier.getText match {
          case "YES" => "true"
          case "NO"  => "false"
          case other => other
        }
      } orElse
      Option(ctx.STRING_LITERAL).map(_.getText.substring(1)) orElse
      Option(ctx.constant).map(_.getText)
    }.getOrElse {
      ctx.getText match {
        case x @ ("self" | "super") => x
        case _ => visitChildren(ctx)
      }
    }
  }

  override def visitExpression(ctx: ExpressionContext) = concatChildResults(ctx, "")
  override def visitArgument_expression_list(ctx: Argument_expression_listContext) = concatChildResults(ctx, ", ")
  override def visitAssignment_expression(ctx: Assignment_expressionContext): String = {
    if (isUSSetter(ctx.parent))
      concatChildResults(ctx, " ").replaceFirst("_","self.")
    else
      concatChildResults(ctx, " ")
  }

  override def visitEquality_expression(ctx: Equality_expressionContext)       = visitBinaryExpression(ctx)
  override def visitRelational_expression(ctx: Relational_expressionContext)   = visitBinaryExpression(ctx)
  override def visitLogical_or_expression(ctx: Logical_or_expressionContext)   = visitBinaryExpression(ctx)
  override def visitLogical_and_expression(ctx: Logical_and_expressionContext) = visitBinaryExpression(ctx)
  override def visitAdditive_expression(ctx: Additive_expressionContext)       = visitBinaryExpression(ctx)
  override def visitMultiplicative_expression(ctx: Multiplicative_expressionContext) = visitBinaryExpression(ctx)

  override def visitUnary_expression(ctx: Unary_expressionContext)             = visitUnaryExpression(ctx)
  override def visitPostfix_expression(ctx: Postfix_expressionContext)         = visitUnaryExpression(ctx)

  override def visitInclusive_or_expression(ctx: Inclusive_or_expressionContext): String =
    ctx.exclusive_or_expression().map(visit).mkString(" | ")

  override def visitExclusive_or_expression(ctx: Exclusive_or_expressionContext): String =
    ctx.and_expression().map(visit).mkString(" ^ ")

  override def visitAnd_expression(ctx: And_expressionContext): String =
    ctx.equality_expression().map(visit).mkString(" & ")

  override def visitShift_expression(ctx: Shift_expressionContext): String =
    ctx.children.collect {
      case TerminalText("<<") => " << "
      case TerminalText(">>") => " >> "
      case a: Additive_expressionContext => visit(a)
    }.mkString

}
