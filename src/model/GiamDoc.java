package model;

import java.util.Scanner;

public class GiamDoc extends ConNguoi{
    float coPhanCongTy;

    public GiamDoc() {
        luong1Ngay = 300;
    }

    @Override
    public double tinhLuong() {
        return luong1Ngay * soNgayLamViec;
    }

    public void nhapThongTinGiamDoc() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        float cp;
        do {
            System.out.print("Nhap co phan cong ty: ");
            cp = sc.nextFloat();
        } while (cp <= 0 || cp > 100);
    }

    @Override
    public String toString() {
        return "GiamDoc{" +
                "coPhanCongTy=" + coPhanCongTy +
                ", maSo=" + maSo +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", soNgayLamViec=" + soNgayLamViec +
                ", luong1Ngay=" + luong1Ngay +
                '}';
    }
}
