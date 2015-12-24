import jp.co.yahoo.objc2swift.converter.{ObjC2SwiftBaseConverter, TerminalNodeVisitor}
import org.junit.runner.RunWith
import jp.co.yahoo.objc2swift.converter.ObjCParser.ClassNameContext
import jp.co.yahoo.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/09.
 */
@RunWith(classOf[JUnitRunner])
class DeclarationVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with DeclarationVisitor
      with ExpressionVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.declaration())
      override def visitClassName(ctx: ClassNameContext): String = ctx.getText
    }

  test("var decl without init") {
    val source = "MyType x;"
    val expected = "var x: MyType"
    assertConvertSuccess(source, expected)
  }

  test("multiple var decl without init") {
    val source = "MyType x, y;"
    val expected =
      s"""
         |var x: MyType
         |var y: MyType
       """.stripMargin
    assertConvertSuccess(source, expected)
  }

  test("var decl with initializer") {
    val source = "MyType x = 1;"
    val expected = "var x = 1"
    assertConvertSuccess(source, expected)
  }

  test("multiple var decl with init") {
    val source = "MyType x = 1, y = 2;"
    val expected =
      s"""
         |var x = 1
         |var y = 2
       """.stripMargin
    assertConvertSuccess(source, expected)
  }

  test("object-type var decl without init") {
    val source = "MyObject *x;"
    val expected = "var x: MyObject"
    assertConvertSuccess(source, expected)
  }

  test("multiple object-type var decl without init") {
    val source = "MyObject *x, *y;"
    val expected =
      s"""
         |var x: MyObject
         |var y: MyObject
       """.stripMargin
    assertConvertSuccess(source, expected)
  }

  test("object-type var decl with init") {
    val source = "MyObject *x = y;"
    val expected = "var x = y"
    assertConvertSuccess(source, expected)
  }

  test("const var decl without init") {
    val source = "const MyType x;"
    val expected = "let x: MyType"
    assertConvertSuccess(source, expected)
  }

  test("multiple const var decl without init") {
    val source = "const MyType x, y;"
    val expected =
      s"""
         |let x: MyType
         |let y: MyType
       """.stripMargin
    assertConvertSuccess(source, expected)
  }

  test("const var decl with init") {
    val source = "const MyType x = 1;"
    val expected = "let x = 1"
    assertConvertSuccess(source, expected)
  }

  test("multiple const var decl with init") {
    val source = "const MyType x = 1, y = 2;"
    val expected =
      s"""
         |let x = 1
         |let y = 2
       """.stripMargin
    assertConvertSuccess(source, expected)
  }

  ignore("const object-type var decl without init") {
    val source = "MyType *const x;"
    val expected = "let x: MyType"
    assertConvertSuccess(source, expected)
  }

  test("ignore static") {
    val source = "static MyType x;"
    val expected = "var x: MyType"
    assertConvertSuccess(source, expected)
  }

  test("unsigned var decl") {
    val source = "unsigned x;"
    val expected = "var x: UInt"
    assertConvertSuccess(source, expected)
  }

  test("unsigned int var decl") {
    val source = "unsigned int x;"
    val expected = "var x: UInt32"
    assertConvertSuccess(source, expected)
  }

  test("long long var decl") {
    val source = "long long x;"
    val expected = "var x: Int64"
    assertConvertSuccess(source, expected)
  }

  test("unsigned long long var decl") {
    val source = "unsigned long long x;"
    val expected = "var x: UInt64"
    assertConvertSuccess(source, expected)
  }

  test("typedef declaration") { // not supported yet
    val source = "typedef OldType NewType;"
    val expected = "typealias NewType = OldType"
    assertConvertSuccess(source, expected)
  }

  test("typedef declaration with pointer") { // not supported yet
    val source = "typedef OldType *NewType;"
    val expected = "typealias NewType = OldType"
    assertConvertSuccess(source, expected)
  }

  ignore("c-type array var decl without init") { // not supported yet
    val source = "MyType x[];"
    val expected = "var x: [MyType]"
    assertConvertSuccess(source, expected)
  }
}

@RunWith(classOf[JUnitRunner])
class FunctionDefinitionTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with DeclarationVisitor
      with TerminalNodeVisitor {
      override def getResult() = visit(parser.functionDefinition())
      override def visitClassName(ctx: ClassNameContext): String = ctx.getText
    }

  test("function without return type") {
    val source = "f(){ }"
    val expected = "func f() {\n}"
    assertConvertSuccess(source, expected)
  }

  test("void function") {
    val source = "void f(){ }"
    val expected = "func f() {\n}"
    assertConvertSuccess(source, expected)
  }

  test("function with return Type") {
    val source = "MyType f(){ }"
    val expected = "func f() -> MyType {\n}"
    assertConvertSuccess(source, expected)
  }

  test("function with params") {
    val source = "f(MyTypeA a, MyTypeB b){ }"
    val expected = "func f(a: MyTypeA, _ b: MyTypeB) {\n}"
    assertConvertSuccess(source, expected)
  }

  test("void function with variadic params") {
    val source = "f(MyTypeA a, MyTypeB b, ...){ }"
    val expected = "func f(a: MyTypeA, _ b: MyTypeB...) {\n}"
    assertConvertSuccess(source, expected)
  }
}