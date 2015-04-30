/**
 * This file is part of objc2swift. 
 * https://github.com/yahoojapan/objc2swift
 * 
 * Copyright (c) 2015 Yahoo Japan Corporation
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import ObjCParser._
import org.antlr.v4.runtime.tree.TerminalNode
import collection.JavaConversions._

class ObjC2SwiftConverter(_root: Translation_unitContext)
  extends ObjCBaseVisitor[String]
  with ClassVisitor
  with CategoryVisitor
  with ProtocolVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with StatementVisitor
  with ExpressionVisitor
  with OperatorVisitor
  with TypeVisitor {

  val root = _root

  override def visitPointer(ctx: PointerContext): String = {
    val sb = new StringBuilder()

    for (element <- ctx.children) {
      if (! element.isInstanceOf[TerminalNode]) sb.append(visit(element))
    }
    sb.toString()
  }

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String = ctx.getText

  override def visitSelector(ctx: SelectorContext): String = ctx.getText
}
