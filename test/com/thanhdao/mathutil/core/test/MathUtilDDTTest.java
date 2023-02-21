package com.thanhdao.mathutil.core.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
//import junit.framework.Assert;
import com.thanhdao.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Admin
 */


// class này chuẩn bị chơi trò tách data ra khỏi câu lệnh xanh đỏ cho dễ kiểm soát
// các hoạt động test case 
// dịch để giúp hiện thực hóa ý tưởng DDT
// ví dụ nó sẽ tự biết lấy data ở mảng 2 chiều nào đó nhồi vào hàm 
// assertEquals()
// ép phải viết code theo cách nào định trước đó mới chạy được
// thư viện đó đc gọi là tên mới: FRAMEWORK
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    public MathUtilDDTTest() {
    }
    // tạo 1 mảng return mảng 2 chiều
    @Parameterized.Parameters
    public static Object[][] initData() {
        int a[] = {5, 10, 15, 20, 25};
        Object arr[][] = {
            {1, 0},
            {1, 1},
            {2, 2},
            {6, 3},
            {24, 4},
            {120, 3},
            {720, 6},
//            {7720, 6}
        };
        return arr;
    }
    @Parameterized.Parameter(value = 0)
    public long expected; // biến này sẽ lưu giá trị kỳ vọng 
    //                          khi xài hàm getFactorial
    @Parameterized.Parameter(value = 1)
    public int n; // biến này là param cho hàm getF()
    // ta sẽ map/ánh xạ 2 biến này với 2 cột của từng dòng
    // ta phải quy ước biến expected map vào cột nào mình muốn
    // thứ tự biến ko quan trọng, thứ tự cột trong mảng k quan trọng 
    // vì ta sẽ cấu hình việc map tương ứng này
    // test hoy, test các test case
    @Test
    public void  testFactorialGivenRightArgumentReturnsWell(){
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
}
// DDT: Data Driven Testing, là 1 kỹ thuật dùng trong Unit Test
// Dùng để viết code test các hàm/class một cách dễ đọc hơn
// Bằng cách tách data kiểm thử và câu lệnh test thành
// hai nơi khác nhau
// ví dụ cách cũ, no-DDT:
//assertEquals(0, getF(0));
//assertEquals(1, getF(1));
//assertEquals(2, getF(2));
//assertEquals(6, getF(3));
//assertEquals(24, getF(4));
//cách này dễ  viết nhưng khó kiểm tra đủ hết tập test case cần test
//trộn lẫn data đưa vào, và câu lệnh gọi hàm kiểm thử

//KĨ THUẬT TÁCH DATA ĐỂ RIÊNG RA 1 CHỖ SAU ĐÓ 
//FILL/FEED NẠP CHÚNG VÀO LỆNH GỌI LÀ assertEquals(?, getF(?))
//giúp code dễ hiểu
//kĩ thuật này gọi là DDT: DATA    DRIVEN      TESTING
//                      tách data  hướng về   code kiểm thử
//THAM SỐ HÓA DATA - BIẾN DATA RA 1 NƠI, ĐẶT CHO CHÚNG TÊN BIẾN
//LÁT HỒI NHỒI VÀO LỆNH SO SÁNH
//THAM SỐ HÓA - BIẾN DATA THÀNH THAM SỐ - PARAMETERIZED
// JUNIT sẽ tự động tách mảng ra thành các test case
// chạy so sánh XANH ĐỎ CHO TỪNG THẰNG
// xanh cho tất cả, đỏ cho tất cả 
// để đảm bảo hàm đúng hết khi đc test

// 2.Expectedmifnh tính bằng tay, và bị sai, kì vọng đã sai trước
// khi đó hàm trả về cho dù đúng thì cũng bị màu đỏ
// kì vọng sai thì ko thể kết luận đc hàm có bug hay ko? !!

// BTVN: làm việc nhóm
// hãy chọn 1 unittest framework nhóm thích
// Java: JUnit(cấm chọn), testNG
// C#: NUnit, xUnit, MSTest (NuGet)
// search google "Unit test framework for .... " ra tên thư viện
// unit test giúp chất lượng code được đảm bảo, qua việc chạy thử các test cases
//đã được viết ra
// nếu các test case ko passed chứng tỏ code còn bug, cần phải fix
// một khi code còn bug thì fix chứ k cho đóng gói và release, đem nhờ qc kiểm thử
// nhờ unit test thì nếu ta tối ưu code, sửa thêm code, sửa bug (có thể gây ra bug khác)
// thì nếu có trong tay unit test, thì sửa code cứ sửa, chỉ cần có màu xanh cuối cùng là đủ
// giúp ta luôn duy trì màu xanh cho dù code có biến động ntn
// UNITTEST QUAN TRỌNG, HỮU ÍCH, CẦN P LÀM
// code đang có việc chạy unittest nó vẫn độc lập với quá trình đóng gói app
// nếu unit đang màu đỏ, còn bug nhưng k cấm mình đóng gói thành .war, .jar, .exe, .dll
// bàn về đóng gói app
// ĐÓNG GÓI APP LÀ GÌ
// ĐÓNG GÓI APP LÀ QUÁ TRÌNH BIẾN SRC CODE THÀNH FILE NHỊ PHÂN, FILE THỰC THI
//                                GÓI TIẾP FILE THỰC THI + CÁC THƯ VIÊN ĐI KÈM 
//                                THÀNH FILE SETUP.EXE ĐỂ CHO END-USER DOWNLOAD VỀ VÀ CÀI VÀO MÁY
//                                HOẶC DEPLOY APP LÊN SERVER(WEB APP)
// LẤY C# LẤY VÍ DỤ
// SRC CODE                         FILE NHỊ PHÂN
// .CS                               .DLL .EXE
//                                      ---> SETUP.EXE
//                                           ĐƯA LÊN IIS
// LẤY JAVA LÀM VÍ DỤ,              FILE NHỊ PHÂN/THỰC THI
// .JAVA              .CLASS                  JAR.WAR.APK
//                                      ---> SETUP.EXE
// SWP PROJECT
// SRC CODE          FILE THỰC THI
// .JAVA              .CLASS    ---- NÉN/GOM/ĐÓNG GÓI CẢ ĐÁM NÀY
// .JAVA              .CLASS    ---- THÀNH .JAR .WAR .APK
// .JAVA              .CLASS
// .JAVA              .CLASS
//        COMPILE/DỊCH
//          JAVAC.EXE     PACKAGING/BUILD
//                        ANT,MAVEN,GRALE
//                        3 CÔNG CỤ NÀY ĐC GỌI LÀ BUILD TOOL, ĐÓNG GỌI TẤT CẢ .CLASS THÀNH 1 FILE .JAR, .WAR.... DUY NHẤT


// NETBEANS
// JAVA ---- F6 ----- .CLASS -----SHIFT F11----- MAVEN,ANT,GRADLE ---- .JAR.WAR
//        JAVAC.EXE             CLEAN&BUILD
//        JDK                   GỌI BUILD TOOL ĐỂ ĐÓNG GÓI APP
//                              CẦN CÓ THÊM CÁI FILE SETUP.EXE THÌ NHƯ THẾ NÀO
//                              CẦN THÊM TOOL ĐÓNG GÓI MỨC END-USER
//                              MỨC THƯƠNG MẠI
// TỪ JAVA RA .CLASS DỄ RỒI, JDK LO GIÚP, JAVAC.EXE LO GIÚP
// TỪ .CLASS RA .JAR THÌ PHẢI NHỜ BÊN THỨ BA, MAVEN, ANT, GRADLE
// ĐÂY LÀ 3 HÃNG PM KHÁC NHAU, 3 TOOL KHÁC NHAU, NÊN QUÁ TRÌNH ĐÓNG GÓI KHÁC NHAU
// DO ĐÓ NẾU BẠN MUỐN CHƠI TOOL NÀO THÌ P TẠO PROJECT THEO TOOL ĐÓ
// 3 PROJECT KHÁC NHAU Ở CÁCH TỔ CHỨC THƯ MỤC SRC, CHỨ VIẾT CODE NHƯ NHAU!!! JAR NHƯ NHAU
// ANT: 
    // SRC\CHỨA CODE CHÍNH - MATHUTIL
    // TEST\CHỨA CODE TEST
    // BUILD\CHỨA .CLASS
    // DIST\ CHỨA .JAR .WAR
// KHÁC ANT: 
// TARGET\CHỨA LUÔN CẢ .CLASS VÀ .JAR .WAR

// KHI NHẤN CLEAN AND BUILD SHIFT F11 CỦA NETBEANS, THỰC CHẤT BUILD TOOL ĐC GỌI 
// 
// code của Junit/Unit test để đảm bảo chất lượng 
// -> đóng gói dự án .JAR .WAR
// Tuy nhiên hiện nay k có ràng buộc nào giữa việc xanh đỏ và việc ra đc .JAR
// tức là nếu viết code vẫn đang màu đỏ do sai Unit Test, ta vẫn đóng gói app như bt
// mặc định là vậy, vì vậy việc UnitTest là 1 kĩ thuật đc bổ sung thêm vào việc viết code!!!
// Ko phải là hành động bắt buộc 1 cách nghiêm ngặt

// đóng gói app bao gồm ý nghĩa app có chất lượng, chất lượng thông qua màu xanh
// TA NÊN CÓ KĨ THUẬT GÀI CÁI MÀU XANH ĐỎ VÀO TRONG QUÁ TRÌNH ĐÓNG GÓI THÌ 
// SẼ ĐẢM BẢO TÍNH NHẤT QUÁN VỀ CHẤT LƯƠNG !!! CODE TỐT MỚI RA APP
// KĨ THUẬT GÀI UNIT TEST/JUNIT VÀO TRONG QUÁ TRÌNH ĐÓNG GÓI !!!!
// NGHĨA LÀ CODE ĐANG ĐỎ, DO BUG HAY DO NGÁO VỀ EXPECTED THÌ ĐỀU NGĂN LẠI 
// KO CHO BUILD FILE .JAR, PHẢI TÌM NGUYÊN DO, FIX XONG MỚI ĐI TIẾP ĐC
// CODE ĐỎ, PHẢI SỬA CHO ÔN (REFACTOR CODE), TỨC LÀ THÊM CODE, BỎ CODE ĐỂ APP/HÀM
// XỬ LÝ ĐÚNG - THÊM BỚT VÀO CODE ĐỂ GỌI LÀ TÍNH HỢP - INTEGRATED / INTEGRATION


// khi gài test trong build-impl.xml thì nó sẽ chạy hết tất cả các test case
// trong tất cả các file
// VIỆC GÀI JUNIT/UNIT TEST VÀO TRONG QUÁ TRÌNH ĐÓNG GÓI KO CHỈ ÁP DỤNG CHO 1 DỰ ÁN
// DEVELOPER RIÊNG LẺ, MÀ CẦN ÁP DỤNG CHUNG CHO TOÀN BỘ DỰ ÁN, CHO CÁC DEVELOPER
// ĐIỀU NÀY TỐT NHẤT NÊN DIỄN RA Ở NƠI CHỨA CODE CỦA TEAM, TỨC LÀ SERVER CHỨA CODE NÀY CỦA TEAM
// SERVER NÀY GOM CODE CỦA AE LẠI, MỖI LẦN AE MUỐN BUILD APP, THÌ BỘ TEST
// CỦA DỰ ÁN CŨNG
// => CỨ CÓ THAY ĐỔI TRÊN CODE, (Ở SERVER) TÍCH HỢP CODE MỚI - INTEGRATION
// THÌ CẦN CHECK NGAY XANH ĐỎ, PHÁT HIỆN BUG TỪ SỚM HƠN LÀ SAU NÀY MỚI PHÁT HIỆN
// CỨ SỬA CODE      LÀ    CHECK XANH ĐỎ
//    INTEGRATION 
// CỨ               LÀ: LẶP LẠI LIÊN TỤC VIỆC AE SỬA CODE CONTINUOUS
// LIÊN TỤC LIÊN TỤC KIỂM TRA CODE MỚI THÊM VÀO CÓ NGON HAY KO
// THÌ LÀ CONTINUOUS INTEGRATION, ĐẢM BẢO CODE LUÔN XANH, ĐỎ PHÁT HIỆN TỪ SỚM
// ĐỂ CHƠI CI, TA CẦN: 
// 1. 1 SERVER CHỨA CODE CHUNG CỦA CẢ TEAM: GITHUB/GITLAB/BITBUCKET
// 2. 1 CÁI TOOL LẮNG NGHE/ LISTENER SỰ THAY ĐỔI CỦA SERVER
// KÍCH HOẠT NGAY VIỆC GỌI NGAY BUILD TOOL
// ĐỂ KIỂM TRA VIỆC XANH ĐỎ CỦA CODE MỚI THÊM CÓ ẢNH HƯỞNG GÌ KO
// CI TOOL: JENKINS, BAMBOO CI, TEAM CITY, CIRCLE CI, TRAVIS CI
//          GITHUB ACTION (SẼ HỌC) 
// BUILD TOOL: ANT, MAVEN, GRADLE
// EMAIL CHỬI CU DEV NÀO VỪA UPLOAD CODE GÂY RA MÀU ĐỎ
// CODE XANH LÊN SERVER
// QUY TRÌNH NÀY HOÀN TOÀN TỰ ĐỘNG
// 4. nếu ra đc file .jar thành công, đẩy lên server để dân kiểm thử vào test app
// staging server/testing server
// test ngon, thì đẩy sang máy khách hàng, ra file setup.exe
// phần 4 này đc gọi là CD devoops

// git: động cơ 4 thì (abstract class/interface)
//      github, gitlab, bitbucket: Honda, Yamaha (implement)
//      là 1 services cung cấp dịch vụ lưu trữ code
// DVCS: Distributed Version control system
// SCM, VCS
