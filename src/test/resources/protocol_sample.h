@protocol SimpleProtocol
@end

@protocol ExtendedProtocol <SimpleProtocol>
@end

@protocol SimpleProtocol2
@end

@protocol ExtendedProtocol2 <SimpleProtocol, SimpleProtocol2>
@end

@protocol SimpleMethodProtocol
- (void)simpleMethod;
- (int)simpleMethod2;
@end

@protocol ComplexMethodProtocol
- (void)mouseDragged:(NSEvent *)theEvent;
+ initFromXMLRepresentation:(NSXMLElement *)XMLElement;
@end

@protocol OptionalProtocol
- (int)requiredMethod;
@optional
- (int)optionalMethod;
@end

@protocol OptionalProtocol2
@required
- (int)optionalMethod1;
- (int)optionalMethod2;
@optional
- (int)optionalMethod3;
@end

@protocol XYZPieChartViewDataSource
- (NSUInteger)numberOfSegments;
- (CGFloat)sizeOfSegmentAtIndex:(NSUInteger)segmentIndex;
@optional
- (NSString *)titleForSegmentAtIndex:(NSUInteger)segmentIndex;
- (BOOL)shouldExplodeSegmentAtIndex:(NSUInteger)segmentIndex;
@required
- (UIColor *)colorForSegmentAtIndex:(NSUInteger)segmentIndex;
@end

@protocol ExternalProtocol;
