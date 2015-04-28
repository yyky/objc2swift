/**
 * This file is part of objc2swift.
 * https://github.com/yahoojapan/objc2swift
 *
 * Copyright (c) 2015 Yahoo Japan Corporation
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import ObjCParser._
import collection.JavaConversions._

trait ProtocolVisitor extends Converter {
  override def visitProtocol_name(ctx: Protocol_nameContext) = ctx.getText
  override def visitProtocol_reference_list(ctx: Protocol_reference_listContext) = visit(ctx.protocol_list)
  override def visitProtocol_list(ctx: Protocol_listContext) = {
    ctx.protocol_name.map(visit).mkString(", ")
  }
}
