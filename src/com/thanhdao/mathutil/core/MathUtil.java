/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhdao.mathutil.core;
/**
 *
 * @author Admin
 */
public class MathUtil {
    //trong class này ta sẽ viết các hàm tiện ích dùng chung cho các class khác
    //cái gì mà dùng chung cho các class khác thì thường sẽ THIẾT KẾ LÀ STATIC
    
    //hàm tính giai thừa n! = 1.2.3.4....n
    //quy ước ko có giai thừa âm
    //        0! = 1! = 1
    //        chỉ tính n từ 0..20, vì
    //        21! vượt quá 18 con số 0, vượt long
//    public static long getFactorial(int n){
//        if (n < 0 || n > 20){
//            throw new IllegalArgumentException("Invalid n. N must be between 0...20");
//        }
//        if (n == 0 || n == 1){
//            return 1;
//        }
//        long product = 1; //biến tích lũy acc/accomulation
//        for (int i = 2; i <= n; i++) {
//            product *= i; 
//        }
//        return product;
//    }
    
    
    // 14/10/2022
    // viết hàm tính giai thừa theo style đệ quy !! RECURSION
    // n! = 1.2.3.4.5....n4
    // 5! = 1.2.3.4.5
    // 5! = 4! x 5 = 5 x 4!
    // 4! = 1.2.3.4 = 3! x 4 
    // 3! ...
    // 2! ...
    // 1! ...
    
    // n! = n x (n -1)!
    // lặp lại chính mình với quy mô nhỏ hơn
    // n! = ~~~ RETURN N X (N-1)!
    // CHỮ GIAI THỪA XUẤT HIỆN 2 LẦN
    /*
    
    */
    public static long getFactorial(int n){
        if (n < 0 || n > 20){
            throw new IllegalArgumentException("Invalid n. N must be between 0...20");
        }
        if (n == 0 || n == 1)
            return 1; 
        // CHỐT DỪNG ĐỆ QUY 
        // TỪ 2 GIAI THỪA LÀ ĐOẠN CODE DƯỚI ĐÂY
        return  n* getFactorial(n -1); 
        
    }
}

//Học kỹ thuật viết code mới được gọi là TDD - Test Driven Development
//Là kỹ thuật ngay khi viết code, ngay khi thiết kế ra tên hàm/class
//Phải chuận bị luôn bộ kiểm thử - các test case
//Chuẩn bị luôn các tình huống (case) sẽ xài hàm này như thế nào
//Chuẫn bị luôn các tình huống test các hàm để xác định hàm đúng hay sai
//Viết code hướng về các bài kiểm thử đặt ra

//Các test cases - các tình huống xài hàm 1 khi viết xong 
//Case #1: n = 0; getFactorial(0) -> expected hy vọng hàm trả ra: 1
//Case #2: n = 1; getFactorial(1) -> expected hy vọng hàm trả ra: 1
//Case #3: n = 5; getFactorial(5) -> expected hy vọng hàm trả ra: 120

//Case #4: n = -5; getFactorial(-5) -> expected value: CHỬI, KO HỢP LỆ n
//Case #5: n = 21; getFactorial(21) -> expected value: CHỬI, KO HỢP LỆ n
//                                                     VALIDATOR/VALIDATION

//TEST CASSE: là 1 tình huống kiểm thử màn hình/tính năng
//            xem có chạy đúng hay ko
//            bằng cách đưa data vào, xem có input ra đúng với dự kiến hay ko
//            đưa data, chờ app xử lý, chờ so sánh kết quả actual với expected


