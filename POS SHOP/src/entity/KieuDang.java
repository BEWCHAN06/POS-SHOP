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
        this.maKieuDang = maKieuDang;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    @Override
    public String toString() {
        return "KieuDang [maKieuDang=" + maKieuDang + ", kieuDang=" + kieuDang + "]";
    }
}
