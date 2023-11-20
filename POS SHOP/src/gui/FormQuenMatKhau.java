package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dao.TaiKhoanDAO;
import main.Login;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;

public class FormQuenMatKhau extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JLabel lblNhapTenDangNhap, lblXacNhanMatKhau;
	private JTextField txtTenTaiKhoan, txtXacNhanMatKhau;
	private JButton btnLayMaXacNhan, btnQuayLai;
	private JButton btnGuiLaiMaXacNhan;
	private Timer timer;
	private int seconds = 40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormQuenMatKhau frame = new FormQuenMatKhau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormQuenMatKhau() {
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 370);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);

		JPanel panelLoGo = new JPanel();
		panelLoGo.setBounds(0, 0, 328, 341);
		panelLoGo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelLoGo.setBackground(new Color(31, 139, 31));

		JPanel panelForm = new JPanel();
		panelForm.setBounds(327, 0, 454, 333);
		panelForm.setBackground(new Color(144, 238, 144));

		lblNhapTenDangNhap = new JLabel("Nhập tên đăng nhập:");
		lblNhapTenDangNhap.setBounds(58, 65, 360, 18);
		lblNhapTenDangNhap.setForeground(Color.BLACK);
		lblNhapTenDangNhap.setFont(new Font("Arial", Font.BOLD, 15));
		lblNhapTenDangNhap.setBackground(Color.BLACK);

		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setBounds(58, 93, 360, 25);
		txtTenTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 12));
		txtTenTaiKhoan.setColumns(10);

		lblXacNhanMatKhau = new JLabel("Xác nhận mật khẩu:");
		lblXacNhanMatKhau.setBounds(58, 136, 147, 18);
		lblXacNhanMatKhau.setForeground(Color.BLACK);
		lblXacNhanMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lblXacNhanMatKhau.setBackground(Color.BLACK);
		lblXacNhanMatKhau.setVisible(false);

		txtXacNhanMatKhau = new JTextField();
		txtXacNhanMatKhau.setBounds(58, 172, 360, 25);
		txtXacNhanMatKhau.setFont(new Font("Arial", Font.PLAIN, 12));
		txtXacNhanMatKhau.setColumns(10);
		txtXacNhanMatKhau.setVisible(false);

		btnLayMaXacNhan = new JButton("LẤY MÃ XÁC NHẬN");
		btnLayMaXacNhan.setBounds(58, 136, 364, 52);
		btnLayMaXacNhan.setIcon(new ImageIcon(FormQuenMatKhau.class.getResource("/icon/login.png")));
		btnLayMaXacNhan.setForeground(Color.WHITE);
		btnLayMaXacNhan.setFont(new Font("Arial", Font.BOLD, 13));
		btnLayMaXacNhan.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnLayMaXacNhan.setBackground(Color.RED);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(312, 206, 110, 29);
		btnQuayLai.setIcon(new ImageIcon(FormQuenMatKhau.class.getResource("/icon/refesh.png")));
		btnQuayLai.setForeground(new Color(31, 139, 31));
		btnQuayLai.setFont(new Font("Arial", Font.BOLD, 12));
		btnQuayLai.setBackground(new Color(255, 255, 255));

		btnGuiLaiMaXacNhan = new JButton("Gửi lại mã (40)");
		btnGuiLaiMaXacNhan.setBounds(58, 206, 122, 29);
		btnGuiLaiMaXacNhan.setVisible(false);
		btnGuiLaiMaXacNhan.setForeground(new Color(31, 139, 31));
		btnGuiLaiMaXacNhan.setFont(new Font("Arial", Font.BOLD, 12));
		btnGuiLaiMaXacNhan.setBackground(Color.WHITE);
		mainPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FormQuenMatKhau.class.getResource("/icon/logoshop3.png")));
		GroupLayout gl_panelLoGo = new GroupLayout(panelLoGo);
		gl_panelLoGo.setHorizontalGroup(gl_panelLoGo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLoGo.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_panelLoGo.setVerticalGroup(gl_panelLoGo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLoGo.createSequentialGroup().addContainerGap(84, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
						.addGap(82)));
		panelLoGo.setLayout(gl_panelLoGo);
		mainPanel.add(panelLoGo);
		mainPanel.add(panelForm);
		panelForm.setLayout(null);
		panelForm.add(lblNhapTenDangNhap);
		panelForm.add(txtTenTaiKhoan);
		panelForm.add(lblXacNhanMatKhau);
		panelForm.add(txtXacNhanMatKhau);
		panelForm.add(btnGuiLaiMaXacNhan);
		panelForm.add(btnQuayLai);
		panelForm.add(btnLayMaXacNhan);
		btnLayMaXacNhan.addActionListener(this);
		btnQuayLai.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent q) {
		Object o = q.getSource();
		String tenTK = txtTenTaiKhoan.getText();
		TaiKhoanDAO ds = new TaiKhoanDAO();
		String email = ds.getEmailTheoTenTaiKhoan(tenTK);
		if (o.equals(btnLayMaXacNhan)) {
			String maXacNhan = maXacNhan();
			String mama = maXacNhan;
			if (btnLayMaXacNhan.getText().equals("LẤY MÃ XÁC NHẬN")) {
				if (txtTenTaiKhoan.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Tên tài khoản không được để rỗng !");
					txtTenTaiKhoan.requestFocus();
				} else {
					if (email == null) {
						JOptionPane.showMessageDialog(null, "Tên tài khoản không tồn tại, Vui lòng thử lại !");
						txtTenTaiKhoan.requestFocus();
					} else {
						txtTenTaiKhoan.setText("");
						btnLayMaXacNhan.setText("XÁC NHẬN");
						btnLayMaXacNhan.setEnabled(true);
						lblNhapTenDangNhap.setText("Nhập mã xác nhận cho Email " + email + ":");
						demNguoc();
						btnGuiLaiMaXacNhan.setEnabled(false);
						btnGuiLaiMaXacNhan.setVisible(true);
						JOptionPane.showMessageDialog(null, "Mã xác nhận đã được gửi tới " + email);
						guiMaXacNhan(email, mama);
						System.out.println(mama);
						txtTenTaiKhoan.requestFocus();
					}
				}
			} else {
				if (!txtTenTaiKhoan.getText().equals(mama)) {
					System.out.println(mama);
					JOptionPane.showMessageDialog(null, "Mã xác nhận không hợp lệ !");
				} else {
					btnLayMaXacNhan.setText("HOÀN TẤT");
					lblNhapTenDangNhap.setText("Mật khẩu mới");
					btnGuiLaiMaXacNhan.setVisible(false);
					// Di chuyển các nút
					btnLayMaXacNhan.setBounds(58, 223, 364, 52);
					btnQuayLai.setBounds(312, 293, 110, 29);
					// Hiển thị lablel và textField xác nhận mật khẩu
					lblXacNhanMatKhau.setVisible(true);
					txtXacNhanMatKhau.setVisible(true);
				}
			}
		} else if (o.equals(btnGuiLaiMaXacNhan)) {

		} else if (o.equals(btnQuayLai)) {
			if (btnLayMaXacNhan.getText().equals("HOÀN TẤT")) {

			}
			Login lg = new Login();
			lg.setVisible(true);
			dispose();
		}
	}

	// Thời gian đếm ngược để gửi lại mã
	private void demNguoc() {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seconds--;
				if (seconds >= 0) {
					btnGuiLaiMaXacNhan.setText("Gửi lại mã (" + seconds + ")");
				} else {
					timer.stop();
					btnGuiLaiMaXacNhan.setEnabled(true);
					btnGuiLaiMaXacNhan.setText("Gửi lại mã");
				}
			}
		});
		timer.start();
	}

	// Hàm sinh mã xác nhận ngẫu nhiên
	private String maXacNhan() {
		Random random = new Random();
		// Sinh ra một số ngẫu nhiên gồm 5 chữ số từ 0 đến 99999 (bao gồm cả 0 và 99999)
		int maXacNhan = random.nextInt(100000);
		// Định dạng số ngẫu nhiên thành chuỗi với 5 chữ số
		return String.format("%05d", maXacNhan);
	}

	// Hàm gửi mã cho email xác nhận
	private void guiMaXacNhan(String email, String maXacNhan) {
		// Email: posshop95@gmail.com
		// Pasword: awazzbudolknwanx
		String from = "posshop95@gmail.com"; // Người gửi
		String password = "gbrp adoe fcvq bnsh";

		// Cấu hình SMTP server và thông tin kết nối
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // Phải đăng nhập
		props.put("mail.smtp.starttls.enable", "true"); // Sử dụng giao thức TSL
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 (google) SSL 465

		// Tạo Authenticator (Trình xác thực) -> Đăng nhập vào gmail
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}

		};
		// Tạo đối tượng Session để kết nối đến SMTP server và đăng nhập
		Session session = Session.getInstance(props, auth);

		// Tạo đối tượng MimeMessage (để tạo tin nhắn)
		MimeMessage msg = new MimeMessage(session);
		try {
//			msg.addHeader("Content-type", "text/HTML; charset=UTF-8"); // Kiểu nội dung
			msg.setFrom(from); // Gửi từ ...
			// Người nhận (bcc, cc, to)
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
			msg.setSubject("Mã xác minh cho email khôi phục:" + maXacNhan); // Tiêu đề email
			msg.setSentDate(new Date()); // Ngày gửi
			/**
			 * Quy đinh email phản hồi (Nếu không để thì sẽ phản hồi về email mặc định)
			 * msg.setReplyTo(InternetAddress.parse(from, false));
			 */
			// Nội dung email
			String htmlContent = "<div style=\"width: 450px; border: 1px solid #ccc; border-radius: 5px; margin: auto; display: flex; align-items: center; flex-direction: column;\">"
					+ "<img src=\"https://scontent.xx.fbcdn.net/v/t1.15752-9/370139880_914036113420812_8414365613681779412_n.png?stp=cp0_dst-png&_nc_cat=110&ccb=1-7&_nc_sid=510075&_nc_eui2=AeG0mEg37O5ZBdT9OsjPlmyzKU5YQod5xicpTlhCh3nGJySNlhZ4huHobIeNi_O5N7GK-2DfJtoEyjun-orfhr_t&_nc_ohc=Zj6QDGLfggYAX9NeCOq&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdQg20GiRL-YQP8IDzF5LE22_UtGJOfG8IG-ca5LuYGKhA&oe=65800E0B\" alt=\"logoPosShop\"/><br>"
					+ "<h2 style=\"width: 350px; font-weight: 500; text-align: center; margin: 0; padding-bottom: 26px; border-bottom: 1px solid #ccc;\">Xác minh email của bạn</h2><br>"
					+ "<p>Sử dụng mã này để tiếp tục việc thiết lập mật khẩu:</p><br>"
					+ "<h1 style=\"margin: 0;\"><strong>" + maXacNhan + "</strong></h1><br>"
					+ "<p>Mã này sẽ hết hạn sau 24 giờ.</p><br>"
					+ "<p style=\"margin-top: 0;\">PosShop, trân trọng!</p><br>" + "</div>";

			// Gửi mail
			msg.setContent(htmlContent, "text/html; charset=utf-8");
			// Gửi mail
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void kiemTraRong() {
		txtTenTaiKhoan.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				chekRong();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				chekRong();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				chekRong();
			}
		});
	}

	private void chekRong() {
		String text = txtTenTaiKhoan.getText();
		if (text.equals("")) {
			btnLayMaXacNhan.setEnabled(false);
		} else {
			btnGuiLaiMaXacNhan.setEnabled(true);
		}
	}

}