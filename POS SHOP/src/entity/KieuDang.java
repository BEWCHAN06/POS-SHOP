package entity;

public class KieuDang {
    private String maKieuDang;
    private String kieuDang;
	public KieuDang(String maKieuDang, String kieuDang) {
		super();
		this.maKieuDang = maKieuDang;
		this.kieuDang = kieuDang;
	}
	public KieuDang() {
		super();
		// TODO Auto-generated constructor stub
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
