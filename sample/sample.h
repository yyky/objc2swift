@interface MyClass : NSObject <SomeProtocol>

@property(nonatomic, strong) IBOutlet UILabel *label;

- (void)doSomething;
- (NSString *)somethingWithArg1:(id)arg1 arg2:(int)arg2;

@end
