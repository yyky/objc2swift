import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class BlockVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ExpressionVisitor
      with BlockVisitor
      with DeclarationVisitor
      with TypeVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.expression())
    }

  test("empty block") {
    val source =
      """
        |^{
        |}
      """.stripMargin

    val expected =
      """
        |{
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with one param") {
    val source =
      """
        |^(MyType a){
        |}
      """.stripMargin

    val expected =
      """
        |{(a: MyType) in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with params") {
    val source =
      """
        |^(MyTypeA a, MyTypeB b){
        |}
      """.stripMargin

    val expected =
      """
        |{(a: MyTypeA, b: MyTypeB) in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with return type") {
    val source =
      """
        |^NSString *{
        |}
      """.stripMargin

    val expected =
      """
        |{() -> NSString in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with return type and params") {
    val source =
      """
        |^NSString *(NSInteger i, NSInteger j){
        |}
      """.stripMargin

    val expected =
      """
        |{(i: Int, j: Int) -> NSString in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with void param") {
    val source =
      """
        |^(void){
        |}
      """.stripMargin

    val expected =
      """
        |{() in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("block with void return type") {
    val source =
      """
        |^void {
        |}
      """.stripMargin

    val expected =
      """
        |{() -> Void in
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  // TODO block type test
}
