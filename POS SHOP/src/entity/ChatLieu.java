package entity;

public class ChatLieu {
    private String maChatLieu;
    private String chatLieu;

    public ChatLieu() {
        // Constructor mặc nhiên
    }

    public ChatLieu(String maChatLieu, String chatLieu) {
        setMaChatLieu(maChatLieu);
        setChatLieu(chatLieu);
    }

    // Copy constructor
    public ChatLieu(ChatLieu other) {
        this(other.maChatLieu, other.chatLieu);
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        // Kiểm tra và xử lý logic tạo mã ChatLieu theo quy luật
        // Phát sinh tự động
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        if (chatLieu != null && !chatLieu.isEmpty()) {
            this.chatLieu = chatLieu;
        } else {
            throw new IllegalArgumentException("Chất liệu không được rỗng");
        }
    }

    @Override
    public String toString() {
        return "ChatLieu [maChatLieu=" + maChatLieu + ", chatLieu=" + chatLieu + "]";
    }
}

