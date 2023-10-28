package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class BanHang extends JPanel {
	public JPanel mainPanel = new JPanel();
	/**
	 * Create the panel.
	 */
	public BanHang() {
		
		// Đặt kích thước mặc định cho JPanel QuanLySanPham
		setPreferredSize(new Dimension(947, 703));
		
		JPanel mainPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 664, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		QuanLyBanHang qlbh = new QuanLyBanHang();
		qlbh.btnTraHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
        mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
        mainPanel.setLayout(new CardLayout(0, 0));
        mainPanel.add(qlbh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
        
        //bam nut tra hang ben quan lý bán hàng
        qlbh.btnTraHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuanLyTraHang qlth = new QuanLyTraHang();
                mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
                mainPanel.add(qlth, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
                mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới

                qlth.btnBanHang.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent e) {
        				BanHang bh = new BanHang();
        				mainPanel.removeAll(); // Xóa tất cả các thành phần con khỏi mainPanel
        				mainPanel.add(bh, BorderLayout.CENTER); // Đặt giao diện quản lý nhân viên vào mainPanel
        				mainPanel.revalidate(); // Cập nhật lại mainPanel để hiển thị giao diện mới
        			}
        		});
                
			}
		});
//        bam nut bán hàng bên quản lý trả hàng

	}
}