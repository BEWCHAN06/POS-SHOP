package entity;

public class TaiKhoan {
    private String tenTaiKhoan;
    private String matKhau;
    private boolean loaiTaiKhoan;
    private NhanVien nhanVien;

    public TaiKhoan() {
        // Constructor mặc nhiên
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau, boolean loaiTaiKhoan, NhanVien nhanVien) {
        setTenTaiKhoan(tenTaiKhoan);
        setMatKhau(matKhau);
        setLoaiTaiKhoan(loaiTaiKhoan);
        setNhanVien(nhanVien);
    }

    // Copy constructor
    public TaiKhoan(TaiKhoan other) {
        this(other.tenTaiKhoan, other.matKhau, other.loaiTaiKhoan, other.nhanVien);
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        // Lấy theo mã nhân viên
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        if (matKhau.length() >= 4 && matKhau.length() <= 16) {
            this.matKhau = matKhau;
        } else {
            throw new IllegalArgumentException("Mật Khẩu phải có độ dài tối thiểu 4 kí tự và tối đa 16 kí tự");
        }
    }

    public boolean isLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(boolean loaiTaiKhoan) {
        // Kiểm tra và xử lý logic kiểm tra loaiTaiKhoan
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        // Kiểm tra và xử lý logic kiểm tra nhanVien
        this.nhanVien = nhanVien;
    }

    @Override
    public String toString() {
        return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", loaiTaiKhoan=" + loaiTaiKhoan + ", nhanVien=" + nhanVien + "]";
    }
}
