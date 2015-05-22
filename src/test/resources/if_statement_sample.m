@implementation IfStatementSample

- (void)fuga {
  if ( a == 0 ) {
    b = a * b - 1 / a;
  }
  if ( a > 2) {
    b = 2;
  }
  if (a <= 1 ) {
    b = 3;
  }
  if( a && b ){
    b = 1;
  }
  if (x && y)
    a = b + c;
  if (a) {
    b = 1;
    if (b) {
       c = d;
    }
  }
  if([comps containsObject:@"画像"])
    return YSSSearchTypeImage;
  else if([comps containsObject:@"動画"])
    return YSSSearchTypeVideo;
  else
    return YSSSearchTypeDefault;
}

@end
