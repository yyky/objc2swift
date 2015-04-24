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
}
+ (double)oneFloatParamOneDoubleParamDoubleRet:(float)p1 dnum:(double)p2 {
    return p2;
}
@end
