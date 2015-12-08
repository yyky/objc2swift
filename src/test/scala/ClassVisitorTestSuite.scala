import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class ClassVisitorTestSuite extends ObjC2SwiftTestSuite {
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
}
