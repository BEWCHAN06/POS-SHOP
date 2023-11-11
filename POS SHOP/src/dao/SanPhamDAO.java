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
import entity.KieuDang;
import entity.MauSac;
import entity.NhaCungCap;
import entity.PhanLoai;
import entity.SanPham;
import entity.XuatXu;

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

		KetNoiSQL.getInstance().connect();
		;
		dssp = new ArrayList<SanPham>();
	}

	public List<SanPham> doTuBang() {
		KetNoiSQL.getInstance().connect();
		try {
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select maSP, tenSP, maPL, giaNhap,loiTheoPhanTram, maKM, giaBan, maKT,soLuong,maMS, maCL, maNCC, hinhAnh  from SanPham ";
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
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select maSP, tenSP, maPL, giaNhap,loiTheoPhanTram, maKM, giaBan, maKT,soLuong,maMS, maCL, maNCC, hinhAnh \r\n"
					+ "from SanPham where maPL = (select maPL from PhanLoai where phanLoai = (?))";
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

	public SanPham getSanPhanTheoId(String id) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select maSP, tenSP, maPL, giaNhap,loiTheoPhanTram, maKM, giaBan, maKT,soLuong,maMS, maCL, maNCC,maKD,maXX, hinhAnh\r\n"
					+ "from SanPham where maSP like (?)";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, id);
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
				String makd = rs.getString("maKD");
				String maxx = rs.getString("maXX");
				String hinhAnh = rs.getString("hinhAnh");

				PhanLoai phanloai = phanLoaiDAO.getPhanLoai(maloai);
				KhuyenMai khuyenmai = khuyenMaiDao.getKhuyenMai(maKm);
				KichThuoc kt = kichThuocDao.getKichThuoc(makt);
				MauSac ms = mauSacDAO.getMauSac(mams);
				ChatLieu cl = chatLieuDao.getChatLieu(macl);
				NhaCungCap ncc = nhaCungCapDao.getNhaCungCap(mancc);
				KieuDang kd = kieuDangDao.getKieuDang(makd);
				XuatXu xx = xuatXuDAO.getXuatXu(maxx);

				SanPham sp = new SanPham(masp, ten, phanloai, giaNhap, loi, khuyenmai, giaBan, kt, loi, ms, cl, ncc, kd,
						xx, hinhAnh, sl);
				return sp;
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Tìm sản phẩm theo mã khuyến mãi
	public List<SanPham> getSanPhanTheoMaKM(String maKM) {
		try {
			KetNoiSQL.getInstance().connect();
			Connection con = KetNoiSQL.getInstance().getConnection();
			String sql = "select *from SanPham where maKM = (?)";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, maKM);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String masp = rs.getString("maSP");
				String ten = rs.getString("tenSP");
				Double giaBan = rs.getDouble("giaBan");
				SanPham sp = new SanPham(masp, ten, null, 0, 0, null, giaBan, null, 0, null, null, null, null);
				dssp.add(sp);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dssp;
	}

	// Cập nhật mã khuyến mãi cho sản phẩm
	public boolean updateMaKMChoSanPHam(String maSP, String maKM) {
		Connection con = KetNoiSQL.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SanPham set maKM = ? where maSP = ?");
			stmt.setString(1, maKM);
			stmt.setString(2, maSP);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public int addSanPham(SanPham sanPham) {
			KetNoiSQL.getInstance().connect();
        try {
        	Connection con = KetNoiSQL.getInstance().getConnection();
            String sql = "Insert into sanpham values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, sanPham.getMaSP());
            ps.setString(2, sanPham.getTenSP());
            ps.setDouble(3, sanPham.getGiaNhap());
            ps.setInt(4, sanPham.getSoLuong());
            ps.setString(5, sanPham.getNhaCungCap().getMaNCC());
            ps.setString(6, null);
            ps.setInt(7, sanPham.getTrangThai());
            ps.setString(8, sanPham.getChatLieu().getMaChatLieu());
            ps.setString(9, sanPham.getKieuDang().getMaKieuDang());
            ps.setString(10, sanPham.getKichThuoc().getMaKichThuoc());
            ps.setString(11, sanPham.getMauSac().getMaMauSac());
            ps.setString(12, sanPham.getXuatXu().getMaXuatXu());
            ps.setString(13, sanPham.getPl().getMaPhanLoai());
            ps.setInt(14, sanPham.getLoi());
            ps.setDouble(15, sanPham.getGiaBan());
            ps.setString(16, sanPham.getHinhAnh());

            return ps.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return -1;
    }
	public int updateSanPham(SanPham sanPham) {
        KetNoiSQL.getInstance().connect();;
        Connection conn = KetNoiSQL.getConnection();

        try {
            String sql = "update SanPham set tenSP = ?, giaNhap = ?,soLuong=?,maNCC = ?,\r\n"
            		+ "maKM =?, trangThai = ?, maCL = ?,maKD = ?, maMS = ?, maXX = ?,maPL= ?, \r\n"
            		+ "loiTheoPhanTram = ?, giaBan= ?,hinhAnh = ? \r\n"
            		+ "where maSP = ?";

            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, sanPham.getTenSP());
            stmt.setDouble(2, sanPham.getGiaBan());
            stmt.setInt(3, sanPham.getSoLuong());
            stmt.setString(4, sanPham.getNhaCungCap().getMaNCC());
            stmt.setString(5, null);
            stmt.setInt(6, sanPham.getTrangThai());
            stmt.setString(7, sanPham.getChatLieu().getMaChatLieu());
            stmt.setString(8, sanPham.getKieuDang().getMaKieuDang());
            stmt.setString(9, sanPham.getMauSac().getMaMauSac());
            stmt.setString(10, sanPham.getXuatXu().getMaXuatXu());
            stmt.setString(11, sanPham.getPl().getMaPhanLoai());
            stmt.setInt(12, sanPham.getLoi());
            stmt.setDouble(13, sanPham.getGiaBan());
            stmt.setString(14, sanPham.getHinhAnh());
            stmt.setString(15, sanPham.getMaSP());

            return stmt.executeUpdate();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return -1;
    }
}
