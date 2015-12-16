import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class ClassVisitorTestSuite extends ObjC2SwiftTestSuite {

  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with RootVisitor
      with ClassVisitor
      with MethodVisitor
      with DeclarationVisitor
      with ProtocolVisitor
      with PropertyVisitor
      with TerminalNodeVisitor {

      override val root = parser.translationUnit()
      override def getResult() = visit(root)
    }

  test("empty class") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class with superclass") {
    val source =
      s"""
         |@interface MyClass : SuperClass
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass: SuperClass {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class with protocols") {
    val source =
      s"""
         |@interface MyClass<A, B>
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass: A, B {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class with superclass and protocols") {
    val source =
      s"""
         |@interface MyClass : SuperClass<A, B, C>
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass: SuperClass, A, B, C {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("empty category") {
    val source =
      s"""
         |@interface MyClass(MyCategory)
         |@end
         |
         |@implementation MyClass(MyCategory)
         |@end
       """.stripMargin

    val expected =
      s"""
         |extension MyClass {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("category with protocols") {
    val source =
      s"""
         |@interface MyClass(MyCategory)<A, B, C>
         |@end
         |
         |@implementation MyClass(MyCategory)
         |@end
       """.stripMargin

    val expected =
      s"""
         |extension MyClass: A, B, C {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("empty class extension") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@interface MyClass()
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class extension with protocols") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@interface MyClass()<A, B, C>
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |}
         |
         |private extension MyClass: A, B, C {
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class extension with properties") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@interface MyClass()
         |
         |@property(nonatomic) MyType a;
         |@property(nonatomic, weak) MyType b;
         |
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |  private var a: MyType
         |  private weak var b: MyType?
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("class extension with IBOutlet properties") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@interface MyClass()
         |
         |@property(nonatomic) IBOutlet MyType a;
         |@property(nonatomic, weak) IBOutlet MyType b;
         |
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |  @IBOutlet private var a: MyType!
         |  @IBOutlet private weak var b: MyType!
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("ivars in @interface") {
    val source =
      s"""
         |@interface MyClass {
         |  MyType a;
         |  MyType b;
         |}
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |  var a: MyType
         |  var b: MyType
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("ivars in @implementation") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass {
         |  MyType a;
         |  MyType b;
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |  private var a: MyType
         |  private var b: MyType
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("ivars in class extension") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@interface MyClass() {
         |  MyType a;
         |  MyType b;
         |}
         |
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |  private var a: MyType
         |  private var b: MyType
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }


}
