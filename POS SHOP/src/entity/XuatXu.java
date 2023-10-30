package entity;

public class XuatXu {
    private String maXuatXu;
    private String xuatXu;

    public XuatXu() {
        // Constructor mặc nhiên
    }

    public XuatXu(String maXuatXu, String xuatXu) {
        setMaXuatXu(maXuatXu);
        setXuatXu(xuatXu);
    }

    // Copy constructor
    public XuatXu(XuatXu other) {
        this(other.maXuatXu, other.xuatXu);
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
        return "XuatXuSanPham [maXuatXu=" + maXuatXu + ", xuatXu=" + xuatXu + "]";
    }
}
