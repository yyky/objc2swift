package org.objc2swift.misc

import scala.language.implicitConversions

class Optionable[T <: AnyRef](value: T) {
  def toOption: Option[T] = if ( value == null ) None else Option(value)
}

object Optionable {
  implicit def anyRefToOptionable[T <: AnyRef](value: T) = new Optionable(value)
}