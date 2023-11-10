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
import entity.NhanVien;
import entity.PhanLoai;
import entity.SanPham;

public class ChiTietHoaDonDAO {
	ArrayList<ChiTietHoaDon> dscthd;
	ChiTietHoaDon cthd;
//	ChatLieuDAO cld = new ChatLieuDAO();
//	KichThuocDAO ktd = new KichThuocDAO();
//	PhanLoaiDAO pld = new PhanLoaiDAO();
//	MauSacDAO msd = new MauSacDAO();
//	KieuDangDAO kdd = new KieuDangDAO();

	public ChiTietHoaDonDAO() {
		KetNoiSQL.getInstance().connect();
		dscthd = new ArrayList<ChiTietHoaDon>();
	}

	// Lấy danh sách thông tin Chi Tiết Hóa Đơn từ SQL
	public ArrayList<ChiTietHoaDon> getChiTietHoaDonTheoMaHD(String maHD) {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			PreparedStatement stmt = null;
			String sql = "Select chd.maSP,sp.tenSP,sp.giaBan,chd.soLuong,chd.phanTramKhuyenmai,cl.chatLieu,kd.kieuDang,kt.kichThuoc,ms.mauSac,pl.phanLoai\r\n"
					+ "from ChiTietHoaDon chd join sanPham sp on chd.maSP = sp.maSP left join KhuyenMai km on sp.maKM = km.maKM\r\n"
					+ "join ChatLieu cl on sp.maCL = cl.maCL join KieuDang kd on sp.maKD = kd.maKD join KichThuoc kt on sp.maKT = kt.maKT\r\n"
					+ "join MauSac ms on sp.maMS = ms.maMS join PhanLoai pl on sp.maPL = pl.maPL where chd.maHD = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHD);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				Double giaBan = rs.getDouble(3);
				int soLuong = rs.getInt(4);
				Double phanTramKhuyenMai = rs.getDouble(5);
				String chatLieu = rs.getString(6);
				String kieuDang = rs.getString(7);
				String kichThuoc = rs.getString(8);
				String mauSac = rs.getString(9);
				String phanLoai = rs.getString(10);

//				ChatLieu cl = cld.getChatLieu(chatLieu);
//				KieuDang kd = kdd.getKieuDang(kieuDang);
//				KichThuoc kt = ktd.getKichThuoc(phanLoai);
//				MauSac ms = msd.getMauSac(mauSac);
//				PhanLoai pl = pld.getPhanLoai(phanLoai);

				ChiTietHoaDon cthd = new ChiTietHoaDon(
						new SanPham(maSP, tenSP, new PhanLoai(null, phanLoai), 0, 0, null, giaBan,
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
}
