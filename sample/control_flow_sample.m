@implementation MyClassControll

- (void)fuga {
  int a = 0;
  int b = 0;
  if ( a == 0 ) {
    b = a * b - 1 / a;
  }
  if ( a > 2) {
    b = 2;
  }
  if ( a <= 1) {
    b = 3;
  }
  if ( a && b ) {
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
  for (a = 0; a < 10; a++) {
    b += 1;
  }
  while (a < 10) {
    ++a;
  }
  do {
   b++;
  } while (b < 10);

  for(NSString *str in array){
    NSLog(str);
  }
}

@end
