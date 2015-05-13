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
  with TypeVisitor
  with EnumVisitor {

  val root = _root

  override def visitPointer(ctx: PointerContext): String =
    ctx.children.foldLeft(List.empty[String])((z, c) => {
      c match {
        case _: TerminalNode => z
        case _ => visit(c) :: z
      }
    }).reverse.mkString

  override def visitIdentifier(ctx: IdentifierContext): String = ctx.getText

  override def visitConstant(ctx: ConstantContext): String = ctx.getText
}
