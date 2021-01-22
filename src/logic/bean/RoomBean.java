package logic.bean;

import java.util.List;

import logic.model.Hardware;
import logic.model.VideoGame;

public class RoomBean {
		
	private String roomName;
	private int numSeat;
	private int price;
	private String location;
	private String city;
	private String photo;
	private List<VideoGame> vg;
	private List<Hardware>	hw;
	private String Description;
	
	

	// deleting arguments to fix smells.
	public RoomBean() {
		this.roomName = "";
		this.numSeat= 0;
		this.price = 0;
		this.location = "";
		this.photo = "";
		this.vg = null;
		this.hw = null;
	}
	
	

	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
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
		this.numSeat =numSeat;
		
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
	
	
	
	public List<Hardware> getHw(){
		return hw;
		
	}
	
	public void addHardware(Hardware hardw) {
		this.hw.add(hardw);
		
	}
	
	public void removeHardware(Hardware hardw) {
		this.hw.remove(hardw);
		
	}
	
	public List<VideoGame> getVg(){
		return vg;
		
	}
	
	
	public void addGame(VideoGame vid) {
		this.vg.add(vid);
		
	}
	
	public void removeGame(VideoGame vid) {
		this.vg.remove(vid);
		
	}
	

	
}
