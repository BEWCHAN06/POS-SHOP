package gui;

//import dao.ChiTietHoaDonDAO;
//import dao.HoaDonDAO;
import dao.KichThuocDAO;
import dao.MauSacDAO;
import dao.PhanLoaiDAO;
import dao.SanPhamDAO;
import entity.KichThuoc;
import entity.MauSac;
import entity.PhanLoai;
import entity.SanPham;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class TabThongKeSanPham extends javax.swing.JPanel {
    private SanPhamDAO sanPham_DAO = new SanPhamDAO();
//    private ChiTietHoaDonDAO cthd_DAO = new ChiTietHoaDonDAO();
//    private HoaDonDAO hoaDon_DAO = new HoaDonDAO();
    private KichThuocDAO kichThuoc_DAO = new KichThuocDAO();
    private MauSacDAO mauSac_DAO = new MauSacDAO();
    private PhanLoaiDAO phanLoai_DAO = new PhanLoaiDAO();
   
    public TabThongKeSanPham() {
        initComponents();
        designTable();
        tblDanhSachSanPham();
        khoiTaoGiaTri();
    }
    
    private void khoiTaoGiaTri(){
        
        ArrayList<KichThuoc>listKichThuoc = kichThuoc_DAO.getAllKichThuoc();
        for(KichThuoc kt : listKichThuoc){
            cb_KichThuoc.addItem(kt.getKichThuoc());
        }
        
        ArrayList<MauSac>listMauSac = mauSac_DAO.getAllMauSac();
        for(MauSac ms : listMauSac){
            cb_MauSac.addItem(ms.getMauSac());
        }
        
        ArrayList<PhanLoai>listPhanLoai = phanLoai_DAO.getAllPhanLoai();
        for(PhanLoai pl : listPhanLoai){
            cb_PhanLoai.addItem(pl.getPhanLoai());
        }
        

    }
    
    private void designTable() {
        tbl_DanhSachSanPham.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_DanhSachSanPham.getTableHeader().setOpaque(false);
        tbl_DanhSachSanPham.getTableHeader().setBackground(new Color(102,204,153));
        tbl_DanhSachSanPham.getTableHeader().setForeground(Color.WHITE);
        tbl_DanhSachSanPham.setDefaultEditor(Object.class, null);
        tbl_DanhSachSanPham.setRowHeight(30);
   
    }
    
    private void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachSanPham.getModel();
        dtm.setRowCount(0);
    }
    
    private void tblDanhSachSanPham(){
        clearTable();
        
        String mauSac = cb_MauSac.getSelectedItem().toString();
        if(cb_MauSac.getSelectedItem().toString().equals("Tất cả")) mauSac = "";
        
        String phanLoai = cb_PhanLoai.getSelectedItem().toString();
        if(cb_PhanLoai.getSelectedItem().toString().equals("Tất cả")) phanLoai = "";
        
        String kichThuoc = cb_KichThuoc.getSelectedItem().toString();
        if(cb_KichThuoc.getSelectedItem().toString().equals("Tất cả")) kichThuoc = "";
        
//        ArrayList<SanPham> listSanPham = cthd_DAO.thongKeDanhSachSanPhamVoiSoLuongBanDuoc(mauSac, phanLoai, kichThuoc);
//        ArrayList<SanPham> listSanPham = sanPham_DAO.getAllSanPham("", "", phanLoai, mauSac, kichThuoc);
//        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachSanPham.getModel();
//
//        for(SanPham sp : listSanPham){
//
//            Object[] rowData = {sp.getMaSP(), sp.getTenSP(), sp.getPl().getPhanLoai(), sp.getKichThuoc().getKichThuoc(),
//                                sp.getMauSac().getMauSac(), sp.getSoLuong(), NumberFormat.getInstance().format( sp.getGiaNhap()) };
//            dtm.addRow(rowData);
//        }
        
   
    }
    
    private void tblDanhSachSanPhamVuotDinhMuc(int soLuongDinhMuc){
        clearTable();
        
        String mauSac = cb_MauSac.getSelectedItem().toString();
        if(cb_MauSac.getSelectedItem().toString().equals("Tất cả")) mauSac = "";
        
        String phanLoai = cb_PhanLoai.getSelectedItem().toString();
        if(cb_PhanLoai.getSelectedItem().toString().equals("Tất cả")) phanLoai = "";
        
        String kichThuoc = cb_KichThuoc.getSelectedItem().toString();
        if(cb_KichThuoc.getSelectedItem().toString().equals("Tất cả")) kichThuoc = "";

//        ArrayList<SanPham> listSanPham = cthd_DAO.thongKeDanhSachSanPhamVoiSoLuongBanDuoc(mauSac, phanLoai, kichThuoc, thang, nam);
//        ArrayList<SanPham> listSanPham = sanPham_DAO.getAllSanPhamVuotDinhMuc("", "", phanLoai, mauSac, kichThuoc, soLuongDinhMuc);
//        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachSanPham.getModel();
//        
//        for(SanPham sp : listSanPham){
//     
//            Object[] rowData = {sp.getMaSP(), sp.getTenSP(), sp.getPl().getPhanLoai(), sp.getKichThuoc().getKichThuoc(),
//                                sp.getMauSac().getMauSac(), sp.getSoLuong(), NumberFormat.getInstance().format(sp.getGiaNhap()) };
//            dtm.addRow(rowData);
//        }
//        
    }
    
    private void tblDanhSachSanPhamDuoiDinhMuc(int soLuongDinhMuc){
        clearTable();
        
        String mauSac = cb_MauSac.getSelectedItem().toString();
        if(cb_MauSac.getSelectedItem().toString().equals("Tất cả")) mauSac = "";
        
        String phanLoai = cb_PhanLoai.getSelectedItem().toString();
        if(cb_PhanLoai.getSelectedItem().toString().equals("Tất cả")) phanLoai = "";
        
        String kichThuoc = cb_KichThuoc.getSelectedItem().toString();
        if(cb_KichThuoc.getSelectedItem().toString().equals("Tất cả")) kichThuoc = "";

//        ArrayList<SanPham> listSanPham = cthd_DAO.thongKeDanhSachSanPhamVoiSoLuongBanDuoc(mauSac, phanLoai, kichThuoc, thang, nam);
//        ArrayList<SanPham> listSanPham = sanPham_DAO.getAllSanPhamDuoiDinhMuc("", "", phanLoai, mauSac, kichThuoc, soLuongDinhMuc);
//        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachSanPham.getModel();
//
//        for(SanPham sp : listSanPham){
//           
//            Object[] rowData = {sp.getMaSP(), sp.getTenSP(), sp.getPl().getPhanLoai(), sp.getKichThuoc().getKichThuoc(),
//                                sp.getMauSac().getMauSac(), sp.getSoLuong(), NumberFormat.getInstance().format(sp.getGiaNhap()) };
//            dtm.addRow(rowData);
//        }
        
    }
    
    private void tblDanhSachSanPhamTon(){
        clearTable();
        
        String mauSac = cb_MauSac.getSelectedItem().toString();
        if(cb_MauSac.getSelectedItem().toString().equals("Tất cả")) mauSac = "";
        
        String phanLoai = cb_PhanLoai.getSelectedItem().toString();
        if(cb_PhanLoai.getSelectedItem().toString().equals("Tất cả")) phanLoai = "";
        
        String kichThuoc = cb_KichThuoc.getSelectedItem().toString();
        if(cb_KichThuoc.getSelectedItem().toString().equals("Tất cả")) kichThuoc = "";

//        ArrayList<SanPham> listSanPham = cthd_DAO.thongKeDanhSachSanPhamVoiSoLuongBanDuoc(mauSac, phanLoai, kichThuoc, thang, nam);
//        ArrayList<SanPham> listSanPham = sanPham_DAO.getAllSanPhamTon("", "", phanLoai, mauSac, kichThuoc);
//        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachSanPham.getModel();
//
//        for(SanPham sp : listSanPham){
//           
//            Object[] rowData = {sp.getMaSP(), sp.getTenSP(), sp.getPl().getPhanLoai(), sp.getKichThuoc().getKichThuoc(),
//                                sp.getMauSac().getMauSac(), sp.getSoLuong(), NumberFormat.getInstance().format(sp.getGiaNhap()) };
//            dtm.addRow(rowData);
//        }
        
    }
    

    private int duLieuDinhMuc(){
        int soLuong = 0;
        try {
            soLuong = Integer.parseInt(txt_DinhMuc.getText());
            if(soLuong < 0){
                JOptionPane.showMessageDialog(null, "Định mức phải là số lớn hơn 0");
                return -1;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Định mức phải là 1 con số");
            return -1;
        }
        return soLuong;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
		setPreferredSize(new Dimension(932, 667));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
        lbl_1 = new javax.swing.JLabel();
        btng = new javax.swing.ButtonGroup();
        scr_1 = new javax.swing.JScrollPane();
        tbl_DanhSachSanPham = new javax.swing.JTable();
        lbl_MauSac = new javax.swing.JLabel();
        cb_MauSac = new javax.swing.JComboBox<>();
        lbl_PhanLoai = new javax.swing.JLabel();
        cb_PhanLoai = new javax.swing.JComboBox<>();
        lbl_KichThuoc = new javax.swing.JLabel();
        cb_KichThuoc = new javax.swing.JComboBox<>();
        pnl_4 = new javax.swing.JPanel();
        lbl_2 = new javax.swing.JLabel();
        lbl_3 = new javax.swing.JLabel();
        txt_DinhMuc = new javax.swing.JTextField();
        rbtn_duoiDinhMuc = new javax.swing.JRadioButton();
        rbtn_vuocDinhMuc = new javax.swing.JRadioButton();
        rbtn_tatCa = new javax.swing.JRadioButton();
        btn_topspbancham = new javax.swing.JButton();
        btn_topspbanchay = new javax.swing.JButton();

        lbl_1.setText("lbl_1");

        setBackground(new java.awt.Color(255, 255, 255));
        

        tbl_DanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Phân loại", "Kích cỡ", "Màu sắc", "Số lượng tồn kho", "Giá bán"
            }
        ));
        tbl_DanhSachSanPham.setRowHeight(30);
        scr_1.setViewportView(tbl_DanhSachSanPham);

        lbl_MauSac.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_MauSac.setText("Màu sắc:");

        cb_MauSac.setFont(new Font("Arial", Font.PLAIN, 12)); // NOI18N
        cb_MauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cb_MauSac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_MauSacItemStateChanged(evt);
            }
        });

        lbl_PhanLoai.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_PhanLoai.setText("Phân loại:");

        cb_PhanLoai.setFont(new Font("Arial", Font.PLAIN, 12)); // NOI18N
        cb_PhanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cb_PhanLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_PhanLoaiItemStateChanged(evt);
            }
        });

        lbl_KichThuoc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_KichThuoc.setText("Kích thước:");

        cb_KichThuoc.setFont(new Font("Arial", Font.PLAIN, 12)); // NOI18N
        cb_KichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cb_KichThuoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_KichThuocItemStateChanged(evt);
            }
        });
        cb_KichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_KichThuocActionPerformed(evt);
            }
        });

        pnl_4.setBackground(new java.awt.Color(102,204,153));

        lbl_2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_2.setText("Định mức tồn:");

        lbl_3.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lbl_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_3.setText("Tồn kho");

        txt_DinhMuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_DinhMuc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_DinhMucInputMethodTextChanged(evt);
            }
        });
        txt_DinhMuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_DinhMucKeyReleased(evt);
            }
        });

        rbtn_duoiDinhMuc.setBackground(new java.awt.Color(102,204,153));
        btng.add(rbtn_duoiDinhMuc);
        rbtn_duoiDinhMuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtn_duoiDinhMuc.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_duoiDinhMuc.setText("Dưới định mức tồn");
        rbtn_duoiDinhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtn_duoiDinhMucItemStateChanged(evt);
            }
        });

        rbtn_vuocDinhMuc.setBackground(new java.awt.Color(102,204,153));
        btng.add(rbtn_vuocDinhMuc);
        rbtn_vuocDinhMuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtn_vuocDinhMuc.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_vuocDinhMuc.setText("Vược định mức tồn");
        rbtn_vuocDinhMuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtn_vuocDinhMucItemStateChanged(evt);
            }
        });

        rbtn_tatCa.setBackground(new java.awt.Color(102,204,153));
        btng.add(rbtn_tatCa);
        rbtn_tatCa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtn_tatCa.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_tatCa.setSelected(true);
        rbtn_tatCa.setText("Tất cả");
        rbtn_tatCa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtn_tatCaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl_4Layout = new javax.swing.GroupLayout(pnl_4);
        pnl_4Layout.setHorizontalGroup(
        	pnl_4Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(pnl_4Layout.createSequentialGroup()
        			.addGap(25)
        			.addGroup(pnl_4Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, pnl_4Layout.createSequentialGroup()
        					.addComponent(lbl_2)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(txt_DinhMuc, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        					.addGap(35)
        					.addComponent(rbtn_tatCa, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        					.addGap(12))
        				.addComponent(rbtn_vuocDinhMuc)
        				.addComponent(rbtn_duoiDinhMuc))
        			.addGap(60))
        		.addGroup(Alignment.LEADING, pnl_4Layout.createSequentialGroup()
        			.addGap(160)
        			.addComponent(lbl_3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(170, Short.MAX_VALUE))
        );
        pnl_4Layout.setVerticalGroup(
        	pnl_4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(pnl_4Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbl_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(pnl_4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txt_DinhMuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(rbtn_tatCa)
        				.addComponent(lbl_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(rbtn_duoiDinhMuc)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(rbtn_vuocDinhMuc)
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        pnl_4.setLayout(pnl_4Layout);

        btn_topspbancham.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_topspbancham.setText("Top 10 sản phẩm bán chậm");
        btn_topspbancham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                btn_topspbanchamMouseClicked(evt);
            }
        });

        btn_topspbanchay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_topspbanchay.setText("Top 10 sản phẩm bán chạy");
        btn_topspbanchay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                btn_topspbanchayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(scr_1, GroupLayout.PREFERRED_SIZE, 911, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(pnl_4, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lbl_MauSac, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(cb_MauSac, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbl_PhanLoai, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lbl_KichThuoc, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(cb_KichThuoc, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(cb_PhanLoai, 0, 112, Short.MAX_VALUE))))
        					.addPreferredGap(ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(btn_topspbanchay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btn_topspbancham, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(17)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_MauSac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(cb_MauSac, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        							.addComponent(btn_topspbanchay, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(cb_PhanLoai, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_PhanLoai)
        						.addComponent(btn_topspbancham, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lbl_KichThuoc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cb_KichThuoc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(42))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(pnl_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scr_1, GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_KichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_KichThuocActionPerformed
        // TODO add your handling code here:
        tblDanhSachSanPham();
    }//GEN-LAST:event_cb_KichThuocActionPerformed

    private void cb_MauSacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_MauSacItemStateChanged
        // TODO add your handling code here:
       tblDanhSachSanPham();
    }//GEN-LAST:event_cb_MauSacItemStateChanged

    private void cb_PhanLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_PhanLoaiItemStateChanged
        // TODO add your handling code here:
       tblDanhSachSanPham();
    }//GEN-LAST:event_cb_PhanLoaiItemStateChanged

    private void cb_KichThuocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_KichThuocItemStateChanged
        // TODO add your handling code here:
        tblDanhSachSanPham();
    }//GEN-LAST:event_cb_KichThuocItemStateChanged

    private void txt_DinhMucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DinhMucKeyReleased
        // TODO add your handling code here:
        if(txt_DinhMuc.getText().equals("")) {
            txt_DinhMuc.setText("1");  
        }

        int soLuong = duLieuDinhMuc();
        
        if(soLuong == -1) return;
        
        if(rbtn_tatCa.isSelected()){
            tblDanhSachSanPham();
        }
        else if(rbtn_vuocDinhMuc.isSelected()){
            tblDanhSachSanPhamVuotDinhMuc(soLuong);
        }
        else if(rbtn_duoiDinhMuc.isSelected()){
            tblDanhSachSanPhamDuoiDinhMuc(soLuong);
        }
    }//GEN-LAST:event_txt_DinhMucKeyReleased

    private void txt_DinhMucInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_DinhMucInputMethodTextChanged
        // TODO add your handling code here:
         int soLuong = duLieuDinhMuc();
        if(soLuong == -1) return;
        
        if(rbtn_tatCa.isSelected()){
            tblDanhSachSanPham();
        }
        else if(rbtn_vuocDinhMuc.isSelected()){
            tblDanhSachSanPhamVuotDinhMuc(soLuong);
        }
        else if(rbtn_duoiDinhMuc.isSelected()){
            tblDanhSachSanPhamDuoiDinhMuc(soLuong);
        }
    }//GEN-LAST:event_txt_DinhMucInputMethodTextChanged

    private void rbtn_duoiDinhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_duoiDinhMucItemStateChanged
        // TODO add your handling code here:
         int soLuong = duLieuDinhMuc();
        if(soLuong == -1) return;
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
            tblDanhSachSanPhamDuoiDinhMuc(soLuong);
        }
    }//GEN-LAST:event_rbtn_duoiDinhMucItemStateChanged

//    private void rbtn_hetHangTrongKhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_hetHangTrongKhoItemStateChanged
//        // TODO add your handling code here:     
//        if(evt.getStateChange() == ItemEvent.SELECTED){
//            tblDanhSachSanPhamHetHang();
//        }
//    }//GEN-LAST:event_rbtn_hetHangTrongKhoItemStateChanged

    private void rbtn_vuocDinhMucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_vuocDinhMucItemStateChanged
        // TODO add your handling code here:
         int soLuong = duLieuDinhMuc();
        if(soLuong == -1) return;
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
            tblDanhSachSanPhamVuotDinhMuc(soLuong);
        }
    }//GEN-LAST:event_rbtn_vuocDinhMucItemStateChanged

    private void rbtn_tatCaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_tatCaItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            tblDanhSachSanPham();
        }
        txt_DinhMuc.setText("");
    }//GEN-LAST:event_rbtn_tatCaItemStateChanged

//    private void btn_topspbanchayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_topspbanchayMouseClicked
//        // TODO add your handling code here:
//        ArrayList<SanPham>listSanPham = sanPham_DAO.topNSanPham();
//        new FormDanhSachSanPhamBanChay(listSanPham).setVisible(true);
//    }//GEN-LAST:event_btn_topspbanchayMouseClicked
//
//    private void btn_topspbanchamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_topspbanchamMouseClicked
//       // TODO add your handling code here:
//         ArrayList<SanPham>listSanPham = sanPham_DAO.topNSanPhamBanCham();
//       new FormDanhSachSanPhamBanCham(listSanPham).setVisible(true);
//    }//GEN-LAST:event_btn_topspbanchamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btng;
    private javax.swing.JComboBox<String> cb_KichThuoc;
    private javax.swing.JComboBox<String> cb_MauSac;
    private javax.swing.JComboBox<String> cb_PhanLoai;
    private javax.swing.JButton btn_topspbancham;
    private javax.swing.JButton btn_topspbanchay;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JPanel pnl_4;
    private javax.swing.JScrollPane scr_1;
    private javax.swing.JLabel lbl_KichThuoc;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_PhanLoai;
    private javax.swing.JRadioButton rbtn_duoiDinhMuc;
    private javax.swing.JRadioButton rbtn_tatCa;
    private javax.swing.JRadioButton rbtn_vuocDinhMuc;
    private javax.swing.JTable tbl_DanhSachSanPham;
    private javax.swing.JTextField txt_DinhMuc;
}
