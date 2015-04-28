@interface MyClass : NSObject <SomeProtocol>

@property(nonatomic, strong) IBOutlet UILabel *label;

- (void)doSomething;
- (NSString *)somethingWithArg1:(id)arg1 arg2:(int)arg2;

+ (void)classMethod;

@end

@interface MyClass(Category1)

- (void)category1Method;

@end
