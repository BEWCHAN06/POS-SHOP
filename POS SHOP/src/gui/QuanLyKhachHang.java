package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import dao.NhaCungCapDAO;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;

import javax.swing.JTabbedPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class QuanLyKhachHang extends JPanel implements ActionListener, MouseListener {
	private JTextField txtmaKH;
	private JTextField txttenKh;
	private JTextField txtsdt;
	private JTextField txtemail;
	private JTextField txtTimkiem;
	private JTable tblKH;
	private JRadioButton rdbgtinh;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnHuy;
	private int trangthainut;
	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang() {
		uiKhachHang();
		upLoadDataKH();
		
	}
	private void uiKhachHang() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(932, 685));
		JPanel pnThietlapTT = new JPanel();
		pnThietlapTT.setLayout(null);
		pnThietlapTT.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Thi\u1EBFt L\u1EADp Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThietlapTT.setBackground(Color.WHITE);
		
		JLabel lbmakh = new JLabel("Mã Khách Hàng:");
		lbmakh.setFont(new Font("Arial", Font.BOLD, 12));
		lbmakh.setBounds(16, 30, 97, 14);
		pnThietlapTT.add(lbmakh);
		
		txtmaKH = new JTextField();
		txtmaKH.setBackground(new Color(255, 255, 255));
		txtmaKH.setEditable(false);
		txtmaKH.setColumns(10);
		txtmaKH.setBounds(133, 27, 255, 20);
		pnThietlapTT.add(txtmaKH);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng:");
		lblTnKhchHng.setFont(new Font("Arial", Font.BOLD, 12));
		lblTnKhchHng.setBounds(16, 64, 107, 14);
		pnThietlapTT.add(lblTnKhchHng);
		
		txttenKh = new JTextField();
		txttenKh.setBackground(new Color(255, 255, 255));
		txttenKh.setEditable(false);
		txttenKh.setColumns(10);
		txttenKh.setBounds(133, 61, 320, 20);
		pnThietlapTT.add(txttenKh);
		
		JLabel lblgt = new JLabel("Giới Tính:");
		lblgt.setFont(new Font("Arial", Font.BOLD, 12));
		lblgt.setBounds(16, 92, 89, 14);
		pnThietlapTT.add(lblgt);
		
		JLabel lblsdt = new JLabel("Số Điện Thoại:");
		lblsdt.setFont(new Font("Arial", Font.BOLD, 12));
		lblsdt.setBounds(16, 123, 89, 14);
		pnThietlapTT.add(lblsdt);
		
		txtsdt = new JTextField();
		txtsdt.setBackground(new Color(255, 255, 255));
		txtsdt.setFont(new Font("Arial", Font.PLAIN, 12));
		txtsdt.setEditable(false);
		txtsdt.setColumns(10);
		txtsdt.setBounds(133, 120, 200, 20);
		pnThietlapTT.add(txtsdt);
		
		JLabel lbmail = new JLabel("Email:");
		lbmail.setFont(new Font("Arial", Font.BOLD, 12));
		lbmail.setBounds(390, 92, 89, 14);
		pnThietlapTT.add(lbmail);
		
		txtemail = new JTextField();
		txtemail.setBackground(new Color(255, 255, 255));
		txtemail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtemail.setEditable(false);
		txtemail.setColumns(10);
		txtemail.setBounds(390, 120, 310, 20);
		pnThietlapTT.add(txtemail);
		
		rdbgtinh = new JRadioButton("Nam");
		rdbgtinh.setBackground(new Color(255, 255, 255));
		rdbgtinh.setSelected(true);
		rdbgtinh.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbgtinh.setBounds(133, 88, 99, 23);
		pnThietlapTT.add(rdbgtinh);
		
		JPanel pnttinKH = new JPanel();
		pnttinKH.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnttinKH.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnttinKH, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnThietlapTT, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnThietlapTT, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnttinKH, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel pnloc = new JPanel();
		pnloc.setBackground(new Color(255, 255, 255));
		pnloc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnttinKH = new GroupLayout(pnttinKH);
		gl_pnttinKH.setHorizontalGroup(
			gl_pnttinKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnttinKH.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnloc, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnttinKH.setVerticalGroup(
			gl_pnttinKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnttinKH.createSequentialGroup()
					.addGroup(gl_pnttinKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnttinKH.createSequentialGroup()
							.addGap(21)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnttinKH.createSequentialGroup()
							.addGap(80)
							.addComponent(pnloc, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblgt_1 = new JLabel("Giới Tính:");
		lblgt_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JComboBox cbxGT = new JComboBox();
		cbxGT.setBackground(new Color(255, 255, 255));
		cbxGT.setModel(new DefaultComboBoxModel(new String[] {"Nam ", "Nữ"}));
		cbxGT.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblgt_1_1 = new JLabel("Trạng Thái:");
		lblgt_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JComboBox cbxTT = new JComboBox();
		cbxTT.setBackground(new Color(255, 255, 255));
		cbxTT.setModel(new DefaultComboBoxModel(new String[] {"Còn hoạt động", "Ngưng hoạt động"}));
		cbxTT.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_pnloc = new GroupLayout(pnloc);
		gl_pnloc.setHorizontalGroup(
			gl_pnloc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnloc.createSequentialGroup()
					.addGroup(gl_pnloc.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnloc.createSequentialGroup()
							.addComponent(lblgt_1)
							.addGap(18)
							.addComponent(cbxGT, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_pnloc.createSequentialGroup()
							.addComponent(lblgt_1_1, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxTT, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnloc.setVerticalGroup(
			gl_pnloc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnloc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnloc.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblgt_1)
						.addComponent(cbxGT, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnloc.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblgt_1_1)
						.addComponent(cbxTT, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		pnloc.setLayout(gl_pnloc);
		
		JPanel pntTinCN = new JPanel();
		pntTinCN.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Thông Tin Cá Nhân", null, pntTinCN, null);
		
		JLabel lblTim = new JLabel("Tìm Kiếm:");
		lblTim.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTimkiem = new JTextField();
		txtTimkiem.setBackground(new Color(255, 255, 255));
		txtTimkiem.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimkiem.setEditable(false);
		txtTimkiem.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pntTinCN = new GroupLayout(pntTinCN);
		gl_pntTinCN.setHorizontalGroup(
			gl_pntTinCN.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pntTinCN.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pntTinCN.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pntTinCN.createSequentialGroup()
							.addComponent(lblTim, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimkiem, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pntTinCN.setVerticalGroup(
			gl_pntTinCN.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pntTinCN.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pntTinCN.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTim)
						.addComponent(txtTimkiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		tblKH = new JTable();
		tblKH.setFont(new Font("Arial", Font.PLAIN, 12));
		tblKH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 KH", "T\u00EAn Kh\u00E1ch H\u00E0ng", "S\u0110T", "Email ", "Gi\u1EDBi T\u00EDnh"
			}
		));
		tblKH.getColumnModel().getColumn(1).setPreferredWidth(118);
		scrollPane.setViewportView(tblKH);
		pntTinCN.setLayout(gl_pntTinCN);
		
		JPanel pnlsuGD = new JPanel();
		pnlsuGD.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Lịch Sử Giao Dịch", null, pnlsuGD, null);
		pnttinKH.setLayout(gl_pnttinKH);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/icon/add.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));
		btnThem.setBounds(540, 30, 98, 37);
		pnThietlapTT.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/icon/sua.png")));
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBackground(new Color(255, 255, 0));
		btnSua.setBounds(660, 30, 97, 37);
		pnThietlapTT.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/icon/save.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuu.setBackground(new Color(0, 0, 255));
		btnLuu.setBounds(780, 30, 97, 37);
		pnThietlapTT.add(btnLuu);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/icon/x.png")));
		btnHuy.setFont(new Font("Arial", Font.BOLD, 12));
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setBounds(780, 88, 97, 37);
		pnThietlapTT.add(btnHuy);
		setLayout(groupLayout);
		tblKH.addMouseListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnHuy.addActionListener(this);
		btnLuu.addActionListener(this);
	}
	private void clearTableDSSP() {
        DefaultTableModel dtm = (DefaultTableModel) tblKH.getModel();
        dtm.setRowCount(0);
    }
	private void upLoadDataKH() {
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		clearTableDSSP();
		DefaultTableModel dtm = (DefaultTableModel) tblKH.getModel();
		List<KhachHang> listkh = khachHangDAO.doTuBang();
		for(KhachHang kh : listkh) {
			String mail = "";
			if(kh.getEmail() == null) {
				mail = "";
			}else {
				mail = kh.getEmail();
			}
			Object[] rowdata = {kh.getMaKH(),kh.getTenKH(),kh.getSDT(), mail,kh.isGioiTinh() == true ? "Nam":"Nữ"};
			dtm.addRow(rowdata);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblKH.getSelectedRow();
		txtmaKH.setText(tblKH.getValueAt(row, 0).toString());
		txttenKh.setText(tblKH.getValueAt(row, 1).toString());
		txtsdt.setText(tblKH.getValueAt(row, 2).toString());
		if(tblKH.getValueAt(row, 3).toString().equals("")) {
			txtemail.setText("");
		}else {
			txtemail.setText(tblKH.getValueAt(row, 3).toString());
		}
		
		rdbgtinh.setSelected(tblKH.getValueAt(row, 4).toString().equals("Nam") ? true : false);
//		.setText(tblKhachHang.getValueAt(row, 3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(btnThem)) {
			
			trangthainut = 1;
			txtmaKH.setText("");
			txttenKh.setText("");
			txtsdt.setText("");
			txtemail.setText("");
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnLuu.setEnabled(true);
			btnHuy.setEnabled(true);
			KhachHang kh = new KhachHang();
			txtmaKH.setText(kh.getAutoID());
//			txtmaKH.setEditable(true);
			txttenKh.setEditable(true);
			txtsdt.setEditable(true);
			txtemail.setEditable(true);
		}
		if(o.equals(btnSua)) {
			trangthainut =2;
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnLuu.setEnabled(true);
			btnHuy.setEnabled(true);
			txttenKh.setEditable(true);
			txtsdt.setEditable(true);
			txtemail.setEditable(true);
		}
		if(o.equals(btnLuu)) {
			if(trangthainut == 1) {
				String makh = txtmaKH.getText();
				String tenkh = txttenKh.getText();
				String sdt = txtsdt.getText();
				String email = txtemail.getText();
				boolean gt = rdbgtinh.isSelected();
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				KhachHang kh = new KhachHang(makh, tenkh, email, sdt, gt);
				khachHangDAO.addKhachHang(kh);
				upLoadDataKH();
			}
			if(trangthainut == 2) {
				String makh = txtmaKH.getText();
				String tenkh = txttenKh.getText();
				String sdt = txtsdt.getText();
				String email = txtemail.getText();
				boolean gt = rdbgtinh.isSelected();
				KhachHangDAO khachHangDAO = new KhachHangDAO();
				KhachHang kh = new KhachHang(makh, tenkh, email, sdt, gt);
				khachHangDAO.updateKhachHang(kh);
				upLoadDataKH();
			}
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnLuu.setEnabled(false);
			btnHuy.setEnabled(false);
		}
		if(o.equals(btnHuy)) {
			txtmaKH.setText("");
			txttenKh.setText("");
			txtsdt.setText("");
			txtemail.setText("");
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnLuu.setEnabled(false);
			btnHuy.setEnabled(false);
		}
	}

	
}
