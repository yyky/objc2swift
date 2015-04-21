@interface MyClass : NSObject <SomeProtocol>

@property(nonatomic, strong) IBOutlet UILabel *sampleLabel;

@property(nonatomic,copy) NSString *sampleStr;
@property (nonatomic, retain) NSObject *sampleObj;

@property(nonatomic,readonly,getter=isSample) BOOL sampleBool;
@property (readonly) NSInteger sampleInteger;

@property (nonatomic, assign) id <sampleProtocol> sampleDelegate;
@end