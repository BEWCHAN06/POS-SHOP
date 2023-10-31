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
        this.maChatLieu = maChatLieu;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    @Override
    public String toString() {
        return "ChatLieu [maChatLieu=" + maChatLieu + ", chatLieu=" + chatLieu + "]";
    }
}

