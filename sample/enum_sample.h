enum OBJCEnumSampleA {
    OBJCEnumSampleA0 = 0,
    OBJCEnumSampleA1,
    OBJCEnumSampleA2,
};

typedef enum {
    OBJCEnumSampleB0,
    OBJCEnumSampleB1,
    OBJCEnumSampleB2,
} OBJCEnumSampleB;

typedef enum : NSUInteger {
    OBJCEnumSampleC0,
    OBJCEnumSampleC1,
    OBJCEnumSampleC2,
    OBJCEnumSampleC3,
    OBJCEnumSampleC4,
    OBJCEnumSampleC5,
    OBJCEnumSampleC6,
    OBJCEnumSampleC99 = 99,
} OBJCEnumSampleC;

typedef NS_ENUM(NSInteger, OBJCEnumSampleD) {
	OBJCEnumSampleD0 = 0,
	OBJCEnumSampleD42 = 42
};

typedef NS_OPTIONS(NSUInteger, OBJCEnumSampleE) {
	OBJCEnumSampleE0 = 0,
	OBJCEnumSampleE1 = 1 << 0,
	OBJCEnumSampleE2 = 1 << 1,
	OBJCEnumSampleE4 = 1 << 2,
};

/*
typedef enum CTRAdPosition : NSUInteger {
    CTRAdPositionViewTop = 0,
    CTRAdPositionViewBottom
} CTRAdPosition;
*/
