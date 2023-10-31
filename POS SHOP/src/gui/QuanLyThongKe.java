package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.ScrollPane;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class QuanLyThongKe extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTable tblDoiTra;
	/**
	 * Create the panel.
	 */
	public QuanLyThongKe() {
		setPreferredSize(new Dimension(934, 685));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(182, 215, 168));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(182, 215, 168));
		
		JLabel lblSHon = new JLabel("Số Hoá Đơn");
		lblSHon.setFont(new Font("Arial", Font.BOLD, 17));
		lblSHon.setBackground(new Color(182, 215, 168));
		
		JLabel lblSoHD = new JLabel("1");
		lblSoHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoHD.setFont(new Font("Arial", Font.BOLD, 17));
		lblSoHD.setBackground(new Color(182, 215, 168));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblSHon)
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(lblSoHD, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(58))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblSHon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSoHD, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(182, 215, 168));
		
		JLabel lblSHngi = new JLabel("Số Hàng Đổi");
		lblSHngi.setFont(new Font("Arial", Font.BOLD, 17));
		lblSHngi.setBackground(new Color(182, 215, 168));
		
		JLabel lblSoHangDoi = new JLabel("0");
		lblSoHangDoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoHangDoi.setFont(new Font("Arial", Font.BOLD, 17));
		lblSoHangDoi.setBackground(new Color(182, 215, 168));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(lblSHngi)
					.addGap(46))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(61)
					.addComponent(lblSoHangDoi, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(lblSHngi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSoHangDoi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(182, 215, 168));
		
		JLabel lblTngKhchHng = new JLabel("Tổng Khách Hàng");
		lblTngKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTngKhchHng.setFont(new Font("Arial", Font.BOLD, 17));
		lblTngKhchHng.setBackground(new Color(182, 215, 168));
		
		JLabel lblTongKH = new JLabel("10");
		lblTongKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongKH.setFont(new Font("Arial", Font.BOLD, 17));
		lblTongKH.setBackground(new Color(182, 215, 168));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(21)
					.addComponent(lblTngKhchHng)
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(lblTongKH, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTngKhchHng)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(lblTongKH, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JRadioButton rdbtnTatCa = new JRadioButton("Tất cả");
		rdbtnTatCa.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnTatCa.setSelected(true);
		rdbtnTatCa.setBackground(new Color(255, 255, 255));
		
		JRadioButton rdbtnTheoThang = new JRadioButton("Theo tháng");
		rdbtnTheoThang.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnTheoThang.setBackground(Color.WHITE);
		
		JRadioButton rdbtnTheoNam = new JRadioButton("Theo năm");
		rdbtnTheoNam.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtnTheoNam.setBackground(Color.WHITE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 884, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnTatCa)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(rdbtnTheoNam, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnTheoThang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(rdbtnTatCa)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnTheoThang, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnTheoNam, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setFont(new Font("Arial", Font.BOLD, 16));
		tabbedPane.addTab("Sản Phẩm", null, panelSanPham, null);
		tabbedPane.setEnabledAt(0, true);
		
		table = new JTable();
		
		JComboBox cbBoxPhanLoai = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("Phân Loại");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Năm");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm Kiếm");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Gửi Báo Cáo");
		btnNewButton.setBackground(new Color(182, 215, 168));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panelSanPham = new GroupLayout(panelSanPham);
		gl_panelSanPham.setHorizontalGroup(
			gl_panelSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSanPham.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 857, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelSanPham.createSequentialGroup()
									.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(cbBoxPhanLoai, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
									.addGap(46)
									.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
									.addGap(44)
									.addGroup(gl_panelSanPham.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panelSanPham.createSequentialGroup()
							.addGap(358)
							.addComponent(btnNewButton)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panelSanPham.setVerticalGroup(
			gl_panelSanPham.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSanPham.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelSanPham.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbBoxPhanLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		panelSanPham.setLayout(gl_panelSanPham);
		
		JPanel panelDoiTra = new JPanel();
		panelDoiTra.setFont(new Font("Arial", Font.BOLD, 16));
		tabbedPane.addTab("Đổi Trả", null, panelDoiTra, null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Hoá Đơn");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		
		JLabel lblNewLabel_5 = new JLabel("Nhân Viên");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		
		JComboBox comboBox_2 = new JComboBox();
		
		JButton btnNewButton_1 = new JButton("Gửi Báo Cáo");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(182, 215, 168));
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_panelDoiTra = new GroupLayout(panelDoiTra);
		gl_panelDoiTra.setHorizontalGroup(
			gl_panelDoiTra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDoiTra.createSequentialGroup()
					.addGroup(gl_panelDoiTra.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDoiTra.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelDoiTra.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(gl_panelDoiTra.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)))
						.addGroup(gl_panelDoiTra.createSequentialGroup()
							.addGap(356)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panelDoiTra.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 861, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelDoiTra.setVerticalGroup(
			gl_panelDoiTra.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDoiTra.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDoiTra.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelDoiTra.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel_4.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, "name_873321168537800");
		
		tblDoiTra = new JTable();
		tblDoiTra.setFont(new Font("Arial", Font.BOLD, 13));
		tblDoiTra.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblDoiTra.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Ho\u00E1 \u0110\u01A1n", " Ng\u00E0y T\u1EA1o", "M\u00E3 Nh\u00E2n Vi\u00EAn", "Kh\u00E1ch H\u00E0ng", "T\u1ED5ng Ti\u1EC1n G\u1ED1c", " T\u1ED5ng Ti\u1EC1n Tr\u1EA3", "T\u1ED5ng Ti\u1EC1n Mua M\u1EDBi", "Ti\u1EC1n Tr\u1EA3 Kh\u00E1ch", "Doanh Thu"
			}
		));
		tblDoiTra.getColumnModel().getColumn(4).setPreferredWidth(82);
		tblDoiTra.getColumnModel().getColumn(5).setPreferredWidth(89);
		tblDoiTra.getColumnModel().getColumn(6).setPreferredWidth(100);
		tblDoiTra.getColumnModel().getColumn(7).setPreferredWidth(82);
		scrollPane.setViewportView(tblDoiTra);
		panelDoiTra.setLayout(gl_panelDoiTra);
		
		JLabel lblNewLabel = new JLabel("Doanh Thu");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(182, 215, 168));
		
		JLabel lblDT = new JLabel("15.000.000 VNĐ");
		lblDT.setFont(new Font("Arial", Font.BOLD, 17));
		lblDT.setBackground(new Color(182, 215, 168));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblDT)
							.addGap(27))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDT, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
