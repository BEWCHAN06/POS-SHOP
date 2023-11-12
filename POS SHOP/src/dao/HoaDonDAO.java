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
import entity.ChatLieu;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.KichThuoc;
import entity.KieuDang;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.PhanLoai;
import entity.SanPham;
import entity.XuatXu;

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
	public HoaDon getHDTheoId(String id) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select * from HoaDon where maHD =(?)";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String mahd = rs.getString(1);
				Date ngaylap = rs.getDate(2);
				String makh = rs.getString(3);
				String manv = rs.getString(4);
				KhachHang kh = khachHangDAO.getKhachHang(makh);
				NhanVien nv = nhanVienDAO.getNhanVienByID(manv);
				HoaDon hd = new HoaDon(mahd, ngaylap, kh, nv);
				return hd;
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH)
	public List<HoaDon> getHoaDonTheoTuKhoa(String tukhoa) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where hd.maHD like ? or hd.maNV like ? or nv.tenNV like ? or hd.maKH like ? or kh.tenKH like ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm danh sách hóa đơn theo tổng tiền
	public List<HoaDon> getHoaDonTheoTongTien(int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "WHERE ((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, giaMin);
			stmt.setInt(2, giaMax);
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
	public List<HoaDon> getHDCho() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select * from HoaDon where trangthai = 1";
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
	public int addHoaDon(HoaDon hoaDon) {
			KetNoiSQL.getInstance().connect();
	    try {
	    	Connection con = KetNoiSQL.getInstance().getConnection();
	        String sql = "Insert into HoaDon values(?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setString(1, hoaDon.getMaHoaDon());
	        ps.setDate(2, Date.valueOf(hoaDon.getNgayLap().toString()));
	        if(hoaDon.getKhachHang() == null) {
	        	ps.setString(3, "");
	        }else {
	        	ps.setString(3, hoaDon.getKhachHang().getMaKH());
	        }
	        
	        ps.setString(4, hoaDon.getNhanVien().getMaNV());
	        ps.setInt(5, hoaDon.getTrangthai());
	
	        return ps.executeUpdate();
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    }
	    return -1;
	}
	// Tìm danh sách hóa đơn theo tháng
	public List<HoaDon> getHoaDonTheoThang(int thang) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where MONTH(ngayLap) = ?";
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

	// Tìm danh sách hóa đơn theo năm
	public List<HoaDon> getHoaDonTheoNam(int nam) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where YEAR(ngayLap) = ?;";
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

	// Tìm danh sách hóa đơn theo cả tháng và năm
	public List<HoaDon> getHoaDonTheoThangNam(int thang, int nam) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where MONTH(hd.ngayLap) = ? and YEAR(ngayLap) = ?;";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, thang);
			stmt.setInt(2, nam);
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

	// Tìm danh sách hóa đơn theo tổng tiền và tháng
	public List<HoaDon> getHoaDonTheoTongTienThang(int thang, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where MONTH(hd.ngayLap) = ? AND \r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, thang);
			stmt.setInt(2, giaMin);
			stmt.setInt(3, giaMax);
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

	// Tìm danh sách hóa đơn theo tổng tiền và năm
	public List<HoaDon> getHoaDonTheoTongTienNam(int nam, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where YEAR(hd.ngayLap) = ? AND \r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, nam);
			stmt.setInt(2, giaMin);
			stmt.setInt(3, giaMax);
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

	// Tìm danh sách hóa đơn theo tổng tiền, tháng và năm
	public List<HoaDon> getHoaDonTheoTongTienThangNam(int thang, int nam, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? AND\r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setInt(1, thang);
			stmt.setInt(2, nam);
			stmt.setInt(3, giaMin);
			stmt.setInt(4, giaMax);
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

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH) và tháng
	public List<HoaDon> getHoaDonTheoTuKhoaThang(String tukhoa, int thang) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where (hd.maHD like ? or hd.maNV like ? or nv.tenNV like ? or hd.maKH like ? or kh.tenKH like ?) "
					+ "AND MONTH(hd.ngayLap) = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, thang);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH) và năm
	public List<HoaDon> getHoaDonTheoTuKhoaNam(String tukhoa, int nam) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "from HoaDon hd join NhanVien nv on hd.maNV = nv.maNV\r\n"
					+ "join KhachHang kh on hd.maKH = kh.maKH where (hd.maHD like ? or hd.maNV like ? or nv.tenNV like ? or hd.maKH like ? or kh.tenKH like ?) "
					+ "AND YEAR(hd.ngayLap) = ?";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, nam);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH) và tổng tiền
	public List<HoaDon> getHoaDonTheoTuKhoaTongTien(String tukhoa, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where (hd.maHD LIKE ? or hd.maNV LIKE ? or nv.tenNV LIKE ? or hd.maKH LIKE ? OR kh.tenKH LIKE ?) \r\n"
					+ "AND ((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, giaMin);
			stmt.setInt(7, giaMax);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH), tháng và tổng
	// tiền
	public List<HoaDon> getHoaDonTheoTuKhoaThangTongTien(String tukhoa, int thang, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where (hd.maHD LIKE ? or hd.maNV LIKE ? or nv.tenNV LIKE ? or hd.maKH LIKE ? OR kh.tenKH LIKE ?) \r\n"
					+ "AND MONTH(hd.ngayLap) = ? AND\r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, thang);
			stmt.setInt(7, giaMin);
			stmt.setInt(8, giaMax);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH), năm và tổng
	// tiền
	public List<HoaDon> getHoaDonTheoTuKhoaNamTongTien(String tukhoa, int nam, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where (hd.maHD LIKE ? or hd.maNV LIKE ? or nv.tenNV LIKE ? or hd.maKH LIKE ? OR kh.tenKH LIKE ?) \r\n"
					+ "AND YEAR(hd.ngayLap) = ? AND\r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, nam);
			stmt.setInt(7, giaMin);
			stmt.setInt(8, giaMax);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH), thang, năm và
	// tổng tiền
	public List<HoaDon> getHoaDonTheoTuKhoaThangNamTongTien(String tukhoa, int thang, int nam, int giaMin, int giaMax) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where (hd.maHD LIKE ? or hd.maNV LIKE ? or nv.tenNV LIKE ? or hd.maKH LIKE ? OR kh.tenKH LIKE ?) \r\n"
					+ "AND MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? AND\r\n"
					+ "((sp.giaNhap + sp.giaNhap * sp.loiTheoPhanTram / 100) * cthd.soLuong * (1 - cthd.phanTramKhuyenMai / 100)) \r\n"
					+ "BETWEEN ? AND ? GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, thang);
			stmt.setInt(7, nam);
			stmt.setInt(8, giaMin);
			stmt.setInt(9, giaMax);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	// Tìm kiếm hóa đơn theo từ khóa (maHD, maNV, tenNV, maKH, tenKH), thang và năm
	public List<HoaDon> getHoaDonTheoTuKhoaThangNam(String tukhoa, int thang, int nam) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH\r\n"
					+ "From HoaDon hd join ChiTietHoaDon cthd on cthd.maHD = hd.maHD join SanPham sp on cthd.maSP = sp.maSP \r\n"
					+ "join NhanVien nv on hd.maNV = nv.maNV join KhachHang kh on hd.maKH = kh.maKH\r\n"
					+ "Where (hd.maHD LIKE ? or hd.maNV LIKE ? or nv.tenNV LIKE ? or hd.maKH LIKE ? OR kh.tenKH LIKE ?) \r\n"
					+ "AND MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? \r\n"
					+ "GROUP BY hd.maHD, hd.ngayLap, hd.maNV, nv.tenNV, hd.maKH, kh.tenKH";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, "%" + tukhoa + "%");
			stmt.setString(2, "%" + tukhoa + "%");
			stmt.setString(3, "%" + tukhoa + "%");
			stmt.setString(4, "%" + tukhoa + "%");
			stmt.setString(5, "%" + tukhoa + "%");
			stmt.setInt(6, thang);
			stmt.setInt(7, nam);
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
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
}
