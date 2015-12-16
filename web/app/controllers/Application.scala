package controllers

import play.api.mvc._

import org.objc2swift.converter.ObjC2SwiftConverter

class Application extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index("objc2swift-web", defaultInput, convertSource(defaultInput)))
  }

  def convert = Action { implicit request =>
    val result = {
      for {
        form <- request.body.asFormUrlEncoded
        input <- form.get("source").flatMap(_.headOption)
      } yield convertSource(input)
    } getOrElse ""

    Ok(result).as(HTML)
  }

  private def convertSource(source: String): String = {
    val parser = ObjC2SwiftConverter.generateParser(source)
    val converter = new ObjC2SwiftConverter(parser)
    converter.getResult()
  }

  private val defaultInput =
    """@interface MyClass
      |
      |- (void)sayHello;
      |
      |@end
      |
      |@implementation MyClass
      |
      |- (void)sayHello{
      |    NSLog(@"Hello Swift, Goodbye Obj-C!");
      |}
      |
      |@end""".stripMargin

}
