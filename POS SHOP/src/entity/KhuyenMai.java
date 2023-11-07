package entity;

import java.util.Date;

public class KhuyenMai {
	private String maKM, tenKhuyenMai;
	private double phanTramKhuyenMai;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	public KhuyenMai(String maKM, String tenKhuyenMai, double phanTramKhuyenMai, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.maKM = maKM;
		this.tenKhuyenMai = tenKhuyenMai;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}
	public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	@Override
	public String toString() {
		return "KhuyenMai [maKM=" + maKM + ", tenKhuyenMai=" + tenKhuyenMai + ", phanTramKhuyenMai=" + phanTramKhuyenMai
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}

	
}
