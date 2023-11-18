package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.TaiKhoan;

public class TaiKhoanDAO {
	ArrayList<TaiKhoan> dstk;
	TaiKhoan tk;

	public TaiKhoanDAO() {
		dstk = new ArrayList<TaiKhoan>();
	}

	// Lấy email nhân viên theo tên tài khoản
	public String getEmailTheoTenTaiKhoan(String tenTK) {
		try {
			KetNoiSQL.getInstance().connect();
			PreparedStatement stmt = null;
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "Select nv.email from TaiKhoan tk join NhanVien nv on tk.maNV = nv.maNV\r\n"
					+ "where tk.tenTaiKhoan = ?";
			stmt = con.prepareStatement(sql); // Thực thi câu lệnh SQL trả về ResulSet.
			stmt.setString(1, tenTK);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString("email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
