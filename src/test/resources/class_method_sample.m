@implementation ClassMethodSample
+ (void)classMethodHasDef {
    if (x < y) {
        z = x;
    }
}
+ (void)privateClassMethodHasDef {
    if (x > y) {
        z = y;
    }
    return;
}
+ (double)oneFloatParamOneDoubleParamDoubleRet:(float)p1 dnum:(double)p2 {
    return p2;
}
+ (void)sameNameMethod:(int)p1 {
}
- (void)sameNameMethod:(int)p1 {
}
+ (void)sameNamePrivateMethod:(int)p1 {
}
- (void)sameNamePrivateMethod:(int)p1 {
}
@end
