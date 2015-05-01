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
