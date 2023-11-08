package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectDB.KetNoiSQL;
import entity.KhuyenMai;
import entity.PhanLoai;

public class KhuyenMaiDAO {
	ArrayList<KhuyenMai> dskm;
	KhuyenMai km;

	public KhuyenMaiDAO() {
		KetNoiSQL.getInstance().connect();
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
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang
																					// dd-MM-yyyy
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

	// Thêm khuyến mãi
	public boolean createKhuyenMai(KhuyenMai km) {
		Connection con = KetNoiSQL.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			stmt = con.prepareStatement("insert into KhuyenMai values(?, ?, ?, ?, ?)");
			stmt.setString(1, km.getMaKM());
			stmt.setDouble(2, km.getPhanTramKhuyenMai());
			stmt.setString(3, km.getTenKhuyenMai());
			stmt.setDate(4,  (Date) km.getNgayBatDau());
			stmt.setDate(5,  (Date) km.getNgayKetThuc());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public KhuyenMai getKhuyenMai(String id) {
		KetNoiSQL.getInstance();
		Connection conn = KetNoiSQL.getConnection();
		try {
			String sql = "select * from KhuyenMai where maKM = ?";
			PreparedStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String makm = rs.getString(1);
				int ptkm = rs.getInt(2);
				String tenkm = rs.getString(3);
				Date ngayBD = rs.getDate(4);
				Date ngayKT = rs.getDate(5);
				KhuyenMai km = new KhuyenMai(makm, tenkm, ptkm, ngayBD, ngayKT);
				return km;
			}
		} catch (SQLException ex) {
			Logger.getLogger(XuatXuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}
<<<<<<< HEAD

=======
	public KhuyenMai getKhuyenMaiByPhanTram(int phanTram) {
        KetNoiSQL.getInstance();
        Connection conn = KetNoiSQL.getConnection();

        try {
            String sql = "select * from khuyenmai where phanTramKhuyenMai = ?";
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, phanTram);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhuyenMai khuyenMai = new KhuyenMai();
                khuyenMai.setMaKM(rs.getString(1));
                khuyenMai.setPhanTramKhuyenMai(rs.getInt(2));
                khuyenMai.setTenKhuyenMai(rs.getString(3));
                khuyenMai.setNgayBatDau(rs.getDate(4));
                khuyenMai.setNgayKetThuc(rs.getDate(5));

                return khuyenMai;
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatXuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
>>>>>>> 9ef33824eb6c1a015d6922310a3c59da9673dba8
}
