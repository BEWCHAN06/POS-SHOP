package entity;

public class PhanLoai {
    private String maPhanLoai;
    private String phanLoai;

    public PhanLoai() {
        // Constructor mặc nhiên
    }

    public PhanLoai(String maPhanLoai, String phanLoai) {
        setMaPhanLoai(maPhanLoai);
        setPhanLoai(phanLoai);
    }

    // Copy constructor
    public PhanLoai(PhanLoai other) {
        this(other.maPhanLoai, other.phanLoai);
    }

    public String getMaPhanLoai() {
        return maPhanLoai;
    }

    public void setMaPhanLoai(String maPhanLoai) {
        // Kiểm tra và xử lý logic tạo mã PhanLoai theo quy luật
        // Phát sinh tự động
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        if (phanLoai != null && phanLoai.matches("^[A-Z][a-zA-Z ]+$")) {
            this.phanLoai = phanLoai;
        } else {
            throw new IllegalArgumentException("Phân loại không được rỗng nếu tham số phanLoai không hợp lệ");
        }
    }

    @Override
    public String toString() {
        return "PhanLoaiSanPham [maPhanLoai=" + maPhanLoai + ", phanLoai=" + phanLoai + "]";
    }
}

