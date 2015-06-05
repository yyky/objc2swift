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

import java.io.{StringReader, BufferedReader}
import java.util

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA

trait ErrorHandler extends BaseConverter with ANTLRErrorListener {
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

  override def reportAmbiguity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, exact: Boolean, ambigAlts: util.BitSet, configs: ATNConfigSet): Unit = {
  }

  override def reportAttemptingFullContext(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, conflictingAlts: util.BitSet, configs: ATNConfigSet): Unit = {
  }

  override def reportContextSensitivity(recognizer: Parser, dfa: DFA, startIndex: Int, stopIndex: Int, prediction: Int, configs: ATNConfigSet): Unit = {
  }
}
