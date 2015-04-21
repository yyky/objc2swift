@implementation MyClass

- (void)doSomething
{
    [self somethingWithArg1:nil arg2:0];
}

- (NSString *)somethingWithArg1:(id)arg1 arg2:(int)arg2
{
    return @"something";
}

@end
