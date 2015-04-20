@interface InstanceMethodSample : NSObject<Protocol1, Protocol2>

- (void)NoParamNoRet;
- (void)oneIntParamNoRet:(int)p1;
- (void)twoIntParamsNoRet:(int)n1 opt2:(int)n2;
- (void)threeIntParamsNoRet:(int)n1 opt2:(int)n2 opt3:(int)n3;
- (int)noParamIntRet;
- (int)oneIntParamIntRet:(int)n1;
- (unsigned int)noParamUIntRet;
- (signed int)noParamSIntRet;
- (unsigned int)oneUIntParamUIntRet:(unsigned int)n1;
- NoParamIdRet;
- (void)NoParamNoRetHasBody;
- (ClassA)SomeParamSomeRet:(ClassB)p1;
- (long)noParamLongRet;

@end