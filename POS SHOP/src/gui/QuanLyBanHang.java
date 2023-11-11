package gui;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

import dao.SanPhamDAO;
import entity.HoaDon;
import entity.SanPham;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class QuanLyBanHang extends JPanel implements ActionListener, MouseListener{
	private JTextField txtTienKhachDua;
	private JTable tblHoaDonCho;
	private JTable tblGioHang;
	private JTextField txtSoLuong;
	private JTable tblDSSanPham;
	private JTextField txtTimKiemSP;
	public JButton btnTraHang = new JButton("Trả Hàng");
	private SanPhamDAO sanPhamDAO;
	private JButton btnThemVaoGio;
	private String masp;
	private int soluong;
	private JButton btnTaoHD;
	private JButton btnTim;
	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public QuanLyBanHang() {
		UiBanHang();
		tblDanhSachSanPham();
	}
    private void clearTableDSSP() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSSanPham.getModel();
        dtm.setRowCount(0);
    }
	private void tblDanhSachSanPham() {
		sanPhamDAO = new SanPhamDAO();
		clearTableDSSP();
		DefaultTableModel dtm = (DefaultTableModel) tblDSSanPham.getModel();
		List<SanPham> listsp = sanPhamDAO.doTuBang();
		for(SanPham sp : listsp) {
			Object[] rowdata = {sp.getMaSP(),sp.getTenSP(),sp.getPl().getPhanLoai(),sp.getKichThuoc(),sp.getGiaBan(),sp.getSoLuong(),sp.getMauSac().getMauSac(),sp.getKichThuoc().getKichThuoc()};
			dtm.addRow(rowdata);
		}
	}
	private void UiBanHang() {
		setPreferredSize(new Dimension(934, 701));
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
		
		JPanel pnlHoaDon = new JPanel();
		pnlHoaDon.setBackground(new Color(255, 255, 255));
		pnlHoaDon.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "\u0110\u01A1n H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel pnlHoaDonCho = new JPanel();
		pnlHoaDonCho.setBackground(new Color(255, 255, 255));
		pnlHoaDonCho.setBorder(new CompoundBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "H\u00F3a \u0110\u01A1n Ch\u1EDD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null), null));
		
		JPanel pnlCamera = new JPanel();
		pnlCamera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel pnlGioHang = new JPanel();
		pnlGioHang.setBackground(new Color(255, 255, 255));
		pnlGioHang.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Gi\u1ECF H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JPanel pnlDanhSachSanPham = new JPanel();
		pnlDanhSachSanPham.setBackground(new Color(255, 255, 255));
		pnlDanhSachSanPham.setBorder(new CompoundBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null), null));

		btnTraHang.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/doitra2.png")));
		btnTraHang.setForeground(new Color(255, 255, 255));
		btnTraHang.setBackground(new Color(50, 205, 50));
		btnTraHang.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlGioHang, 0, 0, Short.MAX_VALUE)
						.addComponent(pnlDanhSachSanPham, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlHoaDonCho, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pnlCamera, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlHoaDon, GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE)
						.addComponent(btnTraHang))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(0)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(pnlCamera, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addComponent(pnlHoaDonCho, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pnlGioHang, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlDanhSachSanPham, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(btnTraHang)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlHoaDon, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiêm sản phẩm : ");
		
		txtTimKiemSP = new JTextField();
		txtTimKiemSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTimKiemSP.setColumns(10);
		
		btnThemVaoGio = new JButton("Thêm Sản Phẩm");
		btnThemVaoGio.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/add.png")));
		btnThemVaoGio.setForeground(new Color(255, 255, 255));
		btnThemVaoGio.setFont(new Font("Arial", Font.BOLD, 11));
		btnThemVaoGio.setBackground(new Color(65, 105, 225));
		btnThemVaoGio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_pnlDanhSachSanPham = new GroupLayout(pnlDanhSachSanPham);
		gl_pnlDanhSachSanPham.setHorizontalGroup(
			gl_pnlDanhSachSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachSanPham.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimKiemSP, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnThemVaoGio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(88))
				.addGroup(gl_pnlDanhSachSanPham.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 572, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_pnlDanhSachSanPham.setVerticalGroup(
			gl_pnlDanhSachSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachSanPham.createSequentialGroup()
					.addGroup(gl_pnlDanhSachSanPham.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtTimKiemSP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemVaoGio))
					.addGap(11)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
		);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "name_87070151630200");
		
		tblDSSanPham = new JTable();
		tblDSSanPham.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Ph\u00E2n lo\u1EA1i", "K\u00EDch th\u01B0\u1EDBc", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "M\u00E0u s\u1EAFc", "k\u00EDch th\u01B0\u1EDBc"
			}
		));
		tblDSSanPham.getColumnModel().getColumn(0).setPreferredWidth(87);
		tblDSSanPham.getColumnModel().getColumn(1).setPreferredWidth(116);
		tblDSSanPham.getColumnModel().getColumn(2).setPreferredWidth(89);
		scrollPane_1.setViewportView(tblDSSanPham);
		pnlDanhSachSanPham.setLayout(gl_pnlDanhSachSanPham);
		
		JPanel panel = new JPanel();
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số Lượng      ");
		
		JButton btnOk = new JButton("OK");
		btnOk.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(144, 238, 144));
		btnOk.setFont(new Font("Arial", Font.BOLD, 9));
		
		JButton btnXoaSanPham = new JButton("Xóa sản phẩm");
		btnXoaSanPham.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnXoaSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaSanPham.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/xoa1sp.png")));
		btnXoaSanPham.setForeground(new Color(255, 255, 255));
		btnXoaSanPham.setBackground(new Color(210, 105, 30));
		btnXoaSanPham.setFont(new Font("Arial", Font.BOLD, 10));
		
		JButton btnXoaTatCaSP = new JButton("Xóa tất cả");
		btnXoaTatCaSP.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnXoaTatCaSP.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/xoaall.png")));
		btnXoaTatCaSP.setForeground(new Color(255, 255, 255));
		btnXoaTatCaSP.setBackground(new Color(255, 0, 0));
		btnXoaTatCaSP.setFont(new Font("Arial", Font.BOLD, 10));
		GroupLayout gl_pnlGioHang = new GroupLayout(pnlGioHang);
		gl_pnlGioHang.setHorizontalGroup(
			gl_pnlGioHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlGioHang.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnXoaSanPham, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(btnXoaTatCaSP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
		);
		gl_pnlGioHang.setVerticalGroup(
			gl_pnlGioHang.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlGioHang.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlGioHang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlGioHang.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlGioHang.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnXoaSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnXoaTatCaSP, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_GioHang = new JScrollPane();
		panel.add(scrollPane_GioHang, "name_86272947197200");
		
		tblGioHang = new JTable();
		tblGioHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "K\u00EDch Th\u01B0\u1EDBc", "Khuy\u1EBFn m\u00E3i", "\u0110\u01A1n Gi\u00E1", "s\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
			}
		));
		tblGioHang.getColumnModel().getColumn(1).setPreferredWidth(95);
		tblGioHang.getColumnModel().getColumn(2).setPreferredWidth(63);
		tblGioHang.getColumnModel().getColumn(3).setPreferredWidth(77);
		tblGioHang.getColumnModel().getColumn(6).setPreferredWidth(61);
		scrollPane_GioHang.setViewportView(tblGioHang);
		pnlGioHang.setLayout(gl_pnlGioHang);
		pnlHoaDonCho.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlHoaDonCho.add(scrollPane, "name_85655507217700");
		
		tblHoaDonCho = new JTable();
		tblHoaDonCho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "Ng\u00E0y T\u1EA1o", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Kh\u00E1ch H\u00E0ng"
			}
		));
		tblHoaDonCho.getColumnModel().getColumn(2).setPreferredWidth(99);
		tblHoaDonCho.getColumnModel().getColumn(3).setPreferredWidth(119);
		scrollPane.setViewportView(tblHoaDonCho);
		
		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBackground(new Color(255, 255, 255));
		pnlKhachHang.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		btnTaoHD = new JButton("Tạo HĐ");
		btnTaoHD.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnTaoHD.setFont(new Font("Arial", Font.BOLD, 11));
		btnTaoHD.setForeground(new Color(255, 255, 255));
		btnTaoHD.setBackground(new Color(65, 105, 225));
		btnTaoHD.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/save.png")));
		btnTaoHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn :");
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTngTin = new JLabel("Tổng tiền : ");
		lblTngTin.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblGimGi = new JLabel("Giảm giá : ");
		lblGimGi.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblThuVat = new JLabel("Thuế VAT : ");
		lblThuVat.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblT = new JLabel("Thanh Toán : ");
		lblT.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTinKhcha = new JLabel("Tiền khách đưa : ");
		lblTinKhcha.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTinKhcha_1 = new JLabel("Tiền thừa : ");
		lblTinKhcha_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTinKhcha_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setColumns(10);
		
		JLabel lblMaHDpush = new JLabel("0");
		
		JLabel lblTongTienpush = new JLabel("0");
		
		JLabel lblGiamGiapush = new JLabel("0");
		
		JLabel lblThuepush = new JLabel("0");
		
		JLabel lblThanhToanpush = new JLabel("0");
		
		JLabel lblNewLabel_1_4 = new JLabel("0");
		
		JLabel lblTien = new JLabel("VNĐ");
		lblTien.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTien_1 = new JLabel("VNĐ");
		lblTien_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTien_2 = new JLabel("VNĐ");
		lblTien_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTien_3 = new JLabel("VNĐ");
		lblTien_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTien_4 = new JLabel("VNĐ");
		lblTien_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTien_5 = new JLabel("VNĐ");
		lblTien_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTinKhcha_1_1 = new JLabel("Tiền thừa : ");
		lblTinKhcha_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTinKhcha_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel pnlGhiChu = new JPanel();
		pnlGhiChu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnHuyHoaDon = new JButton("Hủy Hóa Đơn");
		btnHuyHoaDon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnHuyHoaDon.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/stop2.png")));
		btnHuyHoaDon.setForeground(new Color(255, 255, 255));
		btnHuyHoaDon.setBackground(new Color(255, 0, 0));
		btnHuyHoaDon.setFont(new Font("Arial", Font.BOLD, 12));
		btnHuyHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("Thanh Toán");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/thanhtoan.png")));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnHuyHoaDon_1 = new JButton("Làm mới ");
		btnHuyHoaDon_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnHuyHoaDon_1.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/refesh.png")));
		btnHuyHoaDon_1.setBackground(new Color(152, 251, 152));
		btnHuyHoaDon_1.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout gl_pnlHoaDon = new GroupLayout(pnlHoaDon);
		gl_pnlHoaDon.setHorizontalGroup(
			gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHoaDon.createSequentialGroup()
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlHoaDon.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlKhachHang, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnlHoaDon.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_pnlHoaDon.createSequentialGroup()
											.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTinKhcha)
														.addComponent(lblTinKhcha_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
														.addComponent(txtTienKhachDua, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_pnlHoaDon.createSequentialGroup()
															.addComponent(lblNewLabel_1_4)
															.addGap(151)
															.addComponent(lblTien_5))))
												.addComponent(lblTinKhcha_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
											.addGap(18))
										.addGroup(gl_pnlHoaDon.createSequentialGroup()
											.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMaHD, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTngTin, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblGimGi, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblThuVat, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblT, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addComponent(lblTongTienpush, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
													.addComponent(lblTien, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addComponent(lblThuepush, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblTien_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addComponent(lblGiamGiapush, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblTien_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addComponent(lblMaHDpush, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
													.addGap(18)
													.addComponent(btnTaoHD, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
													.addGap(18))
												.addGroup(gl_pnlHoaDon.createSequentialGroup()
													.addComponent(lblThanhToanpush, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTien_4, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
														.addComponent(lblTien_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))))
									.addGap(19))))
						.addGroup(gl_pnlHoaDon.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlGhiChu, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnlHoaDon.createSequentialGroup()
									.addComponent(btnHuyHoaDon, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnHuyHoaDon_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_pnlHoaDon.setVerticalGroup(
			gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHoaDon.createSequentialGroup()
					.addComponent(pnlKhachHang, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMaHD)
							.addComponent(lblMaHDpush))
						.addComponent(btnTaoHD, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTngTin)
						.addComponent(lblTongTienpush)
						.addComponent(lblTien))
					.addGap(18)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGimGi)
						.addComponent(lblGiamGiapush)
						.addComponent(lblTien_1))
					.addGap(18)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblThuVat)
						.addComponent(lblThuepush)
						.addComponent(lblTien_2))
					.addGap(18)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblT)
						.addComponent(lblThanhToanpush)
						.addComponent(lblTien_3))
					.addGap(18)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTinKhcha)
						.addComponent(txtTienKhachDua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTien_4))
					.addGap(28)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTinKhcha_1)
						.addComponent(lblNewLabel_1_4)
						.addComponent(lblTien_5))
					.addGap(31)
					.addComponent(lblTinKhcha_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlGhiChu, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_pnlHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHuyHoaDon, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHuyHoaDon_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		GroupLayout gl_pnlGhiChu = new GroupLayout(pnlGhiChu);
		gl_pnlGhiChu.setHorizontalGroup(
			gl_pnlGhiChu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 279, Short.MAX_VALUE)
		);
		gl_pnlGhiChu.setVerticalGroup(
			gl_pnlGhiChu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 91, Short.MAX_VALUE)
		);
		pnlGhiChu.setLayout(gl_pnlGhiChu);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng : ");
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTenKH = new JLabel("Tên khách hàng : ");
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblmakh = new JLabel(" ");
		lblmakh.setForeground(new Color(255, 0, 0));
		
		JLabel lbltenkh = new JLabel(" ");
		lbltenkh.setForeground(Color.RED);
		
		btnTim = new JButton("Tìm");
		
		//===================================
		///them jframe để tìm khách hàng
		btnTim.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				UiTimKhachHang timKhachHangUI = new UiTimKhachHang();
		        timKhachHangUI.setKhachHangSelectedListener(new UiTimKhachHang.KhachHangSelectedListener() {
		            @Override
		            public void onKhachHangSelected(String makh, String tenkh) {
		                lblmakh.setText(makh);
		                lbltenkh.setText(tenkh);
		            }
		        });
		        timKhachHangUI.setVisible(true);
		        disable();
			}
		});
		//===================================
		//===================================
		btnTim.setBackground(new Color(192, 192, 192));
		btnTim.setIcon(new ImageIcon(QuanLyBanHang.class.getResource("/icon/search.png")));
		btnTim.setFont(new Font("Arial", Font.BOLD, 11));
		GroupLayout gl_pnlKhachHang = new GroupLayout(pnlKhachHang);
		gl_pnlKhachHang.setHorizontalGroup(
			gl_pnlKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlKhachHang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlKhachHang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlKhachHang.createSequentialGroup()
							.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbltenkh, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlKhachHang.createSequentialGroup()
							.addComponent(lblMaKH)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblmakh, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(50)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlKhachHang.setVerticalGroup(
			gl_pnlKhachHang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlKhachHang.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlKhachHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaKH)
						.addComponent(lblmakh)
						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlKhachHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTenKH)
						.addComponent(lbltenkh))
					.addContainerGap())
		);
		pnlKhachHang.setLayout(gl_pnlKhachHang);
		pnlHoaDon.setLayout(gl_pnlHoaDon);
		setLayout(groupLayout);
		//su kien hoa don cho va san pham
		///su kien tim kiếm liên tục (auto find load table)
		txtTimKiemSP.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimKiemSP();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimKiemSP();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTableTimKiemSP();
			}
		});
		
		
		//them sư kiện
		btnThemVaoGio.addActionListener(this);
		tblDSSanPham.addMouseListener(this);
		btnTaoHD.addActionListener(this);
		
	}
	private void updateTableGioHang(){
		SanPham sp = sanPhamDAO.getSanPhanTheoId(masp);
		DefaultTableModel dtm = (DefaultTableModel) tblGioHang.getModel();
		soluong = 1;
		double khuyenmai = 0.0;
		if(sp.getKhuyenMai() == null) {
			khuyenmai = 0.0;
		}else {
			khuyenmai = sp.getKhuyenMai().getPhanTramKhuyenMai();
		}
		Object[] rowdata = {sp.getMaSP(),sp.getTenSP(),sp.getKichThuoc().getKichThuoc(),khuyenmai,sp.getGiaBan(),soluong,sp.getGiaBan()*soluong};
		dtm.addRow(rowdata);
	}
	private void updateTableHoaDonCho() {
		HoaDon hd = new HoaDon();
		DefaultTableModel dtm = (DefaultTableModel) tblHoaDonCho.getModel();
		LocalDate ngayhientai = LocalDate.now();
		Object[] rowdata = {hd.getAutoID(),ngayhientai.toString(),"Trần Chí Bảo","Trần Văn Bình"};
		dtm.addRow(rowdata);
	}
	private void updateTableTimKiemSP(){
		String masp = txtTimKiemSP.getText();
		sanPhamDAO = new SanPhamDAO();
		clearTableDSSP();
		DefaultTableModel dtm = (DefaultTableModel) tblDSSanPham.getModel();
		List<SanPham> listsp = sanPhamDAO.getDSSPTheoMaSP(masp);
		for(SanPham sp : listsp) {
			Object[] rowdata = {};
			dtm.addRow(rowdata);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThemVaoGio)) {
			updateTableGioHang();
		}
		if(o.equals(btnTaoHD)) {
			updateTableHoaDonCho();
		}
		if(o.equals(btnTim)) {
			
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblDSSanPham.getSelectedRow();
		masp = tblDSSanPham.getValueAt(row, 0).toString();
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
	
}
