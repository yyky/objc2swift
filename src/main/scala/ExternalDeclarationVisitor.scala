import ObjCParser._
import collection.JavaConversions._

trait ExternalDeclarationVisitor extends Converter {
  self: ObjCBaseVisitor[String] =>

  override def visitTranslation_unit(ctx: Translation_unitContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitExternal_declaration(ctx: External_declarationContext): String = {
    concatChildResults(ctx, "\n\n")
  }

  override def visitClass_interface(ctx: Class_interfaceContext): String = {
    val sb = new StringBuilder()

    // class [CLASS-NAME] : [SUPERCLASS], [PROTOCOL1, PROTOCOL2, ...]
    sb.append("class " + visit(ctx.class_name))
    if(ctx.superclass_name() != null) {
      sb.append(" : ")
      sb.append(visit(ctx.superclass_name))
    }
    if(ctx.protocol_reference_list() != null) {
      sb.append(", " + visit(ctx.protocol_reference_list))
    }

    // implementation of class
    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      sb.append(visit(ctx.interface_declaration_list()))
    }

    val implCtx = findCorrespondingClassImplementation(ctx)
    if(implCtx != null && !visited.get(implCtx)) {
      visited.put(implCtx, true)
      sb.append(visit(implCtx.implementation_definition_list()))
    }

    sb.append("\n}")

    sb.toString()
  }

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    val sb = new StringBuilder()

    // extension [CLASS-NAME]
    sb.append("extension " + visit(ctx.class_name))
    if(ctx.protocol_reference_list() != null) {
      sb.append(", " + visit(ctx.protocol_reference_list))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      sb.append(visit(ctx.interface_declaration_list()))
    }
    sb.append("}")

    sb.toString()
  }

  override def visitInterface_declaration_list(ctx: Interface_declaration_listContext): String = {
    concatChildResults(ctx, "\n")
  }

  override def visitClass_implementation(ctx: Class_implementationContext): String = {
    // TODO: Considier what to do
    //concatChildResults(ctx, "")
    ""
  }

  override def visitCategory_implementation(ctx: Category_implementationContext): String = {
    // TODO
    ""
  }

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext) = concatChildResults(ctx, "")

  override def visitClass_name(ctx: Class_nameContext) = ctx.getText
  override def visitSuperclass_name(ctx: Superclass_nameContext) = ctx.getText
  override def visitCategory_name(ctx: Category_nameContext) = ctx.getText

  override def visitProtocol_reference_list(ctx: Protocol_reference_listContext) = visit(ctx.protocol_list)
  override def visitProtocol_list(ctx: Protocol_listContext) = {
    ctx.protocol_name.map(visit).mkString(", ")
  }
  override def visitProtocol_name(ctx: Protocol_nameContext) = ctx.getText
}