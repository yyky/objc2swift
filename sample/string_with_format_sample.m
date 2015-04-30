@implementation StringWithFormatSample

- (NSString *)stringWithFormatTest {
    [NSString stringWithFormat:@"int型：%d", num];
    [NSString stringWithFormat:@"%02i:%02i:%02i", hour, min, sec];
    [NSString stringWithFormat:@"double型：%f", x];
    [NSString stringWithFormat:@"double型：%.1f", f];
    [NSString stringWithFormat:@"%@ %@", rawResult[@"FirstName"], rawResult[@"LastName"]];
    [NSString stringWithFormat:@"NSArray型：%@", ary];
    [[NSString alloc]initWithFormat:@"文字列：%ld", n];
}

@end
