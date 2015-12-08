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
import org.junit.Ignore
import org.objc2swift.converter.ObjC2SwiftConverter
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite

import org.antlr.v4.runtime._
import org.objc2swift._
import scala.io.Source

import scala.sys.process._

@RunWith(classOf[JUnitRunner])
class CompleteMatchTestSuite extends ObjC2SwiftTestSuite {
  test("sample complete match test") {
    val expected = loadFile("/sample.swift")
    val actual = convertFiles("/sample.h", "/sample.m")
    assertCodeEqual(expected, actual)
  }

  test("class_method_sample complete match test") {
    val expected = loadFile("/class_method_sample.swift")
    val actual = convertFiles("/class_method_sample.h", "/class_method_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("control_flow_sample complete match test") {
    val expected = loadFile("/control_flow_sample.swift")
    val actual = convertFiles("/control_flow_sample.h", "/control_flow_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("declaration_sample complete match test") {
    val expected = loadFile("/declaration_sample.swift")
    val actual = convertFiles("/declaration_sample.h", "/declaration_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("enum_sample complete match test") {
    val expected = loadFile("/enum_sample.swift")
    val actual = convertFiles("/enum_sample.h")
    assertCodeEqual(expected, actual)
  }

  test("expression_sample complete match test") {
    val expected = loadFile("/expression_sample.swift")
    val actual = convertFiles("/expression_sample.h", "/expression_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("instance_method_sample complete match test") {
    val expected = loadFile("/instance_method_sample.swift")
    val actual = convertFiles("/instance_method_sample.h", "/instance_method_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("property_sample complete match test") {
    val expected = loadFile("/property_sample.swift")
    val actual = convertFiles("/property_sample.h","/property_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("non_implemented_property complete match test") {
    val expected = loadFile("/non_implemented_property.swift")
    val actual = convertFiles("/non_implemented_property.h")
    assertCodeEqual(expected, actual)
  }

  ignore("protocol_sample complete match test") {
    val expected = loadFile("/protocol_sample.swift")
    val actual = convertFiles("/protocol_sample.h", "/protocol_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("string_with_format_sample complete match test") {
    val expected = loadFile("/string_with_format_sample.swift")
    val actual = convertFiles("/string_with_format_sample.h", "/string_with_format_sample.m")
    assertCodeEqual(expected, actual)
  }

  test("empty_class complete match test") {
    val expected = loadFile("/empty_class.swift")
    val actual = convertFiles("/empty_class.h", "/empty_class.m")
    assertCodeEqual(expected, actual)
  }

  test("IBAction complete match test") {
    val expected = loadFile("/ib_action_test.swift")
    val actual = convertFiles("/ib_action_test.h", "/ib_action_test.m")
    assertCodeEqual(expected, actual)
  }

  test("if_statement complete match test") {
    val expected = loadFile("/if_statement_sample.swift")
    val actual = convertFiles("/if_statement_sample.h", "/if_statement_sample.m")
    assertCodeEqual(expected, actual)
  }
}
