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
    func numberOfSegments() -> UInt32

    func sizeOfSegmentAtIndex(segmentIndex: UInt32) -> CGFloat
    optional func titleForSegmentAtIndex(segmentIndex: UInt32) -> NSString

    optional func shouldExplodeSegmentAtIndex(segmentIndex: UInt32) -> Bool
    func colorForSegmentAtIndex(segmentIndex: UInt32) -> UIColor
}
