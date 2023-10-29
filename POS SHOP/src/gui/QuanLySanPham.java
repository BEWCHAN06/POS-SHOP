package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class QuanLySanPham extends JPanel {
	private JTextField txtTenSP;
	private JTextField txtSoLuongSP;
	private JTextField txtGiaNhap;
	private JTable tblXemTruoc;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tbllistSanPham;

	/**
	 * Create the panel.
	 */
	public QuanLySanPham() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(934, 687));
		setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(mainPanel, "name_13998316339700");
		
		JPanel pnlXemTruoc = new JPanel();
		pnlXemTruoc.setBackground(new Color(255, 255, 255));
		pnlXemTruoc.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel pnlThongTinSanPham = new JPanel();
		pnlThongTinSanPham.setBackground(new Color(255, 255, 255));
		pnlThongTinSanPham.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Xem tr\u01B0\u1EDBc", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setBackground(new Color(255, 255, 255));
		pnlSanPham.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JButton btnThem = new JButton("thêm");
		btnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnThem.setBackground(new Color(65, 105, 225));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/add.png")));
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSua.setBackground(new Color(255, 255, 0));
		btnSua.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/sua.png")));
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLuu.setBackground(new Color(255, 165, 0));
		btnLuu.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/luulienket.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setBackground(new Color(144, 238, 144));
		btnLamMoi.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/refesh.png")));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnHy.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/x.png")));
		btnHy.setForeground(new Color(255, 255, 255));
		btnHy.setBackground(new Color(255, 0, 0));
		btnHy.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
							.addGap(111)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlXemTruoc, GroupLayout.PREFERRED_SIZE, 477, Short.MAX_VALUE))
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(47)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlThongTinSanPham, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addComponent(pnlSanPham, GroupLayout.PREFERRED_SIZE, 924, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlXemTruoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlThongTinSanPham, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(6))
		);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_3 = new JLabel("tìm kiếm sản phẩm : ");
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_1.setColumns(10);
		GroupLayout gl_pnlSanPham = new GroupLayout(pnlSanPham);
		gl_pnlSanPham.setHorizontalGroup(
			gl_pnlSanPham.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
				.addGroup(gl_pnlSanPham.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(538, Short.MAX_VALUE))
		);
		gl_pnlSanPham.setVerticalGroup(
			gl_pnlSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlSanPham.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_pnlSanPham.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
		);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(scrollPane_1, "name_25621687000400");
		
		tbllistSanPham = new JTable();
		tbllistSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"m\u00E3 s\u1EA3n ph\u1EA9m", "t\u00EAn s\u1EA3n ph\u1EA9m", "lo\u1EA1i", "gi\u00E1 g\u1ED1c", "l\u1EDDi", "khuy\u1EBFn m\u00E3i", "gi\u00E1 b\u00E1n", "k\u00EDch th\u01B0\u1EDBc", "s\u1ED1 l\u01B0\u1EE3ng", "m\u00E0u s\u1EAFc", "ch\u1EA5t li\u1EC7u", "t\u1ED3n kho", "nh\u00E0 cung c\u1EA5p"
			}
		));
		scrollPane_1.setViewportView(tbllistSanPham);
		pnlSanPham.setLayout(gl_pnlSanPham);
		
		JPanel pnlBangXemTruoc = new JPanel();
		pnlBangXemTruoc.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNewLabel_2 = new JLabel("Thay đổi số lượng : ");
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_1.setBackground(new Color(144, 238, 144));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_2.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/xoaall.png")));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton_3 = new JButton("Thêm Tất Cả Sản Phẩm");
		btnNewButton_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton_3.setBackground(new Color(65, 105, 225));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(QuanLySanPham.class.getResource("/icon/save.png")));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout gl_pnlThongTinSanPham = new GroupLayout(pnlThongTinSanPham);
		gl_pnlThongTinSanPham.setHorizontalGroup(
			gl_pnlThongTinSanPham.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlThongTinSanPham.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(96))
				.addGroup(Alignment.LEADING, gl_pnlThongTinSanPham.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_pnlThongTinSanPham.createSequentialGroup()
					.addComponent(pnlBangXemTruoc, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnlThongTinSanPham.setVerticalGroup(
			gl_pnlThongTinSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlThongTinSanPham.createSequentialGroup()
					.addComponent(pnlBangXemTruoc, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlThongTinSanPham.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
		);
		pnlBangXemTruoc.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlBangXemTruoc.add(scrollPane, "name_17081090334300");
		
		tblXemTruoc = new JTable();
		tblXemTruoc.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "K\u00EDch Th\u01B0\u1EDBc", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		tblXemTruoc.getColumnModel().getColumn(1).setPreferredWidth(165);
		scrollPane.setViewportView(tblXemTruoc);
		pnlThongTinSanPham.setLayout(gl_pnlThongTinSanPham);
		
		JLabel lblNewLabel = new JLabel("Tên sản phẩm : ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 11));
		
		txtTenSP = new JTextField();
		txtTenSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTenSP.setColumns(10);
		
		JLabel lblHnhA = new JLabel("Hình ảnh:");
		
		JPanel pnlHinhAnh = new JPanel();
		pnlHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNewLabel_1 = new JLabel("Số Lượng : ");
		
		txtSoLuongSP = new JTextField();
		txtSoLuongSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSoLuongSP.setBackground(new Color(255, 255, 255));
		txtSoLuongSP.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Màu sắc :");
		
		JComboBox cboMauSac = new JComboBox();
		cboMauSac.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboMauSac.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Loại sản phẩm :");
		
		JComboBox cboLoaiSanPham = new JComboBox();
		cboLoaiSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboLoaiSanPham.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Chất liệu : ");
		
		JComboBox cboChatLieu = new JComboBox();
		cboChatLieu.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboChatLieu.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Kiểu dáng :");
		
		JComboBox cboKieuDang = new JComboBox();
		cboKieuDang.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboKieuDang.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Xuất Xứ : ");
		
		JComboBox cboChatLieu_1 = new JComboBox();
		cboChatLieu_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboChatLieu_1.setBackground(new Color(255, 255, 255));
		
		JButton btnHinhAnh = new JButton("Chọn");
		btnHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnHinhAnh.setBackground(new Color(144, 238, 144));
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nhà Cung Cấp :");
		
		JComboBox cboKieuDang_1 = new JComboBox();
		cboKieuDang_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboKieuDang_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblGiNhp = new JLabel("Giá Nhập : ");
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtGiaNhap.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Lời Theo :");
		
		JComboBox cboGiaLoi = new JComboBox();
		cboGiaLoi.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboGiaLoi.setBackground(new Color(255, 255, 255));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Xuất kích thước tự động");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Kích thước :");
		
		JComboBox cboKichThuocBatDau = new JComboBox();
		cboKichThuocBatDau.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboKichThuocBatDau.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1_1_2_3_1 = new JLabel("Đến :");
		
		JComboBox cboKichThuocBatDau_1 = new JComboBox();
		cboKichThuocBatDau_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		cboKichThuocBatDau_1.setBackground(new Color(255, 255, 255));
		
		JButton btnXemTruoc = new JButton("Xem Trước");
		btnXemTruoc.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnXemTruoc.setForeground(new Color(0, 0, 0));
		btnXemTruoc.setBackground(new Color(192, 192, 192));
		btnXemTruoc.setFont(new Font("Arial", Font.BOLD, 13));
		GroupLayout gl_pnlXemTruoc = new GroupLayout(pnlXemTruoc);
		gl_pnlXemTruoc.setHorizontalGroup(
			gl_pnlXemTruoc.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlXemTruoc.createSequentialGroup()
					.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlXemTruoc.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1_1_2_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboKichThuocBatDau, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_1_1_1_2_3_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboKichThuocBatDau_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(158))
						.addGroup(gl_pnlXemTruoc.createSequentialGroup()
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlXemTruoc.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_pnlXemTruoc.createSequentialGroup()
													.addComponent(lblNewLabel_1_1_1_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnlXemTruoc.createSequentialGroup()
													.addComponent(cboKieuDang, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(cboChatLieu_1, 0, 111, Short.MAX_VALUE)))
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_pnlXemTruoc.createSequentialGroup()
											.addContainerGap()
											.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlXemTruoc.createSequentialGroup()
											.addGap(11)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addGap(59)
											.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlXemTruoc.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
												.addComponent(cboLoaiSanPham, 0, 120, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1_1_1)
												.addComponent(txtSoLuongSP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
												.addComponent(cboMauSac, 0, 114, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
												.addComponent(cboChatLieu, 0, 114, Short.MAX_VALUE))))
									.addGap(18))
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel)
									.addGap(171))
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addContainerGap()
									.addComponent(cboKieuDang_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addContainerGap()
									.addComponent(chckbxNewCheckBox)))
							.addGap(18)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addComponent(lblHnhA, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnHinhAnh, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblGiNhp, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_2_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaNhap, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(pnlHinhAnh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_pnlXemTruoc.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnXemTruoc, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addComponent(cboGiaLoi, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addGap(19)))
					.addGap(1))
		);
		gl_pnlXemTruoc.setVerticalGroup(
			gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlXemTruoc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlXemTruoc.createSequentialGroup()
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHnhA)
								.addComponent(btnHinhAnh))
							.addGap(3)
							.addComponent(pnlHinhAnh, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGiNhp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlXemTruoc.createSequentialGroup()
									.addGap(20)
									.addComponent(cboGiaLoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_1_1_2_2))
							.addGap(27)
							.addComponent(btnXemTruoc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlXemTruoc.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(3)
							.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_1))
							.addGap(3)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSoLuongSP, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboMauSac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1)
								.addComponent(lblNewLabel_1_1_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(cboLoaiSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboChatLieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_2)
								.addComponent(lblNewLabel_1_1_1_1_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(cboKieuDang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboChatLieu_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1_1_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboKieuDang_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlXemTruoc.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_2_3)
								.addComponent(cboKichThuocBatDau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1_2_3_1)
								.addComponent(cboKichThuocBatDau_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		pnlXemTruoc.setLayout(gl_pnlXemTruoc);
		mainPanel.setLayout(gl_mainPanel);
	}
}
