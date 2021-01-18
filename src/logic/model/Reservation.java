package logic.model;

public class Reservation 
{
	
	//attributes
	private int rsid;//usefull???
	private int reservationStatus;
	private int numberOfPlayer;
	private String reservationRoom;
	private String playerUsername;
	private String date;//replace with date??
	private String hour;
	


	public Reservation(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Reservation(int reservationStatus, int numberOfPlayer, String reservationRoom, String playerUsername, String date) 
	{
		this.setReservationStatus(reservationStatus);
		this.setNumberOfPlayer(numberOfPlayer);
		this.setReservationRoom(reservationRoom);
		this.setPlayerUsername(playerUsername);
		this.setDate(date);
	}
	
	//setter&getter
	public int getReservationStatus() 
	{
		return reservationStatus;
	}
	
	public int getRsid() {
		return rsid;
	}
	public int getNumberOfPlayer()
	{
		return numberOfPlayer;
	}
	
	public String getReservationRoom()
	{
		return reservationRoom;
	}

	public String getPlayerUsername()
	{
		return playerUsername;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void setReservationStatus(int reservationStatus)
	{
		this.reservationStatus = reservationStatus;
	}
	
	public void setNumberOfPlayer(int numberOfPlayer)
	{
		this.numberOfPlayer = numberOfPlayer;
	}
	
	public void setReservationRoom(String reservationRoom)
	{
		this.reservationRoom = reservationRoom;
	}
	
	public void setPlayerUsername(String playerUsername)
	{
		this.playerUsername = playerUsername;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setRsid(int rsid) {
		this.rsid = rsid;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
}
