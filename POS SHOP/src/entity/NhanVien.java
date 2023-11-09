package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private Date ngaySinh;
    private String SDT;
    private String email;
    private String CMND;
    private boolean gioiTinh;
    private String diaChi;
    private boolean chucVu;
    private int trangThai;
    
	public NhanVien(String maNV, String tenNV, Date ngaySinh, String sDT, String email, String cMND, boolean gioiTinh,
			String diaChi, boolean chucVu, int trangThai) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.SDT = sDT;
		this.email = email;
		this.CMND = cMND;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		this.SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		this.CMND = cMND;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", email="
				+ email + ", CMND=" + CMND + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", chucVu=" + chucVu
				+ ", trangThai=" + trangThai + "]";
	}
}
