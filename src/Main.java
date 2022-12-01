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
        System.out.println("////// MENU LUA CHON //////");
        System.out.println("0. Thoat");
        System.out.println("1. Phan bo nhan vien vao truong phong");
        System.out.println("2. Them nhan su");
        System.out.println("3. Xoa nhan su");
        System.out.println("4. Xuat toan bo nguoi trong cong ty");
        System.out.println("5. Xuat tong luong toan bo cong ty");
        System.out.println("6. Nhan vien co luong cao nhat");
        System.out.println("7. Truong phong co nhieu nhan vien nhat");
        System.out.println("8. Sap xep nhan vien theo abc");
        System.out.println("9. Sap xep nhan vien theo luong giam dan");
        System.out.println("10. Giam doc so luong co phan nhieu nhat");
        System.out.println("11. Xuat tong thu nhap cua tung Giam doc");
        System.out.print(">> ");
    }

    public static void xuLyLuaChon(int lc) {
        switch (lc) {
            case 2:
                congTy.themNhanSu();
                break;
        }
    }
}
