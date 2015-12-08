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

import org.antlr.v4.runtime._
import org.objc2swift.converter.ObjCParser._

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
  def processBinaryExpression(ctx: ParserRuleContext): String = {
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
  def processUnaryExpression(ctx: ParserRuleContext): String = {
    ctx.children.map {
      case TerminalText(s) => s
      case c               => visit(c)
    }.mkString
  }

  /**
   * Returns translated text of messageExpression context.
   *
   * @param ctx the parse tree
   **/
  override def visitMessageExpression(ctx: MessageExpressionContext): String =
    ctx match {
      case StringWithFormatMessageExpression(s) => s
      case AllocMessageExpression(s)            => s
      case InitMessageExpression(s)             => s
      case _ => {
        val sel = ctx.messageSelector()
        val method = Option(sel.selector()) match {
          case Some(s) => s"${s.getText}()" // no argument
          case None => {
            val head :: tail = sel.keywordArgument.toList
            val firstArg = s"${head.selector.getText}(${visit(head.expression)}"
            val restArgs = tail.map { c => s", ${c.selector.getText}: ${visit(c.expression)}" }
            s"$firstArg${restArgs.mkString})"
          }
        }

        s"${visit(ctx.receiver)}.$method"
      }
    }

  /**
   * Returns translated text of selectorExpression context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelectorExpression(ctx: SelectorExpressionContext): String =
    s""""${visit(ctx.selectorName())}""""

  /**
   * Returns translated text of selectorName context.
   *
   * @param ctx the parse tree
   **/
  override def visitSelectorName(ctx: SelectorNameContext): String = ctx.getText

  override def visitArrayExpression(ctx: ArrayExpressionContext) = {
    s"[${ctx.postfixExpression.map(visit).mkString(", ")}]"
  }


  override def visitDictionaryExpression(ctx: DictionaryExpressionContext) = {
    s"[${ctx.dictionaryPair.map(visit).mkString(", ")}]"
  }

  /**
   * Returns translated text of dictionaryPair context.
   *
   * @param ctx the parse tree
   **/
  override def visitDictionaryPair(ctx: DictionaryPairContext): String =
    Option(ctx.expression()) match {
      case Some(s) => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.expression())}"
      case None    => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.postfixExpression(1))}"
    }

  /**
   * Returns translated text of boxExpression context.
   *
   * @param ctx the parse tree
   **/
  override def visitBoxExpression(ctx: BoxExpressionContext): String =
    ctx match {
      case ConstantBox(c) => visit(c)
      case ExpressionBox(c) => visit(c)
      case PostfixExpressionBox(c) => visit(c)
    }

  override def visitBlockExpression(ctx: BlockExpressionContext): String = {
    val blockType = (ctx.blockParameters, ctx.typeSpecifier) match {
      case (null, null) => ""
      case (null, t) =>
        s"() -> ${visit(t)} in"
      case (b, null) =>
        s"${visit(b)} in"
      case (b, t) =>
        s"${visit(b)} -> ${visit(t)} in"
    }

    s"""|{$blockType
        |${visit(ctx.compoundStatement)}
        |${indent(ctx)}}""".stripMargin
  }

  override def visitBlockParameters(ctx: BlockParametersContext): String =
    s"(${ctx.typeVariableDeclarator.map(visit).mkString(", ")})"


  /**
   * Returns translated text of conditionalExpression context.
   *
   * @param ctx the parse tree
   **/
  override def visitConditionalExpression(ctx: ConditionalExpressionContext): String = {
    val left = visit(ctx.logicalOrExpression())
    val conds = ctx.conditionalExpression()
    conds.length match {
      case 0 => left
      case 1 => s"$left ?? ${visit(conds(0))}"
      case 2 => s"$left ? ${visit(conds(0))} : ${visit(conds(1))}"
    }
  }

  override def visitPrimaryExpression(ctx: PrimaryExpressionContext): String = {
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
  override def visitArgumentExpressionList(ctx: ArgumentExpressionListContext) = concatChildResults(ctx, ", ")
  override def visitAssignmentExpression(ctx: AssignmentExpressionContext): String = {
    if (isUSSetter(ctx.parent))
      concatChildResults(ctx, " ").replaceFirst("_","self.")
    else
      concatChildResults(ctx, " ")
  }

  override def visitEqualityExpression(ctx: EqualityExpressionContext)       = processBinaryExpression(ctx)
  override def visitRelationalExpression(ctx: RelationalExpressionContext)   = processBinaryExpression(ctx)
  override def visitLogicalOrExpression(ctx: LogicalOrExpressionContext)   = processBinaryExpression(ctx)
  override def visitLogicalAndExpression(ctx: LogicalAndExpressionContext) = processBinaryExpression(ctx)
  override def visitAdditiveExpression(ctx: AdditiveExpressionContext)       = processBinaryExpression(ctx)
  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) = processBinaryExpression(ctx)

  override def visitUnaryExpression(ctx: UnaryExpressionContext)             = processUnaryExpression(ctx)
  override def visitPostfixExpression(ctx: PostfixExpressionContext)         = processUnaryExpression(ctx)

  override def visitInclusiveOrExpression(ctx: InclusiveOrExpressionContext): String =
    ctx.exclusiveOrExpression().map(visit).mkString(" | ")

  override def visitExclusiveOrExpression(ctx: ExclusiveOrExpressionContext): String =
    ctx.andExpression().map(visit).mkString(" ^ ")

  override def visitAndExpression(ctx: AndExpressionContext): String =
    ctx.equalityExpression().map(visit).mkString(" & ")

  override def visitShiftExpression(ctx: ShiftExpressionContext): String =
    ctx.children.collect {
      case TerminalText("<<") => " << "
      case TerminalText(">>") => " >> "
      case a: AdditiveExpressionContext => visit(a)
    }.mkString

}
