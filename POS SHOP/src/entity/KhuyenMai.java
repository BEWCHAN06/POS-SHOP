package entity;

import java.util.Date;

public class KhuyenMai {
    private String maKM;
    private double phanTramKhuyenMai;
    private double tienGiamKhuyenMai;
    private String tenKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String sanPham;

    public KhuyenMai() {
        // Constructor mặc nhiên
    }

    public KhuyenMai(String maKM, double phanTramKhuyenMai, double tienGiamKhuyenMai, String tenKhuyenMai,
                     Date ngayBatDau, Date ngayKetThuc, String sanPham) {
        this.maKM = maKM;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.tienGiamKhuyenMai = tienGiamKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.sanPham = sanPham;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        // Cài đặt logic để tạo mã khuyến mãi theo yêu cầu (KMxxx)
        // Phát sinh tự động
    }

    public double getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
        if (phanTramKhuyenMai >= 0 && phanTramKhuyenMai <= 100) {
            this.phanTramKhuyenMai = phanTramKhuyenMai;
        } else {
            throw new IllegalArgumentException("Phần trăm khuyến mãi không hợp lệ");
        }
    }

    public double getTienGiamKhuyenMai() {
        return tienGiamKhuyenMai;
    }

    public void setTienGiamKhuyenMai(double tienGiamKhuyenMai) {
        if (tienGiamKhuyenMai >= 0) {
            this.tienGiamKhuyenMai = tienGiamKhuyenMai;
        } else {
            throw new IllegalArgumentException("Tiền giảm khuyến mãi không hợp lệ");
        }
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        if (tenKhuyenMai != null && !tenKhuyenMai.isEmpty()) {
            this.tenKhuyenMai = tenKhuyenMai;
        } else {
            throw new IllegalArgumentException("Tên khuyến mãi không được rỗng");
        }
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        // Kiểm tra logic ngày bắt đầu hợp lệ
        if (ngayBatDau != null) {
            this.ngayBatDau = ngayBatDau;
        } else {
            throw new IllegalArgumentException("Ngày bắt đầu không hợp lệ");
        }
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        // Kiểm tra logic ngày kết thúc hợp lệ
        if (ngayKetThuc != null) {
            this.ngayKetThuc = ngayKetThuc;
        } else {
            throw new IllegalArgumentException("Ngày kết thúc không hợp lệ");
        }
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        // Cài đặt logic kiểm tra sản phẩm
        this.sanPham = sanPham;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM='" + maKM + '\'' +
                ", phanTramKhuyenMai=" + phanTramKhuyenMai +
                ", tienGiamKhuyenMai=" + tienGiamKhuyenMai +
                ", tenKhuyenMai='" + tenKhuyenMai + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", sanPham='" + sanPham + '\'' +
                '}';
    }

    public double tinhTienKhuyenMai(double giaBan) {
        return giaBan - tienGiamKhuyenMai;
    }
}
