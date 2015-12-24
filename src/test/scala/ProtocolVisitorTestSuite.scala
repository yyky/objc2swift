import jp.co.yahoo.objc2swift.converter.{ObjC2SwiftBaseConverter, TerminalNodeVisitor}
import org.junit.runner.RunWith
import jp.co.yahoo.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class ProtocolVisitorTestSuite extends ObjC2SwiftTestSuite {

  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ProtocolVisitor
      with RootVisitor
      with ClassVisitor
      with MethodVisitor
      with PropertyVisitor
      with DeclarationVisitor
      with TerminalNodeVisitor
    {
      override val root = null
      override def getResult() = visit(parser.protocolDeclaration())
    }

  test("empty protocol") {
    val source =
      s"""
         |@protocol MyProtocol
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with conformance") {
    val source =
      s"""
         |@protocol MyProtocol <A, B>
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol: A, B {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with function") {
    val source =
      s"""
         |@protocol MyProtocol
         |- (void)hello;
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |  func hello()
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with optional functions") {
    val source =
      s"""
         |@protocol MyProtocol
         |@optional
         |- (void)hello;
         |- (void)goodbye;
         |+ (void)jajaja;
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |  optional func hello()
         |  optional func goodbye()
         |  optional class func jajaja()
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with required/optional functions") {
    val source =
      s"""
         |@protocol MyProtocol
         |@required
         |- (void)hello;
         |@optional
         |- (void)nihao;
         |@required
         |- (void)goodbye;
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |  func hello()
         |  optional func nihao()
         |  func goodbye()
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with property") {
    val source =
      s"""
         |@protocol MyProtocol
         |@property(nonatomic) MyType a;
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |var a: MyType { get set }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("protocol with readonly property") {
    val source =
      s"""
         |@protocol MyProtocol
         |@property(nonatomic, readonly) MyType a;
         |@end
       """.stripMargin

    val expected =
      s"""
         |protocol MyProtocol {
         |var a: MyType { get }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }
}
