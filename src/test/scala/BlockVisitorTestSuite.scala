import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.Ignore
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class BlockVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with StatementVisitor
      with ExpressionVisitor
      with BlockVisitor
      with DeclarationVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.expression())
    }

  test("empty block") {
    val source = "^{}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("empty param empty block") {
    val source = "^(){}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("void param block") {
    val source = "^(void){}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("void return type block") {
    val source = "^void{}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("void return type and empty param block") {
    val source = "^void(){}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("void return type and void param block ") {
    val source = "^void(void){}"
    val expected = "{}"
    assertConvertSuccess(source, expected)
  }

  test("one param block") {
    val source = "^(MyType a){}"
    val expected = "{ (a: MyType) in }"
    assertConvertSuccess(source, expected)
  }

  test("multi-params block") {
    val source = "^(MyTypeA a, MyTypeB b){}"
    val expected = "{ (a: MyTypeA, b: MyTypeB) in }"
    assertConvertSuccess(source, expected)
  }

  test("return type block") {
    val source = "^MyType{}"
    val expected = "{ Void -> MyType in }"
    assertConvertSuccess(source, expected)
  }

  test("return type and empty param block") {
    val source = "^MyType(){}"
    val expected = "{ Void -> MyType in }"
    assertConvertSuccess(source, expected)
  }

  test("return type and void param block") {
    val source = "^MyType(void){}"
    val expected = "{ Void -> MyType in }"
    assertConvertSuccess(source, expected)
  }

  test("return type and multi-params block") {
    val source = "^MyType(MyTypeA a, MyTypeB b){ }"
    val expected = "{ (a: MyTypeA, b: MyTypeB) -> MyType in }"
    assertConvertSuccess(source, expected)
  }

  test("block with single statement") {
    val source = "^{ doSomething(); }"
    val expected = "{ doSomething() }"
    assertConvertSuccess(source, expected)
  }

  test("block with single return statement") {
    val source = "^MyType{ return getSomething(); }"
    val expected = "{ Void -> MyType in getSomething() }"
    assertConvertSuccess(source, expected)
  }

  test("block with multiple statements") {
    val source =
      """^MyType(MyTypeA a, MyTypeB b) {
        |  doSomething();
        |  return getSomething();
        |}""".stripMargin

    val expected =
      """{ (a: MyTypeA, b: MyTypeB) -> MyType in
        |  doSomething()
        |  return getSomething()
        |}""".stripMargin

    assertConvertSuccess(source, expected)
  }
}

@RunWith(classOf[JUnitRunner])
class BlockDeclarationTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ExpressionVisitor
      with BlockVisitor
      with DeclarationVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.declaration())
    }

  test("void block decl") {
    val source = "void (^blockName)();"
    val expected = "var blockName: Void -> Void"
    assertConvertSuccess(source, expected)
  }

  test("param-name-less block decl") {
    val source = "void (^blockName)(MyTypeA, MyTypeB);"
    val expected = "var blockName: (MyTypeA, MyTypeB) -> Void"
    assertConvertSuccess(source, expected)
  }

  test("param-named block decl") {
    val source = "void (^blockName)(MyTypeA a, MyTypeB b);"
    val expected = "var blockName: (MyTypeA, MyTypeB) -> Void"
    assertConvertSuccess(source, expected)
  }

  test("void block decl with init") {
    val source = "void (^blockName)() = ^{};"
    val expected = "var blockName: Void -> Void = {}"
    assertConvertSuccess(source, expected)
  }

  test("normal block decl with init") {
    val source = "RetType (^blockName)(MyTypeA, MyTypeB) = ^(MyTypeA a, MyTypeB b){};"
    val expected = "var blockName: (MyTypeA, MyTypeB) -> RetType = { (a: MyTypeA, b: MyTypeB) in }"
    assertConvertSuccess(source, expected)
  }
}
