@implementation MyClassControll

- (void)fuga {
  int a = 0;
  int b = 0;

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

  for (a = 10; a > 0; a--)
    b -= 1;

  for (a = 0; a < 10; a++) {
    b *= 2;
    c *= 3;
  }

  while (a < 10) {
    ++a;
  }

  while (b != 1)
    b = b * b - b;

  while (!c) {
    c = d;
    d = e;
  }

  do {
   b++;
  } while (b < 10);

  for(NSString *str in array){
    NSLog(str);
  }

  for (int i = 0; i < 10; i++) {
    for (int j = 0, k = 1; j < 5; j++) {
      foo = [self hoge];
    }
  }
}

@end
