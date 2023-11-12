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
import entity.SanPham;

public class HoaDonDAO {
	ArrayList<HoaDon> dshd;
	HoaDon hd;
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
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
	public List<HoaDon> getHDCho() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select * from HoaDon where trangthai = 0";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String mahd = rs.getString(1);
				Date ngaylap = rs.getDate(2);
				String makh = rs.getString(3);
				String manv = rs.getString(4);
				KhachHang kh = khachHangDAO.getKhachHang(makh);
				NhanVien nv = nhanVienDAO.getNhanVienByID(manv);
				HoaDon hd = new HoaDon(mahd, ngaylap, kh, nv);
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
		public int addHoaDon(HoaDon hoaDon) {
			KetNoiSQL.getInstance().connect();
        try {
        	Connection con = KetNoiSQL.getInstance().getConnection();
            String sql = "Insert into HoaDon values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, hoaDon.getMaHoaDon());
            ps.setDate(2, Date.valueOf(hoaDon.getNgayLap().toString()));
            ps.setString(3, hoaDon.getKhachHang().getMaKH());
            ps.setString(4, hoaDon.getNhanVien().getMaNV());
            ps.setInt(5, hoaDon.getTrangthai());

            return ps.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return -1;
    }
}
