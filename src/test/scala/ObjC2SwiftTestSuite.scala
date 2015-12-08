import java.io.{PrintWriter, SequenceInputStream, FileInputStream}

import org.objc2swift.converter.{ObjC2SwiftBaseConverter, ObjCParser, ObjC2SwiftConverter}
import org.scalatest.FunSuite

/**
 * Created by takesano on 15/12/08.
 */
trait ObjC2SwiftTestSuite extends FunSuite {

  // override point
  def parser(source: String): ObjCParser = ObjC2SwiftConverter.generateParser(source)

  // override point
  def converter(parser: ObjCParser): ObjC2SwiftBaseConverter = new ObjC2SwiftConverter(parser)

  def convertSource(source: String): String = converter(parser(source)).getResult

  def assertCodeEqual(expected: String, actual: String): Unit = {
    val expectedString = trimLines(expected.split("\n"))
    val actualString = trimLines(actual.split("\n"))
    val result = expectedString == actualString
    assert(result, failedMessage(expectedString, actualString))
  }

  private def trimLines(lines: Seq[String]): String = {
    val trimmedLines = lines.map(_.trim)
    trimmedLines.filter(_.nonEmpty).mkString("\n")
  }

  private def failedMessage(expected: String, actual: String): String =
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
