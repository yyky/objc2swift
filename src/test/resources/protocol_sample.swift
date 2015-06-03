protocol SimpleProtocol {
}

protocol ExtendedProtocol: SimpleProtocol {
}

protocol SimpleProtocol2 {
}

protocol ExtendedProtocol2: SimpleProtocol, SimpleProtocol2 {
}

protocol SimpleMethodProtocol {
    func simpleMethod()

    func simpleMethod2() -> Int
}

protocol ComplexMethodProtocol {
    func mouseDragged(theEvent: NSEvent)

    class func initFromXMLRepresentation(XMLElement: NSXMLElement) -> AnyObject
}

protocol OptionalProtocol {
    func requiredMethod() -> Int
    optional func optionalMethod() -> Int
}

protocol OptionalProtocol2 {
    func optionalMethod1() -> Int

    func optionalMethod2() -> Int
    optional func optionalMethod3() -> Int
}

protocol XYZPieChartViewDataSource {
    func numberOfSegments() -> UInt

    func sizeOfSegmentAtIndex(segmentIndex: UInt) -> CGFloat
    optional func titleForSegmentAtIndex(segmentIndex: UInt) -> NSString

    optional func shouldExplodeSegmentAtIndex(segmentIndex: UInt) -> Bool
    func colorForSegmentAtIndex(segmentIndex: UInt) -> UIColor
}
