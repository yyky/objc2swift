class MyClass : NSObject, SomeProtocol {

    @IBOutlet  var sampleLabel:UILabel!

    var sampleCopy:NSObject?

    var sampleRetain:NSObject?

    var sampleGetter:Bool?{ get{} }

    var sampleReadonly:NSObject?{ get{} }

    unowned(unsafe) var sampleDelegate:sampleProtocol1?

    unowned(unsafe) var sampleDelegate2:protocol<sampleProtocol1,sampleProtocol2>

    var sampleStr:NSString?

    var sampleArray:[AnyObject]?

    var sampleBool:Bool?

    var sampleId:AnyObject?

    var sampleDictionary:[NSObject : AnyObject]?

    var sampleSelector:Selector?


}
