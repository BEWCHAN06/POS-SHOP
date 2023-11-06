package entity;

public class SanPham {
    private String maSP;
    private String tenSP;
    private double giaNhap;
    private double giaBan;
    private NhaCungCap nhaCungCap;
    private KhuyenMai khuyenMai;
    private int trangThai;
    private ChatLieu chatLieu;
    private KieuDang kieuDang;
    private KichThuoc kichThuoc;
    private XuatXu xuatXu;
    private PhanLoai phanLoai;
    private MauSac mauSac;
    private int loiTheoPhanTram;
    private String hinhAnh;
    public SanPham() {
        // Constructor mặc nhiên
    }

    public SanPham(String maSP, String tenSP, double giaNhap, double giaBan,NhaCungCap nhaCungCap, KhuyenMai khuyenMai,
                   int trangThai, ChatLieu chatLieu, KieuDang kieuDang, KichThuoc kichThuoc, XuatXu xuatXu,
                   PhanLoai phanLoai, MauSac mauSac, int loiTheoPhanTram) { // Gia Huy Thêm giaBan, loiTheoPhanTram
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan; // GiaBan được tính dựa trên giá nhập (30% lợi nhuận)
        this.nhaCungCap = nhaCungCap;
        this.khuyenMai = khuyenMai;
        this.trangThai = trangThai;
        this.chatLieu = chatLieu;
        this.kieuDang = kieuDang;
        this.kichThuoc = kichThuoc;
        this.xuatXu = xuatXu;
        this.phanLoai = phanLoai;
        this.mauSac = mauSac;
        this.loiTheoPhanTram = loiTheoPhanTram;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        // Cài đặt logic để tạo mã sản phẩm theo yêu cầu (SPxxx)
        // Phát sinh tự động
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        if (!tenSP.isEmpty()) {
            this.tenSP = tenSP;
        } else {
            throw new IllegalArgumentException("Sản phẩm không được rỗng");
        }
    }

    public void setGiaNhap(double giaNhap) {
        if (giaNhap > 0) {
            this.giaNhap = giaNhap;
        } else {
            throw new IllegalArgumentException("Giá nhập phải lớn hơn 0");
        }
    }

    public void setGiaBan(double giaNhap, double giaBan) {
        // Tính giá bán dựa trên giá nhập, ví dụ: giaBan = giaNhap * 1.3 (tăng 30%)
        this.giaBan = giaNhap * 1.3;
    }

    public void setTrangThai(int trangThai) {
        if (trangThai == 0 || trangThai == 1 || trangThai == 2) {
            this.trangThai = trangThai;
        } else {
            throw new IllegalArgumentException("Trạng thái sản phẩm không hợp lệ");
        }
    }

    public void setChatLieu(ChatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    public void setKieuDang(KieuDang kieuDang) {
        this.kieuDang = kieuDang;
    }

    public void setKichThuoc(KichThuoc kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public void setPhanLoai(PhanLoai phanLoai) {
        this.phanLoai = phanLoai;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }
    
    public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public ChatLieu getChatLieu() {
		return chatLieu;
	}

	public KieuDang getKieuDang() {
		return kieuDang;
	}

	public KichThuoc getKichThuoc() {
		return kichThuoc;
	}

	public XuatXu getXuatXu() {
		return xuatXu;
	}

	public PhanLoai getPhanLoai() {
		return phanLoai;
	}

	public MauSac getMauSac() {
		return mauSac;
	}

	@Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                ", nhaCungCap=" + nhaCungCap +
                ", khuyenMai=" + khuyenMai +
                ", trangThai=" + trangThai +
                ", chatLieu=" + chatLieu +
                ", kieuDang=" + kieuDang +
                ", kichThuoc=" + kichThuoc +
                ", xuatXu=" + xuatXu +
                ", phanLoai=" + phanLoai +
                ", mauSac=" + mauSac +
                '}';
    }
}
