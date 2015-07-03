package controllers

import play.api.mvc._

import org.objc2swift._

class Application extends Controller {

  private val defaultInput =
    """
      |@interface MyClass
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
      |@end
      |
    """.stripMargin

  def index = Action { implicit request =>
    val input = (for {
      form <- request.body.asFormUrlEncoded
      buff <- form.get("source")
      if (buff.length > 0)
    } yield buff(0)).getOrElse(defaultInput)

    val converter = new ObjC2SwiftConverter(input)
    val result = converter.getResult

    Ok(views.html.index("suzak", input, result))
  }
}
