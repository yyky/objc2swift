/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import java.io.{InputStreamReader, SequenceInputStream, FileInputStream, PrintWriter}
import org.objc2swift.converter.ObjC2SwiftConverter
import org.scalatest.Ignore
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

import collection.JavaConversions._
import scala.io.Source
import scala.sys.process._

@RunWith(classOf[JUnitRunner])
@Ignore
class CompleteMatchTestSuite extends ObjC2SwiftTestSuite {

  private def loadFile(filename: String): String =
    Source.fromFile(getFilePath(filename))(io.Codec("UTF-8")).mkString

  private def convertFiles(filenames: String*): String = {
    val files = filenames.map(getFilePath)
    val fileStreams = files.map(new FileInputStream(_))
    val inputStream = new SequenceInputStream(fileStreams.toIterator)
    val parser = ObjC2SwiftConverter.generateParser(inputStream)
    val converter = new ObjC2SwiftConverter(parser)
    converter.getResult
  }

  private def diffResult(prefix: String, actual: String) = {
    val expectedPath = getFilePath("/" + prefix + ".swift")
    val actualPath = expectedPath.stripSuffix(".swift") + ".out"
    val out = new PrintWriter(actualPath)
    out.println(actual)
    out.close()
    println(s"#============ START DIFF: $prefix =============")
    s"diff -u $expectedPath $actualPath".!
    println(s"#============= END DIFF: $prefix ==============")
  }

  private def getFilePath(filename: String): String = getClass.getResource(filename).getPath

  test("sample complete match test") {
    val expected = loadFile("/sample.swift")
    val actual = convertFiles("/sample.h", "/sample.m")
    assertCodeEqual(actual, expected)
  }
}
