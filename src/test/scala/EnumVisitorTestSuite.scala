import org.junit.runner.RunWith
import org.objc2swift.converter.ObjCParser.ClassNameContext
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/09.
 */
@RunWith(classOf[JUnitRunner])
class EnumVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with DeclarationVisitor
      with EnumVisitor
      with TypeVisitor
      with TerminalNodeVisitor
      with UtilMethods
    {
      override def getResult() = visit(parser.declaration())
      override def visitClassName(ctx: ClassNameContext): String = ctx.getText
    }

  test("simple enum") {
    val source =
      s"""
         |enum A {
         |  A0
         |};
       """.stripMargin

    val expected =
      s"""
         |enum A : Int {
         |  case A0
         |}
       """.stripMargin // TODO no raw-value type when not specified

    assertConvertSuccess(source, expected)
  }

  test("simple enum with multiple choices") {
    val source =
      s"""
         |enum A {
         |  A0,
         |  A1,
         |  A2,
         |};
       """.stripMargin

    val expected =
      s"""
         |enum A : Int {
         |  case A0
         |  case A1
         |  case A2
         |}
       """.stripMargin // TODO no raw-value type when not specified

    assertConvertSuccess(source, expected)
  }

  test("enum with init value") {
    val source =
      s"""
         |enum A {
         |  A0 = 1
         |};
       """.stripMargin

    val expected =
      s"""
         |enum A : Int {
         |  case A0 = 1
         |}
       """.stripMargin // TODO no raw-value type when not specified

    assertConvertSuccess(source, expected)
  }

  test("enum with init value, multiple choices ") {
    val source =
      s"""
         |enum A {
         |  A0 = 0,
         |  A1,
         |  A2 = 99
         |};
       """.stripMargin

    val expected =
      s"""
         |enum A : Int {
         |  case A0 = 0
         |  case A1
         |  case A2 = 99
         |}
       """.stripMargin // TODO no raw-value type when not specified

    assertConvertSuccess(source, expected)
  }

  test("enum with type specifier") {
    val source =
      """
        |typedef enum : NSUInteger {
        |  A0
        |} A;
      """.stripMargin

    val expected =
      """
        |enum A : UInt {
        |  case A0
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("typedef NS_ENUM") {
    val source =
      """
        |typedef NS_ENUM(NSUInteger, A) {
        |  A0
        |};
      """.stripMargin

    val expected =
      """
        |enum A : UInt {
        |  case A0
        |}
      """.stripMargin


    assertConvertSuccess(source, expected)
  }

  // TODO use OptionSetType
  test("typedef NS_OPTIONS") {
    val source =
      """
        |typedef NS_OPTIONS(NSInteger, A) {
        |  A0 = 0,
        |  A1 = 1,
        |  A2 = 2,
        |  A3 = 4,
        |};
      """.stripMargin

    val expected =
      """
        |enum A : Int {
        |  case A0 = 0
        |  case A1 = 1
        |  case A2 = 2
        |  case A3 = 4
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }
}
