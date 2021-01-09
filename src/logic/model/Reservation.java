package logic.model;

public class Reservation 
{
	
	//attributes
	private int rsid;
	

	

	private int reservationStatus;
	private int numberOfPlayer;
	private String reservationRoom;
	private String playerUsername;
	private String organizerMail;
	
	public Reservation(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Reservation(int reservationStatus, int numberOfPlayer, String reservationRoom, String playerUsername, String organizerMail) 
	{
		this.setReservationStatus(reservationStatus);
		this.setNumberOfPlayer(numberOfPlayer);
		this.setReservationRoom(reservationRoom);
		this.setPlayerUsername(playerUsername);
		this.setOrganizerMail(organizerMail);
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
	
	public String getOrganizerMail()
	{
		return organizerMail;
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
	
	public void setOrganizerMail(String organizerMail)
	{
		this.organizerMail = organizerMail;
	}
	
	public void setRsid(int rsid) {
		rsid = rsid;
	}
}
