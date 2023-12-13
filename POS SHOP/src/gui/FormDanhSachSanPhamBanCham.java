package gui;

import entity.SanPham;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FormDanhSachSanPhamBanCham extends javax.swing.JFrame {
    private ArrayList<SanPham>listSanPham = new ArrayList<>();
 
    public FormDanhSachSanPhamBanCham(ArrayList<SanPham>listSanPham) {
        this.listSanPham = listSanPham;
        initComponents();
        designTable();
        tblDanhSachBanChay();
    }

     private void designTable() {
        tbl_danhSachSanPham.getTableHeader().setFont(new java.awt.Font("Calibri", 0, 12));
        tbl_danhSachSanPham.getTableHeader().setOpaque(false);
        tbl_danhSachSanPham.getTableHeader().setBackground(new Color(144,238,144));
        tbl_danhSachSanPham.getTableHeader().setForeground(Color.WHITE);
        tbl_danhSachSanPham.setDefaultEditor(Object.class, null); // Không cho phép edit
        tbl_danhSachSanPham.setRowHeight(30);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        lbl_1 = new javax.swing.JLabel();
        scr_1 = new javax.swing.JScrollPane();
        tbl_danhSachSanPham = new javax.swing.JTable();
        lbl_2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        lbl_1.setFont(new java.awt.Font("Calibri", 1, 30)); // NOI18N
        lbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_1.setText("TOP 10 SẢN PHẨM BÁN CHẬM");
        lbl_1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        tbl_danhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Top", "Mã sản phẩm", "Tên sản phẩm", "Số lượng đã bán", "Phân loại", "Màu sắc", "Kích cỡ", "Giá bán"
            }
        ));
        scr_1.setViewportView(tbl_danhSachSanPham);

        lbl_2.setText("    X");
        lbl_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(lbl_1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(lbl_2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr_1)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_lbl_2MouseClicked

  private void tblDanhSachBanChay(){
        DefaultTableModel dtm = (DefaultTableModel) tbl_danhSachSanPham.getModel();
        dtm.setRowCount(0);
        for(int i = 0; i < listSanPham.size(); i++){
            SanPham sp = listSanPham.get(i);
            Object[] rowData = {i+1, sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), sp.getPl().getPhanLoai(), sp.getMauSac().getMauSac(),
            sp.getKichThuoc().getKichThuoc(), NumberFormat.getInstance().format(sp.getGiaBan())};
            dtm.addRow(rowData);
        }
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JScrollPane scr_1;
    private javax.swing.JTable tbl_danhSachSanPham;
    // End of variables declaration//GEN-END:variables
}
