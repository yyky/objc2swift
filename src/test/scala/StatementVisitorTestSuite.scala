import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class StatementVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with StatementVisitor
      with DeclarationVisitor
      with ExpressionVisitor
      with OperationVisitor
      with TypeVisitor
      with TerminalNodeVisitor
      with UtilMethods
    {
      override def getResult() = visit(parser.statement())
    }

  test("empty statement") {
    assertConvertSuccess(";", "")
  }

  test("expression statement") {
    assertConvertSuccess("sayHello();", "sayHello()")
  }

  test("void return") {
    assertConvertSuccess("return;", "return")
  }

  test("return value") {
    assertConvertSuccess("return 1;", "return 1")
  }

  test("return expression") {
    assertConvertSuccess("return sayHello();", "return sayHello()")
  }

  test("compound statement") {
    val source =
      """
        |{
        |  sayHello();
        |  sayGoodbye();
        |}
      """.stripMargin

    val expected =
      """
        |sayHello()
        |sayGoodbye()
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("if statement") {
    val source =
      """
        |if(cond) {
        |  sayHello();
        |}
      """.stripMargin

    val expected =
      """
        |if cond {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("if else statement") {
    val source =
      """
        |if(cond) {
        |  sayHello();
        |} else {
        |  sayGoodbye();
        |}
      """.stripMargin

    val expected =
      """
        |if cond {
        |  sayHello()
        |} else {
        |  sayGoodbye()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("if else-if statement") {
    val source =
      """
        |if(cond1) {
        |  sayHello();
        |} else if(cond2) {
        |  sayGoodbye();
        |}
      """.stripMargin

    // TODO else-if should be at the same level of if
    val expected =
      """
        |if cond1 {
        |  sayHello()
        |} else {
        |  if cond2 {
        |    sayGoodbye()
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("single line if else-if statement") {
    val source =
      """
        |if(cond1)
        |  sayHello();
        |else if(cond2)
        |  sayGoodbye();
        |else
        |  sayNothing();
      """.stripMargin

    // TODO else-if should be at the same level of if
    val expected =
      """
        |if cond1 {
        |  sayHello()
        |} else {
        |  if cond2 {
        |    sayGoodbye()
        |  } else {
        |    sayNothing()
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("switch-case statement") {
    val source =
      """
        |switch(value) {
        |case A:
        |  doA();
        |  break;
        |case B:
        |  doB();
        |  break;
        |}
      """.stripMargin

    val expected =
      """
        |switch value {
        |case A:
        |  doA()
        |case B:
        |  doB()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("switch-case-default statement") {
    val source =
      """
        |switch(value) {
        |case A:
        |  doA();
        |  break;
        |default:
        |  doDefault();
        |}
      """.stripMargin

    val expected =
      """
        |switch value {
        |case A:
        |  doA()
        |default:
        |  doDefault()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("switch-case fallthrough") { // TODO not supported yet
  val source =
    """
      |switch(value) {
      |case A:
      |  doA();
      |case B:
      |  doB();
      |  break;
      |}
    """.stripMargin

    val expected =
      """
        |switch value {
        |case A:
        |  doA()
        |  fallthrough
        |case B:
        |  doB()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("switch multiple-case") { // TODO not supported yet
  val source =
    """
      |switch(value) {
      |case A:
      |case B:
      |  doSomething();
      |  break;
      |default:
      |  doDefault();
      |  break;
      |}
    """.stripMargin

    val expected =
      """
        |switch value {
        |case A, B:
        |  doSomething()
        |default:
        |  doDefault()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("for statement") {
    val source =
      """
        |for(NSInteger i = 0; i < 10; i++) {
        |  sayHello();
        |}
      """.stripMargin

    val expected =
      """
        |for var i = 0; i < 10; i++ {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("for statement multiple vars") { // TODO not supported
    val source =
      """
        |for(NSInteger i = 0, j = 0; i < 10 && j < 10; i++, j++) {
        |  sayHello();
        |}
      """.stripMargin

    val expected =
      """
        |for var i = 0, j = 0; i < 10 && j < 10; i++, j++ {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("single line for statement") {
    val source =
      """
        |for(NSInteger i = 0; i < 10; i++)
        |  sayHello();
      """.stripMargin

    val expected =
      """
        |for var i = 0; i < 10; i++ {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("for-in statement") {
    val source =
      """
        |for(NSInteger i in array) {
        |  sayHello();
        |}
      """.stripMargin

    val expected =
      """
        |for i: Int in array {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("single line for-in statement") {
    val source =
      """
        |for(NSInteger i in array)
        |  sayHello();
      """.stripMargin

    val expected =
      """
        |for i: Int in array {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("while statement") {
    val source =
      """
        |while(cond) {
        |  sayHello();
        |}
      """.stripMargin

    val expected =
      """
        |while cond {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("single line while statement") {
    val source =
      """
        |while(cond)
        |  sayHello();
      """.stripMargin

    val expected =
      """
        |while cond {
        |  sayHello()
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("do-while statement") {
    val source =
      """
        |do {
        |  sayHello();
        |} while(cond);
      """.stripMargin

    val expected =
      """
        |repeat {
        |  sayHello()
        |} while cond
      """.stripMargin

    assertConvertSuccess(source, expected)
  }
}
