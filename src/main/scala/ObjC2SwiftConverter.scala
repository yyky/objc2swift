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
import org.antlr.v4.runtime.{CommonToken, ParserRuleContext}
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree, ParseTreeProperty}
import collection.JavaConversions._

class ObjC2SwiftConverter(_root: Translation_unitContext)
  extends ObjCBaseVisitor[String]
  with ExternalDeclarationVisitor
  with PropertyVisitor
  with MethodVisitor
  with DeclarationVisitor
  with StatementVisitor
  with ExpressionVisitor
  with OperatorVisitor {

  val root = _root
}
