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
import org.objc2swift.converter.util.{NSStringLiteral, TerminalText}

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
      case AllocMessageExpression(s) => s
      case InitMessageExpression(s) => s
      case StringWithFormatMessageExpression(s) => s
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
        List(
          visit(head.selector()),
          "(",
          visit(head.expression()),
          tail.foldLeft("")(_ + ", " + visit(_)),
          ")"
        ).mkString
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
      case TerminalText(":") => ": "
      case c => visit(c)
    }


  private object AllocMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      for{
        receiver <- ctx.receiver()
        msgSel <- ctx.messageSelector()
        sel <- msgSel.selector()
        if visit(sel) == "alloc"
      } yield visit(receiver)
  }


  private object InitMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] = {
      ctx.messageSelector().flatMap { msgSel =>
        msgSel.selector() match {
          case Some(SelectorText(s)) if s == "init" =>
            Some(visit(ctx.receiver()) + "()")
          case None =>
            val headArg :: tailArgs = msgSel.keywordArgument()
            for {
              sel <- headArg.selector()
              selName = visit(sel)
              if selName startsWith "initWith"
            } yield {
              val stripped = selName.stripPrefix("initWith")
              List(
                visit(ctx.receiver()),
                "(",
                stripped.head.toLower,
                stripped.tail,
                ": ",
                visit(headArg.expression()),
                tailArgs.foldLeft("")(_ + ", " + visit(_)),
                ")"
              ).mkString
            }
          case Some(_) =>
            None
        }
      }
    }
  }


  private object StringWithFormatMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] = {
      (for {
        rcv <- ctx.receiver()
        msgSel <- ctx.messageSelector()
        kwArg <- msgSel.keywordArgument().headOption
        sel <- kwArg.selector()
        arg <- kwArg.expression().flatMap(_.assignmentExpression().headOption)
      } yield (rcv, sel) match {
          case (ReceiverText("NSString"), SelectorText("stringWithFormat")) |
               (ReceiverText("NSString"), SelectorText("initWithFormat")) =>
            if(arg.getText.matches("^@\".*\"$")) {
              convertComplexFormat(kwArg.expression().get.assignmentExpression()) orElse
                convertSimpleFormat(kwArg.expression().get.assignmentExpression())
            } else {
              None
            }

          case _ =>
            None
      }).flatten
    }
  }

  private object ReceiverText {
    def unapply(ctx: ReceiverContext): Option[String] = Some(visit(ctx))
  }

  private object SelectorText {
    def unapply(ctx: SelectorContext): Option[String] = Some(visit(ctx))
  }

  private[this] def convertSimpleFormat(exps: List[AssignmentExpressionContext]): Option[String] = {
    val r = """(%[a-z@]+)""".r
    r.findFirstIn(exps.head.getText).map { _ =>
      val format = visit(exps.head)
      val params = exps.tail.map(visit).map(i => s"""\\($i)""")
      (("" +: params) zip r.split(format)).map(i => i._1 + i._2).mkString
    }
  }

  private[this] def convertComplexFormat(exps: List[AssignmentExpressionContext]): Option[String] = {
    val r = """(%[0-9.]+[a-z@]+)""".r
    r.findFirstIn(exps.head.getText).map { _ =>
      val head :: tail = exps.toList
      val format = s"format: ${visit(head)}"
      val args = tail.map(c => s", ${visit(c)}")
      s"String($format${args.mkString})"
    }
  }

}
