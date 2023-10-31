package gui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class QuanLyHoaDon extends JPanel {
	private JTextField txtTimKiemHoaDon;
	private JButton btnTimKiemHoaDon;
	private JComboBox<String> comboBoxTongTien, comboBoxThang, comboBoxNam;
	private JTable tblHoaDon, tblChiTietHoaDon;

	/**
	 * Create the panel.
	 */
	public QuanLyHoaDon() {
		setBackground(new Color(255, 255, 255));
		setLayout(new CardLayout(0, 0));
		setPreferredSize(new Dimension(934, 687));
		
		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(255, 255, 255));
		add(pnlHoaDon, "name_195669266279000");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "H\u00F3a \u0110\u01A1n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Chi Ti\u1EBFt H\u00F3a \u0110\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		GroupLayout gl_pnlHoaDon = new GroupLayout(pnlHoaDon);
		gl_pnlHoaDon.setHorizontalGroup(
			gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
		);
		gl_pnlHoaDon.setVerticalGroup(
			gl_pnlHoaDon.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnlHoaDon.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane_ChiTietHoaDon = new JScrollPane();
		scrollPane_ChiTietHoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_ChiTietHoaDon, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_ChiTietHoaDon, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
		);
		
		tblChiTietHoaDon = new JTable();
		tblChiTietHoaDon.setFont(new Font("Arial", Font.PLAIN, 12));
		tblChiTietHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Loại", "Đơn giá", "Số lượng", "Màu sắc", "Chất liệu", "Kích thước"
			}
		));
		scrollPane_ChiTietHoaDon.setViewportView(tblChiTietHoaDon);
		panel_2.setLayout(gl_panel_2);
		
		txtTimKiemHoaDon = new JTextField();
		txtTimKiemHoaDon.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimKiemHoaDon.setColumns(10);
		
		JLabel lblTimKiemHoaDon = new JLabel("Tìm kiếm hóa đơn :");
		lblTimKiemHoaDon.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnTimKiemHoaDon = new JButton("Tìm");
		btnTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemHoaDon.setIcon(new ImageIcon(QuanLyHoaDon.class.getResource("/icon/search.png")));
		btnTimKiemHoaDon.setFont(new Font("Arial", Font.BOLD, 11));
		btnTimKiemHoaDon.setBackground(new Color(192, 192, 192));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		comboBoxThang = new JComboBox<>();
		comboBoxThang.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JLabel lblThang = new JLabel("Tháng :");
		lblThang.setHorizontalAlignment(SwingConstants.LEFT);
		lblThang.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNam = new JLabel("Năm :");
		lblNam.setHorizontalAlignment(SwingConstants.LEFT);
		lblNam.setFont(new Font("Arial", Font.BOLD, 12));
		
		comboBoxNam = new JComboBox<>();
		comboBoxNam.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxNam.setModel(new DefaultComboBoxModel(new String[] {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015"}));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxThang, 0, 66, Short.MAX_VALUE)
						.addComponent(lblThang, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNam, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxNam, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblThang, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNam, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxNam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JScrollPane scrollPane_HoaDon = new JScrollPane();
		scrollPane_HoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(229)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addGap(15)))
					.addContainerGap(242, Short.MAX_VALUE))
				.addComponent(scrollPane_HoaDon, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
					.addGap(28)
					.addComponent(scrollPane_HoaDon, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
		);
		
		tblHoaDon = new JTable();
		tblHoaDon.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_HoaDon.setViewportView(tblHoaDon);
		tblHoaDon.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "T\u1ED5ng ti\u1EC1n"
			}
		));
		
		JLabel lblTongTien = new JLabel("Tổng tiền :");
		lblTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 12));
			
		comboBoxTongTien = new JComboBox<>();
		comboBoxTongTien.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxTongTien.setModel(new DefaultComboBoxModel(new String[] {"0 NVĐ - 500.000 VNĐ", "500.000 VNĐ - 1.000.000 VNĐ", "1.000.000 VNĐ - 1.500.000 VNĐ", "1.500.000 VNĐ - 2.000.000 VNĐ"}));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxTongTien, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblTongTien, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxTongTien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		pnlHoaDon.setLayout(gl_pnlHoaDon);

	}
}
