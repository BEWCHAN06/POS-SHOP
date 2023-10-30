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
        this.maPhanLoai = maPhanLoai;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    @Override
    public String toString() {
        return "PhanLoaiSanPham [maPhanLoai=" + maPhanLoai + ", phanLoai=" + phanLoai + "]";
    }
}

