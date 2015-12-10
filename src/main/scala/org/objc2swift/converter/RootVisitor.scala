package org.objc2swift.converter

import org.objc2swift.converter.ObjCParser.{ExternalDeclarationContext, TranslationUnitContext}

import scala.collection.JavaConversions._

/**
 * Created by takesano on 15/11/13.
 */
trait RootVisitor {
  this: ObjC2SwiftBaseConverter =>

  protected val root: TranslationUnitContext

  override def visitTranslationUnit(ctx: TranslationUnitContext): String =
    visitChildren(ctx, "\n\n")

  override def visitExternalDeclaration(ctx: ExternalDeclarationContext): String =
    visitChildren(ctx)
}
