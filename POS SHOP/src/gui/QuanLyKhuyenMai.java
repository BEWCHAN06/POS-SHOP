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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DropMode;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class QuanLyKhuyenMai extends JPanel {
	private JTextField txtMaKhuyenMai, txtTenKhuyenMai, txtMucKhuyenMai, txtTimKiemSanPham;
	private JComboBox<String> comboBoxPhanLoai;
	private JDateChooser dateChooserThoiGianBatDauGiamGia, dateChooserThoiGianKetThucGiamGia;
	private JTable tblSanPham,tblKhuyenMai;

	/**
	 * Create the panel.
	 */
	public QuanLyKhuyenMai() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(934, 687));
		
		JPanel pnlKhuyenMai = new JPanel();
		pnlKhuyenMai.setBackground(new Color(255, 255, 255));
		pnlKhuyenMai.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Khuy\u1EBFn M\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh S\u00E1ch Khuy\u1EBFn M\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
						.addComponent(pnlKhuyenMai, GroupLayout.PREFERRED_SIZE, 934, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlKhuyenMai, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane_DanhSachKhuyenMai = new JScrollPane();
		scrollPane_DanhSachKhuyenMai.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_DanhSachKhuyenMai, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_DanhSachKhuyenMai, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
		);
		
		tblKhuyenMai = new JTable();
		tblKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 11));
		tblKhuyenMai.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 khuy\u1EBFn m\u00E3i", "T\u00EAn khuy\u1EBFn m\u00E3i", "Ph\u1EA7n tr\u0103n khuy\u1EBFn m\u00E3i", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc"
			}
		));
		tblKhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblKhuyenMai.getColumnModel().getColumn(2).setPreferredWidth(90);
		tblKhuyenMai.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane_DanhSachKhuyenMai.setViewportView(tblKhuyenMai);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u1EDDi Gian Khuy\u1EBFn M\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		GroupLayout gl_pnlKhuyenMai = new GroupLayout(pnlKhuyenMai);
		gl_pnlKhuyenMai.setHorizontalGroup(
			gl_pnlKhuyenMai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKhuyenMai.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlKhuyenMai.setVerticalGroup(
			gl_pnlKhuyenMai.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlKhuyenMai.createSequentialGroup()
					.addGroup(gl_pnlKhuyenMai.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblThoiGianBatDauKhuyenMai = new JLabel("Thời gian bắt đầu giảm giá :");
		lblThoiGianBatDauKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblThoiGianKetThucKhuyenMai = new JLabel("Thời gian kết thúc giảm giá :");
		lblThoiGianKetThucKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnLuuKhuyenMai = new JButton("Lưu");
		btnLuuKhuyenMai.setIcon(new ImageIcon(QuanLyKhuyenMai.class.getResource("/icon/luulienket.png")));
		btnLuuKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuuKhuyenMai.setBackground(new Color(210, 105, 30));
		
		JButton btnKhuyenMai = new JButton("Sửa");
		btnKhuyenMai.setIcon(new ImageIcon(QuanLyKhuyenMai.class.getResource("/icon/sua.png")));
		btnKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		btnKhuyenMai.setBackground(new Color(255, 255, 0));
		
		JButton btnLamMoi = new JButton("Làm mới ");
		btnLamMoi.setIcon(new ImageIcon(QuanLyKhuyenMai.class.getResource("/icon/loading.png")));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 12));
		btnLamMoi.setBackground(new Color(152, 251, 152));
		
		dateChooserThoiGianBatDauGiamGia = new JDateChooser();
		dateChooserThoiGianKetThucGiamGia = new JDateChooser();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserThoiGianKetThucGiamGia, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(lblThoiGianBatDauKhuyenMai)
						.addComponent(lblThoiGianKetThucKhuyenMai, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnLuuKhuyenMai, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(btnKhuyenMai, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(58)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooserThoiGianBatDauGiamGia, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addComponent(lblThoiGianBatDauKhuyenMai, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dateChooserThoiGianBatDauGiamGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblThoiGianKetThucKhuyenMai, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dateChooserThoiGianKetThucGiamGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLuuKhuyenMai, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKhuyenMai, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblMaKhuyenMai = new JLabel("Mã khuyến mãi :");
		lblMaKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtMaKhuyenMai = new JTextField();
		txtMaKhuyenMai.setEditable(false);
		txtMaKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMaKhuyenMai.setColumns(10);
		
		JLabel lblTenKhuyenMai = new JLabel("Tên khuyến mãi :");
		lblTenKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTenKhuyenMai = new JTextField();
		txtTenKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTenKhuyenMai.setColumns(10);
		
		JLabel lblMucKhuyenMai = new JLabel("Mức khuyến mãi ( % ) :");
		lblMucKhuyenMai.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtMucKhuyenMai = new JTextField();
		txtMucKhuyenMai.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMucKhuyenMai.setColumns(10);
		
		JCheckBox checkBoxChonTatCa = new JCheckBox("Select All");
		checkBoxChonTatCa.setBackground(new Color(255, 255, 255));
		checkBoxChonTatCa.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblPhanLoai = new JLabel("Phân loại :");
		lblPhanLoai.setFont(new Font("Arial", Font.BOLD, 12));
		
		comboBoxPhanLoai = new JComboBox<>();
		comboBoxPhanLoai.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxPhanLoai.setModel(new DefaultComboBoxModel(new String[] {"Áo", "Quần", "Nón", "Thắt lưng"}));
		
		JLabel lblTimKiemSanPham = new JLabel("Tìm kiếm sản phẩm :");
		lblTimKiemSanPham.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTimKiemSanPham = new JTextField();
		txtTimKiemSanPham.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTimKiemSanPham.setColumns(10);
		
		JButton btnTimKiemSanPham = new JButton("Tìm");
		btnTimKiemSanPham.setIcon(new ImageIcon(QuanLyKhuyenMai.class.getResource("/icon/search.png")));
		btnTimKiemSanPham.setFont(new Font("Arial", Font.BOLD, 11));
		btnTimKiemSanPham.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane_SanPham = new JScrollPane();
		scrollPane_SanPham.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_SanPham, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(checkBoxChonTatCa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPhanLoai)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxPhanLoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMaKhuyenMai)
						.addComponent(lblTenKhuyenMai, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMucKhuyenMai)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtMucKhuyenMai, Alignment.LEADING)
							.addComponent(txtTenKhuyenMai, Alignment.LEADING)
							.addComponent(txtMaKhuyenMai, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMaKhuyenMai)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMaKhuyenMai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTenKhuyenMai, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTenKhuyenMai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMucKhuyenMai, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMucKhuyenMai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(checkBoxChonTatCa)
						.addComponent(lblPhanLoai, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxPhanLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(scrollPane_SanPham, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
		);
		
		tblSanPham = new JTable();
		tblSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{null, null, null, null},
				{Boolean.FALSE, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Select", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n gi\u00E1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblSanPham.getColumnModel().getColumn(0).setMinWidth(10);
		tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane_SanPham.setViewportView(tblSanPham);
		panel.setLayout(gl_panel);
		pnlKhuyenMai.setLayout(gl_pnlKhuyenMai);
		setLayout(groupLayout);
	}
}
