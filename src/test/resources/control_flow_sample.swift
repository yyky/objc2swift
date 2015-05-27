class MyClassControll : NSObject, SomeProtocol {

    @IBOutlet  var label:UILabel!

    func fuga() {
        var a: Int32 = 0
        var b: Int32 = 0

        switch a {
            case 0:
            b = 1
            
            case 1:
            b = 0
            
            default:
            b = 2
            
        }

        for a = 0; a < 10; a++ {
            b += 1
        }

        for a = 10; a > 0; a-- {
            b -= 1
        }

        for a = 0; a < 10; a++ {
            b *= 2
            c *= 3
        }

        while a < 10 {
            ++a
        }

        while b != 1 {
            b = b * b - b
        }

        while !c {
            c = d
            d = e
        }

        do {
            b++
        } while b < 10

        for str: NSString in array {
            NSLog(str) 
        }

        for i: Int32 in num {
            self.hoge(i)
        }

        for var i = 0; i < 10; i++ {
            for var j = 0, k = 1; j < 5; j++ {
                foo = self.hoge()
            }

        }


    }



}
