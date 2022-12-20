package model;

import java.util.Scanner;

public class GiamDoc extends ConNguoi{
    private float coPhanCongTy;

    public GiamDoc() {
        setLuong1Ngay(300);
    }

    @Override
    public double tinhLuong() {
        return getLuong1Ngay() * getSoNgayLamViec();
    }

    public void nhapThongTinGiamDoc() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        float cp;
        do {
            System.out.print("Nhap co phan cong ty: ");
            cp = sc.nextFloat();
            if (cp <= 0 || cp > 100) System.out.println("Co Phan cong ty > 0 va <= 100");
        } while (cp <= 0 || cp > 100);
        coPhanCongTy = cp;
    }

    @Override
    public String toString() {
        return "GiamDoc{" +
                "coPhanCongTy=" + coPhanCongTy +
                ", maSo=" + getMaSo() +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai='" + getSoDienThoai() + '\'' +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() +
                ", luong=" + tinhLuong() +
                '}';
    }

    public float getCoPhanCongTy() {
        return coPhanCongTy;
    }

    public void setCoPhanCongTy(float coPhanCongTy) {
        this.coPhanCongTy = coPhanCongTy;
    }
}
