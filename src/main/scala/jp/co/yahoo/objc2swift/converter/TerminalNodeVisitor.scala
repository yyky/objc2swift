package jp.co.yahoo.objc2swift.converter

import jp.co.yahoo.objc2swift.converter.ObjCParser._
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Created by takesano on 15/11/13.
 */
trait TerminalNodeVisitor {
  this: ObjC2SwiftBaseConverter =>

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitSelector(ctx: SelectorContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String =
    // TODO eliminate suffix like 10.0f
    ctx.getChild(0) match {
      case c: TerminalNode => c.getSymbol.getType match {
        case OCTAL_LITERAL => s"0o${c.getText.substring(1)}"
        case CHARACTER_LITERAL => "\"" + c.getText.substring(1, 2) + "\""
        case _ => c.getText
      }
    }

}
