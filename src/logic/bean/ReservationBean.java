package logic.bean;

public class ReservationBean {

	private int rsid;
	private int reservationStatus;
	private int numberOfPlayer;
	private String reservationRoom;
	private String playerUsername;
	private String date;
	
	
	
	public ReservationBean() {
		this.reservationRoom = "";
		this.playerUsername = "";
		this.date = "";
		
	}
	
	public ReservationBean(int rsid,int reservationStatus, int numberOfPlayer,String reservationRoom,String playerUsername,String date) {
		this.rsid =rsid;
		this.reservationStatus =reservationStatus;
		this.numberOfPlayer =numberOfPlayer;
		this.reservationRoom =reservationRoom;
		this.playerUsername =playerUsername;
		this.date=date;
		
	}
	

	public int getRsid() {
		return rsid;
		
	}
	
	
	public void setRsid(int rsid) {
		this.rsid = rsid;
		
	}

	public int getReservationStatus() {
		return reservationStatus;
		
	}
	
	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
		
	}

	public int getNumberOfPlayer() {
		return numberOfPlayer;
		
	}
	
	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
		
	}
	

	public String getReservationRoom() {
		return reservationRoom;
		
	}
	
	public void setReservationRoom(String reservationRoom) {
		this.reservationRoom = reservationRoom;
		
	}

	public String getPlayerUsername() {
		return playerUsername;
		
	}
	
	
	public void setPlayerUsername(String playerUsername) {
		this.playerUsername = playerUsername;
		
	}

	public String getDate() {
		return date;
		
	}



	public void setDate(String date) {
		this.date = date;
		
	}
	
	
}
