package model;

public class NhanVien extends ConNguoi{
    TruongPhong truongPhongQuanLy;

    public NhanVien() {
        luong1Ngay = 100;
    }

    @Override
    public double tinhLuong() {
        return luong1Ngay * soNgayLamViec;
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
                "maSoTruongPhongQuanLy=" + truongPhongQuanLy.maSo +
                ", maSo=" + maSo +
                ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", soNgayLamViec=" + soNgayLamViec +
                ", luong1Ngay=" + luong1Ngay +
                '}';
    }
}
