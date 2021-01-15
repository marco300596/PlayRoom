package logic.bean;


public class RatingBean {
		
	private String roomName;
	private double	rate;
	private String comment;
	
	

	
	public RatingBean() {
		this.roomName = "";
		this.comment = "";
		
	}
	
	
	public RatingBean(String roomName, double rate, String comment) {
		this.roomName =roomName;
		this.rate = rate;
		this.comment = comment;
		
	}
	
	
	public String getRoomName() {
		return roomName;
		
	}
	
	public void setRoomName(String roomName) {
		this.roomName =roomName;
		
	}

	public double getRate() {
		return rate;
	
	}
	
	public void setRate(double rate) {
		this.rate = rate;
		
	}
	
	

	public String getComment() {
		return comment;
		
	}



	public void setComment(String comment) {
		this.comment =comment;
		
	}
	
	
}
