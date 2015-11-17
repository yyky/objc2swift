package org.objc2swift.util

import scala.collection.JavaConversions._
import org.antlr.v4.runtime.tree.Tree
import org.objc2swift.converter.ObjCParser._

import scala.language.implicitConversions

package object antlr {
  implicit class OptionTree[T <: Tree](value: T) {
    def toOption: Option[T] = Option(value)
  }

  implicit class AClass_interfaceContext(ctx: Class_interfaceContext) {
    def correspondingClassImplementation(root: Translation_unitContext): Option[Class_implementationContext] = {
      val className = ctx.class_name.getText

      {
        for {
          extDclCtx <- root.external_declaration.toStream
          implCtx <- Option(extDclCtx.class_implementation)
          if implCtx.class_name.getText == className
        } yield implCtx
      }.headOption
    }
  }

  implicit class ACategory_interfaceContext(ctx: Category_interfaceContext) {
    def correspondingCategoryImplementation(root: Translation_unitContext): Option[Category_implementationContext] = {
      val className = ctx.class_name.getText
      val categoryName = ctx.category_name.getText

      {
        for {
          extDclCtx <- root.external_declaration.toStream
          implCtx <- Option(extDclCtx.category_implementation())
          if implCtx.class_name.getText == className
          if implCtx.category_name.getText == categoryName
        } yield implCtx
      }.headOption
    }
  }
}