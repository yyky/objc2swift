package org.objc2swift.converter

import org.objc2swift.converter.ObjCParser.{ExternalDeclarationContext, TranslationUnitContext}

import scala.collection.JavaConversions._

/**
 * Created by takesano on 15/11/13.
 */
trait RootVisitor {
  this: ObjC2SwiftBaseConverter =>

  protected val root: TranslationUnitContext

  /**
   * translation_unit:
   *   external_declaration+ EOF;
   *
   * @param ctx
   * @return
   */
  override def visitTranslationUnit(ctx: TranslationUnitContext): String =
    visitChildrenAs(ctx, "\n") {
      case c if !isVisited(c) =>
        visit(c) match {
          case r if r.lines.size > 1 => r + "\n"
          case r => r
        }
    }.trim

  /**
   * external_declaration
   *   : COMMENT
   *   | LINE_COMMENT
   *   | preprocessor_declaration
   *   | function_definition
   *   | declaration
   *   | class_interface
   *   | class_implementation
   *   | category_interface
   *   | category_implementation
   *   | protocol_declaration
   *   | protocol_declaration_list
   *   | class_declaration_list
   *   ;
   *
   * @param ctx
   * @return
   */
  override def visitExternalDeclaration(ctx: ExternalDeclarationContext): String =
    visitChildren(ctx)

}
