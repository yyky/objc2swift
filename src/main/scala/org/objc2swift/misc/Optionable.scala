package org.objc2swift.misc

import scala.language.implicitConversions

package object optionable {
  implicit class Optionable[T <: AnyRef](value: T) {
    def toOption: Option[T] = Option(value)
  }
}