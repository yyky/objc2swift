package org.objc2swift.util

import org.antlr.v4.runtime.tree.Tree

import scala.language.implicitConversions

package object antlr {
  implicit class OptionTree[T <: Tree](value: T) {
    def toOption: Option[T] = Option(value)
  }
}