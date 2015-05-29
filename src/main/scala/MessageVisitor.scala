/**
 *
 *
 * Copyright (C) 2015 Yahoo Japan Corporation.
 * All Rights Reserved.
 * @since 2015/05/29
 */
import ObjCParser._
import collection.JavaConversions._

trait MessageVisitor {
  self: ObjCBaseVisitor[String] =>

  /**
   * Extractor for alloc method expression.
   */
  object AllocMessageExpression {
    def unapply(ctx: Message_expressionContext): Option[String] =
      Option(ctx.message_selector.selector) match {
        case Some(s) =>
          // No argument
          s.getText match {
            case "alloc" => Some(s"${visit(ctx.receiver)}()")
            case _ => None
          }
        case None => None
      }
  }

  /**
   * Extractor for stringWithFormat message expression.
   */
  object StringWithFormatMessageExpression {
    def unapply(ctx: Message_expressionContext): Option[String] =
      Option(ctx.message_selector().keyword_argument()) match {
        case Some(a) if !a.isEmpty =>
          visit(a(0).selector()) match {
            case "stringWithFormat" =>
              val exps = a(0).expression().assignment_expression()
              exps(0).getText match {
                case s if s.matches("^@\".*\"$") =>
                  convertComplexFormat(exps).filter(!_.isEmpty) orElse
                    convertSimpleFormat(exps).filter(!_.isEmpty)
                case _ => None
              }
            case _ => None
          }
        case _ => None
      }
  }

  type AEContexts = scala.collection.mutable.Buffer[Assignment_expressionContext]

  private[this] def convertSimpleFormat(exps: AEContexts): Option[String] = {
    val r = "(%[a-z@]+)".r
    r.findFirstIn(exps.head.getText) match {
      case Some(m) =>
        val res = exps.foldLeft("")((s, c) => {
          s match {
            case "" => visit(c)
            case _ => r.replaceFirstIn(s, s"\\\\(${visit(c)})")
          }
        })
        Some(res)
      case None => None
    }
  }

  private[this] def convertComplexFormat(exps: AEContexts): Option[String] = {
    val r = "(%[0-9.]+[a-z@]+)".r
    r.findFirstIn(exps.head.getText) match {
      case Some(m) =>
        val builder = List.newBuilder[String]
        exps.zipWithIndex.foreach {
          case (c, 0) => builder += s"format: ${visit(c)}"
          case (c, _) => builder += s", ${visit(c)}"
        }
        Some(s"String(${builder.result().mkString})")
      case None => None
    }
  }

}
