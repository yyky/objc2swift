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
trait ExpressionVisitor {
  this: ObjC2SwiftBaseConverter =>

  /**
   * expression:
   *   assignment_expression (',' assignment_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitExpression(ctx: ExpressionContext) =
    visitChildrenAs(ctx, "") {
      case Token(COMMA) => ", "
      case c => visit(c)
    }

  /**
   * selector_expression:
   *   '@selector' '(' selector_name ')';
   *
   * @param ctx
   * @return
   */
  override def visitSelectorExpression(ctx: SelectorExpressionContext): String =
    visitChildrenAs(ctx) {
      case c: SelectorNameContext => "\"" + visit(c) + "\""
    }

  /**
   * selector_name:
   *   selector | (selector? ':')+;
   *
   * @param ctx
   * @return
   */
  override def visitSelectorName(ctx: SelectorNameContext): String =
    ctx.getText

  /**
   * array_expression:
   *   '@' '[' postfix_expression? (',' postfix_expression)* ','? ']';
   *
   * @param ctx
   * @return
   */
  override def visitArrayExpression(ctx: ArrayExpressionContext) = {
    s"[${ctx.postfixExpression().map(visit).mkString(", ")}]"
  }

  /**
   * dictionary_expression:
   *   '@' '{' dictionary_pair? (',' dictionary_pair)* ','? '}';
   *
   * @param ctx
   * @return
   */
  override def visitDictionaryExpression(ctx: DictionaryExpressionContext) =
    ctx.dictionaryPair() match {
      case Nil => "[:]"
      case list => s"[${list.map(visit).mkString(", ")}]"
    }


  /**
   * dictionary_pair:
   *   postfix_expression ':' (postfix_expression | expression);
   *
   * @param ctx
   * @return
   */
  override def visitDictionaryPair(ctx: DictionaryPairContext): String =
    ctx.expression() match {
      case Some(s) => s"${visit(ctx.postfixExpression(0))}: ${ctx.expression().map(visit)}"
      case None    => s"${visit(ctx.postfixExpression(0))}: ${visit(ctx.postfixExpression(1))}"
    }

  /**
   * box_expression:
   *   '@' '(' (postfix_expression | expression) ')'
   *   | '@'constant
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitBoxExpression(ctx: BoxExpressionContext): String =
    visitChildrenAs(ctx) {
      case c: ConstantContext => visit(c)
      case c: ExpressionContext => s"(${visit(c)})"
      case c: PostfixExpressionContext => s"(${visit(c)})"
    }

  /**
   * conditional_expression: logical_or_expression
   *   ('?' conditional_expression? ':' conditional_expression)? ;
   *
   * @param ctx
   * @return
   */
  override def visitConditionalExpression(ctx: ConditionalExpressionContext): String = {
    val cond = ctx.logicalOrExpression().map(visit) getOrElse defaultResult()
    ctx.conditionalExpression() match {
      case List() => cond
      case List(right) => s"$cond ?? ${visit(right)}"
      case List(left, right) => s"$cond ? ${visit(left)} : ${visit(right)}"
    }
  }

  /**
   * cast_expression :
   *   '(' type_name ')' cast_expression | unary_expression ;
   *
   * @param ctx
   * @return
   */
  override def visitCastExpression(ctx: CastExpressionContext): String =
    (ctx.typeName(), ctx.castExpression()) match {
      case (Some(typeName), Some(castExpression)) => s"${visit(castExpression)} as! ${visit(typeName)}"
      case _ => visitOption(ctx.unaryExpression())
    }

  /**
   * primary_expression:
	 *   IDENTIFIER | constant | STRING_LITERAL | ('(' expression ')') | 'self' | 'super'
   *   | message_expression | selector_expression | protocol_expression | encode_expression
   *   | dictionary_expression | array_expression | box_expression | block_expression
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitPrimaryExpression(ctx: PrimaryExpressionContext): String = {
    ctx.children.toList match {
      case List(Token(LPAREN), c: ExpressionContext, Token(RPAREN)) =>
        s"(${visit(c)})"

      case List(c) => c match {
        case TokenString(IDENTIFIER, t) => t match {
          case "YES" => "true"
          case "NO"  => "false"
          case "_cmd" => "__FUNCTION__"
          case _ => t
        }

        case c: ConstantContext => visit(c)
        case TokenString(STRING_LITERAL, t) => t.substring(1)
        case Token(SELF)  => "self"
        case Token(SUPER) => "super"
        case _ => visitChildren(ctx)
      }
    }
  }

  /**
   * argument_expression_list
   *   : assignment_expression (',' assignment_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitArgumentExpressionList(ctx: ArgumentExpressionListContext) =
    visitChildren(ctx, ", ")

  /**
   * assignment_expression:
   *   conditional_expression
   *   | unary_expression assignment_operator assignment_expression
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitAssignmentExpression(ctx: AssignmentExpressionContext): String =
    visitChildren(ctx)

  /**
   * equality_expression:
   *   relational_expression
   *   (('!=' | '==') relational_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitEqualityExpression(ctx: EqualityExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * relational_expression:
   *   shift_expression
   *   (('<' | '>' | '<=' | '>=') shift_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitRelationalExpression(ctx: RelationalExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * logical_or_expression:
   *   logical_and_expression
   *   ('||' logical_and_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitLogicalOrExpression(ctx: LogicalOrExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * logical_and_expression:
   *   inclusive_or_expression
   *   ('&&' inclusive_or_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitLogicalAndExpression(ctx: LogicalAndExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * additive_expression:
   *   multiplicative_expression
   *   (('+' | '-') multiplicative_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitAdditiveExpression(ctx: AdditiveExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * multiplicative_expression:
   *   cast_expression
   *   (('*' | '/' | '%') cast_expression)* ;
   * @param ctx
   * @return
   */
  override def visitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * inclusive_or_expression:
   *   exclusive_or_expression
   *   ('|' exclusive_or_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitInclusiveOrExpression(ctx: InclusiveOrExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * exclusive_or_expression:
   *   and_expression
   *   ('^' and_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitExclusiveOrExpression(ctx: ExclusiveOrExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * and_expression:
   *   equality_expression
   *   ('&' equality_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitAndExpression(ctx: AndExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * shift_expression:
   *   additive_expression (('<<' | '>>') additive_expression)* ;
   *
   * @param ctx
   * @return
   */
  override def visitShiftExpression(ctx: ShiftExpressionContext) =
    processBinaryExpression(ctx)

  /**
   * unary_expression:
   *   postfix_expression
   *   | '++' unary_expression
   *   | '--' unary_expression
   *   | unary_operator cast_expression
   *   | 'sizeof' ('(' type_name ')' | unary_expression)
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitUnaryExpression(ctx: UnaryExpressionContext) =
    processUnaryExpression(ctx)

  /**
   * postfix_expression:
   *   primary_expression
   *     ( '[' expression ']'
   *     | '(' argument_expression_list? ')'
   *     | '.' identifier
   *     | '->' identifier
   *     | '++'
   *     | '--'
   *     )* ;
   *
   * @param ctx
   * @return
   */
  override def visitPostfixExpression(ctx: PostfixExpressionContext) =
    ctx.children.toList match {
      case List(c: PrimaryExpressionContext, Token(LPAREN),  (args: ArgumentExpressionListContext), Token(RPAREN)) =>
        processFunctionCall(c, args.assignmentExpression())
      case List(c: PrimaryExpressionContext, Token(LPAREN),  Token(RPAREN)) =>
        processFunctionCall(c, Nil)
      case _ => processUnaryExpression(ctx)
    }


  /**
   * assignment_operator:
   *   '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=';
   *
   * @param ctx
   * @return
   */
  override def visitAssignmentOperator(ctx: AssignmentOperatorContext) =
    ctx.getText

  /**
   * unary_operator:
   *   '&' | '*' | '-' | '~' | '!' ;
   *
   * @param ctx
   * @return
   */
  override def visitUnaryOperator(ctx: UnaryOperatorContext) =
    ctx.getText


  private def processBinaryExpression(ctx: ParserRuleContext): String =
    visitChildrenAs(ctx) {
      case TokenString(_, s) => s
      case c => visit(c)
    }


  private def processUnaryExpression(ctx: ParserRuleContext): String =
    visitChildrenAs(ctx, "") {
      case TokenString(_, s) => s
      case c => visit(c)
    }

  private def processFunctionCall(ctx: PrimaryExpressionContext, args: List[_ <: RuleContext]): String = {
    import org.objc2swift.converter.util.stringFormat

    visit(ctx) match {
      case "NSLog" =>
        s"print(${stringFormat(this, args)})"
      case f =>
        s"$f(${visitList(args, ", ")})"
    }
  }
}
