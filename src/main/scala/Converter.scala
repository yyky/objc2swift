import ObjCParser._
import org.antlr.v4.runtime.{RuleContext, ParserRuleContext}
import org.antlr.v4.runtime.tree.{TerminalNode, ParseTree, ParseTreeProperty}
import collection.JavaConversions._

trait Converter extends ObjCBaseVisitor[String] {
  type TSContexts = scala.collection.mutable.Buffer[Type_specifierContext]

  object TerminalText {
    def unapply(node: TerminalNode): Option[String] = Option(node.getSymbol.getText)
  }

  object ClassNameText {
    def unapply(node: Class_nameContext): Option[String] = Option(node.getText)
  }

  val root: Translation_unitContext

  private val usSetters = new ParseTreeProperty[Boolean]()
  private val visited = new ParseTreeProperty[Boolean]()
  val indentString = " " * 4
  var isOptionalProtocol = false

  def getResult: String = visit(root)

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = for(i <- 0 until node.getChildCount) yield node.getChild(i)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String =
    nodes.map(visit).collect{ case s: String if !s.isEmpty => s }.mkString(glue)

  def indentLevel(node: ParserRuleContext): Int = {
    var level = 0
    var ptr: RuleContext = node

    while(ptr.parent != null) {
      ptr match {
        case _: External_declarationContext => level += 1
        case _: Compound_statementContext   => level += 1
        case _ =>
      }
      ptr = ptr.parent
      level
    }
    level
  }

  def indent(node: ParserRuleContext): String = indentString * indentLevel(node)

  override def visit(tree: ParseTree): String = {
    isVisited(tree) match {
      case true => ""
      case false =>
        setVisited(tree)
        super.visit(tree)
    }
  }

  /**
   * Returns if node was visited or not
   *
   * @param node parse tree
   * @return true if node was visited, otherwise false
   */
  def isVisited(node: ParseTree): Boolean = Option(visited.get(node)).getOrElse(false)

  def setVisited(node: ParseTree) {
    visited.put(node, true)
  }

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext] = {
    val className = classCtx.class_name.getText
    for {
      extDclCtx <- root.external_declaration
      implCtx <- Option(extDclCtx.class_implementation())
    } implCtx.class_name().getText match {
      case `className` => return Some(implCtx)
      case _ =>
    }
    None
  }

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext] = {
    val className = catCtx.class_name.getText
    val categoryName = catCtx.category_name.getText

    for {
      extDclCtx <- root.external_declaration
      implCtx <- Option(extDclCtx.category_implementation())
    } (implCtx.class_name.getText, implCtx.category_name.getText) match {
      case (`className`, `categoryName`) => return Some(implCtx)
      case _ =>
    }
    None
  }

  def findCorrespondingMethodDefinition(declCtx: Method_declarationContext): Option[Method_definitionContext] = {
    val selector = declCtx.method_selector.getText

    val implDefList = declCtx.parent.parent.parent match {
      case classCtx: Class_interfaceContext =>
        findCorrespondingClassImplementation(classCtx) match {
          case Some(implCtx) => implCtx.implementation_definition_list
          case None => return None
        }
      case catCtx: Category_interfaceContext =>
        findCorrespondingCategoryImplementation(catCtx) match {
          case Some(implCtx) => implCtx.implementation_definition_list
          case None => return None
        }
      case _ => return None
    }

    declCtx.parent match {
      case _: Instance_method_declarationContext =>
        implDefList.instance_method_definition.map(_.method_definition())
          .find(_.method_selector.getText == selector)
      case _: Class_method_declarationContext =>
        implDefList.class_method_definition.map(_.method_definition())
          .find(_.method_selector.getText == selector)
      case _ => None
    }
  }

  private def isProtocolScope(ctx: RuleContext): Boolean = ctx match {
    case _: Protocol_declarationContext => true
    case _: Protocol_declaration_listContext => true
    case _: External_declarationContext => false
    case c => isProtocolScope(c.parent)
  }

  def optional(node: ParserRuleContext): String =
    isProtocolScope(node) && isOptionalProtocol match {
      case true => "optional "
      case false => ""
    }

  override def visitTranslation_unit(ctx: Translation_unitContext): String =
    ctx.external_declaration().map(visit).filter(_ != "").mkString("\n\n")

  override def visitExternal_declaration(ctx: External_declarationContext): String =
    concatChildResults(ctx, "")

  /**
   * Returns concatenated number type text.
   * @param prefix Prefix text of current types.
   * @param ctx Current type_specifier context
   * @return Concatenated and translated number type text
   */
  private def concatNumberType(prefix: String, ctx: Type_specifierContext): String =
    (prefix, visit(ctx)) match {
      case ("unsigned", "Int8") => "UInt8"
      case ("unsigned", "Int")  => "UInt"
      case ("Int", "Int")       => "Int64"
      case ("UInt", "Int")      => "UInt64"
      case ("signed", t)        => t
      case (_, t) if !t.isEmpty => t
      case (_, _)               => prefix
    }

  /**
   * Return concatenated type text.
   * @param types List of type_specifier context
   * @return Concatenated and translated type text
   */
  def concatType(types: TSContexts): String =
    types.foldLeft("")(concatNumberType) match {
      case "unsigned" => "UInt"
      case s          => s
    }

  def isUSSetter(node: ParseTree) = {
    Option(usSetters.get(node)) match {
      case Some(flag) if flag => true
      case _ => false
    }
  }

  def setUSSetter(node: ParseTree) = {
    usSetters.put(node, true)
  }
}
