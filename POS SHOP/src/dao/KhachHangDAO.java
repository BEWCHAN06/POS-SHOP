package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectDB.KetNoiSQL;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhanLoai;

public class KhachHangDAO {
	ArrayList<KhachHang> dskh;
	KhachHang kh;
	public KhachHangDAO() {
		KetNoiSQL.getInstance().connect();
		dskh = new ArrayList<KhachHang>();
	}

	// Lấy danh sách thông tin hóa hóa đơn từ SQL
	public ArrayList<KhachHang> doTuBang() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String makh = rs.getString(1);
				String tenkh = rs.getString(2);
				Date ngaysinh = rs.getDate(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				boolean gioitinh = rs.getBoolean(6);
				KhachHang kh = new KhachHang(makh, tenkh, ngaysinh, email, sdt, gioitinh);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public KhachHang getKhachHang(String id){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        
        try {
            String sql = "select * from KhachHang where maKH = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setNgaySinh(rs.getDate(3));
                kh.setSDT(rs.getString(4));
                kh.setEmail(rs.getString(5));
                kh.setGioiTinh(rs.getBoolean(6));
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatXuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	public int addKhachHang(KhachHang khachHang){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        try {
            String sql = "insert into khachhang(maKH, tenKH, ngaySinh, SDT,email,gioiTinh)"
                + "                 values(?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, khachHang.getMaKH());
            stmt.setString(2, khachHang.getTenKH());
            stmt.setDate(3, new Date(khachHang.getNgaySinh().getTime()));
            stmt.setString(4,khachHang.getSDT());
            stmt.setString(5, khachHang.getEmail());
            stmt.setBoolean(6, khachHang.isGioiTinh());
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> listKhachHang = new ArrayList<>();
		KetNoiSQL.getInstance();
		Connection conn = KetNoiSQL.getConnection();

		try {
			String sql = "Select * from khachhang";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String makh = rs.getString(1);
				String tenkh= rs.getString(2);
				Date ns = rs.getDate(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				
				boolean gioitinh = rs.getBoolean(6);
				KhachHang kh = new KhachHang(makh ,tenkh,ns,sdt,email,gioitinh);
				listKhachHang.add(kh);
			}

		} catch (SQLException ex) {
			Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listKhachHang;
	}
 	public int updateKhachHang(KhachHang khachHang){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        System.out.println(khachHang);
        try {
            String sql = "update khachhang set tenKH = ?,ngaySinh = ?,SDT = ?,email = ?, gioiTinh = ?, where maKH = ?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            
            stmt.setString(1, khachHang.getTenKH());
            stmt.setDate(2, new Date(khachHang.getNgaySinh().getTime()));
            stmt.setString(3, khachHang.getSDT());
            stmt.setString(4, khachHang.getEmail());
            stmt.setBoolean(5, khachHang.isGioiTinh());
            stmt.setString(6, khachHang.getMaKH());
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
