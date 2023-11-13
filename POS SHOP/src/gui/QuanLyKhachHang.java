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

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import entity.NhanVien;

import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class QuanLyKhachHang extends JPanel implements ActionListener,MouseListener {
	private JTextField txtMaKH;
	private JTextField txtTenKh;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private JTextField txtDiachi;
	private JTextField textField;
	private JTable tblThongtin;
	private JTextField txtTimkiemGD;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang() {
		setPreferredSize(new Dimension(934, 687));
		setLayout(new CardLayout(0, 0));
		
		JPanel Mainpanel = new JPanel();
		add(Mainpanel, "name_131322479893799");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Thi\u1EBFt L\u1EADp Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);
		gl_Mainpanel.setHorizontalGroup(
			gl_Mainpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Mainpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Mainpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Mainpanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 918, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_Mainpanel.createSequentialGroup()
							.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
							.addGap(2))))
		);
		gl_Mainpanel.setVerticalGroup(
			gl_Mainpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Mainpanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		JTabbedPane tabbedThongtin = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel pnLoc = new JPanel();
		pnLoc.setBackground(new Color(255, 255, 255));
		pnLoc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedThongtin, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnLoc, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(tabbedThongtin, GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(62)
							.addComponent(pnLoc, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblGioitinhloc = new JLabel("Giới tinh:");
		lblGioitinhloc.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTrangthailoc = new JLabel("Trạng thái:");
		lblTrangthailoc.setFont(new Font("Arial", Font.BOLD, 12));
		
		JComboBox comboBoxGioitinh = new JComboBox();
		comboBoxGioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		
		JComboBox comboBoxTrangthai = new JComboBox();
		comboBoxTrangthai.setModel(new DefaultComboBoxModel(new String[] {"Còn hoạt động", "Ngưng hoạt động"}));
		GroupLayout gl_pnLoc = new GroupLayout(pnLoc);
		gl_pnLoc.setHorizontalGroup(
			gl_pnLoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLoc.createSequentialGroup()
					.addGroup(gl_pnLoc.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblGioitinhloc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTrangthailoc, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLoc.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxGioitinh, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxTrangthai, 0, 102, Short.MAX_VALUE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_pnLoc.setVerticalGroup(
			gl_pnLoc.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLoc.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLoc.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGioitinhloc)
						.addComponent(comboBoxGioitinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLoc.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrangthailoc)
						.addComponent(comboBoxTrangthai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		pnLoc.setLayout(gl_pnLoc);
		
		JPanel pnGiaodich = new JPanel();
		pnGiaodich.setBackground(new Color(255, 255, 255));
		tabbedThongtin.addTab("Lịch Sử Giao Dịch", null, pnGiaodich, null);
		
		JPanel pnLichsu = new JPanel();
		pnLichsu.setBackground(new Color(255, 255, 255));
		pnGiaodich.add(pnLichsu);
		
		JLabel lblTimkiemGD = new JLabel("Tìm kiếm:");
		lblTimkiemGD.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTimkiemGD = new JTextField();
		txtTimkiemGD.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimkiemGD.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		GroupLayout gl_pnLichsu = new GroupLayout(pnLichsu);
		gl_pnLichsu.setHorizontalGroup(
			gl_pnLichsu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLichsu.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLichsu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnLichsu.createSequentialGroup()
							.addComponent(lblTimkiemGD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTimkiemGD))
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_pnLichsu.setVerticalGroup(
			gl_pnLichsu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLichsu.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_pnLichsu.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimkiemGD)
						.addComponent(txtTimkiemGD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPaneLSGD = new JScrollPane();
		panel_2_1.add(scrollPaneLSGD, "name_299840614057200");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD v\u00E0 t\u00EAn", "Email", "S\u0110T", "Gi\u1EDBi t\u00EDnh"
			}
		));
		scrollPaneLSGD.setViewportView(table);
		pnLichsu.setLayout(gl_pnLichsu);
		
		JPanel pnThongtin = new JPanel();
		pnThongtin.setBackground(new Color(255, 255, 255));
		tabbedThongtin.addTab("Thông Tin Cá Nhân", null, pnThongtin, null);
		
		JLabel lblTimkiem = new JLabel("Tìm kiếm:");
		lblTimkiem.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		GroupLayout gl_pnThongtin = new GroupLayout(pnThongtin);
		gl_pnThongtin.setHorizontalGroup(
			gl_pnThongtin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongtin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnThongtin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThongtin.createSequentialGroup()
							.addComponent(lblTimkiem)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnThongtin.setVerticalGroup(
			gl_pnThongtin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongtin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnThongtin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimkiem)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "name_299268527754300");
		
		tblThongtin = new JTable();
		tblThongtin.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD v\u00E0 t\u00EAn", "Email", "S\u0110T", "Gi\u1EDBi t\u00EDnh"
			}
		));
		scrollPane.setViewportView(tblThongtin);
		pnThongtin.setLayout(gl_pnThongtin);
		panel_1.setLayout(gl_panel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblGiiTinh = new JLabel("Giới tinh:");
		lblGiiTinh.setFont(new Font("Arial", Font.BOLD, 12));
		
		JRadioButton rdGioitinh = new JRadioButton("Nam");
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTenKh = new JTextField();
		txtTenKh.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTenKh.setColumns(10);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSdt.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		
		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setFont(new Font("Arial", Font.BOLD, 12));
		
		JRadioButton rdTrangthai = new JRadioButton("Còn hoạt động");
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiachi.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/icon/add.png")));
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBackground(new Color(255, 255, 0));
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuu.setBackground(new Color(255, 128, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblTnKhchHng, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(lblGiiTinh, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdGioitinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKh, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
							.addGap(86)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblTrngThi, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdTrangthai, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
									.addGap(43)
									.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
									.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(23))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
									.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(92))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(615, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnKhchHng)
								.addComponent(txtTenKh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrngThi)
								.addComponent(rdTrangthai))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGiiTinh)
								.addComponent(lblaCh)
								.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdGioitinh))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinThoi)
								.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Mainpanel.setLayout(gl_Mainpanel);
		
		//nút thêm
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(false);
				btnLuu.setEnabled(true);
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validData()) {

					String makh = txtMaKH.getText().trim();
					String tenkh = txtTenKh.getText().trim();
					String Sdt = txtSdt.getText().trim();
					String diachi = txtDiachi.getText().trim();
					String email = txtEmail.getText().trim();

					boolean gt = true;
					if (rdGioitinh.isSelected()) {
						gt = true;
					} else {
						gt = false;
					}

					int tt = 1;

					if (rdTrangthai.isSelected()) {
						tt = 1;
					} else {
						tt = 0;
					}

					NhanVien nv = new NhanVien(manv, tennv, Date.valueOf(ngaysinh), sdt, email, cmnd, gt,
							diachi, cv, tt);

					nvdao.addNhanVien(nv);
					JOptionPane.showMessageDialog(null, "Thêm thành công 1 nhân viên.");
				}
			}
		});
		
	}
	private boolean validData() {
		String makh = txtMaKH.getText().trim();
		String tenkh = txtTenKh.getText().trim();
		String Sdt = txtSdt.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String email = txtEmail.getText().trim();
		
		if (makh.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền mã khách hàng.");
			return false;
		}
		
		if (tenkh.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền tên khách hàng.");
			return false;
		}
		if (Sdt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền số điện thoại.");
			return false;
		}
		if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền email.");
			return false;
		}
		if (diachi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền địa chỉ.");
			return false;
		}
		return false;
}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}
	
}
