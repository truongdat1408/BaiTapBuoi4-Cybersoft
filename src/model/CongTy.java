package model;

import java.util.*;

public class CongTy {
    String ten;
    String maSoThue;
    double doanhThuThang;

    static final Scanner sc = new Scanner(System.in);
    List<ConNguoi> danhSachToanBoNhanVien;

    public CongTy() {
        danhSachToanBoNhanVien = new ArrayList<>();
    }

    public void nhapThongTinCongTy() {
        System.out.print("Tên công ty: ");
        ten = sc.nextLine();
        System.out.print("Mã số thuế: ");
        maSoThue = sc.nextLine();
        System.out.print("Doanh thu tháng: ");
        doanhThuThang = sc.nextDouble();
    }

    public void themNhanSu() {
        int luachon;
        do {
            System.out.println("Lựa chọn loại nhân sự cần thêm vào: ");
            System.out.println("1. Nhân viên");
            System.out.println("2. Trưởng Phòng");
            System.out.println("3. Giám Đốc");
            System.out.println("0. Thoát");
            System.out.print(">> ");
            luachon = sc.nextInt();
            sc.nextLine();

            int soLuongNhanVien = 0;
            int maSoNhanVien = 0;

            switch (luachon) {
                case 1:
                    System.out.println(">> THÊM NHÂN VIÊN <<");
                    soLuongNhanVien = danhSachToanBoNhanVien.size();

                    // Mã số nhân viên sẽ lấy mã số ở cuối danh sách tăng lên 1, vì nhân viên ở cuối danh sách theo logic
                    // nếu không sắp xếp theo gì cả sẽ có mã số lớn nhất
                    maSoNhanVien = soLuongNhanVien == 0 ? 0 : (danhSachToanBoNhanVien.get(soLuongNhanVien - 1).getMaSo() + 1);
                    NhanVien nhanVienMoi = new NhanVien(maSoNhanVien);

                    int maSoTruongPhong;
                    TruongPhong truongPhong = null;
                    do {
                        System.out.println("Nhập vào mã số Trưởng Phòng Quản Lý\n" +
                                "(Nhập -1 nếu không muốn có Trưởng Phòng Quản lý nhân viên này): ");
                        maSoTruongPhong = sc.nextInt();
                        sc.nextLine();

                        if (maSoTruongPhong > -1) {
                            truongPhong = kiemTraCoTruongPhongTrongDanhSach(maSoTruongPhong);

                            //Nếu có trưởng phòng trong danh sách
                            if (Objects.nonNull(truongPhong)) {
                                truongPhong.tangSoLuongNhanVien();
                                int index = 0;

                                // Chắc chắn trong danh sách đã có Trưởng phòng
                                for (ConNguoi conNguoi : danhSachToanBoNhanVien) {
                                    if (conNguoi instanceof TruongPhong && conNguoi.getMaSo() == truongPhong.getMaSo()) {
                                        index = danhSachToanBoNhanVien.indexOf(conNguoi);
                                        break;
                                    }
                                }
                                danhSachToanBoNhanVien.set(index, truongPhong); //update lại danh sách trưởng phòng có thêm nhân viên mới
                                nhanVienMoi.nhapThongTinNV(truongPhong);
                            } else {
                                System.out.println("Lỗi: Không có trưởng phòng có mã số này!");
                            }
                        } else if (maSoTruongPhong == -1) {
                            nhanVienMoi.nhapThongTinNV(null);
                        }
                    } while (maSoTruongPhong != -1 && Objects.isNull(truongPhong));
                    danhSachToanBoNhanVien.add(nhanVienMoi);
                    inDanhSachNhanSu();
                    break;

                case 2:
                    System.out.println(">> THÊM TRƯỞNG PHÒNG <<");
                    soLuongNhanVien = danhSachToanBoNhanVien.size();
                    // Mã số nhân viên sẽ lấy mã số ở cuối danh sách tăng lên 1, vì nhân viên ở cuối danh sách theo logic
                    // nếu không sắp xếp theo gì cả sẽ có mã số lớn nhất
                    maSoNhanVien = soLuongNhanVien == 0 ? 0 : (danhSachToanBoNhanVien.get(soLuongNhanVien - 1).getMaSo() + 1);
                    truongPhong = new TruongPhong();
                    truongPhong.setMaSo(maSoNhanVien);
                    truongPhong.nhapThongTin();
                    danhSachToanBoNhanVien.add(truongPhong);
                    inDanhSachNhanSu();
                    break;

                case 3:
                    System.out.println(">> THÊM GIÁM ĐỐC <<");
                    soLuongNhanVien = danhSachToanBoNhanVien.size();
                    // Mã số nhân viên sẽ lấy mã số ở cuối danh sách tăng lên 1, vì nhân viên ở cuối danh sách theo logic
                    // nếu không sắp xếp theo gì cả sẽ có mã số lớn nhất
                    maSoNhanVien = soLuongNhanVien == 0 ? 0 : (danhSachToanBoNhanVien.get(soLuongNhanVien - 1).getMaSo() + 1);
                    GiamDoc giamDoc = new GiamDoc();
                    giamDoc.setMaSo(maSoNhanVien);
                    giamDoc.nhapThongTinGiamDoc();
                    danhSachToanBoNhanVien.add(giamDoc);
                    inDanhSachNhanSu();
                    break;
            }
        } while (luachon != 0);
    }

    private TruongPhong kiemTraCoTruongPhongTrongDanhSach(int maSo) {
        for (ConNguoi conNguoi : danhSachToanBoNhanVien) {
            if (conNguoi instanceof TruongPhong && conNguoi.getMaSo() == maSo) {
                return (TruongPhong) conNguoi;
            }
        }
        return null;
    }

    public void phanBoNhanVienChoTruongPhong() {
        int luachon;
        do {
            System.out.println("Vui lòng lựa chọn: ");
            System.out.println("1. Phân bổ những nhân viên chưa có trưởng phòng");
            System.out.println("2. Phân bổ cho 1 nhân viên cụ thể");
            System.out.println("0. Thoát");
            System.out.print(">> ");
            luachon = sc.nextInt();
            sc.nextLine();

            int maSoTruongPhong;
            NhanVien nhanVien = null;
            TruongPhong truongPhong = null;

            switch (luachon) {
                case 1:
                    boolean coNhanVien = false;

                    for(ConNguoi conNguoi : danhSachToanBoNhanVien) {
                        if (conNguoi instanceof NhanVien
                                && ((NhanVien) conNguoi).getTruongPhongQuanLy() == null) {
                            nhanVien = (NhanVien) conNguoi;
                            coNhanVien = true;
                            System.out.println("Nhân viên {maSo: " + nhanVien.getMaSo() + ", ten: " + nhanVien.getHoTen() + "}");

                            do {
                                System.out.println("Nhập vào mã số Trưởng Phòng Quản Lý\n" +
                                        "(Nhập -1 nếu không muốn có Trưởng Phòng Quản lý nhân viên này): ");
                                maSoTruongPhong = sc.nextInt();
                                sc.nextLine();

                                if (maSoTruongPhong > -1) {
                                    truongPhong = kiemTraCoTruongPhongTrongDanhSach(maSoTruongPhong);

                                    //Nếu có trưởng phòng trong danh sách
                                    if (Objects.nonNull(truongPhong)) {
                                        truongPhong.tangSoLuongNhanVien();
                                        int index = 0;
                                        int index2 = 0;

                                        // Chắc chắn trong danh sách đã có Trưởng phòng
                                        // index 1: chỉ số của trưởng phòng cần update lại
                                        // index 2: chỉ số của nhân viên cần update
                                        for (ConNguoi cn : danhSachToanBoNhanVien) {
                                            if (cn instanceof TruongPhong && cn.getMaSo() == truongPhong.getMaSo()) {
                                                index = danhSachToanBoNhanVien.indexOf(cn);
                                            }

                                            if (cn instanceof NhanVien && cn.getMaSo() == nhanVien.getMaSo()) {
                                                index2 = danhSachToanBoNhanVien.indexOf(cn);
                                            }
                                        }
                                        danhSachToanBoNhanVien.set(index, truongPhong); //update lại danh sách có trưởng phòng thay đổi số lượng nhân viên
                                        nhanVien.setTruongPhongQuanLy(truongPhong); //update lại trưởng phòng
                                        danhSachToanBoNhanVien.set(index2, nhanVien); //update lại danh sách có nhân viên trưởng phòng thay đổi
                                    } else {
                                        System.out.println("Lỗi: Không có trưởng phòng có mã số này!");
                                    }
                                }
                            } while (maSoTruongPhong != -1 && Objects.isNull(truongPhong));
                        }
                    }

                    if(!coNhanVien) {
                        System.out.println("Các nhân viên đã được phân bổ trưởng phòng!");
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã nhân viên cần phân bổ: ");
                    int maSoNhanVien = sc.nextInt();
                    coNhanVien = false;
                    sc.nextLine();

                    for (ConNguoi conNguoi : danhSachToanBoNhanVien) {
                        if (conNguoi instanceof NhanVien && conNguoi.getMaSo() == maSoNhanVien) {
                            nhanVien = (NhanVien) conNguoi; // Biến update nhân viên mới chuẩn bị phân bổ trưởng phòng
                            coNhanVien = true;
                            TruongPhong truongPhongCu = nhanVien.getTruongPhongQuanLy(); // Trưởng phòng cũ
                            boolean coTruongPhongCu = Objects.nonNull(truongPhongCu); //Biến check nhân viên đã có trưởng phòng chưa

                            do {
                                System.out.println("Nhập vào mã số Trưởng Phòng Quản Lý\n" +
                                        "(Nhập -1 nếu không muốn có Trưởng Phòng Quản lý nhân viên này): ");
                                maSoTruongPhong = sc.nextInt();
                                sc.nextLine();

                                if (maSoTruongPhong > -1) {
                                    truongPhong = kiemTraCoTruongPhongTrongDanhSach(maSoTruongPhong); //Trưởng phòng phân cho nhân viên

                                    //Nếu có trưởng phòng trong danh sách
                                    if (Objects.nonNull(truongPhong)) {
                                        truongPhong.tangSoLuongNhanVien(); //Tăng số lượng nhân viên quản lý
                                        int index = 0;
                                        int index2 = 0;


                                        // Chắc chắn trong danh sách đã có Trưởng phòng
                                        // index 1: chỉ số của trưởng phòng cần update lại
                                        // index 2: chỉ số của nhân viên cần update
                                        for (ConNguoi cn : danhSachToanBoNhanVien) {
                                            if (cn instanceof TruongPhong && cn.getMaSo() == truongPhong.getMaSo()) {
                                                index = danhSachToanBoNhanVien.indexOf(cn);
                                            }

                                            if (cn instanceof NhanVien && cn.getMaSo() == nhanVien.getMaSo()) {
                                                index2 = danhSachToanBoNhanVien.indexOf(cn);
                                            }

                                            //Update lại số lượng nhân viên quản lý của trưởng phòng cũ trong danh sách
                                            if (coTruongPhongCu && truongPhongCu.getMaSo() == cn.getMaSo()) {
                                                truongPhongCu.giamSoLuongNhanVien();
                                                danhSachToanBoNhanVien.set(danhSachToanBoNhanVien.indexOf(cn), truongPhongCu);
                                            }
                                        }
                                        danhSachToanBoNhanVien.set(index, truongPhong); //update lại danh sách có trưởng phòng thay đổi số lượng nhân viên
                                        nhanVien.setTruongPhongQuanLy(truongPhong); //update lại trưởng phòng
                                        danhSachToanBoNhanVien.set(index2, nhanVien); //update lại danh sách có nhân viên trưởng phòng thay đổi

                                    } else {
                                        System.out.println("Không có mã số trưởng phòng này trong danh sách");
                                    }

                                } else if (maSoTruongPhong == -1){
                                    if (coTruongPhongCu) {
                                        for (ConNguoi cn : danhSachToanBoNhanVien) {
                                            //Update lại số lượng nhân viên quản lý của trưởng phòng cũ trong danh sách
                                            if (truongPhongCu.getMaSo() == cn.getMaSo()) {
                                                truongPhongCu.giamSoLuongNhanVien();
                                                danhSachToanBoNhanVien.set(danhSachToanBoNhanVien.indexOf(cn), truongPhongCu);
                                                break;
                                            }
                                        }
                                    }
                                    nhanVien.setTruongPhongQuanLy(null);
                                }

                            } while (maSoTruongPhong != -1 && Objects.isNull(truongPhong));

                            break;
                        }
                    }

                    if(!coNhanVien) {
                        System.out.println("Không có mã số nhân viên này để phân bổ trưởng phòng");
                    }
                    break;
            }
            inDanhSachNhanSu();
        } while (luachon != 0);
    }
    public void xoaNhanSu() {
        int lc;
        inDanhSachNhanSu();
        do {
            System.out.println("1. Xóa nhân viên bằng mã số");
            System.out.println("0. Thoát");
            System.out.print(">> ");
            lc = sc.nextInt();
            sc.nextLine();

            if (lc < 0 || lc > 1) {
                System.out.println("Lỗi nhập sai hãy nhập lại!");
            }

            if (lc == 1) {
                boolean coNV = false;
                int maSoNV;
                do {
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    maSoNV = sc.nextInt();
                    sc.nextLine();

                    for (ConNguoi cn : danhSachToanBoNhanVien) {
                        if(cn.getMaSo() == maSoNV) {
                            danhSachToanBoNhanVien.remove(cn);
                            coNV = true;
                            break;
                        }
                    }

                    if (!coNV) {
                        System.out.println("Không tồn tại nhân viên có mã số này!");
                    }
                } while (!coNV);
                inDanhSachNhanSu();
            }
        } while (lc != 0);
    }

    public void inDanhSachNhanSu() {
        System.out.println();
        System.out.println("/////////DANH SÁCH NHÂN SỰ CÔNG TY " + ten + "//////////");
        for (ConNguoi conNguoi : danhSachToanBoNhanVien) {
            System.out.println(conNguoi);
        }
        System.out.println("/////////////////////////////");
    }

    public double layTongLuongCongTy() {
        double tongLuong = 0;
        for(ConNguoi cn : danhSachToanBoNhanVien) {
            tongLuong += cn.tinhLuong();
        }
        return tongLuong;
    }

    public void inNVCoLuongCaoNhat() {
        double luongCaoNhat = Double.MIN_VALUE;
        ConNguoi nv = null;
        for (ConNguoi cn : danhSachToanBoNhanVien) {
            if (cn instanceof NhanVien && cn.tinhLuong() > luongCaoNhat) {
                luongCaoNhat = cn.tinhLuong();
                nv = cn;
            }
        }
        System.out.println("Nhân viên thường có lương cao nhất: " + nv);
        System.out.println("-> Tổng lương: " + luongCaoNhat);
    }

    public void inTPCoNhieuNhanVienNhat() {
        int soNhanVien = Integer.MIN_VALUE;
        TruongPhong tp = null;
        for (ConNguoi cn : danhSachToanBoNhanVien) {
            if (cn instanceof TruongPhong && ((TruongPhong) cn).getSoLuongNhanVien() > soNhanVien) {
                soNhanVien = ((TruongPhong) cn).getSoLuongNhanVien();
                tp = (TruongPhong) cn;
            }
        }
        System.out.println("Trưởng phòng số lượng nhân viên quản lý nhiều nhất là:");
        System.out.println(tp);
        System.out.println("-> Với số lượng nhân viên quản lý: " + soNhanVien);
    }

    public void sapXepNVTheoABC() {
        danhSachToanBoNhanVien.sort((nv1, nv2) -> nv1.getHoTen().compareTo(nv2.getHoTen()));
        inDanhSachNhanSu();
    }

    public void sapXepNVTheoLuongGiamDan() {
        Collections.sort(danhSachToanBoNhanVien, (nv1, nv2) -> ((Double) nv2.tinhLuong()).compareTo(nv1.tinhLuong()));
        inDanhSachNhanSu();
    }

    public void inGiamDocCoPhanNhieuNhat() {
        float coPhanLonNhat = Float.MIN_VALUE;
        GiamDoc giamDoc = null;
        for(ConNguoi cn : danhSachToanBoNhanVien) {
            if(cn instanceof GiamDoc && ((GiamDoc) cn).getCoPhanCongTy() > coPhanLonNhat) {
                coPhanLonNhat = ((GiamDoc) cn).getCoPhanCongTy();
                giamDoc = (GiamDoc) cn;
            }
        }

        if(giamDoc != null) {
            System.out.println("Giám đốc có cổ phần lớn nhất công ty: " + giamDoc);
            System.out.println("-> Số cổ phần: " + giamDoc.getCoPhanCongTy());
        } else {
            System.out.println("Lỗi: Trong danh sách không có Giám đốc, hãy kiểm tra lại!");
        }

    }

    public void xuatTongThuNhapTungGiamDoc() {
        double loiNhuan = doanhThuThang - layTongLuongCongTy();
        for(ConNguoi cn : danhSachToanBoNhanVien) {
            if(cn instanceof GiamDoc) {
                System.out.println(
                        "Giám đốc {maSo:" + cn.getMaSo() + ", "
                                + "hoTen:" + cn.getHoTen() + ","
                                + "thuNhap:" + (cn.tinhLuong() + loiNhuan*((GiamDoc) cn).getCoPhanCongTy()*1.0/100)
                                + "}");
            }
        }
    }

}
