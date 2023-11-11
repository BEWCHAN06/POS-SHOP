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

import ConnectDB.KetNoiSQL;
import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;

public class QuanLyHoaDon extends JPanel implements ActionListener {
	private JTextField txtTimKiemHoaDon;
	private JButton btnTimKiemHoaDon;
	private JComboBox<String> comboBoxTongTien, comboBoxThangHoaDon, comboBoxNamHoaDon;
	private JTextField txtTimKiemHoaDonTraHang;
	private JTable tblHoaDon, tblChiTietHoaDon, tblHoaDonTraHang, tblChiTietHoaDonTraHang;
	private DefaultTableModel modelHoaDon, modelChiTietHoaDon, modelHoaDonTraHang, modelChiTietHoaDonTraHang;
	private HoaDonDAO dshd = new HoaDonDAO();
	private ChiTietHoaDonDAO dscthd = new ChiTietHoaDonDAO();

	/**
	 * Create the panel.
	 */
	public QuanLyHoaDon() {
		KetNoiSQL.getInstance().connect();
		initComponents();
	}

	public void initComponents() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLayout(new CardLayout(0, 0));
		setPreferredSize(new Dimension(934, 687));

		JPanel pnlMain = new JPanel();
		pnlMain.setForeground(new Color(255, 255, 255));
		pnlMain.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlMain.setBackground(new Color(255, 255, 255));
		add(pnlMain, "name_195669266279000");

		JTabbedPane tabbedPaneHoaDon = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneHoaDon.setBorder(null);
		tabbedPaneHoaDon.setToolTipText("g");
		GroupLayout gl_pnlMain = new GroupLayout(pnlMain);
		gl_pnlMain.setHorizontalGroup(gl_pnlMain.createParallelGroup(Alignment.TRAILING).addComponent(tabbedPaneHoaDon,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE));
		gl_pnlMain.setVerticalGroup(gl_pnlMain.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlMain.createSequentialGroup()
						.addComponent(tabbedPaneHoaDon, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JPanel pnlHoaDon = new JPanel();
		tabbedPaneHoaDon.addTab("Hóa Đơn", null, pnlHoaDon, null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

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
		panel_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));

		comboBoxThangHoaDon = new JComboBox<>();
		comboBoxThangHoaDon.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxThangHoaDon.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		JLabel lblThang = new JLabel("Tháng :");
		lblThang.setHorizontalAlignment(SwingConstants.LEFT);
		lblThang.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNam = new JLabel("Năm :");
		lblNam.setHorizontalAlignment(SwingConstants.LEFT);
		lblNam.setFont(new Font("Arial", Font.BOLD, 12));

		comboBoxNamHoaDon = new JComboBox<>();
		comboBoxNamHoaDon.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxNamHoaDon.setModel(new DefaultComboBoxModel(
				new String[] { "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015" }));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1
				.setHorizontalGroup(
						gl_panel_1_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1_1.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBoxThangHoaDon, 0, 66, Short.MAX_VALUE)
												.addComponent(lblThang, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
										.addGap(27)
										.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNam, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBoxNamHoaDon, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE))
										.addGap(20)));
		gl_panel_1_1.setVerticalGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
						.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblThang, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNam, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
						.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxThangHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxNamHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1_1.setLayout(gl_panel_1_1);

		JScrollPane scrollPane_HoaDon = new JScrollPane();
		scrollPane_HoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(229).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING,
								false)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 246,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnTimKiemHoaDon,
										GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(23)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addGap(15)))
						.addContainerGap(242, Short.MAX_VALUE))
				.addComponent(scrollPane_HoaDon, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiemHoaDon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
						.addGap(28).addComponent(scrollPane_HoaDon, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)));

		tblHoaDon = new JTable();
		tblHoaDon.setForeground(new Color(0, 0, 0));
		tblHoaDon.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_HoaDon.setViewportView(tblHoaDon);
		tblHoaDon.setModel(modelHoaDon = new DefaultTableModel(new Object[][] {

		}, new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "M\u00E3 nh\u00E2n vi\u00EAn",
				"T\u00EAn nh\u00E2n vi\u00EAn", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
				"T\u1ED5ng ti\u1EC1n" }));

		JLabel lblTongTien = new JLabel("Tổng tiền :");
		lblTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 12));

		comboBoxTongTien = new JComboBox<>();
		comboBoxTongTien.setFont(new Font("Arial", Font.BOLD, 11));
		comboBoxTongTien.setModel(new DefaultComboBoxModel(new String[] { "0 NVĐ - 500.000 VNĐ",
				"500.000 VNĐ - 1.000.000 VNĐ", "1.000.000 VNĐ - 1.500.000 VNĐ", "1.500.000 VNĐ - 2.000.000 VNĐ" }));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panel_1.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxTongTien, GroupLayout.PREFERRED_SIZE, 171,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(lblTongTien, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBoxTongTien,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Chi Ti\u1EBFt H\u00F3a \u0110\u01A1n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				null));

		JScrollPane scrollPane_ChiTietHoaDon = new JScrollPane();
		scrollPane_ChiTietHoaDon.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_ChiTietHoaDon, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(scrollPane_ChiTietHoaDon,
						GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)));

		tblChiTietHoaDon = new JTable();
		tblChiTietHoaDon.setFont(new Font("Arial", Font.PLAIN, 12));
		tblChiTietHoaDon.setModel(modelChiTietHoaDon = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i",
						"\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u1EA3m gi\u00E1",
						"Ch\u1EA5t li\u1EC7u", "Ki\u1EC3u d\u00E1ng", "M\u00E0u s\u1EAFc", "K\u00EDch th\u01B0\u1EDBc",
						"Th\u00E0nh ti\u1EC1n" }));
		scrollPane_ChiTietHoaDon.setViewportView(tblChiTietHoaDon);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_pnlHoaDon = new GroupLayout(pnlHoaDon);
		gl_pnlHoaDon.setHorizontalGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlHoaDon
				.createSequentialGroup()
				.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE).addComponent(panel,
								Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnlHoaDon.setVerticalGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHoaDon.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		pnlHoaDon.setLayout(gl_pnlHoaDon);

		JPanel pnlHoaDonTraHang = new JPanel();
		tabbedPaneHoaDon.addTab("Hóa Đơn Trả Hàng", null, pnlHoaDonTraHang, null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.WHITE);

		JLabel lblTmKimHa = new JLabel("Tìm kiếm hóa đơn trả hàng:");
		lblTmKimHa.setFont(new Font("Arial", Font.BOLD, 12));

		txtTimKiemHoaDonTraHang = new JTextField();
		txtTimKiemHoaDonTraHang.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimKiemHoaDonTraHang.setColumns(10);

		JButton btnTimKiemHoaDonTraHang = new JButton("Tìm");
		btnTimKiemHoaDonTraHang.setIcon(new ImageIcon(QuanLyHoaDon.class.getResource("/icon/search.png")));
		btnTimKiemHoaDonTraHang.setFont(new Font("Arial", Font.BOLD, 11));
		btnTimKiemHoaDonTraHang.setBackground(Color.LIGHT_GRAY);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_1_2.setBackground(Color.WHITE);

		JLabel lblTongTien_1 = new JLabel("Tổng tiền :");
		lblTongTien_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien_1.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox<String> comboBoxTongTienTraHang = new JComboBox<String>();
		comboBoxTongTienTraHang.setModel(new DefaultComboBoxModel(new String[] { "0 NVĐ - 500.000 VNĐ",
				"500.000 VNĐ - 1.000.000 VNĐ", "1.000.000 VNĐ - 1.500.000 VNĐ", "1.500.000 VNĐ - 2.000.000 VNĐ" }));
		comboBoxTongTienTraHang.setFont(new Font("Arial", Font.BOLD, 11));
		GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
		gl_panel_1_2
				.setHorizontalGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING).addGap(0, 193, Short.MAX_VALUE)
						.addGroup(gl_panel_1_2.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTongTien_1, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxTongTienTraHang, GroupLayout.PREFERRED_SIZE, 171,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel_1_2.setVerticalGroup(gl_panel_1_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 60, Short.MAX_VALUE)
				.addGroup(gl_panel_1_2.createSequentialGroup()
						.addComponent(lblTongTien_1, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBoxTongTienTraHang,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel_1_2.setLayout(gl_panel_1_2);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_1_1_1.setBackground(Color.WHITE);

		JComboBox<String> comboBoxThangTraHang = new JComboBox<String>();
		comboBoxThangTraHang.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBoxThangTraHang.setFont(new Font("Arial", Font.BOLD, 11));

		JLabel lblThang_1 = new JLabel("Tháng :");
		lblThang_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblThang_1.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNam_1 = new JLabel("Năm :");
		lblNam_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNam_1.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox<String> comboBoxNamTraHang = new JComboBox<String>();
		comboBoxNamTraHang.setModel(new DefaultComboBoxModel(
				new String[] { "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015" }));
		comboBoxNamTraHang.setFont(new Font("Arial", Font.BOLD, 11));
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
				gl_panel_1_1_1.createParallelGroup(Alignment.LEADING).addGap(0, 193, Short.MAX_VALUE)
						.addGroup(gl_panel_1_1_1.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxThangTraHang, 0, 66, Short.MAX_VALUE)
										.addComponent(lblThang_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
								.addGap(27)
								.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNam_1, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxNamTraHang, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE))
								.addGap(20)));
		gl_panel_1_1_1.setVerticalGroup(gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 60, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
						.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblThang_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNam_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxThangTraHang, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxNamTraHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1_1_1.setLayout(gl_panel_1_1_1);

		JScrollPane scrollPane_HoaDonTraHang = new JScrollPane();
		scrollPane_HoaDonTraHang.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 915, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(182).addGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup().addComponent(lblTmKimHa)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTimKiemHoaDonTraHang, GroupLayout.PREFERRED_SIZE, 246,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnTimKiemHoaDonTraHang, GroupLayout.PREFERRED_SIZE, 83,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addGap(15)))
						.addContainerGap(231, Short.MAX_VALUE))
				.addComponent(scrollPane_HoaDonTraHang, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 911,
						Short.MAX_VALUE));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGap(0, 359, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup().addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTmKimHa, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemHoaDonTraHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTimKiemHoaDonTraHang, GroupLayout.PREFERRED_SIZE, 28,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_2, 0, 0, Short.MAX_VALUE))
						.addGap(28)
						.addComponent(scrollPane_HoaDonTraHang, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)));

		tblHoaDonTraHang = new JTable();
		tblHoaDonTraHang.setForeground(new Color(255, 255, 255));
		tblHoaDonTraHang.setModel(modelHoaDonTraHang = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 h\u00F3a \u0111\u01A1n tr\u1EA3 h\u00E0ng", "Ng\u00E0y l\u1EADp",
						"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "M\u00E3 kh\u00E1ch h\u00E0ng",
						"T\u00EAn kh\u00E1ch h\u00E0ng", "T\u1ED5ng ti\u1EC1n tr\u1EA3 h\u00E0ng" }));
		tblHoaDonTraHang.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_HoaDonTraHang.setViewportView(tblHoaDonTraHang);
		panel_3.setLayout(gl_panel_3);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"Chi Ti\u1EBFt H\u00F3a \u0110\u01A1n Tr\u1EA3 H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)), null));
		panel_2_1.setBackground(Color.WHITE);

		JScrollPane scrollPane_ChiTietHoaDonTraHang = new JScrollPane();
		scrollPane_ChiTietHoaDonTraHang.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_ChiTietHoaDonTraHang, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE));
		gl_panel_2_1.setVerticalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_2_1.createSequentialGroup().addContainerGap().addComponent(scrollPane_ChiTietHoaDonTraHang,
						GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)));

		tblChiTietHoaDonTraHang = new JTable();
		tblChiTietHoaDonTraHang.setForeground(new Color(255, 255, 255));
		tblChiTietHoaDonTraHang.setBackground(new Color(255, 255, 255));
		tblChiTietHoaDonTraHang.setFont(new Font("Arial", Font.PLAIN, 12));
		tblChiTietHoaDonTraHang.setModel(modelChiTietHoaDonTraHang = new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i",
						"\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "M\u00E0u s\u1EAFc", "Ch\u1EA5t li\u1EC7u",
						"K\u00EDch th\u01B0\u1EDBc" }));
		scrollPane_ChiTietHoaDonTraHang.setViewportView(tblChiTietHoaDonTraHang);
		panel_2_1.setLayout(gl_panel_2_1);
		GroupLayout gl_pnlHoaDonTraHang = new GroupLayout(pnlHoaDonTraHang);
		gl_pnlHoaDonTraHang.setHorizontalGroup(
				gl_pnlHoaDonTraHang.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_pnlHoaDonTraHang.createSequentialGroup()
								.addGroup(gl_pnlHoaDonTraHang.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 926,
												Short.MAX_VALUE)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE))
								.addContainerGap()));
		gl_pnlHoaDonTraHang.setVerticalGroup(gl_pnlHoaDonTraHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHoaDonTraHang.createSequentialGroup()
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		pnlHoaDonTraHang.setLayout(gl_pnlHoaDonTraHang);
		pnlMain.setLayout(gl_pnlMain);

		/*
		 * ==== EVENT ====
		 */
		updateTableHoaDon();
		tblHoaDon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tblHoaDon.getSelectedRow();
				if (row != -1) {
					String selectedMaHD = (String) tblHoaDon.getValueAt(row, 0);
					List<ChiTietHoaDon> list = dscthd.getChiTietHoaDonTheoMaHD(selectedMaHD);
					modelChiTietHoaDon.getDataVector().removeAllElements();
					for (ChiTietHoaDon cthd : list) {
						Double thanhTien = cthd.thanhTien();
						Object data[] = { cthd.getSanPham().getMaSP(), cthd.getSanPham().getTenSP(),
								cthd.getSanPham().getPl().getPhanLoai(), cthd.getSanPham().getGiaBan(),
								cthd.getSanPham().getSoLuong(), cthd.getPhanTramKhuyenMai(),
								cthd.getSanPham().getChatLieu().getChatLieu(),
								cthd.getSanPham().getKieuDang().getKieuDang(),
								cthd.getSanPham().getMauSac().getMauSac(),
								cthd.getSanPham().getKichThuoc().getKichThuoc(), thanhTien };
						modelChiTietHoaDon.addRow(data);
					}
					tblChiTietHoaDon.setModel(modelChiTietHoaDon);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private void updateTableHoaDon() {
		modelHoaDon.getDataVector().removeAllElements();
		List<HoaDon> list = dshd.doTuBang();
		for (HoaDon hd : list) {
			Double tongTien = hd.tongTien();
			Object data[] = { hd.getMaHoaDon(), hd.getNgayLap(), hd.getNhanVien().getMaNV(),
					hd.getNhanVien().getTenNV(), hd.getKhachHang().getMaKH(), hd.getKhachHang().getTenKH(), tongTien };
			modelHoaDon.addRow(data);
		}
		tblHoaDon.setModel(modelHoaDon);
	}
}
