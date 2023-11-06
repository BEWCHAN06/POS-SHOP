package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.KhuyenMai;
import entity.SanPham;

public class SanPhamDAO {
	ArrayList<SanPham> dssp;
	SanPham sp;
	
	public SanPhamDAO() {
		KetNoiSQL.getInstance();
		dssp = new ArrayList<SanPham>();
	}
	
	public List<SanPham> doTuBang() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "Select * from SanPham";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				Double giaNhap = rs.getDouble(3);
				String NCC = rs.getString(4);
				String KM = rs.getString(5);
				int trangThai = rs.getInt(6);
				String CL = rs.getString(7);
				String KD = rs.getString(8);
				String KT = rs.getString(9);
				String MS = rs.getString(10);
				String XX = rs.getString(11);
				String PL = rs.getString(12);
				int loi = rs.getInt(13);
				Double giaBan = rs.getDouble(14);
				SanPham sp = new SanPham(ma, ten, giaNhap, giaBan, null, null, trangThai, null, null, null, null, null, null, loi);
				dssp.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
}
