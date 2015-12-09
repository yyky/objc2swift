import org.junit.runner.RunWith
import org.objc2swift.converter.{TerminalNodeVisitor, TypeVisitor, ObjC2SwiftBaseConverter, ObjCParser}
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class TypeVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with TypeVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.typeSpecifier())
    }

  test("type: void") {
    assertCodeEqual("Void", convertSource("void"))
  }

  test("type: id") {
    assertCodeEqual("AnyObject", convertSource("id"))
  }

  test("type: char") {
    assertCodeEqual("Int8", convertSource("char"))
  }

  test("type: short") {
    assertCodeEqual("Int16", convertSource("short"))
  }

  test("type: int") {
    assertCodeEqual("Int32", convertSource("int"))
  }

  test("type: long") {
    assertCodeEqual("Int64", convertSource("long"))
  }

  test("type: float") {
    assertCodeEqual("Float", convertSource("float"))
  }

  test("type: double") {
    assertCodeEqual("Double", convertSource("double"))
  }

  test("type: NSInteger") {
    assertCodeEqual("Int", convertSource("NSInteger"))
  }

  test("type: NSUInteger") {
    assertCodeEqual("UInt", convertSource("NSUInteger"))
  }

  test("type: NSArray") {
    assertCodeEqual("[AnyObject]", convertSource("NSArray"))
  }

  test("type: NSDictionary") {
    assertCodeEqual("[AnyObject: AnyObject]", convertSource("NSDictionary"))
  }

  test("type: SEL") {
    assertCodeEqual("Selector", convertSource("SEL"))
  }

  test("type: BOOL") {
    assertCodeEqual("Bool", convertSource("BOOL"))
  }

  test("type: object") {
    assertCodeEqual("SomeClass", convertSource("SomeClass *"))
  }

  ignore("type: NSError pointer") {
    assertCodeEqual("NSErrorPointer", convertSource("NSError **"))
  }

  // TODO struct and union
}
