import org.junit.runner.RunWith
import org.objc2swift.converter._
import org.scalatest.junit.JUnitRunner

/**
 * Created by takesano on 15/12/08.
 */
@RunWith(classOf[JUnitRunner])
class BlockVisitorTestSuite extends ObjC2SwiftTestSuite {
  override def converter(parser: ObjCParser): ObjC2SwiftBaseConverter =
    new ObjC2SwiftBaseConverter
      with ExpressionVisitor
      with BlockVisitor
      with TypeVisitor
      with TerminalNodeVisitor
      with UtilMethods
    {
      override def getResult() = visit(parser.expression())
    }

  // TODO block expression test
}
