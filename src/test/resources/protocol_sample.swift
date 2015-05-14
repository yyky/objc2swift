protocol SimpleProtocol {
}

protocol ExtendedProtocol : SimpleProtocol {
}

protocol SimpleProtocol2 {
}

protocol ExtendedProtocol2 : SimpleProtocol, SimpleProtocol2 {
}

protocol SimpleMethodProtocol {
    func simpleMethod()

    func simpleMethod2() -> Int32
}

protocol ComplexMethodProtocol {
    func mouseDragged(theEvent: NSEvent)

    class func initFromXMLRepresentation(XMLElement: NSXMLElement) -> AnyObject
}

protocol OptionalProtocol {
    func requiredMethod() -> Int32
    optional func optionalMethod() -> Int32
}

protocol OptionalProtocol2 {
    func optionalMethod1() -> Int32

    func optionalMethod2() -> Int32
    optional func optionalMethod3() -> Int32
}

protocol XYZPieChartViewDataSource {
    func numberOfSegments() -> Int

    func sizeOfSegmentAtIndex(segmentIndex: Int) -> CGFloat
    optional func titleForSegmentAtIndex(segmentIndex: Int) -> NSString

    optional func shouldExplodeSegmentAtIndex(segmentIndex: Int) -> Bool
    func colorForSegmentAtIndex(segmentIndex: Int) -> UIColor
}
