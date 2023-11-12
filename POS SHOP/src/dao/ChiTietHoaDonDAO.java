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
        String sql = "Insert into ChiTietHoaDon values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, chiTietHoaDon.getSanPham().getMaSP());
        ps.setString(2, chiTietHoaDon.getHoaDon().getMaHoaDon());
        ps.setDouble(3, chiTietHoaDon.getPhanTramKhuyenMai());
        ps.setInt(4, chiTietHoaDon.getSoLuong());
//        ps.setString(1, sanPham.getMaSP());
//        ps.setString(2, sanPham.getTenSP());
//        ps.setDouble(3, sanPham.getGiaNhap());
//        ps.setInt(4, sanPham.getSoLuong());
//        ps.setString(5, sanPham.getNhaCungCap().getMaNCC());
//        ps.setString(6, null);
//        ps.setInt(7, sanPham.getTrangThai());
//        ps.setString(8, sanPham.getChatLieu().getMaChatLieu());
//        ps.setString(9, sanPham.getKieuDang().getMaKieuDang());
//        ps.setString(10, sanPham.getKichThuoc().getMaKichThuoc());
//        ps.setString(11, sanPham.getMauSac().getMaMauSac());
//        ps.setString(12, sanPham.getXuatXu().getMaXuatXu());
//        ps.setString(13, sanPham.getPl().getMaPhanLoai());
//        ps.setInt(14, sanPham.getLoi());
//        ps.setDouble(15, sanPham.getGiaBan());
//        ps.setString(16, sanPham.getHinhAnh());

        return ps.executeUpdate();
    } catch (SQLException ex) {
    	ex.printStackTrace();
    }
    return -1;
}
}
