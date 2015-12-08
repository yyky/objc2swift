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
	def visitTranslationUnit(ctx: ObjCParser.TranslationUnitContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.external_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitExternalDeclaration(ctx: ObjCParser.ExternalDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.preprocessor_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPreprocessorDeclaration(ctx: ObjCParser.PreprocessorDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassInterface(ctx: ObjCParser.ClassInterfaceContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_interface}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategoryInterface(ctx: ObjCParser.CategoryInterfaceContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassImplementation(ctx: ObjCParser.ClassImplementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategoryImplementation(ctx: ObjCParser.CategoryImplementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolDeclaration(ctx: ObjCParser.ProtocolDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolDeclarationList(ctx: ObjCParser.ProtocolDeclarationListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassDeclarationList(ctx: ObjCParser.ClassDeclarationListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassList(ctx: ObjCParser.ClassListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_reference_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolReferenceList(ctx: ObjCParser.ProtocolReferenceListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolList(ctx: ObjCParser.ProtocolListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertyDeclaration(ctx: ObjCParser.PropertyDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attributes_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertyAttributesDeclaration(ctx: ObjCParser.PropertyAttributesDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attributes_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertyAttributesList(ctx: ObjCParser.PropertyAttributesListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertyAttribute(ctx: ObjCParser.PropertyAttributeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.ib_outlet_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitIbOutletSpecifier(ctx: ObjCParser.IbOutletSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassName(ctx: ObjCParser.ClassNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.superclass_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSuperclassName(ctx: ObjCParser.SuperclassNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.category_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCategoryName(ctx: ObjCParser.CategoryNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolName(ctx: ObjCParser.ProtocolNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstanceVariables(ctx: ObjCParser.InstanceVariablesContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.visibility_specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitVisibilitySpecification(ctx: ObjCParser.VisibilitySpecificationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.interface_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInterfaceDeclarationList(ctx: ObjCParser.InterfaceDeclarationListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassMethodDeclaration(ctx: ObjCParser.ClassMethodDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstanceMethodDeclaration(ctx: ObjCParser.InstanceMethodDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethodDeclaration(ctx: ObjCParser.MethodDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.implementation_definition_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitImplementationDefinitionList(ctx: ObjCParser.ImplementationDefinitionListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.class_method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitClassMethodDefinition(ctx: ObjCParser.ClassMethodDefinitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.instance_method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInstanceMethodDefinition(ctx: ObjCParser.InstanceMethodDefinitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethodDefinition(ctx: ObjCParser.MethodDefinitionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.method_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMethodSelector(ctx: ObjCParser.MethodSelectorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.keyword_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitKeywordDeclarator(ctx: ObjCParser.KeywordDeclaratorContext): T
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
	def visitMethodType(ctx: ObjCParser.MethodTypeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_implementation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertyImplementation(ctx: ObjCParser.PropertyImplementationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_synthesize_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertySynthesizeList(ctx: ObjCParser.PropertySynthesizeListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.property_synthesize_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPropertySynthesizeItem(ctx: ObjCParser.PropertySynthesizeItemContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlockType(ctx: ObjCParser.BlockTypeContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTypeSpecifier(ctx: ObjCParser.TypeSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTypeQualifier(ctx: ObjCParser.TypeQualifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolQualifier(ctx: ObjCParser.ProtocolQualifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPrimaryExpression(ctx: ObjCParser.PrimaryExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.dictionary_pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDictionaryPair(ctx: ObjCParser.DictionaryPairContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.dictionary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDictionaryExpression(ctx: ObjCParser.DictionaryExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.array_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArrayExpression(ctx: ObjCParser.ArrayExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.box_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBoxExpression(ctx: ObjCParser.BoxExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlockParameters(ctx: ObjCParser.BlockParametersContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.block_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitBlockExpression(ctx: ObjCParser.BlockExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.message_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMessageExpression(ctx: ObjCParser.MessageExpressionContext): T
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
	def visitMessageSelector(ctx: ObjCParser.MessageSelectorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.keyword_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitKeywordArgument(ctx: ObjCParser.KeywordArgumentContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selector_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelectorExpression(ctx: ObjCParser.SelectorExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selector_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelectorName(ctx: ObjCParser.SelectorNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.protocol_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitProtocolExpression(ctx: ObjCParser.ProtocolExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.encode_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEncodeExpression(ctx: ObjCParser.EncodeExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.type_variable_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTypeVariableDeclarator(ctx: ObjCParser.TypeVariableDeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.try_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTryStatement(ctx: ObjCParser.TryStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.catch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCatchStatement(ctx: ObjCParser.CatchStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.finally_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFinallyStatement(ctx: ObjCParser.FinallyStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.throw_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitThrowStatement(ctx: ObjCParser.ThrowStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.try_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitTryBlock(ctx: ObjCParser.TryBlockContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.synchronized_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSynchronizedStatement(ctx: ObjCParser.SynchronizedStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.autorelease_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAutoreleaseStatement(ctx: ObjCParser.AutoreleaseStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitFunctionDefinition(ctx: ObjCParser.FunctionDefinitionContext): T
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
	def visitDeclarationSpecifiers(ctx: ObjCParser.DeclarationSpecifiersContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.arc_behaviour_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArcBehaviourSpecifier(ctx: ObjCParser.ArcBehaviourSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.storage_class_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStorageClassSpecifier(ctx: ObjCParser.StorageClassSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.init_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInitDeclaratorList(ctx: ObjCParser.InitDeclaratorListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInitDeclarator(ctx: ObjCParser.InitDeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_or_union_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStructOrUnionSpecifier(ctx: ObjCParser.StructOrUnionSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStructDeclaration(ctx: ObjCParser.StructDeclarationContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.specifier_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSpecifierQualifierList(ctx: ObjCParser.SpecifierQualifierListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStructDeclaratorList(ctx: ObjCParser.StructDeclaratorListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.struct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStructDeclarator(ctx: ObjCParser.StructDeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.enum_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEnumSpecifier(ctx: ObjCParser.EnumSpecifierContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.enumerator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEnumeratorList(ctx: ObjCParser.EnumeratorListContext): T
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
	def visitDirectDeclarator(ctx: ObjCParser.DirectDeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.declarator_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDeclaratorSuffix(ctx: ObjCParser.DeclaratorSuffixContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameterList(ctx: ObjCParser.ParameterListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameterDeclaration(ctx: ObjCParser.ParameterDeclarationContext): T
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
	def visitTypeName(ctx: ObjCParser.TypeNameContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAbstractDeclarator(ctx: ObjCParser.AbstractDeclaratorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.abstract_declarator_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAbstractDeclaratorSuffix(ctx: ObjCParser.AbstractDeclaratorSuffixContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.parameter_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitParameterDeclarationList(ctx: ObjCParser.ParameterDeclarationListContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitStatementList(ctx: ObjCParser.StatementListContext): T
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
	def visitLabeledStatement(ctx: ObjCParser.LabeledStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCompoundStatement(ctx: ObjCParser.CompoundStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitSelectionStatement(ctx: ObjCParser.SelectionStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.for_in_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitForInStatement(ctx: ObjCParser.ForInStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitForStatement(ctx: ObjCParser.ForStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitWhileStatement(ctx: ObjCParser.WhileStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.do_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitDoStatement(ctx: ObjCParser.DoStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitIterationStatement(ctx: ObjCParser.IterationStatementContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitJumpStatement(ctx: ObjCParser.JumpStatementContext): T
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
	def visitAssignmentExpression(ctx: ObjCParser.AssignmentExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.assignment_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAssignmentOperator(ctx: ObjCParser.AssignmentOperatorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitConditionalExpression(ctx: ObjCParser.ConditionalExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitConstantExpression(ctx: ObjCParser.ConstantExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitLogicalOrExpression(ctx: ObjCParser.LogicalOrExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitLogicalAndExpression(ctx: ObjCParser.LogicalAndExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.inclusive_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitInclusiveOrExpression(ctx: ObjCParser.InclusiveOrExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.exclusive_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitExclusiveOrExpression(ctx: ObjCParser.ExclusiveOrExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAndExpression(ctx: ObjCParser.AndExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitEqualityExpression(ctx: ObjCParser.EqualityExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitRelationalExpression(ctx: ObjCParser.RelationalExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitShiftExpression(ctx: ObjCParser.ShiftExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitAdditiveExpression(ctx: ObjCParser.AdditiveExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitMultiplicativeExpression(ctx: ObjCParser.MultiplicativeExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.cast_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitCastExpression(ctx: ObjCParser.CastExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitUnaryExpression(ctx: ObjCParser.UnaryExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitUnaryOperator(ctx: ObjCParser.UnaryOperatorContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitPostfixExpression(ctx: ObjCParser.PostfixExpressionContext): T
	/**
	 * Visit a parse tree produced by {@link ObjCParser.argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	def visitArgumentExpressionList(ctx: ObjCParser.ArgumentExpressionListContext): T
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