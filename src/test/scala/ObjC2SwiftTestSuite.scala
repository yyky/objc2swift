import java.io.{PrintWriter, SequenceInputStream, FileInputStream}

import jp.co.yahoo.objc2swift.converter.ObjC2SwiftBaseConverter
import jp.co.yahoo.objc2swift.converter.{ObjCParser, ObjC2SwiftConverter}
import org.scalatest.FunSuite

/**
 * Created by takesano on 15/12/08.
 */
trait ObjC2SwiftTestSuite extends FunSuite {

  // override point
  def parser(source: String): ObjCParser = ObjC2SwiftConverter.generateParser(source)

  // override point
  def converter(parser: ObjCParser): ObjC2SwiftBaseConverter

  def convertSource(source: String): String = converter(parser(source)).getResult

  def assertConvertPass(source: String) = {
    val result = convertSource(source)
    println(result)
    assert(result != null)
  }

  def assertConvertSuccess(source: String, expected: String) = {
    val converted = convertSource(source)
    assertCodeEqual(converted, expected)
  }

  def assertCodeEqual(actual: String, expected: String) = {
    val actualString = trimLines(actual.split("\n"))
    val expectedString = trimLines(expected.split("\n"))
    val result = expectedString == actualString
    assert(result, failedMessage(actual, expected))
  }

  private def trimLines(lines: Seq[String]): String = {
    val trimmedLines = lines.map(_.trim)
    trimmedLines.filter(_.nonEmpty).mkString("\n")
  }

  private def failedMessage(actual: String, expected: String): String =
    s"""
       |=========================================
       |> Expected:
       |-----------------------------------------
       |$expected
        |=========================================
        |> But actual:
        |-----------------------------------------
        |$actual
        |=========================================
        |""".stripMargin
}
