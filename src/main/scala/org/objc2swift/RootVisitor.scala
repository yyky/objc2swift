package org.objc2swift

import org.objc2swift.ObjCParser.{External_declarationContext, Translation_unitContext}
import scala.collection.JavaConversions._

/**
 * Created by takesano on 15/11/13.
 */
trait RootVisitor {
  this: ObjC2SwiftConverter =>

  override def visitTranslation_unit(ctx: Translation_unitContext): String =
    ctx.external_declaration().map(visit).filter(_.nonEmpty).mkString("\n\n")

  override def visitExternal_declaration(ctx: External_declarationContext): String =
    concatChildResults(ctx, "")
}
