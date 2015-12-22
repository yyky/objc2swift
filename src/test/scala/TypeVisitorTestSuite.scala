import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class TypeVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with DeclarationVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.typeSpecifier())
    }

  test("type: void") {
    assertConvertSuccess("void", "Void")
  }

  test("type: id") {
    assertConvertSuccess("id", "AnyObject")
  }

  test("type: char") {
    assertConvertSuccess("char", "Int8")
  }

  test("type: short") {
    assertConvertSuccess("short", "Int16")
  }

  test("type: int") {
    assertConvertSuccess("int", "Int32")
  }

  test("type: long") {
    assertConvertSuccess("long", "Int64")
  }

  test("type: float") {
    assertConvertSuccess("float", "Float")
  }

  test("type: double") {
    assertConvertSuccess("double", "Double")
  }

  test("type: BOOL") {
    assertConvertSuccess("BOOL", "Bool")
  }

  test("type: SEL") {
    assertConvertSuccess("SEL", "Selector")
  }

  test("type: NSInteger") {
    assertConvertSuccess("NSInteger", "Int")
  }

  test("type: NSUInteger") {
    assertConvertSuccess("NSUInteger", "UInt")
  }

  test("type: NSString") {
    assertConvertSuccess("NSString", "String")
  }

  test("type: NSArray") {
    assertConvertSuccess("NSArray", "[AnyObject]")
  }

  test("type: NSDictionary") {
    assertConvertSuccess("NSDictionary", "[AnyObject: AnyObject]")
  }

  test("type: NSMutableArray") {
    assertConvertSuccess("NSMutableArray", "[AnyObject]")
  }

  test("type: NSMutableDictionary") {
    assertConvertSuccess("NSMutableDictionary", "[AnyObject: AnyObject]")
  }

  test("type: object") {
    assertConvertSuccess("SomeClass *", "SomeClass")
  }

  ignore("type: NSError pointer") {
    assertConvertSuccess("NSError **", "NSErrorPointer")
  }

  // TODO struct and union
}
