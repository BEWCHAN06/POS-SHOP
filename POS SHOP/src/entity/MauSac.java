package entity;

public class MauSac {
    private String maMauSac;
    private String mauSac;

    public MauSac() {
        // Constructor mặc nhiên
    }

    public MauSac(String maMauSac, String mauSac) {
        setMaMauSac(maMauSac);
        setMauSac(mauSac);
    }

    // Copy constructor
    public MauSac(MauSac other) {
        this(other.maMauSac, other.mauSac);
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        // Kiểm tra và xử lý logic tạo mã MauSac theo quy luật
        // Phát sinh tự động
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        if (mauSac != null && !mauSac.isEmpty()) {
            this.mauSac = mauSac;
        } else {
            throw new IllegalArgumentException("Màu sắc không được rỗng nếu tham số mauSac không hợp lệ");
        }
    }

    @Override
    public String toString() {
        return "MauSac [maMauSac=" + maMauSac + ", mauSac=" + mauSac + "]";
    }
}

