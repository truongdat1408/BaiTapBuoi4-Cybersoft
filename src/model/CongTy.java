package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CongTy {
    String ten;
    String maSoThue;
    double doanhThuThang;

    static final Scanner sc = new Scanner(System.in);

    List<NhanVien> danhSachNhanVien;
    List<TruongPhong> danhSachTruongPhong;
    List<GiamDoc> danhSachGiamDoc;
    List<ConNguoi> danhSachToanBoNhanVien;

    public CongTy() {
        danhSachNhanVien = new ArrayList<>();
        danhSachTruongPhong = new ArrayList<>();
        danhSachGiamDoc = new ArrayList<>();
        danhSachToanBoNhanVien = new ArrayList<>();
    }

    public void nhapThongTinCongTy() {
        System.out.print("Ten cong ty: ");
        ten = sc.nextLine();
        System.out.print("Ma so thue: ");
        maSoThue = sc.nextLine();
        System.out.print("Doanh thu thang: ");
        doanhThuThang = sc.nextDouble();
    }

    public void themNhanSu() {
        int lc;
        do {
            System.out.println("LUA CHON NHAN SU THEM VAO");
            System.out.println("1. Nhan Vien");
            System.out.println("2. Truong Phong");
            System.out.println("3. Giam Doc");
            System.out.println("0. Thoat");
            System.out.print(">> ");
            lc = sc.nextInt();
            sc.nextLine();
            if (lc > 0 && lc < 4) {
                switch (lc) {
                    case 1:
                        System.out.println("/// NHAP THONG TIN NHAN VIEN ///");
                        NhanVien nv = new NhanVien();
                        if(danhSachToanBoNhanVien.size() > 0) {
                            int chiSoPhanTuCuoi = danhSachToanBoNhanVien.size() - 1;
                            nv.setMaSo((danhSachToanBoNhanVien.get(chiSoPhanTuCuoi).getMaSo() + 1));
                        } else {
                            nv.setMaSo(danhSachToanBoNhanVien.size());
                        }

                        int maSoTruongPhong;
                        boolean outLoop = false;
                        do {
                            System.out.print("Nhap ma so truong phong quan ly nhan vien nay");
                            System.out.println("(Neu khong co ai quan ly, vui long nhap -1):");
                            maSoTruongPhong = sc.nextInt();
                            if (maSoTruongPhong == -1) {
                                nv.nhapThongTinNV(null);
                                break;
                            }

                            for (TruongPhong tp : danhSachTruongPhong) {
                                if (tp.maSo == maSoTruongPhong) {
                                    tp.soLuongNhanVien++;
                                    nv.nhapThongTinNV(tp);
                                    outLoop = true;
                                    break;
                                }
                            }
                        } while (!outLoop);
                        danhSachNhanVien.add(nv);
                        danhSachToanBoNhanVien.add(nv);
                        break;

                    case 2:
                        System.out.println("/// NHAP THONG TIN TRUONG PHONG ///");
                        TruongPhong truongPhong = new TruongPhong();
                        if(danhSachToanBoNhanVien.size() > 0) {
                            int chiSoPhanTuCuoi = danhSachToanBoNhanVien.size() - 1;
                            truongPhong.setMaSo((danhSachToanBoNhanVien.get(chiSoPhanTuCuoi).getMaSo() + 1));
                        } else {
                            truongPhong.setMaSo(danhSachToanBoNhanVien.size());
                        }
                        truongPhong.nhapThongTin();
                        danhSachTruongPhong.add(truongPhong);
                        danhSachToanBoNhanVien.add(truongPhong);
                        break;
                    case 3:
                        System.out.println("/// NHAP THONG TIN GIAM DOC ///");
                        GiamDoc giamDoc = new GiamDoc();
                        if(danhSachToanBoNhanVien.size() > 0) {
                            int chiSoPhanTuCuoi = danhSachToanBoNhanVien.size() - 1;
                            giamDoc.setMaSo((danhSachToanBoNhanVien.get(chiSoPhanTuCuoi).getMaSo() + 1));
                        } else {
                            giamDoc.setMaSo(danhSachToanBoNhanVien.size());
                        }
                        giamDoc.setMaSo(danhSachToanBoNhanVien.size());
                        giamDoc.nhapThongTinGiamDoc();
                        danhSachGiamDoc.add(giamDoc);
                        danhSachToanBoNhanVien.add(giamDoc);
                        break;
                }
            }
        } while (lc != 0);
    }

    public void xoaNhanSu(int maSo) {
        for (ConNguoi conNguoi : danhSachToanBoNhanVien) {
            if (conNguoi.maSo == maSo) {

            }
        }
    }
}
