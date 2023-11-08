package dao;

import java.util.List;

import ConnectDB.KetNoiSQL;
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
        System.out.println(sanPhamDAO.getSanPhanTheoId("SP01"));
    }
}
