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

trait MessageVisitor {
  this: ObjC2SwiftBaseConverter =>

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
        val sel = ctx.messageSelector().get
        val method = sel.selector() match {
          case Some(s) => s"${s.getText}()" // no argument
          case None => {
            val head :: tail = sel.keywordArgument
            val firstArg = s"${head.selector.get.getText}(${visit(head.expression)}"
            val restArgs = tail.map { c => s", ${c.selector.get.getText}: ${visit(c.expression)}" }
            s"$firstArg${restArgs.mkString})"
          }
        }

        s"${visit(ctx.receiver)}.$method"
      }
    }

  /**
   * Extractor for alloc method expression.
   */
  object AllocMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] =
      ctx.messageSelector.flatMap(_.selector)
        .filter(_.getText == "alloc")
        .map(_ => visit(ctx.receiver))
  }

  object InitMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] = {
      ctx.messageSelector().flatMap(_.selector()) match {
        case Some(s) =>
          if (s.getText == "init") Some(s"${visit(ctx.receiver)}()")
          else None
        case None =>
          val params = ctx.messageSelector().map(_.keywordArgument).get
          Some(params.head.selector.get.getText).filter(_.startsWith("initWith")).map { _ =>
            val builder = List.newBuilder[String]
            val head :: tail = params.toList
            val firstParam = {
              val selector = head.selector.get.getText
              val oldName = selector.stripPrefix("initWith")
              val newName = oldName.head.toLower + oldName.tail
              s"$newName: ${visit(head.expression.get)}"
            }
            val restParams =
              tail.map(c => s", ${c.selector.get.getText}: ${visit(c.expression)}")

            s"${visit(ctx.receiver)}($firstParam${restParams.mkString})"
          }
      }
    }
  }

  /**
   * Extractor for stringWithFormat message expression.
   */
  object StringWithFormatMessageExpression {
    def unapply(ctx: MessageExpressionContext): Option[String] = {
      Option(ctx.messageSelector().get.keywordArgument()).filter(_.nonEmpty).flatMap { a =>
        visit(a.head.selector()) match {
          case "stringWithFormat" =>
            val exps = a.head.expression().get.assignmentExpression()
            Some(exps.head.getText).filter(_.matches("^@\".*\"$")).flatMap { _ =>
              convertComplexFormat(exps).filter(_.nonEmpty) orElse
              convertSimpleFormat(exps).filter(_.nonEmpty)
            }
          case "initWithFormat" =>
            val exps = a.head.expression().get.assignmentExpression()
            Some(s"String(format: ${exps.map(visit).mkString(", ")})")
          case _ => None
        }
      }
    }
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
