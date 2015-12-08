import org.junit.runner.RunWith
import org.objc2swift.converter.ObjCParser.CompoundStatementContext
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class MethodVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with RootVisitor
      with ClassVisitor
      with MethodVisitor
      with TypeVisitor
      with TerminalNodeVisitor
      with UtilMethods
    {
      override val root = parser.translationUnit()
      override def getResult() = visit(root)
      override def visitCompoundStatement(ctx: CompoundStatementContext): String = ""
    }

  test("void method") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello() {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void method one arg") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello:(Arg1)arg1;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello(arg1: Arg1) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void method two args") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello:(Arg1)arg1 and:(Arg2)arg2;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello(arg1: Arg1, and arg2: Arg2) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void method two args when label-name = param-name") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello:(Arg1)arg1 arg2:(Arg2)arg2;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello(arg1: Arg1, arg2: Arg2) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void method three args") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello:(Arg1)arg1 arg2:(Arg2)arg2 arg3:(Arg3)arg3;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello(arg1: Arg1, arg2: Arg2, arg3: Arg3) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("return-type method no arg") {
    val source =
      s"""
         |@interface MyClass
         |- (ReturnType)hello;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello() -> ReturnType {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("return-type method with args") {
    val source =
      s"""
         |@interface MyClass
         |- (ReturnType)hello:(Arg1)arg1 arg2:(Arg2)arg2 arg3:(Arg3)arg3;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello(arg1: Arg1, arg2: Arg2, arg3: Arg3) -> ReturnType {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void class-method") {
    val source =
      s"""
         |@interface MyClass
         |+ (void)hello;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello() {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void class-method one arg") {
    val source =
      s"""
         |@interface MyClass
         |+ (void)hello:(Arg1)arg1;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello(arg1: Arg1) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void class-method two args") {
    val source =
      s"""
         |@interface MyClass
         |+ (void)hello:(Arg1)arg1 and:(Arg2)arg2;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello(arg1: Arg1, and arg2: Arg2) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void class-method two args when label-name = param-name") {
    val source =
      s"""
         |@interface MyClass
         |+ (void)hello:(Arg1)arg1 arg2:(Arg2)arg2;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello(arg1: Arg1, arg2: Arg2) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("void class-method three args") {
    val source =
      s"""
         |@interface MyClass
         |+ (void)hello:(Arg1)arg1 arg2:(Arg2)arg2 arg3:(Arg3)arg3;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello(arg1: Arg1, arg2: Arg2, arg3: Arg3) {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("return-type class-method no arg") {
    val source =
      s"""
         |@interface MyClass
         |+ (ReturnType)hello;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello() -> ReturnType {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("return-type class-method with args") {
    val source =
      s"""
         |@interface MyClass
         |+ (ReturnType)hello:(Arg1)arg1 arg2:(Arg2)arg2 arg3:(Arg3)arg3;
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    class func hello(arg1: Arg1, arg2: Arg2, arg3: Arg3) -> ReturnType {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

  test("implementation with corresponding method") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello;
         |@end
         |
         |@implementation MyClass
         |- (void)hello {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello() {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }


  test("implementation with no-corresponding method") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass
         |- (void)hello {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    func hello() {
         |    }
         |}
       """.stripMargin

    assertCodeEqual(expected, convertSource(source))
  }

}
