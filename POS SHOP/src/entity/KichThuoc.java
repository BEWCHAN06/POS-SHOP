package entity;

public class KichThuoc {
    private String maKichThuoc;
    private String kichThuoc;

    public KichThuoc() {
        // Constructor mặc nhiên
    }

    public KichThuoc(String maKichThuoc, String kichThuoc) {
        setMaKichThuoc(maKichThuoc);
        setKichThuoc(kichThuoc);
    }

    // Copy constructor
    public KichThuoc(KichThuoc other) {
        this(other.maKichThuoc, other.kichThuoc);
    }

    public String getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(String maKichThuoc) {
        // Kiểm tra và xử lý logic tạo mã KichThuoc theo quy luật
        // Phát sinh tự động
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    @Override
    public String toString() {
        return "KichThuoc [maKichThuoc=" + maKichThuoc + ", kichThuoc=" + kichThuoc + "]";
    }
}
