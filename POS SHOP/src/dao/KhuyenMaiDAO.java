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
public class KhuyenMaiDAO {
	ArrayList<KhuyenMai> dskm;
	KhuyenMai km;
	
	public KhuyenMaiDAO() {
		KetNoiSQL.getInstance();
		dskm = new ArrayList<KhuyenMai>();
	}
	
	public List<KhuyenMai> doTuBang() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "Select * from KhuyenMai";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
				String ma = rs.getString(1);
				Double phanTram = rs.getDouble(2);
				String ten = rs.getString(3);
				Date nbd = rs.getDate(4);
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang dd-MM-yyyy
				String ngayBatDau = dataFormat.format(nbd);
				Date nkt = rs.getDate(5);
				String ngayKetThuc = dataFormat.format(nkt); // Chuyển định dang yyyy-MM-dd sang dd-MM-yyyy
				KhuyenMai km = new KhuyenMai(ma, ten, phanTram, nbd, nkt);
				dskm.add(km);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskm;
	}
}










