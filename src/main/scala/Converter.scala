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
    nodes.map(visit).filter(_ != null).mkString(glue)

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
    setVisited(tree)
    super.visit(tree)
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

  def findCorrespondingMethodDefinition(declCtx: Method_declarationContext): Option[Method_definitionContext] = {
    val classCtx = declCtx.parent.parent.parent.asInstanceOf[Class_interfaceContext]

    findCorrespondingClassImplementation(classCtx) match {
      case None =>
      case Some(implCtx) =>
        declCtx.parent match {
          case p: Instance_method_declarationContext =>
            for (ctx <- implCtx.implementation_definition_list.children if ctx.isInstanceOf[Instance_method_definitionContext]) {
              val defCtx = ctx.asInstanceOf[Instance_method_definitionContext]
              if (defCtx.method_definition.method_selector.getText == declCtx.method_selector.getText)
                return Some(defCtx.method_definition())
            }
          case p: Class_method_declarationContext =>
            for (ctx <- implCtx.implementation_definition_list.children if ctx.isInstanceOf[Class_method_definitionContext]) {
              val defCtx = ctx.asInstanceOf[Class_method_definitionContext]
              if (defCtx.method_definition.method_selector.getText == declCtx.method_selector.getText)
                return Some(defCtx.method_definition())
            }
          //case p: Class_method_declarationContext => None
          case _ =>
        }
    }
    None
  }
}
