package org.objc2swift.converter

import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.converter.ObjCParser._
import scala.collection.JavaConversions._

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
        case CHARACTER_LITERAL => s""""${c.getText.substring(1, 2)}""""
        case _ => c.getText
      }
    }

}
