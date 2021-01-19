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
	private List<VideoGame> vg;
	private List<Hardware>	hw;
	private String hardwareName;
	private String hardwareGenre;
	private String hardwareQuantity;
	private String hardwareDescription;
	private String gameGenre;
	private String gameDescription;
	
	private String gameName;
	private String gameQuantity;
	
	

	
	
	// deleting arguments to fix smells.
	public RoomBean() {
		this.roomName = "";
		this.numSeat= 0;
		this.price = 0;
		this.location = "";
		this.photo = "";
		this.hardwareName = "";
		this.hardwareGenre = "";
		this.hardwareQuantity = "";
		this.hardwareDescription = "";
		this.gameName = "";
		this.gameGenre = "";
		this.gameQuantity = "";
		this.gameDescription = "";
		this.vg = null;
		this.hw = null;
	}
	
	public String getHardwareGenre() {
		return hardwareGenre;
	}


	public String getHardwareQuantity() {
		return hardwareQuantity;
	}


	public String getHardwareDescription() {
		return hardwareDescription;
	}


	public String getGameGenre() {
		return gameGenre;
	}


	public String getGameDescription() {
		return gameDescription;
	}


	public String getGameQuantity() {
		return gameQuantity;
	}


	public void setHardwareGenre(String hardwareGenre) {
		this.hardwareGenre = hardwareGenre;
	}


	public void setHardwareQuantity(String hardwareQuantity) {
		this.hardwareQuantity = hardwareQuantity;
	}


	public void setHardwareDescription(String hardwareDescription) {
		this.hardwareDescription = hardwareDescription;
	}


	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}


	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}


	public void setGameQuantity(String gameQuantity) {
		this.gameQuantity = gameQuantity;
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
