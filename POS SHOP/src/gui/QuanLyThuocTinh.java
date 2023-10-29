package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuanLyThuocTinh extends JPanel {
	private JTextField txtTenThuocTinh;
	private JTextField textField;
	private JTable tblThuocTinh;

	/**
	 * Create the panel.
	 */
	public QuanLyThuocTinh() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(932, 685));
		setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel, "name_115175246584900");
		
		JPanel pnlThuocTinh = new JPanel();
		pnlThuocTinh.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Thu\u1ED9c t\u00EDnh s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		pnlThuocTinh.setBackground(new Color(255, 255, 255));
		
		JPanel pnlDanhSachThuocTinh = new JPanel();
		pnlDanhSachThuocTinh.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh S\u00E1ch Thu\u1ED9c T\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		pnlDanhSachThuocTinh.setBackground(new Color(255, 255, 255));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlDanhSachThuocTinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
						.addComponent(pnlThuocTinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlThuocTinh, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDanhSachThuocTinh, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblTmKimThuc = new JLabel("Tìm kiếm thuộc tính");
		lblTmKimThuc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_pnlDanhSachThuocTinh = new GroupLayout(pnlDanhSachThuocTinh);
		gl_pnlDanhSachThuocTinh.setHorizontalGroup(
			gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachThuocTinh.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTmKimThuc, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(383, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
		);
		gl_pnlDanhSachThuocTinh.setVerticalGroup(
			gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachThuocTinh.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTmKimThuc)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
		);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		panel.add(scrollPane, "name_117489822752800");
		
		tblThuocTinh = new JTable();
		tblThuocTinh.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"M\u00E3 Thu\u1ED9c T\u00EDnh", "T\u00EAn Thu\u1ED9c T\u00EDnh"
			}
		));
		scrollPane.setViewportView(tblThuocTinh);
		pnlDanhSachThuocTinh.setLayout(gl_pnlDanhSachThuocTinh);
		
		JLabel lblNewLabel = new JLabel("Tên thuộc tính :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel pnlListThuocTinh = new JPanel();
		pnlListThuocTinh.setBackground(new Color(255, 255, 255));
		
		JButton btnThem = new JButton("thêm");
		btnThem.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnThem.setBackground(new Color(65, 105, 225));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/sua.png")));
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSua.setBackground(Color.YELLOW);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/luulienket.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLuu.setBackground(new Color(255, 165, 0));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/refesh.png")));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 12));
		btnLamMoi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/x.png")));
		btnHy.setForeground(Color.WHITE);
		btnHy.setFont(new Font("Arial", Font.BOLD, 12));
		btnHy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnHy.setBackground(Color.RED);
		
		txtTenThuocTinh = new JTextField();
		txtTenThuocTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTenThuocTinh.setColumns(10);
		GroupLayout gl_pnlThuocTinh = new GroupLayout(pnlThuocTinh);
		gl_pnlThuocTinh.setHorizontalGroup(
			gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThuocTinh.createSequentialGroup()
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTenThuocTinh, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(pnlListThuocTinh, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(75)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlThuocTinh.setVerticalGroup(
			gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThuocTinh.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlListThuocTinh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(txtTenThuocTinh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(1)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(1)
							.addComponent(btnHy, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Màu sắc");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JRadioButton rdbtnKchThc = new JRadioButton("Kích thước");
		rdbtnKchThc.setBackground(new Color(255, 255, 255));
		rdbtnKchThc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Chất liệu");
		rdbtnNewRadioButton_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JRadioButton rdbtnKiuDng = new JRadioButton("kiểu dáng");
		rdbtnKiuDng.setBackground(new Color(255, 255, 255));
		rdbtnKiuDng.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JRadioButton rdbtnXutX = new JRadioButton("Xuất xứ");
		rdbtnXutX.setBackground(new Color(255, 255, 255));
		rdbtnXutX.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Loại sản phẩm");
		rdbtnNewRadioButton_1_1_1.setBackground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_pnlListThuocTinh = new GroupLayout(pnlListThuocTinh);
		gl_pnlListThuocTinh.setHorizontalGroup(
			gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlListThuocTinh.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnKiuDng, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnXutX, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnKchThc, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnNewRadioButton_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnNewRadioButton_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlListThuocTinh.setVerticalGroup(
			gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlListThuocTinh.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnKchThc)
						.addComponent(rdbtnNewRadioButton_1_1))
					.addGap(18)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnKiuDng)
						.addComponent(rdbtnXutX)
						.addComponent(rdbtnNewRadioButton_1_1_1))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		pnlListThuocTinh.setLayout(gl_pnlListThuocTinh);
		pnlThuocTinh.setLayout(gl_pnlThuocTinh);
		mainPanel.setLayout(gl_mainPanel);
	}
}
