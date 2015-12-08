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
	override def visitTranslationUnit(ctx: ObjCParser.TranslationUnitContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitExternalDeclaration(ctx: ObjCParser.ExternalDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPreprocessorDeclaration(ctx: ObjCParser.PreprocessorDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassInterface(ctx: ObjCParser.ClassInterfaceContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategoryInterface(ctx: ObjCParser.CategoryInterfaceContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassImplementation(ctx: ObjCParser.ClassImplementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategoryImplementation(ctx: ObjCParser.CategoryImplementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolDeclaration(ctx: ObjCParser.ProtocolDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolDeclarationList(ctx: ObjCParser.ProtocolDeclarationListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassDeclarationList(ctx: ObjCParser.ClassDeclarationListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassList(ctx: ObjCParser.ClassListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolReferenceList(ctx: ObjCParser.ProtocolReferenceListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolList(ctx: ObjCParser.ProtocolListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertyDeclaration(ctx: ObjCParser.PropertyDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertyAttributesDeclaration(ctx: ObjCParser.PropertyAttributesDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertyAttributesList(ctx: ObjCParser.PropertyAttributesListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertyAttribute(ctx: ObjCParser.PropertyAttributeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitIbOutletSpecifier(ctx: ObjCParser.IbOutletSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassName(ctx: ObjCParser.ClassNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSuperclassName(ctx: ObjCParser.SuperclassNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCategoryName(ctx: ObjCParser.CategoryNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolName(ctx: ObjCParser.ProtocolNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstanceVariables(ctx: ObjCParser.InstanceVariablesContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitVisibilitySpecification(ctx: ObjCParser.VisibilitySpecificationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInterfaceDeclarationList(ctx: ObjCParser.InterfaceDeclarationListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassMethodDeclaration(ctx: ObjCParser.ClassMethodDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstanceMethodDeclaration(ctx: ObjCParser.InstanceMethodDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethodDeclaration(ctx: ObjCParser.MethodDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitImplementationDefinitionList(ctx: ObjCParser.ImplementationDefinitionListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitClassMethodDefinition(ctx: ObjCParser.ClassMethodDefinitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInstanceMethodDefinition(ctx: ObjCParser.InstanceMethodDefinitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethodDefinition(ctx: ObjCParser.MethodDefinitionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMethodSelector(ctx: ObjCParser.MethodSelectorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitKeywordDeclarator(ctx: ObjCParser.KeywordDeclaratorContext) = visitChildren(ctx) 
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
	override def visitMethodType(ctx: ObjCParser.MethodTypeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertyImplementation(ctx: ObjCParser.PropertyImplementationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertySynthesizeList(ctx: ObjCParser.PropertySynthesizeListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPropertySynthesizeItem(ctx: ObjCParser.PropertySynthesizeItemContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlockType(ctx: ObjCParser.BlockTypeContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTypeSpecifier(ctx: ObjCParser.TypeSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTypeQualifier(ctx: ObjCParser.TypeQualifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolQualifier(ctx: ObjCParser.ProtocolQualifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPrimaryExpression(ctx: ObjCParser.PrimaryExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDictionaryPair(ctx: ObjCParser.DictionaryPairContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDictionaryExpression(ctx: ObjCParser.DictionaryExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArrayExpression(ctx: ObjCParser.ArrayExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBoxExpression(ctx: ObjCParser.BoxExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlockParameters(ctx: ObjCParser.BlockParametersContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitBlockExpression(ctx: ObjCParser.BlockExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMessageExpression(ctx: ObjCParser.MessageExpressionContext) = visitChildren(ctx) 
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
	override def visitMessageSelector(ctx: ObjCParser.MessageSelectorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitKeywordArgument(ctx: ObjCParser.KeywordArgumentContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelectorExpression(ctx: ObjCParser.SelectorExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelectorName(ctx: ObjCParser.SelectorNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitProtocolExpression(ctx: ObjCParser.ProtocolExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEncodeExpression(ctx: ObjCParser.EncodeExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTypeVariableDeclarator(ctx: ObjCParser.TypeVariableDeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTryStatement(ctx: ObjCParser.TryStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCatchStatement(ctx: ObjCParser.CatchStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFinallyStatement(ctx: ObjCParser.FinallyStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitThrowStatement(ctx: ObjCParser.ThrowStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitTryBlock(ctx: ObjCParser.TryBlockContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSynchronizedStatement(ctx: ObjCParser.SynchronizedStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAutoreleaseStatement(ctx: ObjCParser.AutoreleaseStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitFunctionDefinition(ctx: ObjCParser.FunctionDefinitionContext) = visitChildren(ctx) 
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
	override def visitDeclarationSpecifiers(ctx: ObjCParser.DeclarationSpecifiersContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArcBehaviourSpecifier(ctx: ObjCParser.ArcBehaviourSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStorageClassSpecifier(ctx: ObjCParser.StorageClassSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInitDeclaratorList(ctx: ObjCParser.InitDeclaratorListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInitDeclarator(ctx: ObjCParser.InitDeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStructOrUnionSpecifier(ctx: ObjCParser.StructOrUnionSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStructDeclaration(ctx: ObjCParser.StructDeclarationContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSpecifierQualifierList(ctx: ObjCParser.SpecifierQualifierListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStructDeclaratorList(ctx: ObjCParser.StructDeclaratorListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStructDeclarator(ctx: ObjCParser.StructDeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEnumSpecifier(ctx: ObjCParser.EnumSpecifierContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEnumeratorList(ctx: ObjCParser.EnumeratorListContext) = visitChildren(ctx) 
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
	override def visitDirectDeclarator(ctx: ObjCParser.DirectDeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDeclaratorSuffix(ctx: ObjCParser.DeclaratorSuffixContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameterList(ctx: ObjCParser.ParameterListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameterDeclaration(ctx: ObjCParser.ParameterDeclarationContext) = visitChildren(ctx) 
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
	override def visitTypeName(ctx: ObjCParser.TypeNameContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAbstractDeclarator(ctx: ObjCParser.AbstractDeclaratorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAbstractDeclaratorSuffix(ctx: ObjCParser.AbstractDeclaratorSuffixContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitParameterDeclarationList(ctx: ObjCParser.ParameterDeclarationListContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitStatementList(ctx: ObjCParser.StatementListContext) = visitChildren(ctx) 
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
	override def visitLabeledStatement(ctx: ObjCParser.LabeledStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCompoundStatement(ctx: ObjCParser.CompoundStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitSelectionStatement(ctx: ObjCParser.SelectionStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitForInStatement(ctx: ObjCParser.ForInStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitForStatement(ctx: ObjCParser.ForStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitWhileStatement(ctx: ObjCParser.WhileStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitDoStatement(ctx: ObjCParser.DoStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitIterationStatement(ctx: ObjCParser.IterationStatementContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitJumpStatement(ctx: ObjCParser.JumpStatementContext) = visitChildren(ctx) 
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
	override def visitAssignmentExpression(ctx: ObjCParser.AssignmentExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAssignmentOperator(ctx: ObjCParser.AssignmentOperatorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitConditionalExpression(ctx: ObjCParser.ConditionalExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitConstantExpression(ctx: ObjCParser.ConstantExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitLogicalOrExpression(ctx: ObjCParser.LogicalOrExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitLogicalAndExpression(ctx: ObjCParser.LogicalAndExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitInclusiveOrExpression(ctx: ObjCParser.InclusiveOrExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitExclusiveOrExpression(ctx: ObjCParser.ExclusiveOrExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAndExpression(ctx: ObjCParser.AndExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitEqualityExpression(ctx: ObjCParser.EqualityExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitRelationalExpression(ctx: ObjCParser.RelationalExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitShiftExpression(ctx: ObjCParser.ShiftExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitAdditiveExpression(ctx: ObjCParser.AdditiveExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitMultiplicativeExpression(ctx: ObjCParser.MultiplicativeExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitCastExpression(ctx: ObjCParser.CastExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitUnaryExpression(ctx: ObjCParser.UnaryExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitUnaryOperator(ctx: ObjCParser.UnaryOperatorContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitPostfixExpression(ctx: ObjCParser.PostfixExpressionContext) = visitChildren(ctx) 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	override def visitArgumentExpressionList(ctx: ObjCParser.ArgumentExpressionListContext) = visitChildren(ctx) 
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