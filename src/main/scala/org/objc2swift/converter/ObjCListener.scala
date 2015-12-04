// Generated from ObjC.g4 by ANTLR 4.5
package org.objc2swift.converter
import org.antlr.v4.runtime.tree.ParseTreeListener

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ObjCParser}.
 */
trait ObjCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ObjCParser.translation_unit}.
	 * @param ctx the parse tree
	 */
	def enterTranslation_unit(ctx: ObjCParser.Translation_unitContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.translation_unit}.
	 * @param ctx the parse tree
	 */
	def exitTranslation_unit(ctx: ObjCParser.Translation_unitContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 */
	def enterExternal_declaration(ctx: ObjCParser.External_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 */
	def exitExternal_declaration(ctx: ObjCParser.External_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 */
	def enterPreprocessor_declaration(ctx: ObjCParser.Preprocessor_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 */
	def exitPreprocessor_declaration(ctx: ObjCParser.Preprocessor_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 */
	def enterClass_interface(ctx: ObjCParser.Class_interfaceContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 */
	def exitClass_interface(ctx: ObjCParser.Class_interfaceContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 */
	def enterCategory_interface(ctx: ObjCParser.Category_interfaceContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 */
	def exitCategory_interface(ctx: ObjCParser.Category_interfaceContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 */
	def enterClass_implementation(ctx: ObjCParser.Class_implementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 */
	def exitClass_implementation(ctx: ObjCParser.Class_implementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 */
	def enterCategory_implementation(ctx: ObjCParser.Category_implementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 */
	def exitCategory_implementation(ctx: ObjCParser.Category_implementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_declaration(ctx: ObjCParser.Protocol_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_declaration(ctx: ObjCParser.Protocol_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_declaration_list(ctx: ObjCParser.Protocol_declaration_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_declaration_list(ctx: ObjCParser.Protocol_declaration_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterClass_declaration_list(ctx: ObjCParser.Class_declaration_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitClass_declaration_list(ctx: ObjCParser.Class_declaration_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 */
	def enterClass_list(ctx: ObjCParser.Class_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 */
	def exitClass_list(ctx: ObjCParser.Class_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_reference_list(ctx: ObjCParser.Protocol_reference_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_reference_list(ctx: ObjCParser.Protocol_reference_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_list(ctx: ObjCParser.Protocol_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_list(ctx: ObjCParser.Protocol_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 */
	def enterProperty_declaration(ctx: ObjCParser.Property_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 */
	def exitProperty_declaration(ctx: ObjCParser.Property_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 */
	def enterProperty_attributes_declaration(ctx: ObjCParser.Property_attributes_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 */
	def exitProperty_attributes_declaration(ctx: ObjCParser.Property_attributes_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 */
	def enterProperty_attributes_list(ctx: ObjCParser.Property_attributes_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 */
	def exitProperty_attributes_list(ctx: ObjCParser.Property_attributes_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 */
	def enterProperty_attribute(ctx: ObjCParser.Property_attributeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 */
	def exitProperty_attribute(ctx: ObjCParser.Property_attributeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 */
	def enterIb_outlet_specifier(ctx: ObjCParser.Ib_outlet_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 */
	def exitIb_outlet_specifier(ctx: ObjCParser.Ib_outlet_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 */
	def enterClass_name(ctx: ObjCParser.Class_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 */
	def exitClass_name(ctx: ObjCParser.Class_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 */
	def enterSuperclass_name(ctx: ObjCParser.Superclass_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 */
	def exitSuperclass_name(ctx: ObjCParser.Superclass_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 */
	def enterCategory_name(ctx: ObjCParser.Category_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 */
	def exitCategory_name(ctx: ObjCParser.Category_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_name(ctx: ObjCParser.Protocol_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_name(ctx: ObjCParser.Protocol_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 */
	def enterInstance_variables(ctx: ObjCParser.Instance_variablesContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 */
	def exitInstance_variables(ctx: ObjCParser.Instance_variablesContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 */
	def enterVisibility_specification(ctx: ObjCParser.Visibility_specificationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 */
	def exitVisibility_specification(ctx: ObjCParser.Visibility_specificationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterInterface_declaration_list(ctx: ObjCParser.Interface_declaration_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitInterface_declaration_list(ctx: ObjCParser.Interface_declaration_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterClass_method_declaration(ctx: ObjCParser.Class_method_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitClass_method_declaration(ctx: ObjCParser.Class_method_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterInstance_method_declaration(ctx: ObjCParser.Instance_method_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitInstance_method_declaration(ctx: ObjCParser.Instance_method_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterMethod_declaration(ctx: ObjCParser.Method_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitMethod_declaration(ctx: ObjCParser.Method_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 */
	def enterImplementation_definition_list(ctx: ObjCParser.Implementation_definition_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 */
	def exitImplementation_definition_list(ctx: ObjCParser.Implementation_definition_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 */
	def enterClass_method_definition(ctx: ObjCParser.Class_method_definitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 */
	def exitClass_method_definition(ctx: ObjCParser.Class_method_definitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 */
	def enterInstance_method_definition(ctx: ObjCParser.Instance_method_definitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 */
	def exitInstance_method_definition(ctx: ObjCParser.Instance_method_definitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 */
	def enterMethod_definition(ctx: ObjCParser.Method_definitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 */
	def exitMethod_definition(ctx: ObjCParser.Method_definitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 */
	def enterMethod_selector(ctx: ObjCParser.Method_selectorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 */
	def exitMethod_selector(ctx: ObjCParser.Method_selectorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 */
	def enterKeyword_declarator(ctx: ObjCParser.Keyword_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 */
	def exitKeyword_declarator(ctx: ObjCParser.Keyword_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selector}.
	 * @param ctx the parse tree
	 */
	def enterSelector(ctx: ObjCParser.SelectorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selector}.
	 * @param ctx the parse tree
	 */
	def exitSelector(ctx: ObjCParser.SelectorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_type}.
	 * @param ctx the parse tree
	 */
	def enterMethod_type(ctx: ObjCParser.Method_typeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_type}.
	 * @param ctx the parse tree
	 */
	def exitMethod_type(ctx: ObjCParser.Method_typeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 */
	def enterProperty_implementation(ctx: ObjCParser.Property_implementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 */
	def exitProperty_implementation(ctx: ObjCParser.Property_implementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 */
	def enterProperty_synthesize_list(ctx: ObjCParser.Property_synthesize_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 */
	def exitProperty_synthesize_list(ctx: ObjCParser.Property_synthesize_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 */
	def enterProperty_synthesize_item(ctx: ObjCParser.Property_synthesize_itemContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 */
	def exitProperty_synthesize_item(ctx: ObjCParser.Property_synthesize_itemContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 */
	def enterBlock_type(ctx: ObjCParser.Block_typeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 */
	def exitBlock_type(ctx: ObjCParser.Block_typeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 */
	def enterType_specifier(ctx: ObjCParser.Type_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 */
	def exitType_specifier(ctx: ObjCParser.Type_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 */
	def enterType_qualifier(ctx: ObjCParser.Type_qualifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 */
	def exitType_qualifier(ctx: ObjCParser.Type_qualifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_qualifier(ctx: ObjCParser.Protocol_qualifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_qualifier(ctx: ObjCParser.Protocol_qualifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 */
	def enterPrimary_expression(ctx: ObjCParser.Primary_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 */
	def exitPrimary_expression(ctx: ObjCParser.Primary_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 */
	def enterDictionary_pair(ctx: ObjCParser.Dictionary_pairContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 */
	def exitDictionary_pair(ctx: ObjCParser.Dictionary_pairContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 */
	def enterDictionary_expression(ctx: ObjCParser.Dictionary_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 */
	def exitDictionary_expression(ctx: ObjCParser.Dictionary_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 */
	def enterArray_expression(ctx: ObjCParser.Array_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 */
	def exitArray_expression(ctx: ObjCParser.Array_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 */
	def enterBox_expression(ctx: ObjCParser.Box_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 */
	def exitBox_expression(ctx: ObjCParser.Box_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 */
	def enterBlock_parameters(ctx: ObjCParser.Block_parametersContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 */
	def exitBlock_parameters(ctx: ObjCParser.Block_parametersContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 */
	def enterBlock_expression(ctx: ObjCParser.Block_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 */
	def exitBlock_expression(ctx: ObjCParser.Block_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 */
	def enterMessage_expression(ctx: ObjCParser.Message_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 */
	def exitMessage_expression(ctx: ObjCParser.Message_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.receiver}.
	 * @param ctx the parse tree
	 */
	def enterReceiver(ctx: ObjCParser.ReceiverContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.receiver}.
	 * @param ctx the parse tree
	 */
	def exitReceiver(ctx: ObjCParser.ReceiverContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.message_selector}.
	 * @param ctx the parse tree
	 */
	def enterMessage_selector(ctx: ObjCParser.Message_selectorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.message_selector}.
	 * @param ctx the parse tree
	 */
	def exitMessage_selector(ctx: ObjCParser.Message_selectorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 */
	def enterKeyword_argument(ctx: ObjCParser.Keyword_argumentContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 */
	def exitKeyword_argument(ctx: ObjCParser.Keyword_argumentContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 */
	def enterSelector_expression(ctx: ObjCParser.Selector_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 */
	def exitSelector_expression(ctx: ObjCParser.Selector_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 */
	def enterSelector_name(ctx: ObjCParser.Selector_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 */
	def exitSelector_name(ctx: ObjCParser.Selector_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 */
	def enterProtocol_expression(ctx: ObjCParser.Protocol_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 */
	def exitProtocol_expression(ctx: ObjCParser.Protocol_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 */
	def enterEncode_expression(ctx: ObjCParser.Encode_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 */
	def exitEncode_expression(ctx: ObjCParser.Encode_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 */
	def enterType_variable_declarator(ctx: ObjCParser.Type_variable_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 */
	def exitType_variable_declarator(ctx: ObjCParser.Type_variable_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 */
	def enterTry_statement(ctx: ObjCParser.Try_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 */
	def exitTry_statement(ctx: ObjCParser.Try_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 */
	def enterCatch_statement(ctx: ObjCParser.Catch_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 */
	def exitCatch_statement(ctx: ObjCParser.Catch_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 */
	def enterFinally_statement(ctx: ObjCParser.Finally_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 */
	def exitFinally_statement(ctx: ObjCParser.Finally_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 */
	def enterThrow_statement(ctx: ObjCParser.Throw_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 */
	def exitThrow_statement(ctx: ObjCParser.Throw_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 */
	def enterTry_block(ctx: ObjCParser.Try_blockContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 */
	def exitTry_block(ctx: ObjCParser.Try_blockContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 */
	def enterSynchronized_statement(ctx: ObjCParser.Synchronized_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 */
	def exitSynchronized_statement(ctx: ObjCParser.Synchronized_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 */
	def enterAutorelease_statement(ctx: ObjCParser.Autorelease_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 */
	def exitAutorelease_statement(ctx: ObjCParser.Autorelease_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 */
	def enterFunction_definition(ctx: ObjCParser.Function_definitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 */
	def exitFunction_definition(ctx: ObjCParser.Function_definitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.declaration}.
	 * @param ctx the parse tree
	 */
	def enterDeclaration(ctx: ObjCParser.DeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declaration}.
	 * @param ctx the parse tree
	 */
	def exitDeclaration(ctx: ObjCParser.DeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.declaration_specifiers}.
	 * @param ctx the parse tree
	 */
	def enterDeclaration_specifiers(ctx: ObjCParser.Declaration_specifiersContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declaration_specifiers}.
	 * @param ctx the parse tree
	 */
	def exitDeclaration_specifiers(ctx: ObjCParser.Declaration_specifiersContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 */
	def enterArc_behaviour_specifier(ctx: ObjCParser.Arc_behaviour_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 */
	def exitArc_behaviour_specifier(ctx: ObjCParser.Arc_behaviour_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 */
	def enterStorage_class_specifier(ctx: ObjCParser.Storage_class_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 */
	def exitStorage_class_specifier(ctx: ObjCParser.Storage_class_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 */
	def enterInit_declarator_list(ctx: ObjCParser.Init_declarator_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 */
	def exitInit_declarator_list(ctx: ObjCParser.Init_declarator_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 */
	def enterInit_declarator(ctx: ObjCParser.Init_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 */
	def exitInit_declarator(ctx: ObjCParser.Init_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	def enterStruct_or_union_specifier(ctx: ObjCParser.Struct_or_union_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	def exitStruct_or_union_specifier(ctx: ObjCParser.Struct_or_union_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 */
	def enterStruct_declaration(ctx: ObjCParser.Struct_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 */
	def exitStruct_declaration(ctx: ObjCParser.Struct_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	def enterSpecifier_qualifier_list(ctx: ObjCParser.Specifier_qualifier_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	def exitSpecifier_qualifier_list(ctx: ObjCParser.Specifier_qualifier_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	def enterStruct_declarator_list(ctx: ObjCParser.Struct_declarator_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	def exitStruct_declarator_list(ctx: ObjCParser.Struct_declarator_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 */
	def enterStruct_declarator(ctx: ObjCParser.Struct_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 */
	def exitStruct_declarator(ctx: ObjCParser.Struct_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 */
	def enterEnum_specifier(ctx: ObjCParser.Enum_specifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 */
	def exitEnum_specifier(ctx: ObjCParser.Enum_specifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 */
	def enterEnumerator_list(ctx: ObjCParser.Enumerator_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 */
	def exitEnumerator_list(ctx: ObjCParser.Enumerator_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.enumerator}.
	 * @param ctx the parse tree
	 */
	def enterEnumerator(ctx: ObjCParser.EnumeratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.enumerator}.
	 * @param ctx the parse tree
	 */
	def exitEnumerator(ctx: ObjCParser.EnumeratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.pointer}.
	 * @param ctx the parse tree
	 */
	def enterPointer(ctx: ObjCParser.PointerContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.pointer}.
	 * @param ctx the parse tree
	 */
	def exitPointer(ctx: ObjCParser.PointerContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.declarator}.
	 * @param ctx the parse tree
	 */
	def enterDeclarator(ctx: ObjCParser.DeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declarator}.
	 * @param ctx the parse tree
	 */
	def exitDeclarator(ctx: ObjCParser.DeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.direct_declarator}.
	 * @param ctx the parse tree
	 */
	def enterDirect_declarator(ctx: ObjCParser.Direct_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.direct_declarator}.
	 * @param ctx the parse tree
	 */
	def exitDirect_declarator(ctx: ObjCParser.Direct_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def enterDeclarator_suffix(ctx: ObjCParser.Declarator_suffixContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def exitDeclarator_suffix(ctx: ObjCParser.Declarator_suffixContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 */
	def enterParameter_list(ctx: ObjCParser.Parameter_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 */
	def exitParameter_list(ctx: ObjCParser.Parameter_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 */
	def enterParameter_declaration(ctx: ObjCParser.Parameter_declarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 */
	def exitParameter_declaration(ctx: ObjCParser.Parameter_declarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.initializer}.
	 * @param ctx the parse tree
	 */
	def enterInitializer(ctx: ObjCParser.InitializerContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.initializer}.
	 * @param ctx the parse tree
	 */
	def exitInitializer(ctx: ObjCParser.InitializerContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_name}.
	 * @param ctx the parse tree
	 */
	def enterType_name(ctx: ObjCParser.Type_nameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_name}.
	 * @param ctx the parse tree
	 */
	def exitType_name(ctx: ObjCParser.Type_nameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 */
	def enterAbstract_declarator(ctx: ObjCParser.Abstract_declaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 */
	def exitAbstract_declarator(ctx: ObjCParser.Abstract_declaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def enterAbstract_declarator_suffix(ctx: ObjCParser.Abstract_declarator_suffixContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def exitAbstract_declarator_suffix(ctx: ObjCParser.Abstract_declarator_suffixContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterParameter_declaration_list(ctx: ObjCParser.Parameter_declaration_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitParameter_declaration_list(ctx: ObjCParser.Parameter_declaration_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 */
	def enterStatement_list(ctx: ObjCParser.Statement_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 */
	def exitStatement_list(ctx: ObjCParser.Statement_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.statement}.
	 * @param ctx the parse tree
	 */
	def enterStatement(ctx: ObjCParser.StatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.statement}.
	 * @param ctx the parse tree
	 */
	def exitStatement(ctx: ObjCParser.StatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.labeled_statement}.
	 * @param ctx the parse tree
	 */
	def enterLabeled_statement(ctx: ObjCParser.Labeled_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.labeled_statement}.
	 * @param ctx the parse tree
	 */
	def exitLabeled_statement(ctx: ObjCParser.Labeled_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 */
	def enterCompound_statement(ctx: ObjCParser.Compound_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 */
	def exitCompound_statement(ctx: ObjCParser.Compound_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 */
	def enterSelection_statement(ctx: ObjCParser.Selection_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 */
	def exitSelection_statement(ctx: ObjCParser.Selection_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 */
	def enterFor_in_statement(ctx: ObjCParser.For_in_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 */
	def exitFor_in_statement(ctx: ObjCParser.For_in_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 */
	def enterFor_statement(ctx: ObjCParser.For_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 */
	def exitFor_statement(ctx: ObjCParser.For_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 */
	def enterWhile_statement(ctx: ObjCParser.While_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 */
	def exitWhile_statement(ctx: ObjCParser.While_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 */
	def enterDo_statement(ctx: ObjCParser.Do_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 */
	def exitDo_statement(ctx: ObjCParser.Do_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 */
	def enterIteration_statement(ctx: ObjCParser.Iteration_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 */
	def exitIteration_statement(ctx: ObjCParser.Iteration_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 */
	def enterJump_statement(ctx: ObjCParser.Jump_statementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 */
	def exitJump_statement(ctx: ObjCParser.Jump_statementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.expression}.
	 * @param ctx the parse tree
	 */
	def enterExpression(ctx: ObjCParser.ExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.expression}.
	 * @param ctx the parse tree
	 */
	def exitExpression(ctx: ObjCParser.ExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.assignment_expression}.
	 * @param ctx the parse tree
	 */
	def enterAssignment_expression(ctx: ObjCParser.Assignment_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.assignment_expression}.
	 * @param ctx the parse tree
	 */
	def exitAssignment_expression(ctx: ObjCParser.Assignment_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 */
	def enterAssignment_operator(ctx: ObjCParser.Assignment_operatorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 */
	def exitAssignment_operator(ctx: ObjCParser.Assignment_operatorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 */
	def enterConditional_expression(ctx: ObjCParser.Conditional_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 */
	def exitConditional_expression(ctx: ObjCParser.Conditional_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 */
	def enterConstant_expression(ctx: ObjCParser.Constant_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 */
	def exitConstant_expression(ctx: ObjCParser.Constant_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterLogical_or_expression(ctx: ObjCParser.Logical_or_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitLogical_or_expression(ctx: ObjCParser.Logical_or_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 */
	def enterLogical_and_expression(ctx: ObjCParser.Logical_and_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 */
	def exitLogical_and_expression(ctx: ObjCParser.Logical_and_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterInclusive_or_expression(ctx: ObjCParser.Inclusive_or_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitInclusive_or_expression(ctx: ObjCParser.Inclusive_or_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterExclusive_or_expression(ctx: ObjCParser.Exclusive_or_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitExclusive_or_expression(ctx: ObjCParser.Exclusive_or_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 */
	def enterAnd_expression(ctx: ObjCParser.And_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 */
	def exitAnd_expression(ctx: ObjCParser.And_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 */
	def enterEquality_expression(ctx: ObjCParser.Equality_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 */
	def exitEquality_expression(ctx: ObjCParser.Equality_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 */
	def enterRelational_expression(ctx: ObjCParser.Relational_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 */
	def exitRelational_expression(ctx: ObjCParser.Relational_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 */
	def enterShift_expression(ctx: ObjCParser.Shift_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 */
	def exitShift_expression(ctx: ObjCParser.Shift_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 */
	def enterAdditive_expression(ctx: ObjCParser.Additive_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 */
	def exitAdditive_expression(ctx: ObjCParser.Additive_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	def enterMultiplicative_expression(ctx: ObjCParser.Multiplicative_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	def exitMultiplicative_expression(ctx: ObjCParser.Multiplicative_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 */
	def enterCast_expression(ctx: ObjCParser.Cast_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 */
	def exitCast_expression(ctx: ObjCParser.Cast_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 */
	def enterUnary_expression(ctx: ObjCParser.Unary_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 */
	def exitUnary_expression(ctx: ObjCParser.Unary_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 */
	def enterUnary_operator(ctx: ObjCParser.Unary_operatorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 */
	def exitUnary_operator(ctx: ObjCParser.Unary_operatorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 */
	def enterPostfix_expression(ctx: ObjCParser.Postfix_expressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 */
	def exitPostfix_expression(ctx: ObjCParser.Postfix_expressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 */
	def enterArgument_expression_list(ctx: ObjCParser.Argument_expression_listContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 */
	def exitArgument_expression_list(ctx: ObjCParser.Argument_expression_listContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.identifier}.
	 * @param ctx the parse tree
	 */
	def enterIdentifier(ctx: ObjCParser.IdentifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.identifier}.
	 * @param ctx the parse tree
	 */
	def exitIdentifier(ctx: ObjCParser.IdentifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.constant}.
	 * @param ctx the parse tree
	 */
	def enterConstant(ctx: ObjCParser.ConstantContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.constant}.
	 * @param ctx the parse tree
	 */
	def exitConstant(ctx: ObjCParser.ConstantContext): Unit
}