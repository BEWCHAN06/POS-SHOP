package entity;

public class SanPham {
    private String maSP;
    private String tenSP;
    private PhanLoai pl; 
    private double giaNhap;
    private int loi;
    private KhuyenMai khuyenMai; 
    private double giaBan;
    private KichThuoc kichThuoc; 
    private int soLuong; 
    private MauSac mauSac; 
    private ChatLieu chatLieu;
    private NhaCungCap nhaCungCap;
    private String hinhAnh;
    private int TrangThai;
    
	public SanPham(String maSP, String tenSP, PhanLoai pl, double giaNhap, int loi, KhuyenMai khuyenMai, double giaBan,
			KichThuoc kichThuoc, int soLuong, MauSac mauSac, ChatLieu chatLieu, NhaCungCap nhaCungCap, String hinhAnh,
			int trangThai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.pl = pl;
		this.giaNhap = giaNhap;
		this.loi = loi;
		this.khuyenMai = khuyenMai;
		this.giaBan = giaBan;
		this.kichThuoc = kichThuoc;
		this.soLuong = soLuong;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
		this.nhaCungCap = nhaCungCap;
		this.hinhAnh = hinhAnh;
		this.TrangThai = trangThai;
	}
	public SanPham(String maSP, String tenSP, PhanLoai pl, double giaNhap, int loi, KhuyenMai khuyenMai, double giaBan,
			KichThuoc kichThuoc, int soLuong, MauSac mauSac, ChatLieu chatLieu, NhaCungCap nhaCungCap, String hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.pl = pl;
		this.giaNhap = giaNhap;
		this.loi = loi;
		this.khuyenMai = khuyenMai;
		this.giaBan = giaBan;
		this.kichThuoc = kichThuoc;
		this.soLuong = soLuong;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
		this.nhaCungCap = nhaCungCap;
		this.hinhAnh = hinhAnh;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public PhanLoai getPl() {
		return pl;
	}
	public void setPl(PhanLoai pl) {
		this.pl = pl;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public int getLoi() {
		return loi;
	}
	public void setLoi(int loi) {
		this.loi = loi;
	}
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public KichThuoc getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(KichThuoc kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public MauSac getMauSac() {
		return mauSac;
	}
	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}
	public ChatLieu getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(ChatLieu chatLieu) {
		this.chatLieu = chatLieu;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	public int getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", pl=" + pl + ", giaNhap=" + giaNhap + ", loi=" + loi
				+ ", khuyenMai=" + khuyenMai + ", giaBan=" + giaBan + ", kichThuoc=" + kichThuoc + ", soLuong="
				+ soLuong + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", nhaCungCap=" + nhaCungCap
				+ ", hinhAnh=" + hinhAnh + "]";
	}
    
}
