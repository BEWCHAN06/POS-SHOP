package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonDAO {
	ArrayList<HoaDon> dshd;
	HoaDon hd;

	public HoaDonDAO() {
		KetNoiSQL.getInstance().connect();
		dshd = new ArrayList<HoaDon>();
	}

	// Lấy danh sách thông tin hóa hóa đơn từ SQL
	public List<HoaDon> doTuBang() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				String maNV = rs.getString(3);
				String tenNV = rs.getString(4);
				String maKH = rs.getString(5);
				String tenKH = rs.getString(6);
				HoaDon hd = new HoaDon(maHD, ngayLap, new KhachHang(maKH, tenKH, null, null, null, false),
						new NhanVien(maNV, tenNV, null, null, null, null, false, null, false, 0));
				dshd.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
	
	// Tìm danh sách hóa đơn theo tháng
	public List<HoaDon> getHoaDonTheoThang(int thang) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "Select * From HoaDon Where MONTH(ngayLap) = ?;";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, thang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				String maNV = rs.getString(3);
				String tenNV = rs.getString(4);
				String maKH = rs.getString(5);
				String tenKH = rs.getString(6);
				HoaDon hd = new HoaDon(maHD, ngayLap, new KhachHang(maKH, tenKH, null, null, null, false),
						new NhanVien(maNV, tenNV, null, null, null, null, false, null, false, 0));
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return dshd;
	}
	
	// Tìm danh sách hóa đơn theo tháng
		public List<HoaDon> getHoaDonTheoNam(int nam) {
			try {
				KetNoiSQL.getInstance().connect();
				Connection con = KetNoiSQL.getInstance().getConnection();
				String sql = "Select * From HoaDon Where YEAR(ngayLap) = ?;";
				PreparedStatement stmt = con.prepareCall(sql);
				stmt.setInt(1, nam);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString(1);
					Date ngayLap = rs.getDate(2);
					String maNV = rs.getString(3);
					String tenNV = rs.getString(4);
					String maKH = rs.getString(5);
					String tenKH = rs.getString(6);
					HoaDon hd = new HoaDon(maHD, ngayLap, new KhachHang(maKH, tenKH, null, null, null, false),
							new NhanVien(maNV, tenNV, null, null, null, null, false, null, false, 0));
					dshd.add(hd);
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			return dshd;
		}
}
