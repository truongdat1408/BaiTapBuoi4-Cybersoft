package model;

public class TruongPhong extends ConNguoi{
    int soLuongNhanVien;

    public TruongPhong() {
        luong1Ngay = 200;
        soLuongNhanVien = 0;
    }

    @Override
    public double tinhLuong() {
        return luong1Ngay * soNgayLamViec + 100 * soLuongNhanVien;
    }

    @Override
    public String toString() {
        return "TruongPhong{" +
                "soLuongNhanVien=" + soLuongNhanVien +
                ", maSo=" + maSo +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", soNgayLamViec=" + soNgayLamViec +
                ", luong1Ngay=" + luong1Ngay +
                '}';
    }
}
