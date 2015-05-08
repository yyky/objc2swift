#import <Foundation/Foundation.h>

typedef enum : NSUInteger {
    YSSSearchTypeDefault,
    YSSSearchTypeWeb,
    YSSSearchTypeImage,
    YSSSearchTypeVideo,
    YSSSearchTypeTweet,
    YSSSearchTypeNews,
    YSSSearchTypeMatome,
    YSSSearchTypeOther = 99,
} YSSSearchType;

/*
typedef enum CTRAdPosition : NSUInteger {
    CTRAdPositionViewTop = 0,
    CTRAdPositionViewBottom
} CTRAdPosition;
*/

typedef NS_ENUM(NSInteger, CTRAdPosition) {
    CTRAdPositionViewTop = 0,
    CTRAdPositionViewBottom
};

typedef NS_OPTIONS(NSUInteger, CTRAdType) {
    CTRAdTypeNone   = 0,
    CTRAdTypeIAd    = 1 << 0,
    CTRAdTypeAdMob  = 1 << 1,
    CTRAdTypeHomeAd = 1 << 2,
};
