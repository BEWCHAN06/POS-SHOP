package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectDB.KetNoiSQL;
import dao.ChatLieuDAO;
import dao.KichThuocDAO;
import dao.KieuDangDAO;
import dao.MauSacDAO;
import dao.PhanLoaiDAO;
import dao.XuatXuDAO;
import entity.ChatLieu;
import entity.KichThuoc;
import entity.KieuDang;
import entity.MauSac;
import entity.PhanLoai;
import entity.XuatXu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuanLyThuocTinh extends JPanel implements ActionListener{
	private JTextField txtTenThuocTinh;
	private JTextField txtTimKiem;
	private JTable tblThuocTinh;
	private ButtonGroup rd_group = new ButtonGroup();
    private javax.swing.JRadioButton rb_chatLieu;
    private javax.swing.JRadioButton rb_kichThuoc;
    private javax.swing.JRadioButton rb_kieuDang;
    private javax.swing.JRadioButton rb_loaiSanPham;
    private javax.swing.JRadioButton rb_mauSac;
    private javax.swing.JRadioButton rb_xuatXu;
	private MauSacDAO mauSac_Dao = new MauSacDAO();
	private KichThuocDAO kichThuoc_Dao = new KichThuocDAO();
	private XuatXuDAO xuatXu_Dao = new XuatXuDAO();
	private ChatLieuDAO chatLieu_Dao = new  ChatLieuDAO();
	private PhanLoaiDAO phanLoai_Dao = new PhanLoaiDAO();
	private KieuDangDAO kieuDang_Dao = new KieuDangDAO();
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnThem;
	private JButton btnHuy;
	private DefaultTableModel dtm;
	/**
	 * Create the panel.
	 */
	public QuanLyThuocTinh() {
		KetNoiSQL.getInstance().connect();
		initComponents();
		tblDanhSachMauSac();
	}
    
	private void initComponents() {
		
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(932, 685));
		setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel, "name_115175246584900");
		
		JPanel pnlThuocTinh = new JPanel();
		pnlThuocTinh.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Thu\u1ED9c t\u00EDnh s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		pnlThuocTinh.setBackground(new Color(255, 255, 255));
		
		JPanel pnlDanhSachThuocTinh = new JPanel();
		pnlDanhSachThuocTinh.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh S\u00E1ch Thu\u1ED9c T\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		pnlDanhSachThuocTinh.setBackground(new Color(255, 255, 255));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlDanhSachThuocTinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
						.addComponent(pnlThuocTinh, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlThuocTinh, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDanhSachThuocTinh, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblTmKimThuc = new JLabel("Tìm kiếm thuộc tính");
		lblTmKimThuc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTimKiem.setColumns(10);
		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTable();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTable();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				updateTable();
				
			}
			private void updateTable() {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_pnlDanhSachThuocTinh = new GroupLayout(pnlDanhSachThuocTinh);
		gl_pnlDanhSachThuocTinh.setHorizontalGroup(
			gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachThuocTinh.createSequentialGroup()
					.addGap(28)
					.addComponent(lblTmKimThuc, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(383, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
		);
		gl_pnlDanhSachThuocTinh.setVerticalGroup(
			gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDanhSachThuocTinh.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_pnlDanhSachThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTmKimThuc)
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
		);
		panel.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		panel.add(scrollPane, "name_117489822752800");
		
		tblThuocTinh = new JTable();
		tblThuocTinh.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"M\u00E3 Thu\u1ED9c T\u00EDnh", "T\u00EAn Thu\u1ED9c T\u00EDnh"
			}
		));
		scrollPane.setViewportView(tblThuocTinh);
		pnlDanhSachThuocTinh.setLayout(gl_pnlDanhSachThuocTinh);
		
		JLabel lblNewLabel = new JLabel("Tên thuộc tính :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel pnlListThuocTinh = new JPanel();
		pnlListThuocTinh.setBackground(new Color(255, 255, 255));
		
		//==========================================
		//CÁC NÚT
		//==========================================
		
		btnThem = new JButton("thêm");
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//				rb_mauSac.setEnabled(false);
//				btn_ThemMouseListener(e);
				txtTenThuocTinh.setEnabled(true);
				btnLuu.setEnabled(true);
				btnSua.setEnabled(false);
				btnThem.setEnabled(false);
				btnHuy.setEnabled(true);
				setRb(false);

			}
		});
		btnThem.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/add.png")));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 12));
		btnThem.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnThem.setBackground(new Color(65, 105, 225));
		
		btnSua = new JButton("Sửa");
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTenThuocTinh.setEnabled(true);
				btnLuu.setEnabled(true);
				btnSua.setEnabled(false);
				btnThem.setEnabled(false);
				btnHuy.setEnabled(true);
				setRb(false);
			}
		});
		btnSua.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/sua.png")));
		btnSua.setFont(new Font("Arial", Font.BOLD, 12));
		btnSua.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSua.setBackground(Color.YELLOW);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTenThuocTinh.setEnabled(false);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnLuu.setEnabled(false);
				btnHuy.setEnabled(false);
				setRb(true);
			}
		});
		btnLuu.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/luulienket.png")));
		btnLuu.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLuu.setBackground(new Color(255, 165, 0));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTenThuocTinh.setText("");
				txtTenThuocTinh.setEnabled(false);
				setRb(true);
				btnThem.setEnabled(true);
				btnLuu.setEnabled(true);
				btnHuy.setEnabled(false);
				btnLuu.setEnabled(false);
			}
		});
		btnLamMoi.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/refesh.png")));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 12));
		btnLamMoi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnLamMoi.setBackground(new Color(144, 238, 144));
		
		btnHuy = new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTenThuocTinh.setEnabled(false);
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnLuu.setEnabled(false);
				btnHuy.setEnabled(false);
				setRb(true);
			}
		});
		btnHuy.setIcon(new ImageIcon(QuanLyThuocTinh.class.getResource("/icon/x.png")));
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Arial", Font.BOLD, 12));
		btnHuy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnHuy.setBackground(Color.RED);
		
		txtTenThuocTinh = new JTextField();
		txtTenThuocTinh.setEnabled(false);
		txtTenThuocTinh.setBackground(Color.LIGHT_GRAY);
		txtTenThuocTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTenThuocTinh.setColumns(10);
		//===========================================
		//chạy tổng thể:
		txtTenThuocTinh.addPropertyChangeListener("enabled", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                boolean isEnabled = (boolean) evt.getNewValue();
                if (isEnabled) {
                    txtTenThuocTinh.setBackground(Color.WHITE);
                } else {
                    txtTenThuocTinh.setBackground(Color.DARK_GRAY);
                }
            }
        });
//		setColorTXT();
		GroupLayout gl_pnlThuocTinh = new GroupLayout(pnlThuocTinh);
		gl_pnlThuocTinh.setHorizontalGroup(
			gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThuocTinh.createSequentialGroup()
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTenThuocTinh, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(pnlListThuocTinh, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(75)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlThuocTinh.setVerticalGroup(
			gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThuocTinh.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlListThuocTinh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(txtTenThuocTinh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_pnlThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(1)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlThuocTinh.createSequentialGroup()
							.addGap(1)
							.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		
		rb_mauSac = new JRadioButton("Màu sắc");
		rb_mauSac.setBackground(new Color(255, 255, 255));
		rb_mauSac.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rb_kichThuoc = new JRadioButton("Kích thước");
		rb_kichThuoc.setBackground(new Color(255, 255, 255));
		rb_kichThuoc.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rb_chatLieu = new JRadioButton("Chất liệu");
		rb_chatLieu.setBackground(new Color(255, 255, 255));
		rb_chatLieu.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rb_kieuDang = new JRadioButton("kiểu dáng");
		rb_kieuDang.setBackground(new Color(255, 255, 255));
		rb_kieuDang.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rb_xuatXu = new JRadioButton("Xuất xứ");
		rb_xuatXu.setBackground(new Color(255, 255, 255));
		rb_xuatXu.setFont(new Font("Arial", Font.PLAIN, 12));
		
		rb_loaiSanPham = new JRadioButton("Loại sản phẩm");
		rb_loaiSanPham.setBackground(new Color(255, 255, 255));
		rb_loaiSanPham.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_pnlListThuocTinh = new GroupLayout(pnlListThuocTinh);
		gl_pnlListThuocTinh.setHorizontalGroup(
			gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlListThuocTinh.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(rb_mauSac)
						.addComponent(rb_kieuDang, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
						.addComponent(rb_xuatXu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(rb_kichThuoc, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rb_chatLieu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rb_loaiSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlListThuocTinh.setVerticalGroup(
			gl_pnlListThuocTinh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlListThuocTinh.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb_mauSac)
						.addComponent(rb_kichThuoc)
						.addComponent(rb_chatLieu))
					.addGap(18)
					.addGroup(gl_pnlListThuocTinh.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb_kieuDang)
						.addComponent(rb_xuatXu)
						.addComponent(rb_loaiSanPham))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		pnlListThuocTinh.setLayout(gl_pnlListThuocTinh);
		pnlThuocTinh.setLayout(gl_pnlThuocTinh);
		mainPanel.setLayout(gl_mainPanel);
		rb_chatLieu.setEnabled(true);
		rd_group.add(rb_mauSac);
        rd_group.add(rb_chatLieu);
        rd_group.add(rb_kichThuoc);
        rd_group.add(rb_loaiSanPham);
        rd_group.add(rb_kieuDang);
        rd_group.add(rb_xuatXu);
        rb_mauSac.setSelected(true);
        
        //addActionListener
      rb_chatLieu.addActionListener(this);
      rb_kichThuoc.addActionListener(this);
      rb_loaiSanPham.addActionListener(this);
      rb_mauSac.addActionListener(this);
      rb_xuatXu.addActionListener(this);
      rb_kieuDang.addActionListener(this);
	}
	private void setColorTXT() {
		boolean check = txtTenThuocTinh.isEnabled();
		if(check == true) {
			txtTenThuocTinh.setBackground(Color.white);
		}else {
			txtTenThuocTinh.setBackground(Color.DARK_GRAY);
		}
	}
	private void btn_ThemMouseListener(MouseEvent e) {
        rb_chatLieu.setEnabled(false);
        rb_kichThuoc.setEnabled(false);
        rb_kieuDang.setEnabled(false);
        rb_loaiSanPham.setEnabled(false);
        rb_mauSac.setEnabled(false);
        rb_xuatXu.setEnabled(false);
		
	}
	private void setRb(boolean check) {
		rb_chatLieu.setEnabled(check);
		rb_kichThuoc.setEnabled(check);
		rb_kieuDang.setEnabled(check);
		rb_loaiSanPham.setEnabled(check);
		rb_mauSac.setEnabled(check);
		rb_xuatXu.setEnabled(check);
	}
    private void clearInput(){
        txtTenThuocTinh.setText("");
    }
	private void clearTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
    }
	private void tblDanhSachMauSac(){
        ArrayList<MauSac> listMauSac = mauSac_Dao.getAllMauSac();
        clearTable();
        dtm = (DefaultTableModel) tblThuocTinh.getModel();
        for(MauSac ms : listMauSac) {
        	Object[] rowData = {ms.getMaMauSac(), ms.getMauSac()};
        	dtm.addRow(rowData);
        }
    }
	private void tblDanhSachKichThuoc(){
        ArrayList<KichThuoc> listPhanLoai = kichThuoc_Dao.getAllKichThuoc();
        clearTable();
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        for(KichThuoc kt : listPhanLoai){
            Object[] rowData = {kt.getMaKichThuoc(), kt.getKichThuoc()};
            dtm.addRow(rowData);
        }
    }
	private void tblDanhSachXuatXu() {
		ArrayList<XuatXu> listXuatXu = xuatXu_Dao.getAllXuatXu();
		clearTable();
		DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
		for(XuatXu xx : listXuatXu) {
			Object[] rowData = {xx.getMaXuatXu(), xx.getXuatXu()};
            dtm.addRow(rowData);
		}
	}
	private void tblDanhSachChatLieu() {
		ArrayList<ChatLieu> listChatLieu = chatLieu_Dao.getAllChatLieu();
		clearTable();
		dtm = (DefaultTableModel) tblThuocTinh.getModel();
		for(ChatLieu cl : listChatLieu) {
			Object[] rowData = {cl.getMaChatLieu(), cl.getChatLieu()};
            dtm.addRow(rowData);
		}
	}
	private void tblDanhSachPhanLoai() {
		ArrayList<PhanLoai> listPhanLoai = phanLoai_Dao.getAllPhanLoai();
		clearTable();
		DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
		for(PhanLoai pl : listPhanLoai) {
			Object[] rowData = {pl.getMaPhanLoai(), pl.getPhanLoai()};
            dtm.addRow(rowData);
		}
	}
	private void tblDanhSachKieuDang() {
		ArrayList<KieuDang> list = kieuDang_Dao.getAllKieuDang();
		clearTable();
		DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
		for(KieuDang kd : list) {
			Object[] rowData = {kd.getMaKieuDang(), kd.getKieuDang()};
            dtm.addRow(rowData);
		}
	}
	public boolean validData() {
        String tenThuocTinh = txtTenThuocTinh.getText().trim();

        if (tenThuocTinh.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thuộc tính");
            return false;
        }

        return true;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		if(event.equalsIgnoreCase("Kích thước")){
            tblDanhSachKichThuoc();
        }

        else if(event.equalsIgnoreCase("Màu sắc")){
            tblDanhSachMauSac();
        }

        else if(event.equalsIgnoreCase("Chất liệu")){
            tblDanhSachChatLieu();
        }

        else if(event.equalsIgnoreCase("Loại sản phẩm")){
            tblDanhSachPhanLoai();
        }
        else if(event.equalsIgnoreCase("Kiểu dáng")){
            tblDanhSachKieuDang();
        }
        else if(event.equalsIgnoreCase("Xuất xứ")){
            tblDanhSachXuatXu();
        } 
	}
	
}
