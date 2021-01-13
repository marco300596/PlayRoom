package logic.bean;

import java.util.List;

import logic.model.Hardware;
import logic.model.VideoGame;

public class RoomBean {
		
	private String roomName;
	private int numSeat;
	private int price;
	private String location;
	private String photo;
	private String description;
	private List<VideoGame> vg;
	private List<Hardware>	hw;
	
	public RoomBean() {
		//this is empty
	}

	public String getRoomName() {
		return roomName;
	}

	public int getNumSeat() {
		return numSeat;
	}

	public int getPrice() {
		return price;
	}

	public String getLocation() {
		return location;
	}

	public String getPhoto() {
		return photo;
	}
	
	public List<Hardware> getHw(){
		return hw;
	}
	
	public List<VideoGame> getVg(){
		return vg;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setNumSeat(int numSeat) {
		this.numSeat =numSeat;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public void addHardware(Hardware hardw) {
		this.hw.add(hardw);
	}
	
	public void addGame(VideoGame vid) {
		this.vg.add(vid);
	}
	
	public void removeHardware(Hardware hardw) {
		this.hw.remove(hardw);
	}
	
	public void removeGame(VideoGame vid) {
		this.vg.remove(vid);
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
