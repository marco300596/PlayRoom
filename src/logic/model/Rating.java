package logic.model;

public class Rating {
	
	private String roomName;
	private int	rate;
	private String comment;
	
	public Rating(String roomName, int rate, String comment) {
		
		this.setRoomName(roomName);
		this.setRate(rate);
		this.setComment(comment);
	}
	
	
	public String getRoomName() {
		return roomName;
	}
	public int getRate() {
		return rate;
	}
	public String getComment() {
		return comment;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
