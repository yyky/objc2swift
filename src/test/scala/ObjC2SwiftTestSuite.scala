import java.io.{PrintWriter, SequenceInputStream, FileInputStream}

import org.objc2swift.converter.ObjC2SwiftConverter
import org.scalatest.FunSuite
import collection.JavaConversions._
import scala.io.Source
import scala.sys.process._

/**
 * Created by takesano on 15/12/08.
 */
trait ObjC2SwiftTestSuite extends FunSuite {

  def assertCodeEqual(expected: String, actual: String): Unit = {
    val expectedString = trimLines(expected.split("\n"))
    val actualString = trimLines(actual.split("\n"))
    val result = expectedString == actualString
    assert(result, failedMessage(expectedString, actualString))
  }

  def loadFile(filename: String): String =
    Source.fromFile(getFilePath(filename))(io.Codec("UTF-8")).mkString

  def convertSource(source: String): String = {
    val parser = ObjC2SwiftConverter.generateParser(source)
    val converter = new ObjC2SwiftConverter(parser)
    converter.getResult
  }

  def convertFiles(filenames: String*): String = {
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
