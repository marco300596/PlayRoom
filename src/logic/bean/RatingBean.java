package logic.bean;


public class RatingBean {
		
	private String roomName;
	private int	rate;
	private String comment;
	
	

	
	public RatingBean() {
		this.roomName = "";
		this.comment = "";
		
	}
	
	
	public RatingBean(String roomName, int rate, String comment) {
		this.roomName =roomName;
		this.rate = rate;
		this.comment = comment;
		
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
		this.roomName =roomName;
	}

	public void setRating(int rate) {
		this.rate = rate;
	}

	public void setComment(String comment) {
		this.comment =comment;
	}

	
	
}
