/**
 * This file is part of objc2swift. 
 * https://github.com/yahoojapan/objc2swift
 * 
 * Copyright (c) 2015 Yahoo Japan Corporation
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import java.io._
import java.nio.file._
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.commons.io.FilenameUtils._
import collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

object Main {
  def main(args: Array[String]) {
    val options = Map("tree" -> args.contains("-t"))

    val fileNames = args.filter(!_.startsWith("-")).toList
    if(fileNames.length == 0) {
      println("error: no input file specified.")
      return
    }

    val files = findFiles(fileNames)
    if(files.length == 0) {
      println("error: no file found for: '" + fileNames.mkString(", ") + "'")
      return
    }

    val streams = files.map(new FileInputStream(_))
    val seqStream = new SequenceInputStream(streams.toIterator)
    val input = new ANTLRInputStream(seqStream)

    val lexer = new ObjCLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new ObjCParser(tokens)

    val root = parser.translation_unit
    val converter = new ObjC2SwiftConverter(root)

    val result = converter.getResult
    val header = getHeader(files, options, parser, root)

    println(s"$header\n$result")
  }

  def findFiles(input:List[String]): List[File] = {
    val result = List.newBuilder[File]

    input.foreach({
      case x if x.contains("*") =>
        val dir = (x.contains("/") match {
          case true => Paths.get(x).getParent
          case false => Paths.get(".")
        }).toFile

        val matcher = getName(x)
        val files = dir.listFiles(new FilenameFilter {
          override def accept(dir: File, name: String): Boolean = {
            val extension = getExtension(name)
            List("h", "m").contains(extension) && wildcardMatch(name, matcher)
          }
        })
        result ++= files

      case x =>
        val file = Paths.get(x)
        Files.exists(file) match {
          case true => result += file.toFile
          case false =>
        }
    })

    result.result
  }

  def getHeader(files: List[File], options: Map[String, Any], parser: Parser, root: ParserRuleContext): String = {
    val lines = List.newBuilder[String]

    lines += "Hello Swift, Goodbye Obj-C."
    lines += "converted by 'objc2swift' https://github.com/yahoojapan/objc2swift"
    lines += "original source: " + files.mkString(", ")

    if(options("tree") == true) {
      lines += ""
      lines += "source-tree:"
      new ParseTreeWalker().walk(new ObjCBaseListener() {
        override def enterEveryRule(ctx: ParserRuleContext): Unit = {
          lines +=
            (ctx.depth - 1) + "  " * ctx.depth +
            parser.getRuleNames()(ctx.getRuleIndex) + ": " + "'" + ctx.getStart.getText.replace("\n\r\t", " ") + "'"
        }
      }, root)
    }

    "/* " + lines.result.mkString("\n * ") + "\n */"
  }
}
