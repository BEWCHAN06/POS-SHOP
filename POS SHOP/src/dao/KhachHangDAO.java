package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

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
}
