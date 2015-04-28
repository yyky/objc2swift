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

    // implementation of class
    sb.append(" {\n")

    Option(ctx.interface_declaration_list) match {
      case Some(c) => sb.append(visit(c) + "\n\n")
      case None =>
    }

    findCorrespondingClassImplementation(ctx) match {
      case Some(c) => sb.append(visit(c) + "\n")
      case None =>
    }

    sb.append("\n}")

    sb.toString()
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext) = {
    concatChildResults(ctx, "\n\n")
  }

  override def visitClass_implementation(ctx: Class_implementationContext) = {
    visit(ctx.implementation_definition_list())
  }

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext) = {
    concatChildResults(ctx, "\n\n")
  }
}