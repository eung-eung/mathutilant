/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhdao.mathutil.main;

import com.thanhdao.mathutil.core.MathUtil;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        //Test case #1: n = 0 -> expected getF(0) -> return 1
        long expected = 1;
        long actual = MathUtil.getFactorial(0);

        System.out.println("0! status: expected = " + expected
                + " | actual = " + actual);

        //Test case #2: n = 1 -> expected getF(1) -> return 1
        System.out.println("1! status: expected = " + expected
                + " | actual = " + MathUtil.getFactorial(1));

        //Test case #3: n = 5 -> expected getF(5) -> return 120
        System.out.println("5! status: expected = " + expected
                + " | actual = " + MathUtil.getFactorial(5));

        //Test case #3: n = -5 -> expected getF(-5) -> nhận exception
        // System.out.println("-5! status: expected = EXCEPTION"
        //                           + " | actual = " + MathUtil.getFactorial(-5));
        System.out.println("-5! status: expected = EXCEPTION"
                + " | actual = ");
        MathUtil.getFactorial(-5);

        //NẾU CÓ EXCEPTION XẢY RA, MỪNG RƠI NƯỚC MẮT
        //VÌ HÀM CHẠY NHƯ THIẾT KẾ VỚI -5
    }
}

//VIỆC CHẠY BỘ TEST/XEM TỨNG DÒNG KẾT QUẢ ĐƯỢC IN RA, ĐỂ SUY LUẬN
//SO SÁNH, ĐỂ KẾT LUẬN HÀM ĐÚNG SAI -> VỤ NÀY MẤT SỨC,
//VÌ PHẢI DÙNG MẮT, SUY LUẬN -> MANUAL TEST, RẤT CẢM GIÁC THỦ CÔNG
//KO HIỆU QUẢ NẾU CODE ĐƯỢC CHỈNH SỬA, TA PHẢI LUẬN LẠI KẾT
//QUẢ BẰNG THỦ CÔNG: MẮT QUÉT QUA CÁC KẾT QUẢ, TỰ SO SÁNH, TỰ KẾT LUẬN
//KĨ THUẬT THỨ 2 XUẤT HIỆN: TEST AUTOMATION
//TỨC  LÀ VẪN CHẠY BỘ TEST NHƯ MANUAL, NHƯNG KO CẦN MẮT NHÌN TỪNG KẾT QUẢ
//MÁY DƯ SỨC SO SÁNH
//TA CHỈ NHÌN 2 THỨ DUY NHẤT SAU KHI
//CHẠY QUA 1 ĐÁM TEST CASE: ĐÚNG: XANH; SAI: ĐỎ

