package entity;

public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String sdt;
    private String email;
    private String diaChi;

    public NhaCungCap() {
        // Constructor mặc nhiên
    }

    public NhaCungCap(String maNCC, String tenNCC, String sdt, String email, String diaChi) {
        setMaNCC(maNCC);
        setTenNCC(tenNCC);
        setSDT(sdt);
        setEmail(email);
        setDiaChi(diaChi);
    }

    // Copy constructor
    public NhaCungCap(NhaCungCap other) {
        this(other.maNCC, other.tenNCC, other.sdt, other.email, other.diaChi);
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        // Kiểm tra và xử lý logic tạo mã NCC theo quy luật
        // Phát sinh tự động
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        if (tenNCC != null && !tenNCC.isEmpty()) {
            this.tenNCC = tenNCC;
        } else {
            throw new IllegalArgumentException("Tên NCC không được rỗng nếu tham số tenNCC không hợp lệ");
        }
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        // Kiểm tra và xử lý logic kiểm tra SĐT
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Kiểm tra và xử lý logic kiểm tra Email
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        // Kiểm tra và xử lý logic kiểm tra địa chỉ
    }

    @Override
    public String toString() {
        return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", sdt=" + sdt + ", email=" + email + ", diaChi=" + diaChi + "]";
    }
}
