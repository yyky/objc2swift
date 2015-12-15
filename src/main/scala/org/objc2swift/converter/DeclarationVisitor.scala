/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package org.objc2swift.converter

import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

trait DeclarationVisitor {
  this: ObjC2SwiftBaseConverter =>

  import org.objc2swift.converter.util._

  /**
   * MEMO: strangely, this rule matches:
   * - one param function call like: f(x)
   * - enum type declaration
   * - block declaration: retType (^blockName)(...);
   * - variable declaration: int i = 0, j = 1;
   * - single variable declaration without initial value: int i;
   *
   * declaration:
   *   declaration_specifiers init_declarator_list? ';';
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitDeclaration(ctx: DeclarationContext): String = {
    processAsFunctionCall(ctx) orElse
      processAsEnum(ctx) orElse
      processAsBlockDeclaration(ctx) orElse
      processAsVarDeclaration(ctx) orElse
      processAsSingleVarDeclaration(ctx) getOrElse
      defaultResult()
  }

  /**
   * declaration_specifiers:
   *   (arc_behaviour_specifier | storage_class_specifier | type_specifier | type_qualifier)+ ;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitDeclarationSpecifiers(ctx: DeclarationSpecifiersContext): String =
    visitChildrenAs(ctx) {
      case c: TypeSpecifierContext => "" // MEMO do not process here
      case c => visit(c)
    }

  /**
   * arc_behaviour_specifier:
   *   '__unsafe_unretained' | '__weak';
   *
   * @param ctx
   * @return
   */
  override def visitArcBehaviourSpecifier(ctx: ArcBehaviourSpecifierContext): String =
    "weak"

  /**
   * storage_class_specifier:
   *   'auto' | 'register' | 'static' | 'extern' | 'typedef';
   *
   * @param ctx the parse tree
   **/
  override def visitStorageClassSpecifier(ctx: StorageClassSpecifierContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("static") => "static"
    }


  /**
   * type_specifier:
   *   'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned'
   *   | ('id' ( protocol_reference_list )? )
   *   | (class_name ( protocol_reference_list )?)
   *   | struct_or_union_specifier
   *   | enum_specifier
   *   | IDENTIFIER
   *   | IDENTIFIER pointer
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitTypeSpecifier(ctx: TypeSpecifierContext): String =
    visitChildrenAs(ctx) {
      case TerminalText("void")           => "Void"
      case TerminalText("id")             => "AnyObject"
      case TerminalText("char")           => "Int8"
      case TerminalText("short")          => "Int16"
      case TerminalText("int")            => "Int32"
      case TerminalText("long")           => "Int64"
      case TerminalText("float")          => "Float"
      case TerminalText("double")         => "Double"
      case TerminalText(s) if !s.isEmpty  => s
      case _: TerminalNode                => "AnyObject"
      case ClassName("NSInteger")     => "Int"
      case ClassName("NSUInteger")    => "UInt"
      case ClassName("NSArray")       => "[AnyObject]"
      case ClassName("NSDictionary")  => "[AnyObject: AnyObject]"
      case ClassName("SEL")           => "Selector"
      case ClassName("BOOL")          => "Bool"
      case ClassName(s) if !s.isEmpty => s
      case _: ClassNameContext           => "AnyObject"
      case c: PointerContext              => visit(c)
      case c                              => c.getText
    }



  private object ClassName {
    def unapply(node: ClassNameContext): Option[String] = Option(node.getText)
  }

  /**
   * type_qualifier:
	 *   'const' | 'volatile' | protocol_qualifier;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitTypeQualifier(ctx: TypeQualifierContext): String =
    defaultResult()


  /**
   * init_declarator_list:
   *   init_declarator (',' init_declarator)* ;
   *
   * @param ctx the parse tree
   * @return
   */
  override def visitInitDeclaratorList(ctx: InitDeclaratorListContext): String =
    visitChildren(ctx, ", ")


  /**
   * init_declarator:
   *   declarator ('=' initializer)? ;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitInitializer(ctx: InitializerContext): String =
    visitChildren(ctx)

  /**
   * declarator:
   *   pointer ? direct_declarator ;
   *
   * @param ctx
   * @return
   **/
  override def visitDeclarator(ctx: DeclaratorContext): String =
    visitChildren(ctx)

  /**
   * pointer:
   *   '*' declaration_specifiers? | '*' declaration_specifiers? pointer ;
   *
   * @param ctx
   * @return
   */
  override def visitPointer(ctx: PointerContext): String =
    visitChildrenAs(ctx) {
      case c: DeclarationSpecifiersContext => visit(c)
    }

  /**
   * direct_declarator:
   *   identifier declarator_suffix*
   *   | '(' declarator ')' declarator_suffix*
   *   | '(' '&#94;' identifier? ')' block_parameters
   *   ;
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitDirectDeclarator(ctx: DirectDeclaratorContext) =
    visitChildrenAs(ctx, "") {
      case TerminalText("(") => "("
      case TerminalText(")") => ")"
      case c                 => visit(c)
    }

  /**
   * type_name:
   *   specifier_qualifier_list abstract_declarator
   *   | block_type
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitTypeName(ctx: TypeNameContext): String =
    visitChildren(ctx)


  /**
   * specifier_qualifier_list:
   *   (arc_behaviour_specifier | type_specifier | type_qualifier)+ ;
   *
   * @param ctx
   * @return
   */
  override def visitSpecifierQualifierList(ctx: SpecifierQualifierListContext): String =
    processTypeSpecifierList(ctx.typeSpecifier())


  /**
   * abstract_declarator:
   *   pointer abstract_declarator
   *   | '(' abstract_declarator ')' abstract_declarator_suffix+
   *   | ('[' constant_expression? ']')+
   *   | ;
   *
   * @param ctx
   * @return
   */
  override def visitAbstractDeclarator(ctx: AbstractDeclaratorContext): String =
    defaultResult() // MEMO what is this for?

  /**
   * type_variable_declarator:
   *   declaration_specifiers declarator;
   *
   * @param ctx
   * @return
   */
  override def visitTypeVariableDeclarator(ctx: TypeVariableDeclaratorContext): String = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      typeSpecs = declSpec.typeSpecifier()

      decl <- ctx.declarator()
      dirDecl <- decl.directDeclarator()
      id <- dirDecl.identifier()
    } yield s"${visit(id)}: ${processTypeSpecifierList(typeSpecs)}"
  } getOrElse defaultResult()


  private def processAsFunctionCall(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      funcName <- firstTypeSpec.className() // MEMO this is strange

      initDeclList <- ctx.initDeclaratorList()
      initDecl <- initDeclList.initDeclarator().headOption
      decl <- initDecl.declarator()
      dirDecl <- decl.directDeclarator()
      decl2 <- dirDecl.declarator()
      dirDecl2 <- decl2.directDeclarator()
    } yield s"${visit(funcName)}(${visit(dirDecl2)})"
  }

  private def processAsEnum(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      firstTypeSpec <- declSpec.typeSpecifier().headOption
      enumSpec <- firstTypeSpec.enumSpecifier()
    } yield visit(enumSpec)
  }


  // TODO add grammer pattern and move this part to BlockVisitor
  private def processAsBlockDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      typeSpec <- declSpec.typeSpecifier().headOption
      initDeclList <- ctx.initDeclaratorList()
      initDecl <- initDeclList.initDeclarator().headOption
      decl <- initDecl.declarator()
      dirDecl <- decl.directDeclarator()
      id <- dirDecl.identifier()
      blockParam <- dirDecl.blockParameters()
    } yield {
      val blockParamStr = visit(blockParam).replaceAll("[a-zA-Z0-9]+: ", "") // strip param-name
      val declStr = s"var ${visit(id)}: $blockParamStr -> ${visit(typeSpec)}"
      initDecl.initializer() match {
        case Some(c) => s"$declStr = ${visit(c)}"
        case None => declStr
      }
    }
  }


  private def processAsVarDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      initDeclList <- ctx.initDeclaratorList()
    } yield initDeclList.initDeclarator().map { // foreach init-declarator
      visitChildrenAs(_) {
        case c: DeclaratorContext  => varDeclaration(ctx, declSpec, declSpec.typeSpecifier(), c)
        case TerminalText("=") => "="
        case c: InitializerContext => visit(c)
      }
    }.mkString("\n")
  }


  private def processAsSingleVarDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      lastTypeSpec <- declSpec.typeSpecifier().lastOption
      varName <- lastTypeSpec.className() // MEMO this is strange
    } yield varDeclaration(ctx, declSpec, declSpec.typeSpecifier().init, varName)
  }


  private def varDeclaration(ctx: DeclarationContext, declSpec: DeclarationSpecifiersContext,
                             typeSpecs: List[TypeSpecifierContext], varName: RuleContext): String = {
    List(
      visit(declSpec),
      letOrVar(ctx),
      visit(varName) + ":",
      processTypeSpecifierList(typeSpecs)
    ).filter(_.nonEmpty).mkString(" ")
  }

  private def processTypeSpecifierList(ctxs: List[TypeSpecifierContext]): String = {
    ctxs.foldRight("") { (ctx, folded) =>
      (visit(ctx), folded) match {
        case ("Int64", "Int64") => "Int64" // long long
        case ("unsigned", "") => "UInt" // unsigned only
        case ("unsigned", t) if t.startsWith("Int") => "U" + t
        case ("signed", t) if t.startsWith("Int")   => t
        case (t, "") => t
        case (_, t)  => t
      }
    }
  }

  private def letOrVar(ctx: DeclarationContext): String =
    if(ctx.declarationSpecifiers().exists(isConstantDeclaration)) "let" else "var"

  private def isConstantDeclaration(ctx: DeclarationSpecifiersContext): Boolean =
    ctx.typeQualifier().exists {
      _.children.exists {
        case TerminalText("const") => true
        case _ => false
      }
    }
}
