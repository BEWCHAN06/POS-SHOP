package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.ChatLieu;
import entity.KhuyenMai;
import entity.KichThuoc;
import entity.MauSac;
import entity.NhaCungCap;
import entity.PhanLoai;
import entity.SanPham;

public class SanPhamDAO {
	ArrayList<SanPham> dssp;
	SanPham sp;
	ChatLieuDAO chatLieuDao = new ChatLieuDAO();
	KieuDangDAO kieuDangDao = new KieuDangDAO();
	KichThuocDAO kichThuocDao = new KichThuocDAO();
	MauSacDAO mauSacDAO = new MauSacDAO();
	XuatXuDAO xuatXuDAO = new XuatXuDAO();
	PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO();
	NhaCungCapDAO nhaCungCapDao = new NhaCungCapDAO();
	KhuyenMaiDAO khuyenMaiDao = new KhuyenMaiDAO();

	public SanPhamDAO() {

		KetNoiSQL.getInstance().connect();;
		dssp = new ArrayList<SanPham>();
	}

	public List<SanPham> doTuBang() {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select sp.maSP, tenSP, maPL, giaNhap,loiTheoPhanTram, maKM, giaBan, maKT,soLuong,maMS, maCL, maNCC, hinhAnh  from SanPham sp join ChiTietHoaDon cthd on sp.maSP = cthd.maSP";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String masp = rs.getString("maSP");
				String ten = rs.getString("tenSP");
				String maloai = rs.getString("maPL");
				float giaNhap = rs.getFloat("giaNhap");
				int loi = rs.getInt("loiTheoPhanTram");
				String maKm = rs.getString("maKM");
				float giaBan = rs.getFloat("giaBan");
				String makt = rs.getString("maKT");
				int sl = rs.getInt("soLuong");
				String mams = rs.getString("maMS");
				String macl = rs.getString("maCL");
				String mancc = rs.getString("maNCC");
				String hinhAnh = rs.getString("hinhAnh");

				PhanLoai phanloai = phanLoaiDAO.getPhanLoai(maloai);
				KhuyenMai khuyenmai = khuyenMaiDao.getKhuyenMai(maKm);
				KichThuoc kt = kichThuocDao.getKichThuoc(makt);
				MauSac ms = mauSacDAO.getMauSac(mams);
				ChatLieu cl = chatLieuDao.getChatLieu(macl);
				NhaCungCap ncc = nhaCungCapDao.getNhaCungCap(mancc);

				SanPham sp = new SanPham(masp, ten, phanloai, giaNhap, loi, khuyenmai, giaBan, kt, sl, ms, cl, ncc,
						hinhAnh);
				dssp.add(sp);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}

	// Tìm sản phẩm theo phân loại
	public List<SanPham> getSanPhanTheoPhanLoai(String name) {
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select sp.maSP, tenSP, maPL, giaNhap,loiTheoPhanTram, maKM, giaBan, maKT,soLuong,maMS, maCL, maNCC, hinhAnh \r\n"
					+ "from SanPham sp join ChiTietHoaDon cthd on sp.maSP = cthd.maSP \r\n"
					+ "where maPL = (select maPL from PhanLoai where phanLoai = (?))";
			PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String masp = rs.getString("maSP");
				String ten = rs.getString("tenSP");
				String maloai = rs.getString("maPL");
				float giaNhap = rs.getFloat("giaNhap");
				int loi = rs.getInt("loiTheoPhanTram");
				String maKm = rs.getString("maKM");
				float giaBan = rs.getFloat("giaBan");
				String makt = rs.getString("maKT");
				int sl = rs.getInt("soLuong");
				String mams = rs.getString("maMS");
				String macl = rs.getString("maCL");
				String mancc = rs.getString("maNCC");
				String hinhAnh = rs.getString("hinhAnh");

				PhanLoai phanloai = phanLoaiDAO.getPhanLoai(maloai);
				KhuyenMai khuyenmai = khuyenMaiDao.getKhuyenMai(maKm);
				KichThuoc kt = kichThuocDao.getKichThuoc(makt);
				MauSac ms = mauSacDAO.getMauSac(mams);
				ChatLieu cl = chatLieuDao.getChatLieu(macl);
				NhaCungCap ncc = nhaCungCapDao.getNhaCungCap(mancc);

				SanPham sp = new SanPham(masp, ten, phanloai, giaNhap, loi, khuyenmai, giaBan, kt, sl, ms, cl, ncc,
						hinhAnh);
				dssp.add(sp);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}
}
