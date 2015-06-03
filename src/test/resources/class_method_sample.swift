class ClassMethodSample: NSObject, Protocol1, Protocol2 {

    class func classMethodNoDef() {
    }

    class func classMethodNoDef2(num: Int) -> Int {
    }

    class func classMethodHasDef() {
        if x < y {
            z = x
        }


    }

    class func oneFloatParamOneDoubleParamDoubleRet(p1: Float, dnum p2: Double) -> Double {
        return p2

    }

    class func sameNameMethod(p1: Int) {

    }

    func sameNameMethod(p1: Int) {

    }

    class func privateClassMethodHasDef() {
        if x > y {
            z = y
        }
        return
    }

    class func sameNamePrivateMethod(p1: Int) {

    }

    func sameNamePrivateMethod(p1: Int) {

    }

}
