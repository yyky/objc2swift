import ObjCParser._
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}
import collection.JavaConversions._

trait Converter {
  self: ObjCBaseVisitor[String] =>

  val root: Translation_unitContext

  val visited = new ParseTreeProperty[Boolean]()
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

  def findCorrespondingClassImplementation(classCtx: Class_interfaceContext): Option[Class_implementationContext] = {
    val list = root.external_declaration
    for (extDclCtx <- list) {
      for (ctx <- extDclCtx.children if ctx.isInstanceOf[Class_implementationContext]) {
        val implCtx = ctx.asInstanceOf[Class_implementationContext]
        if(implCtx.class_name.getText == classCtx.class_name.getText)
          return Some(implCtx)
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
