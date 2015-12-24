import jp.co.yahoo.objc2swift.converter.{ObjC2SwiftBaseConverter, TerminalNodeVisitor}
import org.junit.runner.RunWith
import jp.co.yahoo.objc2swift.converter.ObjCParser.CompoundStatementContext
import jp.co.yahoo.objc2swift.converter._
import org.scalatest.Ignore
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
      with StatementVisitor
      with DeclarationVisitor
      with ExpressionVisitor
      with TerminalNodeVisitor
    {
      override val root = parser.translationUnit()
      override def getResult() = visit(root)
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

  test("readonly property") {
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
        |  weak var a: MyType?
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
        |  return _prop;
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    return _prop
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("property with corresponding getter and setter") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (MyType)prop {
        |  return _prop;
        |}
        |- (void)setProp:(MyType)value {
        |  _prop = value;
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |      return _prop
        |    }
        |    set(value) {
        |      _prop = value
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  // TODO what should we do about the getter?
  test("property with corresponding setter") {
    val source =
      """
        |@interface MyClass
        |@property(nonatomic) MyType prop;
        |@end
        |
        |@implementation MyClass
        |- (void)setProp:(MyType)value {
        |  _prop = value;
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |      // FIXME: implement getter
        |    }
        |    set(value) {
        |      _prop = value
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
        |  return _prop;
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    return _prop
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
        |  return _prop;
        |}
        |- (void)setMyProp:(MyType)value {
        |  _prop = value;
        |}
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var prop: MyType {
        |    get {
        |      return _prop
        |    }
        |    set(value) {
        |      _prop = value
        |    }
        |  }
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("listed property") {
    val source =
      """
        |@interface MyClass
        |@property MyType a, b;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  var a: MyType
        |  var b: MyType
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }

  test("listed IBOutlet property") {
    val source =
      """
        |@interface MyClass
        |@property IBOutlet MyType a, b;
        |@end
      """.stripMargin

    val expected =
      """
        |class MyClass {
        |  @IBOutlet var a: MyType!
        |  @IBOutlet var b: MyType!
        |}
      """.stripMargin

    assertConvertSuccess(source, expected)
  }


}
