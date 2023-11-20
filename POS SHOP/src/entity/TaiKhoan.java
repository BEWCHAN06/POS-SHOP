package entity;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private boolean loaiTaiKhoan;
	private NhanVien nhanVien;

	public TaiKhoan() {
		// Constructor mặc nhiên
	}

	public TaiKhoan(String tenTaiKhoan, String matKhau, boolean loaiTaiKhoan, NhanVien nhanVien) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.nhanVien = nhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(boolean loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", loaiTaiKhoan=" + loaiTaiKhoan
				+ ", nhanVien=" + nhanVien + "]";
	}
}