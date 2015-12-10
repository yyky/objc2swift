import org.junit.runner.RunWith
import org.objc2swift.converter._
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
      with OperationVisitor
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

  test("nested message-send") {
    assertConvertSuccess("[[a goodGuy] sayHello:x orGoodbye:y]", "a.goodGuy().sayHello(x, orGoodbye: y)")
  }

  test("alloc init") {
    assertConvertSuccess("[[MyClass alloc] init]", "MyClass()")
  }

  test("alloc initWith") {
    assertConvertSuccess("[[MyClass alloc] initWithName:n age:a]", "MyClass(name: n, age: a)")
  }

  test("stringWithFormat") {
    assertConvertSuccess("[NSString stringWithFormat:@\"hello, %@-san\", name]", "\"hello, \\(name)-san\"")
  }

  test("dictionary access in stringWithFormat") {
    assertConvertSuccess("[NSString stringWithFormat:@\"hello, %@-san\", d[@\"name\"]]", "\"hello, \\(d[\"name\"])-san\"")
  }

  test("stringWithFormat with precision") {
    assertConvertSuccess("[NSString stringWithFormat:@\"%02i\", age]", "String(format: \"%02i\", age)")
  }

  // TODO support more convenience constructors
}
