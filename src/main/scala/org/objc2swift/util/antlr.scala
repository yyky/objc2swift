package org.objc2swift.util

import scala.collection.JavaConversions._
import org.antlr.v4.runtime.tree.Tree
import org.objc2swift.converter.ObjCParser._

import scala.language.implicitConversions

package object antlr {
  implicit class AClassInterfaceContext(ctx: ClassInterfaceContext) {
    def correspondingClassImplementation(root: TranslationUnitContext): Option[ClassImplementationContext] = {
      val className = ctx.className.get.getText

      {
        for {
          extDclCtx <- root.externalDeclaration.toStream
          implCtx <- extDclCtx.classImplementation
          if implCtx.className.get.getText == className
        } yield implCtx
      }.headOption
    }
  }

  implicit class ACategoryInterfaceContext(ctx: CategoryInterfaceContext) {
    def correspondingCategoryImplementation(root: TranslationUnitContext): Option[CategoryImplementationContext] = {
      val className = ctx.className.get.getText
      val categoryName = ctx.categoryName.get.getText

      {
        for {
          extDclCtx <- root.externalDeclaration.toStream
          implCtx <- extDclCtx.categoryImplementation()
          if implCtx.className.get.getText == className
          if implCtx.categoryName.get.getText == categoryName
        } yield implCtx
      }.headOption
    }
  }
}
