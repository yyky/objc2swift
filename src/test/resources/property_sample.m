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

-(NSString *)sampleDefaultGetter{
  return @"hoge";
}

-(void)setSampleDefaultSetter:(NSString *)sampleDefaultSetter{
  _sampleDefaultSetter = @"hoge";
}

-(NSString *)sampleDefaultGetterAndSetter{
  return @"fuga";
}

-(void)setSampleDefaultGetterAndSetter:(NSString *)sampleDefaultGetterAndSetter{
  _sampleDefaultGetterAndSetter = @"fuga";
}

- (UIViewController *)sourceViewController
{
  return [_transitionContext viewControllerForKey:(!_reverse ? UITransitionContextFromViewControllerKey : UITransitionContextToViewControllerKey)];
}
@end
