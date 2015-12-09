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

  test("control_flow_sample complete match test") {
    val expected = loadFile("/control_flow_sample.swift")
    val actual = convertFiles("/control_flow_sample.h", "/control_flow_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("declaration_sample complete match test") {
    val expected = loadFile("/declaration_sample.swift")
    val actual = convertFiles("/declaration_sample.h", "/declaration_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("enum_sample complete match test") {
    val expected = loadFile("/enum_sample.swift")
    val actual = convertFiles("/enum_sample.h")
    assertCodeEqual(actual, expected)
  }

  test("expression_sample complete match test") {
    val expected = loadFile("/expression_sample.swift")
    val actual = convertFiles("/expression_sample.h", "/expression_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("property_sample complete match test") {
    val expected = loadFile("/property_sample.swift")
    val actual = convertFiles("/property_sample.h","/property_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("non_implemented_property complete match test") {
    val expected = loadFile("/non_implemented_property.swift")
    val actual = convertFiles("/non_implemented_property.h")
    assertCodeEqual(actual, expected)
  }

  ignore("protocol_sample complete match test") {
    val expected = loadFile("/protocol_sample.swift")
    val actual = convertFiles("/protocol_sample.h", "/protocol_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("string_with_format_sample complete match test") {
    val expected = loadFile("/string_with_format_sample.swift")
    val actual = convertFiles("/string_with_format_sample.h", "/string_with_format_sample.m")
    assertCodeEqual(actual, expected)
  }

  test("IBAction complete match test") {
    val expected = loadFile("/ib_action_test.swift")
    val actual = convertFiles("/ib_action_test.h", "/ib_action_test.m")
    assertCodeEqual(actual, expected)
  }

  test("if_statement complete match test") {
    val expected = loadFile("/if_statement_sample.swift")
    val actual = convertFiles("/if_statement_sample.h", "/if_statement_sample.m")
    assertCodeEqual(actual, expected)
  }
}
