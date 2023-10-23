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
        // Kiểm tra và xử lý logic tạo mã XuatXu theo quy luật
        // Phát sinh tự động
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        if (xuatXu != null && xuatXu.matches("^[A-Z][a-zA-Z ]+$")) {
            this.xuatXu = xuatXu;
        } else {
            throw new IllegalArgumentException("Xuất xứ không được rỗng nếu tham số xuatXu không hợp lệ");
        }
    }

    @Override
    public String toString() {
        return "XuatXuSanPham [maXuatXu=" + maXuatXu + ", xuatXu=" + xuatXu + "]";
    }
}
