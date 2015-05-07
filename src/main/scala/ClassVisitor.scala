import ObjCParser._
import collection.JavaConversions._

trait ClassVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  override def visitClass_name(ctx: Class_nameContext) = ctx.getText
  override def visitSuperclass_name(ctx: Superclass_nameContext) = ctx.getText

  override def visitClass_interface(ctx: Class_interfaceContext): String = {
    val sb = new StringBuilder()

    // class [CLASS-NAME] : [SUPERCLASS], [PROTOCOL1, PROTOCOL2, ...]
    sb.append("class " + visit(ctx.class_name))

    Option(ctx.superclass_name) match {
      case Some(c) => sb.append(" : " + visit(c))
      case None =>
    }
    Option(ctx.protocol_reference_list) match {
      case Some(c) => sb.append(", " + visit(c))
      case None =>
    }

    // TODO merge class-ext (aka unnamed-category)

    // implementation of class
    sb.append(" {\n\n")

    // TODO collect instance-vars from @intf, @impl and class-ext
    // TODO only insert \n\n in between method blocks.

    Option(ctx.interface_declaration_list) match {
      case Some(c) => sb.append(visit(c) + "\n\n")
      case None =>
    }

    findCorrespondingClassImplementation(ctx) match {
      case Some(c) => sb.append(visit(c.implementation_definition_list) + "\n")
      case None =>
    }

    sb.append("\n}")

    sb.toString()
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext) = {
    concatChildResults(ctx, "\n\n")
  }

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext) = {
    concatChildResults(ctx, "\n\n")
  }

  // ignore implementation with no corresponding interface.
  override def visitClass_implementation(ctx: Class_implementationContext) = ""
}