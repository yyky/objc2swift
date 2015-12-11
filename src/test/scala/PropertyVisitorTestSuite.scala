import org.junit.runner.RunWith
import org.objc2swift.converter.ObjCParser.CompoundStatementContext
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class PropertyVisitorTestSuite extends ObjC2SwiftTestSuite {

  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with RootVisitor
      with ClassVisitor
      with MethodVisitor
      with PropertyVisitor
      with DeclarationVisitor
      with TerminalNodeVisitor
    {
      override val root = parser.translationUnit()
      override def getResult() = visit(root)
      override def visitCompoundStatement(ctx: CompoundStatementContext): String = ""
    }

  test("plain property") {
    val source =
      """
        |@interface MyClass
        |@property MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("nonatomic property") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("readonly property") {
    // TODO not supported

    val source =
      """
        |@interface MyClass
        |@property(readonly) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  private(set) var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("copy property") {
    val source =
      """
        |@interface MyClass
        |@property(copy) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("retain property") {
    val source =
      """
        |@interface MyClass
        |@property(retain) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("assign property") {
    val source =
      """
        |@interface MyClass
        |@property(assign) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("weak property") {
    val source =
      """
        |@interface MyClass
        |@property(weak) MyType a;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  weak var a: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("IBOutlet property") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) IBOutlet UILabel *label;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  @IBOutlet var label: UILabel!
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("IBOutletCollection property") {
    // TODO not supported
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) IBOutletCollection(UILabel) NSArray *labels;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  @IBOutlet var labels: [UILabel]!
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("readonly property with corresponding getter") {
    val source =
      """
        |@interface MyClass
        |@property(readonly) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (MyType)prop {
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  ignore("property with corresponding getter and setter") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (MyType)prop {
        |}
        |- (void)setProp:(MyType)value {
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: Bool {
        |    get {
        |    }
        |    set {
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  // TODO what should we do about the getter?
  ignore("property with corresponding setter") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (void)setProp:(MyType)value {
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: Bool {
        |    get {
        |    }
        |    set {
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("readonly property with specified getter") {
    val source =
      """
        |@interface MyClass
        |@property(readonly, getter=getProp) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (MyType)getProp {
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("property with specified getter and setter") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic, getter=getProp, setter=setMyProp:) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (MyType)getProp {
        |}
        |- (void)setMyProp:(MyType)value {
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |    }
        |    set {
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }
}
