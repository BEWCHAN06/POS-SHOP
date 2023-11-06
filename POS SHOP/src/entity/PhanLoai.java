package entity;

public class PhanLoai {
    private String maPhanLoai;
    private String phanLoai;
	public PhanLoai(String maPhanLoai, String phanLoai) {
		super();
		this.maPhanLoai = maPhanLoai;
		this.phanLoai = phanLoai;
	}
	public PhanLoai() {
		super();
		// TODO Auto-generated constructor stub
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
		return "PhanLoai [maPhanLoai=" + maPhanLoai + ", phanLoai=" + phanLoai + "]";
	}

    
}

