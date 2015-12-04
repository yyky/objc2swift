// Generated from ObjC.g4 by ANTLR 4.5
package org.objc2swift.converter
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

/**
 * This class provides an empty implementation of {@link ObjCVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
class ObjCBaseVisitor[T] extends AbstractParseTreeVisitor[T] with ObjCVisitor[T] {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTranslation_unit(ctx: ObjCParser.Translation_unitContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitExternal_declaration(ctx: ObjCParser.External_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPreprocessor_declaration(ctx: ObjCParser.Preprocessor_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_interface(ctx: ObjCParser.Class_interfaceContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategory_interface(ctx: ObjCParser.Category_interfaceContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_implementation(ctx: ObjCParser.Class_implementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategory_implementation(ctx: ObjCParser.Category_implementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_declaration(ctx: ObjCParser.Protocol_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_declaration_list(ctx: ObjCParser.Protocol_declaration_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_declaration_list(ctx: ObjCParser.Class_declaration_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_list(ctx: ObjCParser.Class_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_reference_list(ctx: ObjCParser.Protocol_reference_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_list(ctx: ObjCParser.Protocol_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_declaration(ctx: ObjCParser.Property_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_attributes_declaration(ctx: ObjCParser.Property_attributes_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_attributes_list(ctx: ObjCParser.Property_attributes_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_attribute(ctx: ObjCParser.Property_attributeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitIb_outlet_specifier(ctx: ObjCParser.Ib_outlet_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_name(ctx: ObjCParser.Class_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSuperclass_name(ctx: ObjCParser.Superclass_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategory_name(ctx: ObjCParser.Category_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_name(ctx: ObjCParser.Protocol_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstance_variables(ctx: ObjCParser.Instance_variablesContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitVisibility_specification(ctx: ObjCParser.Visibility_specificationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInterface_declaration_list(ctx: ObjCParser.Interface_declaration_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_method_declaration(ctx: ObjCParser.Class_method_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstance_method_declaration(ctx: ObjCParser.Instance_method_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethod_declaration(ctx: ObjCParser.Method_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitImplementation_definition_list(ctx: ObjCParser.Implementation_definition_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClass_method_definition(ctx: ObjCParser.Class_method_definitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstance_method_definition(ctx: ObjCParser.Instance_method_definitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethod_definition(ctx: ObjCParser.Method_definitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethod_selector(ctx: ObjCParser.Method_selectorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitKeyword_declarator(ctx: ObjCParser.Keyword_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelector(ctx: ObjCParser.SelectorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethod_type(ctx: ObjCParser.Method_typeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_implementation(ctx: ObjCParser.Property_implementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_synthesize_list(ctx: ObjCParser.Property_synthesize_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProperty_synthesize_item(ctx: ObjCParser.Property_synthesize_itemContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlock_type(ctx: ObjCParser.Block_typeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitType_specifier(ctx: ObjCParser.Type_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitType_qualifier(ctx: ObjCParser.Type_qualifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_qualifier(ctx: ObjCParser.Protocol_qualifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPrimary_expression(ctx: ObjCParser.Primary_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDictionary_pair(ctx: ObjCParser.Dictionary_pairContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDictionary_expression(ctx: ObjCParser.Dictionary_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArray_expression(ctx: ObjCParser.Array_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBox_expression(ctx: ObjCParser.Box_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlock_parameters(ctx: ObjCParser.Block_parametersContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlock_expression(ctx: ObjCParser.Block_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMessage_expression(ctx: ObjCParser.Message_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitReceiver(ctx: ObjCParser.ReceiverContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMessage_selector(ctx: ObjCParser.Message_selectorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitKeyword_argument(ctx: ObjCParser.Keyword_argumentContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelector_expression(ctx: ObjCParser.Selector_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelector_name(ctx: ObjCParser.Selector_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocol_expression(ctx: ObjCParser.Protocol_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEncode_expression(ctx: ObjCParser.Encode_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitType_variable_declarator(ctx: ObjCParser.Type_variable_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTry_statement(ctx: ObjCParser.Try_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCatch_statement(ctx: ObjCParser.Catch_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFinally_statement(ctx: ObjCParser.Finally_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitThrow_statement(ctx: ObjCParser.Throw_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTry_block(ctx: ObjCParser.Try_blockContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSynchronized_statement(ctx: ObjCParser.Synchronized_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAutorelease_statement(ctx: ObjCParser.Autorelease_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFunction_definition(ctx: ObjCParser.Function_definitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDeclaration(ctx: ObjCParser.DeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDeclaration_specifiers(ctx: ObjCParser.Declaration_specifiersContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArc_behaviour_specifier(ctx: ObjCParser.Arc_behaviour_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStorage_class_specifier(ctx: ObjCParser.Storage_class_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInit_declarator_list(ctx: ObjCParser.Init_declarator_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInit_declarator(ctx: ObjCParser.Init_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStruct_or_union_specifier(ctx: ObjCParser.Struct_or_union_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStruct_declaration(ctx: ObjCParser.Struct_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSpecifier_qualifier_list(ctx: ObjCParser.Specifier_qualifier_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStruct_declarator_list(ctx: ObjCParser.Struct_declarator_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStruct_declarator(ctx: ObjCParser.Struct_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEnum_specifier(ctx: ObjCParser.Enum_specifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEnumerator_list(ctx: ObjCParser.Enumerator_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEnumerator(ctx: ObjCParser.EnumeratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPointer(ctx: ObjCParser.PointerContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDeclarator(ctx: ObjCParser.DeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDirect_declarator(ctx: ObjCParser.Direct_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDeclarator_suffix(ctx: ObjCParser.Declarator_suffixContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameter_list(ctx: ObjCParser.Parameter_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameter_declaration(ctx: ObjCParser.Parameter_declarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInitializer(ctx: ObjCParser.InitializerContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitType_name(ctx: ObjCParser.Type_nameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAbstract_declarator(ctx: ObjCParser.Abstract_declaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAbstract_declarator_suffix(ctx: ObjCParser.Abstract_declarator_suffixContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameter_declaration_list(ctx: ObjCParser.Parameter_declaration_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStatement_list(ctx: ObjCParser.Statement_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStatement(ctx: ObjCParser.StatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitLabeled_statement(ctx: ObjCParser.Labeled_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCompound_statement(ctx: ObjCParser.Compound_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelection_statement(ctx: ObjCParser.Selection_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFor_in_statement(ctx: ObjCParser.For_in_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFor_statement(ctx: ObjCParser.For_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitWhile_statement(ctx: ObjCParser.While_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDo_statement(ctx: ObjCParser.Do_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitIteration_statement(ctx: ObjCParser.Iteration_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitJump_statement(ctx: ObjCParser.Jump_statementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitExpression(ctx: ObjCParser.ExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAssignment_expression(ctx: ObjCParser.Assignment_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAssignment_operator(ctx: ObjCParser.Assignment_operatorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitConditional_expression(ctx: ObjCParser.Conditional_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitConstant_expression(ctx: ObjCParser.Constant_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitLogical_or_expression(ctx: ObjCParser.Logical_or_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitLogical_and_expression(ctx: ObjCParser.Logical_and_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInclusive_or_expression(ctx: ObjCParser.Inclusive_or_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitExclusive_or_expression(ctx: ObjCParser.Exclusive_or_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAnd_expression(ctx: ObjCParser.And_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEquality_expression(ctx: ObjCParser.Equality_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitRelational_expression(ctx: ObjCParser.Relational_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitShift_expression(ctx: ObjCParser.Shift_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAdditive_expression(ctx: ObjCParser.Additive_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMultiplicative_expression(ctx: ObjCParser.Multiplicative_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCast_expression(ctx: ObjCParser.Cast_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitUnary_expression(ctx: ObjCParser.Unary_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitUnary_operator(ctx: ObjCParser.Unary_operatorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPostfix_expression(ctx: ObjCParser.Postfix_expressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArgument_expression_list(ctx: ObjCParser.Argument_expression_listContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitIdentifier(ctx: ObjCParser.IdentifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitConstant(ctx: ObjCParser.ConstantContext) = visitChildren(ctx) 
}