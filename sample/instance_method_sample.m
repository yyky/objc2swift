@interface InstanceMethodSample () {
}
@end

@implementation InstanceMethodSample
- (void)noParamNoRet {
}

- (void)oneIntParamNoRet:(int)p1 {
}

- (void)twoIntParamsNoRet:(int)n1 opt2:(int)n2 {
}

- (void)threeIntParamsNoRet:(int)n1 opt2:(int)n2 opt3:(int)n3 {
}

- (int)noParamIntRet {
}

- (int)oneIntParamIntRet:(int)n1 {
}

- (unsigned int)noParamUIntRet {
}

- (signed int)noParamSIntRet {
}

- (unsigned int)oneUIntParamUIntRet:(unsigned int)n1 {
}

- noParamIdRet {
}

- (void)noParamNoRetHasBody {
    ;
}

- (ClassA)someParamSomeRetHasBody:(ClassB)p1 {
    ;
}

- (long)noParamLongRet {
}

- (unsigned long)noParamULongRet {
}

- (long long)noParamLongLongRet {
}

- (unsigned long long)noParamULongLongRet {
}

- (short)noParamShortRet {
}

- (unsigned short)noParamUShortRet {
}

- (float)noParamFloatRet {
}

- (double)noParamDoubleRet {
}

- (float)oneFloatParamFloatRet:(float)p1 {
}

- (double)oneFloatParamOneDoubleParamDoubleRet:(float)p1 dnum:(double)p2 {
}

- (NSNumber *)noParamNSNumberRetHasBody {
    [self noParamIntRet];
    [self oneIntParamIntRet:1];
}

- (NSString *)noParamNSStringRet {
}

- (NSString *)oneNSStringParamNSStringRet:(NSString *)p1 {
}

- (NSString *)overloadSample:(NSString *)p1 {
}

- (NSString *)overloadSample:(NSString *)p1 p2:(NSString *)p2 {
}

- (NSString *)overloadSample:(NSString *)p1 q2:(NSNumber *)q2 {
}

- (NSString *)extNameSample1:(NSString *)p1 :(NSNumber *)p2 {
}

- (NSString *)extNameSample2:(NSString *)p1 p2:(NSNumber *)p2 {
}

- (NSString *)extNameSample3:(NSString *)p1 pp:(NSNumber *)p2 {
}

- (NSString *)privateMethodSample:(NSString *)p1 pp:(NSNumber *)p2 {
}

- (NSString *)privateMethodSampleHasBody:(NSString *)p1 pp:(NSNumber *)p2 {
    [self noParamIntRet];
    [self oneIntParamIntRet:1];
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section {
    return nil;
}

@end
