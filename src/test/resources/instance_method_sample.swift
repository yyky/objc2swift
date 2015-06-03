class InstanceMethodSample: NSObject, Protocol1, Protocol2 {

    func noParamNoRet() {

    }

    func oneIntParamNoRet(p1: Int) {

    }

    func twoIntParamsNoRet(n1: Int, opt2 n2: Int) {

    }

    func threeIntParamsNoRet(n1: Int, opt2 n2: Int, opt3 n3: Int) {

    }

    func noParamIntRet() -> Int {

    }

    func oneIntParamIntRet(n1: Int) -> Int {

    }

    func noParamUIntRet() -> UInt {

    }

    func noParamSIntRet() -> Int {

    }

    func oneUIntParamUIntRet(n1: UInt) -> UInt {

    }

    func noParamIdRet() -> AnyObject {

    }

    func noParamNoRetHasBody() {
        

    }

    func someParamSomeRetHasBody(p1: ClassB) -> ClassA {
        

    }

    func noParamLongRet() -> Int {

    }

    func noParamULongRet() -> UInt {

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

    func privateMethodSample(p1: NSString, pp p2: NSNumber) -> NSString {

    }

    func privateMethodSampleHasBody(p1: NSString, pp p2: NSNumber) -> NSString {
        self.noParamIntRet()
        self.oneIntParamIntRet(1)

    }

    func tableView(tableView: UITableView, titleForHeaderInSection section: Int) -> NSString {
        return nil
    }

    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.shouldShowSection(section) ? self.numberOfQueriesInSection(section) : 0
    }

    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return 44
    }

    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        var reuseId: NSString = (indexPath.section == YSSSearchPanelSectionFavorite) ? kFavKeywordCellIdentifier : kDefaultCellIdentifier
        var cell: YSSSearchPanelTableViewCell = tableView.dequeueReusableCellWithIdentifier(reuseId)
        cell.searchPanelViewController = self
        cell.query = self.queryAtIndexPath(indexPath)
        return cell
    }
}
