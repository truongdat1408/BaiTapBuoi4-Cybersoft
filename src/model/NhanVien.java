package model;

import java.util.Objects;

public class NhanVien extends ConNguoi{
    private TruongPhong truongPhongQuanLy;

    public NhanVien() {
        setLuong1Ngay(100);
    }

    public NhanVien(int maSoNhanVien) {
        setMaSo(maSoNhanVien);
        setLuong1Ngay(100);
    }

    @Override
    public double tinhLuong() {
        return getLuong1Ngay() * getSoNgayLamViec();
    }

    public TruongPhong getTruongPhongQuanLy() {
        return truongPhongQuanLy;
    }

    public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
        this.truongPhongQuanLy = truongPhongQuanLy;
    }

    public void nhapThongTinNV(TruongPhong tp) {
        super.nhapThongTin();
        setTruongPhongQuanLy(tp);
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maSoTruongPhongQuanLy=" + (Objects.nonNull(truongPhongQuanLy) ? truongPhongQuanLy.getMaSo() : "null") +
                ", maSo=" + getMaSo() +
                ", hoTen='" + getHoTen() + '\'' +
                ", soDienThoai='" + getSoDienThoai() + '\'' +
                ", soNgayLamViec=" + getSoNgayLamViec() +
                ", luong1Ngay=" + getLuong1Ngay() +
                ", luong=" + tinhLuong() +
                '}';
    }
}
