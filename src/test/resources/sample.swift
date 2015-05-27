class MyClass : NSObject, SomeProtocol {

    @IBOutlet var label:UILabel!

    func doSomething() {
        self.somethingWithArg1("hello", arg2: 0)

    }

    func somethingWithArg1(arg1: AnyObject, arg2: Int32) -> NSString {
        return "something"

    }

    class func classMethod() {
        "classMethod"

    }

    func privateMethod() {
        "private"

    }

}

extension MyClass {
    func category1Method() {

    }


}
