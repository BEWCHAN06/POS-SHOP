package entity;

public class ChiTietHoaDon {
	private SanPham sanPham;
	private HoaDon hoaDon;
	private double phanTramKhuyenMai;
	private int soLuong;

	public ChiTietHoaDon() {
		// Constructor mặc nhiên
	}

	public ChiTietHoaDon(SanPham sanPham, HoaDon hoaDon, double phanTramKhuyenMai, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public double getPhanTramKhuyenMai() {
		return phanTramKhuyenMai;
	}

	public void setPhanTramKhuyenMai(double phanTramKhuyenMai) {
		this.phanTramKhuyenMai = phanTramKhuyenMai;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double thanhTien() {
		if (sanPham != null) {
			double giaSanPham = sanPham.getGiaBan(); // Giả sử có phương thức getGia() trong class SanPham
			return soLuong * giaSanPham;
		} else {
			throw new IllegalArgumentException("Sản phẩm không được null");
		}
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [soLuong=" + soLuong + ", sanPham=" + sanPham + ", hoaDon=" + hoaDon + "]";
	}
}
