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
import org.objc2swift.converter.util.stringFormat

import scala.collection.JavaConversions._

trait MessageVisitor {
  this: ObjC2SwiftBaseConverter =>

  /**
   * message_expression:
   *   '[' receiver message_selector ']' ;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitMessageExpression(ctx: MessageExpressionContext): String =
    ctx match {
      case AllocExpression(result) => result
      case RetainReleaseExpression(result) => result
      case InitExpression(result) => result
      case NSStringFormatExpression(result) => result
      case ConvenienceConstructorExpression(result) => result
      case _ => visitChildren(ctx, ".")
    }

  /**
   * receiver:
   *   expression | class_name | 'super';
   *
   * @param ctx
   * @return
   */
  override def visitReceiver(ctx: ReceiverContext): String =
    visitChildren(ctx)

  /**
   * message_selector:
   *   selector | keyword_argument+;
   *
   * @param ctx
   * @return
   */
  override def visitMessageSelector(ctx: MessageSelectorContext): String =
    ctx.selector() match {
      case Some(SelectorText(s)) => s"$s()" // no argument
      case None =>
        val head :: tail = ctx.keywordArgument()
        val funcName = visitOption(head.selector())
        val firstArg = visitOption(head.expression())
        val rest = tail.foldLeft("")(_ + ", " + visit(_))
        s"$funcName($firstArg$rest)"
    }


  /**
   * keyword_argument:
   *   selector? ':' expression;
   *
   * @param ctx
   * @return
   */
  override def visitKeywordArgument(ctx: KeywordArgumentContext): String =
    visitChildrenAs(ctx, "") {
      case Token(COLON) => ": "
      case c => visit(c)
    }


  private object AllocExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      ctx match {
        case ReceiverAndFirstSelector(r, s) if s == "alloc" => Some(r)
        case _ => None
      }
  }


  private object RetainReleaseExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      ctx match {
        case ReceiverAndFirstSelector(r, s)
          if List("retain", "release", "autorelease") contains s => Some(r)
        case _ => None
      }
  }


  private object InitExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      ctx match {
        case ReceiverAndFirstSelector(r, s) if s == "init" =>
          Some(s"$r()")

        case ReceiverAndFirstSelector(r, s) if s matches "initWith.*?:" =>
          val stripped = s.stripPrefix("initWith")
          val firstLabel = stripped.head.toLower + stripped.tail
          val kwArgs = ctx.messageSelector().get.keywordArgument()
          val firstArg = visitOption(kwArgs.head.expression())
          val rest = kwArgs.tail.foldLeft("")(_ + ", " + visit(_))
          Some(s"$r($firstLabel $firstArg$rest)")

        case _ => None
      }
  }


  // TODO support more
  private object ConvenienceConstructorExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      (ctx match {
        case ReceiverAndFirstSelector(r, s) => (r, s) match {
          case ("UIImage", "imageNamed:") => Some(r, "named:")
          case _ => None
        }
      }) map { case (r, s) =>
        val msgSel = ctx.messageSelector().get
        val head :: tail = msgSel.keywordArgument()
        val headArg = visitOption(head.expression())
        val rest = tail.foldLeft("")(_ + ", " + visit(_))
        s"$r($s $headArg$rest)"
      }
  }

  private object NSStringFormatExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      ctx match {
        case ReceiverAndFirstSelector("NSString", "stringWithFormat:") =>
          (for {
            msgSel <- ctx.messageSelector()
            kwArg <- msgSel.keywordArgument().headOption
            expr <- kwArg.expression()
            exps = expr.assignmentExpression() // MEMO the element of the list is mostly NOT an assignment.
          } yield exps) map { stringFormat(MessageVisitor.this, _) }
        case _ =>
          None
    }
  }

  private object ReceiverAndFirstSelector {
    def unapply(ctx: MessageExpressionContext): Option[(String, String)] =
      (for {
        rcv <- ctx.receiver()
        r = visit(rcv)
        msgSel <- ctx.messageSelector()
      } yield msgSel.selector() match {
          case Some(SelectorText(s)) =>
            Some(r, s)

          case None =>
            for {
              head <- msgSel.keywordArgument().headOption
              sel <- head.selector()
            } yield (r, visit(sel) + ":")

          case _ => None
        }).flatten
  }

  private object ReceiverText {
    def unapply(ctx: ReceiverContext): Option[String] = Some(visit(ctx))
  }

  private object SelectorText {
    def unapply(ctx: SelectorContext): Option[String] = Some(visit(ctx))
  }
}
