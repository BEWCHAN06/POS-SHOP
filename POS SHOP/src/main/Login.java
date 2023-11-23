package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import ConnectDB.KetNoiSQL;
import dao.loginDAO;
import gui.FormQuenMatKhau;
import gui.QuanLyThongKe;
import gui.uiMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenTK;
	private JPasswordField passwordField;
	private JFrame frame;
	public FormQuenMatKhau lmxn;
	public uiMain otherUI;
	private boolean isPasswordVisible = false;

	/**
	 * Launch the application.
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
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		KetNoiSQL.getInstance().connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(5, 5, 329, 601);
		panelLogo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelLogo.setBackground(new Color(34, 139, 34));

		JPanel pnlDangNhap = new JPanel();
		pnlDangNhap.setForeground(new Color(144, 238, 144));
		pnlDangNhap.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pnlDangNhap.setBounds(333, 5, 646, 601);
		pnlDangNhap.setBackground(new Color(144, 238, 144));
		contentPane.setLayout(null);
		contentPane.add(panelLogo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icon/logoshop3.png")));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icon/manghinh.png")));

		JLabel lblNewLabel_2 = new JLabel("POS SYSTEM");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 40));
		GroupLayout gl_panelLogo = new GroupLayout(panelLogo);
		gl_panelLogo.setHorizontalGroup(gl_panelLogo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogo.createSequentialGroup()
						.addGroup(gl_panelLogo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLogo.createSequentialGroup().addContainerGap()
										.addGroup(gl_panelLogo.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1).addComponent(lblNewLabel)))
								.addGroup(gl_panelLogo.createSequentialGroup().addGap(40).addComponent(lblNewLabel_2)))
						.addContainerGap(40, Short.MAX_VALUE)));
		gl_panelLogo.setVerticalGroup(gl_panelLogo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogo.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addGap(82).addComponent(lblNewLabel_2).addContainerGap(110, Short.MAX_VALUE)));
		panelLogo.setLayout(gl_panelLogo);
		contentPane.add(pnlDangNhap);

		JLabel lblNewLabel_2_1 = new JLabel("Đăng Nhập");
		lblNewLabel_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 30));

		JLabel lblNewLabel_2_1_1 = new JLabel("tên tài khoản");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBackground(Color.BLACK);

		txtTenTK = new JTextField();
		txtTenTK.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTenTK.setColumns(10);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("mật khẩu ");
		lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBackground(Color.BLACK);

		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginDAO daoLoginDAO = new loginDAO();
				String pass = String.valueOf(passwordField.getPassword());
				int checklogin = daoLoginDAO.getTaiKhoan(txtTenTK.getText(), pass);
				if (checklogin == 1) {
					otherUI = new uiMain(); // Tạo một đối tượng của lớp uiMain
					otherUI.frame.setVisible(true); // Hiển thị giao diện của uiMain bằng cách set visible cho frame của
													// uiMain
					dispose();
				} else {

				}
			}
		});
		// Phím tắt Enter
		btnDangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				"Enter");
		btnDangNhap.getActionMap().put("Enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginDAO daoLoginDAO = new loginDAO();
				String pass = String.valueOf(passwordField.getPassword());
				int checklogin = daoLoginDAO.getTaiKhoan(txtTenTK.getText(), pass);
				if (checklogin == 1) {
					otherUI = new uiMain(); // Tạo một đối tượng của lớp uiMain
					otherUI.frame.setVisible(true); // Hiển thị giao diện của uiMain bằng cách set visible cho frame của
													// uiMain
					dispose();
				} else {

				}
			}
		});
		btnDangNhap.setIcon(new ImageIcon(Login.class.getResource("/icon/login.png")));
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(255, 0, 0));
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 13));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnXemMatKhau = new JButton("");
		btnXemMatKhau.setForeground(new Color(255, 255, 255));
		btnXemMatKhau.setBackground(new Color(144, 238, 144));
		btnXemMatKhau.setBorder(new LineBorder(new Color(144, 238, 144), 2));
		btnXemMatKhau.setIcon(new ImageIcon(Login.class.getResource("/icon/conmat.png")));

		JButton btnQuenMatKhau = new JButton("Quên mật khẩu ?");
		btnQuenMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lmxn = new FormQuenMatKhau();
				lmxn.setVisible(true);
				dispose();
				lmxn.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						// Hiển thị lại giao diện Login khi FormLayMaXacNhan được đóng
						Login lg = new Login();
						lg.setVisible(true);
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub

					}
				});
			}
		});
		btnQuenMatKhau.setBackground(new Color(144, 238, 144));
		btnQuenMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
		btnQuenMatKhau.setBorder(new LineBorder(new Color(144, 238, 144), 2));
		GroupLayout gl_pnlDangNhap = new GroupLayout(pnlDangNhap);
		gl_pnlDangNhap.setHorizontalGroup(gl_pnlDangNhap.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDangNhap.createSequentialGroup().addGap(142)
						.addGroup(gl_pnlDangNhap.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
								.addComponent(btnDangNhap, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
								.addGroup(gl_pnlDangNhap.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_2_1_1_1, Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
												158, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1, Alignment.LEADING).addComponent(txtTenTK,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
						.addGap(18)
						.addComponent(btnXemMatKhau, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(65))
				.addGroup(gl_pnlDangNhap.createSequentialGroup().addContainerGap(252, Short.MAX_VALUE)
						.addComponent(btnQuenMatKhau, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGap(230)));
		gl_pnlDangNhap.setVerticalGroup(gl_pnlDangNhap.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDangNhap
				.createSequentialGroup().addGap(153)
				.addGroup(gl_pnlDangNhap.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnXemMatKhau, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlDangNhap.createSequentialGroup().addComponent(lblNewLabel_2_1).addGap(23)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTenTK, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(passwordField,
										GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
				.addGap(45).addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(btnQuenMatKhau, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(121, Short.MAX_VALUE)));
		pnlDangNhap.setLayout(gl_pnlDangNhap);
		btnXemMatKhau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isPasswordVisible = !isPasswordVisible;
				updatePasswordFieldEchoChar();
			}
		});

		txtTenTK.setText("TK01");
		passwordField.setText("123456");

	}

	private void updatePasswordFieldEchoChar() {
		if (isPasswordVisible) {
			passwordField.setEchoChar((char) 0);
		} else {
			passwordField.setEchoChar('\u2022');
		}
	}
}