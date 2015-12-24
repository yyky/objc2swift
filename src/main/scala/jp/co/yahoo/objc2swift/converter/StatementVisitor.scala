/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package jp.co.yahoo.objc2swift.converter

import org.antlr.v4.runtime.ParserRuleContext
import jp.co.yahoo.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

trait StatementVisitor {
  this: ObjC2SwiftBaseConverter =>

  import jp.co.yahoo.objc2swift.converter.util._

  /**
   * compound_statement:
   *   '{' (declaration|statement_list)* '}' ;
   *
   * @param ctx the parse tree
   **/
  override def visitCompoundStatement(ctx: CompoundStatementContext): String =
    visitChildren(ctx, "\n")

  /**
   * statement_list:
   *   statement+ ;
   *
   * @param ctx the parse tree
   **/
  override def visitStatementList(ctx: StatementListContext): String =
    visitChildren(ctx, "\n")

  /**
   * statement
   *   : labeled_statement
   *   | expression ';'
   *   | compound_statement
   *   | selection_statement
   *   | iteration_statement
   *   | jump_statement
   *   | synchronized_statement
   *   | autorelease_statement
   *   | try_block
   *   | ';'
   *   ;
   *
   * @param ctx the parse tree
   **/
  override def visitStatement(ctx: StatementContext): String =
    visitChildren(ctx)


  /**
   * jump_statement
   *   : 'goto' identifier ';'
   *   | 'continue' ';'
   *   | 'break' ';'
   *   | 'return' expression? ';'
   *   ;
   *
   * MEMO: no support for 'goto'
   *
   * @param ctx the parse tree
   **/
  override def visitJumpStatement(ctx: JumpStatementContext): String =
    ctx.getChild(0) match {
      case Token(RETURN) =>
        "return" + ctx.expression().map(" " + visit(_)).getOrElse("")
      case Token(BREAK) =>
        if(isInsideSwitchStatement(ctx)) "" else "break"
      case Token(CONTINUE) =>
        "continue"
      case _ =>
        ""
    }

  /**
   * selection_statement
   *   : 'if' '(' expression ')' statement ('else' statement)?
   *   | 'switch' '(' expression ')' statement
   *   ;
   *
   * @param ctx the parse tree
   **/
  override def visitSelectionStatement(ctx: SelectionStatementContext): String =
    visitChildrenAs(ctx) {
      case Token(IF)     => "if"
      case Token(ELSE)   => extractElseIf(ctx.statement(1))
      case Token(SWITCH) => "switch"
      case c: ExpressionContext   => visit(c)
      case c: StatementContext if !isVisited(c) => processBlock(c)
    }


  private def extractElseIf(ctx: StatementContext): String = {
    ctx.children.toList match {
      case List(c: SelectionStatementContext) if c.getChild(0).getText == "if" =>
        setVisited(ctx)
        s"else ${visit(c)}"
      case _ =>
        "else"
    }
  }

  /**
   * labeled_statement
   *   : identifier ':' statement
   *   | 'case' constant_expression ':' statement
   *   | 'default' ':' statement
   *   ;
   *
   * @param ctx the parse tree
   **/
  override def visitLabeledStatement(ctx: LabeledStatementContext): String =
    ctx match {
      case CaseLabel(name, st) =>
        val labels = takeConsecutiveLabels(ctx)
        labels.lastOption match {
          case Some(c @ DefaultLabel(lst)) =>
            visit(c)
          case Some(c @ CaseLabel(_, lst)) =>
            val labelStr = labels.flatMap(_.constantExpression()).map(visit).mkString(", ")
            s"""case $labelStr:
               |${indent(visit(lst))}
           """.stripMargin

          case _ =>
            defaultResult()
        }

      case DefaultLabel(st) =>
        s"""default:
           |${indent(visit(st))}
         """.stripMargin

      case _ =>
        defaultResult()

    }

  private object CaseLabel {
    def unapply(ctx: LabeledStatementContext): Option[(String, StatementContext)] =
      (ctx.getChild(0), ctx.constantExpression(), ctx.statement()) match {
        case (Token(CASE), Some(c), Some(s)) => Option(visit(c), s)
        case _ => None
      }
  }

  private object DefaultLabel {
    def unapply(ctx: LabeledStatementContext): Option[StatementContext] =
      (ctx.getChild(0), ctx.statement()) match {
        case (Token(DEFAULT), Some(s)) => Option(s)
        case _ => None
      }
  }

  /**
   * group consecutive cases
   *
   * @param ctx
   * @return
   */
  private def takeConsecutiveLabels(ctx: LabeledStatementContext): List[LabeledStatementContext] =
    Stream.from(0)
      .scanLeft(Option(ctx)) { (lblOpt, _) =>
        for {
          lbl <- lblOpt
          st <- lbl.statement()
          cLbl <- st.labeledStatement()
        } yield cLbl
      }
      .takeWhile(_.nonEmpty)
      .flatten
      .toList

  /**
   * iteration_statement
   *   : while_statement
   *   | do_statement
   *   | for_statement
   *   | for_in_statement
   *   ;
   */
  override def visitIterationStatement(ctx: IterationStatementContext): String =
    visitChildren(ctx)

  /**
   * for_in_statement:
   *   'for' '(' type_variable_declarator 'in' expression? ')' statement;
   *
   * @param ctx the parse tree
   **/
  override def visitForInStatement(ctx: ForInStatementContext): String =
    visitChildrenAs(ctx) {
      case Token(FOR)              => "for"
      case Token(IN)               => "in"
      case c: ExpressionContext             => visit(c)
      case c: TypeVariableDeclaratorContext => visit(c)
      case c: StatementContext              => processBlock(c)
    }

  /**
   * for_statement:
   *   'for' '(' ( (declaration_specifiers init_declarator_list) | expression)? ';'
   *             expression? ';'
   *             expression? ')'
   *   statement;
   *
   * @param ctx the parse tree
   **/
  override def visitForStatement(ctx: ForStatementContext): String =
    visitChildrenAs(ctx, "") {
      case Token(FOR)             => "for "
      case Token(SEMI)            => "; "
      case c: ExpressionContext            => visit(c)
      case d: DeclarationSpecifiersContext => processForInitializer(d, ctx.initDeclaratorList().get)
      case c: StatementContext             => s" ${processBlock(c)}"
    }

  /**
   * while_statement:
   *   'while' '(' expression ')' statement;
   *
   * @param ctx the parse tree
   **/
  override def visitWhileStatement(ctx: WhileStatementContext): String =
    visitChildrenAs(ctx) {
      case Token(WHILE) => "while"
      case c: ExpressionContext  => visit(c)
      case c: StatementContext   => processBlock(c)
    }

  /**
   * do_statement:
   *   'do' statement 'while' '(' expression ')' ';';
   *
   * @param ctx the parse tree
   **/
  override def visitDoStatement(ctx: DoStatementContext): String =
    visitChildrenAs(ctx, "") {
      case Token(DO)    => "repeat {\n"
      case Token(WHILE) => s"} while"
      case c: ExpressionContext  => s" ${visit(c)}\n"
      case c: StatementContext   => indent(visitChildren(c)) + "\n"
    }


  private def isInsideSwitchStatement(ctx: ParserRuleContext): Boolean =
    Stream.from(0)
      .scanLeft(ctx.parent) { (list, _) => list.parent }
      .takeWhile(_ != null)
      .find {
        case _: SelectionStatementContext => true
        case _: IterationStatementContext => true
        case _ => false
      } match {
      case Some(c: SelectionStatementContext) =>
        c.getChild(0) match {
          case Token(SWITCH) => true
          case _ => false
        }
      case _ =>
        false
    }


  private def processBlock(ctx: StatementContext): String =
    if(isInsideSwitchStatement(ctx))
      s"""|{
         |${visit(ctx)}
         |}""".stripMargin
  else
      s"""|{
         |${indent(visit(ctx))}
         |}""".stripMargin



  private def processForInitializer(d: DeclarationSpecifiersContext, i: InitDeclaratorListContext): String = {
    i.initDeclarator() match {
      case Nil =>
        ""
      case list =>
        "var " + list.flatMap(processForInitDeclarator(d, _)).mkString(", ")
    }
  }

  private def processForInitDeclarator(d: DeclarationSpecifiersContext, ctx: InitDeclaratorContext): Option[String] =
    for {
      decl <- ctx.declarator()
      dirDecl <- decl.directDeclarator()
      id <- dirDecl.identifier()
      init <- ctx.initializer()
    } yield s"${visit(id)} = ${visit(init)}" // TODO consider declarationSpecifiers
}
