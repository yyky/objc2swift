@interface MyClass()

@property (nonatomic, readwrite) BOOL loadingContentInfo;
@property NSString *privateProp;

- (void)privateMethod;

@end

@implementation MyClass

- (void)doSomething
{
    [self somethingWithArg1:@"hello" arg2:0];

    return [NSURL URLWithString:kYSSWebPageCaptureEndpointURL
                  getParams:@{
                      @"url": URL.absoluteString,
                      @"w": @(size.width),
                      @"h": @(size.height),
                      @"s": @"s",
                      @"device": iPhone() ? @"sp" : @"tb",
                      @"width":@(width * kStaticMapRatio)
                  }];
}

- (NSString *)somethingWithArg1:(id)arg1 arg2:(int)arg2
{
    return @"something";
}

+ (void)classMethod
{
    @"classMethod";
}

- (void)privateMethod
{
    @"private";
}

//- (void)funcA:(NSString *)p1 p2:(void (^)(id, NSError *))p2
//{
//}

- (NSURL *)faviconURL
{
    return _faviconURL ?: _linkURL ? [YSSURLGenerator faviconURLForURL:_linkURL] : nil;
}

@end

@implementation MyClass(Category1)

- (void)category1Method
{
}

@end
