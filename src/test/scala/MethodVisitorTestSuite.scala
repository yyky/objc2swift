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
      with DeclarationVisitor
      with TerminalNodeVisitor
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
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

    assertConvertSuccess(source, expected)
  }

  test("IBAction in interface and implementation") {
    val source =
      s"""
         |@interface MyClass
         |- (IBAction)hello;
         |@end
         |
         |@implementation MyClass
         |- (IBAction)hello {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    @IBAction func hello() {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("IBAction only in interface") {
    val source =
      s"""
         |@interface MyClass
         |- (IBAction)hello;
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
         |    @IBAction func hello() {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("IBAction only in implementation") {
    val source =
      s"""
         |@interface MyClass
         |- (void)hello;
         |@end
         |
         |@implementation MyClass
         |- (IBAction)hello {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    @IBAction func hello() {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }


  test("init method") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass
         |- (id)init {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    init() {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }


  test("initWith method") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass
         |- (id)initWithA:(MyTypeA)a b:(MyTypeB)b {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    init(a: MyTypeA, b: MyTypeB) {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }


  test("dealloc method") {
    val source =
      s"""
         |@interface MyClass
         |@end
         |
         |@implementation MyClass
         |- (void)dealloc {
         |}
         |@end
       """.stripMargin

    val expected =
      s"""
         |class MyClass {
         |    deinit {
         |    }
         |}
       """.stripMargin

    assertConvertSuccess(source, expected)
  }


}
