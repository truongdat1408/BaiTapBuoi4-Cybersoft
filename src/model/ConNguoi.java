package model;

import java.util.Scanner;

public abstract class ConNguoi {
    int maSo;
    String hoTen;
    String soDienThoai;
    int soNgayLamViec;
    double luong1Ngay;

    static final Scanner sc = new Scanner(System.in);

    public abstract double tinhLuong();

    public void nhapThongTin() {
        System.out.print("Ho ten: ");
        setHoTen(sc.nextLine());
        System.out.print("So dien thoai: ");
        setSoDienThoai(sc.nextLine());
        System.out.print("So ngay lam viec: ");
        setSoNgayLamViec(sc.nextInt());
    }

    public int getMaSo() {
        return maSo;
    }

    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }
}
