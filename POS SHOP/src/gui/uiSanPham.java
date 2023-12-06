package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class uiSanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	public uiSanPham() {
		setBackground(new Color(255, 255, 255));

		// Đặt kích thước mặc định cho JPanel QuanLySanPham
		setPreferredSize(new Dimension(953, 667));
		setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel, "name_45087099704000");
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tabbedPane.setBackground(new Color(255, 255, 255));
		mainPanel.add(tabbedPane, "name_45187479142700");
		//tab quản lý sản phẩm
		JPanel mainPanelQuanLySanPham = new JPanel();
		mainPanelQuanLySanPham.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Quản Lý Sản Phẩm", null, mainPanelQuanLySanPham, null);
		QuanLySanPham qlsp = new QuanLySanPham();
		mainPanelQuanLySanPham.removeAll();
		mainPanelQuanLySanPham.add(qlsp, BorderLayout.CENTER);
		mainPanelQuanLySanPham.revalidate();
		
		
		//tab quản lý thuộc tính
		JPanel mainPanelQuanLyThuocTinh = new JPanel();
		mainPanelQuanLyThuocTinh.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Quản Lý Thuộc Tính", null, mainPanelQuanLyThuocTinh, null);
		QuanLyThuocTinh qltt = new QuanLyThuocTinh();
		mainPanelQuanLyThuocTinh.removeAll();
		mainPanelQuanLyThuocTinh.add(qltt, BorderLayout.CENTER);
		
		//tab quản lý nhà cung cấp
		JPanel mainPanelQuanLyNhaCC = new JPanel();
		tabbedPane.addTab("Quản Lý Nhà Cung Cấp", null, mainPanelQuanLyNhaCC, null);
		QuanLyNhaCungCap qlncc = new QuanLyNhaCungCap();
		mainPanelQuanLyNhaCC.removeAll();
		mainPanelQuanLyNhaCC.add(qlncc, BorderLayout.CENTER);
	}
}