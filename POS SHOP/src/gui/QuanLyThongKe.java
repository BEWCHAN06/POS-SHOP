package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class QuanLyThongKe extends JPanel{
	private TabThongKeSanPham tabTKSP;
	private TabThongKeDoanhThu tabDT;

	public QuanLyThongKe() {
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setPreferredSize(new Dimension(934, 685));
		
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "name_34377947137900");
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setFont(new Font("Arial", Font.BOLD, 15));
		tabbedPane.addTab("Sản Phẩm", null, pnlSanPham, null);
		pnlSanPham.setLayout(new CardLayout(0, 0));
		tabbedPane.setEnabledAt(0, true);
		tabTKSP = new TabThongKeSanPham();
		pnlSanPham.removeAll();
		pnlSanPham.add(tabTKSP, BorderLayout.CENTER);
		pnlSanPham.revalidate();
		
		JPanel pnlDoanhThu = new JPanel();
		tabbedPane.addTab("DoanhThu", null, pnlDoanhThu, null);
		pnlDoanhThu.setLayout(new CardLayout(0, 0));
		tabDT = new TabThongKeDoanhThu();
		pnlDoanhThu.removeAll();
		pnlDoanhThu.add(tabDT, BorderLayout.CENTER);
		pnlDoanhThu.revalidate();
	}
	
}