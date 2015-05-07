@interface MyClass : NSObject <SomeProtocol>

@property(nonatomic, strong) IBOutlet UILabel *sampleLabel;

@property(nonatomic, copy) NSObject *sampleCopy;
@property (nonatomic, retain) NSObject *sampleRetain;

@property(nonatomic,readonly,getter=isSample) BOOL sampleGetter;
@property(nonatomic,setter=setSetter:)int sampleSetter;
@property(nonatomic,getter=getterFunc,setter=setterFunc:) int sampleGetterAndSetter;
@property (readonly) NSObject sampleReadonly;

@property (nonatomic, assign) id <sampleProtocol1> sampleDelegate;
@property (nonatomic, assign) id <sampleProtocol1, sampleProtocol2> sampleDelegate2;

@property(nonatomic) NSString *sampleStr;
@property(nonatomic) NSArray *sampleArray;
@property(nonatomic) BOOL sampleBool;
@property(nonatomic) id sampleId;
@property(nonatomic) NSDictionary sampleDictionary;
@property(nonatomic) SEL sampleSelector;

@end