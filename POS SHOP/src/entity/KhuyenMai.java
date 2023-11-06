package entity;

import java.util.Date;

public class KhuyenMai {
	private String maKM, tenKhuyenMai;
	private double phanTramKhuyenMai;
	private Date ngayBatDau;
	private Date ngayKetThuc;

	public KhuyenMai() {
		// Constructor mặc nhiên
	}

	public KhuyenMai(String maKM, String tenKhuyenMai, double phanTramKhuyenMai, Date ngayBatDau, Date ngayKetThuc) {
		this.maKM = maKM;
		this.tenKhuyenMai = tenKhuyenMai;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		// Cài đặt logic để tạo mã khuyến mãi theo yêu cầu (KMxxx)
		// Phát sinh tự động
		this.maKM = maKM;
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

	@Override
	public String toString() {
		return "KhuyenMai{" + "maKM='" + maKM + '\'' + ", phanTramKhuyenMai=" + phanTramKhuyenMai + ", tenKhuyenMai='"
				+ tenKhuyenMai + '\'' + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + '\'' + '}';
	}

}
