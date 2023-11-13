package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import entity.ChatLieu;
import entity.KichThuoc;
import entity.KieuDang;
import entity.MauSac;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.PhanLoai;
import entity.SanPham;
import entity.TaiKhoan;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class QuanLyNhanVien extends JPanel implements ActionListener, MouseListener {
	private JTextField txtTimNV, txtMaNV, txtTenNV, txtTenTK, txtMK;
	private JTable tableDSTK, tableNgungLV, tableDangLV;
	private JTextField txtManhanvien, txtTen, txtMatkhau, txtDiachi, txtSĐT, txtNgaysinh, txtEmail, txtTimnv, txtTimmNV;
	private JButton btnThem, btnSua, btnLuu;
	private JLabel txtMess;
	private DefaultTableModel modelnv;
	JComboBox cbxgt;
	JComboBox cbxcv;
	private NhanVienDAO nvdao;
	private JTextField txtCMND;

	
	private DefaultTableModel modeltk;
	/**
	 * Create the panel.
	 */
	public QuanLyNhanVien() {
		setPreferredSize(new Dimension(934, 687));
		setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedNVTK = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedNVTK, "name_369984908895700");

		JPanel pnNhanvien = new JPanel();
		pnNhanvien.setBackground(new Color(255, 255, 255));
		tabbedNVTK.addTab("Nhân Viên", null, pnNhanvien, null);

		JPanel pnThietlapTT = new JPanel();
		pnThietlapTT.setBackground(new Color(255, 255, 255));
		pnThietlapTT.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"Thi\u1EBFt L\u1EADp Th\u00F4ng Tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));

		JTabbedPane tabbedLamviec = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_pnNhanvien = new GroupLayout(pnNhanvien);
		gl_pnNhanvien.setHorizontalGroup(gl_pnNhanvien.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_pnNhanvien.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnThietlapTT, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addGroup(gl_pnNhanvien.createSequentialGroup().addContainerGap()
						.addComponent(tabbedLamviec, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));
		gl_pnNhanvien.setVerticalGroup(gl_pnNhanvien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhanvien.createSequentialGroup()
						.addComponent(pnThietlapTT, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tabbedLamviec, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel pnLamviec = new JPanel();
		pnLamviec.setBackground(new Color(255, 255, 255));
		tabbedLamviec.addTab("Đang Làm Việc", null, pnLamviec, null);

		JLabel lbTimNV = new JLabel("Tìm Kiếm Nhân Viên:");
		lbTimNV.setFont(new Font("Arial", Font.BOLD, 12));

		txtTimmNV = new JTextField();
		txtTimmNV.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimmNV.setColumns(10);

		JLabel lbLocgt = new JLabel("Lọc Theo Giới Tính :");
		lbLocgt.setFont(new Font("Arial", Font.BOLD, 12));

		  cbxgt = new JComboBox();
		cbxgt.setModel(new DefaultComboBoxModel(new String[] { "Nam ", "Nữ" }));
		cbxgt.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbLoccv = new JLabel("Lọc Theo Chức Vụ :");
		lbLoccv.setFont(new Font("Arial", Font.BOLD, 12));

		  cbxcv = new JComboBox();
		cbxcv.setModel(new DefaultComboBoxModel(new String[] { "Nhân Viên ", "Quản Lý" }));
		cbxcv.setFont(new Font("Arial", Font.PLAIN, 12));

		JScrollPane scrollPaneDangLV = new JScrollPane();
		GroupLayout gl_pnLamviec = new GroupLayout(pnLamviec);
		gl_pnLamviec.setHorizontalGroup(gl_pnLamviec.createParallelGroup(Alignment.LEADING).addGroup(gl_pnLamviec
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnLamviec.createParallelGroup(Alignment.LEADING).addGroup(gl_pnLamviec
						.createSequentialGroup()
						.addComponent(lbTimNV, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtTimmNV, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lbLocgt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(cbxgt, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lbLoccv, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(cbxcv, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneDangLV, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(12, Short.MAX_VALUE)));
		gl_pnLamviec.setVerticalGroup(gl_pnLamviec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLamviec.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnLamviec.createParallelGroup(Alignment.BASELINE).addComponent(lbTimNV)
								.addComponent(txtTimmNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbLocgt)
								.addComponent(cbxgt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbLoccv)
								.addComponent(cbxcv, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneDangLV, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));

		tableDangLV = new JTable();
//		tableDangLV.setModel(new DefaultTableModel(new Object[][] {},
//				new String[] { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD v\u00E0 T\u00EAn", "Ng\u00E0y Sinh",
//						"\u0110\u1ECBa Ch\u1EC9", "S\u0110T", "Gi\u1EDBi T\u00EDnh", "L\u01B0\u01A1ng", "Email",
//						"Ch\u1EE9c V\u1EE5" }));

		modelnv = new DefaultTableModel();
		modelnv.addColumn("Mã NV");
		modelnv.addColumn("Họ Tên ");
		modelnv.addColumn("Ngày Sinh");
		modelnv.addColumn("Địa Chỉ");
		modelnv.addColumn("CMND");
		modelnv.addColumn("so dien thoai");
		modelnv.addColumn("email");
		modelnv.addColumn("gioi tinh");

		modelnv.addColumn("chuc vu");

		nvdao = new NhanVienDAO();

		for (NhanVien nz : nvdao.getAllNhanVien()) {
			String gt = "";
			if (nz.isGioiTinh() == true) {
				gt = "Nam";
			} else {
				gt = "Nu";
			}

			String cv = "";
			if (nz.isChucVu() == true) {
				cv = "Nhan vien";
			} else {
				cv = "Quan ly";
			}
			Object[] obj = { nz.getMaNV(), nz.getTenNV(), nz.getNgaySinh(), nz.getDiaChi(), nz.getCMND(), nz.getSDT(),
					nz.getEmail(), gt, cv };

			modelnv.addRow(obj);
		}

		tableDangLV = new JTable(modelnv);

		scrollPaneDangLV.setViewportView(tableDangLV);
		pnLamviec.setLayout(gl_pnLamviec);

		JPanel pnNgunglamviec = new JPanel();
		pnNgunglamviec.setBackground(new Color(255, 255, 255));
		tabbedLamviec.addTab("Ngưng Làm Việc", null, pnNgunglamviec, null);

		JLabel lbTimkiem = new JLabel("Tìm Kiếm Nhân Viên:");
		lbTimkiem.setFont(new Font("Arial", Font.BOLD, 12));

		txtTimnv = new JTextField();
		txtTimnv.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTimnv.setColumns(10);

		JLabel lbLocGT = new JLabel("Lọc Theo Giới Tính :");
		lbLocGT.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox cbxGT = new JComboBox();
		cbxGT.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cbxGT.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbLocCV = new JLabel("Lọc Theo Chức Vụ :");
		lbLocCV.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox cbxGT_1 = new JComboBox();
		cbxGT_1.setModel(new DefaultComboBoxModel(new String[] { "Nhân Viên", "Quản Lý" }));
		cbxGT_1.setFont(new Font("Arial", Font.PLAIN, 12));

		JScrollPane scrollPaneDanglm = new JScrollPane();
		GroupLayout gl_pnNgunglamviec = new GroupLayout(pnNgunglamviec);
		gl_pnNgunglamviec.setHorizontalGroup(gl_pnNgunglamviec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNgunglamviec.createSequentialGroup().addContainerGap().addGroup(gl_pnNgunglamviec
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNgunglamviec.createSequentialGroup().addComponent(lbTimkiem)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTimnv, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE).addGap(18)
								.addComponent(lbLocGT).addGap(18)
								.addComponent(cbxGT, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lbLocCV, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(cbxGT_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneDanglm, GroupLayout.PREFERRED_SIZE, 879, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_pnNgunglamviec.setVerticalGroup(gl_pnNgunglamviec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNgunglamviec.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnNgunglamviec.createParallelGroup(Alignment.BASELINE).addComponent(lbTimkiem)
								.addComponent(txtTimnv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbxGT_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbLocCV)
								.addComponent(cbxGT, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbLocGT))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneDanglm, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));

		tableNgungLV = new JTable();
		tableNgungLV.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD v\u00E0 T\u00EAn", "Ng\u00E0y Sinh",
						"\u0110\u1ECBa Ch\u1EC9", "S\u0110T", "Gi\u1EDBi T\u00EDnh", "L\u01B0\u01A1ng ", "Email",
						"Ch\u1EE9c V\u1EE5" }));
		scrollPaneDanglm.setViewportView(tableNgungLV);
		pnNgunglamviec.setLayout(gl_pnNgunglamviec);

		JLabel lbMaNV = new JLabel("Mã Nhân VIên:");
		lbMaNV.setFont(new Font("Arial", Font.BOLD, 12));

		txtManhanvien = new JTextField();
		txtManhanvien.setColumns(10);

		JLabel lbTenNV = new JLabel("Tên Nhân Viên:");
		lbTenNV.setFont(new Font("Arial", Font.BOLD, 12));

		txtTen = new JTextField();
		txtTen.setColumns(10);

		JLabel lbMK = new JLabel("Mật Khẩu:");
		lbMK.setFont(new Font("Arial", Font.BOLD, 12));

		txtMatkhau = new JTextField();
		txtMatkhau.setColumns(10);

		JLabel lbVaitro = new JLabel("Vai Trò:");
		lbVaitro.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox cbxVaitro = new JComboBox();
		cbxVaitro.setModel(new DefaultComboBoxModel(new String[] { "Nhân Viên ", "Quản Lý" }));
		cbxVaitro.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbDiachi = new JLabel("Địa Chỉ:");
		lbDiachi.setFont(new Font("Arial", Font.BOLD, 12));

		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDiachi.setColumns(10);

		JLabel lbSĐT = new JLabel("Số Điện Thoại:");
		lbSĐT.setFont(new Font("Arial", Font.BOLD, 12));

		txtSĐT = new JTextField();
		txtSĐT.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSĐT.setColumns(10);

		JLabel lbNS = new JLabel("Ngày Sinh:");
		lbNS.setFont(new Font("Arial", Font.BOLD, 12));

		txtNgaysinh = new JTextField();
		txtNgaysinh.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNgaysinh.setColumns(10);

		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Arial", Font.BOLD, 12));

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);

		JLabel lbGT = new JLabel("Giới Tính:");
		lbGT.setFont(new Font("Arial", Font.BOLD, 12));

		JRadioButton rdbtnGioitinh = new JRadioButton("Nam");
		rdbtnGioitinh.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lbTrangthai = new JLabel("Trạng Thái:");
		lbTrangthai.setFont(new Font("Arial", Font.BOLD, 12));

		JRadioButton rdbtnTrangthai = new JRadioButton("Đang làm việc");
		rdbtnTrangthai.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnThem = new JButton("Thêm");

		btnThem.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/icon/add.png")));
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.setBackground(new Color(0, 128, 255));

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/icon/sua.png")));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = tableDangLV.getSelectedRow();

				if (row >= 0) {
					String manv = txtMaNV.getText().trim();
					String tennv = txtTen.getText().trim();
					String email = txtEmail.getText().trim();
					String ngaysinh = txtNgaysinh.getText().trim();
					String sdt = txtSĐT.getText().trim();
					String diachi = txtDiachi.getText().trim();

					boolean gt = true;
					if (rdbtnGioitinh.isSelected()) {
						gt = true;
					} else {
						gt = false;
					}

					int tt = 1;

					if (rdbtnTrangthai.isSelected()) {
						tt = 1;
					} else {
						tt = 0;
					}
					boolean cv = true;
					if (cbxcv.getSelectedItem().toString() == "Nhân Viên")
						cv = true;
					else
						cv = false;

					NhanVien nv = new NhanVien(tennv, Date.valueOf(ngaysinh), sdt, email, gt, diachi, cv, manv);
					nvdao.updateNhanVien(nv);
					JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");

					//
					modelnv.getDataVector().removeAllElements();
					for (NhanVien nz : nvdao.getAllNhanVien()) {
						String gt1 = "";
						if (nz.isGioiTinh() == true) {
							gt1 = "Nam";
						} else {
							gt1 = "Nu";
						}

						String cv1 = "";
						if (nz.isChucVu() == true) {
							cv1 = "Nhan vien";
						} else {
							cv1 = "Quan ly";
						}
						Object[] obj = { nz.getMaNV(), nz.getTenNV(), nz.getNgaySinh(), nz.getDiaChi(), nz.getCMND(),
								nz.getSDT(), nz.getEmail(), gt1, cv1 };

						modelnv.addRow(obj);
					}
					tableDangLV.setModel(modelnv);

					//
				}
			}
		});
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBackground(new Color(255, 255, 128));

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/icon/luulienket.png")));

		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuu.setBackground(new Color(255, 128, 64));

		JLabel lbCMND = new JLabel("CMND:");
		lbCMND.setHorizontalAlignment(SwingConstants.LEFT);
		lbCMND.setFont(new Font("Arial", Font.BOLD, 12));

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 12));
		txtCMND.setColumns(10);
		GroupLayout gl_pnThietlapTT = new GroupLayout(pnThietlapTT);
		gl_pnThietlapTT.setHorizontalGroup(gl_pnThietlapTT.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThietlapTT.createSequentialGroup().addGroup(gl_pnThietlapTT
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThietlapTT.createSequentialGroup().addContainerGap().addGroup(gl_pnThietlapTT
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pnThietlapTT.createSequentialGroup().addComponent(lbMaNV)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(txtManhanvien, GroupLayout.PREFERRED_SIZE, 299,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnThietlapTT.createSequentialGroup()
										.addComponent(lbTenNV, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtTen,
												GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnThietlapTT.createSequentialGroup()
										.addComponent(lbMK, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txtMatkhau, GroupLayout.PREFERRED_SIZE, 299,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnThietlapTT.createSequentialGroup()
										.addComponent(lbVaitro, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(cbxVaitro, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnThietlapTT.createSequentialGroup()
										.addComponent(lbDiachi, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, 299,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(63)
								.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnThietlapTT.createSequentialGroup()
												.addComponent(lbCMND, GroupLayout.PREFERRED_SIZE, 89,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtCMND,
														GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_pnThietlapTT.createSequentialGroup()
														.addComponent(lbNS, GroupLayout.PREFERRED_SIZE, 89,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtNgaysinh, GroupLayout.PREFERRED_SIZE, 299,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnThietlapTT.createSequentialGroup()
														.addComponent(lbSĐT, GroupLayout.PREFERRED_SIZE, 89,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtSĐT, GroupLayout.PREFERRED_SIZE, 299,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnThietlapTT.createSequentialGroup()
														.addComponent(lbEmail, GroupLayout.PREFERRED_SIZE, 89,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 299,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnThietlapTT.createSequentialGroup()
														.addComponent(lbGT, GroupLayout.PREFERRED_SIZE, 70,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(rdbtnGioitinh, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lbTrangthai, GroupLayout.PREFERRED_SIZE, 70,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(rdbtnTrangthai,
																GroupLayout.PREFERRED_SIZE, 111,
																GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_pnThietlapTT.createSequentialGroup().addGap(170).addComponent(btnThem).addGap(100)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(94)
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(27, Short.MAX_VALUE)));
		gl_pnThietlapTT.setVerticalGroup(gl_pnThietlapTT.createParallelGroup(Alignment.LEADING).addGroup(gl_pnThietlapTT
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE).addComponent(lbMaNV)
						.addComponent(lbSĐT)
						.addComponent(txtSĐT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(txtManhanvien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(14)
				.addGroup(
						gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE).addComponent(lbTenNV).addComponent(lbNS)
								.addComponent(txtNgaysinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(
						gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE).addComponent(lbMK).addComponent(lbEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMatkhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE).addComponent(lbVaitro)
						.addComponent(cbxVaitro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCMND).addComponent(txtCMND, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(10)
				.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE).addComponent(lbDiachi)
						.addComponent(txtDiachi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lbGT).addComponent(rdbtnTrangthai).addComponent(lbTrangthai)
						.addComponent(rdbtnGioitinh))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThietlapTT.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(21, Short.MAX_VALUE)));
		pnThietlapTT.setLayout(gl_pnThietlapTT);
		pnNhanvien.setLayout(gl_pnNhanvien);

		JPanel pnTaikhoan = new JPanel();
		pnTaikhoan.setBackground(new Color(255, 255, 255));
		tabbedNVTK.addTab("Tài Khoản", null, pnTaikhoan, null);

		JPanel pnTk = new JPanel();
		pnTk.setBackground(new Color(255, 255, 255));
		pnTk.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "T\u00E0i Kho\u1EA3n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel pnDanhsachTK = new JPanel();
		pnDanhsachTK.setBackground(new Color(255, 255, 255));
		pnDanhsachTK.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"Danh S\u00E1ch T\u00E0i Kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnTaikhoan = new GroupLayout(pnTaikhoan);
		gl_pnTaikhoan.setHorizontalGroup(gl_pnTaikhoan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTaikhoan.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnTaikhoan.createParallelGroup(Alignment.LEADING)
								.addComponent(pnDanhsachTK, GroupLayout.PREFERRED_SIZE, 918, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnTk, GroupLayout.PREFERRED_SIZE, 918, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnTaikhoan.setVerticalGroup(gl_pnTaikhoan.createParallelGroup(Alignment.LEADING).addGroup(gl_pnTaikhoan
				.createSequentialGroup().addComponent(pnTk, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(pnDanhsachTK, GroupLayout.PREFERRED_SIZE, 435, Short.MAX_VALUE).addContainerGap()));

		JScrollPane scrollPaneDS = new JScrollPane();
		GroupLayout gl_pnDanhsachTK = new GroupLayout(pnDanhsachTK);
		gl_pnDanhsachTK.setHorizontalGroup(gl_pnDanhsachTK.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnDanhsachTK.createSequentialGroup()
						.addComponent(scrollPaneDS, GroupLayout.PREFERRED_SIZE, 903, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnDanhsachTK.setVerticalGroup(gl_pnDanhsachTK.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnDanhsachTK.createSequentialGroup()
						.addComponent(scrollPaneDS, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(25, Short.MAX_VALUE)));

		
		
		modeltk = new DefaultTableModel();
		modeltk.addColumn("Tên Tài Khoản");
		modeltk.addColumn("matKhau ");
		modeltk.addColumn("maNV");
		modeltk.addColumn("loaiTaiKhoan");
	 
		
		tableDSTK = new JTable(modeltk);
		
		nvdao = new NhanVienDAO();

		for (TaiKhoan nz : nvdao.getAlltaikhoan()) {
			
			int zz=1;
			if(nz.isLoaiTaiKhoan()==true) {
				zz=1;
			}
			Object[] obj = {  nz.getTenTaiKhoan(),nz.getMatKhau(),nz.getNhanVien().getMaNV(),zz};

			modeltk.addRow(obj);
		}

		tableDSTK = new JTable(modeltk);
		
		//load bảng tài khoản 
		
		tableDSTK.setFont(new Font("Arial", Font.PLAIN, 12));
//		tableDSTK.setModel(new DefaultTableModel(new Object[][] {
//
//		}, new String[] { "T\u00EAn T\u00E0i Kho\u1EA3n", "M\u1EADt Kh\u1EA9u", "H\u1ECD v\u00E0 T\u00EAn",
//				"Ch\u1EE9c V\u1EE5" }));
		scrollPaneDS.setViewportView(tableDSTK);
		pnDanhsachTK.setLayout(gl_pnDanhsachTK);

		JLabel lblTimTK = new JLabel("Tìm kiếm tài khoản:");
		lblTimTK.setFont(new Font("Arial", Font.BOLD, 12));

		txtTimNV = new JTextField();
		txtTimNV.setColumns(10);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Arial", Font.BOLD, 12));

		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setFont(new Font("Arial", Font.BOLD, 12));

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);

		JLabel lblTenTK = new JLabel("Tên Tài Khoản:");
		lblTenTK.setFont(new Font("Arial", Font.BOLD, 12));

		txtTenTK = new JTextField();
		txtTenTK.setColumns(10);

		JLabel lblMK = new JLabel("Mật Khẩu:");
		lblMK.setFont(new Font("Arial", Font.BOLD, 12));

		txtMK = new JTextField();
		txtMK.setColumns(10);

		JButton btnTim = new JButton("Tìm");
				btnTim.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/icon/search.png")));
		btnTim.setFont(new Font("Arial", Font.BOLD, 12));
		btnTim.setBackground(Color.LIGHT_GRAY);

		JButton btnDoiMK = new JButton("Đổi Mật Khẩu");
		btnDoiMK.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/icon/refesh.png")));
		btnDoiMK.setFont(new Font("Arial", Font.BOLD, 12));
		btnDoiMK.setBackground(new Color(0, 255, 128));
		GroupLayout gl_pnTk = new GroupLayout(pnTk);
		gl_pnTk.setHorizontalGroup(
			gl_pnTk.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTk.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnTk.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnTk.createSequentialGroup()
							.addGroup(gl_pnTk.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaNV, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenNV, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenNV, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
							.addGap(67)
							.addGroup(gl_pnTk.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMK, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMK, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenTK, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenTK, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnTk.createSequentialGroup()
							.addComponent(lblTimTK, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTimNV, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDoiMK, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_pnTk.setVerticalGroup(
			gl_pnTk.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTk.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnTk.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimTK)
						.addComponent(btnTim)
						.addComponent(btnDoiMK, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnTk.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaNV)
						.addComponent(lblTenTK))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnTk.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenTK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnTk.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTenNV)
						.addComponent(lblMK))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnTk.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		pnTk.setLayout(gl_pnTk);
		pnTaikhoan.setLayout(gl_pnTaikhoan);
		// them su kien cac nut
		btnLuu.setEnabled(false);
//		su kien cua may cai nut
		
		//Nút tìm
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String zz11=txtTimNV.getText().toString();
				modeltk.getDataVector().removeAllElements();
				for (TaiKhoan nz : nvdao.timtk(zz11)) {
					int zz=1;
					if(nz.isLoaiTaiKhoan()==true) {
						zz=1;
					}
					Object[] obj = {  nz.getTenTaiKhoan(),nz.getMatKhau(),nz.getNhanVien().getMaNV(),zz};

					modeltk.addRow(obj);
					JOptionPane.showMessageDialog(null, "tim thay tai khoan");
				}
				tableDSTK.setModel(modeltk);
				
				
			}
		});
		
		
		txtTimmNV.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimkiemSP();
			}
//			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimkiemSP();
			}
//			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimkiemSP();
			}
//			
			
			
			
		}); 
		
		//Nút thêm
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(false);
				btnLuu.setEnabled(true);
			}
		});

		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validData()) {

					String manv = txtMaNV.getText().trim();
					String tennv = txtTen.getText().trim();
					String email = txtEmail.getText().trim();
					String ngaysinh = txtNgaysinh.getText().trim();
					String sdt = txtSĐT.getText().trim();
					String diachi = txtDiachi.getText().trim();
					String cmnd = txtCMND.getText().trim();

					boolean gt = true;
					if (rdbtnGioitinh.isSelected()) {
						gt = true;
					} else {
						gt = false;
					}

					int tt = 1;

					if (rdbtnTrangthai.isSelected()) {
						tt = 1;
					} else {
						tt = 0;
					}
					boolean cv = true;
					if (cbxcv.getSelectedItem().toString() == "Nhân Viên")
						cv = true;
					else
						cv = false;

					NhanVien nv = new NhanVien(manv, tennv, Date.valueOf(ngaysinh), sdt, email, cmnd, gt,
							diachi, cv, tt);

					nvdao.addNhanVien(nv);
					JOptionPane.showMessageDialog(null, "Thêm thành công 1 nhân viên.");
				}
			}
		});

		tableDangLV.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableDangLV.getSelectedRow();
				txtManhanvien.setText(modelnv.getValueAt(row, 0).toString());
				txtTen.setText(modelnv.getValueAt(row, 1).toString());
				txtNgaysinh.setText(modelnv.getValueAt(row, 2).toString());
				txtDiachi.setText(modelnv.getValueAt(row, 3).toString());
				txtCMND.setText(modelnv.getValueAt(row, 4).toString());
				txtSĐT.setText(modelnv.getValueAt(row, 5).toString());
				txtEmail.setText(modelnv.getValueAt(row, 6).toString());

				if (modelnv.getValueAt(row, 7).toString() == "Nam") {
					rdbtnGioitinh.setSelected(true);
				}
				if (modelnv.getValueAt(row, 8).toString() == "Nhân Viên") {
					cbxVaitro.setSelectedItem("Nhân Viên");
				} else {
					cbxVaitro.setSelectedItem("Quản Lý");
				}

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

			}
		});

		tableDSTK.addMouseListener(this);
		tableNgungLV.addMouseListener(this);
		tableDangLV.addMouseListener(this);
	}
	
	private void updateTableTimkiemSP () {
		String masptendt = txtTimmNV.getText();
		String gt=cbxgt.getSelectedItem().toString();
		boolean gtzz=true;
		if(gt=="Nam") {
			gtzz=true;
		}
		else {
			gtzz=false;
		}
		
		String cv=cbxcv.getSelectedItem().toString();
		boolean cvzz=true;
		if(gt=="Nhân Viên") {
			cvzz=true;
		}
		else {
			cvzz=false;
		}
//		 
		
		 
 
		
		
		modelnv.getDataVector().removeAllElements();
		for (NhanVien nz : nvdao.timnv(masptendt,gtzz,cvzz)) {
			String gt1 = "";
			if (nz.isGioiTinh() == true) {
				gt1 = "Nam";
			} else {
				gt1 = "Nu";
			}

			String cv1 = "";
			if (nz.isChucVu() == true) {
				cv1 = "Nhan vien";
			} else {
				cv1 = "Quan ly";
			}
			Object[] obj = { nz.getMaNV(), nz.getTenNV(), nz.getNgaySinh(), nz.getDiaChi(), nz.getCMND(),
					nz.getSDT(), nz.getEmail(), gt1, cv1 };

			modelnv.addRow(obj);
		}
		tableDangLV.setModel(modelnv);
		}

	// su kien các nút
	private void xoaRongTextField() {
		// TODO Auto-generated method stub
		txtDiachi.setText("");
		txtEmail.setText("");
		txtManhanvien.setText("");
		txtMaNV.setText("");
		txtMatkhau.setText("");
		txtMK.setText("");
		txtNgaysinh.setText("");
		txtSĐT.setText("");
		txtTen.setText("");
		txtTenNV.setText("");
		txtTimmNV.setText("");
		txtTenTK.setText("");
		txtTimnv.setText("");
		txtTimNV.setText("");
	}

	private void showMessage(String string, JTextField txtMaNV2) {
		// TODO Auto-generated method stub

	}

	private void updateTableData() {
		// TODO Auto-generated method stub
		NhanVienDAO nv = new NhanVienDAO();
		ArrayList<NhanVien> list = nv.getAllNhanVien();
		for (NhanVien nz : list) {
			Object[] obj = { nz.getMaNV() };

			modelnv.addRow(obj);
		}

	}

	private boolean validData() {
		String maNv = txtManhanvien.getText().trim();
		String tenNv = txtTen.getText().trim();
		String matkhau = txtMatkhau.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String email = txtEmail.getText().trim();
		String ngaysinh = txtNgaysinh.getText().trim();
		String sdt = txtSĐT.getText().trim();
		String cmnd = txtCMND.getText().trim();

		if (maNv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền tên nhân viên.");
			return false;
		}

		if (tenNv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền mã nhân viên.");
			return false;
		}

		if (matkhau.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu.");
			return false;
		}

		if (diachi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền địa chỉ.");
			return false;
		}

		if (sdt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền số điện thoại.");
			return false;
		}

		if (ngaysinh.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền ngày sinh.");
			return false;
		}

		if (email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền email.");
			return false;
		}
		if (cmnd.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền CMND.");
			return false;
		}
		return true;
	}

//	private NhanVien NhanVienFromTextfields() {
//		String manv = txtMaNV.getText().trim();
//		String tennv = txtTenNV.getText().trim();
//		String email = txtEmail.getText().trim();
//		String ngaysinh = txtNgaysinh.getText().trim();
//		String sdt = txtSĐT.getText().trim();
//		String diachi = txtDiachi.getText().trim();
//		return new NhanVien();
//	}

	private void clearTextfields() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtDiachi.setText("");
		txtEmail.setText("");
		txtNgaysinh.setText("");
		txtSĐT.setText("");
		txtMaNV.setEditable(true);
		txtMaNV.requestFocus();
	}
// Bảng tài khoản
	private boolean validData2() {
		String timnv = txtTimNV.getText().trim();
		String manv= txtMaNV.getText().trim();
		String taikhoan = txtTenTK.getText().trim();
		String tennv = txtTenNV.getText().trim();
		String datmk= txtMK.getText().trim();
		
		if (timnv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền nhân viên muốn tìm.");
			return false;
		}
		if (manv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền mã nhân viên.");
			return false;
		}
		if (taikhoan.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền tên tài khoản.");
			return false;
		}
		if (tennv.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền tên nhân viên.");
			return false;
		}
		if (datmk.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu.");
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

	public void actionPerformed(ActionEvent e) {

	}
}
