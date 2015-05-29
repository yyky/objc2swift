//
//  YSSWeatherEntity.h
//  YSmartSearch
//
//  Created by takesano on 2014/02/10.
//  Copyright (c) 2014年 Yahoo! Japan. All rights reserved.
//

#import "YSSWebContentEntity.h"

@interface YSSWeatherEntity : YSSWebContentEntity

@property (nonatomic) NSString *pointName;
@property (nonatomic) NSDate *refTime;
@property (nonatomic) NSArray *daily;

@end