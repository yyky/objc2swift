class InstanceMethodSample : NSObject, Protocol1, Protocol2 {

    func noParamNoRet() {

    }

    func oneIntParamNoRet(p1: Int32) {

    }

    func twoIntParamsNoRet(n1: Int32, opt2 n2: Int32) {

    }

    func threeIntParamsNoRet(n1: Int32, opt2 n2: Int32, opt3 n3: Int32) {

    }

    func noParamIntRet() -> Int32 {

    }

    func oneIntParamIntRet(n1: Int32) -> Int32 {

    }

    func noParamUIntRet() -> UInt32 {

    }

    func noParamSIntRet() -> Int32 {

    }

    func oneUIntParamUIntRet(n1: UInt32) -> UInt32 {

    }

    func noParamIdRet() -> AnyObject {

    }

    func noParamNoRetHasBody() {
        

    }

    func someParamSomeRetHasBody(p1: ClassB) -> ClassA {
        

    }

    func noParamLongRet() -> Int32 {

    }

    func noParamULongRet() -> UInt32 {

    }

    func noParamLongLongRet() -> Int64 {

    }

    func noParamULongLongRet() -> UInt64 {

    }

    func noParamShortRet() -> Int8 {

    }

    func noParamUShortRet() -> UInt8 {

    }

    func noParamFloatRet() -> Float {

    }

    func noParamDoubleRet() -> Double {

    }

    func oneFloatParamFloatRet(p1: Float) -> Float {

    }

    func oneFloatParamOneDoubleParamDoubleRet(p1: Float, dnum p2: Double) -> Double {

    }

    func noParamNoRetNoDef() {
    }

    func noParamNSNumberRetHasBody() -> NSNumber {
        self.noParamIntRet()
        self.oneIntParamIntRet(1)

    }

    func noParamNSStringRet() -> NSString {

    }

    func oneNSStringParamNSStringRet(p1: NSString) -> NSString {

    }

    func overloadSample(p1: NSString) -> NSString {

    }

    func overloadSample(p1: NSString, p2: NSString) -> NSString {

    }

    func overloadSample(p1: NSString, q2: NSNumber) -> NSString {

    }

    func extNameSample1(p1: NSString, p2: NSNumber) -> NSString {

    }

    func extNameSample2(p1: NSString, p2: NSNumber) -> NSString {

    }

    func extNameSample3(p1: NSString, pp p2: NSNumber) -> NSString {

    }

    func noParamNoRetNoDef2() {
    }

    private func privateMethodSample(p1: NSString, pp p2: NSNumber) -> NSString {

    }

    private func privateMethodSampleHasBody(p1: NSString, pp p2: NSNumber) -> NSString {
        self.noParamIntRet()
        self.oneIntParamIntRet(1)

    }

}
