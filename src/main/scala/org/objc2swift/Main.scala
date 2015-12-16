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

import java.io._
import java.nio.file._

import scala.collection.JavaConversions._
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.commons.io.FilenameUtils._
import org.objc2swift.converter.ObjC2SwiftConverter
import org.objc2swift.converter.{ObjCBaseListener, ObjCParser}

import scala.io.Source


object Main {
  def main(args: Array[String]) {
    val options = Map("-t" -> args.contains("-t"))

    val fileNames = args.filter(!_.startsWith("-")).toList

    val inputStream = if(fileNames.nonEmpty) {
      val files = findFiles(fileNames)
      if (files.isEmpty) {
        println(s"error: no file found: '${fileNames.mkString(", ")}'")
        sys.exit(1)
      }

      val streams = files.map(new FileInputStream(_))
      new SequenceInputStream(streams.toIterator)
    } else {
      System.in
    }

    val parser = ObjC2SwiftConverter.generateParser(inputStream)

    val result = if(options("-t"))
      getParseTree(parser)
    else {
      val converter = new ObjC2SwiftConverter(parser)
      converter.getResult()
    }

    printResult(result)
  }

  /**
   * Extractor to validate target file.
   */
  object ValidFile {
    def unapply(s: String): Option[Path] = {
      val objcExtensions = Set("h", "m")
      val path = Paths.get(s)

      if (Files.exists(path) && objcExtensions(getExtension(s))) Some(path)
      else None
    }
  }

  def findFiles(input:List[String]): List[File] = {
    input.flatMap {
      case x if x.contains("*") =>
        val dir = {
          if (x.contains("/")) Paths.get(x).getParent
          else Paths.get(".")
        }.toFile

        val matcher = getName(x)

        dir.listFiles(new FilenameFilter {
          override def accept(dir: File, name: String): Boolean =
            ValidFile.unapply(s"$dir/$name").nonEmpty &&
            wildcardMatch(name, matcher)
        })
      case ValidFile(path) => List(path.toFile)
      case _ => List.empty
    }
  }

  def getParseTree(parser: ObjCParser) = {
    val lines = List.newBuilder[String]
    new ParseTreeWalker().walk(new ObjCBaseListener() {
      override def enterEveryRule(ctx: ParserRuleContext) {
        lines += List(
          (ctx.depth - 1) + "  " * ctx.depth,
          parser.getRuleNames()(ctx.getRuleIndex),
          ": ",
          if(ctx.getStart.getTokenIndex == ctx.getStop.getTokenIndex)
            ctx.getStart.getText.replace("\n\r\t", " ")
          else
            s"${ctx.getStart.getText} .. ${ctx.getStop.getText}".replace("\n\r\t", " ")
        ).mkString
      }
    }, parser.translationUnit())
    lines.result().mkString("\n")
  }

  def printResult(result: String) {
    println(s"$DocumentComment\n\n$result")
  }

  private val DocumentComment =
    """|/*
       | * "Hello Swift, Goodbye Obj-C."
       | * Converted by 'objc2swift'
       | *
       | * https://github.com/yahoojapan/objc2swift
       | */""".stripMargin
}
