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
  this: ObjC2SwiftConverter =>

  /**
   * Extractor for alloc method expression.
   */
  object AllocMessageExpression {
    def unapply(ctx: Message_expressionContext): Option[String] =
      Option(ctx.message_selector.selector)
        .filter(_.getText == "alloc")
        .map(_ => visit(ctx.receiver))
  }

  object InitMessageExpression {
    def unapply(ctx: Message_expressionContext): Option[String] = {
      Option(ctx.message_selector().selector()) match {
        case Some(s) =>
          if (s.getText == "init") Some(s"${visit(ctx.receiver)}()")
          else None
        case None =>
          val params = ctx.message_selector().keyword_argument
          Some(params.head.selector.getText).filter(_.startsWith("initWith")).map { _ =>
            val builder = List.newBuilder[String]
            val head :: tail = params.toList
            val firstParam = {
              val selector = head.selector.getText
              val oldName = selector.stripPrefix("initWith")
              val newName = oldName.head.toLower + oldName.tail
              s"$newName: ${visit(head.expression)}"
            }
            val restParams =
              tail.map(c => s", ${c.selector.getText}: ${visit(c.expression)}")

            s"${visit(ctx.receiver)}($firstParam${restParams.mkString})"
          }
      }
    }
  }

  /**
   * Extractor for stringWithFormat message expression.
   */
  object StringWithFormatMessageExpression {
    def unapply(ctx: Message_expressionContext): Option[String] = {
      Option(ctx.message_selector().keyword_argument()).filter(_.nonEmpty).flatMap { a =>
        visit(a.head.selector()) match {
          case "stringWithFormat" =>
            val exps = a.head.expression().assignment_expression()
            Some(exps.head.getText).filter(_.matches("^@\".*\"$")).flatMap { _ =>
              convertComplexFormat(exps).filter(_.nonEmpty) orElse
              convertSimpleFormat(exps).filter(_.nonEmpty)
            }
          case "initWithFormat" =>
            val exps = a.head.expression().assignment_expression()
            Some(s"String(format: ${exps.map(visit).mkString(", ")})")
          case _ => None
        }
      }
    }
  }

  type AEContexts = scala.collection.mutable.Buffer[Assignment_expressionContext]

  private[this] def convertSimpleFormat(exps: AEContexts): Option[String] = {
    val r = """(%[a-z@]+)""".r
    r.findFirstIn(exps.head.getText).map { _ =>
      val format = visit(exps.head)
      val params = exps.tail.map(visit).map(i => s"""\\($i)""")
      (("" +: params) zip r.split(format)).map(i => i._1 + i._2).mkString
    }
  }

  private[this] def convertComplexFormat(exps: AEContexts): Option[String] = {
    val r = """(%[0-9.]+[a-z@]+)""".r
    r.findFirstIn(exps.head.getText).map { _ =>
      val head :: tail = exps.toList
      val format = s"format: ${visit(head)}"
      val args = tail.map(c => s", ${visit(c)}")
      s"String($format${args.mkString})"
    }
  }

}
