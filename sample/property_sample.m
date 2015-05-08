@interface PropertySample () {
}
@end

@implementation PropertySample

- (BOOL)isSample{
    return YES;
}

-(void)setSetter:(int)sampleSetter{
    _sampleSetter = 100;
}

-(int)getterFunc{
    return 10;
}

-(void)setterFunc:(int)sampleGetterAndSetter{
    _sampleGetterAndSetter = 30;
}

@end
