package gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class QuanLySanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLySanPham() {
		setLayout(new CardLayout(0, 0));

		// Đặt kích thước mặc định cho JPanel QuanLySanPham
		setPreferredSize(new Dimension(947, 664));
	}
}