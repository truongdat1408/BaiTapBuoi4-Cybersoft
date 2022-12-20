import model.CongTy;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CongTy congTy;

    public static void main(String[] args) {
        System.out.println("--- NHAP THONG TIN CONG TY ---");
        congTy = new CongTy();
        congTy.nhapThongTinCongTy();

        int lc;
        do{
            luaChon();
            lc = sc.nextInt();
            sc.nextLine();
            if (lc > 0 && lc < 12) {
                xuLyLuaChon(lc);
            }
        } while (lc != 0);
    }

    public static void luaChon() {
        System.out.println("////// MENU LỰA CHỌN //////");
        System.out.println("0. THOÁT");
        System.out.println("1. PHÂN BỔ NHÂN VIÊN CHO TRƯỞNG PHÒNG");
        System.out.println("2. THÊM NHÂN SỰ");
        System.out.println("3. XÓA NHÂN SỰ");
        System.out.println("4. XUẤT TOÀN BỘ NHÂN SỰ");
        System.out.println("5. XUẤT TỔNG LƯƠNG TRONG CÔNG TY");
        System.out.println("6. NHÂN VIÊN THƯỜNG CÓ LƯƠNG CAO NHẤT");
        System.out.println("7. TRƯỞNG PHÒNG CÓ NHIỀU NHÂN VIÊN NHẤT");
        System.out.println("8. SẮP XẾP NHÂN VIÊN THEO THỨ TỰ ABC");
        System.out.println("9. SẮP XẾP NHÂN VIÊN THEO LƯƠNG GIẢM DẦN");
        System.out.println("10. GIÁM ĐỐC CÓ CỔ PHẦN NHIỀU NHẤT");
        System.out.println("11. XUẤT TỔNG THU NHẬP CỦA TỪNG GIÁM ĐỐC");
        System.out.print(">> ");
    }

    public static void xuLyLuaChon(int lc) {
        switch (lc) {
            case 1:
                congTy.phanBoNhanVienChoTruongPhong();
                break;
            case 2:
                congTy.themNhanSu();
                break;
            case 3:
                congTy.xoaNhanSu();
                break;
            case 4:
                congTy.inDanhSachNhanSu();
                break;
            case 5:
                System.out.println("Tổng lương của toàn bộ công ty: " + congTy.layTongLuongCongTy());
                break;
            case 6:
                congTy.inNVCoLuongCaoNhat();
                break;
            case 7:
                congTy.inTPCoNhieuNhanVienNhat();
                break;
            case 8:
                congTy.sapXepNVTheoABC();
                break;
            case 9:
                congTy.sapXepNVTheoLuongGiamDan();
                break;
            case 10:
                congTy.inGiamDocCoPhanNhieuNhat();
                break;
            case 11:
                congTy.xuatTongThuNhapTungGiamDoc();
                break;
        }
        Utils.pressEnterToContinue();
    }
}
