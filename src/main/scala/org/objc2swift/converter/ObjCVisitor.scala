// Generated from ObjC.g4 by ANTLR 4.5
package org.objc2swift.converter
import org.antlr.v4.runtime.tree.ParseTreeVisitor

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ObjCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
trait ObjCVisitor[T] extends ParseTreeVisitor[T] {
	/**
	 * Visit a parse tree produced by {@link ObjCParser.translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTranslation_unit(ctx: ObjCParser.Translation_unitContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitExternal_declaration(ctx: ObjCParser.External_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPreprocessor_declaration(ctx: ObjCParser.Preprocessor_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_interface(ctx: ObjCParser.Class_interfaceContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategory_interface(ctx: ObjCParser.Category_interfaceContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_implementation(ctx: ObjCParser.Class_implementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategory_implementation(ctx: ObjCParser.Category_implementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_declaration(ctx: ObjCParser.Protocol_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_declaration_list(ctx: ObjCParser.Protocol_declaration_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_declaration_list(ctx: ObjCParser.Class_declaration_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_list(ctx: ObjCParser.Class_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_reference_list(ctx: ObjCParser.Protocol_reference_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_list(ctx: ObjCParser.Protocol_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_declaration(ctx: ObjCParser.Property_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_attributes_declaration(ctx: ObjCParser.Property_attributes_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_attributes_list(ctx: ObjCParser.Property_attributes_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_attribute(ctx: ObjCParser.Property_attributeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitIb_outlet_specifier(ctx: ObjCParser.Ib_outlet_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_name(ctx: ObjCParser.Class_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSuperclass_name(ctx: ObjCParser.Superclass_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategory_name(ctx: ObjCParser.Category_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_name(ctx: ObjCParser.Protocol_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstance_variables(ctx: ObjCParser.Instance_variablesContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitVisibility_specification(ctx: ObjCParser.Visibility_specificationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInterface_declaration_list(ctx: ObjCParser.Interface_declaration_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_method_declaration(ctx: ObjCParser.Class_method_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstance_method_declaration(ctx: ObjCParser.Instance_method_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethod_declaration(ctx: ObjCParser.Method_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitImplementation_definition_list(ctx: ObjCParser.Implementation_definition_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClass_method_definition(ctx: ObjCParser.Class_method_definitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstance_method_definition(ctx: ObjCParser.Instance_method_definitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethod_definition(ctx: ObjCParser.Method_definitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethod_selector(ctx: ObjCParser.Method_selectorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitKeyword_declarator(ctx: ObjCParser.Keyword_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelector(ctx: ObjCParser.SelectorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethod_type(ctx: ObjCParser.Method_typeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_implementation(ctx: ObjCParser.Property_implementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_synthesize_list(ctx: ObjCParser.Property_synthesize_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProperty_synthesize_item(ctx: ObjCParser.Property_synthesize_itemContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlock_type(ctx: ObjCParser.Block_typeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitType_specifier(ctx: ObjCParser.Type_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitType_qualifier(ctx: ObjCParser.Type_qualifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_qualifier(ctx: ObjCParser.Protocol_qualifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPrimary_expression(ctx: ObjCParser.Primary_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDictionary_pair(ctx: ObjCParser.Dictionary_pairContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDictionary_expression(ctx: ObjCParser.Dictionary_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArray_expression(ctx: ObjCParser.Array_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBox_expression(ctx: ObjCParser.Box_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlock_parameters(ctx: ObjCParser.Block_parametersContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlock_expression(ctx: ObjCParser.Block_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMessage_expression(ctx: ObjCParser.Message_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.receiver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitReceiver(ctx: ObjCParser.ReceiverContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.message_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMessage_selector(ctx: ObjCParser.Message_selectorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitKeyword_argument(ctx: ObjCParser.Keyword_argumentContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelector_expression(ctx: ObjCParser.Selector_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelector_name(ctx: ObjCParser.Selector_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocol_expression(ctx: ObjCParser.Protocol_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEncode_expression(ctx: ObjCParser.Encode_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitType_variable_declarator(ctx: ObjCParser.Type_variable_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTry_statement(ctx: ObjCParser.Try_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCatch_statement(ctx: ObjCParser.Catch_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFinally_statement(ctx: ObjCParser.Finally_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitThrow_statement(ctx: ObjCParser.Throw_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTry_block(ctx: ObjCParser.Try_blockContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSynchronized_statement(ctx: ObjCParser.Synchronized_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAutorelease_statement(ctx: ObjCParser.Autorelease_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFunction_definition(ctx: ObjCParser.Function_definitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDeclaration(ctx: ObjCParser.DeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.declaration_specifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDeclaration_specifiers(ctx: ObjCParser.Declaration_specifiersContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArc_behaviour_specifier(ctx: ObjCParser.Arc_behaviour_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStorage_class_specifier(ctx: ObjCParser.Storage_class_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInit_declarator_list(ctx: ObjCParser.Init_declarator_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInit_declarator(ctx: ObjCParser.Init_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStruct_or_union_specifier(ctx: ObjCParser.Struct_or_union_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStruct_declaration(ctx: ObjCParser.Struct_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSpecifier_qualifier_list(ctx: ObjCParser.Specifier_qualifier_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStruct_declarator_list(ctx: ObjCParser.Struct_declarator_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStruct_declarator(ctx: ObjCParser.Struct_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEnum_specifier(ctx: ObjCParser.Enum_specifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEnumerator_list(ctx: ObjCParser.Enumerator_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEnumerator(ctx: ObjCParser.EnumeratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPointer(ctx: ObjCParser.PointerContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDeclarator(ctx: ObjCParser.DeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.direct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDirect_declarator(ctx: ObjCParser.Direct_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDeclarator_suffix(ctx: ObjCParser.Declarator_suffixContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameter_list(ctx: ObjCParser.Parameter_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameter_declaration(ctx: ObjCParser.Parameter_declarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInitializer(ctx: ObjCParser.InitializerContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitType_name(ctx: ObjCParser.Type_nameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAbstract_declarator(ctx: ObjCParser.Abstract_declaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAbstract_declarator_suffix(ctx: ObjCParser.Abstract_declarator_suffixContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameter_declaration_list(ctx: ObjCParser.Parameter_declaration_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStatement_list(ctx: ObjCParser.Statement_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStatement(ctx: ObjCParser.StatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.labeled_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitLabeled_statement(ctx: ObjCParser.Labeled_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCompound_statement(ctx: ObjCParser.Compound_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelection_statement(ctx: ObjCParser.Selection_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFor_in_statement(ctx: ObjCParser.For_in_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFor_statement(ctx: ObjCParser.For_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitWhile_statement(ctx: ObjCParser.While_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDo_statement(ctx: ObjCParser.Do_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitIteration_statement(ctx: ObjCParser.Iteration_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitJump_statement(ctx: ObjCParser.Jump_statementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitExpression(ctx: ObjCParser.ExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAssignment_expression(ctx: ObjCParser.Assignment_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAssignment_operator(ctx: ObjCParser.Assignment_operatorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitConditional_expression(ctx: ObjCParser.Conditional_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitConstant_expression(ctx: ObjCParser.Constant_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitLogical_or_expression(ctx: ObjCParser.Logical_or_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitLogical_and_expression(ctx: ObjCParser.Logical_and_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInclusive_or_expression(ctx: ObjCParser.Inclusive_or_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitExclusive_or_expression(ctx: ObjCParser.Exclusive_or_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAnd_expression(ctx: ObjCParser.And_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEquality_expression(ctx: ObjCParser.Equality_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitRelational_expression(ctx: ObjCParser.Relational_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitShift_expression(ctx: ObjCParser.Shift_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAdditive_expression(ctx: ObjCParser.Additive_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMultiplicative_expression(ctx: ObjCParser.Multiplicative_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCast_expression(ctx: ObjCParser.Cast_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitUnary_expression(ctx: ObjCParser.Unary_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitUnary_operator(ctx: ObjCParser.Unary_operatorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPostfix_expression(ctx: ObjCParser.Postfix_expressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArgument_expression_list(ctx: ObjCParser.Argument_expression_listContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitIdentifier(ctx: ObjCParser.IdentifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitConstant(ctx: ObjCParser.ConstantContext): T
}