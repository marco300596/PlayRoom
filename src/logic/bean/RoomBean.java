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
	private String genre;
	private String quantity;
	private String hdescription;
	private String vdescription;
	private String gameName;
	private String hardwareName;
	

	
	
	// deleting arguments to fix smells.
	public RoomBean() {
		this.roomName = "";
		this.numSeat= 0;
		this.price = 0;
		this.location = "";
		this.photo = "";
		this.description = "";
		this.vg = null;
		this.hw = null;
	}
	
	
	public String getGameName() {
		return gameName;
	}

	public String getHardwareName() {
		return hardwareName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}
	
	public String getGenre() {
		return genre;
	}


	public String getQuantity() {
		return quantity;
	}


	public String getHdescription() {
		return hdescription;
	}


	public String getVdescription() {
		return vdescription;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public void setHdescription(String hdescription) {
		this.hdescription = hdescription;
	}


	public void setVdescription(String vdescription) {
		this.vdescription = vdescription;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
		
	}
	
	
	
}
