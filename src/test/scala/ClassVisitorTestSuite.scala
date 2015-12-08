import org.junit.runner.RunWith
import org.objc2swift.converter.{ObjCParser, ObjC2SwiftBaseConverter, RootVisitor, ClassVisitor, ProtocolVisitor}
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
      with ProtocolVisitor {

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

    assertCodeEqual(expected, convertSource(source))
  }

  test("empty class with superclass") {
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

    assertCodeEqual(expected, convertSource(source))
  }

  test("empty class with superclass and one protocol") {
    val source =
      s"""
         |@interface MyClass : SuperClass<A>
         |@end
         |
         |@implementation MyClass
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass: SuperClass, A {
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("empty class with superclass and muptiple protocols") {
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

    assertCodeEqual(expected, convertSource(source))
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

    assertCodeEqual(expected, convertSource(source))
  }

  test("empty category with protocols") {
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

    assertCodeEqual(expected, convertSource(source))
  }

  // TODO test unnamed-cateogory (class extension)
}
