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
      return
    }

    val files = findFiles(fileNames)
    if (files.isEmpty) {
      println(s"error: no file found for: '${fileNames.mkString(", ")}'")
      return
    }

    val streams = files.map(new FileInputStream(_))
    val seqStream = new SequenceInputStream(streams.toIterator)
    val converter = new ObjC2SwiftConverter(seqStream)

    val result = if(options("-t"))
      converter.getParseTree()
    else
      converter.getResult()

    printResult(files, result)
  }

  /**
   * Extractor to validate target file.
   */
  object ValidFile {
    def unapply(s: String): Option[Path] =
      Paths.get(s) match {
        case p if Files.exists(p) =>
          getExtension(s) match {
            case "h"|"m" => Some(p)
            case _ => None
          }
        case _ => None
      }
  }

  def findFiles(input:List[String]): List[File] = {
    val builder = List.newBuilder[File]

    input.foreach {
      case x if x.contains("*") =>
        val dir = (x.contains("/") match {
          case true => Paths.get(x).getParent
          case false => Paths.get(".")
        }).toFile

        val matcher = getName(x)
        val files = dir.listFiles(new FilenameFilter {
          override def accept(dir: File, name: String): Boolean = {
            s"$dir/$name" match {
              case ValidFile(path) => wildcardMatch(name, matcher)
              case _ => false
            }
          }
        })
        builder ++= files
      case ValidFile(path) => builder += path.toFile
      case _ =>
    }

    builder.result()
  }

  def printResult(files: List[File], result: String) = {
    val lines = List.newBuilder[String]
    lines += "Hello Swift, Goodbye Obj-C."
    lines += "converted by 'objc2swift' https://github.com/yahoojapan/objc2swift"
    lines += "original source: " + files.mkString(", ")

    println(s"/* ${lines.result().mkString("\n * ")}\n */")
    println()
    println(result)
  }
}
