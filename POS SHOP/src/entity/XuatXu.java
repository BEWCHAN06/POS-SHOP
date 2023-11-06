package entity;

public class XuatXu {
    private String maXuatXu;
    private String xuatXu;
    
    
	public XuatXu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XuatXu(String maXuatXu, String xuatXu) {
		super();
		this.maXuatXu = maXuatXu;
		this.xuatXu = xuatXu;
	}
	public String getMaXuatXu() {
		return maXuatXu;
	}
	public void setMaXuatXu(String maXuatXu) {
		this.maXuatXu = maXuatXu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	@Override
	public String toString() {
		return "XuatXu [maXuatXu=" + maXuatXu + ", xuatXu=" + xuatXu + "]";
	}

    
}
