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

trait DeclarationVisitor extends Converter {
    self: ObjC2SwiftConverter =>

    override def visitDeclaration(ctx: DeclarationContext): String = {
        indent(ctx) + "// TODO: Implement Declaration" + "\n"
    }

}
