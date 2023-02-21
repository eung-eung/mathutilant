/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhdao.mathutil.core.test;

import com.thanhdao.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**

 * @author Admin
 */

public class MathUtilTest {

    @Test
    // test thử hàm so sánh 2 giá trị expected và actual
    // máy tự so sánh dùm luôn, ko nhìn bằng mắt để so sánh như bên main()phải dùng sout
    // mà FW JUnit tự generate ra code để so sánh giá trị,
    // màu XANH/ĐỎ mang ý nghĩa là PASS/FAILED
    public void tryAssert() {
        Assert.assertEquals(10, 10);
    }

    //test hàm getFactorial(), như bên main()
    //nhưng trả XANH ĐỎ
    @Test //Quy tắc đặc tên hàm dành cho kiểm thử
    //tên hàm bao hàm ngữ nghĩa của việc kiểm thử
    //test này kiểm tra tính gt với tham số từ tử tế 0...20
    public void testFactorialGivenRightArgumentReturnWell() {
        //Test case #1: n = 0; 0! hy vọng trả về 1
        long expected = 1;
        long actual = MathUtil.getFactorial(0);

        Assert.assertEquals(expected, actual);

        //Test case #2: n = 1, 1! hy vọng trả về 1
        Assert.assertEquals(1, MathUtil.getFactorial(1));

        //Test case #3: n = 2, 2!
        Assert.assertEquals(2, MathUtil.getFactorial(2));
    }

    @Test
    public void testFactorialGivenRightArgumentReturnWell2() {
        //Test case #1: n = 0; 0! hy vọng trả về 1
        long expected = 1;
        long actual = MathUtil.getFactorial(0);

        Assert.assertEquals(expected, actual);

        //Test case #4: n = 3, 3! hy vọng trả về 6
        Assert.assertEquals(6, MathUtil.getFactorial(3));

        //Test case #4: n = 4, 4!
        Assert.assertEquals(24, MathUtil.getFactorial(4));
    }

    //KIỂM THỬ NGOẠI LỆ KHI ĐƯA DATA SAI
    //n < 0, không tính giai thừa âm
    //n > 20, ko tính giai thừa trên kiểu long
    //hàm được thiết kế: NÉM RA NGOẠI LỆ TÊN LÀ: Illegal-Argument_Exception
    //THAY VÌ NHẬN VỀ 1 GIÁ TRỊ LONG, BẠN NHẬN VỀ 1 CÂU THÔNG BÁO EXCEPTION
    //NẾU N = -5, MÀ NÉM RA CÂU NGOẠI LỆ THÌ --> HÀM ỔN, NHƯ KỲ VỌNG
    //ĐÚNG KỲ VỌNG, PASS --> XANH
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5);
        
        //Test case #6: n = -5, expected: hy vọng thấy ngoại lệ
        //tên là IllegalArgumentException
        
    }
}

// @Test: là annotation báo với JUnit và JVM
// để generate cái hàm tryAssert() thành main() truyền thống
// và gửi cho JVM để chạy. App bắt đầu chạy từ main()
//thiếu @Test tương đương app thiếu main() no-runable
//CHỐT DEAL XANH ĐỎ:
//NẾU CÁC TEST CASES, @TEST ĐỀU MÀU XANH -> KẾT LUẬN HÀM ĐÚNG
//ĐÚNG CHO NHỮNG THỨ MÌNH ĐÃ TEST
//XANH KHI TẤT CẢ @TEST PHẢI XANH
//1. XANH KHI TẤT CẢ CÙNG XANH
//NẾU TRONG CÁC @TEST CÓ ÍT NHẤT 1 THẰNG ĐỎ/XEM NHƯ TẤT CẢ LÀ ĐỎ
//Ý NGHĨA LÀ HÀM ĐÚNG THÌ PHẢI ĐÚNG HẾT, CÓ 1 THẰNG SAI THÌ
//HÀM KO ỔN ĐỊNH
//2. ĐỎ KHI CÓ ÍT NHẤT 1 THẰNG ĐỎ
//ĐỎ ĐẾN TỪ 1 TRONG TÌNH HUỐNG 
//EXPECTED ĐÃ TÍNH ĐÚNG, ACTUAL TRẢ VỀ SAI --> BUG CỦA HÀM
//EXPECTED ĐÃ TÍNH GÕ SAI, ACTUAL SAI --> ĐÚNG
