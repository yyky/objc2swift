import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class ExpressionVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with DeclarationVisitor
      with ExpressionVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.expression())
    }

  test("conditional expr") {
    assertConvertSuccess("x ? y : z", "x ? y : z")
  }

  test("conditional expr without second value") {
    assertConvertSuccess("x ?: y", "x ?? y")
  }

  test("box expr") {
    assertConvertSuccess("@1", "1")
  }

  test("box expr with ()") {
    assertConvertSuccess("@(1 + 2)", "(1 + 2)")
  }

  test("NSString literal") {
    assertConvertSuccess("@\"hoge\"", "\"hoge\"")
  }

  test("empty array") {
    assertConvertSuccess("@[]", "[]")
  }

  test("array") {
    assertConvertSuccess("@[x, y, z]", "[x, y, z]")
  }

  test("empty dictionary") {
    assertConvertSuccess("@{}", "[:]")
  }

  test("dictionary") {
    assertConvertSuccess("@{a: A, b: B}", "[a: A, b: B]")
  }

  test("array / dictionary access") {
    assertConvertSuccess("a[10]", "a[10]")
  }

  test("array / dictionary assign") {
    assertConvertSuccess("a[10] = 100", "a[10] = 100")
  }

  test("selector") {
    assertConvertSuccess("@selector(hello)", "\"hello\"")
  }

  test("multi-arg selector") {
    assertConvertSuccess("@selector(hello:bye:)", "\"hello:bye:\"")
  }

  test("primary: YES") {
    assertConvertSuccess("YES", "true")
  }

  test("primary: NO") {
    assertConvertSuccess("NO", "false")
  }

  test("primary: self") {
    assertConvertSuccess("self", "self")
  }

  test("primary: super") {
    assertConvertSuccess("super", "super")
  }

  test("parenthesis") {
    assertConvertSuccess("(x)", "(x)")
  }

  test("cast") {
    assertConvertSuccess("(MyClass)x", "x as! MyClass")
  }

  test("cast unsigned long long") {
    assertConvertSuccess("(unsigned long long)x", "x as! UInt64")
  }

  test("dot access") {
    assertConvertSuccess("x.y.z", "x.y.z")
  }

  test("function-call") {
    assertConvertSuccess("f()", "f()")
  }

  test("function-call with params") {
    assertConvertSuccess("f(x, y, z)", "f(x, y, z)")
  }

  test("decimal literal") {
    assertConvertSuccess("1", "1")
  }

  test("hex literal") {
    assertConvertSuccess("0x1ab0ed", "0x1ab0ed")
  }

  test("oct literal") {
    assertConvertSuccess("01024", "0o1024")
  }

  test("float literal") {
    assertConvertSuccess("'c'", "\"c\"")
  }

  test("nil literal") {
    assertConvertSuccess("nil", "nil")
  }
}
