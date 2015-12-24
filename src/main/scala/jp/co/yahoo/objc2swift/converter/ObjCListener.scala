// Generated from ObjC.g4 by ANTLR 4.5
package jp.co.yahoo.objc2swift.converter

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
	def enterTranslationUnit(ctx: ObjCParser.TranslationUnitContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.translation_unit}.
	 * @param ctx the parse tree
	 */
	def exitTranslationUnit(ctx: ObjCParser.TranslationUnitContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 */
	def enterExternalDeclaration(ctx: ObjCParser.ExternalDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 */
	def exitExternalDeclaration(ctx: ObjCParser.ExternalDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 */
	def enterPreprocessorDeclaration(ctx: ObjCParser.PreprocessorDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 */
	def exitPreprocessorDeclaration(ctx: ObjCParser.PreprocessorDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 */
	def enterClassInterface(ctx: ObjCParser.ClassInterfaceContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 */
	def exitClassInterface(ctx: ObjCParser.ClassInterfaceContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 */
	def enterCategoryInterface(ctx: ObjCParser.CategoryInterfaceContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 */
	def exitCategoryInterface(ctx: ObjCParser.CategoryInterfaceContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 */
	def enterClassImplementation(ctx: ObjCParser.ClassImplementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 */
	def exitClassImplementation(ctx: ObjCParser.ClassImplementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 */
	def enterCategoryImplementation(ctx: ObjCParser.CategoryImplementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 */
	def exitCategoryImplementation(ctx: ObjCParser.CategoryImplementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 */
	def enterProtocolDeclaration(ctx: ObjCParser.ProtocolDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 */
	def exitProtocolDeclaration(ctx: ObjCParser.ProtocolDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocolDeclarationList(ctx: ObjCParser.ProtocolDeclarationListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocolDeclarationList(ctx: ObjCParser.ProtocolDeclarationListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterClassDeclarationList(ctx: ObjCParser.ClassDeclarationListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitClassDeclarationList(ctx: ObjCParser.ClassDeclarationListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 */
	def enterClassList(ctx: ObjCParser.ClassListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 */
	def exitClassList(ctx: ObjCParser.ClassListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocolReferenceList(ctx: ObjCParser.ProtocolReferenceListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocolReferenceList(ctx: ObjCParser.ProtocolReferenceListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 */
	def enterProtocolList(ctx: ObjCParser.ProtocolListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 */
	def exitProtocolList(ctx: ObjCParser.ProtocolListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 */
	def enterPropertyDeclaration(ctx: ObjCParser.PropertyDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 */
	def exitPropertyDeclaration(ctx: ObjCParser.PropertyDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 */
	def enterPropertyAttributesDeclaration(ctx: ObjCParser.PropertyAttributesDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 */
	def exitPropertyAttributesDeclaration(ctx: ObjCParser.PropertyAttributesDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 */
	def enterPropertyAttributesList(ctx: ObjCParser.PropertyAttributesListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 */
	def exitPropertyAttributesList(ctx: ObjCParser.PropertyAttributesListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 */
	def enterPropertyAttribute(ctx: ObjCParser.PropertyAttributeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 */
	def exitPropertyAttribute(ctx: ObjCParser.PropertyAttributeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 */
	def enterIbOutletSpecifier(ctx: ObjCParser.IbOutletSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 */
	def exitIbOutletSpecifier(ctx: ObjCParser.IbOutletSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 */
	def enterClassName(ctx: ObjCParser.ClassNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 */
	def exitClassName(ctx: ObjCParser.ClassNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 */
	def enterSuperclassName(ctx: ObjCParser.SuperclassNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 */
	def exitSuperclassName(ctx: ObjCParser.SuperclassNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 */
	def enterCategoryName(ctx: ObjCParser.CategoryNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 */
	def exitCategoryName(ctx: ObjCParser.CategoryNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 */
	def enterProtocolName(ctx: ObjCParser.ProtocolNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 */
	def exitProtocolName(ctx: ObjCParser.ProtocolNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 */
	def enterInstanceVariables(ctx: ObjCParser.InstanceVariablesContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 */
	def exitInstanceVariables(ctx: ObjCParser.InstanceVariablesContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 */
	def enterVisibilitySpecification(ctx: ObjCParser.VisibilitySpecificationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 */
	def exitVisibilitySpecification(ctx: ObjCParser.VisibilitySpecificationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterInterfaceDeclarationList(ctx: ObjCParser.InterfaceDeclarationListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitInterfaceDeclarationList(ctx: ObjCParser.InterfaceDeclarationListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterClassMethodDeclaration(ctx: ObjCParser.ClassMethodDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitClassMethodDeclaration(ctx: ObjCParser.ClassMethodDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterInstanceMethodDeclaration(ctx: ObjCParser.InstanceMethodDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitInstanceMethodDeclaration(ctx: ObjCParser.InstanceMethodDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 */
	def enterMethodDeclaration(ctx: ObjCParser.MethodDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 */
	def exitMethodDeclaration(ctx: ObjCParser.MethodDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 */
	def enterImplementationDefinitionList(ctx: ObjCParser.ImplementationDefinitionListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 */
	def exitImplementationDefinitionList(ctx: ObjCParser.ImplementationDefinitionListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 */
	def enterClassMethodDefinition(ctx: ObjCParser.ClassMethodDefinitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 */
	def exitClassMethodDefinition(ctx: ObjCParser.ClassMethodDefinitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 */
	def enterInstanceMethodDefinition(ctx: ObjCParser.InstanceMethodDefinitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 */
	def exitInstanceMethodDefinition(ctx: ObjCParser.InstanceMethodDefinitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 */
	def enterMethodDefinition(ctx: ObjCParser.MethodDefinitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 */
	def exitMethodDefinition(ctx: ObjCParser.MethodDefinitionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 */
	def enterMethodSelector(ctx: ObjCParser.MethodSelectorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 */
	def exitMethodSelector(ctx: ObjCParser.MethodSelectorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 */
	def enterKeywordDeclarator(ctx: ObjCParser.KeywordDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 */
	def exitKeywordDeclarator(ctx: ObjCParser.KeywordDeclaratorContext): Unit
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
	def enterMethodType(ctx: ObjCParser.MethodTypeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.method_type}.
	 * @param ctx the parse tree
	 */
	def exitMethodType(ctx: ObjCParser.MethodTypeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 */
	def enterPropertyImplementation(ctx: ObjCParser.PropertyImplementationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 */
	def exitPropertyImplementation(ctx: ObjCParser.PropertyImplementationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 */
	def enterPropertySynthesizeList(ctx: ObjCParser.PropertySynthesizeListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 */
	def exitPropertySynthesizeList(ctx: ObjCParser.PropertySynthesizeListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 */
	def enterPropertySynthesizeItem(ctx: ObjCParser.PropertySynthesizeItemContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 */
	def exitPropertySynthesizeItem(ctx: ObjCParser.PropertySynthesizeItemContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 */
	def enterBlockType(ctx: ObjCParser.BlockTypeContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 */
	def exitBlockType(ctx: ObjCParser.BlockTypeContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 */
	def enterTypeSpecifier(ctx: ObjCParser.TypeSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 */
	def exitTypeSpecifier(ctx: ObjCParser.TypeSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 */
	def enterTypeQualifier(ctx: ObjCParser.TypeQualifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 */
	def exitTypeQualifier(ctx: ObjCParser.TypeQualifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 */
	def enterProtocolQualifier(ctx: ObjCParser.ProtocolQualifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 */
	def exitProtocolQualifier(ctx: ObjCParser.ProtocolQualifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 */
	def enterPrimaryExpression(ctx: ObjCParser.PrimaryExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 */
	def exitPrimaryExpression(ctx: ObjCParser.PrimaryExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 */
	def enterDictionaryPair(ctx: ObjCParser.DictionaryPairContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 */
	def exitDictionaryPair(ctx: ObjCParser.DictionaryPairContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 */
	def enterDictionaryExpression(ctx: ObjCParser.DictionaryExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 */
	def exitDictionaryExpression(ctx: ObjCParser.DictionaryExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 */
	def enterArrayExpression(ctx: ObjCParser.ArrayExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 */
	def exitArrayExpression(ctx: ObjCParser.ArrayExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 */
	def enterBoxExpression(ctx: ObjCParser.BoxExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 */
	def exitBoxExpression(ctx: ObjCParser.BoxExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 */
	def enterBlockParameters(ctx: ObjCParser.BlockParametersContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 */
	def exitBlockParameters(ctx: ObjCParser.BlockParametersContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 */
	def enterBlockExpression(ctx: ObjCParser.BlockExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 */
	def exitBlockExpression(ctx: ObjCParser.BlockExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 */
	def enterMessageExpression(ctx: ObjCParser.MessageExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 */
	def exitMessageExpression(ctx: ObjCParser.MessageExpressionContext): Unit
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
	def enterMessageSelector(ctx: ObjCParser.MessageSelectorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.message_selector}.
	 * @param ctx the parse tree
	 */
	def exitMessageSelector(ctx: ObjCParser.MessageSelectorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 */
	def enterKeywordArgument(ctx: ObjCParser.KeywordArgumentContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 */
	def exitKeywordArgument(ctx: ObjCParser.KeywordArgumentContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 */
	def enterSelectorExpression(ctx: ObjCParser.SelectorExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 */
	def exitSelectorExpression(ctx: ObjCParser.SelectorExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 */
	def enterSelectorName(ctx: ObjCParser.SelectorNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 */
	def exitSelectorName(ctx: ObjCParser.SelectorNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 */
	def enterProtocolExpression(ctx: ObjCParser.ProtocolExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 */
	def exitProtocolExpression(ctx: ObjCParser.ProtocolExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 */
	def enterEncodeExpression(ctx: ObjCParser.EncodeExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 */
	def exitEncodeExpression(ctx: ObjCParser.EncodeExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 */
	def enterTypeVariableDeclarator(ctx: ObjCParser.TypeVariableDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 */
	def exitTypeVariableDeclarator(ctx: ObjCParser.TypeVariableDeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 */
	def enterTryStatement(ctx: ObjCParser.TryStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 */
	def exitTryStatement(ctx: ObjCParser.TryStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 */
	def enterCatchStatement(ctx: ObjCParser.CatchStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 */
	def exitCatchStatement(ctx: ObjCParser.CatchStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 */
	def enterFinallyStatement(ctx: ObjCParser.FinallyStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 */
	def exitFinallyStatement(ctx: ObjCParser.FinallyStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 */
	def enterThrowStatement(ctx: ObjCParser.ThrowStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 */
	def exitThrowStatement(ctx: ObjCParser.ThrowStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 */
	def enterTryBlock(ctx: ObjCParser.TryBlockContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 */
	def exitTryBlock(ctx: ObjCParser.TryBlockContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 */
	def enterSynchronizedStatement(ctx: ObjCParser.SynchronizedStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 */
	def exitSynchronizedStatement(ctx: ObjCParser.SynchronizedStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 */
	def enterAutoreleaseStatement(ctx: ObjCParser.AutoreleaseStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 */
	def exitAutoreleaseStatement(ctx: ObjCParser.AutoreleaseStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 */
	def enterFunctionDefinition(ctx: ObjCParser.FunctionDefinitionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 */
	def exitFunctionDefinition(ctx: ObjCParser.FunctionDefinitionContext): Unit
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
	def enterDeclarationSpecifiers(ctx: ObjCParser.DeclarationSpecifiersContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declaration_specifiers}.
	 * @param ctx the parse tree
	 */
	def exitDeclarationSpecifiers(ctx: ObjCParser.DeclarationSpecifiersContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 */
	def enterArcBehaviourSpecifier(ctx: ObjCParser.ArcBehaviourSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 */
	def exitArcBehaviourSpecifier(ctx: ObjCParser.ArcBehaviourSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 */
	def enterStorageClassSpecifier(ctx: ObjCParser.StorageClassSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 */
	def exitStorageClassSpecifier(ctx: ObjCParser.StorageClassSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 */
	def enterInitDeclaratorList(ctx: ObjCParser.InitDeclaratorListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 */
	def exitInitDeclaratorList(ctx: ObjCParser.InitDeclaratorListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 */
	def enterInitDeclarator(ctx: ObjCParser.InitDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 */
	def exitInitDeclarator(ctx: ObjCParser.InitDeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	def enterStructOrUnionSpecifier(ctx: ObjCParser.StructOrUnionSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	def exitStructOrUnionSpecifier(ctx: ObjCParser.StructOrUnionSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 */
	def enterStructDeclaration(ctx: ObjCParser.StructDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 */
	def exitStructDeclaration(ctx: ObjCParser.StructDeclarationContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	def enterSpecifierQualifierList(ctx: ObjCParser.SpecifierQualifierListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	def exitSpecifierQualifierList(ctx: ObjCParser.SpecifierQualifierListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	def enterStructDeclaratorList(ctx: ObjCParser.StructDeclaratorListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	def exitStructDeclaratorList(ctx: ObjCParser.StructDeclaratorListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 */
	def enterStructDeclarator(ctx: ObjCParser.StructDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 */
	def exitStructDeclarator(ctx: ObjCParser.StructDeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 */
	def enterEnumSpecifier(ctx: ObjCParser.EnumSpecifierContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 */
	def exitEnumSpecifier(ctx: ObjCParser.EnumSpecifierContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 */
	def enterEnumeratorList(ctx: ObjCParser.EnumeratorListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 */
	def exitEnumeratorList(ctx: ObjCParser.EnumeratorListContext): Unit
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
	def enterDirectDeclarator(ctx: ObjCParser.DirectDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.direct_declarator}.
	 * @param ctx the parse tree
	 */
	def exitDirectDeclarator(ctx: ObjCParser.DirectDeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def enterDeclaratorSuffix(ctx: ObjCParser.DeclaratorSuffixContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def exitDeclaratorSuffix(ctx: ObjCParser.DeclaratorSuffixContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 */
	def enterParameterList(ctx: ObjCParser.ParameterListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 */
	def exitParameterList(ctx: ObjCParser.ParameterListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 */
	def enterParameterDeclaration(ctx: ObjCParser.ParameterDeclarationContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 */
	def exitParameterDeclaration(ctx: ObjCParser.ParameterDeclarationContext): Unit
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
	def enterTypeName(ctx: ObjCParser.TypeNameContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.type_name}.
	 * @param ctx the parse tree
	 */
	def exitTypeName(ctx: ObjCParser.TypeNameContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 */
	def enterAbstractDeclarator(ctx: ObjCParser.AbstractDeclaratorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 */
	def exitAbstractDeclarator(ctx: ObjCParser.AbstractDeclaratorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def enterAbstractDeclaratorSuffix(ctx: ObjCParser.AbstractDeclaratorSuffixContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 */
	def exitAbstractDeclaratorSuffix(ctx: ObjCParser.AbstractDeclaratorSuffixContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	def enterParameterDeclarationList(ctx: ObjCParser.ParameterDeclarationListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	def exitParameterDeclarationList(ctx: ObjCParser.ParameterDeclarationListContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 */
	def enterStatementList(ctx: ObjCParser.StatementListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 */
	def exitStatementList(ctx: ObjCParser.StatementListContext): Unit
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
	def enterLabeledStatement(ctx: ObjCParser.LabeledStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.labeled_statement}.
	 * @param ctx the parse tree
	 */
	def exitLabeledStatement(ctx: ObjCParser.LabeledStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 */
	def enterCompoundStatement(ctx: ObjCParser.CompoundStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 */
	def exitCompoundStatement(ctx: ObjCParser.CompoundStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 */
	def enterSelectionStatement(ctx: ObjCParser.SelectionStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 */
	def exitSelectionStatement(ctx: ObjCParser.SelectionStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 */
	def enterForInStatement(ctx: ObjCParser.ForInStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 */
	def exitForInStatement(ctx: ObjCParser.ForInStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 */
	def enterForStatement(ctx: ObjCParser.ForStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 */
	def exitForStatement(ctx: ObjCParser.ForStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 */
	def enterWhileStatement(ctx: ObjCParser.WhileStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 */
	def exitWhileStatement(ctx: ObjCParser.WhileStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 */
	def enterDoStatement(ctx: ObjCParser.DoStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 */
	def exitDoStatement(ctx: ObjCParser.DoStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 */
	def enterIterationStatement(ctx: ObjCParser.IterationStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 */
	def exitIterationStatement(ctx: ObjCParser.IterationStatementContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 */
	def enterJumpStatement(ctx: ObjCParser.JumpStatementContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 */
	def exitJumpStatement(ctx: ObjCParser.JumpStatementContext): Unit
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
	def enterAssignmentExpression(ctx: ObjCParser.AssignmentExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.assignment_expression}.
	 * @param ctx the parse tree
	 */
	def exitAssignmentExpression(ctx: ObjCParser.AssignmentExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 */
	def enterAssignmentOperator(ctx: ObjCParser.AssignmentOperatorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 */
	def exitAssignmentOperator(ctx: ObjCParser.AssignmentOperatorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 */
	def enterConditionalExpression(ctx: ObjCParser.ConditionalExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 */
	def exitConditionalExpression(ctx: ObjCParser.ConditionalExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 */
	def enterConstantExpression(ctx: ObjCParser.ConstantExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 */
	def exitConstantExpression(ctx: ObjCParser.ConstantExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterLogicalOrExpression(ctx: ObjCParser.LogicalOrExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitLogicalOrExpression(ctx: ObjCParser.LogicalOrExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 */
	def enterLogicalAndExpression(ctx: ObjCParser.LogicalAndExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 */
	def exitLogicalAndExpression(ctx: ObjCParser.LogicalAndExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterInclusiveOrExpression(ctx: ObjCParser.InclusiveOrExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitInclusiveOrExpression(ctx: ObjCParser.InclusiveOrExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def enterExclusiveOrExpression(ctx: ObjCParser.ExclusiveOrExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 */
	def exitExclusiveOrExpression(ctx: ObjCParser.ExclusiveOrExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 */
	def enterAndExpression(ctx: ObjCParser.AndExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 */
	def exitAndExpression(ctx: ObjCParser.AndExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 */
	def enterEqualityExpression(ctx: ObjCParser.EqualityExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 */
	def exitEqualityExpression(ctx: ObjCParser.EqualityExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 */
	def enterRelationalExpression(ctx: ObjCParser.RelationalExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 */
	def exitRelationalExpression(ctx: ObjCParser.RelationalExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 */
	def enterShiftExpression(ctx: ObjCParser.ShiftExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 */
	def exitShiftExpression(ctx: ObjCParser.ShiftExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 */
	def enterAdditiveExpression(ctx: ObjCParser.AdditiveExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 */
	def exitAdditiveExpression(ctx: ObjCParser.AdditiveExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	def enterMultiplicativeExpression(ctx: ObjCParser.MultiplicativeExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	def exitMultiplicativeExpression(ctx: ObjCParser.MultiplicativeExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 */
	def enterCastExpression(ctx: ObjCParser.CastExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 */
	def exitCastExpression(ctx: ObjCParser.CastExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 */
	def enterUnaryExpression(ctx: ObjCParser.UnaryExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 */
	def exitUnaryExpression(ctx: ObjCParser.UnaryExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 */
	def enterUnaryOperator(ctx: ObjCParser.UnaryOperatorContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 */
	def exitUnaryOperator(ctx: ObjCParser.UnaryOperatorContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 */
	def enterPostfixExpression(ctx: ObjCParser.PostfixExpressionContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 */
	def exitPostfixExpression(ctx: ObjCParser.PostfixExpressionContext): Unit
	/**
	 * Enter a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 */
	def enterArgumentExpressionList(ctx: ObjCParser.ArgumentExpressionListContext): Unit
	/**
	 * Exit a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 */
	def exitArgumentExpressionList(ctx: ObjCParser.ArgumentExpressionListContext): Unit
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