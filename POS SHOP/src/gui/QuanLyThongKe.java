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
	private TabThongKeSanPham tabTKSP = new TabThongKeSanPham();
	private TabThongKeDoanhThu tabDT = new TabThongKeDoanhThu();
	

	public QuanLyThongKe() {
		tabTKSP.setVisible(true);
		tabDT.setVisible(true);
		setBackground(new Color(255, 255, 255));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setPreferredSize(new Dimension(934, 685));
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, "name_34377947137900");
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setFont(new Font("Arial", Font.BOLD, 15));
		pnlSanPham.setVisible(true);
		tabbedPane.addTab("Sản Phẩm", null, pnlSanPham, null);
		pnlSanPham.setLayout(new CardLayout(0, 0));
		tabbedPane.setEnabledAt(0, true);
		pnlSanPham.removeAll();
		pnlSanPham.add(tabTKSP, BorderLayout.CENTER);
		pnlSanPham.revalidate();
		
		JPanel pnlDoanhThu = new JPanel();
		tabbedPane.addTab("DoanhThu", null, pnlDoanhThu, null);
		pnlDoanhThu.setLayout(new CardLayout(0, 0));
		pnlDoanhThu.removeAll();
		pnlDoanhThu.setVisible(true);
		pnlDoanhThu.add(tabDT, BorderLayout.CENTER);
		pnlDoanhThu.revalidate();
	}
	
}