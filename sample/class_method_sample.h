@interface ClassMethodSample : NSObject<Protocol1, Protocol2>
+ (void)classMethodNoDef;
+ (long)classMethodNoDef2:(int)num;
+ (void)classMethodHasDef;
+ (double)oneFloatParamOneDoubleParamDoubleRet:(float)p1 dnum:(double)p2;
+ (void)sameNameMethod:(int)p1;
- (void)sameNameMethod:(int)p1;
@end
