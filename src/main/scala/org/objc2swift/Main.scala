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

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.commons.io.FilenameUtils._

import scala.collection.JavaConversions._

object Main {
  def main(args: Array[String]) {
    val options = Map("-t" -> args.contains("-t"))

    val fileNames = args.filter(!_.startsWith("-")).toList
    if (fileNames.isEmpty) {
      println("error: no input file specified.")
      sys.exit(1)
    }

    val files = findFiles(fileNames)
    if (files.isEmpty) {
      println(s"error: no file found for: '${fileNames.mkString(", ")}'")
      sys.exit(1)
    }

    val streams = files.map(new FileInputStream(_))
    val seqStream = new SequenceInputStream(streams.toIterator)
    val parser = ObjC2SwiftConverter.generateParser(seqStream)

    val result = if(options("-t"))
      getParseTree(parser)
    else {
      val converter = new ObjC2SwiftConverter(parser)
      converter.getResult()
    }

    printResult(files, result)
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
        lines +=
          (ctx.depth - 1) + "  " * ctx.depth +
            parser.getRuleNames()(ctx.getRuleIndex) + ": " + "'" + ctx.getStart.getText.replace("\n\r\t", " ") + "'"
      }
    }, parser.translation_unit())
    lines.result().mkString("\n")
  }

  def printResult(files: List[File], result: String) {
    println(s"""|/* Hello Swift, Goodbye Obj-C.
                | * converted by 'objc2swift' https://github.com/yahoojapan/objc2swift
                | * original source: ${files.mkString(", ")}
                | */
                |
                |$result""".stripMargin)
  }
}
