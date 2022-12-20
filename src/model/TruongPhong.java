package model;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends ConNguoi{
    private int soLuongNhanVien;

    public TruongPhong() {
        setLuong1Ngay(200);
        soLuongNhanVien = 0;
    }

    @Override
    public double tinhLuong() {
        return getLuong1Ngay() * getSoNgayLamViec() + 100 * soLuongNhanVien;
    }

    @Override
    public String toString() {
        return "TruongPhong{" +
                "soLuongNhanVien=" + soLuongNhanVien +
                ", maSo=" + getMaSo() +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai='" + getSoDienThoai() + '\'' +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() +
                ", luong=" + tinhLuong() +
                '}';
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public void tangSoLuongNhanVien() {
        soLuongNhanVien++;
    }

    public void giamSoLuongNhanVien() {
        soLuongNhanVien--;
    }
}
