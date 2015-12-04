// Generated from ObjC.g4 by ANTLR 4.5
package org.objc2swift.converter
import org.antlr.v4.runtime.atn._
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.misc._
import org.antlr.v4.runtime.tree._
import java.util.List
import java.util.Iterator
import java.util.ArrayList
import scala.collection.JavaConverters._

object ObjCParser {
	RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION)

	protected final val _sharedContextCache = new PredictionContextCache()

	class Translation_unitContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def EOF() = getToken(ObjCParser.EOF, 0)
		def external_declaration() = getRuleContexts(classOf[External_declarationContext]).asScala
		def external_declaration(i: Int) = getRuleContext(classOf[External_declarationContext], i)

		override def getRuleIndex() = RULE_translation_unit
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterTranslation_unit(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitTranslation_unit(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitTranslation_unit(this)
			else
				visitor.visitChildren(this)
	}


	class External_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def COMMENT() = getToken(ObjCParser.COMMENT, 0)
		def LINE_COMMENT() = getToken(ObjCParser.LINE_COMMENT, 0)
		def preprocessor_declaration() = getRuleContext(classOf[Preprocessor_declarationContext], 0)
		def function_definition() = getRuleContext(classOf[Function_definitionContext], 0)
		def declaration() = getRuleContext(classOf[DeclarationContext], 0)
		def class_interface() = getRuleContext(classOf[Class_interfaceContext], 0)
		def class_implementation() = getRuleContext(classOf[Class_implementationContext], 0)
		def category_interface() = getRuleContext(classOf[Category_interfaceContext], 0)
		def category_implementation() = getRuleContext(classOf[Category_implementationContext], 0)
		def protocol_declaration() = getRuleContext(classOf[Protocol_declarationContext], 0)
		def protocol_declaration_list() = getRuleContext(classOf[Protocol_declaration_listContext], 0)
		def class_declaration_list() = getRuleContext(classOf[Class_declaration_listContext], 0)

		override def getRuleIndex() = RULE_external_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterExternal_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitExternal_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitExternal_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Preprocessor_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IMPORT() = getToken(ObjCParser.IMPORT, 0)
		def INCLUDE() = getToken(ObjCParser.INCLUDE, 0)

		override def getRuleIndex() = RULE_preprocessor_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterPreprocessor_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitPreprocessor_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitPreprocessor_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Class_interfaceContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)
		def superclass_name() = getRuleContext(classOf[Superclass_nameContext], 0)
		def protocol_reference_list() = getRuleContext(classOf[Protocol_reference_listContext], 0)
		def instance_variables() = getRuleContext(classOf[Instance_variablesContext], 0)
		def interface_declaration_list() = getRuleContext(classOf[Interface_declaration_listContext], 0)

		override def getRuleIndex() = RULE_class_interface
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_interface(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_interface(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_interface(this)
			else
				visitor.visitChildren(this)
	}


	class Category_interfaceContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)
		def category_name() = getRuleContext(classOf[Category_nameContext], 0)
		def protocol_reference_list() = getRuleContext(classOf[Protocol_reference_listContext], 0)
		def instance_variables() = getRuleContext(classOf[Instance_variablesContext], 0)
		def interface_declaration_list() = getRuleContext(classOf[Interface_declaration_listContext], 0)

		override def getRuleIndex() = RULE_category_interface
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCategory_interface(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCategory_interface(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCategory_interface(this)
			else
				visitor.visitChildren(this)
	}


	class Class_implementationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)
		def superclass_name() = getRuleContext(classOf[Superclass_nameContext], 0)
		def instance_variables() = getRuleContext(classOf[Instance_variablesContext], 0)
		def implementation_definition_list() = getRuleContext(classOf[Implementation_definition_listContext], 0)

		override def getRuleIndex() = RULE_class_implementation
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_implementation(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_implementation(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_implementation(this)
			else
				visitor.visitChildren(this)
	}


	class Category_implementationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)
		def category_name() = getRuleContext(classOf[Category_nameContext], 0)
		def implementation_definition_list() = getRuleContext(classOf[Implementation_definition_listContext], 0)

		override def getRuleIndex() = RULE_category_implementation
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCategory_implementation(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCategory_implementation(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCategory_implementation(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_name() = getRuleContext(classOf[Protocol_nameContext], 0)
		def protocol_reference_list() = getRuleContext(classOf[Protocol_reference_listContext], 0)
		def interface_declaration_list() = getRuleContexts(classOf[Interface_declaration_listContext]).asScala
		def interface_declaration_list(i: Int) = getRuleContext(classOf[Interface_declaration_listContext], i)

		override def getRuleIndex() = RULE_protocol_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_declaration_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_list() = getRuleContext(classOf[Protocol_listContext], 0)

		override def getRuleIndex() = RULE_protocol_declaration_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_declaration_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_declaration_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_declaration_list(this)
			else
				visitor.visitChildren(this)
	}


	class Class_declaration_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_list() = getRuleContext(classOf[Class_listContext], 0)

		override def getRuleIndex() = RULE_class_declaration_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_declaration_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_declaration_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_declaration_list(this)
			else
				visitor.visitChildren(this)
	}


	class Class_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def class_name() = getRuleContexts(classOf[Class_nameContext]).asScala
		def class_name(i: Int) = getRuleContext(classOf[Class_nameContext], i)

		override def getRuleIndex() = RULE_class_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_list(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_reference_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_list() = getRuleContext(classOf[Protocol_listContext], 0)

		override def getRuleIndex() = RULE_protocol_reference_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_reference_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_reference_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_reference_list(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_name() = getRuleContexts(classOf[Protocol_nameContext]).asScala
		def protocol_name(i: Int) = getRuleContext(classOf[Protocol_nameContext], i)

		override def getRuleIndex() = RULE_protocol_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_list(this)
			else
				visitor.visitChildren(this)
	}


	class Property_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def struct_declaration() = getRuleContext(classOf[Struct_declarationContext], 0)
		def property_attributes_declaration() = getRuleContext(classOf[Property_attributes_declarationContext], 0)
		def ib_outlet_specifier() = getRuleContext(classOf[Ib_outlet_specifierContext], 0)

		override def getRuleIndex() = RULE_property_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Property_attributes_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def property_attributes_list() = getRuleContext(classOf[Property_attributes_listContext], 0)

		override def getRuleIndex() = RULE_property_attributes_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_attributes_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_attributes_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_attributes_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Property_attributes_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def property_attribute() = getRuleContexts(classOf[Property_attributeContext]).asScala
		def property_attribute(i: Int) = getRuleContext(classOf[Property_attributeContext], i)

		override def getRuleIndex() = RULE_property_attributes_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_attributes_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_attributes_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_attributes_list(this)
			else
				visitor.visitChildren(this)
	}


	class Property_attributeContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_property_attribute
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_attribute(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_attribute(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_attribute(this)
			else
				visitor.visitChildren(this)
	}


	class Ib_outlet_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)

		override def getRuleIndex() = RULE_ib_outlet_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterIb_outlet_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitIb_outlet_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitIb_outlet_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Class_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_class_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_name(this)
			else
				visitor.visitChildren(this)
	}


	class Superclass_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_superclass_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSuperclass_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSuperclass_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSuperclass_name(this)
			else
				visitor.visitChildren(this)
	}


	class Category_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_category_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCategory_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCategory_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCategory_name(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_protocol_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_name(this)
			else
				visitor.visitChildren(this)
	}


	class Instance_variablesContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def struct_declaration() = getRuleContexts(classOf[Struct_declarationContext]).asScala
		def struct_declaration(i: Int) = getRuleContext(classOf[Struct_declarationContext], i)
		def visibility_specification() = getRuleContext(classOf[Visibility_specificationContext], 0)
		def instance_variables() = getRuleContext(classOf[Instance_variablesContext], 0)

		override def getRuleIndex() = RULE_instance_variables
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInstance_variables(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInstance_variables(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInstance_variables(this)
			else
				visitor.visitChildren(this)
	}


	class Visibility_specificationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_visibility_specification
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterVisibility_specification(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitVisibility_specification(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitVisibility_specification(this)
			else
				visitor.visitChildren(this)
	}


	class Interface_declaration_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration() = getRuleContexts(classOf[DeclarationContext]).asScala
		def declaration(i: Int) = getRuleContext(classOf[DeclarationContext], i)
		def class_method_declaration() = getRuleContexts(classOf[Class_method_declarationContext]).asScala
		def class_method_declaration(i: Int) = getRuleContext(classOf[Class_method_declarationContext], i)
		def instance_method_declaration() = getRuleContexts(classOf[Instance_method_declarationContext]).asScala
		def instance_method_declaration(i: Int) = getRuleContext(classOf[Instance_method_declarationContext], i)
		def property_declaration() = getRuleContexts(classOf[Property_declarationContext]).asScala
		def property_declaration(i: Int) = getRuleContext(classOf[Property_declarationContext], i)

		override def getRuleIndex() = RULE_interface_declaration_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInterface_declaration_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInterface_declaration_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInterface_declaration_list(this)
			else
				visitor.visitChildren(this)
	}


	class Class_method_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_declaration() = getRuleContext(classOf[Method_declarationContext], 0)

		override def getRuleIndex() = RULE_class_method_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_method_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_method_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_method_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Instance_method_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_declaration() = getRuleContext(classOf[Method_declarationContext], 0)

		override def getRuleIndex() = RULE_instance_method_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInstance_method_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInstance_method_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInstance_method_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Method_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_selector() = getRuleContext(classOf[Method_selectorContext], 0)
		def method_type() = getRuleContext(classOf[Method_typeContext], 0)

		override def getRuleIndex() = RULE_method_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMethod_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMethod_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMethod_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Implementation_definition_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def function_definition() = getRuleContexts(classOf[Function_definitionContext]).asScala
		def function_definition(i: Int) = getRuleContext(classOf[Function_definitionContext], i)
		def declaration() = getRuleContexts(classOf[DeclarationContext]).asScala
		def declaration(i: Int) = getRuleContext(classOf[DeclarationContext], i)
		def class_method_definition() = getRuleContexts(classOf[Class_method_definitionContext]).asScala
		def class_method_definition(i: Int) = getRuleContext(classOf[Class_method_definitionContext], i)
		def instance_method_definition() = getRuleContexts(classOf[Instance_method_definitionContext]).asScala
		def instance_method_definition(i: Int) = getRuleContext(classOf[Instance_method_definitionContext], i)
		def property_implementation() = getRuleContexts(classOf[Property_implementationContext]).asScala
		def property_implementation(i: Int) = getRuleContext(classOf[Property_implementationContext], i)

		override def getRuleIndex() = RULE_implementation_definition_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterImplementation_definition_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitImplementation_definition_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitImplementation_definition_list(this)
			else
				visitor.visitChildren(this)
	}


	class Class_method_definitionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_definition() = getRuleContext(classOf[Method_definitionContext], 0)

		override def getRuleIndex() = RULE_class_method_definition
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterClass_method_definition(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitClass_method_definition(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitClass_method_definition(this)
			else
				visitor.visitChildren(this)
	}


	class Instance_method_definitionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_definition() = getRuleContext(classOf[Method_definitionContext], 0)

		override def getRuleIndex() = RULE_instance_method_definition
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInstance_method_definition(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInstance_method_definition(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInstance_method_definition(this)
			else
				visitor.visitChildren(this)
	}


	class Method_definitionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def method_selector() = getRuleContext(classOf[Method_selectorContext], 0)
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)
		def method_type() = getRuleContext(classOf[Method_typeContext], 0)
		def init_declarator_list() = getRuleContext(classOf[Init_declarator_listContext], 0)

		override def getRuleIndex() = RULE_method_definition
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMethod_definition(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMethod_definition(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMethod_definition(this)
			else
				visitor.visitChildren(this)
	}


	class Method_selectorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def selector() = getRuleContext(classOf[SelectorContext], 0)
		def keyword_declarator() = getRuleContexts(classOf[Keyword_declaratorContext]).asScala
		def keyword_declarator(i: Int) = getRuleContext(classOf[Keyword_declaratorContext], i)
		def parameter_list() = getRuleContext(classOf[Parameter_listContext], 0)

		override def getRuleIndex() = RULE_method_selector
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMethod_selector(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMethod_selector(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMethod_selector(this)
			else
				visitor.visitChildren(this)
	}


	class Keyword_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)
		def selector() = getRuleContext(classOf[SelectorContext], 0)
		def method_type() = getRuleContexts(classOf[Method_typeContext]).asScala
		def method_type(i: Int) = getRuleContext(classOf[Method_typeContext], i)

		override def getRuleIndex() = RULE_keyword_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterKeyword_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitKeyword_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitKeyword_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class SelectorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_selector
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSelector(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSelector(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSelector(this)
			else
				visitor.visitChildren(this)
	}


	class Method_typeContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_name() = getRuleContext(classOf[Type_nameContext], 0)

		override def getRuleIndex() = RULE_method_type
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMethod_type(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMethod_type(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMethod_type(this)
			else
				visitor.visitChildren(this)
	}


	class Property_implementationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def property_synthesize_list() = getRuleContext(classOf[Property_synthesize_listContext], 0)

		override def getRuleIndex() = RULE_property_implementation
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_implementation(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_implementation(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_implementation(this)
			else
				visitor.visitChildren(this)
	}


	class Property_synthesize_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def property_synthesize_item() = getRuleContexts(classOf[Property_synthesize_itemContext]).asScala
		def property_synthesize_item(i: Int) = getRuleContext(classOf[Property_synthesize_itemContext], i)

		override def getRuleIndex() = RULE_property_synthesize_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_synthesize_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_synthesize_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_synthesize_list(this)
			else
				visitor.visitChildren(this)
	}


	class Property_synthesize_itemContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getTokens(ObjCParser.IDENTIFIER).asScala
		def IDENTIFIER(i: Int) = getToken(ObjCParser.IDENTIFIER, i)

		override def getRuleIndex() = RULE_property_synthesize_item
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProperty_synthesize_item(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProperty_synthesize_item(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProperty_synthesize_item(this)
			else
				visitor.visitChildren(this)
	}


	class Block_typeContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_specifier() = getRuleContexts(classOf[Type_specifierContext]).asScala
		def type_specifier(i: Int) = getRuleContext(classOf[Type_specifierContext], i)
		def block_parameters() = getRuleContext(classOf[Block_parametersContext], 0)

		override def getRuleIndex() = RULE_block_type
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterBlock_type(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitBlock_type(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitBlock_type(this)
			else
				visitor.visitChildren(this)
	}


	class Type_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_reference_list() = getRuleContext(classOf[Protocol_reference_listContext], 0)
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)
		def struct_or_union_specifier() = getRuleContext(classOf[Struct_or_union_specifierContext], 0)
		def enum_specifier() = getRuleContext(classOf[Enum_specifierContext], 0)
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)
		def pointer() = getRuleContext(classOf[PointerContext], 0)

		override def getRuleIndex() = RULE_type_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterType_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitType_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitType_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Type_qualifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_qualifier() = getRuleContext(classOf[Protocol_qualifierContext], 0)

		override def getRuleIndex() = RULE_type_qualifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterType_qualifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitType_qualifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitType_qualifier(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_qualifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_protocol_qualifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_qualifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_qualifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_qualifier(this)
			else
				visitor.visitChildren(this)
	}


	class Primary_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)
		def constant() = getRuleContext(classOf[ConstantContext], 0)
		def STRING_LITERAL() = getToken(ObjCParser.STRING_LITERAL, 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def message_expression() = getRuleContext(classOf[Message_expressionContext], 0)
		def selector_expression() = getRuleContext(classOf[Selector_expressionContext], 0)
		def protocol_expression() = getRuleContext(classOf[Protocol_expressionContext], 0)
		def encode_expression() = getRuleContext(classOf[Encode_expressionContext], 0)
		def dictionary_expression() = getRuleContext(classOf[Dictionary_expressionContext], 0)
		def array_expression() = getRuleContext(classOf[Array_expressionContext], 0)
		def box_expression() = getRuleContext(classOf[Box_expressionContext], 0)
		def block_expression() = getRuleContext(classOf[Block_expressionContext], 0)

		override def getRuleIndex() = RULE_primary_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterPrimary_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitPrimary_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitPrimary_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Dictionary_pairContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def postfix_expression() = getRuleContexts(classOf[Postfix_expressionContext]).asScala
		def postfix_expression(i: Int) = getRuleContext(classOf[Postfix_expressionContext], i)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)

		override def getRuleIndex() = RULE_dictionary_pair
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDictionary_pair(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDictionary_pair(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDictionary_pair(this)
			else
				visitor.visitChildren(this)
	}


	class Dictionary_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def dictionary_pair() = getRuleContexts(classOf[Dictionary_pairContext]).asScala
		def dictionary_pair(i: Int) = getRuleContext(classOf[Dictionary_pairContext], i)

		override def getRuleIndex() = RULE_dictionary_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDictionary_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDictionary_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDictionary_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Array_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def postfix_expression() = getRuleContexts(classOf[Postfix_expressionContext]).asScala
		def postfix_expression(i: Int) = getRuleContext(classOf[Postfix_expressionContext], i)

		override def getRuleIndex() = RULE_array_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterArray_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitArray_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitArray_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Box_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def postfix_expression() = getRuleContext(classOf[Postfix_expressionContext], 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def constant() = getRuleContext(classOf[ConstantContext], 0)

		override def getRuleIndex() = RULE_box_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterBox_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitBox_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitBox_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Block_parametersContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_variable_declarator() = getRuleContexts(classOf[Type_variable_declaratorContext]).asScala
		def type_variable_declarator(i: Int) = getRuleContext(classOf[Type_variable_declaratorContext], i)

		override def getRuleIndex() = RULE_block_parameters
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterBlock_parameters(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitBlock_parameters(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitBlock_parameters(this)
			else
				visitor.visitChildren(this)
	}


	class Block_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)
		def type_specifier() = getRuleContext(classOf[Type_specifierContext], 0)
		def block_parameters() = getRuleContext(classOf[Block_parametersContext], 0)

		override def getRuleIndex() = RULE_block_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterBlock_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitBlock_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitBlock_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Message_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def receiver() = getRuleContext(classOf[ReceiverContext], 0)
		def message_selector() = getRuleContext(classOf[Message_selectorContext], 0)

		override def getRuleIndex() = RULE_message_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMessage_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMessage_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMessage_expression(this)
			else
				visitor.visitChildren(this)
	}


	class ReceiverContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def class_name() = getRuleContext(classOf[Class_nameContext], 0)

		override def getRuleIndex() = RULE_receiver
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterReceiver(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitReceiver(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitReceiver(this)
			else
				visitor.visitChildren(this)
	}


	class Message_selectorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def selector() = getRuleContext(classOf[SelectorContext], 0)
		def keyword_argument() = getRuleContexts(classOf[Keyword_argumentContext]).asScala
		def keyword_argument(i: Int) = getRuleContext(classOf[Keyword_argumentContext], i)

		override def getRuleIndex() = RULE_message_selector
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMessage_selector(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMessage_selector(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMessage_selector(this)
			else
				visitor.visitChildren(this)
	}


	class Keyword_argumentContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def selector() = getRuleContext(classOf[SelectorContext], 0)

		override def getRuleIndex() = RULE_keyword_argument
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterKeyword_argument(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitKeyword_argument(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitKeyword_argument(this)
			else
				visitor.visitChildren(this)
	}


	class Selector_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def selector_name() = getRuleContext(classOf[Selector_nameContext], 0)

		override def getRuleIndex() = RULE_selector_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSelector_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSelector_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSelector_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Selector_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def selector() = getRuleContexts(classOf[SelectorContext]).asScala
		def selector(i: Int) = getRuleContext(classOf[SelectorContext], i)

		override def getRuleIndex() = RULE_selector_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSelector_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSelector_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSelector_name(this)
			else
				visitor.visitChildren(this)
	}


	class Protocol_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def protocol_name() = getRuleContext(classOf[Protocol_nameContext], 0)

		override def getRuleIndex() = RULE_protocol_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterProtocol_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitProtocol_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitProtocol_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Encode_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_name() = getRuleContext(classOf[Type_nameContext], 0)

		override def getRuleIndex() = RULE_encode_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterEncode_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitEncode_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitEncode_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Type_variable_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)

		override def getRuleIndex() = RULE_type_variable_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterType_variable_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitType_variable_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitType_variable_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class Try_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)

		override def getRuleIndex() = RULE_try_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterTry_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitTry_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitTry_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Catch_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_variable_declarator() = getRuleContext(classOf[Type_variable_declaratorContext], 0)
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)

		override def getRuleIndex() = RULE_catch_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCatch_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCatch_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCatch_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Finally_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)

		override def getRuleIndex() = RULE_finally_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterFinally_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitFinally_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitFinally_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Throw_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_throw_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterThrow_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitThrow_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitThrow_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Try_blockContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def try_statement() = getRuleContext(classOf[Try_statementContext], 0)
		def catch_statement() = getRuleContexts(classOf[Catch_statementContext]).asScala
		def catch_statement(i: Int) = getRuleContext(classOf[Catch_statementContext], i)
		def finally_statement() = getRuleContext(classOf[Finally_statementContext], 0)

		override def getRuleIndex() = RULE_try_block
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterTry_block(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitTry_block(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitTry_block(this)
			else
				visitor.visitChildren(this)
	}


	class Synchronized_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def primary_expression() = getRuleContext(classOf[Primary_expressionContext], 0)
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)

		override def getRuleIndex() = RULE_synchronized_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSynchronized_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSynchronized_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSynchronized_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Autorelease_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)

		override def getRuleIndex() = RULE_autorelease_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAutorelease_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAutorelease_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAutorelease_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Function_definitionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)

		override def getRuleIndex() = RULE_function_definition
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterFunction_definition(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitFunction_definition(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitFunction_definition(this)
			else
				visitor.visitChildren(this)
	}


	class DeclarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)
		def init_declarator_list() = getRuleContext(classOf[Init_declarator_listContext], 0)

		override def getRuleIndex() = RULE_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDeclaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDeclaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDeclaration(this)
			else
				visitor.visitChildren(this)
	}


	class Declaration_specifiersContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def arc_behaviour_specifier() = getRuleContexts(classOf[Arc_behaviour_specifierContext]).asScala
		def arc_behaviour_specifier(i: Int) = getRuleContext(classOf[Arc_behaviour_specifierContext], i)
		def storage_class_specifier() = getRuleContexts(classOf[Storage_class_specifierContext]).asScala
		def storage_class_specifier(i: Int) = getRuleContext(classOf[Storage_class_specifierContext], i)
		def type_specifier() = getRuleContexts(classOf[Type_specifierContext]).asScala
		def type_specifier(i: Int) = getRuleContext(classOf[Type_specifierContext], i)
		def type_qualifier() = getRuleContexts(classOf[Type_qualifierContext]).asScala
		def type_qualifier(i: Int) = getRuleContext(classOf[Type_qualifierContext], i)

		override def getRuleIndex() = RULE_declaration_specifiers
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDeclaration_specifiers(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDeclaration_specifiers(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDeclaration_specifiers(this)
			else
				visitor.visitChildren(this)
	}


	class Arc_behaviour_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_arc_behaviour_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterArc_behaviour_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitArc_behaviour_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitArc_behaviour_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Storage_class_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_storage_class_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStorage_class_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStorage_class_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStorage_class_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Init_declarator_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def init_declarator() = getRuleContexts(classOf[Init_declaratorContext]).asScala
		def init_declarator(i: Int) = getRuleContext(classOf[Init_declaratorContext], i)

		override def getRuleIndex() = RULE_init_declarator_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInit_declarator_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInit_declarator_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInit_declarator_list(this)
			else
				visitor.visitChildren(this)
	}


	class Init_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)
		def initializer() = getRuleContext(classOf[InitializerContext], 0)

		override def getRuleIndex() = RULE_init_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInit_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInit_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInit_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class Struct_or_union_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)
		def struct_declaration() = getRuleContexts(classOf[Struct_declarationContext]).asScala
		def struct_declaration(i: Int) = getRuleContext(classOf[Struct_declarationContext], i)

		override def getRuleIndex() = RULE_struct_or_union_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStruct_or_union_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStruct_or_union_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStruct_or_union_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Struct_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def specifier_qualifier_list() = getRuleContext(classOf[Specifier_qualifier_listContext], 0)
		def struct_declarator_list() = getRuleContext(classOf[Struct_declarator_listContext], 0)

		override def getRuleIndex() = RULE_struct_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStruct_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStruct_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStruct_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class Specifier_qualifier_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def arc_behaviour_specifier() = getRuleContexts(classOf[Arc_behaviour_specifierContext]).asScala
		def arc_behaviour_specifier(i: Int) = getRuleContext(classOf[Arc_behaviour_specifierContext], i)
		def type_specifier() = getRuleContexts(classOf[Type_specifierContext]).asScala
		def type_specifier(i: Int) = getRuleContext(classOf[Type_specifierContext], i)
		def type_qualifier() = getRuleContexts(classOf[Type_qualifierContext]).asScala
		def type_qualifier(i: Int) = getRuleContext(classOf[Type_qualifierContext], i)

		override def getRuleIndex() = RULE_specifier_qualifier_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSpecifier_qualifier_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSpecifier_qualifier_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSpecifier_qualifier_list(this)
			else
				visitor.visitChildren(this)
	}


	class Struct_declarator_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def struct_declarator() = getRuleContexts(classOf[Struct_declaratorContext]).asScala
		def struct_declarator(i: Int) = getRuleContext(classOf[Struct_declaratorContext], i)

		override def getRuleIndex() = RULE_struct_declarator_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStruct_declarator_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStruct_declarator_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStruct_declarator_list(this)
			else
				visitor.visitChildren(this)
	}


	class Struct_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)
		def constant() = getRuleContext(classOf[ConstantContext], 0)

		override def getRuleIndex() = RULE_struct_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStruct_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStruct_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStruct_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class Enum_specifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def identifier() = getRuleContext(classOf[IdentifierContext], 0)
		def enumerator_list() = getRuleContext(classOf[Enumerator_listContext], 0)
		def type_name() = getRuleContext(classOf[Type_nameContext], 0)
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_enum_specifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterEnum_specifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitEnum_specifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitEnum_specifier(this)
			else
				visitor.visitChildren(this)
	}


	class Enumerator_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def enumerator() = getRuleContexts(classOf[EnumeratorContext]).asScala
		def enumerator(i: Int) = getRuleContext(classOf[EnumeratorContext], i)

		override def getRuleIndex() = RULE_enumerator_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterEnumerator_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitEnumerator_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitEnumerator_list(this)
			else
				visitor.visitChildren(this)
	}


	class EnumeratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def identifier() = getRuleContext(classOf[IdentifierContext], 0)
		def constant_expression() = getRuleContext(classOf[Constant_expressionContext], 0)

		override def getRuleIndex() = RULE_enumerator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterEnumerator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitEnumerator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitEnumerator(this)
			else
				visitor.visitChildren(this)
	}


	class PointerContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)
		def pointer() = getRuleContext(classOf[PointerContext], 0)

		override def getRuleIndex() = RULE_pointer
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterPointer(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitPointer(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitPointer(this)
			else
				visitor.visitChildren(this)
	}


	class DeclaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def direct_declarator() = getRuleContext(classOf[Direct_declaratorContext], 0)
		def pointer() = getRuleContext(classOf[PointerContext], 0)

		override def getRuleIndex() = RULE_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDeclarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDeclarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDeclarator(this)
			else
				visitor.visitChildren(this)
	}


	class Direct_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def identifier() = getRuleContext(classOf[IdentifierContext], 0)
		def declarator_suffix() = getRuleContexts(classOf[Declarator_suffixContext]).asScala
		def declarator_suffix(i: Int) = getRuleContext(classOf[Declarator_suffixContext], i)
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)
		def block_parameters() = getRuleContext(classOf[Block_parametersContext], 0)

		override def getRuleIndex() = RULE_direct_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDirect_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDirect_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDirect_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class Declarator_suffixContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def constant_expression() = getRuleContext(classOf[Constant_expressionContext], 0)
		def parameter_list() = getRuleContext(classOf[Parameter_listContext], 0)

		override def getRuleIndex() = RULE_declarator_suffix
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDeclarator_suffix(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDeclarator_suffix(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDeclarator_suffix(this)
			else
				visitor.visitChildren(this)
	}


	class Parameter_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def parameter_declaration_list() = getRuleContext(classOf[Parameter_declaration_listContext], 0)

		override def getRuleIndex() = RULE_parameter_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterParameter_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitParameter_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitParameter_list(this)
			else
				visitor.visitChildren(this)
	}


	class Parameter_declarationContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)
		def abstract_declarator() = getRuleContext(classOf[Abstract_declaratorContext], 0)
		def declarator() = getRuleContext(classOf[DeclaratorContext], 0)

		override def getRuleIndex() = RULE_parameter_declaration
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterParameter_declaration(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitParameter_declaration(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitParameter_declaration(this)
			else
				visitor.visitChildren(this)
	}


	class InitializerContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def assignment_expression() = getRuleContext(classOf[Assignment_expressionContext], 0)
		def initializer() = getRuleContexts(classOf[InitializerContext]).asScala
		def initializer(i: Int) = getRuleContext(classOf[InitializerContext], i)

		override def getRuleIndex() = RULE_initializer
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInitializer(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInitializer(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInitializer(this)
			else
				visitor.visitChildren(this)
	}


	class Type_nameContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def specifier_qualifier_list() = getRuleContext(classOf[Specifier_qualifier_listContext], 0)
		def abstract_declarator() = getRuleContext(classOf[Abstract_declaratorContext], 0)
		def block_type() = getRuleContext(classOf[Block_typeContext], 0)

		override def getRuleIndex() = RULE_type_name
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterType_name(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitType_name(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitType_name(this)
			else
				visitor.visitChildren(this)
	}


	class Abstract_declaratorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def pointer() = getRuleContext(classOf[PointerContext], 0)
		def abstract_declarator() = getRuleContext(classOf[Abstract_declaratorContext], 0)
		def abstract_declarator_suffix() = getRuleContexts(classOf[Abstract_declarator_suffixContext]).asScala
		def abstract_declarator_suffix(i: Int) = getRuleContext(classOf[Abstract_declarator_suffixContext], i)
		def constant_expression() = getRuleContexts(classOf[Constant_expressionContext]).asScala
		def constant_expression(i: Int) = getRuleContext(classOf[Constant_expressionContext], i)

		override def getRuleIndex() = RULE_abstract_declarator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAbstract_declarator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAbstract_declarator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAbstract_declarator(this)
			else
				visitor.visitChildren(this)
	}


	class Abstract_declarator_suffixContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def constant_expression() = getRuleContext(classOf[Constant_expressionContext], 0)
		def parameter_declaration_list() = getRuleContext(classOf[Parameter_declaration_listContext], 0)

		override def getRuleIndex() = RULE_abstract_declarator_suffix
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAbstract_declarator_suffix(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAbstract_declarator_suffix(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAbstract_declarator_suffix(this)
			else
				visitor.visitChildren(this)
	}


	class Parameter_declaration_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def parameter_declaration() = getRuleContexts(classOf[Parameter_declarationContext]).asScala
		def parameter_declaration(i: Int) = getRuleContext(classOf[Parameter_declarationContext], i)

		override def getRuleIndex() = RULE_parameter_declaration_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterParameter_declaration_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitParameter_declaration_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitParameter_declaration_list(this)
			else
				visitor.visitChildren(this)
	}


	class Statement_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def statement() = getRuleContexts(classOf[StatementContext]).asScala
		def statement(i: Int) = getRuleContext(classOf[StatementContext], i)

		override def getRuleIndex() = RULE_statement_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStatement_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStatement_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStatement_list(this)
			else
				visitor.visitChildren(this)
	}


	class StatementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def labeled_statement() = getRuleContext(classOf[Labeled_statementContext], 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def compound_statement() = getRuleContext(classOf[Compound_statementContext], 0)
		def selection_statement() = getRuleContext(classOf[Selection_statementContext], 0)
		def iteration_statement() = getRuleContext(classOf[Iteration_statementContext], 0)
		def jump_statement() = getRuleContext(classOf[Jump_statementContext], 0)
		def synchronized_statement() = getRuleContext(classOf[Synchronized_statementContext], 0)
		def autorelease_statement() = getRuleContext(classOf[Autorelease_statementContext], 0)
		def try_block() = getRuleContext(classOf[Try_blockContext], 0)

		override def getRuleIndex() = RULE_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterStatement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitStatement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitStatement(this)
			else
				visitor.visitChildren(this)
	}


	class Labeled_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def identifier() = getRuleContext(classOf[IdentifierContext], 0)
		def statement() = getRuleContext(classOf[StatementContext], 0)
		def constant_expression() = getRuleContext(classOf[Constant_expressionContext], 0)

		override def getRuleIndex() = RULE_labeled_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterLabeled_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitLabeled_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitLabeled_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Compound_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def declaration() = getRuleContexts(classOf[DeclarationContext]).asScala
		def declaration(i: Int) = getRuleContext(classOf[DeclarationContext], i)
		def statement_list() = getRuleContexts(classOf[Statement_listContext]).asScala
		def statement_list(i: Int) = getRuleContext(classOf[Statement_listContext], i)

		override def getRuleIndex() = RULE_compound_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCompound_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCompound_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCompound_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Selection_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def statement() = getRuleContexts(classOf[StatementContext]).asScala
		def statement(i: Int) = getRuleContext(classOf[StatementContext], i)

		override def getRuleIndex() = RULE_selection_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterSelection_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitSelection_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitSelection_statement(this)
			else
				visitor.visitChildren(this)
	}


	class For_in_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_variable_declarator() = getRuleContext(classOf[Type_variable_declaratorContext], 0)
		def statement() = getRuleContext(classOf[StatementContext], 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)

		override def getRuleIndex() = RULE_for_in_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterFor_in_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitFor_in_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitFor_in_statement(this)
			else
				visitor.visitChildren(this)
	}


	class For_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def statement() = getRuleContext(classOf[StatementContext], 0)
		def expression() = getRuleContexts(classOf[ExpressionContext]).asScala
		def expression(i: Int) = getRuleContext(classOf[ExpressionContext], i)
		def declaration_specifiers() = getRuleContext(classOf[Declaration_specifiersContext], 0)
		def init_declarator_list() = getRuleContext(classOf[Init_declarator_listContext], 0)

		override def getRuleIndex() = RULE_for_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterFor_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitFor_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitFor_statement(this)
			else
				visitor.visitChildren(this)
	}


	class While_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def expression() = getRuleContext(classOf[ExpressionContext], 0)
		def statement() = getRuleContext(classOf[StatementContext], 0)

		override def getRuleIndex() = RULE_while_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterWhile_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitWhile_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitWhile_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Do_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def statement() = getRuleContext(classOf[StatementContext], 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)

		override def getRuleIndex() = RULE_do_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterDo_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitDo_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitDo_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Iteration_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def while_statement() = getRuleContext(classOf[While_statementContext], 0)
		def do_statement() = getRuleContext(classOf[Do_statementContext], 0)
		def for_statement() = getRuleContext(classOf[For_statementContext], 0)
		def for_in_statement() = getRuleContext(classOf[For_in_statementContext], 0)

		override def getRuleIndex() = RULE_iteration_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterIteration_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitIteration_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitIteration_statement(this)
			else
				visitor.visitChildren(this)
	}


	class Jump_statementContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def identifier() = getRuleContext(classOf[IdentifierContext], 0)
		def expression() = getRuleContext(classOf[ExpressionContext], 0)

		override def getRuleIndex() = RULE_jump_statement
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterJump_statement(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitJump_statement(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitJump_statement(this)
			else
				visitor.visitChildren(this)
	}


	class ExpressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def assignment_expression() = getRuleContexts(classOf[Assignment_expressionContext]).asScala
		def assignment_expression(i: Int) = getRuleContext(classOf[Assignment_expressionContext], i)

		override def getRuleIndex() = RULE_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterExpression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitExpression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitExpression(this)
			else
				visitor.visitChildren(this)
	}


	class Assignment_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def conditional_expression() = getRuleContext(classOf[Conditional_expressionContext], 0)
		def unary_expression() = getRuleContext(classOf[Unary_expressionContext], 0)
		def assignment_operator() = getRuleContext(classOf[Assignment_operatorContext], 0)
		def assignment_expression() = getRuleContext(classOf[Assignment_expressionContext], 0)

		override def getRuleIndex() = RULE_assignment_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAssignment_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAssignment_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAssignment_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Assignment_operatorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_assignment_operator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAssignment_operator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAssignment_operator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAssignment_operator(this)
			else
				visitor.visitChildren(this)
	}


	class Conditional_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def logical_or_expression() = getRuleContext(classOf[Logical_or_expressionContext], 0)
		def conditional_expression() = getRuleContexts(classOf[Conditional_expressionContext]).asScala
		def conditional_expression(i: Int) = getRuleContext(classOf[Conditional_expressionContext], i)

		override def getRuleIndex() = RULE_conditional_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterConditional_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitConditional_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitConditional_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Constant_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def conditional_expression() = getRuleContext(classOf[Conditional_expressionContext], 0)

		override def getRuleIndex() = RULE_constant_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterConstant_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitConstant_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitConstant_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Logical_or_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def logical_and_expression() = getRuleContexts(classOf[Logical_and_expressionContext]).asScala
		def logical_and_expression(i: Int) = getRuleContext(classOf[Logical_and_expressionContext], i)

		override def getRuleIndex() = RULE_logical_or_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterLogical_or_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitLogical_or_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitLogical_or_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Logical_and_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def inclusive_or_expression() = getRuleContexts(classOf[Inclusive_or_expressionContext]).asScala
		def inclusive_or_expression(i: Int) = getRuleContext(classOf[Inclusive_or_expressionContext], i)

		override def getRuleIndex() = RULE_logical_and_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterLogical_and_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitLogical_and_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitLogical_and_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Inclusive_or_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def exclusive_or_expression() = getRuleContexts(classOf[Exclusive_or_expressionContext]).asScala
		def exclusive_or_expression(i: Int) = getRuleContext(classOf[Exclusive_or_expressionContext], i)

		override def getRuleIndex() = RULE_inclusive_or_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterInclusive_or_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitInclusive_or_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitInclusive_or_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Exclusive_or_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def and_expression() = getRuleContexts(classOf[And_expressionContext]).asScala
		def and_expression(i: Int) = getRuleContext(classOf[And_expressionContext], i)

		override def getRuleIndex() = RULE_exclusive_or_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterExclusive_or_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitExclusive_or_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitExclusive_or_expression(this)
			else
				visitor.visitChildren(this)
	}


	class And_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def equality_expression() = getRuleContexts(classOf[Equality_expressionContext]).asScala
		def equality_expression(i: Int) = getRuleContext(classOf[Equality_expressionContext], i)

		override def getRuleIndex() = RULE_and_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAnd_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAnd_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAnd_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Equality_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def relational_expression() = getRuleContexts(classOf[Relational_expressionContext]).asScala
		def relational_expression(i: Int) = getRuleContext(classOf[Relational_expressionContext], i)

		override def getRuleIndex() = RULE_equality_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterEquality_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitEquality_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitEquality_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Relational_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def shift_expression() = getRuleContexts(classOf[Shift_expressionContext]).asScala
		def shift_expression(i: Int) = getRuleContext(classOf[Shift_expressionContext], i)

		override def getRuleIndex() = RULE_relational_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterRelational_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitRelational_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitRelational_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Shift_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def additive_expression() = getRuleContexts(classOf[Additive_expressionContext]).asScala
		def additive_expression(i: Int) = getRuleContext(classOf[Additive_expressionContext], i)

		override def getRuleIndex() = RULE_shift_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterShift_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitShift_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitShift_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Additive_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def multiplicative_expression() = getRuleContexts(classOf[Multiplicative_expressionContext]).asScala
		def multiplicative_expression(i: Int) = getRuleContext(classOf[Multiplicative_expressionContext], i)

		override def getRuleIndex() = RULE_additive_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterAdditive_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitAdditive_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitAdditive_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Multiplicative_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def cast_expression() = getRuleContexts(classOf[Cast_expressionContext]).asScala
		def cast_expression(i: Int) = getRuleContext(classOf[Cast_expressionContext], i)

		override def getRuleIndex() = RULE_multiplicative_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterMultiplicative_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitMultiplicative_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitMultiplicative_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Cast_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def type_name() = getRuleContext(classOf[Type_nameContext], 0)
		def cast_expression() = getRuleContext(classOf[Cast_expressionContext], 0)
		def unary_expression() = getRuleContext(classOf[Unary_expressionContext], 0)

		override def getRuleIndex() = RULE_cast_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterCast_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitCast_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitCast_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Unary_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def postfix_expression() = getRuleContext(classOf[Postfix_expressionContext], 0)
		def unary_expression() = getRuleContext(classOf[Unary_expressionContext], 0)
		def unary_operator() = getRuleContext(classOf[Unary_operatorContext], 0)
		def cast_expression() = getRuleContext(classOf[Cast_expressionContext], 0)
		def type_name() = getRuleContext(classOf[Type_nameContext], 0)

		override def getRuleIndex() = RULE_unary_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterUnary_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitUnary_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitUnary_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Unary_operatorContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {

		override def getRuleIndex() = RULE_unary_operator
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterUnary_operator(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitUnary_operator(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitUnary_operator(this)
			else
				visitor.visitChildren(this)
	}


	class Postfix_expressionContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def primary_expression() = getRuleContext(classOf[Primary_expressionContext], 0)
		def expression() = getRuleContexts(classOf[ExpressionContext]).asScala
		def expression(i: Int) = getRuleContext(classOf[ExpressionContext], i)
		def identifier() = getRuleContexts(classOf[IdentifierContext]).asScala
		def identifier(i: Int) = getRuleContext(classOf[IdentifierContext], i)
		def argument_expression_list() = getRuleContexts(classOf[Argument_expression_listContext]).asScala
		def argument_expression_list(i: Int) = getRuleContext(classOf[Argument_expression_listContext], i)

		override def getRuleIndex() = RULE_postfix_expression
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterPostfix_expression(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitPostfix_expression(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitPostfix_expression(this)
			else
				visitor.visitChildren(this)
	}


	class Argument_expression_listContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def assignment_expression() = getRuleContexts(classOf[Assignment_expressionContext]).asScala
		def assignment_expression(i: Int) = getRuleContext(classOf[Assignment_expressionContext], i)

		override def getRuleIndex() = RULE_argument_expression_list
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterArgument_expression_list(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitArgument_expression_list(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitArgument_expression_list(this)
			else
				visitor.visitChildren(this)
	}


	class IdentifierContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def IDENTIFIER() = getToken(ObjCParser.IDENTIFIER, 0)

		override def getRuleIndex() = RULE_identifier
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterIdentifier(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitIdentifier(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitIdentifier(this)
			else
				visitor.visitChildren(this)
	}


	class ConstantContext(parent: ParserRuleContext, invokingState: Int) extends ParserRuleContext(parent, invokingState) {
		def DECIMAL_LITERAL() = getToken(ObjCParser.DECIMAL_LITERAL, 0)
		def HEX_LITERAL() = getToken(ObjCParser.HEX_LITERAL, 0)
		def OCTAL_LITERAL() = getToken(ObjCParser.OCTAL_LITERAL, 0)
		def CHARACTER_LITERAL() = getToken(ObjCParser.CHARACTER_LITERAL, 0)
		def FLOATING_POINT_LITERAL() = getToken(ObjCParser.FLOATING_POINT_LITERAL, 0)

		override def getRuleIndex() = RULE_constant
		override def enterRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].enterConstant(this)
		override def exitRule(listener: ParseTreeListener) =
			if (listener.isInstanceOf[ObjCListener])
				listener.asInstanceOf[ObjCListener].exitConstant(this)
		override def accept[T](visitor: ParseTreeVisitor[_ <: T]): T =
			if (visitor.isInstanceOf[ObjCVisitor[_]])
				visitor.asInstanceOf[ObjCVisitor[_ <: T]].visitConstant(this)
			else
				visitor.visitChildren(this)
	}



	val EOF = -1
	val T__0 = 1
	val AUTORELEASEPOOL = 2
	val CATCH = 3
	val CLASS = 4
	val DYNAMIC = 5
	val ENCODE = 6
	val END = 7
	val FINALLY = 8
	val IMPLEMENTATION = 9
	val INTERFACE = 10
	val PACKAGE = 11
	val PROTOCOL = 12
	val OPTIONAL = 13
	val PRIVATE = 14
	val PROPERTY = 15
	val PROTECTED = 16
	val PUBLIC = 17
	val SELECTOR = 18
	val SYNCHRONIZED = 19
	val SYNTHESIZE = 20
	val THROW = 21
	val TRY = 22
	val SUPER = 23
	val SELF = 24
	val ABSTRACT = 25
	val AUTO = 26
	val BOOLEAN = 27
	val BREAK = 28
	val BYCOPY = 29
	val BYREF = 30
	val CASE = 31
	val CHAR = 32
	val CONST = 33
	val CONTINUE = 34
	val DEFAULT = 35
	val DO = 36
	val DOUBLE = 37
	val ELSE = 38
	val ENUM = 39
	val EXTERN = 40
	val FLOAT = 41
	val FOR = 42
	val ID = 43
	val IF = 44
	val IN = 45
	val INOUT = 46
	val GOTO = 47
	val INT = 48
	val LONG = 49
	val ONEWAY = 50
	val OUT = 51
	val REGISTER = 52
	val RETURN = 53
	val SHORT = 54
	val SIGNED = 55
	val SIZEOF = 56
	val STATIC = 57
	val STRUCT = 58
	val SWITCH = 59
	val TYPEDEF = 60
	val UNION = 61
	val UNSIGNED = 62
	val VOID = 63
	val VOLATILE = 64
	val WHILE = 65
	val NS_OPTIONS = 66
	val NS_ENUM = 67
	val WWEAK = 68
	val WUNSAFE_UNRETAINED = 69
	val LPAREN = 70
	val RPAREN = 71
	val LBRACE = 72
	val RBRACE = 73
	val LBRACK = 74
	val RBRACK = 75
	val SEMI = 76
	val COMMA = 77
	val DOT = 78
	val STRUCTACCESS = 79
	val AT = 80
	val ASSIGN = 81
	val GT = 82
	val LT = 83
	val BANG = 84
	val TILDE = 85
	val QUESTION = 86
	val COLON = 87
	val EQUAL = 88
	val LE = 89
	val GE = 90
	val NOTEQUAL = 91
	val AND = 92
	val OR = 93
	val INC = 94
	val DEC = 95
	val ADD = 96
	val SUB = 97
	val MUL = 98
	val DIV = 99
	val BITAND = 100
	val BITOR = 101
	val CARET = 102
	val MOD = 103
	val SHIFT_R = 104
	val SHIFT_L = 105
	val ADD_ASSIGN = 106
	val SUB_ASSIGN = 107
	val MUL_ASSIGN = 108
	val DIV_ASSIGN = 109
	val AND_ASSIGN = 110
	val OR_ASSIGN = 111
	val XOR_ASSIGN = 112
	val MOD_ASSIGN = 113
	val LSHIFT_ASSIGN = 114
	val RSHIFT_ASSIGN = 115
	val ELIPSIS = 116
	val ASSIGNPA = 117
	val GETTER = 118
	val NONATOMIC = 119
	val SETTER = 120
	val STRONG = 121
	val RETAIN = 122
	val READONLY = 123
	val READWRITE = 124
	val WEAK = 125
	val IDENTIFIER = 126
	val CHARACTER_LITERAL = 127
	val STRING_LITERAL = 128
	val HEX_LITERAL = 129
	val DECIMAL_LITERAL = 130
	val OCTAL_LITERAL = 131
	val FLOATING_POINT_LITERAL = 132
	val IMPORT = 133
	val INCLUDE = 134
	val PRAGMA = 135
	val WS = 136
	val COMMENT = 137
	val LINE_COMMENT = 138
	val HDEFINE = 139
	val HIF = 140
	val HELSE = 141
	val HUNDEF = 142
	val HIFNDEF = 143
	val HENDIF = 144

    val RULE_translation_unit = 0
    val RULE_external_declaration = 1
    val RULE_preprocessor_declaration = 2
    val RULE_class_interface = 3
    val RULE_category_interface = 4
    val RULE_class_implementation = 5
    val RULE_category_implementation = 6
    val RULE_protocol_declaration = 7
    val RULE_protocol_declaration_list = 8
    val RULE_class_declaration_list = 9
    val RULE_class_list = 10
    val RULE_protocol_reference_list = 11
    val RULE_protocol_list = 12
    val RULE_property_declaration = 13
    val RULE_property_attributes_declaration = 14
    val RULE_property_attributes_list = 15
    val RULE_property_attribute = 16
    val RULE_ib_outlet_specifier = 17
    val RULE_class_name = 18
    val RULE_superclass_name = 19
    val RULE_category_name = 20
    val RULE_protocol_name = 21
    val RULE_instance_variables = 22
    val RULE_visibility_specification = 23
    val RULE_interface_declaration_list = 24
    val RULE_class_method_declaration = 25
    val RULE_instance_method_declaration = 26
    val RULE_method_declaration = 27
    val RULE_implementation_definition_list = 28
    val RULE_class_method_definition = 29
    val RULE_instance_method_definition = 30
    val RULE_method_definition = 31
    val RULE_method_selector = 32
    val RULE_keyword_declarator = 33
    val RULE_selector = 34
    val RULE_method_type = 35
    val RULE_property_implementation = 36
    val RULE_property_synthesize_list = 37
    val RULE_property_synthesize_item = 38
    val RULE_block_type = 39
    val RULE_type_specifier = 40
    val RULE_type_qualifier = 41
    val RULE_protocol_qualifier = 42
    val RULE_primary_expression = 43
    val RULE_dictionary_pair = 44
    val RULE_dictionary_expression = 45
    val RULE_array_expression = 46
    val RULE_box_expression = 47
    val RULE_block_parameters = 48
    val RULE_block_expression = 49
    val RULE_message_expression = 50
    val RULE_receiver = 51
    val RULE_message_selector = 52
    val RULE_keyword_argument = 53
    val RULE_selector_expression = 54
    val RULE_selector_name = 55
    val RULE_protocol_expression = 56
    val RULE_encode_expression = 57
    val RULE_type_variable_declarator = 58
    val RULE_try_statement = 59
    val RULE_catch_statement = 60
    val RULE_finally_statement = 61
    val RULE_throw_statement = 62
    val RULE_try_block = 63
    val RULE_synchronized_statement = 64
    val RULE_autorelease_statement = 65
    val RULE_function_definition = 66
    val RULE_declaration = 67
    val RULE_declaration_specifiers = 68
    val RULE_arc_behaviour_specifier = 69
    val RULE_storage_class_specifier = 70
    val RULE_init_declarator_list = 71
    val RULE_init_declarator = 72
    val RULE_struct_or_union_specifier = 73
    val RULE_struct_declaration = 74
    val RULE_specifier_qualifier_list = 75
    val RULE_struct_declarator_list = 76
    val RULE_struct_declarator = 77
    val RULE_enum_specifier = 78
    val RULE_enumerator_list = 79
    val RULE_enumerator = 80
    val RULE_pointer = 81
    val RULE_declarator = 82
    val RULE_direct_declarator = 83
    val RULE_declarator_suffix = 84
    val RULE_parameter_list = 85
    val RULE_parameter_declaration = 86
    val RULE_initializer = 87
    val RULE_type_name = 88
    val RULE_abstract_declarator = 89
    val RULE_abstract_declarator_suffix = 90
    val RULE_parameter_declaration_list = 91
    val RULE_statement_list = 92
    val RULE_statement = 93
    val RULE_labeled_statement = 94
    val RULE_compound_statement = 95
    val RULE_selection_statement = 96
    val RULE_for_in_statement = 97
    val RULE_for_statement = 98
    val RULE_while_statement = 99
    val RULE_do_statement = 100
    val RULE_iteration_statement = 101
    val RULE_jump_statement = 102
    val RULE_expression = 103
    val RULE_assignment_expression = 104
    val RULE_assignment_operator = 105
    val RULE_conditional_expression = 106
    val RULE_constant_expression = 107
    val RULE_logical_or_expression = 108
    val RULE_logical_and_expression = 109
    val RULE_inclusive_or_expression = 110
    val RULE_exclusive_or_expression = 111
    val RULE_and_expression = 112
    val RULE_equality_expression = 113
    val RULE_relational_expression = 114
    val RULE_shift_expression = 115
    val RULE_additive_expression = 116
    val RULE_multiplicative_expression = 117
    val RULE_cast_expression = 118
    val RULE_unary_expression = 119
    val RULE_unary_operator = 120
    val RULE_postfix_expression = 121
    val RULE_argument_expression_list = 122
    val RULE_identifier = 123
    val RULE_constant = 124
    val ruleNames = scala.List(
    		"translation_unit", "external_declaration", "preprocessor_declaration", 
    		"class_interface", "category_interface", "class_implementation", "category_implementation", 
    		"protocol_declaration", "protocol_declaration_list", "class_declaration_list", 
    		"class_list", "protocol_reference_list", "protocol_list", "property_declaration", 
    		"property_attributes_declaration", "property_attributes_list", "property_attribute", 
    		"ib_outlet_specifier", "class_name", "superclass_name", "category_name", 
    		"protocol_name", "instance_variables", "visibility_specification", 
    		"interface_declaration_list", "class_method_declaration", "instance_method_declaration", 
    		"method_declaration", "implementation_definition_list", "class_method_definition", 
    		"instance_method_definition", "method_definition", "method_selector", 
    		"keyword_declarator", "selector", "method_type", "property_implementation", 
    		"property_synthesize_list", "property_synthesize_item", "block_type", 
    		"type_specifier", "type_qualifier", "protocol_qualifier", "primary_expression", 
    		"dictionary_pair", "dictionary_expression", "array_expression", "box_expression", 
    		"block_parameters", "block_expression", "message_expression", "receiver", 
    		"message_selector", "keyword_argument", "selector_expression", "selector_name", 
    		"protocol_expression", "encode_expression", "type_variable_declarator", 
    		"try_statement", "catch_statement", "finally_statement", "throw_statement", 
    		"try_block", "synchronized_statement", "autorelease_statement", "function_definition", 
    		"declaration", "declaration_specifiers", "arc_behaviour_specifier", 
    		"storage_class_specifier", "init_declarator_list", "init_declarator", 
    		"struct_or_union_specifier", "struct_declaration", "specifier_qualifier_list", 
    		"struct_declarator_list", "struct_declarator", "enum_specifier", "enumerator_list", 
    		"enumerator", "pointer", "declarator", "direct_declarator", "declarator_suffix", 
    		"parameter_list", "parameter_declaration", "initializer", "type_name", 
    		"abstract_declarator", "abstract_declarator_suffix", "parameter_declaration_list", 
    		"statement_list", "statement", "labeled_statement", "compound_statement", 
    		"selection_statement", "for_in_statement", "for_statement", "while_statement", 
    		"do_statement", "iteration_statement", "jump_statement", "expression", 
    		"assignment_expression", "assignment_operator", "conditional_expression", 
    		"constant_expression", "logical_or_expression", "logical_and_expression", 
    		"inclusive_or_expression", "exclusive_or_expression", "and_expression", 
    		"equality_expression", "relational_expression", "shift_expression", 
    		"additive_expression", "multiplicative_expression", "cast_expression", 
    		"unary_expression", "unary_operator", "postfix_expression", "argument_expression_list", 
    		"identifier", "constant"
    ).toArray

	private val _LITERAL_NAMES = scala.List(
		null, "'@required'", "'@autoreleasepool'", "'@catch'", "'@class'", "'@dynamic'", 
		"'@encode'", "'@end'", "'@finally'", "'@implementation'", "'@interface'", 
		"'@package'", "'@protocol'", "'@optional'", "'@private'", "'@property'", 
		"'@protected'", "'@public'", "'@selector'", "'@synchronized'", "'@synthesize'", 
		"'@throw'", "'@try'", "'super'", "'self'", "'abstract'", "'auto'", "'boolean'", 
		"'break'", "'bycopy'", "'byref'", "'case'", "'char'", "'const'", "'continue'", 
		"'default'", "'do'", "'double'", "'else'", "'enum'", "'extern'", "'float'", 
		"'for'", "'id'", "'if'", "'in'", "'inout'", "'goto'", "'int'", "'long'", 
		"'oneway'", "'out'", "'register'", "'return'", "'short'", "'signed'", 
		"'sizeof'", "'static'", "'struct'", "'switch'", "'typedef'", "'union'", 
		"'unsigned'", "'void'", "'volatile'", "'while'", "'NS_OPTIONS'", "'NS_ENUM'", 
		"'__weak'", "'__unsafe_unretained'", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "';'", "','", "'.'", "'->'", "'@'", "'='", "'>'", "'<'", "'!'", 
		"'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", 
		"'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'>>'", 
		"'<<'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", 
		"'<<='", "'>>='", "'...'", "'assign'", "'getter'", "'nonatomic'", "'setter'", 
		"'strong'", "'retain'", "'readonly'", "'readwrite'", "'weak'"
	).toArray

	private val _SYMBOLIC_NAMES = scala.List(
		null, null, "AUTORELEASEPOOL", "CATCH", "CLASS", "DYNAMIC", "ENCODE", 
		"END", "FINALLY", "IMPLEMENTATION", "INTERFACE", "PACKAGE", "PROTOCOL", 
		"OPTIONAL", "PRIVATE", "PROPERTY", "PROTECTED", "PUBLIC", "SELECTOR", 
		"SYNCHRONIZED", "SYNTHESIZE", "THROW", "TRY", "SUPER", "SELF", "ABSTRACT", 
		"AUTO", "BOOLEAN", "BREAK", "BYCOPY", "BYREF", "CASE", "CHAR", "CONST", 
		"CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTERN", "FLOAT", 
		"FOR", "ID", "IF", "IN", "INOUT", "GOTO", "INT", "LONG", "ONEWAY", "OUT", 
		"REGISTER", "RETURN", "SHORT", "SIGNED", "SIZEOF", "STATIC", "STRUCT", 
		"SWITCH", "TYPEDEF", "UNION", "UNSIGNED", "VOID", "VOLATILE", "WHILE", 
		"NS_OPTIONS", "NS_ENUM", "WWEAK", "WUNSAFE_UNRETAINED", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "STRUCTACCESS", 
		"AT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", 
		"DIV", "BITAND", "BITOR", "CARET", "MOD", "SHIFT_R", "SHIFT_L", "ADD_ASSIGN", 
		"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", 
		"MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "ELIPSIS", "ASSIGNPA", 
		"GETTER", "NONATOMIC", "SETTER", "STRONG", "RETAIN", "READONLY", "READWRITE", 
		"WEAK", "IDENTIFIER", "CHARACTER_LITERAL", "STRING_LITERAL", "HEX_LITERAL", 
		"DECIMAL_LITERAL", "OCTAL_LITERAL", "FLOATING_POINT_LITERAL", "IMPORT", 
		"INCLUDE", "PRAGMA", "WS", "COMMENT", "LINE_COMMENT", "HDEFINE", "HIF", 
		"HELSE", "HUNDEF", "HIFNDEF", "HENDIF"
	).toArray

	val VOCABULARY: Vocabulary = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

	@deprecated
	final val tokenNames = (0 until _SYMBOLIC_NAMES.length).map {
		i => scala.List(
			Option(VOCABULARY.getLiteralName(i)),
			Option(VOCABULARY.getSymbolicName(i)),
			Option("<INVALID>")
		).flatten.head
	} .toArray

	private val _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0092\u054f\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\3\2\6\2\u00fe\n\2\r\2\16"+
		"\2\u00ff\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0110"+
		"\n\3\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0118\n\5\3\5\5\5\u011b\n\5\3\5\5\5\u011e"+
		"\n\5\3\5\5\5\u0121\n\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u0129\n\6\3\6\3\6\5"+
		"\6\u012d\n\6\3\6\5\6\u0130\n\6\3\6\5\6\u0133\n\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\5\7\u013b\n\7\3\7\5\7\u013e\n\7\3\7\5\7\u0141\n\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u014b\n\b\3\b\3\b\3\t\3\t\3\t\5\t\u0152\n\t\3\t\3\t"+
		"\3\t\7\t\u0157\n\t\f\t\16\t\u015a\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\7\f\u0169\n\f\f\f\16\f\u016c\13\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\7\16\u0175\n\16\f\16\16\16\u0178\13\16\3\17\3\17"+
		"\5\17\u017c\n\17\3\17\5\17\u017f\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\7\21\u018a\n\21\f\21\16\21\u018d\13\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u019f"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u01a7\n\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\7\30\u01b3\n\30\f\30\16\30\u01b6\13\30"+
		"\3\30\3\30\3\30\3\30\6\30\u01bc\n\30\r\30\16\30\u01bd\3\30\3\30\3\30\3"+
		"\30\6\30\u01c4\n\30\r\30\16\30\u01c5\3\30\3\30\3\30\3\30\3\30\3\30\6\30"+
		"\u01ce\n\30\r\30\16\30\u01cf\3\30\3\30\3\30\5\30\u01d5\n\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\6\32\u01dd\n\32\r\32\16\32\u01de\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\5\35\u01e8\n\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\6\36\u01f2\n\36\r\36\16\36\u01f3\3\37\3\37\3\37\3 \3 \3 \3!\5!\u01fd"+
		"\n!\3!\3!\5!\u0201\n!\3!\5!\u0204\n!\3!\3!\3\"\3\"\6\"\u020a\n\"\r\"\16"+
		"\"\u020b\3\"\5\"\u020f\n\"\5\"\u0211\n\"\3#\5#\u0214\n#\3#\3#\7#\u0218"+
		"\n#\f#\16#\u021b\13#\3#\3#\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\5"+
		"&\u022d\n&\3\'\3\'\3\'\7\'\u0232\n\'\f\'\16\'\u0235\13\'\3(\3(\3(\3(\5"+
		"(\u023b\n(\3)\3)\3)\3)\5)\u0241\n)\3)\3)\5)\u0245\n)\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\5*\u0252\n*\3*\3*\5*\u0256\n*\3*\3*\3*\3*\3*\5*\u025d"+
		"\n*\3+\3+\3+\5+\u0262\n+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\5-\u0277\n-\3.\3.\3.\3.\5.\u027d\n.\3/\3/\3/\5/\u0282\n/"+
		"\3/\3/\7/\u0286\n/\f/\16/\u0289\13/\3/\5/\u028c\n/\3/\3/\3\60\3\60\3\60"+
		"\5\60\u0293\n\60\3\60\3\60\7\60\u0297\n\60\f\60\16\60\u029a\13\60\3\60"+
		"\5\60\u029d\n\60\3\60\3\60\3\61\3\61\3\61\3\61\5\61\u02a5\n\61\3\61\3"+
		"\61\3\61\3\61\5\61\u02ab\n\61\3\62\3\62\3\62\5\62\u02b0\n\62\3\62\3\62"+
		"\7\62\u02b4\n\62\f\62\16\62\u02b7\13\62\3\62\3\62\3\63\3\63\5\63\u02bd"+
		"\n\63\3\63\5\63\u02c0\n\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\5\65\u02cc\n\65\3\66\3\66\6\66\u02d0\n\66\r\66\16\66\u02d1\5\66"+
		"\u02d4\n\66\3\67\5\67\u02d7\n\67\3\67\3\67\3\67\38\38\38\38\38\39\39\5"+
		"9\u02e3\n9\39\69\u02e6\n9\r9\169\u02e7\59\u02ea\n9\3:\3:\3:\3:\3:\3;\3"+
		";\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3"+
		"@\3A\3A\7A\u030c\nA\fA\16A\u030f\13A\3A\5A\u0312\nA\3B\3B\3B\3B\3B\3B"+
		"\3C\3C\3C\3D\5D\u031e\nD\3D\3D\3D\3E\3E\5E\u0325\nE\3E\3E\3F\3F\3F\3F"+
		"\6F\u032d\nF\rF\16F\u032e\3G\3G\3H\3H\3I\3I\3I\7I\u0338\nI\fI\16I\u033b"+
		"\13I\3J\3J\3J\5J\u0340\nJ\3K\3K\3K\5K\u0345\nK\3K\3K\6K\u0349\nK\rK\16"+
		"K\u034a\3K\3K\5K\u034f\nK\3L\3L\3L\3L\3M\3M\3M\6M\u0358\nM\rM\16M\u0359"+
		"\3N\3N\3N\7N\u035f\nN\fN\16N\u0362\13N\3O\3O\5O\u0366\nO\3O\3O\5O\u036a"+
		"\nO\3P\3P\5P\u036e\nP\3P\3P\5P\u0372\nP\3P\3P\3P\3P\3P\5P\u0379\nP\3P"+
		"\3P\3P\3P\5P\u037f\nP\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P"+
		"\3P\3P\3P\3P\5P\u0395\nP\3Q\3Q\3Q\7Q\u039a\nQ\fQ\16Q\u039d\13Q\3Q\5Q\u03a0"+
		"\nQ\3R\3R\3R\5R\u03a5\nR\3S\3S\5S\u03a9\nS\3S\3S\5S\u03ad\nS\3S\5S\u03b0"+
		"\nS\3T\5T\u03b3\nT\3T\3T\3U\3U\7U\u03b9\nU\fU\16U\u03bc\13U\3U\3U\3U\3"+
		"U\7U\u03c2\nU\fU\16U\u03c5\13U\3U\3U\3U\5U\u03ca\nU\3U\3U\5U\u03ce\nU"+
		"\3V\3V\5V\u03d2\nV\3V\3V\3V\5V\u03d7\nV\3V\5V\u03da\nV\3W\3W\3W\5W\u03df"+
		"\nW\3X\3X\5X\u03e3\nX\3X\5X\u03e6\nX\3Y\3Y\3Y\3Y\3Y\7Y\u03ed\nY\fY\16"+
		"Y\u03f0\13Y\3Y\5Y\u03f3\nY\3Y\3Y\5Y\u03f7\nY\3Z\3Z\3Z\3Z\5Z\u03fd\nZ\3"+
		"[\3[\3[\3[\3[\3[\3[\6[\u0406\n[\r[\16[\u0407\3[\3[\5[\u040c\n[\3[\6[\u040f"+
		"\n[\r[\16[\u0410\3[\5[\u0414\n[\3\\\3\\\5\\\u0418\n\\\3\\\3\\\3\\\5\\"+
		"\u041d\n\\\3\\\5\\\u0420\n\\\3]\3]\3]\7]\u0425\n]\f]\16]\u0428\13]\3^"+
		"\6^\u042b\n^\r^\16^\u042c\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_\5_\u043b"+
		"\n_\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\5`\u0449\n`\3a\3a\3a\7a\u044e"+
		"\na\fa\16a\u0451\13a\3a\3a\3b\3b\3b\3b\3b\3b\3b\5b\u045c\nb\3b\3b\3b\3"+
		"b\3b\3b\5b\u0464\nb\3c\3c\3c\3c\3c\5c\u046b\nc\3c\3c\3c\3d\3d\3d\3d\3"+
		"d\3d\5d\u0476\nd\3d\3d\5d\u047a\nd\3d\3d\5d\u047e\nd\3d\3d\3d\3e\3e\3"+
		"e\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\3f\3g\3g\3g\3g\5g\u0495\ng\3h\3h\3h\3"+
		"h\3h\3h\3h\3h\3h\3h\5h\u04a1\nh\3h\5h\u04a4\nh\3i\3i\3i\7i\u04a9\ni\f"+
		"i\16i\u04ac\13i\3j\3j\3j\3j\3j\5j\u04b3\nj\3k\3k\3l\3l\3l\5l\u04ba\nl"+
		"\3l\3l\5l\u04be\nl\3m\3m\3n\3n\3n\7n\u04c5\nn\fn\16n\u04c8\13n\3o\3o\3"+
		"o\7o\u04cd\no\fo\16o\u04d0\13o\3p\3p\3p\7p\u04d5\np\fp\16p\u04d8\13p\3"+
		"q\3q\3q\7q\u04dd\nq\fq\16q\u04e0\13q\3r\3r\3r\7r\u04e5\nr\fr\16r\u04e8"+
		"\13r\3s\3s\3s\7s\u04ed\ns\fs\16s\u04f0\13s\3t\3t\3t\7t\u04f5\nt\ft\16"+
		"t\u04f8\13t\3u\3u\3u\7u\u04fd\nu\fu\16u\u0500\13u\3v\3v\3v\7v\u0505\n"+
		"v\fv\16v\u0508\13v\3w\3w\3w\7w\u050d\nw\fw\16w\u0510\13w\3x\3x\3x\3x\3"+
		"x\3x\5x\u0518\nx\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\3y\5y\u0528\n"+
		"y\5y\u052a\ny\3z\3z\3{\3{\3{\3{\3{\3{\3{\5{\u0535\n{\3{\3{\3{\3{\3{\3"+
		"{\3{\7{\u053e\n{\f{\16{\u0541\13{\3|\3|\3|\7|\u0546\n|\f|\16|\u0549\13"+
		"|\3}\3}\3~\3~\3~\2\2\177\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4"+
		"\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc"+
		"\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4"+
		"\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\2\20"+
		"\3\2\u0087\u0088\5\2\r\r\20\20\22\23\5\2\37 /\60\64\65\3\2FG\7\2\34\34"+
		"**\66\66;;>>\4\2<<??\4\2SSlu\4\2ZZ]]\4\2TU[\\\3\2jk\3\2bc\4\2deii\5\2"+
		"VWcdff\4\2\u0081\u0081\u0083\u0086\u05c1\2\u00fd\3\2\2\2\4\u010f\3\2\2"+
		"\2\6\u0111\3\2\2\2\b\u0113\3\2\2\2\n\u0124\3\2\2\2\f\u0136\3\2\2\2\16"+
		"\u0144\3\2\2\2\20\u014e\3\2\2\2\22\u015d\3\2\2\2\24\u0161\3\2\2\2\26\u0165"+
		"\3\2\2\2\30\u016d\3\2\2\2\32\u0171\3\2\2\2\34\u0179\3\2\2\2\36\u0182\3"+
		"\2\2\2 \u0186\3\2\2\2\"\u019e\3\2\2\2$\u01a6\3\2\2\2&\u01a8\3\2\2\2(\u01aa"+
		"\3\2\2\2*\u01ac\3\2\2\2,\u01ae\3\2\2\2.\u01d4\3\2\2\2\60\u01d6\3\2\2\2"+
		"\62\u01dc\3\2\2\2\64\u01e0\3\2\2\2\66\u01e3\3\2\2\28\u01e7\3\2\2\2:\u01f1"+
		"\3\2\2\2<\u01f5\3\2\2\2>\u01f8\3\2\2\2@\u01fc\3\2\2\2B\u0210\3\2\2\2D"+
		"\u0213\3\2\2\2F\u021e\3\2\2\2H\u0220\3\2\2\2J\u022c\3\2\2\2L\u022e\3\2"+
		"\2\2N\u023a\3\2\2\2P\u023c\3\2\2\2R\u025c\3\2\2\2T\u0261\3\2\2\2V\u0263"+
		"\3\2\2\2X\u0276\3\2\2\2Z\u0278\3\2\2\2\\\u027e\3\2\2\2^\u028f\3\2\2\2"+
		"`\u02aa\3\2\2\2b\u02ac\3\2\2\2d\u02ba\3\2\2\2f\u02c3\3\2\2\2h\u02cb\3"+
		"\2\2\2j\u02d3\3\2\2\2l\u02d6\3\2\2\2n\u02db\3\2\2\2p\u02e9\3\2\2\2r\u02eb"+
		"\3\2\2\2t\u02f0\3\2\2\2v\u02f5\3\2\2\2x\u02f8\3\2\2\2z\u02fb\3\2\2\2|"+
		"\u0301\3\2\2\2~\u0304\3\2\2\2\u0080\u0309\3\2\2\2\u0082\u0313\3\2\2\2"+
		"\u0084\u0319\3\2\2\2\u0086\u031d\3\2\2\2\u0088\u0322\3\2\2\2\u008a\u032c"+
		"\3\2\2\2\u008c\u0330\3\2\2\2\u008e\u0332\3\2\2\2\u0090\u0334\3\2\2\2\u0092"+
		"\u033c\3\2\2\2\u0094\u0341\3\2\2\2\u0096\u0350\3\2\2\2\u0098\u0357\3\2"+
		"\2\2\u009a\u035b\3\2\2\2\u009c\u0369\3\2\2\2\u009e\u0394\3\2\2\2\u00a0"+
		"\u0396\3\2\2\2\u00a2\u03a1\3\2\2\2\u00a4\u03af\3\2\2\2\u00a6\u03b2\3\2"+
		"\2\2\u00a8\u03cd\3\2\2\2\u00aa\u03d9\3\2\2\2\u00ac\u03db\3\2\2\2\u00ae"+
		"\u03e0\3\2\2\2\u00b0\u03f6\3\2\2\2\u00b2\u03fc\3\2\2\2\u00b4\u0413\3\2"+
		"\2\2\u00b6\u041f\3\2\2\2\u00b8\u0421\3\2\2\2\u00ba\u042a\3\2\2\2\u00bc"+
		"\u043a\3\2\2\2\u00be\u0448\3\2\2\2\u00c0\u044a\3\2\2\2\u00c2\u0463\3\2"+
		"\2\2\u00c4\u0465\3\2\2\2\u00c6\u046f\3\2\2\2\u00c8\u0482\3\2\2\2\u00ca"+
		"\u0488\3\2\2\2\u00cc\u0494\3\2\2\2\u00ce\u04a3\3\2\2\2\u00d0\u04a5\3\2"+
		"\2\2\u00d2\u04b2\3\2\2\2\u00d4\u04b4\3\2\2\2\u00d6\u04b6\3\2\2\2\u00d8"+
		"\u04bf\3\2\2\2\u00da\u04c1\3\2\2\2\u00dc\u04c9\3\2\2\2\u00de\u04d1\3\2"+
		"\2\2\u00e0\u04d9\3\2\2\2\u00e2\u04e1\3\2\2\2\u00e4\u04e9\3\2\2\2\u00e6"+
		"\u04f1\3\2\2\2\u00e8\u04f9\3\2\2\2\u00ea\u0501\3\2\2\2\u00ec\u0509\3\2"+
		"\2\2\u00ee\u0517\3\2\2\2\u00f0\u0529\3\2\2\2\u00f2\u052b\3\2\2\2\u00f4"+
		"\u052d\3\2\2\2\u00f6\u0542\3\2\2\2\u00f8\u054a\3\2\2\2\u00fa\u054c\3\2"+
		"\2\2\u00fc\u00fe\5\4\3\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\2"+
		"\2\3\u0102\3\3\2\2\2\u0103\u0110\7\u008b\2\2\u0104\u0110\7\u008c\2\2\u0105"+
		"\u0110\5\6\4\2\u0106\u0110\5\u0086D\2\u0107\u0110\5\u0088E\2\u0108\u0110"+
		"\5\b\5\2\u0109\u0110\5\f\7\2\u010a\u0110\5\n\6\2\u010b\u0110\5\16\b\2"+
		"\u010c\u0110\5\20\t\2\u010d\u0110\5\22\n\2\u010e\u0110\5\24\13\2\u010f"+
		"\u0103\3\2\2\2\u010f\u0104\3\2\2\2\u010f\u0105\3\2\2\2\u010f\u0106\3\2"+
		"\2\2\u010f\u0107\3\2\2\2\u010f\u0108\3\2\2\2\u010f\u0109\3\2\2\2\u010f"+
		"\u010a\3\2\2\2\u010f\u010b\3\2\2\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u010e\3\2\2\2\u0110\5\3\2\2\2\u0111\u0112\t\2\2\2\u0112\7\3"+
		"\2\2\2\u0113\u0114\7\f\2\2\u0114\u0117\5&\24\2\u0115\u0116\7Y\2\2\u0116"+
		"\u0118\5(\25\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2"+
		"\2\2\u0119\u011b\5\30\r\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u011e\5.\30\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u0121\5\62\32\2\u0120\u011f\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\7\t\2\2\u0123\t\3\2\2\2"+
		"\u0124\u0125\7\f\2\2\u0125\u0126\5&\24\2\u0126\u0128\7H\2\2\u0127\u0129"+
		"\5*\26\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\7I\2\2\u012b\u012d\5\30\r\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u012f\3\2\2\2\u012e\u0130\5.\30\2\u012f\u012e\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u0133\5\62\32\2\u0132\u0131\3"+
		"\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\7\t\2\2\u0135"+
		"\13\3\2\2\2\u0136\u0137\7\13\2\2\u0137\u013a\5&\24\2\u0138\u0139\7Y\2"+
		"\2\u0139\u013b\5(\25\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d"+
		"\3\2\2\2\u013c\u013e\5.\30\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\3\2\2\2\u013f\u0141\5:\36\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0143\7\t\2\2\u0143\r\3\2\2\2\u0144\u0145"+
		"\7\13\2\2\u0145\u0146\5&\24\2\u0146\u0147\7H\2\2\u0147\u0148\5*\26\2\u0148"+
		"\u014a\7I\2\2\u0149\u014b\5:\36\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u014d\7\t\2\2\u014d\17\3\2\2\2\u014e\u014f"+
		"\7\16\2\2\u014f\u0151\5,\27\2\u0150\u0152\5\30\r\2\u0151\u0150\3\2\2\2"+
		"\u0151\u0152\3\2\2\2\u0152\u0158\3\2\2\2\u0153\u0157\5\62\32\2\u0154\u0157"+
		"\7\17\2\2\u0155\u0157\7\3\2\2\u0156\u0153\3\2\2\2\u0156\u0154\3\2\2\2"+
		"\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\7\t\2\2\u015c"+
		"\21\3\2\2\2\u015d\u015e\7\16\2\2\u015e\u015f\5\32\16\2\u015f\u0160\7N"+
		"\2\2\u0160\23\3\2\2\2\u0161\u0162\7\6\2\2\u0162\u0163\5\26\f\2\u0163\u0164"+
		"\7N\2\2\u0164\25\3\2\2\2\u0165\u016a\5&\24\2\u0166\u0167\7O\2\2\u0167"+
		"\u0169\5&\24\2\u0168\u0166\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\27\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e"+
		"\7U\2\2\u016e\u016f\5\32\16\2\u016f\u0170\7T\2\2\u0170\31\3\2\2\2\u0171"+
		"\u0176\5,\27\2\u0172\u0173\7O\2\2\u0173\u0175\5,\27\2\u0174\u0172\3\2"+
		"\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\33\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017b\7\21\2\2\u017a\u017c\5\36"+
		"\20\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d"+
		"\u017f\5$\23\2\u017e\u017d\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0181\5\u0096L\2\u0181\35\3\2\2\2\u0182\u0183\7H\2\2\u0183"+
		"\u0184\5 \21\2\u0184\u0185\7I\2\2\u0185\37\3\2\2\2\u0186\u018b\5\"\22"+
		"\2\u0187\u0188\7O\2\2\u0188\u018a\5\"\22\2\u0189\u0187\3\2\2\2\u018a\u018d"+
		"\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c!\3\2\2\2\u018d"+
		"\u018b\3\2\2\2\u018e\u019f\7y\2\2\u018f\u019f\7w\2\2\u0190\u019f\7\177"+
		"\2\2\u0191\u019f\7{\2\2\u0192\u019f\7|\2\2\u0193\u019f\7}\2\2\u0194\u019f"+
		"\7~\2\2\u0195\u019f\3\2\2\2\u0196\u0197\7x\2\2\u0197\u0198\7S\2\2\u0198"+
		"\u019f\7\u0080\2\2\u0199\u019a\7z\2\2\u019a\u019b\7S\2\2\u019b\u019c\7"+
		"\u0080\2\2\u019c\u019f\7Y\2\2\u019d\u019f\7\u0080\2\2\u019e\u018e\3\2"+
		"\2\2\u019e\u018f\3\2\2\2\u019e\u0190\3\2\2\2\u019e\u0191\3\2\2\2\u019e"+
		"\u0192\3\2\2\2\u019e\u0193\3\2\2\2\u019e\u0194\3\2\2\2\u019e\u0195\3\2"+
		"\2\2\u019e\u0196\3\2\2\2\u019e\u0199\3\2\2\2\u019e\u019d\3\2\2\2\u019f"+
		"#\3\2\2\2\u01a0\u01a1\7\u0080\2\2\u01a1\u01a2\7H\2\2\u01a2\u01a3\5&\24"+
		"\2\u01a3\u01a4\7I\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a7\7\u0080\2\2\u01a6"+
		"\u01a0\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7%\3\2\2\2\u01a8\u01a9\7\u0080"+
		"\2\2\u01a9\'\3\2\2\2\u01aa\u01ab\7\u0080\2\2\u01ab)\3\2\2\2\u01ac\u01ad"+
		"\7\u0080\2\2\u01ad+\3\2\2\2\u01ae\u01af\7\u0080\2\2\u01af-\3\2\2\2\u01b0"+
		"\u01b4\7J\2\2\u01b1\u01b3\5\u0096L\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3"+
		"\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01d5\7K\2\2\u01b8\u01b9\7J\2\2\u01b9\u01bb\5\60"+
		"\31\2\u01ba\u01bc\5\u0096L\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\7K"+
		"\2\2\u01c0\u01d5\3\2\2\2\u01c1\u01c3\7J\2\2\u01c2\u01c4\5\u0096L\2\u01c3"+
		"\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2"+
		"\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\5.\30\2\u01c8\u01c9\7K\2\2\u01c9"+
		"\u01d5\3\2\2\2\u01ca\u01cb\7J\2\2\u01cb\u01cd\5\60\31\2\u01cc\u01ce\5"+
		"\u0096L\2\u01cd\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2"+
		"\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\5.\30\2\u01d2\u01d3"+
		"\7K\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01b0\3\2\2\2\u01d4\u01b8\3\2\2\2\u01d4"+
		"\u01c1\3\2\2\2\u01d4\u01ca\3\2\2\2\u01d5/\3\2\2\2\u01d6\u01d7\t\3\2\2"+
		"\u01d7\61\3\2\2\2\u01d8\u01dd\5\u0088E\2\u01d9\u01dd\5\64\33\2\u01da\u01dd"+
		"\5\66\34\2\u01db\u01dd\5\34\17\2\u01dc\u01d8\3\2\2\2\u01dc\u01d9\3\2\2"+
		"\2\u01dc\u01da\3\2\2\2\u01dc\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01dc"+
		"\3\2\2\2\u01de\u01df\3\2\2\2\u01df\63\3\2\2\2\u01e0\u01e1\7b\2\2\u01e1"+
		"\u01e2\58\35\2\u01e2\65\3\2\2\2\u01e3\u01e4\7c\2\2\u01e4\u01e5\58\35\2"+
		"\u01e5\67\3\2\2\2\u01e6\u01e8\5H%\2\u01e7\u01e6\3\2\2\2\u01e7\u01e8\3"+
		"\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\5B\"\2\u01ea\u01eb\7N\2\2\u01eb"+
		"9\3\2\2\2\u01ec\u01f2\5\u0086D\2\u01ed\u01f2\5\u0088E\2\u01ee\u01f2\5"+
		"<\37\2\u01ef\u01f2\5> \2\u01f0\u01f2\5J&\2\u01f1\u01ec\3\2\2\2\u01f1\u01ed"+
		"\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4;\3\2\2\2"+
		"\u01f5\u01f6\7b\2\2\u01f6\u01f7\5@!\2\u01f7=\3\2\2\2\u01f8\u01f9\7c\2"+
		"\2\u01f9\u01fa\5@!\2\u01fa?\3\2\2\2\u01fb\u01fd\5H%\2\u01fc\u01fb\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\5B\"\2\u01ff"+
		"\u0201\5\u0090I\2\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0203"+
		"\3\2\2\2\u0202\u0204\7N\2\2\u0203\u0202\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u0206\5\u00c0a\2\u0206A\3\2\2\2\u0207\u0211\5F$\2"+
		"\u0208\u020a\5D#\2\u0209\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u0209"+
		"\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020f\5\u00acW"+
		"\2\u020e\u020d\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u0207"+
		"\3\2\2\2\u0210\u0209\3\2\2\2\u0211C\3\2\2\2\u0212\u0214\5F$\2\u0213\u0212"+
		"\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0219\7Y\2\2\u0216"+
		"\u0218\5H%\2\u0217\u0216\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2"+
		"\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u021d"+
		"\7\u0080\2\2\u021dE\3\2\2\2\u021e\u021f\7\u0080\2\2\u021fG\3\2\2\2\u0220"+
		"\u0221\7H\2\2\u0221\u0222\5\u00b2Z\2\u0222\u0223\7I\2\2\u0223I\3\2\2\2"+
		"\u0224\u0225\7\26\2\2\u0225\u0226\5L\'\2\u0226\u0227\7N\2\2\u0227\u022d"+
		"\3\2\2\2\u0228\u0229\7\7\2\2\u0229\u022a\5L\'\2\u022a\u022b\7N\2\2\u022b"+
		"\u022d\3\2\2\2\u022c\u0224\3\2\2\2\u022c\u0228\3\2\2\2\u022dK\3\2\2\2"+
		"\u022e\u0233\5N(\2\u022f\u0230\7O\2\2\u0230\u0232\5N(\2\u0231\u022f\3"+
		"\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234"+
		"M\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u023b\7\u0080\2\2\u0237\u0238\7\u0080"+
		"\2\2\u0238\u0239\7S\2\2\u0239\u023b\7\u0080\2\2\u023a\u0236\3\2\2\2\u023a"+
		"\u0237\3\2\2\2\u023bO\3\2\2\2\u023c\u023d\5R*\2\u023d\u023e\7H\2\2\u023e"+
		"\u0240\7h\2\2\u023f\u0241\5R*\2\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2"+
		"\2\u0241\u0242\3\2\2\2\u0242\u0244\7I\2\2\u0243\u0245\5b\62\2\u0244\u0243"+
		"\3\2\2\2\u0244\u0245\3\2\2\2\u0245Q\3\2\2\2\u0246\u025d\7A\2\2\u0247\u025d"+
		"\7\"\2\2\u0248\u025d\78\2\2\u0249\u025d\7\62\2\2\u024a\u025d\7\63\2\2"+
		"\u024b\u025d\7+\2\2\u024c\u025d\7\'\2\2\u024d\u025d\79\2\2\u024e\u025d"+
		"\7@\2\2\u024f\u0251\7-\2\2\u0250\u0252\5\30\r\2\u0251\u0250\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u025d\3\2\2\2\u0253\u0255\5&\24\2\u0254\u0256\5\30"+
		"\r\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2\2\2\u0256\u025d\3\2\2\2\u0257"+
		"\u025d\5\u0094K\2\u0258\u025d\5\u009eP\2\u0259\u025d\7\u0080\2\2\u025a"+
		"\u025b\7\u0080\2\2\u025b\u025d\5\u00a4S\2\u025c\u0246\3\2\2\2\u025c\u0247"+
		"\3\2\2\2\u025c\u0248\3\2\2\2\u025c\u0249\3\2\2\2\u025c\u024a\3\2\2\2\u025c"+
		"\u024b\3\2\2\2\u025c\u024c\3\2\2\2\u025c\u024d\3\2\2\2\u025c\u024e\3\2"+
		"\2\2\u025c\u024f\3\2\2\2\u025c\u0253\3\2\2\2\u025c\u0257\3\2\2\2\u025c"+
		"\u0258\3\2\2\2\u025c\u0259\3\2\2\2\u025c\u025a\3\2\2\2\u025dS\3\2\2\2"+
		"\u025e\u0262\7#\2\2\u025f\u0262\7B\2\2\u0260\u0262\5V,\2\u0261\u025e\3"+
		"\2\2\2\u0261\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262U\3\2\2\2\u0263\u0264"+
		"\t\4\2\2\u0264W\3\2\2\2\u0265\u0277\7\u0080\2\2\u0266\u0277\5\u00fa~\2"+
		"\u0267\u0277\7\u0082\2\2\u0268\u0269\7H\2\2\u0269\u026a\5\u00d0i\2\u026a"+
		"\u026b\7I\2\2\u026b\u0277\3\2\2\2\u026c\u0277\7\32\2\2\u026d\u0277\7\31"+
		"\2\2\u026e\u0277\5f\64\2\u026f\u0277\5n8\2\u0270\u0277\5r:\2\u0271\u0277"+
		"\5t;\2\u0272\u0277\5\\/\2\u0273\u0277\5^\60\2\u0274\u0277\5`\61\2\u0275"+
		"\u0277\5d\63\2\u0276\u0265\3\2\2\2\u0276\u0266\3\2\2\2\u0276\u0267\3\2"+
		"\2\2\u0276\u0268\3\2\2\2\u0276\u026c\3\2\2\2\u0276\u026d\3\2\2\2\u0276"+
		"\u026e\3\2\2\2\u0276\u026f\3\2\2\2\u0276\u0270\3\2\2\2\u0276\u0271\3\2"+
		"\2\2\u0276\u0272\3\2\2\2\u0276\u0273\3\2\2\2\u0276\u0274\3\2\2\2\u0276"+
		"\u0275\3\2\2\2\u0277Y\3\2\2\2\u0278\u0279\5\u00f4{\2\u0279\u027c\7Y\2"+
		"\2\u027a\u027d\5\u00f4{\2\u027b\u027d\5\u00d0i\2\u027c\u027a\3\2\2\2\u027c"+
		"\u027b\3\2\2\2\u027d[\3\2\2\2\u027e\u027f\7R\2\2\u027f\u0281\7J\2\2\u0280"+
		"\u0282\5Z.\2\u0281\u0280\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0287\3\2\2"+
		"\2\u0283\u0284\7O\2\2\u0284\u0286\5Z.\2\u0285\u0283\3\2\2\2\u0286\u0289"+
		"\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u028b\3\2\2\2\u0289"+
		"\u0287\3\2\2\2\u028a\u028c\7O\2\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2"+
		"\2\2\u028c\u028d\3\2\2\2\u028d\u028e\7K\2\2\u028e]\3\2\2\2\u028f\u0290"+
		"\7R\2\2\u0290\u0292\7L\2\2\u0291\u0293\5\u00f4{\2\u0292\u0291\3\2\2\2"+
		"\u0292\u0293\3\2\2\2\u0293\u0298\3\2\2\2\u0294\u0295\7O\2\2\u0295\u0297"+
		"\5\u00f4{\2\u0296\u0294\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2"+
		"\2\u0298\u0299\3\2\2\2\u0299\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029d"+
		"\7O\2\2\u029c\u029b\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029e\3\2\2\2\u029e"+
		"\u029f\7M\2\2\u029f_\3\2\2\2\u02a0\u02a1\7R\2\2\u02a1\u02a4\7H\2\2\u02a2"+
		"\u02a5\5\u00f4{\2\u02a3\u02a5\5\u00d0i\2\u02a4\u02a2\3\2\2\2\u02a4\u02a3"+
		"\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u02a7\7I\2\2\u02a7\u02ab\3\2\2\2\u02a8"+
		"\u02a9\7R\2\2\u02a9\u02ab\5\u00fa~\2\u02aa\u02a0\3\2\2\2\u02aa\u02a8\3"+
		"\2\2\2\u02aba\3\2\2\2\u02ac\u02af\7H\2\2\u02ad\u02b0\5v<\2\u02ae\u02b0"+
		"\7A\2\2\u02af\u02ad\3\2\2\2\u02af\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0"+
		"\u02b5\3\2\2\2\u02b1\u02b2\7O\2\2\u02b2\u02b4\5v<\2\u02b3\u02b1\3\2\2"+
		"\2\u02b4\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6\u02b8"+
		"\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b8\u02b9\7I\2\2\u02b9c\3\2\2\2\u02ba\u02bc"+
		"\7h\2\2\u02bb\u02bd\5R*\2\u02bc\u02bb\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd"+
		"\u02bf\3\2\2\2\u02be\u02c0\5b\62\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2"+
		"\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\5\u00c0a\2\u02c2e\3\2\2\2\u02c3\u02c4"+
		"\7L\2\2\u02c4\u02c5\5h\65\2\u02c5\u02c6\5j\66\2\u02c6\u02c7\7M\2\2\u02c7"+
		"g\3\2\2\2\u02c8\u02cc\5\u00d0i\2\u02c9\u02cc\5&\24\2\u02ca\u02cc\7\31"+
		"\2\2\u02cb\u02c8\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cb\u02ca\3\2\2\2\u02cc"+
		"i\3\2\2\2\u02cd\u02d4\5F$\2\u02ce\u02d0\5l\67\2\u02cf\u02ce\3\2\2\2\u02d0"+
		"\u02d1\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2\3\2\2\2\u02d2\u02d4\3\2"+
		"\2\2\u02d3\u02cd\3\2\2\2\u02d3\u02cf\3\2\2\2\u02d4k\3\2\2\2\u02d5\u02d7"+
		"\5F$\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8"+
		"\u02d9\7Y\2\2\u02d9\u02da\5\u00d0i\2\u02dam\3\2\2\2\u02db\u02dc\7\24\2"+
		"\2\u02dc\u02dd\7H\2\2\u02dd\u02de\5p9\2\u02de\u02df\7I\2\2\u02dfo\3\2"+
		"\2\2\u02e0\u02ea\5F$\2\u02e1\u02e3\5F$\2\u02e2\u02e1\3\2\2\2\u02e2\u02e3"+
		"\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\7Y\2\2\u02e5\u02e2\3\2\2\2\u02e6"+
		"\u02e7\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02ea\3\2"+
		"\2\2\u02e9\u02e0\3\2\2\2\u02e9\u02e5\3\2\2\2\u02eaq\3\2\2\2\u02eb\u02ec"+
		"\7\16\2\2\u02ec\u02ed\7H\2\2\u02ed\u02ee\5,\27\2\u02ee\u02ef\7I\2\2\u02ef"+
		"s\3\2\2\2\u02f0\u02f1\7\b\2\2\u02f1\u02f2\7H\2\2\u02f2\u02f3\5\u00b2Z"+
		"\2\u02f3\u02f4\7I\2\2\u02f4u\3\2\2\2\u02f5\u02f6\5\u008aF\2\u02f6\u02f7"+
		"\5\u00a6T\2\u02f7w\3\2\2\2\u02f8\u02f9\7\30\2\2\u02f9\u02fa\5\u00c0a\2"+
		"\u02fay\3\2\2\2\u02fb\u02fc\7\5\2\2\u02fc\u02fd\7H\2\2\u02fd\u02fe\5v"+
		"<\2\u02fe\u02ff\7I\2\2\u02ff\u0300\5\u00c0a\2\u0300{\3\2\2\2\u0301\u0302"+
		"\7\n\2\2\u0302\u0303\5\u00c0a\2\u0303}\3\2\2\2\u0304\u0305\7\27\2\2\u0305"+
		"\u0306\7H\2\2\u0306\u0307\7\u0080\2\2\u0307\u0308\7I\2\2\u0308\177\3\2"+
		"\2\2\u0309\u030d\5x=\2\u030a\u030c\5z>\2\u030b\u030a\3\2\2\2\u030c\u030f"+
		"\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0311\3\2\2\2\u030f"+
		"\u030d\3\2\2\2\u0310\u0312\5|?\2\u0311\u0310\3\2\2\2\u0311\u0312\3\2\2"+
		"\2\u0312\u0081\3\2\2\2\u0313\u0314\7\25\2\2\u0314\u0315\7H\2\2\u0315\u0316"+
		"\5X-\2\u0316\u0317\7I\2\2\u0317\u0318\5\u00c0a\2\u0318\u0083\3\2\2\2\u0319"+
		"\u031a\7\4\2\2\u031a\u031b\5\u00c0a\2\u031b\u0085\3\2\2\2\u031c\u031e"+
		"\5\u008aF\2\u031d\u031c\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031f\3\2\2"+
		"\2\u031f\u0320\5\u00a6T\2\u0320\u0321\5\u00c0a\2\u0321\u0087\3\2\2\2\u0322"+
		"\u0324\5\u008aF\2\u0323\u0325\5\u0090I\2\u0324\u0323\3\2\2\2\u0324\u0325"+
		"\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u0327\7N\2\2\u0327\u0089\3\2\2\2\u0328"+
		"\u032d\5\u008cG\2\u0329\u032d\5\u008eH\2\u032a\u032d\5R*\2\u032b\u032d"+
		"\5T+\2\u032c\u0328\3\2\2\2\u032c\u0329\3\2\2\2\u032c\u032a\3\2\2\2\u032c"+
		"\u032b\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u032c\3\2\2\2\u032e\u032f\3\2"+
		"\2\2\u032f\u008b\3\2\2\2\u0330\u0331\t\5\2\2\u0331\u008d\3\2\2\2\u0332"+
		"\u0333\t\6\2\2\u0333\u008f\3\2\2\2\u0334\u0339\5\u0092J\2\u0335\u0336"+
		"\7O\2\2\u0336\u0338\5\u0092J\2\u0337\u0335\3\2\2\2\u0338\u033b\3\2\2\2"+
		"\u0339\u0337\3\2\2\2\u0339\u033a\3\2\2\2\u033a\u0091\3\2\2\2\u033b\u0339"+
		"\3\2\2\2\u033c\u033f\5\u00a6T\2\u033d\u033e\7S\2\2\u033e\u0340\5\u00b0"+
		"Y\2\u033f\u033d\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u0093\3\2\2\2\u0341"+
		"\u034e\t\7\2\2\u0342\u034f\7\u0080\2\2\u0343\u0345\7\u0080\2\2\u0344\u0343"+
		"\3\2\2\2\u0344\u0345\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u0348\7J\2\2\u0347"+
		"\u0349\5\u0096L\2\u0348\u0347\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u0348"+
		"\3\2\2\2\u034a\u034b\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d\7K\2\2\u034d"+
		"\u034f\3\2\2\2\u034e\u0342\3\2\2\2\u034e\u0344\3\2\2\2\u034f\u0095\3\2"+
		"\2\2\u0350\u0351\5\u0098M\2\u0351\u0352\5\u009aN\2\u0352\u0353\7N\2\2"+
		"\u0353\u0097\3\2\2\2\u0354\u0358\5\u008cG\2\u0355\u0358\5R*\2\u0356\u0358"+
		"\5T+\2\u0357\u0354\3\2\2\2\u0357\u0355\3\2\2\2\u0357\u0356\3\2\2\2\u0358"+
		"\u0359\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u0099\3\2"+
		"\2\2\u035b\u0360\5\u009cO\2\u035c\u035d\7O\2\2\u035d\u035f\5\u009cO\2"+
		"\u035e\u035c\3\2\2\2\u035f\u0362\3\2\2\2\u0360\u035e\3\2\2\2\u0360\u0361"+
		"\3\2\2\2\u0361\u009b\3\2\2\2\u0362\u0360\3\2\2\2\u0363\u036a\5\u00a6T"+
		"\2\u0364\u0366\5\u00a6T\2\u0365\u0364\3\2\2\2\u0365\u0366\3\2\2\2\u0366"+
		"\u0367\3\2\2\2\u0367\u0368\7Y\2\2\u0368\u036a\5\u00fa~\2\u0369\u0363\3"+
		"\2\2\2\u0369\u0365\3\2\2\2\u036a\u009d\3\2\2\2\u036b\u0371\7)\2\2\u036c"+
		"\u036e\7\u0080\2\2\u036d\u036c\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f"+
		"\3\2\2\2\u036f\u0370\7Y\2\2\u0370\u0372\5\u00b2Z\2\u0371\u036d\3\2\2\2"+
		"\u0371\u0372\3\2\2\2\u0372\u037e\3\2\2\2\u0373\u0378\5\u00f8}\2\u0374"+
		"\u0375\7J\2\2\u0375\u0376\5\u00a0Q\2\u0376\u0377\7K\2\2\u0377\u0379\3"+
		"\2\2\2\u0378\u0374\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037f\3\2\2\2\u037a"+
		"\u037b\7J\2\2\u037b\u037c\5\u00a0Q\2\u037c\u037d\7K\2\2\u037d\u037f\3"+
		"\2\2\2\u037e\u0373\3\2\2\2\u037e\u037a\3\2\2\2\u037f\u0395\3\2\2\2\u0380"+
		"\u0381\7D\2\2\u0381\u0382\7H\2\2\u0382\u0383\5\u00b2Z\2\u0383\u0384\7"+
		"O\2\2\u0384\u0385\5\u00f8}\2\u0385\u0386\7I\2\2\u0386\u0387\7J\2\2\u0387"+
		"\u0388\5\u00a0Q\2\u0388\u0389\7K\2\2\u0389\u0395\3\2\2\2\u038a\u038b\7"+
		"E\2\2\u038b\u038c\7H\2\2\u038c\u038d\5\u00b2Z\2\u038d\u038e\7O\2\2\u038e"+
		"\u038f\5\u00f8}\2\u038f\u0390\7I\2\2\u0390\u0391\7J\2\2\u0391\u0392\5"+
		"\u00a0Q\2\u0392\u0393\7K\2\2\u0393\u0395\3\2\2\2\u0394\u036b\3\2\2\2\u0394"+
		"\u0380\3\2\2\2\u0394\u038a\3\2\2\2\u0395\u009f\3\2\2\2\u0396\u039b\5\u00a2"+
		"R\2\u0397\u0398\7O\2\2\u0398\u039a\5\u00a2R\2\u0399\u0397\3\2\2\2\u039a"+
		"\u039d\3\2\2\2\u039b\u0399\3\2\2\2\u039b\u039c\3\2\2\2\u039c\u039f\3\2"+
		"\2\2\u039d\u039b\3\2\2\2\u039e\u03a0\7O\2\2\u039f\u039e\3\2\2\2\u039f"+
		"\u03a0\3\2\2\2\u03a0\u00a1\3\2\2\2\u03a1\u03a4\5\u00f8}\2\u03a2\u03a3"+
		"\7S\2\2\u03a3\u03a5\5\u00d8m\2\u03a4\u03a2\3\2\2\2\u03a4\u03a5\3\2\2\2"+
		"\u03a5\u00a3\3\2\2\2\u03a6\u03a8\7d\2\2\u03a7\u03a9\5\u008aF\2\u03a8\u03a7"+
		"\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03b0\3\2\2\2\u03aa\u03ac\7d\2\2\u03ab"+
		"\u03ad\5\u008aF\2\u03ac\u03ab\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ae"+
		"\3\2\2\2\u03ae\u03b0\5\u00a4S\2\u03af\u03a6\3\2\2\2\u03af\u03aa\3\2\2"+
		"\2\u03b0\u00a5\3\2\2\2\u03b1\u03b3\5\u00a4S\2\u03b2\u03b1\3\2\2\2\u03b2"+
		"\u03b3\3\2\2\2\u03b3\u03b4\3\2\2\2\u03b4\u03b5\5\u00a8U\2\u03b5\u00a7"+
		"\3\2\2\2\u03b6\u03ba\5\u00f8}\2\u03b7\u03b9\5\u00aaV\2\u03b8\u03b7\3\2"+
		"\2\2\u03b9\u03bc\3\2\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb"+
		"\u03ce\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bd\u03be\7H\2\2\u03be\u03bf\5\u00a6"+
		"T\2\u03bf\u03c3\7I\2\2\u03c0\u03c2\5\u00aaV\2\u03c1\u03c0\3\2\2\2\u03c2"+
		"\u03c5\3\2\2\2\u03c3\u03c1\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03ce\3\2"+
		"\2\2\u03c5\u03c3\3\2\2\2\u03c6\u03c7\7H\2\2\u03c7\u03c9\7h\2\2\u03c8\u03ca"+
		"\5\u00f8}\2\u03c9\u03c8\3\2\2\2\u03c9\u03ca\3\2\2\2\u03ca\u03cb\3\2\2"+
		"\2\u03cb\u03cc\7I\2\2\u03cc\u03ce\5b\62\2\u03cd\u03b6\3\2\2\2\u03cd\u03bd"+
		"\3\2\2\2\u03cd\u03c6\3\2\2\2\u03ce\u00a9\3\2\2\2\u03cf\u03d1\7L\2\2\u03d0"+
		"\u03d2\5\u00d8m\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3\2\2\2\u03d2\u03d3"+
		"\3\2\2\2\u03d3\u03da\7M\2\2\u03d4\u03d6\7H\2\2\u03d5\u03d7\5\u00acW\2"+
		"\u03d6\u03d5\3\2\2\2\u03d6\u03d7\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03da"+
		"\7I\2\2\u03d9\u03cf\3\2\2\2\u03d9\u03d4\3\2\2\2\u03da\u00ab\3\2\2\2\u03db"+
		"\u03de\5\u00b8]\2\u03dc\u03dd\7O\2\2\u03dd\u03df\7v\2\2\u03de\u03dc\3"+
		"\2\2\2\u03de\u03df\3\2\2\2\u03df\u00ad\3\2\2\2\u03e0\u03e5\5\u008aF\2"+
		"\u03e1\u03e3\5\u00a6T\2\u03e2\u03e1\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3"+
		"\u03e6\3\2\2\2\u03e4\u03e6\5\u00b4[\2\u03e5\u03e2\3\2\2\2\u03e5\u03e4"+
		"\3\2\2\2\u03e6\u00af\3\2\2\2\u03e7\u03f7\5\u00d2j\2\u03e8\u03e9\7J\2\2"+
		"\u03e9\u03ee\5\u00b0Y\2\u03ea\u03eb\7O\2\2\u03eb\u03ed\5\u00b0Y\2\u03ec"+
		"\u03ea\3\2\2\2\u03ed\u03f0\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef\3\2"+
		"\2\2\u03ef\u03f2\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f1\u03f3\7O\2\2\u03f2"+
		"\u03f1\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f5\7K"+
		"\2\2\u03f5\u03f7\3\2\2\2\u03f6\u03e7\3\2\2\2\u03f6\u03e8\3\2\2\2\u03f7"+
		"\u00b1\3\2\2\2\u03f8\u03f9\5\u0098M\2\u03f9\u03fa\5\u00b4[\2\u03fa\u03fd"+
		"\3\2\2\2\u03fb\u03fd\5P)\2\u03fc\u03f8\3\2\2\2\u03fc\u03fb\3\2\2\2\u03fd"+
		"\u00b3\3\2\2\2\u03fe\u03ff\5\u00a4S\2\u03ff\u0400\5\u00b4[\2\u0400\u0414"+
		"\3\2\2\2\u0401\u0402\7H\2\2\u0402\u0403\5\u00b4[\2\u0403\u0405\7I\2\2"+
		"\u0404\u0406\5\u00b6\\\2\u0405\u0404\3\2\2\2\u0406\u0407\3\2\2\2\u0407"+
		"\u0405\3\2\2\2\u0407\u0408\3\2\2\2\u0408\u0414\3\2\2\2\u0409\u040b\7L"+
		"\2\2\u040a\u040c\5\u00d8m\2\u040b\u040a\3\2\2\2\u040b\u040c\3\2\2\2\u040c"+
		"\u040d\3\2\2\2\u040d\u040f\7M\2\2\u040e\u0409\3\2\2\2\u040f\u0410\3\2"+
		"\2\2\u0410\u040e\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0414\3\2\2\2\u0412"+
		"\u0414\3\2\2\2\u0413\u03fe\3\2\2\2\u0413\u0401\3\2\2\2\u0413\u040e\3\2"+
		"\2\2\u0413\u0412\3\2\2\2\u0414\u00b5\3\2\2\2\u0415\u0417\7L\2\2\u0416"+
		"\u0418\5\u00d8m\2\u0417\u0416\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u0419"+
		"\3\2\2\2\u0419\u0420\7M\2\2\u041a\u041c\7H\2\2\u041b\u041d\5\u00b8]\2"+
		"\u041c\u041b\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0420"+
		"\7I\2\2\u041f\u0415\3\2\2\2\u041f\u041a\3\2\2\2\u0420\u00b7\3\2\2\2\u0421"+
		"\u0426\5\u00aeX\2\u0422\u0423\7O\2\2\u0423\u0425\5\u00aeX\2\u0424\u0422"+
		"\3\2\2\2\u0425\u0428\3\2\2\2\u0426\u0424\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u00b9\3\2\2\2\u0428\u0426\3\2\2\2\u0429\u042b\5\u00bc_\2\u042a\u0429"+
		"\3\2\2\2\u042b\u042c\3\2\2\2\u042c\u042a\3\2\2\2\u042c\u042d\3\2\2\2\u042d"+
		"\u00bb\3\2\2\2\u042e\u043b\5\u00be`\2\u042f\u0430\5\u00d0i\2\u0430\u0431"+
		"\7N\2\2\u0431\u043b\3\2\2\2\u0432\u043b\5\u00c0a\2\u0433\u043b\5\u00c2"+
		"b\2\u0434\u043b\5\u00ccg\2\u0435\u043b\5\u00ceh\2\u0436\u043b\5\u0082"+
		"B\2\u0437\u043b\5\u0084C\2\u0438\u043b\5\u0080A\2\u0439\u043b\7N\2\2\u043a"+
		"\u042e\3\2\2\2\u043a\u042f\3\2\2\2\u043a\u0432\3\2\2\2\u043a\u0433\3\2"+
		"\2\2\u043a\u0434\3\2\2\2\u043a\u0435\3\2\2\2\u043a\u0436\3\2\2\2\u043a"+
		"\u0437\3\2\2\2\u043a\u0438\3\2\2\2\u043a\u0439\3\2\2\2\u043b\u00bd\3\2"+
		"\2\2\u043c\u043d\5\u00f8}\2\u043d\u043e\7Y\2\2\u043e\u043f\5\u00bc_\2"+
		"\u043f\u0449\3\2\2\2\u0440\u0441\7!\2\2\u0441\u0442\5\u00d8m\2\u0442\u0443"+
		"\7Y\2\2\u0443\u0444\5\u00bc_\2\u0444\u0449\3\2\2\2\u0445\u0446\7%\2\2"+
		"\u0446\u0447\7Y\2\2\u0447\u0449\5\u00bc_\2\u0448\u043c\3\2\2\2\u0448\u0440"+
		"\3\2\2\2\u0448\u0445\3\2\2\2\u0449\u00bf\3\2\2\2\u044a\u044f\7J\2\2\u044b"+
		"\u044e\5\u0088E\2\u044c\u044e\5\u00ba^\2\u044d\u044b\3\2\2\2\u044d\u044c"+
		"\3\2\2\2\u044e\u0451\3\2\2\2\u044f\u044d\3\2\2\2\u044f\u0450\3\2\2\2\u0450"+
		"\u0452\3\2\2\2\u0451\u044f\3\2\2\2\u0452\u0453\7K\2\2\u0453\u00c1\3\2"+
		"\2\2\u0454\u0455\7.\2\2\u0455\u0456\7H\2\2\u0456\u0457\5\u00d0i\2\u0457"+
		"\u0458\7I\2\2\u0458\u045b\5\u00bc_\2\u0459\u045a\7(\2\2\u045a\u045c\5"+
		"\u00bc_\2\u045b\u0459\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u0464\3\2\2\2"+
		"\u045d\u045e\7=\2\2\u045e\u045f\7H\2\2\u045f\u0460\5\u00d0i\2\u0460\u0461"+
		"\7I\2\2\u0461\u0462\5\u00bc_\2\u0462\u0464\3\2\2\2\u0463\u0454\3\2\2\2"+
		"\u0463\u045d\3\2\2\2\u0464\u00c3\3\2\2\2\u0465\u0466\7,\2\2\u0466\u0467"+
		"\7H\2\2\u0467\u0468\5v<\2\u0468\u046a\7/\2\2\u0469\u046b\5\u00d0i\2\u046a"+
		"\u0469\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046d\7I"+
		"\2\2\u046d\u046e\5\u00bc_\2\u046e\u00c5\3\2\2\2\u046f\u0470\7,\2\2\u0470"+
		"\u0475\7H\2\2\u0471\u0472\5\u008aF\2\u0472\u0473\5\u0090I\2\u0473\u0476"+
		"\3\2\2\2\u0474\u0476\5\u00d0i\2\u0475\u0471\3\2\2\2\u0475\u0474\3\2\2"+
		"\2\u0475\u0476\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0479\7N\2\2\u0478\u047a"+
		"\5\u00d0i\2\u0479\u0478\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u047b\3\2\2"+
		"\2\u047b\u047d\7N\2\2\u047c\u047e\5\u00d0i\2\u047d\u047c\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u047f\3\2\2\2\u047f\u0480\7I\2\2\u0480\u0481\5\u00bc"+
		"_\2\u0481\u00c7\3\2\2\2\u0482\u0483\7C\2\2\u0483\u0484\7H\2\2\u0484\u0485"+
		"\5\u00d0i\2\u0485\u0486\7I\2\2\u0486\u0487\5\u00bc_\2\u0487\u00c9\3\2"+
		"\2\2\u0488\u0489\7&\2\2\u0489\u048a\5\u00bc_\2\u048a\u048b\7C\2\2\u048b"+
		"\u048c\7H\2\2\u048c\u048d\5\u00d0i\2\u048d\u048e\7I\2\2\u048e\u048f\7"+
		"N\2\2\u048f\u00cb\3\2\2\2\u0490\u0495\5\u00c8e\2\u0491\u0495\5\u00caf"+
		"\2\u0492\u0495\5\u00c6d\2\u0493\u0495\5\u00c4c\2\u0494\u0490\3\2\2\2\u0494"+
		"\u0491\3\2\2\2\u0494\u0492\3\2\2\2\u0494\u0493\3\2\2\2\u0495\u00cd\3\2"+
		"\2\2\u0496\u0497\7\61\2\2\u0497\u0498\5\u00f8}\2\u0498\u0499\7N\2\2\u0499"+
		"\u04a4\3\2\2\2\u049a\u049b\7$\2\2\u049b\u04a4\7N\2\2\u049c\u049d\7\36"+
		"\2\2\u049d\u04a4\7N\2\2\u049e\u04a0\7\67\2\2\u049f\u04a1\5\u00d0i\2\u04a0"+
		"\u049f\3\2\2\2\u04a0\u04a1\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a4\7N"+
		"\2\2\u04a3\u0496\3\2\2\2\u04a3\u049a\3\2\2\2\u04a3\u049c\3\2\2\2\u04a3"+
		"\u049e\3\2\2\2\u04a4\u00cf\3\2\2\2\u04a5\u04aa\5\u00d2j\2\u04a6\u04a7"+
		"\7O\2\2\u04a7\u04a9\5\u00d2j\2\u04a8\u04a6\3\2\2\2\u04a9\u04ac\3\2\2\2"+
		"\u04aa\u04a8\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab\u00d1\3\2\2\2\u04ac\u04aa"+
		"\3\2\2\2\u04ad\u04b3\5\u00d6l\2\u04ae\u04af\5\u00f0y\2\u04af\u04b0\5\u00d4"+
		"k\2\u04b0\u04b1\5\u00d2j\2\u04b1\u04b3\3\2\2\2\u04b2\u04ad\3\2\2\2\u04b2"+
		"\u04ae\3\2\2\2\u04b3\u00d3\3\2\2\2\u04b4\u04b5\t\b\2\2\u04b5\u00d5\3\2"+
		"\2\2\u04b6\u04bd\5\u00dan\2\u04b7\u04b9\7X\2\2\u04b8\u04ba\5\u00d6l\2"+
		"\u04b9\u04b8\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc"+
		"\7Y\2\2\u04bc\u04be\5\u00d6l\2\u04bd\u04b7\3\2\2\2\u04bd\u04be\3\2\2\2"+
		"\u04be\u00d7\3\2\2\2\u04bf\u04c0\5\u00d6l\2\u04c0\u00d9\3\2\2\2\u04c1"+
		"\u04c6\5\u00dco\2\u04c2\u04c3\7_\2\2\u04c3\u04c5\5\u00dco\2\u04c4\u04c2"+
		"\3\2\2\2\u04c5\u04c8\3\2\2\2\u04c6\u04c4\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7"+
		"\u00db\3\2\2\2\u04c8\u04c6\3\2\2\2\u04c9\u04ce\5\u00dep\2\u04ca\u04cb"+
		"\7^\2\2\u04cb\u04cd\5\u00dep\2\u04cc\u04ca\3\2\2\2\u04cd\u04d0\3\2\2\2"+
		"\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u00dd\3\2\2\2\u04d0\u04ce"+
		"\3\2\2\2\u04d1\u04d6\5\u00e0q\2\u04d2\u04d3\7g\2\2\u04d3\u04d5\5\u00e0"+
		"q\2\u04d4\u04d2\3\2\2\2\u04d5\u04d8\3\2\2\2\u04d6\u04d4\3\2\2\2\u04d6"+
		"\u04d7\3\2\2\2\u04d7\u00df\3\2\2\2\u04d8\u04d6\3\2\2\2\u04d9\u04de\5\u00e2"+
		"r\2\u04da\u04db\7h\2\2\u04db\u04dd\5\u00e2r\2\u04dc\u04da\3\2\2\2\u04dd"+
		"\u04e0\3\2\2\2\u04de\u04dc\3\2\2\2\u04de\u04df\3\2\2\2\u04df\u00e1\3\2"+
		"\2\2\u04e0\u04de\3\2\2\2\u04e1\u04e6\5\u00e4s\2\u04e2\u04e3\7f\2\2\u04e3"+
		"\u04e5\5\u00e4s\2\u04e4\u04e2\3\2\2\2\u04e5\u04e8\3\2\2\2\u04e6\u04e4"+
		"\3\2\2\2\u04e6\u04e7\3\2\2\2\u04e7\u00e3\3\2\2\2\u04e8\u04e6\3\2\2\2\u04e9"+
		"\u04ee\5\u00e6t\2\u04ea\u04eb\t\t\2\2\u04eb\u04ed\5\u00e6t\2\u04ec\u04ea"+
		"\3\2\2\2\u04ed\u04f0\3\2\2\2\u04ee\u04ec\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef"+
		"\u00e5\3\2\2\2\u04f0\u04ee\3\2\2\2\u04f1\u04f6\5\u00e8u\2\u04f2\u04f3"+
		"\t\n\2\2\u04f3\u04f5\5\u00e8u\2\u04f4\u04f2\3\2\2\2\u04f5\u04f8\3\2\2"+
		"\2\u04f6\u04f4\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u00e7\3\2\2\2\u04f8\u04f6"+
		"\3\2\2\2\u04f9\u04fe\5\u00eav\2\u04fa\u04fb\t\13\2\2\u04fb\u04fd\5\u00ea"+
		"v\2\u04fc\u04fa\3\2\2\2\u04fd\u0500\3\2\2\2\u04fe\u04fc\3\2\2\2\u04fe"+
		"\u04ff\3\2\2\2\u04ff\u00e9\3\2\2\2\u0500\u04fe\3\2\2\2\u0501\u0506\5\u00ec"+
		"w\2\u0502\u0503\t\f\2\2\u0503\u0505\5\u00ecw\2\u0504\u0502\3\2\2\2\u0505"+
		"\u0508\3\2\2\2\u0506\u0504\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u00eb\3\2"+
		"\2\2\u0508\u0506\3\2\2\2\u0509\u050e\5\u00eex\2\u050a\u050b\t\r\2\2\u050b"+
		"\u050d\5\u00eex\2\u050c\u050a\3\2\2\2\u050d\u0510\3\2\2\2\u050e\u050c"+
		"\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u00ed\3\2\2\2\u0510\u050e\3\2\2\2\u0511"+
		"\u0512\7H\2\2\u0512\u0513\5\u00b2Z\2\u0513\u0514\7I\2\2\u0514\u0515\5"+
		"\u00eex\2\u0515\u0518\3\2\2\2\u0516\u0518\5\u00f0y\2\u0517\u0511\3\2\2"+
		"\2\u0517\u0516\3\2\2\2\u0518\u00ef\3\2\2\2\u0519\u052a\5\u00f4{\2\u051a"+
		"\u051b\7`\2\2\u051b\u052a\5\u00f0y\2\u051c\u051d\7a\2\2\u051d\u052a\5"+
		"\u00f0y\2\u051e\u051f\5\u00f2z\2\u051f\u0520\5\u00eex\2\u0520\u052a\3"+
		"\2\2\2\u0521\u0527\7:\2\2\u0522\u0523\7H\2\2\u0523\u0524\5\u00b2Z\2\u0524"+
		"\u0525\7I\2\2\u0525\u0528\3\2\2\2\u0526\u0528\5\u00f0y\2\u0527\u0522\3"+
		"\2\2\2\u0527\u0526\3\2\2\2\u0528\u052a\3\2\2\2\u0529\u0519\3\2\2\2\u0529"+
		"\u051a\3\2\2\2\u0529\u051c\3\2\2\2\u0529\u051e\3\2\2\2\u0529\u0521\3\2"+
		"\2\2\u052a\u00f1\3\2\2\2\u052b\u052c\t\16\2\2\u052c\u00f3\3\2\2\2\u052d"+
		"\u053f\5X-\2\u052e\u052f\7L\2\2\u052f\u0530\5\u00d0i\2\u0530\u0531\7M"+
		"\2\2\u0531\u053e\3\2\2\2\u0532\u0534\7H\2\2\u0533\u0535\5\u00f6|\2\u0534"+
		"\u0533\3\2\2\2\u0534\u0535\3\2\2\2\u0535\u0536\3\2\2\2\u0536\u053e\7I"+
		"\2\2\u0537\u0538\7P\2\2\u0538\u053e\5\u00f8}\2\u0539\u053a\7Q\2\2\u053a"+
		"\u053e\5\u00f8}\2\u053b\u053e\7`\2\2\u053c\u053e\7a\2\2\u053d\u052e\3"+
		"\2\2\2\u053d\u0532\3\2\2\2\u053d\u0537\3\2\2\2\u053d\u0539\3\2\2\2\u053d"+
		"\u053b\3\2\2\2\u053d\u053c\3\2\2\2\u053e\u0541\3\2\2\2\u053f\u053d\3\2"+
		"\2\2\u053f\u0540\3\2\2\2\u0540\u00f5\3\2\2\2\u0541\u053f\3\2\2\2\u0542"+
		"\u0547\5\u00d2j\2\u0543\u0544\7O\2\2\u0544\u0546\5\u00d2j\2\u0545\u0543"+
		"\3\2\2\2\u0546\u0549\3\2\2\2\u0547\u0545\3\2\2\2\u0547\u0548\3\2\2\2\u0548"+
		"\u00f7\3\2\2\2\u0549\u0547\3\2\2\2\u054a\u054b\7\u0080\2\2\u054b\u00f9"+
		"\3\2\2\2\u054c\u054d\t\17\2\2\u054d\u00fb\3\2\2\2\u009f\u00ff\u010f\u0117"+
		"\u011a\u011d\u0120\u0128\u012c\u012f\u0132\u013a\u013d\u0140\u014a\u0151"+
		"\u0156\u0158\u016a\u0176\u017b\u017e\u018b\u019e\u01a6\u01b4\u01bd\u01c5"+
		"\u01cf\u01d4\u01dc\u01de\u01e7\u01f1\u01f3\u01fc\u0200\u0203\u020b\u020e"+
		"\u0210\u0213\u0219\u022c\u0233\u023a\u0240\u0244\u0251\u0255\u025c\u0261"+
		"\u0276\u027c\u0281\u0287\u028b\u0292\u0298\u029c\u02a4\u02aa\u02af\u02b5"+
		"\u02bc\u02bf\u02cb\u02d1\u02d3\u02d6\u02e2\u02e7\u02e9\u030d\u0311\u031d"+
		"\u0324\u032c\u032e\u0339\u033f\u0344\u034a\u034e\u0357\u0359\u0360\u0365"+
		"\u0369\u036d\u0371\u0378\u037e\u0394\u039b\u039f\u03a4\u03a8\u03ac\u03af"+
		"\u03b2\u03ba\u03c3\u03c9\u03cd\u03d1\u03d6\u03d9\u03de\u03e2\u03e5\u03ee"+
		"\u03f2\u03f6\u03fc\u0407\u040b\u0410\u0413\u0417\u041c\u041f\u0426\u042c"+
		"\u043a\u0448\u044d\u044f\u045b\u0463\u046a\u0475\u0479\u047d\u0494\u04a0"+
		"\u04a3\u04aa\u04b2\u04b9\u04bd\u04c6\u04ce\u04d6\u04de\u04e6\u04ee\u04f6"+
		"\u04fe\u0506\u050e\u0517\u0527\u0529\u0534\u053d\u053f\u0547"
	private val _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray())

	protected final val _decisionToDFA =
		(0 until _ATN.getNumberOfDecisions())
		.map{i => new DFA(_ATN.getDecisionState(i), i)}
		.toArray


}
class ObjCParser(input: TokenStream) extends Parser(input) {
    import ObjCParser._

	_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache)

	override def getGrammarFileName() = "ObjC.g4"
	override def getRuleNames() = ruleNames
	override def getSerializedATN() = _serializedATN
	override def getATN() = _ATN
	override def getVocabulary() = VOCABULARY

	@deprecated
	override def getTokenNames() = tokenNames

	@throws(classOf[RecognitionException])
	private def matchToken(ttype: Int) = `match`(ttype)



	@throws(classOf[RecognitionException])
	final def translation_unit(): Translation_unitContext = {
		val _localctx: Translation_unitContext = new Translation_unitContext(_ctx, getState())
		enterRule(_localctx, 0, RULE_translation_unit)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(251) 
			_errHandler.sync(this)
			_la = _input.LA(1)
			do {
				setState(250)
				external_declaration()
				setState(253) 
				_errHandler.sync(this)
				_la = _input.LA(1)
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << IMPLEMENTATION) | (1L << INTERFACE) | (1L << PROTOCOL) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (LPAREN - 64)) | (1L << (MUL - 64)) | (1L << (IDENTIFIER - 64)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (IMPORT - 133)) | (1L << (INCLUDE - 133)) | (1L << (COMMENT - 133)) | (1L << (LINE_COMMENT - 133)))) != 0) )
			setState(255)
			matchToken(EOF)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def external_declaration(): External_declarationContext = {
		val _localctx: External_declarationContext = new External_declarationContext(_ctx, getState())
		enterRule(_localctx, 2, RULE_external_declaration)
		try {
			setState(269)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,1,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(257)
				matchToken(COMMENT)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(258)
				matchToken(LINE_COMMENT)

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(259)
				preprocessor_declaration()

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(260)
				function_definition()

			case 5 =>
				enterOuterAlt(_localctx, 5)
				setState(261)
				declaration()

			case 6 =>
				enterOuterAlt(_localctx, 6)
				setState(262)
				class_interface()

			case 7 =>
				enterOuterAlt(_localctx, 7)
				setState(263)
				class_implementation()

			case 8 =>
				enterOuterAlt(_localctx, 8)
				setState(264)
				category_interface()

			case 9 =>
				enterOuterAlt(_localctx, 9)
				setState(265)
				category_implementation()

			case 10 =>
				enterOuterAlt(_localctx, 10)
				setState(266)
				protocol_declaration()

			case 11 =>
				enterOuterAlt(_localctx, 11)
				setState(267)
				protocol_declaration_list()

			case 12 =>
				enterOuterAlt(_localctx, 12)
				setState(268)
				class_declaration_list()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def preprocessor_declaration(): Preprocessor_declarationContext = {
		val _localctx: Preprocessor_declarationContext = new Preprocessor_declarationContext(_ctx, getState())
		enterRule(_localctx, 4, RULE_preprocessor_declaration)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(271)
			_la = _input.LA(1)
			if ( !(_la==IMPORT || _la==INCLUDE) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_interface(): Class_interfaceContext = {
		val _localctx: Class_interfaceContext = new Class_interfaceContext(_ctx, getState())
		enterRule(_localctx, 6, RULE_class_interface)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(273)
			matchToken(INTERFACE)
			setState(274)
			class_name()
			setState(277)
			_la = _input.LA(1)
			if (_la==COLON) {
				setState(275)
				matchToken(COLON)
				setState(276)
				superclass_name()
			}

			setState(280)
			_la = _input.LA(1)
			if (_la==LT) {
				setState(279)
				protocol_reference_list()
			}

			setState(283)
			_la = _input.LA(1)
			if (_la==LBRACE) {
				setState(282)
				instance_variables()
			}

			setState(286)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROPERTY) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				setState(285)
				interface_declaration_list()
			}

			setState(288)
			matchToken(END)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def category_interface(): Category_interfaceContext = {
		val _localctx: Category_interfaceContext = new Category_interfaceContext(_ctx, getState())
		enterRule(_localctx, 8, RULE_category_interface)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(290)
			matchToken(INTERFACE)
			setState(291)
			class_name()
			setState(292)
			matchToken(LPAREN)
			setState(294)
			_la = _input.LA(1)
			if (_la==IDENTIFIER) {
				setState(293)
				category_name()
			}

			setState(296)
			matchToken(RPAREN)
			setState(298)
			_la = _input.LA(1)
			if (_la==LT) {
				setState(297)
				protocol_reference_list()
			}

			setState(301)
			_la = _input.LA(1)
			if (_la==LBRACE) {
				setState(300)
				instance_variables()
			}

			setState(304)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROPERTY) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				setState(303)
				interface_declaration_list()
			}

			setState(306)
			matchToken(END)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_implementation(): Class_implementationContext = {
		val _localctx: Class_implementationContext = new Class_implementationContext(_ctx, getState())
		enterRule(_localctx, 10, RULE_class_implementation)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(308)
			matchToken(IMPLEMENTATION)

			setState(309)
			class_name()
			setState(312)
			_la = _input.LA(1)
			if (_la==COLON) {
				setState(310)
				matchToken(COLON)
				setState(311)
				superclass_name()
			}

			setState(315)
			_la = _input.LA(1)
			if (_la==LBRACE) {
				setState(314)
				instance_variables()
			}

			setState(318)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << SYNTHESIZE) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (LPAREN - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (MUL - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				setState(317)
				implementation_definition_list()
			}

			setState(320)
			matchToken(END)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def category_implementation(): Category_implementationContext = {
		val _localctx: Category_implementationContext = new Category_implementationContext(_ctx, getState())
		enterRule(_localctx, 12, RULE_category_implementation)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(322)
			matchToken(IMPLEMENTATION)

			setState(323)
			class_name()
			setState(324)
			matchToken(LPAREN)
			setState(325)
			category_name()
			setState(326)
			matchToken(RPAREN)
			setState(328)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << SYNTHESIZE) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (LPAREN - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (MUL - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				setState(327)
				implementation_definition_list()
			}

			setState(330)
			matchToken(END)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_declaration(): Protocol_declarationContext = {
		val _localctx: Protocol_declarationContext = new Protocol_declarationContext(_ctx, getState())
		enterRule(_localctx, 14, RULE_protocol_declaration)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(332)
			matchToken(PROTOCOL)

			setState(333)
			protocol_name()
			setState(335)
			_la = _input.LA(1)
			if (_la==LT) {
				setState(334)
				protocol_reference_list()
			}

			setState(342)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << OPTIONAL) | (1L << PROPERTY) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
				setState(340)
				(_input.LA(1)) match {
				case PROPERTY =>
				case AUTO =>
				case BYCOPY =>
				case BYREF =>
				case CHAR =>
				case CONST =>
				case DOUBLE =>
				case ENUM =>
				case EXTERN =>
				case FLOAT =>
				case ID =>
				case IN =>
				case INOUT =>
				case INT =>
				case LONG =>
				case ONEWAY =>
				case OUT =>
				case REGISTER =>
				case SHORT =>
				case SIGNED =>
				case STATIC =>
				case STRUCT =>
				case TYPEDEF =>
				case UNION =>
				case UNSIGNED =>
				case VOID =>
				case VOLATILE =>
				case NS_OPTIONS =>
				case NS_ENUM =>
				case WWEAK =>
				case WUNSAFE_UNRETAINED =>
				case ADD =>
				case SUB =>
				case IDENTIFIER =>
					setState(337)
					interface_declaration_list()

				case OPTIONAL =>
					setState(338)
					matchToken(OPTIONAL)

				case T__0 =>
					setState(339)
					matchToken(T__0)

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(344)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
			setState(345)
			matchToken(END)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_declaration_list(): Protocol_declaration_listContext = {
		val _localctx: Protocol_declaration_listContext = new Protocol_declaration_listContext(_ctx, getState())
		enterRule(_localctx, 16, RULE_protocol_declaration_list)
		try {
			enterOuterAlt(_localctx, 1)
			setState(347)
			matchToken(PROTOCOL)
			setState(348)
			protocol_list()
			setState(349)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_declaration_list(): Class_declaration_listContext = {
		val _localctx: Class_declaration_listContext = new Class_declaration_listContext(_ctx, getState())
		enterRule(_localctx, 18, RULE_class_declaration_list)
		try {
			enterOuterAlt(_localctx, 1)
			setState(351)
			matchToken(CLASS)
			setState(352)
			class_list()
			setState(353)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_list(): Class_listContext = {
		val _localctx: Class_listContext = new Class_listContext(_ctx, getState())
		enterRule(_localctx, 20, RULE_class_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(355)
			class_name()
			setState(360)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(356)
				matchToken(COMMA)
				setState(357)
				class_name()
				setState(362)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_reference_list(): Protocol_reference_listContext = {
		val _localctx: Protocol_reference_listContext = new Protocol_reference_listContext(_ctx, getState())
		enterRule(_localctx, 22, RULE_protocol_reference_list)
		try {
			enterOuterAlt(_localctx, 1)
			setState(363)
			matchToken(LT)
			setState(364)
			protocol_list()
			setState(365)
			matchToken(GT)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_list(): Protocol_listContext = {
		val _localctx: Protocol_listContext = new Protocol_listContext(_ctx, getState())
		enterRule(_localctx, 24, RULE_protocol_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(367)
			protocol_name()
			setState(372)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(368)
				matchToken(COMMA)
				setState(369)
				protocol_name()
				setState(374)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_declaration(): Property_declarationContext = {
		val _localctx: Property_declarationContext = new Property_declarationContext(_ctx, getState())
		enterRule(_localctx, 26, RULE_property_declaration)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(375)
			matchToken(PROPERTY)
			setState(377)
			_la = _input.LA(1)
			if (_la==LPAREN) {
				setState(376)
				property_attributes_declaration()
			}

			setState(380)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,20,_ctx) ) match {
			case 1 =>
				setState(379)
				ib_outlet_specifier()

			}
			setState(382)
			struct_declaration()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_attributes_declaration(): Property_attributes_declarationContext = {
		val _localctx: Property_attributes_declarationContext = new Property_attributes_declarationContext(_ctx, getState())
		enterRule(_localctx, 28, RULE_property_attributes_declaration)
		try {
			enterOuterAlt(_localctx, 1)
			setState(384)
			matchToken(LPAREN)
			setState(385)
			property_attributes_list()
			setState(386)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_attributes_list(): Property_attributes_listContext = {
		val _localctx: Property_attributes_listContext = new Property_attributes_listContext(_ctx, getState())
		enterRule(_localctx, 30, RULE_property_attributes_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(388)
			property_attribute()
			setState(393)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(389)
				matchToken(COMMA)
				setState(390)
				property_attribute()
				setState(395)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_attribute(): Property_attributeContext = {
		val _localctx: Property_attributeContext = new Property_attributeContext(_ctx, getState())
		enterRule(_localctx, 32, RULE_property_attribute)
		try {
			setState(412)
			(_input.LA(1)) match {
			case NONATOMIC =>
				enterOuterAlt(_localctx, 1)
				setState(396)
				matchToken(NONATOMIC)

			case ASSIGNPA =>
				enterOuterAlt(_localctx, 2)
				setState(397)
				matchToken(ASSIGNPA)

			case WEAK =>
				enterOuterAlt(_localctx, 3)
				setState(398)
				matchToken(WEAK)

			case STRONG =>
				enterOuterAlt(_localctx, 4)
				setState(399)
				matchToken(STRONG)

			case RETAIN =>
				enterOuterAlt(_localctx, 5)
				setState(400)
				matchToken(RETAIN)

			case READONLY =>
				enterOuterAlt(_localctx, 6)
				setState(401)
				matchToken(READONLY)

			case READWRITE =>
				enterOuterAlt(_localctx, 7)
				setState(402)
				matchToken(READWRITE)

			case RPAREN =>
			case COMMA =>
				enterOuterAlt(_localctx, 8)


			case GETTER =>
				enterOuterAlt(_localctx, 9)
				setState(404)
				matchToken(GETTER)
				setState(405)
				matchToken(ASSIGN)
				setState(406)
				matchToken(IDENTIFIER)

			case SETTER =>
				enterOuterAlt(_localctx, 10)
				setState(407)
				matchToken(SETTER)
				setState(408)
				matchToken(ASSIGN)
				setState(409)
				matchToken(IDENTIFIER)
				setState(410)
				matchToken(COLON)

			case IDENTIFIER =>
				enterOuterAlt(_localctx, 11)
				setState(411)
				matchToken(IDENTIFIER)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def ib_outlet_specifier(): Ib_outlet_specifierContext = {
		val _localctx: Ib_outlet_specifierContext = new Ib_outlet_specifierContext(_ctx, getState())
		enterRule(_localctx, 34, RULE_ib_outlet_specifier)
		try {
			setState(420)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,23,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(414)
				matchToken(IDENTIFIER)
				setState(415)
				matchToken(LPAREN)
				setState(416)
				class_name()
				setState(417)
				matchToken(RPAREN)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(419)
				matchToken(IDENTIFIER)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_name(): Class_nameContext = {
		val _localctx: Class_nameContext = new Class_nameContext(_ctx, getState())
		enterRule(_localctx, 36, RULE_class_name)
		try {
			enterOuterAlt(_localctx, 1)
			setState(422)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def superclass_name(): Superclass_nameContext = {
		val _localctx: Superclass_nameContext = new Superclass_nameContext(_ctx, getState())
		enterRule(_localctx, 38, RULE_superclass_name)
		try {
			enterOuterAlt(_localctx, 1)
			setState(424)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def category_name(): Category_nameContext = {
		val _localctx: Category_nameContext = new Category_nameContext(_ctx, getState())
		enterRule(_localctx, 40, RULE_category_name)
		try {
			enterOuterAlt(_localctx, 1)
			setState(426)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_name(): Protocol_nameContext = {
		val _localctx: Protocol_nameContext = new Protocol_nameContext(_ctx, getState())
		enterRule(_localctx, 42, RULE_protocol_name)
		try {
			enterOuterAlt(_localctx, 1)
			setState(428)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def instance_variables(): Instance_variablesContext = {
		val _localctx: Instance_variablesContext = new Instance_variablesContext(_ctx, getState())
		enterRule(_localctx, 44, RULE_instance_variables)
		var _la = 0
		try {
			setState(466)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,28,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(430)
				matchToken(LBRACE)
				setState(434)
				_errHandler.sync(this)
				_la = _input.LA(1)
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					setState(431)
					struct_declaration()
					setState(436)
					_errHandler.sync(this)
					_la = _input.LA(1)
				}
				setState(437)
				matchToken(RBRACE)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(438)
				matchToken(LBRACE)
				setState(439)
				visibility_specification()
				setState(441) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(440)
					struct_declaration()
					setState(443) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0) )
				setState(445)
				matchToken(RBRACE)

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(447)
				matchToken(LBRACE)
				setState(449) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(448)
					struct_declaration()
					setState(451) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0) )
				setState(453)
				instance_variables()
				setState(454)
				matchToken(RBRACE)

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(456)
				matchToken(LBRACE)
				setState(457)
				visibility_specification()
				setState(459) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(458)
					struct_declaration()
					setState(461) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0) )
				setState(463)
				instance_variables()
				setState(464)
				matchToken(RBRACE)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def visibility_specification(): Visibility_specificationContext = {
		val _localctx: Visibility_specificationContext = new Visibility_specificationContext(_ctx, getState())
		enterRule(_localctx, 46, RULE_visibility_specification)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(468)
			_la = _input.LA(1)
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PACKAGE) | (1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def interface_declaration_list(): Interface_declaration_listContext = {
		val _localctx: Interface_declaration_listContext = new Interface_declaration_listContext(_ctx, getState())
		enterRule(_localctx, 48, RULE_interface_declaration_list)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(474) 
			_errHandler.sync(this)
			_alt = 1
			do {
				(_alt) match {
				case 1 =>
					setState(474)
					(_input.LA(1)) match {
					case AUTO =>
					case BYCOPY =>
					case BYREF =>
					case CHAR =>
					case CONST =>
					case DOUBLE =>
					case ENUM =>
					case EXTERN =>
					case FLOAT =>
					case ID =>
					case IN =>
					case INOUT =>
					case INT =>
					case LONG =>
					case ONEWAY =>
					case OUT =>
					case REGISTER =>
					case SHORT =>
					case SIGNED =>
					case STATIC =>
					case STRUCT =>
					case TYPEDEF =>
					case UNION =>
					case UNSIGNED =>
					case VOID =>
					case VOLATILE =>
					case NS_OPTIONS =>
					case NS_ENUM =>
					case WWEAK =>
					case WUNSAFE_UNRETAINED =>
					case IDENTIFIER =>
						setState(470)
						declaration()

					case ADD =>
						setState(471)
						class_method_declaration()

					case SUB =>
						setState(472)
						instance_method_declaration()

					case PROPERTY =>
						setState(473)
						property_declaration()

					case _ =>
						throw new NoViableAltException(this)
					}

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(476) 
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx)
			} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_method_declaration(): Class_method_declarationContext = {
		val _localctx: Class_method_declarationContext = new Class_method_declarationContext(_ctx, getState())
		enterRule(_localctx, 50, RULE_class_method_declaration)
		try {
			enterOuterAlt(_localctx, 1)
			setState(478)
			matchToken(ADD)
			setState(479)
			method_declaration()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def instance_method_declaration(): Instance_method_declarationContext = {
		val _localctx: Instance_method_declarationContext = new Instance_method_declarationContext(_ctx, getState())
		enterRule(_localctx, 52, RULE_instance_method_declaration)
		try {
			enterOuterAlt(_localctx, 1)
			setState(481)
			matchToken(SUB)
			setState(482)
			method_declaration()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def method_declaration(): Method_declarationContext = {
		val _localctx: Method_declarationContext = new Method_declarationContext(_ctx, getState())
		enterRule(_localctx, 54, RULE_method_declaration)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(485)
			_la = _input.LA(1)
			if (_la==LPAREN) {
				setState(484)
				method_type()
			}

			setState(487)
			method_selector()
			setState(488)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def implementation_definition_list(): Implementation_definition_listContext = {
		val _localctx: Implementation_definition_listContext = new Implementation_definition_listContext(_ctx, getState())
		enterRule(_localctx, 56, RULE_implementation_definition_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(495) 
			_errHandler.sync(this)
			_la = _input.LA(1)
			do {
				setState(495)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,32,_ctx) ) match {
				case 1 =>
					setState(490)
					function_definition()

				case 2 =>
					setState(491)
					declaration()

				case 3 =>
					setState(492)
					class_method_definition()

				case 4 =>
					setState(493)
					instance_method_definition()

				case 5 =>
					setState(494)
					property_implementation()

				}
				setState(497) 
				_errHandler.sync(this)
				_la = _input.LA(1)
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DYNAMIC) | (1L << SYNTHESIZE) | (1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (LPAREN - 64)) | (1L << (ADD - 64)) | (1L << (SUB - 64)) | (1L << (MUL - 64)) | (1L << (IDENTIFIER - 64)))) != 0) )
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def class_method_definition(): Class_method_definitionContext = {
		val _localctx: Class_method_definitionContext = new Class_method_definitionContext(_ctx, getState())
		enterRule(_localctx, 58, RULE_class_method_definition)
		try {
			enterOuterAlt(_localctx, 1)
			setState(499)
			matchToken(ADD)
			setState(500)
			method_definition()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def instance_method_definition(): Instance_method_definitionContext = {
		val _localctx: Instance_method_definitionContext = new Instance_method_definitionContext(_ctx, getState())
		enterRule(_localctx, 60, RULE_instance_method_definition)
		try {
			enterOuterAlt(_localctx, 1)
			setState(502)
			matchToken(SUB)
			setState(503)
			method_definition()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def method_definition(): Method_definitionContext = {
		val _localctx: Method_definitionContext = new Method_definitionContext(_ctx, getState())
		enterRule(_localctx, 62, RULE_method_definition)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(506)
			_la = _input.LA(1)
			if (_la==LPAREN) {
				setState(505)
				method_type()
			}

			setState(508)
			method_selector()
			setState(510)
			_la = _input.LA(1)
			if (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (MUL - 70)) | (1L << (IDENTIFIER - 70)))) != 0)) {
				setState(509)
				init_declarator_list()
			}

			setState(513)
			_la = _input.LA(1)
			if (_la==SEMI) {
				setState(512)
				matchToken(SEMI)
			}

			setState(515)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def method_selector(): Method_selectorContext = {
		val _localctx: Method_selectorContext = new Method_selectorContext(_ctx, getState())
		enterRule(_localctx, 64, RULE_method_selector)
		try {
			var _alt = 0
			setState(526)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,39,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(517)
				selector()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(519) 
				_errHandler.sync(this)
				_alt = 1
				do {
					(_alt) match {
					case 1 =>
						setState(518)
						keyword_declarator()

					case _ =>
						throw new NoViableAltException(this)
					}
					setState(521) 
					_errHandler.sync(this)
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx)
				} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )
				setState(524)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,38,_ctx) ) match {
				case 1 =>
					setState(523)
					parameter_list()

				}

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def keyword_declarator(): Keyword_declaratorContext = {
		val _localctx: Keyword_declaratorContext = new Keyword_declaratorContext(_ctx, getState())
		enterRule(_localctx, 66, RULE_keyword_declarator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(529)
			_la = _input.LA(1)
			if (_la==IDENTIFIER) {
				setState(528)
				selector()
			}

			setState(531)
			matchToken(COLON)
			setState(535)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==LPAREN) {
				setState(532)
				method_type()
				setState(537)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
			setState(538)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def selector(): SelectorContext = {
		val _localctx: SelectorContext = new SelectorContext(_ctx, getState())
		enterRule(_localctx, 68, RULE_selector)
		try {
			enterOuterAlt(_localctx, 1)
			setState(540)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def method_type(): Method_typeContext = {
		val _localctx: Method_typeContext = new Method_typeContext(_ctx, getState())
		enterRule(_localctx, 70, RULE_method_type)
		try {
			enterOuterAlt(_localctx, 1)
			setState(542)
			matchToken(LPAREN)
			setState(543)
			type_name()
			setState(544)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_implementation(): Property_implementationContext = {
		val _localctx: Property_implementationContext = new Property_implementationContext(_ctx, getState())
		enterRule(_localctx, 72, RULE_property_implementation)
		try {
			setState(554)
			(_input.LA(1)) match {
			case SYNTHESIZE =>
				enterOuterAlt(_localctx, 1)
				setState(546)
				matchToken(SYNTHESIZE)
				setState(547)
				property_synthesize_list()
				setState(548)
				matchToken(SEMI)

			case DYNAMIC =>
				enterOuterAlt(_localctx, 2)
				setState(550)
				matchToken(DYNAMIC)
				setState(551)
				property_synthesize_list()
				setState(552)
				matchToken(SEMI)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_synthesize_list(): Property_synthesize_listContext = {
		val _localctx: Property_synthesize_listContext = new Property_synthesize_listContext(_ctx, getState())
		enterRule(_localctx, 74, RULE_property_synthesize_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(556)
			property_synthesize_item()
			setState(561)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(557)
				matchToken(COMMA)
				setState(558)
				property_synthesize_item()
				setState(563)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def property_synthesize_item(): Property_synthesize_itemContext = {
		val _localctx: Property_synthesize_itemContext = new Property_synthesize_itemContext(_ctx, getState())
		enterRule(_localctx, 76, RULE_property_synthesize_item)
		try {
			setState(568)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,44,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(564)
				matchToken(IDENTIFIER)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(565)
				matchToken(IDENTIFIER)
				setState(566)
				matchToken(ASSIGN)
				setState(567)
				matchToken(IDENTIFIER)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def block_type(): Block_typeContext = {
		val _localctx: Block_typeContext = new Block_typeContext(_ctx, getState())
		enterRule(_localctx, 78, RULE_block_type)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(570)
			type_specifier()
			setState(571)
			matchToken(LPAREN)
			setState(572)
			matchToken(CARET)
			setState(574)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NS_OPTIONS - 66)) | (1L << (NS_ENUM - 66)) | (1L << (IDENTIFIER - 66)))) != 0)) {
				setState(573)
				type_specifier()
			}

			setState(576)
			matchToken(RPAREN)
			setState(578)
			_la = _input.LA(1)
			if (_la==LPAREN) {
				setState(577)
				block_parameters()
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def type_specifier(): Type_specifierContext = {
		val _localctx: Type_specifierContext = new Type_specifierContext(_ctx, getState())
		enterRule(_localctx, 80, RULE_type_specifier)
		var _la = 0
		try {
			setState(602)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,49,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(580)
				matchToken(VOID)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(581)
				matchToken(CHAR)

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(582)
				matchToken(SHORT)

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(583)
				matchToken(INT)

			case 5 =>
				enterOuterAlt(_localctx, 5)
				setState(584)
				matchToken(LONG)

			case 6 =>
				enterOuterAlt(_localctx, 6)
				setState(585)
				matchToken(FLOAT)

			case 7 =>
				enterOuterAlt(_localctx, 7)
				setState(586)
				matchToken(DOUBLE)

			case 8 =>
				enterOuterAlt(_localctx, 8)
				setState(587)
				matchToken(SIGNED)

			case 9 =>
				enterOuterAlt(_localctx, 9)
				setState(588)
				matchToken(UNSIGNED)

			case 10 =>
				enterOuterAlt(_localctx, 10)
				setState(589)
				matchToken(ID)
				setState(591)
				_la = _input.LA(1)
				if (_la==LT) {
					setState(590)
					protocol_reference_list()
				}


			case 11 =>
				enterOuterAlt(_localctx, 11)
				setState(593)
				class_name()
				setState(595)
				_la = _input.LA(1)
				if (_la==LT) {
					setState(594)
					protocol_reference_list()
				}


			case 12 =>
				enterOuterAlt(_localctx, 12)
				setState(597)
				struct_or_union_specifier()

			case 13 =>
				enterOuterAlt(_localctx, 13)
				setState(598)
				enum_specifier()

			case 14 =>
				enterOuterAlt(_localctx, 14)
				setState(599)
				matchToken(IDENTIFIER)

			case 15 =>
				enterOuterAlt(_localctx, 15)
				setState(600)
				matchToken(IDENTIFIER)
				setState(601)
				pointer()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def type_qualifier(): Type_qualifierContext = {
		val _localctx: Type_qualifierContext = new Type_qualifierContext(_ctx, getState())
		enterRule(_localctx, 82, RULE_type_qualifier)
		try {
			setState(607)
			(_input.LA(1)) match {
			case CONST =>
				enterOuterAlt(_localctx, 1)
				setState(604)
				matchToken(CONST)

			case VOLATILE =>
				enterOuterAlt(_localctx, 2)
				setState(605)
				matchToken(VOLATILE)

			case BYCOPY =>
			case BYREF =>
			case IN =>
			case INOUT =>
			case ONEWAY =>
			case OUT =>
				enterOuterAlt(_localctx, 3)
				setState(606)
				protocol_qualifier()

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_qualifier(): Protocol_qualifierContext = {
		val _localctx: Protocol_qualifierContext = new Protocol_qualifierContext(_ctx, getState())
		enterRule(_localctx, 84, RULE_protocol_qualifier)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(609)
			_la = _input.LA(1)
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << IN) | (1L << INOUT) | (1L << ONEWAY) | (1L << OUT))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def primary_expression(): Primary_expressionContext = {
		val _localctx: Primary_expressionContext = new Primary_expressionContext(_ctx, getState())
		enterRule(_localctx, 86, RULE_primary_expression)
		try {
			setState(628)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,51,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(611)
				matchToken(IDENTIFIER)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(612)
				constant()

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(613)
				matchToken(STRING_LITERAL)

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(614)
				matchToken(LPAREN)
				setState(615)
				expression()
				setState(616)
				matchToken(RPAREN)

			case 5 =>
				enterOuterAlt(_localctx, 5)
				setState(618)
				matchToken(SELF)

			case 6 =>
				enterOuterAlt(_localctx, 6)
				setState(619)
				matchToken(SUPER)

			case 7 =>
				enterOuterAlt(_localctx, 7)
				setState(620)
				message_expression()

			case 8 =>
				enterOuterAlt(_localctx, 8)
				setState(621)
				selector_expression()

			case 9 =>
				enterOuterAlt(_localctx, 9)
				setState(622)
				protocol_expression()

			case 10 =>
				enterOuterAlt(_localctx, 10)
				setState(623)
				encode_expression()

			case 11 =>
				enterOuterAlt(_localctx, 11)
				setState(624)
				dictionary_expression()

			case 12 =>
				enterOuterAlt(_localctx, 12)
				setState(625)
				array_expression()

			case 13 =>
				enterOuterAlt(_localctx, 13)
				setState(626)
				box_expression()

			case 14 =>
				enterOuterAlt(_localctx, 14)
				setState(627)
				block_expression()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def dictionary_pair(): Dictionary_pairContext = {
		val _localctx: Dictionary_pairContext = new Dictionary_pairContext(_ctx, getState())
		enterRule(_localctx, 88, RULE_dictionary_pair)
		try {
			enterOuterAlt(_localctx, 1)
			setState(630)
			postfix_expression()
			setState(631)
			matchToken(COLON)
			setState(634)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,52,_ctx) ) match {
			case 1 =>
				setState(632)
				postfix_expression()

			case 2 =>
				setState(633)
				expression()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def dictionary_expression(): Dictionary_expressionContext = {
		val _localctx: Dictionary_expressionContext = new Dictionary_expressionContext(_ctx, getState())
		enterRule(_localctx, 90, RULE_dictionary_expression)
		var _la = 0
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(636)
			matchToken(AT)
			setState(637)
			matchToken(LBRACE)
			setState(639)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				setState(638)
				dictionary_pair()
			}

			setState(645)
			_errHandler.sync(this)
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx)
			while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt == 1 ) {
					setState(641)
					matchToken(COMMA)
					setState(642)
					dictionary_pair() 
				}
				setState(647)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx)
			}
			setState(649)
			_la = _input.LA(1)
			if (_la==COMMA) {
				setState(648)
				matchToken(COMMA)
			}

			setState(651)
			matchToken(RBRACE)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def array_expression(): Array_expressionContext = {
		val _localctx: Array_expressionContext = new Array_expressionContext(_ctx, getState())
		enterRule(_localctx, 92, RULE_array_expression)
		var _la = 0
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(653)
			matchToken(AT)
			setState(654)
			matchToken(LBRACK)
			setState(656)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				setState(655)
				postfix_expression()
			}

			setState(662)
			_errHandler.sync(this)
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx)
			while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt == 1 ) {
					setState(658)
					matchToken(COMMA)
					setState(659)
					postfix_expression() 
				}
				setState(664)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx)
			}
			setState(666)
			_la = _input.LA(1)
			if (_la==COMMA) {
				setState(665)
				matchToken(COMMA)
			}

			setState(668)
			matchToken(RBRACK)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def box_expression(): Box_expressionContext = {
		val _localctx: Box_expressionContext = new Box_expressionContext(_ctx, getState())
		enterRule(_localctx, 94, RULE_box_expression)
		try {
			setState(680)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,60,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(670)
				matchToken(AT)
				setState(671)
				matchToken(LPAREN)
				setState(674)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,59,_ctx) ) match {
				case 1 =>
					setState(672)
					postfix_expression()

				case 2 =>
					setState(673)
					expression()

				}
				setState(676)
				matchToken(RPAREN)

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(678)
				matchToken(AT)
				setState(679)
				constant()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def block_parameters(): Block_parametersContext = {
		val _localctx: Block_parametersContext = new Block_parametersContext(_ctx, getState())
		enterRule(_localctx, 96, RULE_block_parameters)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(682)
			matchToken(LPAREN)
			setState(685)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,61,_ctx) ) match {
			case 1 =>
				setState(683)
				type_variable_declarator()

			case 2 =>
				setState(684)
				matchToken(VOID)

			}
			setState(691)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(687)
				matchToken(COMMA)
				setState(688)
				type_variable_declarator()
				setState(693)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
			setState(694)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def block_expression(): Block_expressionContext = {
		val _localctx: Block_expressionContext = new Block_expressionContext(_ctx, getState())
		enterRule(_localctx, 98, RULE_block_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(696)
			matchToken(CARET)
			setState(698)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << INT) | (1L << LONG) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (NS_OPTIONS - 66)) | (1L << (NS_ENUM - 66)) | (1L << (IDENTIFIER - 66)))) != 0)) {
				setState(697)
				type_specifier()
			}

			setState(701)
			_la = _input.LA(1)
			if (_la==LPAREN) {
				setState(700)
				block_parameters()
			}

			setState(703)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def message_expression(): Message_expressionContext = {
		val _localctx: Message_expressionContext = new Message_expressionContext(_ctx, getState())
		enterRule(_localctx, 100, RULE_message_expression)
		try {
			enterOuterAlt(_localctx, 1)
			setState(705)
			matchToken(LBRACK)
			setState(706)
			receiver()
			setState(707)
			message_selector()
			setState(708)
			matchToken(RBRACK)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def receiver(): ReceiverContext = {
		val _localctx: ReceiverContext = new ReceiverContext(_ctx, getState())
		enterRule(_localctx, 102, RULE_receiver)
		try {
			setState(713)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,65,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(710)
				expression()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(711)
				class_name()

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(712)
				matchToken(SUPER)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def message_selector(): Message_selectorContext = {
		val _localctx: Message_selectorContext = new Message_selectorContext(_ctx, getState())
		enterRule(_localctx, 104, RULE_message_selector)
		var _la = 0
		try {
			setState(721)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,67,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(715)
				selector()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(717) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(716)
					keyword_argument()
					setState(719) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( _la==COLON || _la==IDENTIFIER )

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def keyword_argument(): Keyword_argumentContext = {
		val _localctx: Keyword_argumentContext = new Keyword_argumentContext(_ctx, getState())
		enterRule(_localctx, 106, RULE_keyword_argument)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(724)
			_la = _input.LA(1)
			if (_la==IDENTIFIER) {
				setState(723)
				selector()
			}

			setState(726)
			matchToken(COLON)
			setState(727)
			expression()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def selector_expression(): Selector_expressionContext = {
		val _localctx: Selector_expressionContext = new Selector_expressionContext(_ctx, getState())
		enterRule(_localctx, 108, RULE_selector_expression)
		try {
			enterOuterAlt(_localctx, 1)
			setState(729)
			matchToken(SELECTOR)
			setState(730)
			matchToken(LPAREN)
			setState(731)
			selector_name()
			setState(732)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def selector_name(): Selector_nameContext = {
		val _localctx: Selector_nameContext = new Selector_nameContext(_ctx, getState())
		enterRule(_localctx, 110, RULE_selector_name)
		var _la = 0
		try {
			setState(743)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,71,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(734)
				selector()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(739) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(736)
					_la = _input.LA(1)
					if (_la==IDENTIFIER) {
						setState(735)
						selector()
					}

					setState(738)
					matchToken(COLON)
					setState(741) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( _la==COLON || _la==IDENTIFIER )

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def protocol_expression(): Protocol_expressionContext = {
		val _localctx: Protocol_expressionContext = new Protocol_expressionContext(_ctx, getState())
		enterRule(_localctx, 112, RULE_protocol_expression)
		try {
			enterOuterAlt(_localctx, 1)
			setState(745)
			matchToken(PROTOCOL)
			setState(746)
			matchToken(LPAREN)
			setState(747)
			protocol_name()
			setState(748)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def encode_expression(): Encode_expressionContext = {
		val _localctx: Encode_expressionContext = new Encode_expressionContext(_ctx, getState())
		enterRule(_localctx, 114, RULE_encode_expression)
		try {
			enterOuterAlt(_localctx, 1)
			setState(750)
			matchToken(ENCODE)
			setState(751)
			matchToken(LPAREN)
			setState(752)
			type_name()
			setState(753)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def type_variable_declarator(): Type_variable_declaratorContext = {
		val _localctx: Type_variable_declaratorContext = new Type_variable_declaratorContext(_ctx, getState())
		enterRule(_localctx, 116, RULE_type_variable_declarator)
		try {
			enterOuterAlt(_localctx, 1)
			setState(755)
			declaration_specifiers()
			setState(756)
			declarator()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def try_statement(): Try_statementContext = {
		val _localctx: Try_statementContext = new Try_statementContext(_ctx, getState())
		enterRule(_localctx, 118, RULE_try_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(758)
			matchToken(TRY)
			setState(759)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def catch_statement(): Catch_statementContext = {
		val _localctx: Catch_statementContext = new Catch_statementContext(_ctx, getState())
		enterRule(_localctx, 120, RULE_catch_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(761)
			matchToken(CATCH)
			setState(762)
			matchToken(LPAREN)
			setState(763)
			type_variable_declarator()
			setState(764)
			matchToken(RPAREN)
			setState(765)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def finally_statement(): Finally_statementContext = {
		val _localctx: Finally_statementContext = new Finally_statementContext(_ctx, getState())
		enterRule(_localctx, 122, RULE_finally_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(767)
			matchToken(FINALLY)
			setState(768)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def throw_statement(): Throw_statementContext = {
		val _localctx: Throw_statementContext = new Throw_statementContext(_ctx, getState())
		enterRule(_localctx, 124, RULE_throw_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(770)
			matchToken(THROW)
			setState(771)
			matchToken(LPAREN)
			setState(772)
			matchToken(IDENTIFIER)
			setState(773)
			matchToken(RPAREN)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def try_block(): Try_blockContext = {
		val _localctx: Try_blockContext = new Try_blockContext(_ctx, getState())
		enterRule(_localctx, 126, RULE_try_block)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(775)
			try_statement()
			setState(779)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==CATCH) {
				setState(776)
				catch_statement()
				setState(781)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
			setState(783)
			_la = _input.LA(1)
			if (_la==FINALLY) {
				setState(782)
				finally_statement()
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def synchronized_statement(): Synchronized_statementContext = {
		val _localctx: Synchronized_statementContext = new Synchronized_statementContext(_ctx, getState())
		enterRule(_localctx, 128, RULE_synchronized_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(785)
			matchToken(SYNCHRONIZED)
			setState(786)
			matchToken(LPAREN)
			setState(787)
			primary_expression()
			setState(788)
			matchToken(RPAREN)
			setState(789)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def autorelease_statement(): Autorelease_statementContext = {
		val _localctx: Autorelease_statementContext = new Autorelease_statementContext(_ctx, getState())
		enterRule(_localctx, 130, RULE_autorelease_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(791)
			matchToken(AUTORELEASEPOOL)
			setState(792)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def function_definition(): Function_definitionContext = {
		val _localctx: Function_definitionContext = new Function_definitionContext(_ctx, getState())
		enterRule(_localctx, 132, RULE_function_definition)
		try {
			enterOuterAlt(_localctx, 1)
			setState(795)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,74,_ctx) ) match {
			case 1 =>
				setState(794)
				declaration_specifiers()

			}
			setState(797)
			declarator()
			setState(798)
			compound_statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def declaration(): DeclarationContext = {
		val _localctx: DeclarationContext = new DeclarationContext(_ctx, getState())
		enterRule(_localctx, 134, RULE_declaration)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(800)
			declaration_specifiers()
			setState(802)
			_la = _input.LA(1)
			if (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (MUL - 70)) | (1L << (IDENTIFIER - 70)))) != 0)) {
				setState(801)
				init_declarator_list()
			}

			setState(804)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def declaration_specifiers(): Declaration_specifiersContext = {
		val _localctx: Declaration_specifiersContext = new Declaration_specifiersContext(_ctx, getState())
		enterRule(_localctx, 136, RULE_declaration_specifiers)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(810) 
			_errHandler.sync(this)
			_alt = 1
			do {
				(_alt) match {
				case 1 =>
					setState(810)
					(_input.LA(1)) match {
					case WWEAK =>
					case WUNSAFE_UNRETAINED =>
						setState(806)
						arc_behaviour_specifier()

					case AUTO =>
					case EXTERN =>
					case REGISTER =>
					case STATIC =>
					case TYPEDEF =>
						setState(807)
						storage_class_specifier()

					case CHAR =>
					case DOUBLE =>
					case ENUM =>
					case FLOAT =>
					case ID =>
					case INT =>
					case LONG =>
					case SHORT =>
					case SIGNED =>
					case STRUCT =>
					case UNION =>
					case UNSIGNED =>
					case VOID =>
					case NS_OPTIONS =>
					case NS_ENUM =>
					case IDENTIFIER =>
						setState(808)
						type_specifier()

					case BYCOPY =>
					case BYREF =>
					case CONST =>
					case IN =>
					case INOUT =>
					case ONEWAY =>
					case OUT =>
					case VOLATILE =>
						setState(809)
						type_qualifier()

					case _ =>
						throw new NoViableAltException(this)
					}

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(812) 
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx)
			} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def arc_behaviour_specifier(): Arc_behaviour_specifierContext = {
		val _localctx: Arc_behaviour_specifierContext = new Arc_behaviour_specifierContext(_ctx, getState())
		enterRule(_localctx, 138, RULE_arc_behaviour_specifier)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(814)
			_la = _input.LA(1)
			if ( !(_la==WWEAK || _la==WUNSAFE_UNRETAINED) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def storage_class_specifier(): Storage_class_specifierContext = {
		val _localctx: Storage_class_specifierContext = new Storage_class_specifierContext(_ctx, getState())
		enterRule(_localctx, 140, RULE_storage_class_specifier)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(816)
			_la = _input.LA(1)
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << EXTERN) | (1L << REGISTER) | (1L << STATIC) | (1L << TYPEDEF))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def init_declarator_list(): Init_declarator_listContext = {
		val _localctx: Init_declarator_listContext = new Init_declarator_listContext(_ctx, getState())
		enterRule(_localctx, 142, RULE_init_declarator_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(818)
			init_declarator()
			setState(823)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(819)
				matchToken(COMMA)
				setState(820)
				init_declarator()
				setState(825)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def init_declarator(): Init_declaratorContext = {
		val _localctx: Init_declaratorContext = new Init_declaratorContext(_ctx, getState())
		enterRule(_localctx, 144, RULE_init_declarator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(826)
			declarator()
			setState(829)
			_la = _input.LA(1)
			if (_la==ASSIGN) {
				setState(827)
				matchToken(ASSIGN)
				setState(828)
				initializer()
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def struct_or_union_specifier(): Struct_or_union_specifierContext = {
		val _localctx: Struct_or_union_specifierContext = new Struct_or_union_specifierContext(_ctx, getState())
		enterRule(_localctx, 146, RULE_struct_or_union_specifier)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(831)
			_la = _input.LA(1)
			if ( !(_la==STRUCT || _la==UNION) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
			setState(844)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,82,_ctx) ) match {
			case 1 =>
				setState(832)
				matchToken(IDENTIFIER)

			case 2 =>
				setState(834)
				_la = _input.LA(1)
				if (_la==IDENTIFIER) {
					setState(833)
					matchToken(IDENTIFIER)
				}

				setState(836)
				matchToken(LBRACE)
				setState(838) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(837)
					struct_declaration()
					setState(840) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << SHORT) | (1L << SIGNED) | (1L << STRUCT) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0) )
				setState(842)
				matchToken(RBRACE)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def struct_declaration(): Struct_declarationContext = {
		val _localctx: Struct_declarationContext = new Struct_declarationContext(_ctx, getState())
		enterRule(_localctx, 148, RULE_struct_declaration)
		try {
			enterOuterAlt(_localctx, 1)
			setState(846)
			specifier_qualifier_list()
			setState(847)
			struct_declarator_list()
			setState(848)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def specifier_qualifier_list(): Specifier_qualifier_listContext = {
		val _localctx: Specifier_qualifier_listContext = new Specifier_qualifier_listContext(_ctx, getState())
		enterRule(_localctx, 150, RULE_specifier_qualifier_list)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(853) 
			_errHandler.sync(this)
			_alt = 1
			do {
				(_alt) match {
				case 1 =>
					setState(853)
					(_input.LA(1)) match {
					case WWEAK =>
					case WUNSAFE_UNRETAINED =>
						setState(850)
						arc_behaviour_specifier()

					case CHAR =>
					case DOUBLE =>
					case ENUM =>
					case FLOAT =>
					case ID =>
					case INT =>
					case LONG =>
					case SHORT =>
					case SIGNED =>
					case STRUCT =>
					case UNION =>
					case UNSIGNED =>
					case VOID =>
					case NS_OPTIONS =>
					case NS_ENUM =>
					case IDENTIFIER =>
						setState(851)
						type_specifier()

					case BYCOPY =>
					case BYREF =>
					case CONST =>
					case IN =>
					case INOUT =>
					case ONEWAY =>
					case OUT =>
					case VOLATILE =>
						setState(852)
						type_qualifier()

					case _ =>
						throw new NoViableAltException(this)
					}

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(855) 
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx)
			} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def struct_declarator_list(): Struct_declarator_listContext = {
		val _localctx: Struct_declarator_listContext = new Struct_declarator_listContext(_ctx, getState())
		enterRule(_localctx, 152, RULE_struct_declarator_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(857)
			struct_declarator()
			setState(862)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(858)
				matchToken(COMMA)
				setState(859)
				struct_declarator()
				setState(864)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def struct_declarator(): Struct_declaratorContext = {
		val _localctx: Struct_declaratorContext = new Struct_declaratorContext(_ctx, getState())
		enterRule(_localctx, 154, RULE_struct_declarator)
		var _la = 0
		try {
			setState(871)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,87,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(865)
				declarator()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(867)
				_la = _input.LA(1)
				if (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (MUL - 70)) | (1L << (IDENTIFIER - 70)))) != 0)) {
					setState(866)
					declarator()
				}

				setState(869)
				matchToken(COLON)
				setState(870)
				constant()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def enum_specifier(): Enum_specifierContext = {
		val _localctx: Enum_specifierContext = new Enum_specifierContext(_ctx, getState())
		enterRule(_localctx, 156, RULE_enum_specifier)
		var _la = 0
		try {
			setState(914)
			(_input.LA(1)) match {
			case ENUM =>
				enterOuterAlt(_localctx, 1)
				setState(873)
				matchToken(ENUM)
				setState(879)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,89,_ctx) ) match {
				case 1 =>
					setState(875)
					_la = _input.LA(1)
					if (_la==IDENTIFIER) {
						setState(874)
						matchToken(IDENTIFIER)
					}

					setState(877)
					matchToken(COLON)
					setState(878)
					type_name()

				}
				setState(892)
				(_input.LA(1)) match {
				case IDENTIFIER =>
					setState(881)
					identifier()
					setState(886)
					_errHandler.sync(this)
					( getInterpreter().adaptivePredict(_input,90,_ctx) ) match {
					case 1 =>
						setState(882)
						matchToken(LBRACE)
						setState(883)
						enumerator_list()
						setState(884)
						matchToken(RBRACE)

					}

				case LBRACE =>
					setState(888)
					matchToken(LBRACE)
					setState(889)
					enumerator_list()
					setState(890)
					matchToken(RBRACE)

				case _ =>
					throw new NoViableAltException(this)
				}

			case NS_OPTIONS =>
				enterOuterAlt(_localctx, 2)
				setState(894)
				matchToken(NS_OPTIONS)
				setState(895)
				matchToken(LPAREN)
				setState(896)
				type_name()
				setState(897)
				matchToken(COMMA)
				setState(898)
				identifier()
				setState(899)
				matchToken(RPAREN)
				setState(900)
				matchToken(LBRACE)
				setState(901)
				enumerator_list()
				setState(902)
				matchToken(RBRACE)

			case NS_ENUM =>
				enterOuterAlt(_localctx, 3)
				setState(904)
				matchToken(NS_ENUM)
				setState(905)
				matchToken(LPAREN)
				setState(906)
				type_name()
				setState(907)
				matchToken(COMMA)
				setState(908)
				identifier()
				setState(909)
				matchToken(RPAREN)
				setState(910)
				matchToken(LBRACE)
				setState(911)
				enumerator_list()
				setState(912)
				matchToken(RBRACE)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def enumerator_list(): Enumerator_listContext = {
		val _localctx: Enumerator_listContext = new Enumerator_listContext(_ctx, getState())
		enterRule(_localctx, 158, RULE_enumerator_list)
		var _la = 0
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(916)
			enumerator()
			setState(921)
			_errHandler.sync(this)
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx)
			while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt == 1 ) {
					setState(917)
					matchToken(COMMA)
					setState(918)
					enumerator() 
				}
				setState(923)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx)
			}
			setState(925)
			_la = _input.LA(1)
			if (_la==COMMA) {
				setState(924)
				matchToken(COMMA)
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def enumerator(): EnumeratorContext = {
		val _localctx: EnumeratorContext = new EnumeratorContext(_ctx, getState())
		enterRule(_localctx, 160, RULE_enumerator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(927)
			identifier()
			setState(930)
			_la = _input.LA(1)
			if (_la==ASSIGN) {
				setState(928)
				matchToken(ASSIGN)
				setState(929)
				constant_expression()
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def pointer(): PointerContext = {
		val _localctx: PointerContext = new PointerContext(_ctx, getState())
		enterRule(_localctx, 162, RULE_pointer)
		var _la = 0
		try {
			setState(941)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,98,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(932)
				matchToken(MUL)
				setState(934)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,96,_ctx) ) match {
				case 1 =>
					setState(933)
					declaration_specifiers()

				}

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(936)
				matchToken(MUL)
				setState(938)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					setState(937)
					declaration_specifiers()
				}

				setState(940)
				pointer()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def declarator(): DeclaratorContext = {
		val _localctx: DeclaratorContext = new DeclaratorContext(_ctx, getState())
		enterRule(_localctx, 164, RULE_declarator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(944)
			_la = _input.LA(1)
			if (_la==MUL) {
				setState(943)
				pointer()
			}

			setState(946)
			direct_declarator()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def direct_declarator(): Direct_declaratorContext = {
		val _localctx: Direct_declaratorContext = new Direct_declaratorContext(_ctx, getState())
		enterRule(_localctx, 166, RULE_direct_declarator)
		var _la = 0
		try {
			var _alt = 0
			setState(971)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,103,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(948)
				identifier()
				setState(952)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx)
				while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt == 1 ) {
						setState(949)
						declarator_suffix() 
					}
					setState(954)
					_errHandler.sync(this)
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx)
				}

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(955)
				matchToken(LPAREN)
				setState(956)
				declarator()
				setState(957)
				matchToken(RPAREN)
				setState(961)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx)
				while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt == 1 ) {
						setState(958)
						declarator_suffix() 
					}
					setState(963)
					_errHandler.sync(this)
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx)
				}

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(964)
				matchToken(LPAREN)
				setState(965)
				matchToken(CARET)
				setState(967)
				_la = _input.LA(1)
				if (_la==IDENTIFIER) {
					setState(966)
					identifier()
				}

				setState(969)
				matchToken(RPAREN)
				setState(970)
				block_parameters()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def declarator_suffix(): Declarator_suffixContext = {
		val _localctx: Declarator_suffixContext = new Declarator_suffixContext(_ctx, getState())
		enterRule(_localctx, 168, RULE_declarator_suffix)
		var _la = 0
		try {
			setState(983)
			(_input.LA(1)) match {
			case LBRACK =>
				enterOuterAlt(_localctx, 1)
				setState(973)
				matchToken(LBRACK)
				setState(975)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					setState(974)
					constant_expression()
				}

				setState(977)
				matchToken(RBRACK)

			case LPAREN =>
				enterOuterAlt(_localctx, 2)
				setState(978)
				matchToken(LPAREN)
				setState(980)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					setState(979)
					parameter_list()
				}

				setState(982)
				matchToken(RPAREN)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def parameter_list(): Parameter_listContext = {
		val _localctx: Parameter_listContext = new Parameter_listContext(_ctx, getState())
		enterRule(_localctx, 170, RULE_parameter_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(985)
			parameter_declaration_list()
			setState(988)
			_la = _input.LA(1)
			if (_la==COMMA) {
				setState(986)
				matchToken(COMMA)
				setState(987)
				matchToken(ELIPSIS)
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def parameter_declaration(): Parameter_declarationContext = {
		val _localctx: Parameter_declarationContext = new Parameter_declarationContext(_ctx, getState())
		enterRule(_localctx, 172, RULE_parameter_declaration)
		try {
			enterOuterAlt(_localctx, 1)
			setState(990)
			declaration_specifiers()
			setState(995)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,109,_ctx) ) match {
			case 1 =>
				setState(992)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,108,_ctx) ) match {
				case 1 =>
					setState(991)
					declarator()

				}

			case 2 =>
				setState(994)
				abstract_declarator()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def initializer(): InitializerContext = {
		val _localctx: InitializerContext = new InitializerContext(_ctx, getState())
		enterRule(_localctx, 174, RULE_initializer)
		var _la = 0
		try {
			var _alt = 0
			setState(1012)
			(_input.LA(1)) match {
			case ENCODE =>
			case PROTOCOL =>
			case SELECTOR =>
			case SUPER =>
			case SELF =>
			case SIZEOF =>
			case LPAREN =>
			case LBRACK =>
			case AT =>
			case BANG =>
			case TILDE =>
			case INC =>
			case DEC =>
			case SUB =>
			case MUL =>
			case BITAND =>
			case CARET =>
			case IDENTIFIER =>
			case CHARACTER_LITERAL =>
			case STRING_LITERAL =>
			case HEX_LITERAL =>
			case DECIMAL_LITERAL =>
			case OCTAL_LITERAL =>
			case FLOATING_POINT_LITERAL =>
				enterOuterAlt(_localctx, 1)
				setState(997)
				assignment_expression()

			case LBRACE =>
				enterOuterAlt(_localctx, 2)
				setState(998)
				matchToken(LBRACE)
				setState(999)
				initializer()
				setState(1004)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx)
				while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt == 1 ) {
						setState(1000)
						matchToken(COMMA)
						setState(1001)
						initializer() 
					}
					setState(1006)
					_errHandler.sync(this)
					_alt = getInterpreter().adaptivePredict(_input,110,_ctx)
				}
				setState(1008)
				_la = _input.LA(1)
				if (_la==COMMA) {
					setState(1007)
					matchToken(COMMA)
				}

				setState(1010)
				matchToken(RBRACE)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def type_name(): Type_nameContext = {
		val _localctx: Type_nameContext = new Type_nameContext(_ctx, getState())
		enterRule(_localctx, 176, RULE_type_name)
		try {
			setState(1018)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,113,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1014)
				specifier_qualifier_list()
				setState(1015)
				abstract_declarator()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1017)
				block_type()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def abstract_declarator(): Abstract_declaratorContext = {
		val _localctx: Abstract_declaratorContext = new Abstract_declaratorContext(_ctx, getState())
		enterRule(_localctx, 178, RULE_abstract_declarator)
		var _la = 0
		try {
			var _alt = 0
			setState(1041)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,117,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1020)
				pointer()
				setState(1021)
				abstract_declarator()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1023)
				matchToken(LPAREN)
				setState(1024)
				abstract_declarator()
				setState(1025)
				matchToken(RPAREN)
				setState(1027) 
				_errHandler.sync(this)
				_alt = 1
				do {
					(_alt) match {
					case 1 =>
						setState(1026)
						abstract_declarator_suffix()

					case _ =>
						throw new NoViableAltException(this)
					}
					setState(1029) 
					_errHandler.sync(this)
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx)
				} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(1036) 
				_errHandler.sync(this)
				_la = _input.LA(1)
				do {
					setState(1031)
					matchToken(LBRACK)
					setState(1033)
					_la = _input.LA(1)
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
						setState(1032)
						constant_expression()
					}

					setState(1035)
					matchToken(RBRACK)
					setState(1038) 
					_errHandler.sync(this)
					_la = _input.LA(1)
				} while ( _la==LBRACK )

			case 4 =>
				enterOuterAlt(_localctx, 4)


			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def abstract_declarator_suffix(): Abstract_declarator_suffixContext = {
		val _localctx: Abstract_declarator_suffixContext = new Abstract_declarator_suffixContext(_ctx, getState())
		enterRule(_localctx, 180, RULE_abstract_declarator_suffix)
		var _la = 0
		try {
			setState(1053)
			(_input.LA(1)) match {
			case LBRACK =>
				enterOuterAlt(_localctx, 1)
				setState(1043)
				matchToken(LBRACK)
				setState(1045)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					setState(1044)
					constant_expression()
				}

				setState(1047)
				matchToken(RBRACK)

			case LPAREN =>
				enterOuterAlt(_localctx, 2)
				setState(1048)
				matchToken(LPAREN)
				setState(1050)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTO) | (1L << BYCOPY) | (1L << BYREF) | (1L << CHAR) | (1L << CONST) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << ID) | (1L << IN) | (1L << INOUT) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << SHORT) | (1L << SIGNED) | (1L << STATIC) | (1L << STRUCT) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (IDENTIFIER - 64)))) != 0)) {
					setState(1049)
					parameter_declaration_list()
				}

				setState(1052)
				matchToken(RPAREN)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def parameter_declaration_list(): Parameter_declaration_listContext = {
		val _localctx: Parameter_declaration_listContext = new Parameter_declaration_listContext(_ctx, getState())
		enterRule(_localctx, 182, RULE_parameter_declaration_list)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(1055)
			parameter_declaration()
			setState(1060)
			_errHandler.sync(this)
			_alt = getInterpreter().adaptivePredict(_input,121,_ctx)
			while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt == 1 ) {
					setState(1056)
					matchToken(COMMA)
					setState(1057)
					parameter_declaration() 
				}
				setState(1062)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,121,_ctx)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def statement_list(): Statement_listContext = {
		val _localctx: Statement_listContext = new Statement_listContext(_ctx, getState())
		enterRule(_localctx, 184, RULE_statement_list)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(1064) 
			_errHandler.sync(this)
			_alt = 1
			do {
				(_alt) match {
				case 1 =>
					setState(1063)
					statement()

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(1066) 
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx)
			} while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER )
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def statement(): StatementContext = {
		val _localctx: StatementContext = new StatementContext(_ctx, getState())
		enterRule(_localctx, 186, RULE_statement)
		try {
			setState(1080)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,123,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1068)
				labeled_statement()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1069)
				expression()
				setState(1070)
				matchToken(SEMI)

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(1072)
				compound_statement()

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(1073)
				selection_statement()

			case 5 =>
				enterOuterAlt(_localctx, 5)
				setState(1074)
				iteration_statement()

			case 6 =>
				enterOuterAlt(_localctx, 6)
				setState(1075)
				jump_statement()

			case 7 =>
				enterOuterAlt(_localctx, 7)
				setState(1076)
				synchronized_statement()

			case 8 =>
				enterOuterAlt(_localctx, 8)
				setState(1077)
				autorelease_statement()

			case 9 =>
				enterOuterAlt(_localctx, 9)
				setState(1078)
				try_block()

			case 10 =>
				enterOuterAlt(_localctx, 10)
				setState(1079)
				matchToken(SEMI)

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def labeled_statement(): Labeled_statementContext = {
		val _localctx: Labeled_statementContext = new Labeled_statementContext(_ctx, getState())
		enterRule(_localctx, 188, RULE_labeled_statement)
		try {
			setState(1094)
			(_input.LA(1)) match {
			case IDENTIFIER =>
				enterOuterAlt(_localctx, 1)
				setState(1082)
				identifier()
				setState(1083)
				matchToken(COLON)
				setState(1084)
				statement()

			case CASE =>
				enterOuterAlt(_localctx, 2)
				setState(1086)
				matchToken(CASE)
				setState(1087)
				constant_expression()
				setState(1088)
				matchToken(COLON)
				setState(1089)
				statement()

			case DEFAULT =>
				enterOuterAlt(_localctx, 3)
				setState(1091)
				matchToken(DEFAULT)
				setState(1092)
				matchToken(COLON)
				setState(1093)
				statement()

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def compound_statement(): Compound_statementContext = {
		val _localctx: Compound_statementContext = new Compound_statementContext(_ctx, getState())
		enterRule(_localctx, 190, RULE_compound_statement)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1096)
			matchToken(LBRACE)
			setState(1101)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AUTORELEASEPOOL) | (1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SYNCHRONIZED) | (1L << TRY) | (1L << SUPER) | (1L << SELF) | (1L << AUTO) | (1L << BREAK) | (1L << BYCOPY) | (1L << BYREF) | (1L << CASE) | (1L << CHAR) | (1L << CONST) | (1L << CONTINUE) | (1L << DEFAULT) | (1L << DO) | (1L << DOUBLE) | (1L << ENUM) | (1L << EXTERN) | (1L << FLOAT) | (1L << FOR) | (1L << ID) | (1L << IF) | (1L << IN) | (1L << INOUT) | (1L << GOTO) | (1L << INT) | (1L << LONG) | (1L << ONEWAY) | (1L << OUT) | (1L << REGISTER) | (1L << RETURN) | (1L << SHORT) | (1L << SIGNED) | (1L << SIZEOF) | (1L << STATIC) | (1L << STRUCT) | (1L << SWITCH) | (1L << TYPEDEF) | (1L << UNION) | (1L << UNSIGNED) | (1L << VOID))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (VOLATILE - 64)) | (1L << (WHILE - 64)) | (1L << (NS_OPTIONS - 64)) | (1L << (NS_ENUM - 64)) | (1L << (WWEAK - 64)) | (1L << (WUNSAFE_UNRETAINED - 64)) | (1L << (LPAREN - 64)) | (1L << (LBRACE - 64)) | (1L << (LBRACK - 64)) | (1L << (SEMI - 64)) | (1L << (AT - 64)) | (1L << (BANG - 64)) | (1L << (TILDE - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)) | (1L << (SUB - 64)) | (1L << (MUL - 64)) | (1L << (BITAND - 64)) | (1L << (CARET - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (CHARACTER_LITERAL - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (STRING_LITERAL - 128)) | (1L << (HEX_LITERAL - 128)) | (1L << (DECIMAL_LITERAL - 128)) | (1L << (OCTAL_LITERAL - 128)) | (1L << (FLOATING_POINT_LITERAL - 128)))) != 0)) {
				setState(1099)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,125,_ctx) ) match {
				case 1 =>
					setState(1097)
					declaration()

				case 2 =>
					setState(1098)
					statement_list()

				}
				setState(1103)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
			setState(1104)
			matchToken(RBRACE)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def selection_statement(): Selection_statementContext = {
		val _localctx: Selection_statementContext = new Selection_statementContext(_ctx, getState())
		enterRule(_localctx, 192, RULE_selection_statement)
		try {
			setState(1121)
			(_input.LA(1)) match {
			case IF =>
				enterOuterAlt(_localctx, 1)
				setState(1106)
				matchToken(IF)
				setState(1107)
				matchToken(LPAREN)
				setState(1108)
				expression()
				setState(1109)
				matchToken(RPAREN)
				setState(1110)
				statement()
				setState(1113)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,127,_ctx) ) match {
				case 1 =>
					setState(1111)
					matchToken(ELSE)
					setState(1112)
					statement()

				}

			case SWITCH =>
				enterOuterAlt(_localctx, 2)
				setState(1115)
				matchToken(SWITCH)
				setState(1116)
				matchToken(LPAREN)
				setState(1117)
				expression()
				setState(1118)
				matchToken(RPAREN)
				setState(1119)
				statement()

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def for_in_statement(): For_in_statementContext = {
		val _localctx: For_in_statementContext = new For_in_statementContext(_ctx, getState())
		enterRule(_localctx, 194, RULE_for_in_statement)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1123)
			matchToken(FOR)
			setState(1124)
			matchToken(LPAREN)
			setState(1125)
			type_variable_declarator()
			setState(1126)
			matchToken(IN)
			setState(1128)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				setState(1127)
				expression()
			}

			setState(1130)
			matchToken(RPAREN)
			setState(1131)
			statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def for_statement(): For_statementContext = {
		val _localctx: For_statementContext = new For_statementContext(_ctx, getState())
		enterRule(_localctx, 196, RULE_for_statement)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1133)
			matchToken(FOR)
			setState(1134)
			matchToken(LPAREN)
			setState(1139)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,130,_ctx) ) match {
			case 1 =>
				setState(1135)
				declaration_specifiers()
				setState(1136)
				init_declarator_list()

			case 2 =>
				setState(1138)
				expression()

			}
			setState(1141)
			matchToken(SEMI)
			setState(1143)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				setState(1142)
				expression()
			}

			setState(1145)
			matchToken(SEMI)
			setState(1147)
			_la = _input.LA(1)
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
				setState(1146)
				expression()
			}

			setState(1149)
			matchToken(RPAREN)
			setState(1150)
			statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def while_statement(): While_statementContext = {
		val _localctx: While_statementContext = new While_statementContext(_ctx, getState())
		enterRule(_localctx, 198, RULE_while_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(1152)
			matchToken(WHILE)
			setState(1153)
			matchToken(LPAREN)
			setState(1154)
			expression()
			setState(1155)
			matchToken(RPAREN)
			setState(1156)
			statement()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def do_statement(): Do_statementContext = {
		val _localctx: Do_statementContext = new Do_statementContext(_ctx, getState())
		enterRule(_localctx, 200, RULE_do_statement)
		try {
			enterOuterAlt(_localctx, 1)
			setState(1158)
			matchToken(DO)
			setState(1159)
			statement()
			setState(1160)
			matchToken(WHILE)
			setState(1161)
			matchToken(LPAREN)
			setState(1162)
			expression()
			setState(1163)
			matchToken(RPAREN)
			setState(1164)
			matchToken(SEMI)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def iteration_statement(): Iteration_statementContext = {
		val _localctx: Iteration_statementContext = new Iteration_statementContext(_ctx, getState())
		enterRule(_localctx, 202, RULE_iteration_statement)
		try {
			setState(1170)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,133,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1166)
				while_statement()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1167)
				do_statement()

			case 3 =>
				enterOuterAlt(_localctx, 3)
				setState(1168)
				for_statement()

			case 4 =>
				enterOuterAlt(_localctx, 4)
				setState(1169)
				for_in_statement()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def jump_statement(): Jump_statementContext = {
		val _localctx: Jump_statementContext = new Jump_statementContext(_ctx, getState())
		enterRule(_localctx, 204, RULE_jump_statement)
		var _la = 0
		try {
			setState(1185)
			(_input.LA(1)) match {
			case GOTO =>
				enterOuterAlt(_localctx, 1)
				setState(1172)
				matchToken(GOTO)
				setState(1173)
				identifier()
				setState(1174)
				matchToken(SEMI)

			case CONTINUE =>
				enterOuterAlt(_localctx, 2)
				setState(1176)
				matchToken(CONTINUE)
				setState(1177)
				matchToken(SEMI)

			case BREAK =>
				enterOuterAlt(_localctx, 3)
				setState(1178)
				matchToken(BREAK)
				setState(1179)
				matchToken(SEMI)

			case RETURN =>
				enterOuterAlt(_localctx, 4)
				setState(1180)
				matchToken(RETURN)
				setState(1182)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					setState(1181)
					expression()
				}

				setState(1184)
				matchToken(SEMI)

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def expression(): ExpressionContext = {
		val _localctx: ExpressionContext = new ExpressionContext(_ctx, getState())
		enterRule(_localctx, 206, RULE_expression)
		try {
			var _alt = 0
			enterOuterAlt(_localctx, 1)
			setState(1187)
			assignment_expression()
			setState(1192)
			_errHandler.sync(this)
			_alt = getInterpreter().adaptivePredict(_input,136,_ctx)
			while ( _alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt == 1 ) {
					setState(1188)
					matchToken(COMMA)
					setState(1189)
					assignment_expression() 
				}
				setState(1194)
				_errHandler.sync(this)
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def assignment_expression(): Assignment_expressionContext = {
		val _localctx: Assignment_expressionContext = new Assignment_expressionContext(_ctx, getState())
		enterRule(_localctx, 208, RULE_assignment_expression)
		try {
			setState(1200)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,137,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1195)
				conditional_expression()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1196)
				unary_expression()
				setState(1197)
				assignment_operator()
				setState(1198)
				assignment_expression()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def assignment_operator(): Assignment_operatorContext = {
		val _localctx: Assignment_operatorContext = new Assignment_operatorContext(_ctx, getState())
		enterRule(_localctx, 210, RULE_assignment_operator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1202)
			_la = _input.LA(1)
			if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & ((1L << (ASSIGN - 81)) | (1L << (ADD_ASSIGN - 81)) | (1L << (SUB_ASSIGN - 81)) | (1L << (MUL_ASSIGN - 81)) | (1L << (DIV_ASSIGN - 81)) | (1L << (AND_ASSIGN - 81)) | (1L << (OR_ASSIGN - 81)) | (1L << (XOR_ASSIGN - 81)) | (1L << (MOD_ASSIGN - 81)) | (1L << (LSHIFT_ASSIGN - 81)) | (1L << (RSHIFT_ASSIGN - 81)))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def conditional_expression(): Conditional_expressionContext = {
		val _localctx: Conditional_expressionContext = new Conditional_expressionContext(_ctx, getState())
		enterRule(_localctx, 212, RULE_conditional_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1204)
			logical_or_expression()
			setState(1211)
			_la = _input.LA(1)
			if (_la==QUESTION) {
				setState(1205)
				matchToken(QUESTION)
				setState(1207)
				_la = _input.LA(1)
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
					setState(1206)
					conditional_expression()
				}

				setState(1209)
				matchToken(COLON)
				setState(1210)
				conditional_expression()
			}

		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def constant_expression(): Constant_expressionContext = {
		val _localctx: Constant_expressionContext = new Constant_expressionContext(_ctx, getState())
		enterRule(_localctx, 214, RULE_constant_expression)
		try {
			enterOuterAlt(_localctx, 1)
			setState(1213)
			conditional_expression()
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def logical_or_expression(): Logical_or_expressionContext = {
		val _localctx: Logical_or_expressionContext = new Logical_or_expressionContext(_ctx, getState())
		enterRule(_localctx, 216, RULE_logical_or_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1215)
			logical_and_expression()
			setState(1220)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==OR) {
				setState(1216)
				matchToken(OR)
				setState(1217)
				logical_and_expression()
				setState(1222)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def logical_and_expression(): Logical_and_expressionContext = {
		val _localctx: Logical_and_expressionContext = new Logical_and_expressionContext(_ctx, getState())
		enterRule(_localctx, 218, RULE_logical_and_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1223)
			inclusive_or_expression()
			setState(1228)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==AND) {
				setState(1224)
				matchToken(AND)
				setState(1225)
				inclusive_or_expression()
				setState(1230)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def inclusive_or_expression(): Inclusive_or_expressionContext = {
		val _localctx: Inclusive_or_expressionContext = new Inclusive_or_expressionContext(_ctx, getState())
		enterRule(_localctx, 220, RULE_inclusive_or_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1231)
			exclusive_or_expression()
			setState(1236)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==BITOR) {
				setState(1232)
				matchToken(BITOR)
				setState(1233)
				exclusive_or_expression()
				setState(1238)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def exclusive_or_expression(): Exclusive_or_expressionContext = {
		val _localctx: Exclusive_or_expressionContext = new Exclusive_or_expressionContext(_ctx, getState())
		enterRule(_localctx, 222, RULE_exclusive_or_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1239)
			and_expression()
			setState(1244)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==CARET) {
				setState(1240)
				matchToken(CARET)
				setState(1241)
				and_expression()
				setState(1246)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def and_expression(): And_expressionContext = {
		val _localctx: And_expressionContext = new And_expressionContext(_ctx, getState())
		enterRule(_localctx, 224, RULE_and_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1247)
			equality_expression()
			setState(1252)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==BITAND) {
				setState(1248)
				matchToken(BITAND)
				setState(1249)
				equality_expression()
				setState(1254)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def equality_expression(): Equality_expressionContext = {
		val _localctx: Equality_expressionContext = new Equality_expressionContext(_ctx, getState())
		enterRule(_localctx, 226, RULE_equality_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1255)
			relational_expression()
			setState(1260)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==EQUAL || _la==NOTEQUAL) {
				setState(1256)
				_la = _input.LA(1)
				if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this)
				} else {
					consume()
				}
				setState(1257)
				relational_expression()
				setState(1262)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def relational_expression(): Relational_expressionContext = {
		val _localctx: Relational_expressionContext = new Relational_expressionContext(_ctx, getState())
		enterRule(_localctx, 228, RULE_relational_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1263)
			shift_expression()
			setState(1268)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (GT - 82)) | (1L << (LT - 82)) | (1L << (LE - 82)) | (1L << (GE - 82)))) != 0)) {
				setState(1264)
				_la = _input.LA(1)
				if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (GT - 82)) | (1L << (LT - 82)) | (1L << (LE - 82)) | (1L << (GE - 82)))) != 0)) ) {
				_errHandler.recoverInline(this)
				} else {
					consume()
				}
				setState(1265)
				shift_expression()
				setState(1270)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def shift_expression(): Shift_expressionContext = {
		val _localctx: Shift_expressionContext = new Shift_expressionContext(_ctx, getState())
		enterRule(_localctx, 230, RULE_shift_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1271)
			additive_expression()
			setState(1276)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==SHIFT_R || _la==SHIFT_L) {
				setState(1272)
				_la = _input.LA(1)
				if ( !(_la==SHIFT_R || _la==SHIFT_L) ) {
				_errHandler.recoverInline(this)
				} else {
					consume()
				}
				setState(1273)
				additive_expression()
				setState(1278)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def additive_expression(): Additive_expressionContext = {
		val _localctx: Additive_expressionContext = new Additive_expressionContext(_ctx, getState())
		enterRule(_localctx, 232, RULE_additive_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1279)
			multiplicative_expression()
			setState(1284)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==ADD || _la==SUB) {
				setState(1280)
				_la = _input.LA(1)
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this)
				} else {
					consume()
				}
				setState(1281)
				multiplicative_expression()
				setState(1286)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def multiplicative_expression(): Multiplicative_expressionContext = {
		val _localctx: Multiplicative_expressionContext = new Multiplicative_expressionContext(_ctx, getState())
		enterRule(_localctx, 234, RULE_multiplicative_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1287)
			cast_expression()
			setState(1292)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (MUL - 98)) | (1L << (DIV - 98)) | (1L << (MOD - 98)))) != 0)) {
				setState(1288)
				_la = _input.LA(1)
				if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (MUL - 98)) | (1L << (DIV - 98)) | (1L << (MOD - 98)))) != 0)) ) {
				_errHandler.recoverInline(this)
				} else {
					consume()
				}
				setState(1289)
				cast_expression()
				setState(1294)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def cast_expression(): Cast_expressionContext = {
		val _localctx: Cast_expressionContext = new Cast_expressionContext(_ctx, getState())
		enterRule(_localctx, 236, RULE_cast_expression)
		try {
			setState(1301)
			_errHandler.sync(this)
			( getInterpreter().adaptivePredict(_input,150,_ctx) ) match {
			case 1 =>
				enterOuterAlt(_localctx, 1)
				setState(1295)
				matchToken(LPAREN)
				setState(1296)
				type_name()
				setState(1297)
				matchToken(RPAREN)
				setState(1298)
				cast_expression()

			case 2 =>
				enterOuterAlt(_localctx, 2)
				setState(1300)
				unary_expression()

			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def unary_expression(): Unary_expressionContext = {
		val _localctx: Unary_expressionContext = new Unary_expressionContext(_ctx, getState())
		enterRule(_localctx, 238, RULE_unary_expression)
		try {
			setState(1319)
			(_input.LA(1)) match {
			case ENCODE =>
			case PROTOCOL =>
			case SELECTOR =>
			case SUPER =>
			case SELF =>
			case LPAREN =>
			case LBRACK =>
			case AT =>
			case CARET =>
			case IDENTIFIER =>
			case CHARACTER_LITERAL =>
			case STRING_LITERAL =>
			case HEX_LITERAL =>
			case DECIMAL_LITERAL =>
			case OCTAL_LITERAL =>
			case FLOATING_POINT_LITERAL =>
				enterOuterAlt(_localctx, 1)
				setState(1303)
				postfix_expression()

			case INC =>
				enterOuterAlt(_localctx, 2)
				setState(1304)
				matchToken(INC)
				setState(1305)
				unary_expression()

			case DEC =>
				enterOuterAlt(_localctx, 3)
				setState(1306)
				matchToken(DEC)
				setState(1307)
				unary_expression()

			case BANG =>
			case TILDE =>
			case SUB =>
			case MUL =>
			case BITAND =>
				enterOuterAlt(_localctx, 4)
				setState(1308)
				unary_operator()
				setState(1309)
				cast_expression()

			case SIZEOF =>
				enterOuterAlt(_localctx, 5)
				setState(1311)
				matchToken(SIZEOF)
				setState(1317)
				_errHandler.sync(this)
				( getInterpreter().adaptivePredict(_input,151,_ctx) ) match {
				case 1 =>
					setState(1312)
					matchToken(LPAREN)
					setState(1313)
					type_name()
					setState(1314)
					matchToken(RPAREN)

				case 2 =>
					setState(1316)
					unary_expression()

				}

			case _ =>
				throw new NoViableAltException(this)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def unary_operator(): Unary_operatorContext = {
		val _localctx: Unary_operatorContext = new Unary_operatorContext(_ctx, getState())
		enterRule(_localctx, 240, RULE_unary_operator)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1321)
			_la = _input.LA(1)
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (BANG - 84)) | (1L << (TILDE - 84)) | (1L << (SUB - 84)) | (1L << (MUL - 84)) | (1L << (BITAND - 84)))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def postfix_expression(): Postfix_expressionContext = {
		val _localctx: Postfix_expressionContext = new Postfix_expressionContext(_ctx, getState())
		enterRule(_localctx, 242, RULE_postfix_expression)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1323)
			primary_expression()
			setState(1341)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (DOT - 70)) | (1L << (STRUCTACCESS - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)))) != 0)) {
				setState(1339)
				(_input.LA(1)) match {
				case LBRACK =>
					setState(1324)
					matchToken(LBRACK)
					setState(1325)
					expression()
					setState(1326)
					matchToken(RBRACK)

				case LPAREN =>
					setState(1328)
					matchToken(LPAREN)
					setState(1330)
					_la = _input.LA(1)
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENCODE) | (1L << PROTOCOL) | (1L << SELECTOR) | (1L << SUPER) | (1L << SELF) | (1L << SIZEOF))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (LPAREN - 70)) | (1L << (LBRACK - 70)) | (1L << (AT - 70)) | (1L << (BANG - 70)) | (1L << (TILDE - 70)) | (1L << (INC - 70)) | (1L << (DEC - 70)) | (1L << (SUB - 70)) | (1L << (MUL - 70)) | (1L << (BITAND - 70)) | (1L << (CARET - 70)) | (1L << (IDENTIFIER - 70)) | (1L << (CHARACTER_LITERAL - 70)) | (1L << (STRING_LITERAL - 70)) | (1L << (HEX_LITERAL - 70)) | (1L << (DECIMAL_LITERAL - 70)) | (1L << (OCTAL_LITERAL - 70)) | (1L << (FLOATING_POINT_LITERAL - 70)))) != 0)) {
						setState(1329)
						argument_expression_list()
					}

					setState(1332)
					matchToken(RPAREN)

				case DOT =>
					setState(1333)
					matchToken(DOT)
					setState(1334)
					identifier()

				case STRUCTACCESS =>
					setState(1335)
					matchToken(STRUCTACCESS)
					setState(1336)
					identifier()

				case INC =>
					setState(1337)
					matchToken(INC)

				case DEC =>
					setState(1338)
					matchToken(DEC)

				case _ =>
					throw new NoViableAltException(this)
				}
				setState(1343)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def argument_expression_list(): Argument_expression_listContext = {
		val _localctx: Argument_expression_listContext = new Argument_expression_listContext(_ctx, getState())
		enterRule(_localctx, 244, RULE_argument_expression_list)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1344)
			assignment_expression()
			setState(1349)
			_errHandler.sync(this)
			_la = _input.LA(1)
			while (_la==COMMA) {
				setState(1345)
				matchToken(COMMA)
				setState(1346)
				assignment_expression()
				setState(1351)
				_errHandler.sync(this)
				_la = _input.LA(1)
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def identifier(): IdentifierContext = {
		val _localctx: IdentifierContext = new IdentifierContext(_ctx, getState())
		enterRule(_localctx, 246, RULE_identifier)
		try {
			enterOuterAlt(_localctx, 1)
			setState(1352)
			matchToken(IDENTIFIER)
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


	@throws(classOf[RecognitionException])
	final def constant(): ConstantContext = {
		val _localctx: ConstantContext = new ConstantContext(_ctx, getState())
		enterRule(_localctx, 248, RULE_constant)
		var _la = 0
		try {
			enterOuterAlt(_localctx, 1)
			setState(1354)
			_la = _input.LA(1)
			if ( !(((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (CHARACTER_LITERAL - 127)) | (1L << (HEX_LITERAL - 127)) | (1L << (DECIMAL_LITERAL - 127)) | (1L << (OCTAL_LITERAL - 127)) | (1L << (FLOATING_POINT_LITERAL - 127)))) != 0)) ) {
			_errHandler.recoverInline(this)
			} else {
				consume()
			}
		}
		catch {
		case re: RecognitionException =>
			_localctx.exception = re
			_errHandler.reportError(this, re)
			_errHandler.recover(this, re)
		}
		finally {
			exitRule()
		}
		_localctx
	}


}