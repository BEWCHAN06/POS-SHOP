package entity;

public class ChatLieu {
    private String maChatLieu;
    private String chatLieu;
	public ChatLieu(String maChatLieu, String chatLieu) {
		super();
		this.maChatLieu = maChatLieu;
		this.chatLieu = chatLieu;
	}
	public ChatLieu() {
		super();
		// TODO Auto-generated constructor stub
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

