package entity;

public class KieuDang {
    private String maKieuDang;
    private String kieuDang;

    public KieuDang() {
        // Constructor mặc nhiên
    }

    public KieuDang(String maKieuDang, String kieuDang) {
        setMaKieuDang(maKieuDang);
        setKieuDang(kieuDang);
    }

    // Copy constructor
    public KieuDang(KieuDang other) {
        this(other.maKieuDang, other.kieuDang);
    }

    public String getMaKieuDang() {
        return maKieuDang;
    }

    public void setMaKieuDang(String maKieuDang) {
        // Kiểm tra và xử lý logic tạo mã KieuDang theo quy luật
        // Phát sinh tự động
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        if (kieuDang != null && !kieuDang.isEmpty()) {
            this.kieuDang = kieuDang;
        } else {
            throw new IllegalArgumentException("Kiểu dáng không được rỗng");
        }
    }

    @Override
    public String toString() {
        return "KieuDang [maKieuDang=" + maKieuDang + ", kieuDang=" + kieuDang + "]";
    }
}
