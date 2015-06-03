class MyClass: NSObject, SomeProtocol {

    @IBOutlet var sampleLabel: UILabel!
    @IBOutlet var searchTypeButtons: [UIButton]!

    weak var sampleWeak: NSObject?

    var sampleCopy: NSObject?

    var sampleRetain: NSObject?

    var sampleGetter: Bool? {
        get {
            return true
        }
    }

    var sampleSetter: Int? {
        get {
            return self.sampleSetter
        }
        set {
            self.sampleSetter = 100
        }
    }

    var sampleGetterAndSetter: Int? {
        get {
            return 10
        }
        set {
            self.sampleGetterAndSetter = 30
        }
    }

    var sampleReadonly: NSObject? {
        get {
            return self.sampleReadonly
        }
    }

    var sampleDefaultGetter: NSString? {
        get {
            return "hoge"
        }
    }

    var sampleDefaultSetter: NSString? {
        get {
            return self.sampleDefaultSetter
        }
        set {
            self.sampleDefaultSetter = "hoge"
        }
    }

    var sampleDefaultGetterAndSetter: NSString? {
        get {
            return "fuga"
        }
        set {
            self.sampleDefaultGetterAndSetter = "fuga"
        }
    }

    weak var sampleDelegate: sampleProtocol1?

    weak var sampleDelegate2: protocol<sampleProtocol1, sampleProtocol2>

    var sampleStr: NSString?

    var sampleArray: [AnyObject]?

    var sampleBool: Bool?

    var sampleId: AnyObject?

    var sampleDictionary: [NSObject: AnyObject]?

    var sampleSelector: Selector?

    @IBOutlet var searchTypeScrollView: UIScrollView!

    @IBOutlet var searchTypeButtons: [UIButton]!

    var sourceViewController: UIViewController? {
        get {
            return _transitionContext.viewControllerForKey((!_reverse ? UITransitionContextFromViewControllerKey : UITransitionContextToViewControllerKey))
        }
    }

}
