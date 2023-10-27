package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class QuanLyThuocTinh extends JPanel {

	/**
	 * Create the panel.
	 */
	public QuanLyThuocTinh() {
		setPreferredSize(new Dimension(947, 664));
		setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("quản lý thuộc tính");
		add(lblNewLabel, "name_45656178345600");
	}

}
