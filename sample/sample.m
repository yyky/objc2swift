@implementation MyClass

- (void)hoge {
	[self hello];
	[self hello:1];
	[self helloWithInt:1 string:@"str"];
}

- (void)hogeWithInt:(int)n {
}

- (void)hogeWithInt:(int)n string:(NSString *)str {
}

@end
