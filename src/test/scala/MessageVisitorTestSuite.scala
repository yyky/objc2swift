import jp.co.yahoo.objc2swift.converter.{ObjC2SwiftBaseConverter, TerminalNodeVisitor}
import org.junit.runner.RunWith
import jp.co.yahoo.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class MessageVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ExpressionVisitor
      with MessageVisitor
      with TerminalNodeVisitor
    {
      override def getResult() = visit(parser.expression())
    }

  test("simple message-send") {
    assertConvertSuccess("[self sayHello]", "self.sayHello()")
  }

  test("message-send with args") {
    assertConvertSuccess("[self sayHello:x orGoodbye:y]", "self.sayHello(x, orGoodbye: y)")
  }

  test("message-send with variadic args") {
    assertConvertSuccess("[self sayHello:x orGoodbye:y, z1, z2]", "self.sayHello(x, orGoodbye: y, z1, z2)")
  }

  test("nested message-send") {
    assertConvertSuccess("[[a goodGuy] sayHello:x orGoodbye:y]", "a.goodGuy().sayHello(x, orGoodbye: y)")
  }

  test("alloc init") {
    assertConvertSuccess("[[MyClass alloc] init]", "MyClass()")
  }

  test("alloc initWith") {
    assertConvertSuccess("[[MyClass alloc] initWithName:n age:a]", "MyClass(name: n, age: a)")
  }

  test("ignore retain") {
    assertConvertSuccess("[a retain]", "a")
  }

  test("ignore release") {
    assertConvertSuccess("[a release]", "a")
  }

  test("ignore autorelease") {
    assertConvertSuccess("[a autorelease]", "a")
  }

  test("alloc init autorelease") {
    assertConvertSuccess("[[[MyClass alloc] init] autorelease]", "MyClass()")
  }

  test("NSString stringWithFormat") {
    assertConvertSuccess("[NSString stringWithFormat:@\"hello %@\", name]", "\"hello \\(name)\"")
  }

  test("NSString stringWithFormat2") {
    assertConvertSuccess("[NSString stringWithFormat:@\"hello %@, %@\", name1, name2]", "\"hello \\(name1), \\(name2)\"")
  }

  test("dictionary access in NSString stringWithFormat") {
    assertConvertSuccess("[NSString stringWithFormat:@\"hello, %@-san\", d[@\"name\"]]", "\"hello, \\(d[\"name\"])-san\"")
  }

  test("NSString stringWithFormat with precision") {
    assertConvertSuccess("[NSString stringWithFormat:@\"%02i\", age]", "String(format: \"%02i\", age)")
  }

  test("NSString stringWithFormat with precision2") {
    assertConvertSuccess("[NSString stringWithFormat:@\"%02i %#x\", age, value]", "String(format: \"%02i %#x\", age, value)")
  }

  test("UIImage imageNamed") {
    assertConvertSuccess("[UIImage imageNamed:name]", "UIImage(named: name)")
  }

}
