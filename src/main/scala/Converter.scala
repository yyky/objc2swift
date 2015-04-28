import ObjCParser._
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import collection.JavaConversions._

trait Converter extends ObjCBaseVisitor[String] {

  val root: Translation_unitContext

  private val visited = new ParseTreeProperty[Boolean]()
  val indentString = " " * 4

  def getResult: String = visit(root)

  def concatChildResults(node: ParseTree, glue: String): String = {
    val children = for(i <- 0 until node.getChildCount) yield node.getChild(i)
    concatResults(children.toList, glue)
  }

  def concatResults(nodes: List[ParseTree], glue: String): String =
    nodes.map(visit).filter(s => s != null && s != "").mkString(glue)

  def indentLevel(node: ParserRuleContext): Int = {
    node.depth() match {
      case n if n < 4 => 0 // class
      case n if n < 8 => 1 // method
      case _ => 2 // TODO count number of compound_statement's
    }
  }

  def indent(node: ParserRuleContext): String = {
    indentString * indentLevel(node)
  }

  override def visit(tree: ParseTree): String = {
    isVisited(tree) match {
      case true => ""
      case false =>
        setVisited(tree)
        super.visit(tree)
    }
  }

  def isVisited(node: ParseTree) = {
    Option(visited.get(node)) match {
      case Some(flag) if flag => true
      case _ => false
    }
  }

  def setVisited(node: ParseTree) = {
    visited.put(node, true)
  }

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext] = {
    val className = classCtx.class_name.getText
    for(extDclCtx <- root.external_declaration) {
      Option(extDclCtx.class_implementation) match {
        case Some(implCtx) =>
          implCtx.class_name.getText match {
            case `className` => return Some(implCtx)
            case _ =>
          }
        case None =>
      }
    }
    None
  }

  def findCorrespondingCategoryImplementation(catCtx: Category_interfaceContext): Option[Category_implementationContext] = {
    val className = catCtx.class_name.getText
    val categoryName = catCtx.category_name.getText

    if(categoryName == null)
      return None

    for(extDclCtx <- root.external_declaration) {
      Option(extDclCtx.category_implementation) match {
        case Some(implCtx) =>
          (implCtx.class_name.getText, implCtx.category_name.getText) match {
            case (`className`, `categoryName`) => return Some(implCtx)
            case _ =>
          }
        case None =>
      }
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
        implDefList.instance_method_definition.map(_.method_definition()).find(_.method_selector.getText == selector)
      case _: Class_method_declarationContext =>
        implDefList.class_method_definition   .map(_.method_definition()).find(_.method_selector.getText == selector)
      case _ =>
        None
    }
  }

  override def visitTranslation_unit(ctx: Translation_unitContext): String = {
    concatChildResults(ctx, "\n\n")
  }

  override def visitExternal_declaration(ctx: External_declarationContext): String = {
    concatChildResults(ctx, "")
  }
}
