package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon {
	private String maHoaDon;
	private Date ngayLap;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private List<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();

	public HoaDon() {
		// Constructor mặc nhiên
	}

	public HoaDon(String maHoaDon, Date ngayLap, KhachHang khachHang, NhanVien nhanVien) {
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		// Kiểm tra và xử lý logic kiểm tra maHoaDon
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		Date currentDate = new Date();
		if (ngayLap.after(currentDate)) {
			throw new IllegalArgumentException("Hóa đơn phải được lập ngày hiện tại");
		}
		this.ngayLap = ngayLap;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		// Kiểm tra và xử lý logic kiểm tra khachHang
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		// Kiểm tra và xử lý logic kiểm tra nhanVien
		this.nhanVien = nhanVien;
	}

	public List<ChiTietHoaDon> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		chiTietHoaDonList.add(chiTietHoaDon);
	}

	public double tongTien() {
		double tongTien = 0;
		for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonList) {
			tongTien += chiTietHoaDon.thanhTien();
		}
		return tongTien;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + dateFormat.format(ngayLap) + ", khachHang=" + khachHang
				+ ", nhanVien=" + nhanVien + "]";
	}
}
