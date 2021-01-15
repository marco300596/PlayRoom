package logic.bean;

import java.util.List;

import logic.model.Hardware;
import logic.model.VideoGame;

public class RoomBean {
		
	private String roomName;
	private List<String> freeHours;
	private int numSeat;
	private int price;
	private String location;
	private String photo;
	private String description;
	private List<VideoGame> vg;
	private List<Hardware>	hw;
	
	
	
	public RoomBean() {
		this.roomName = "";
		this.location="";
		this.photo="";
		this.description="";
		
	}
	
	public RoomBean(String roomName,List<String>freeHours, int numSeat,int price,String location,String photo,String description,List<VideoGame>vg,List<Hardware>hw) {
		this.roomName =roomName;
		this.freeHours = freeHours;
		this.numSeat=numSeat;
		this.price = price;
		this.location = location;
		this.photo = photo;
		this.description = description;
		this.vg = vg;
		this.hw = hw;
	}
	
	
	
	

	public String getRoomName() {
		return roomName;
		
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
		
	}
	
	public List<String> getFreeHours() {
		return freeHours;
		
	}
	
	public void setFreeHours(List<String> freeHours) {
		this.freeHours = freeHours;
		
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
		
	}
	
	

	
	
	
	
	
	
	
}
