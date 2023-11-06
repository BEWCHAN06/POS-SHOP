package entity;

public class KichThuoc {
    private String maKichThuoc;
    private String kichThuoc;
	public KichThuoc(String maKichThuoc, String kichThuoc) {
		super();
		this.maKichThuoc = maKichThuoc;
		this.kichThuoc = kichThuoc;
	}
	public KichThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaKichThuoc() {
		return maKichThuoc;
	}
	public void setMaKichThuoc(String maKichThuoc) {
		this.maKichThuoc = maKichThuoc;
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
