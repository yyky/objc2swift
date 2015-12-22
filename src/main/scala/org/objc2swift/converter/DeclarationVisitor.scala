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
      processAsTypedef(ctx) orElse
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
   * MEMO: 'static' var / func should be converted as plain one in Swift.
   * TODO: support typedef
   *
   * @param ctx the parse tree
   * @return
   **/
  override def visitStorageClassSpecifier(ctx: StorageClassSpecifierContext): String =
    ""


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
      case TokenString(t, s) => t match {
        case VOID   => "Void"
        case ID     => "AnyObject"
        case CHAR   => "Int8"
        case SHORT  => "Int16"
        case INT    => "Int32"
        case LONG   => "Int64"
        case FLOAT  => "Float"
        case DOUBLE => "Double"
        case _      => s
      }
      case ClassName(c) => c match {
        case "SEL"          => "Selector"
        case "BOOL"         => "Bool"
        case "NSInteger"    => "Int"
        case "NSUInteger"   => "UInt"
        case "NSString"     => "String"
        case "NSArray"      => "[AnyObject]"
        case "NSDictionary" => "[AnyObject: AnyObject]"
        case "NSMutableArray"      => "[AnyObject]"
        case "NSMutableDictionary" => "[AnyObject: AnyObject]"
        case s              => s
      }
      case c => visit(c)
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
      case Token(LPAREN) => "("
      case Token(RPAREN) => ")"
      case c             => visit(c)
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

  /**
   * struct_declaration:
   *   specifier_qualifier_list struct_declarator_list ';' ;
   *
   * specifier_qualifier_list:
   *   (arc_behaviour_specifier | type_specifier | type_qualifier)+ ;
   *
   * struct_declarator_list:
   *   struct_declarator (',' struct_declarator)* ;
   *
   * struct_declarator:
   *   declarator | declarator? ':' constant;
   *
   * @param ctx
   * @return
   */
  override def visitStructDeclaration(ctx: StructDeclarationContext): String =
    {
      for {
        specQualList <- ctx.specifierQualifierList()
      } yield for {
        sDeclL <- ctx.structDeclaratorList().toList
        sDecl <- sDeclL.structDeclarator()
        decl <- sDecl.declarator()
      } yield varDeclaration(decl, specQualList.typeQualifier(), specQualList.typeSpecifier())

    }.map(_.mkString("\n")) getOrElse defaultResult()

  override def visitStructDeclaratorList(ctx: StructDeclaratorListContext): String =
    ""

  override def visitStructDeclarator(ctx: StructDeclaratorContext): String =
    ""


  /**
   * function_definition :
   *   declaration_specifiers? declarator compound_statement ;
   *
   * @param ctx
   * @return
   */
  override def visitFunctionDefinition(ctx: FunctionDefinitionContext): String =
    {
      for {
        decl <- ctx.declarator()
        dirDecl <- decl.directDeclarator()
        id <- dirDecl.identifier()
        dirSuf <- dirDecl.declaratorSuffix().headOption
      } yield {
        val retType = {
          for {
            declSpec <- ctx.declarationSpecifiers()
            typeSpecs = declSpec.typeSpecifier()
          } yield processTypeSpecifierList(typeSpecs)
        }.getOrElse("") match {
          case "Void" | "" => ""
          case r => s" -> $r"
        }

        s"""func ${visit(id)}(${visitOption(dirSuf.parameterList())})$retType {
           |${indent(visitOption(ctx.compoundStatement()))}
           |}""".stripMargin
      }
    } getOrElse defaultResult()


  /**
   * parameter_list:
   *   parameter_declaration_list ( ',' '...' )? ;
   *
   * @param ctx
   * @return
   */
  override def visitParameterList(ctx: ParameterListContext): String =
    visitOption(ctx.parameterDeclarationList()) +
      ctx.children.toList.lastOption.collect{ case Token(ELIPSIS) => "..." }.getOrElse("")


  /**
   * parameter_declaration_list:
   * parameter_declaration ( ',' parameter_declaration )* ;
   *
   * @param ctx
   * @return
   */
  override def visitParameterDeclarationList(ctx: ParameterDeclarationListContext): String = {
    val list = ctx.parameterDeclaration()
    visitListAs(list, ", ") {
      case c if c == list.head => visit(c)
      case c => "_ " + visit(c) // ignore parameter name after second
    }
  }


  /**
   * parameter_declaration:
   *   declaration_specifiers (declarator? | abstract_declarator) ;
   *
   * @param ctx
   * @return
   */
  override def visitParameterDeclaration(ctx: ParameterDeclarationContext): String =
    {
      for {
        declSpec <- ctx.declarationSpecifiers()
        typeSpecs = declSpec.typeSpecifier()
        lastTypeSpec <- typeSpecs.lastOption
        varName <- lastTypeSpec.className() // MEMO this is strange
      } yield s"${visit(varName)}: ${processTypeSpecifierList(typeSpecs.init)}"
    } orElse {
      for {
        declSpec <- ctx.declarationSpecifiers()
        typeSpecs = declSpec.typeSpecifier()
        decl <- ctx.declarator()
        varName <- decl.directDeclarator().flatMap(_.identifier())
      } yield s"${visit(varName)}: ${processTypeSpecifierList(typeSpecs)}"
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


  private def isTypedefDeclaration(ctx: DeclarationContext): Boolean =
    {
      for {
        declSpec <- ctx.declarationSpecifiers().toList
        stgSpecs <- declSpec.storageClassSpecifier()
        spec <- stgSpecs.children.toList.headOption
      } yield spec
    } exists {
      case Token(TYPEDEF) => true
      case _ => false
    }

  private def processAsTypedef(ctx: DeclarationContext): Option[String] = {
    if(isTypedefDeclaration(ctx)) {
      val result = processAsBlockDeclaration(ctx) orElse
        processAsVarDeclaration(ctx) orElse
        processAsSingleVarDeclaration(ctx) getOrElse
        defaultResult()
      Some(result.replaceFirst("(var|let) (.*?): (.*)", "typealias $2 = $3"))
    } else
      None
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
    } yield initDeclList.initDeclarator().map(_.children.toList).map { // foreach init-declarator
      case List(decl: DeclaratorContext) => List(
        visit(declSpec),
        varDeclaration(decl, declSpec.typeQualifier(), declSpec.typeSpecifier())
      ).filter(_.nonEmpty).mkString(" ")

      case List(decl: DeclaratorContext, Token(ASSIGN), init: InitializerContext) => List(
        visit(declSpec),
        varDeclaration(decl, declSpec.typeQualifier(), declSpec.typeSpecifier(), inferType = true),
        "=",
        visit(init)
      ).filter(_.nonEmpty).mkString(" ")

      case _ => defaultResult()

    }.mkString("\n")
  }


  private def processAsSingleVarDeclaration(ctx: DeclarationContext): Option[String] = {
    for {
      declSpec <- ctx.declarationSpecifiers()
      lastTypeSpec <- declSpec.typeSpecifier().lastOption
      varName <- lastTypeSpec.className() // MEMO this is strange
    } yield List(
      visit(declSpec),
      varDeclaration(varName, declSpec.typeQualifier(), declSpec.typeSpecifier().init)
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

  private def varDeclaration(varName: RuleContext, typeQuals: List[TypeQualifierContext], typeSpecs: List[TypeSpecifierContext], inferType: Boolean = false): String = {
    val typeAnn = if(!inferType) {
      val typeStr = processTypeSpecifierList(typeSpecs)
      if (typeStr.nonEmpty) s": $typeStr" else ""
    } else
      ""

    s"${letOrVar(typeQuals)} ${visit(varName)}$typeAnn"
  }

  private def letOrVar(typeQuals: List[TypeQualifierContext]): String =
    typeQuals.exists {
      _.children.exists {
        case Token(CONST) => true
        case _ => false
      }
    } match {
      case true  => "let"
      case false => "var"
    }
}