package logic.model;

public class Room {
	
	private String roomName;
	private int numSeat;
	private int price;
	private String location;
	private String photo;
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getNumSeat() {
		return numSeat;
	}
	public void setNumSeat(int numSeat) {
		this.numSeat = numSeat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}