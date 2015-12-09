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

  test("id") {
    assertCodeEqual("AnyObject", convertSource("id"))
  }
}
