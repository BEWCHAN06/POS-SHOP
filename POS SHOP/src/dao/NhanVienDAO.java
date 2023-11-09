package dao;

import ConnectDB.KetNoiSQL;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAO {

    public NhanVienDAO() {
    }
    
    public ArrayList<NhanVien>getAllNhanVien(){
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        
        try {
            String sql = "Select * from nhanvien";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdt, email, cmnd, cv, dc, cv, trangthai);
                listNhanVien.add(nv);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listNhanVien;
    }
           
    public ArrayList<NhanVien>getAllNhanVienConHoatDong(){
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        
        try {
            String sql = "  Select * from nhanvien where isDeleted IS NULL OR isDeleted = 0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdt, email, cmnd, cv, dc, cv, trangthai);
                listNhanVien.add(nv);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listNhanVien;
    }
    
    public NhanVien getNhanVienByID(String id){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        try {
           
            String sql = "select * from nhanvien where maNhanVien = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdt, email, cmnd, cv, dc, cv, trangthai);
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
	
     public NhanVien getNhanVienByName(String name){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        try {
           
            String sql = "select * from nhanvien where hoVaTen = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdt, email, cmnd, cv, dc, cv, trangthai);
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     	public NhanVien getNhanVienBySdt(String sdt) {
		KetNoiSQL.getInstance();
		Connection conn = KetNoiSQL.getConnection();

		try {
			String sql = "select * from nhanvien where sdt = ?";
			PreparedStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, sdt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdtt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdtt, email, cmnd, cv, dc, cv, trangthai);
				return nv;
			}
		} catch (SQLException ex) {
			Logger.getLogger(XuatXuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

    public NhanVien getNhanVienByGmail(String gmail){
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();
        try {
           
            String sql = "select * from nhanvien where email = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, gmail);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String manv = rs.getString(1);
                String tennv = rs.getString(2);
                Date ns = rs.getDate(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                String cmnd = rs.getString(6);
                double gioitinh = rs.getDouble(7);
                String dc = rs.getString(8);
                boolean cv = rs.getBoolean(9);
                int trangthai = rs.getInt(10);
                NhanVien nv = new NhanVien(manv, tennv, ns, sdt, email, cmnd, cv, dc, cv, trangthai);
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public int updateNhanVien(NhanVien nhanVien){
//        KetNoiSQL.getInstance();
//        Connection conn = KetNoiSQL.getConnection();
//        System.out.println(nhanVien);
//        try {
//            String sql = "update nhanvien set hoVaTen = ?,ngaySinh = ?,diaChi = ?,sdt = ?, gioiTinh = ?,luong = ?,email = ?,chucVu = ? where maNhanVien = ?";
//            
//            PreparedStatement stmt = conn.prepareCall(sql);
//            stmt.setString(1, nhanVien.getHoVaTen());
//            stmt.setDate(2,new Date(nhanVien.getNgaySinh().getTime()));
//            stmt.setString(3, nhanVien.getDiaChi());
//            stmt.setString(4, nhanVien.getSdt());
//            stmt.setBoolean(5, nhanVien.getGioiTinh());
//            stmt.setLong(6, nhanVien.getLuong());
//            stmt.setString(7, nhanVien.getEmail());
//            stmt.setString(8, nhanVien.getChucVu());
//            stmt.setString(9, nhanVien.getMaNhanVien());
//            
//            return stmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//    }
//    
//    public int updateOTP(String gmail, String OTP, Timestamp expiredAt){
//        KetNoiSQL.getInstance();
//        Connection conn = KetNoiSQL.getConnection();
//        try {
//           
//            String sql = "update nhanvien set OTP = ?, expriedAt = ? where email = ?";
//            PreparedStatement stmt = conn.prepareCall(sql);
//            stmt.setString(1, OTP);
//            stmt.setTimestamp(2, expiredAt);
//            stmt.setString(3, gmail);
//            
//            return stmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//    }
//    
//    public int xoaNhanVien(String maNhanVien){
//        KetNoiSQL.getInstance();
//        Connection conn = KetNoiSQL.getConnection();
//        try {
//           
//            String sql = "update nhanvien set isDeleted = 1 where maNhanVien = ?";
//            PreparedStatement stmt = conn.prepareCall(sql);
//            stmt.setString(1, maNhanVien); 
//            
////            if(taiKhoan_DAO.xoaTaiKhoan(maNhanVien) != -1);
//            
//            return stmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//
//    }
//    
//    public int addNhanVien(NhanVien nhanVien){
//        KetNoiSQL.getInstance();
//        Connection conn = KetNoiSQL.getConnection();
//        try {
//            String sql = "insert into nhanvien(maNhanVien, hoVaTen, ngaySinh, diaChi, sdt, gioiTinh, luong, email, chucVu)"
//                + "                 values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement stmt = conn.prepareCall(sql);
//            stmt.setString(1, nhanVien.getMaNhanVien());
//            stmt.setString(2, nhanVien.getHoVaTen());
//            stmt.setDate(3, new Date(nhanVien.getNgaySinh().getTime()));
//            stmt.setString(4, nhanVien.getDiaChi());
//            stmt.setString(5, nhanVien.getSdt());
//            stmt.setBoolean(6, nhanVien.getGioiTinh());
//            stmt.setInt(7, nhanVien.getLuong());
//            stmt.setString(8, nhanVien.getEmail());
//            stmt.setString(9, nhanVien.getChucVu());
//            
//            return stmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return -1;
//    }
}

