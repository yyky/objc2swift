@interface MyClass()

- (void)privateMethod;

@end

@implementation MyClass

- (void)doSomething
{
    [self somethingWithArg1:@"hello" arg2:0];
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

@end

@implementation MyClass(Category1)

- (void)category1Method
{
}

@end
