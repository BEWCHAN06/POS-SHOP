package dao;

import java.util.List;

import ConnectDB.KetNoiSQL;
import entity.HoaDon;
import entity.NhanVien;
import entity.SanPham;

public class test {
    public static void main(String[] args) {
    	KetNoiSQL.getInstance().connect();
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
//        List<SanPham> danhSachSanPham = sanPhamDAO.doTuBang();
//
//        if (danhSachSanPham != null) {
//            System.out.println("Danh sách sản phẩm:");
//            for (SanPham sanPham : danhSachSanPham) {
//                System.out.println(sanPham); // Đảm bảo rằng bạn đã override phương thức toString() trong lớp SanPham
//            }
//        } else {
//            System.out.println("Không có sản phẩm nào trong danh sách.");
//        }
        HoaDonDAO hddao = new HoaDonDAO();
        List<HoaDon> dshd = hddao.getHDCho();
        for(HoaDon hd : dshd) {
        	System.out.println(hd.toString());
        }
//        System.out.println(sanPhamDAO.doTuBang().size());
        NhanVienDAO nvdao = new NhanVienDAO();
        NhanVien nv = nvdao.getNhanVienByID("NV01");
        System.out.println(nv.toString());
    }
}
