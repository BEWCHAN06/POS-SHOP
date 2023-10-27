package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class QuanLySanPham extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLySanPham() {
		setPreferredSize(new Dimension(947, 664));
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_13998316339700");
	}

}
