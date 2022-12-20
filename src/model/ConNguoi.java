package model;

import java.util.Scanner;

public abstract class ConNguoi {
    private int maSo;
    private String hoTen;
    private String soDienThoai;
    private int soNgayLamViec;
    private double luong1Ngay;

    static final Scanner sc = new Scanner(System.in);

    public abstract double tinhLuong();

    public void nhapThongTin() {
        System.out.print("Ho ten: ");
        setHoTen(sc.nextLine());
        System.out.print("So dien thoai: ");
        setSoDienThoai(sc.nextLine());
        System.out.print("So ngay lam viec: ");
        setSoNgayLamViec(sc.nextInt());
        sc.nextLine();
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

    public double getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(double luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }
}
