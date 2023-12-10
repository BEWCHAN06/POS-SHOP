package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import component.LoadingDialog;
import entity.KhuyenMai;
import main.Login;

public class uiMain {

	public JFrame frame;
	public JPanel mainPanel = new JPanel();
	private JPanel btnSanPham;
	private JPanel btnHoaDon;
	private JPanel btnKhuyenMai;
	private JPanel btnNhanVien;
	private JPanel btnKhachHang;
	private JPanel btnThongKe;
	private JPanel btnBanHang;
	private KhuyenMai km = new KhuyenMai();
	private BanHang qlbh;
	private uiSanPham qlsp;
	private QuanLyHoaDon qlhd;
	private QuanLyKhuyenMai qlkm;
	private QuanLyNhanVien qlnv;
	private QuanLyKhachHang qlkh;
	private QuanLyThongKe qltk;
	private TabThongKeDoanhThu doanhThu;
	private TabThongKeSanPham keSanPham;
	private LoadingDialog dialog;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					uiMain window = new uiMain();
//					window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public uiMain() {
		dialog = new LoadingDialog();

		initialize();
		km.xoaKhuyenMaiKhiHetHan();
		qlbh = new BanHang();
		qlbh.setVisible(true);
		qlsp = new uiSanPham();
		qlsp.setVisible(true);
		qlhd = new QuanLyHoaDon();
		qlhd.setVisible(true);
		qlkm = new QuanLyKhuyenMai();
		qlkm.setVisible(true);
		qlnv = new QuanLyNhanVien();
		qlkm.setVisible(true);
		qlkh = new QuanLyKhachHang();
		qlkm.setVisible(true);
		qltk = new QuanLyThongKe();
//		qltk.setVisible(true);
//		
//		doanhThu = new TabThongKeDoanhThu();
//		doanhThu.setVisible(true);
//		keSanPham = new TabThongKeSanPham();
//		keSanPham.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));

		JPanel pnlMenu = new JPanel();
		pnlMenu.setPreferredSize(new Dimension(947, 703));

		pnlMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlMenu.setBackground(new Color(152, 251, 152));
		
		JPanel mainPanel = new JPanel();
		QuanLyBanHang qlbh_1 = new QuanLyBanHang();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE).addContainerGap())
				.addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE));
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(uiMain.class.getResource("/icon/mainscreen.png")));
		mainPanel.add(lblNewLabel_3, "name_2182919992199");

		JPanel pnlListMenu = new JPanel();
		pnlListMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnlListMenu.setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(152, 251, 152));
		GroupLayout gl_pnlMenu = new GroupLayout(pnlMenu);
		gl_pnlMenu.setHorizontalGroup(gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
						.addGroup(gl_pnlMenu.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_pnlMenu.createSequentialGroup().addContainerGap().addComponent(pnlListMenu,
												GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
								.addGroup(gl_pnlMenu.createSequentialGroup().addGap(5).addComponent(panel,
										GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_pnlMenu.setVerticalGroup(gl_pnlMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlMenu.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(pnlListMenu, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(uiMain.class.getResource("/icon/information-employee.png")));

		JLabel lblNewLabel_1 = new JLabel("Trần Chí Bảo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel lblNewLabel_2 = new JLabel("Chức Vụ : Quản Lý");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(6).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2))
				.addContainerGap(29, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2).addGap(25))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addComponent(lblNewLabel)
						.addContainerGap(22, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		mainPanel.removeAll();
		mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
		/// chuyển giao diện
		btnBanHang = new JPanel();
		btnBanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlbh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(34, 139, 34));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnBanHang.setBackground(new Color(144, 238, 144));
//		btnBanHang.setBackground(new Color(34, 139, 34));
		// Phím tắt F1
		btnBanHang.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
		btnBanHang.getActionMap().put("F1", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				BanHang qlbh = new BanHang();
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlbh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(34, 139, 34));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnSanPham = new JPanel();
		btnSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlsp, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(34, 139, 34));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnSanPham.setBackground(new Color(144, 238, 144));
		// Phím tắt F2
		btnSanPham.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
		btnSanPham.getActionMap().put("F2", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlsp, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(34, 139, 34));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});

		JLabel lblSanPham = new JLabel("Sản Phẩm");
		lblSanPham.setForeground(Color.WHITE);
		lblSanPham.setFont(new Font("Arial", Font.BOLD, 22));
		lblSanPham.setBackground(Color.WHITE);

		JLabel iconSanPham = new JLabel("");
		iconSanPham.setIcon(new ImageIcon(uiMain.class.getResource("/icon/box.png")));
		GroupLayout gl_btnSanPham = new GroupLayout(btnSanPham);
		gl_btnSanPham.setHorizontalGroup(gl_btnSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnSanPham.createSequentialGroup().addContainerGap()
						.addComponent(iconSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblSanPham).addGap(20)));
		gl_btnSanPham.setVerticalGroup(gl_btnSanPham.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnSanPham.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_btnSanPham.createParallelGroup(Alignment.TRAILING).addComponent(lblSanPham)
								.addComponent(iconSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		btnSanPham.setLayout(gl_btnSanPham);

		btnHoaDon = new JPanel();
		btnHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlhd, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(34, 139, 34));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnHoaDon.setBackground(new Color(144, 238, 144));
		// Phím tắt F3
		btnHoaDon.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3");
		btnHoaDon.getActionMap().put("F3", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlhd, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(34, 139, 34));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		JLabel iconSanPham_1 = new JLabel("");
		iconSanPham_1.setIcon(new ImageIcon(uiMain.class.getResource("/icon/bill.png")));

		JLabel lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("Arial", Font.BOLD, 22));
		lblHoaDon.setBackground(Color.WHITE);
		GroupLayout gl_btnHoaDon = new GroupLayout(btnHoaDon);
		gl_btnHoaDon
				.setHorizontalGroup(gl_btnHoaDon.createParallelGroup(Alignment.LEADING).addGap(0, 181, Short.MAX_VALUE)
						.addGroup(gl_btnHoaDon.createSequentialGroup().addContainerGap()
								.addComponent(iconSanPham_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblHoaDon).addGap(20)));
		gl_btnHoaDon
				.setVerticalGroup(gl_btnHoaDon.createParallelGroup(Alignment.TRAILING).addGap(0, 64, Short.MAX_VALUE)
						.addGroup(gl_btnHoaDon.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
								.addGroup(gl_btnHoaDon.createParallelGroup(Alignment.TRAILING).addComponent(lblHoaDon)
										.addComponent(iconSanPham_1, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		btnHoaDon.setLayout(gl_btnHoaDon);

		btnKhuyenMai = new JPanel();
		btnKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlkm, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(34, 139, 34));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnKhuyenMai.setBackground(new Color(144, 238, 144));
		// Phím tắt F4
		btnKhuyenMai.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0),
				"F4");
		btnKhuyenMai.getActionMap().put("F4", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlkm, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(34, 139, 34));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		JLabel iconSanPham_1_1 = new JLabel("");
		iconSanPham_1_1.setIcon(new ImageIcon(uiMain.class.getResource("/icon/sale2.png")));

		JLabel lblKhuyenMai = new JLabel("Khuyến Mãi");
		lblKhuyenMai.setForeground(Color.WHITE);
		lblKhuyenMai.setFont(new Font("Arial", Font.BOLD, 22));
		lblKhuyenMai.setBackground(Color.WHITE);
		GroupLayout gl_btnKhuyenMai = new GroupLayout(btnKhuyenMai);
		gl_btnKhuyenMai.setHorizontalGroup(gl_btnKhuyenMai.createParallelGroup(Alignment.LEADING)
				.addGap(0, 181, Short.MAX_VALUE).addGap(0, 181, Short.MAX_VALUE)
				.addGroup(gl_btnKhuyenMai.createSequentialGroup().addContainerGap()
						.addComponent(iconSanPham_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblKhuyenMai).addGap(20)));
		gl_btnKhuyenMai.setVerticalGroup(gl_btnKhuyenMai.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 64, Short.MAX_VALUE).addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_btnKhuyenMai.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_btnKhuyenMai.createParallelGroup(Alignment.TRAILING).addComponent(lblKhuyenMai)
								.addComponent(iconSanPham_1_1, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		btnKhuyenMai.setLayout(gl_btnKhuyenMai);

		btnNhanVien = new JPanel();
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlnv, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(34, 139, 34));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnNhanVien.setBackground(new Color(144, 238, 144));
		// Phím tắt F5
		btnNhanVien.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5");
		btnNhanVien.getActionMap().put("F5", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlnv, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(34, 139, 34));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		JLabel iconNhanVien = new JLabel("");
		iconNhanVien.setIcon(new ImageIcon(uiMain.class.getResource("/icon/emlpyee.png")));

		JLabel lblNhanvien = new JLabel("Nhân Viên");
		lblNhanvien.setForeground(Color.WHITE);
		lblNhanvien.setFont(new Font("Arial", Font.BOLD, 22));
		lblNhanvien.setBackground(Color.WHITE);
		GroupLayout gl_btnNhanVien = new GroupLayout(btnNhanVien);
		gl_btnNhanVien.setHorizontalGroup(gl_btnNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnNhanVien.createSequentialGroup().addContainerGap()
						.addComponent(iconNhanVien, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNhanvien).addGap(20)));
		gl_btnNhanVien
				.setVerticalGroup(gl_btnNhanVien.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_btnNhanVien.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
								.addGroup(gl_btnNhanVien.createParallelGroup(Alignment.TRAILING)
										.addComponent(iconNhanVien, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNhanvien))
								.addContainerGap()));
		btnNhanVien.setLayout(gl_btnNhanVien);

		btnKhachHang = new JPanel();
		btnKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlkh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(34, 139, 34));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		btnKhachHang.setBackground(new Color(144, 238, 144));
		// Phím tắt F6
		btnKhachHang.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0),
				"F6");
		btnKhachHang.getActionMap().put("F6", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qlkh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(34, 139, 34));
				btnThongKe.setBackground(new Color(144, 238, 144));
			}
		});
		JLabel iconKhachHang = new JLabel("");
		iconKhachHang.setIcon(new ImageIcon(uiMain.class.getResource("/icon/customer.png")));

		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("Arial", Font.BOLD, 22));
		lblKhachHang.setBackground(Color.WHITE);
		GroupLayout gl_btnKhachHang = new GroupLayout(btnKhachHang);
		gl_btnKhachHang.setHorizontalGroup(gl_btnKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnKhachHang.createSequentialGroup().addGap(6)
						.addComponent(iconKhachHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblKhachHang).addGap(45)));
		gl_btnKhachHang.setVerticalGroup(gl_btnKhachHang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnKhachHang.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_btnKhachHang.createParallelGroup(Alignment.TRAILING).addComponent(lblKhachHang)
								.addComponent(iconKhachHang, GroupLayout.PREFERRED_SIZE, 40,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		btnKhachHang.setLayout(gl_btnKhachHang);

		btnThongKe = new JPanel();
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qltk, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(34, 139, 34));
			}
		});
		btnThongKe.setBackground(new Color(144, 238, 144));
		// Phím tắt F7
		btnThongKe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "F7");
		btnThongKe.getActionMap().put("F7", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
				mainPanel.add(qltk, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

				btnBanHang.setBackground(new Color(144, 238, 144));
				btnSanPham.setBackground(new Color(144, 238, 144));
				btnHoaDon.setBackground(new Color(144, 238, 144));
				btnKhuyenMai.setBackground(new Color(144, 238, 144));
				btnNhanVien.setBackground(new Color(144, 238, 144));
				btnKhachHang.setBackground(new Color(144, 238, 144));
				btnThongKe.setBackground(new Color(34, 139, 34));
			}
		});
		JLabel iconThongKe = new JLabel("");
		iconThongKe.setIcon(new ImageIcon(uiMain.class.getResource("/icon/statistical.png")));

		JLabel lblThongKe = new JLabel("Thống Kê");
		lblThongKe.setForeground(Color.WHITE);
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 22));
		lblThongKe.setBackground(Color.WHITE);
		GroupLayout gl_btnThongKe = new GroupLayout(btnThongKe);
		gl_btnThongKe
				.setHorizontalGroup(gl_btnThongKe.createParallelGroup(Alignment.LEADING).addGap(0, 181, Short.MAX_VALUE)
						.addGroup(gl_btnThongKe.createSequentialGroup().addGap(6)
								.addComponent(iconThongKe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblThongKe).addGap(45)));
		gl_btnThongKe.setVerticalGroup(gl_btnThongKe.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 64, Short.MAX_VALUE)
				.addGroup(gl_btnThongKe.createSequentialGroup().addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_btnThongKe.createParallelGroup(Alignment.TRAILING).addComponent(lblThongKe)
								.addComponent(iconThongKe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		btnThongKe.setLayout(gl_btnThongKe);

		JPanel btnDangXuat = new JPanel();
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?",
						"Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					Login  lg = new Login();
					lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					lg.setLocationRelativeTo(null);
					lg.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnDangXuat.setBackground(new Color(255, 0, 0));

		JLabel iconDangXuat = new JLabel("");
		iconDangXuat.setIcon(new ImageIcon(uiMain.class.getResource("/icon/logout3.png")));
		// Phím tắt ESC
		btnDangXuat.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				"Esc");
		btnDangXuat.getActionMap().put("Esc", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?",
						"Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					Login  lg = new Login();
					lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					lg.setLocationRelativeTo(null);
					lg.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		JLabel lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("Arial", Font.BOLD, 22));
		lblDangXuat.setBackground(Color.WHITE);
		GroupLayout gl_btnDangXuat = new GroupLayout(btnDangXuat);
		gl_btnDangXuat.setHorizontalGroup(gl_btnDangXuat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnDangXuat.createSequentialGroup().addContainerGap()
						.addComponent(iconDangXuat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDangXuat)
						.addContainerGap(24, Short.MAX_VALUE)));
		gl_btnDangXuat
				.setVerticalGroup(
						gl_btnDangXuat.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_btnDangXuat.createSequentialGroup()
										.addComponent(iconDangXuat, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(25, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_btnDangXuat.createSequentialGroup()
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblDangXuat).addContainerGap()));
		btnDangXuat.setLayout(gl_btnDangXuat);
		GroupLayout gl_pnlListMenu = new GroupLayout(pnlListMenu);
		gl_pnlListMenu.setHorizontalGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlListMenu
				.createSequentialGroup()
				.addGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_pnlListMenu.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSanPham, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 195,
												Short.MAX_VALUE)
										.addComponent(btnBanHang, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pnlListMenu.createSequentialGroup().addGap(12)
								.addGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnKhachHang, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193,
												Short.MAX_VALUE)
										.addComponent(btnNhanVien, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
										.addComponent(btnThongKe, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193,
												Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pnlListMenu.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING)
										.addComponent(btnKhuyenMai, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 195,
												Short.MAX_VALUE)
										.addComponent(btnHoaDon, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
						.addGroup(gl_pnlListMenu.createSequentialGroup().addContainerGap().addComponent(btnDangXuat,
								GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_pnlListMenu.setVerticalGroup(gl_pnlListMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlListMenu.createSequentialGroup().addContainerGap()
						.addComponent(btnBanHang, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSanPham, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnHoaDon, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnKhuyenMai, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNhanVien, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnKhachHang, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnThongKe, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addGap(57)
						.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE)));

		JLabel lblIconBanHang = new JLabel("");
		lblIconBanHang.setIcon(new ImageIcon(uiMain.class.getResource("/icon/buy.png")));

		JLabel lblBanHang = new JLabel("Bán Hàng");
		lblBanHang.setForeground(new Color(255, 255, 255));
		lblBanHang.setBackground(new Color(255, 255, 255));
		lblBanHang.setFont(new Font("Arial", Font.BOLD, 22));
		GroupLayout gl_btnBanHang = new GroupLayout(btnBanHang);
		gl_btnBanHang.setHorizontalGroup(gl_btnBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnBanHang.createSequentialGroup().addContainerGap().addComponent(lblIconBanHang)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblBanHang).addGap(24)));
		gl_btnBanHang.setVerticalGroup(gl_btnBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnBanHang.createSequentialGroup().addGap(12)
						.addGroup(gl_btnBanHang.createParallelGroup(Alignment.TRAILING).addComponent(lblIconBanHang)
								.addComponent(lblBanHang))));
		btnBanHang.setLayout(gl_btnBanHang);
		pnlListMenu.setLayout(gl_pnlListMenu);
		pnlMenu.setLayout(gl_pnlMenu);
		frame.getContentPane().setLayout(groupLayout);
//		frame.setBounds(100, 100, 1215, 777);
		frame.setSize(new Dimension(1215, 777));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
