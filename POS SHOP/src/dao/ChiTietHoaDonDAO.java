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
import entity.ChiTietHoaDon;
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

public class ChiTietHoaDonDAO {
	ArrayList<ChiTietHoaDon> dscthd;
	ChiTietHoaDon cthd;

	public ChiTietHoaDonDAO() {
		KetNoiSQL.getInstance().connect();
		dscthd = new ArrayList<ChiTietHoaDon>();
	}

	// Lấy danh sách thông tin Chi Tiết Hóa Đơn từ SQL
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonTheoMaHD(String maHD) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "Select chd.maSP,sp.tenSP,sp.giaNhap,sp.loiTheoPhanTram,chd.soLuong,chd.phanTramKhuyenmai,cl.chatLieu,kd.kieuDang,kt.kichThuoc,ms.mauSac,pl.phanLoai\r\n"
					+ "from ChiTietHoaDon chd join sanPham sp on chd.maSP = sp.maSP left join KhuyenMai km on sp.maKM = km.maKM\r\n"
					+ "join ChatLieu cl on sp.maCL = cl.maCL join KieuDang kd on sp.maKD = kd.maKD join KichThuoc kt on sp.maKT = kt.maKT\r\n"
					+ "join MauSac ms on sp.maMS = ms.maMS join PhanLoai pl on sp.maPL = pl.maPL where chd.maHD = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				Double giaNhap = rs.getDouble(3);
				int loi = rs.getInt(4);
				int soLuong = rs.getInt(5);
				Double phanTramKhuyenMai = rs.getDouble(6);
				String chatLieu = rs.getString(7);
				String kieuDang = rs.getString(8);
				String kichThuoc = rs.getString(9);
				String mauSac = rs.getString(10);
				String phanLoai = rs.getString(11);
				ChiTietHoaDon cthd = new ChiTietHoaDon(
						new SanPham(maSP, tenSP, new PhanLoai(null, phanLoai), giaNhap, loi, null, 0,
								new KichThuoc(null, kichThuoc), 0, new MauSac(null, mauSac),
								new ChatLieu(null, chatLieu), null, new KieuDang(null, kieuDang), null, null, 0),
						null, phanTramKhuyenMai, soLuong);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
	}
	
	public int addSanPhamVaoHD(ChiTietHoaDon chiTietHoaDon) {
		KetNoiSQL.getInstance().connect();
    try {
    	Connection con = KetNoiSQL.getInstance().getConnection();
        String sql = "Insert into ChiTietHoaDon values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, chiTietHoaDon.getSanPham().getMaSP());
        ps.setString(2, chiTietHoaDon.getHoaDon().getMaHoaDon());
        ps.setDouble(3, chiTietHoaDon.getPhanTramKhuyenMai());
        ps.setInt(4, chiTietHoaDon.getSoLuong());
        ps.setDouble(5, chiTietHoaDon.getThanhTien());
        return ps.executeUpdate();
    } catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return -1;
	}
    
    public int updateSoLuongSPTrongGio(ChiTietHoaDon chiTietHoaDon) {
		KetNoiSQL.getInstance().connect();
		;
		Connection conn = KetNoiSQL.getConnection();

		try {
			String sql = "update ChiTietHoaDon set soLuong =(?), thanhTien =(?) where maSP =(?) and maHD = (?)";

			PreparedStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, chiTietHoaDon.getSoLuong());
			stmt.setDouble(2, chiTietHoaDon.getThanhTien());
			stmt.setString(3, chiTietHoaDon.getSanPham().getMaSP());
			stmt.setString(4, chiTietHoaDon.getHoaDon().getMaHoaDon());
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
    }
    public int	deleteMotSP(ChiTietHoaDon chiTietHoaDon) {
		KetNoiSQL.getInstance().connect();
		;
		Connection conn = KetNoiSQL.getConnection();

		try {
			String sql = "delete ChiTietHoaDon where maSP = (?) and maHD = (?)";

			PreparedStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, chiTietHoaDon.getSanPham().getMaSP());
			stmt.setString(2, chiTietHoaDon.getHoaDon().getMaHoaDon());
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return -1;
    }
    
    public double getTongTien(String id) {
    	double thanhtien = 0;
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select sum(thanhTien) from ChiTietHoaDon where maHD = (?) group by maHD";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				thanhtien = rs.getDouble(1);
				
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thanhtien;
	}
}
