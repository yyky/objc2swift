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

import org.objc2swift.converter.ObjCParser._

import scala.collection.JavaConversions._

trait PropertyVisitor {
  this: ObjC2SwiftBaseConverter with RootVisitor =>

  /**
   * property_declaration:
   *   '@property' property_attributes_declaration? ib_outlet_specifier? struct_declaration;
   *
   * struct_declaration:
   *   specifier_qualifier_list struct_declarator_list ';' ;
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
  override def visitPropertyDeclaration(ctx: PropertyDeclarationContext): String =
    {
      for {
        strDecl <- ctx.structDeclaration()
        spec <- strDecl.specifierQualifierList()
        declList <- strDecl.structDeclaratorList()
      } yield {
        {
          for { // loop list
            str <- declList.structDeclarator()
            decl <- str.declarator()
          } yield processPropertyDeclarator(ctx, spec, decl)
        }.mkString("\n")
      }
    } getOrElse defaultResult()

  private def processPropertyDeclarator(ctx: PropertyDeclarationContext, specCtx: SpecifierQualifierListContext, declCtx: DeclaratorContext): String = {
    val isProtocol = isDefinedInProtocol(ctx)
    val propertyName = visit(declCtx)

    val attrsList = propertyAttributesList(ctx)

    val isWeak = attrsList.exists {
      case PropertyAttribute("weak") => true
      case _ => false
    }

    val isReadonly = attrsList.exists {
      case PropertyAttribute("readonly") => true
      case _ => false
    }

    val (isIBOutlet, typeSpec) = {
      ctx.ibOutletSpecifier() match {
        case Some(s) => s.getChild(0) match {
          case TokenString(IDENTIFIER, "IBOutlet") => // TODO add new token
            (true, s"${visit(specCtx)}!")

          case TokenString(IDENTIFIER, "IBOutletCollection") => // TODO add new token
            (true, s"[${visit(s.className())}]!")
        }
        case None =>
          if(isWeak)
            (false, s"${visit(specCtx)}?")
          else
            (false, visit(specCtx))
      }
    }

    val accessorBlock = if(!isProtocol) {
      val getter = propertyGetter(propertyName, attrsList)
      val setter = if (!isReadonly) propertySetter(propertyName, attrsList) else None
      processAccessors(getter, setter)
    } else {
      if(isReadonly) "{ get }" else "{ get set }"
    }

    List(
      if(isReadonly && accessorBlock.isEmpty && !isProtocol) "private(set)" else "",
      if(isIBOutlet) "@IBOutlet" else "",
      if(isWeak) "weak" else "",
      s"var $propertyName: $typeSpec",
      accessorBlock
    ).filter(_.nonEmpty).mkString(" ")
  }

  private def propertyAttributesList(ctx: PropertyDeclarationContext): List[PropertyAttributeContext] = {
    (for {
      attrsDecl <- ctx.propertyAttributesDeclaration()
      attrsList <- attrsDecl.propertyAttributesList()
      attrs = attrsList.propertyAttribute()
    } yield attrs ) getOrElse List()
  }

  private object PropertyAttribute {
    def unapply(ctx: PropertyAttributeContext): Option[String] =
      ctx.children.toList.headOption match {
        case Some(c) => Some(c.getText)
        case None => None
      }
  }

  private def isDefinedInProtocol(ctx: PropertyDeclarationContext): Boolean =
    ctx.parent.parent match {
      case _: ProtocolDeclarationContext => true
      case _ => false
    }


  private def propertyGetter(propertyName: String, attrsList: List[PropertyAttributeContext]): Option[MethodDefinitionContext] = {
    val getterName = attrsList.collectFirst {
      case c @ PropertyAttribute("getter") => c.getChild(2).getText
    } getOrElse propertyName

    findMethodDefinition(getterName)
  }

  private def propertySetter(propertyName: String, attrsList: List[PropertyAttributeContext]): Option[MethodDefinitionContext] = {
    val setterName = attrsList.collectFirst {
      case c @ PropertyAttribute("setter") => s"${c.getChild(2).getText}:"
    } getOrElse s"set${propertyName.head.toUpper}${propertyName.tail}:"

    findMethodDefinition(setterName)
  }

  private def findMethodDefinition(selector: String): Option[MethodDefinitionContext] = {
    if(root == null)
      return None

    {
      for {
        extDclCtx <- root.externalDeclaration().view
        cl <- extDclCtx.classImplementation().toList
        impl <- cl.implementationDefinitionList().toList
        imDef <- impl.instanceMethodDefinition()
        mDef <- imDef.methodDefinition().toList
      } yield mDef
    } find {
      methodSelectorString(_) == selector
    }
  }

  private def methodSelectorString(ctx: MethodDefinitionContext): String = {
    ctx.methodSelector() match {
      case Some(m) =>
        m.selector() match {
          case Some(s) =>
            visit(s)
          case None =>
            m.keywordDeclarator().map(_.selector()).foldLeft("")(_ + visit(_) + ":")
        }
      case None =>
        ""
    }
  }

  private def processAccessors(getter: Option[MethodDefinitionContext], setter: Option[MethodDefinitionContext]): String = {
    List(getter, setter).flatten.foreach(c => setVisited(c.parent))

    (getter, setter) match {
      case (Some(g), Some(s)) =>
        s"""{
           |  get {
           |    ${visit(g.compoundStatement())}
           |  }
           |  set(${setterParamName(s)}) {
           |    ${visit(s.compoundStatement())}
           |  }
           |}""".stripMargin

      case (Some(g), None) =>
        s"""{
           |  ${visit(g.compoundStatement())}
           |}""".stripMargin

      case (None, Some(s)) =>
        s"""{
           |  get {
           |    // FIXME: implement getter
           |  }
           |  set(${setterParamName(s)}) {
           |    ${visit(s.compoundStatement())}
           |  }
           |}""".stripMargin

      case _ => ""
    }
  }

  private def setterParamName(ctx: MethodDefinitionContext): String =
    {
      for {
        mSel <- ctx.methodSelector()
        kwDecl <- mSel.keywordDeclarator().headOption
        idf <- kwDecl.children.toList.lastOption
      } yield idf.getText
    } getOrElse defaultResult()

  /**
   * property_attributes_declaration:
   *   '(' property_attributes_list ')' ;
   *
   * @param ctx
   * @return
   */
  override def visitPropertyAttributesDeclaration(ctx: PropertyAttributesDeclarationContext) =
    visitChildren(ctx)


  /**
   * property_attributes_list:
   *   property_attribute (',' property_attribute)* ;
   *
   * @param ctx
   * @return
   */
  override def visitPropertyAttributesList(ctx: PropertyAttributesListContext) =
    visitChildren(ctx, ", ")

  /**
   * property_attribute
   *  : 'nonatomic' | 'assign' | 'weak' | 'strong' | 'retain' | 'readonly' | 'readwrite' |
   *  | 'getter' '=' IDENTIFIER //  getter
   *  | 'setter' '=' IDENTIFIER ':' // setter
   *  | IDENTIFIER
   *  ;
   *
   * MEMO this result will not be used.
   *
   * @param ctx
   * @return
   */
  override def visitPropertyAttribute(ctx: PropertyAttributeContext) =
    ctx.getText

}
