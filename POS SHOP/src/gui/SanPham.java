package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class SanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	public SanPham() {

		// Đặt kích thước mặc định cho JPanel QuanLySanPham
		setPreferredSize(new Dimension(953, 667));
		setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		add(mainPanel, "name_45087099704000");
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.add(tabbedPane, "name_45187479142700");
		//tab quản lý sản phẩm
		JPanel mainPanelQuanLySanPham = new JPanel();
		tabbedPane.addTab("Quản Lý Sản Phẩm", null, mainPanelQuanLySanPham, null);
		QuanLySanPham qlsp = new QuanLySanPham();
		mainPanelQuanLySanPham.removeAll();
		mainPanelQuanLySanPham.add(qlsp, BorderLayout.CENTER);
		mainPanelQuanLySanPham.revalidate();
		
		
		//tab quản lý thuộc tính
		JPanel mainPanelQuanLyThuocTinh = new JPanel();
		tabbedPane.addTab("Quản Lý Thuộc Tính", null, mainPanelQuanLyThuocTinh, null);
		QuanLyThuocTinh qltt = new QuanLyThuocTinh();
		mainPanelQuanLyThuocTinh.removeAll();
		mainPanelQuanLyThuocTinh.add(qltt, BorderLayout.CENTER);
		mainPanelQuanLyThuocTinh.revalidate();
	}
}