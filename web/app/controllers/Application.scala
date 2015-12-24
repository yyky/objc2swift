package controllers

import play.api.mvc._

import jp.co.yahoo.objc2swift.converter.ObjC2SwiftConverter

class Application extends Controller {

  val MaxSourceLength = 30000

  def index = Action { implicit request =>
    val version = ObjC2SwiftConverter.Version
    val input = DefaultInput
    val result = convertSource(input)
    Ok(views.html.index(version, input, result))
  }

  def convert = Action { implicit request =>
    if (isValidAccess) {
      val result = {
        for {
          form <- request.body.asFormUrlEncoded
          input <- form.get("source").flatMap(_.headOption)
        } yield {
          if(input.size <= MaxSourceLength)
            convertSource(input)
          else
            TooLong
        }
      } getOrElse "invalid access."

      Ok(result).as(HTML)
    } else {
      Forbidden
    }
  }

  private def isValidAccess(implicit request: Request[AnyContent]): Boolean = {
    request.headers.get("referer").map(_.contains(request.host)).exists(identity)
  }


  private def convertSource(source: String): String = {
    val parser = ObjC2SwiftConverter.generateParser(source)
    val converter = new ObjC2SwiftConverter(parser)
    converter.getResult()
  }

  private val DefaultInput =
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

  private val TooLong =
    """Input code is too long :(
      |Please run this app in your environment.
      |
      |https://github.com/yahoojapan/objc2swift
    """.stripMargin

}
