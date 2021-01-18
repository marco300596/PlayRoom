package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private String roomName;
	private int numSeat;
	private int price;
	private String location;
	private String photo;
	private List<VideoGame> vg;
	private List<Hardware>	hw;
	public Room() {
		// default constructor for dao impl
	}
	
	
	public Room(String roomName, int numSeat, int price, String location, String photo) {
		this.setRoomName(roomName);
		this.setNumSeat(numSeat);
		this.setPrice(price);
		this.setLocation(location);
		this.setPhoto(photo);
		this.vg = new ArrayList<>();
		this.hw = new ArrayList<>();
	}

	public List<Hardware> getHw(){
		return hw;
		
	}
	public List<VideoGame> getVg() {
		return vg;
		
	}

	public String getRoomName()
	{
		return roomName;
		
	}
	
	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
		
	}
	
	
	public int getPrice()
	{
		return price;
		
	}
	
	public void setPrice(int price)
	{
		this.price = price;
		
	}

	public String getPhoto()
	{
		return photo;
		
	}
	
	public void setPhoto(String photo)
	{
		this.photo = photo;
		
	}
	
	
	
	public int getNumSeat()
	{
		return numSeat;
		
	}
	
	public void setNumSeat(int numSeat)
	{
		this.numSeat = numSeat;
		
	}
	
	
	public String getLocation()
	{
		return location;
		
	}
	
	public void setLocation(String location)
	{
		this.location = location;
		
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
}