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
    sb.append("class " + ctx.class_name.getText)

    if(ctx.superclass_name() != null) {
      sb.append(" : ")
      sb.append(ctx.superclass_name().getText)
    }
    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[Protocol_nameContext])
        .map(_.getText)
      sb.append(", " + protocols.mkString(", "))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      val result = visit(ctx.interface_declaration_list())
      if(result != null) {
        sb.append(result)
      }
    }

    val implCtx = findCorrespondingClassImplementation(ctx)
    if(implCtx != null) {
      Option(implCtx.implementation_definition_list()) match {
        case Some(c) =>
          visit(c) match {
            case s: String => sb.append(s)
            case _ =>
          }
        case _ =>
      }
    }

    sb.append("\n}")

    sb.toString()
  }

  override def visitCategory_interface(ctx: Category_interfaceContext): String = {
    val sb = new StringBuilder()
    sb.append("extension " + ctx.class_name.getText)

    if(ctx.protocol_reference_list() != null) {
      val protocols = ctx.protocol_reference_list()
        .protocol_list()
        .children
        .filter(_.isInstanceOf[Protocol_nameContext])
        .map(_.getText)
      sb.append(" : " + protocols.mkString(", "))
    }

    sb.append(" {\n")
    if(ctx.interface_declaration_list() != null) {
      val result = visit(ctx.interface_declaration_list())
      if(result != null) {
        sb.append(result)
      }
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

  override def visitImplementation_definition_list(ctx: Implementation_definition_listContext): String = {
    concatChildResults(ctx, "")
  }

  override def visitProtocol_name(ctx: Protocol_nameContext) = ctx.getText
  override def visitClass_name(ctx: Class_nameContext) = ctx.getText
}