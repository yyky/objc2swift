@implementation MyClassControll

- (void)fuga {
  int a = 0;
  int b = 0;
  if ( a == 0 ) {
    b = 1;
  }
  switch (a) {
  case 0:
    b = 1;
    break;
  case 1:
    b = 0;
    break;
  default:
    b = 2;
    break;
  }
}

@end
