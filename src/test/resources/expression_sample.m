@implementation ExpressionSample
- (void)sampleExpressions
{
    1 + 2;
    1 - 2;
    1 * 2;
    1 / 2;
    1 % 2;
    1 + 2 - 3 * 4 / 5 % 6;
    1 + (2 - 3 * 4) / (5 % 6);
    ((1 + 2) - (3 * 4)) / 5 % 6;
    a = b;
    a += b;
    a -= b;
    a *= b;
    a /= b;
    a %= b;
    a++;
    a--;
    ++a;
    --a;
    -a;
    x ? y : z;
    a == b;
    a != b;
    a > b;
    a < b;
    a >= b;
    a <= b;
    a && b;
    a || b;
    !a;
    a && (b || c);
    x = y & z;
    x = y | z;
    x = y ^ z;
    x = ~y;
    x = y << z;
    x = y >> z;
    button.size = CGSizeMake(32, 44);
    x = y ?: z;
    NSArray *a1 = @[@"value1", @"value2", @"value3"];
    NSMutableArray *a2 = [@[@"value4", @"value5", @"value6"] mutableCopy];
    NSString *item1 = a1[0];
    a2[0] = @"value7";
    NSDictionary *dic1 = @{@"key1":@"value1",
                           @"key2":@"value2",
                           @"key3":@"value3"};
    NSMutableDictionary *dic2 = [@{@"key4":@"value4",
                                   @"key5":@"value5",
                                   @"key6":@"value6"}
                                mutableCopy];
    NSString *item2 = dic1[@"key1"];
    dic2[@"key1"] = @"updateValue1";
    NSDictionary *dic3 = @{
                             @"url": URL.absoluteString,
                             @"w": @(size.width),
                             @"h": @(size.height),
                             @"s": @"s",
                             @"device": iPhone() ? @"sp" : @"tb"
                         };
    x = @"CONSTANT_VALUE";
    x = @(a);
    x = @(a + b);
    NSNumber *smallestInt = @(-INT_MAX - 1);
    NSNumber *piOverTwo = @(M_PI / 2);

    // initializer
    YSSSearchResultSet *resultSet = [[YSSSearchResultSet alloc] init];
    MyClass *myClass = [[MyClass alloc]initWithName:@"Snoopy"];
    UIMenuController.sharedMenuController.menuItems = @[[[UIMenuItem alloc] initWithTitle:@"検索" action:@selector(search:)]];

    /**
     * TODO: Invalid conversion
     *
     * ObjC
     * ```
     * int (^power)(int) = ^(int x) {
     *   return x * x;
     * };
     * ```
     * ↓
     * Swift
     * ```
     * var power: (Int32) -> Int32 = {(x: Int32) -> Int32 in
     *     return x * x
     * }
     * ```
     */
     //int (^power)(int) = ^(int x) {
     //  return x * x;
     //};
}
@end