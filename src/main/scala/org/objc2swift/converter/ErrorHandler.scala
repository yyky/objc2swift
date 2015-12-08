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

import java.io.{BufferedReader, StringReader}
import java.util.BitSet

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTree

import scala.collection.mutable

trait ErrorHandler extends ANTLRErrorListener {
  this: ObjC2SwiftConverter =>

  protected val errors = mutable.Map[Int, (String, String)]()

  def lineError(tree: ParseTree): Option[(String, String)] = tree match {
    case ctx: ParserRuleContext =>
      val line = ctx.getStart.getLine
      if(errors.contains(line)) {
        val error = errors(line)
        errors.remove(line)
        Some(error)
      } else {
        None
      }
    case _ => None
  }

  override def syntaxError(recognizer: Recognizer[_, _],
                           offendingSymbol: scala.Any,
                           line: Int,
                           pos: Int,
                           msg: String,
                           e: RecognitionException): Unit = {

    val message = s"[error ${line}:${pos}] ${msg}"

    val tokens = recognizer.getInputStream.asInstanceOf[CommonTokenStream]
    val input = tokens.getTokenSource.getInputStream.toString
    val reader = new BufferedReader(new StringReader(input))
    for(_ <- 0 until line - 1) reader.readLine()
    val source = reader.readLine()

    errors.put(line, (message, source))
  }

  override def reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, exact: Boolean, ambigAlts: BitSet, configs: ATNConfigSet): Unit = {
  }

  override def reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, conflictingAlts: BitSet, configs: ATNConfigSet): Unit = {
  }

  override def reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, prediction: Int, configs: ATNConfigSet): Unit = {
  }
}
