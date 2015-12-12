import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class OperationVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ExpressionVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.expression())
    }

  test("op: +") {
    assertConvertSuccess("1 + 2", "1 + 2")
  }

  test("op: -") {
    assertConvertSuccess("1 - 2", "1 - 2")
  }

  test("op: *") {
    assertConvertSuccess("1 * 2", "1 * 2")
  }

  test("op: /") {
    assertConvertSuccess("4 / 2", "4 / 2")
  }

  test("op: %") {
    assertConvertSuccess("23 % 2", "23 % 2")
  }

  test("op: unary -") {
    assertConvertSuccess("-2", "-2")
  }

  test("op: a++") {
    assertConvertSuccess("a++", "a++")
  }

  test("op: ++a") {
    assertConvertSuccess("++a", "++a")
  }

  test("op: a--") {
    assertConvertSuccess("a--", "a--")
  }

  test("op: --a") {
    assertConvertSuccess("--a", "--a")
  }

  test("op: =") {
    assertConvertSuccess("x = y", "x = y")
  }

  test("op: +=") {
    assertConvertSuccess("x += y", "x += y")
  }

  test("op: -=") {
    assertConvertSuccess("x -= y", "x -= y")
  }

  test("op: *=") {
    assertConvertSuccess("x *= y", "x *= y")
  }

  test("op: /=") {
    assertConvertSuccess("x /= y", "x /= y")
  }

  test("op: %=") {
    assertConvertSuccess("x %= y", "x %= y")
  }

  test("op: ==") {
    assertConvertSuccess("x == y", "x == y")
  }

  test("op: !=") {
    assertConvertSuccess("x != y", "x != y")
  }

  test("op: >") {
    assertConvertSuccess("x > y", "x > y")
  }

  test("op: <") {
    assertConvertSuccess("x < y", "x < y")
  }

  test("op: <=") {
    assertConvertSuccess("x <= y", "x <= y")
  }

  test("op: &&") {
    assertConvertSuccess("x && y", "x && y")
  }

  test("op: ||") {
    assertConvertSuccess("x || y", "x || y")
  }

  test("op: !") {
    assertConvertSuccess("!x", "!x")
  }

  test("op: &") {
    assertConvertSuccess("x & y", "x & y")
  }

  test("op: |") {
    assertConvertSuccess("x | y", "x | y")
  }

  test("op: ^") {
    assertConvertSuccess("x ^ y", "x ^ y")
  }

  test("op: ~") {
    assertConvertSuccess("~x", "~x")
  }

  test("op: <<") {
    assertConvertSuccess("x << y", "x << y")
  }

  test("op: >>") {
    assertConvertSuccess("x >> y", "x >> y")
  }
}
