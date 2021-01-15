package logic.model;

public class Rating {
	
	private String roomName;
	private double	rate;
	private String comment;
	
	public Rating(){
		// default constructor for dao impl
	}
	
	public Rating(String roomName, int rate, String comment) {
		
		this.setRoomName(roomName);
		this.setRate(rate);
		this.setComment(comment);
	}
	
	
	public String getRoomName() {
		return roomName;
	}
	public double getRate() {
		return rate;
	}
	public String getComment() {
		return comment;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
