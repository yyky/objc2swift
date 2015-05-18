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
    NSNumber *smallestInt = @(-INT_MAX - 1);
    NSNumber *piOverTwo = @(M_PI / 2);
    int (^power)(int) = ^(int x) {
        return x * x;
    };
}
@end