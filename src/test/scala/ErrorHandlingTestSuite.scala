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
import org.objc2swift.converter.{ObjCParser, ObjC2SwiftConverter}
import org.scalatest.Ignore
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

import collection.JavaConversions._
import scala.io.Source
import scala.sys.process._

@RunWith(classOf[JUnitRunner])
class ErrorHandlingTestSuite extends ObjC2SwiftTestSuite {

  override def converter(parser: ObjCParser) = new ObjC2SwiftConverter(parser)

  test("broken @interface") {
    val source = "@interf"
    assertConvertPass(source)
  }

  test("no class name") {
    val source =
      """@interface
        |@end
      """.stripMargin
    assertConvertPass(source)
  }

  test("no end") {
    val source =
      """@interface MyClass
        |
      """.stripMargin

    assertConvertPass(source)
  }

}
