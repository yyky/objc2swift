class StringWithFormatSample : NSObject, Protocol1, Protocol2 {

    func stringWithFormatTest() -> NSString {
        "int型：\(num)"
        "int型：\(num1 + num2)"
        String(format: "%02i:%02i:%02i", hour, min, sec)
        "double型：\(x)"
        String(format: "double型：%.1f", f)
        "\(rawResult["FirstName"]) \(rawResult["LastName"])"
        "NSArray型：\(ary)"
        NSString.initWithFormat("文字列：%ld"n)

    }

}
