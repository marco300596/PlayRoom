package logic.bean;

public class ReservationBean {

	private int rsid;
	private int reservationStatus;
	private int numberOfPlayer;
	private String reservationRoom;
	private String playerUsername;
	private String date;
	
	public ReservationBean() {
		//this is empty
	}

	public int getRsid() {
		return rsid;
	}

	public int getReservationStatus() {
		return reservationStatus;
	}

	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}

	public String getReservationRoom() {
		return reservationRoom;
	}

	public String getPlayerUsername() {
		return playerUsername;
	}

	public String getDate() {
		return date;
	}

	public void setRsid(int rsid) {
		this.rsid = rsid;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}

	public void setReservationRoom(String reservationRoom) {
		this.reservationRoom = reservationRoom;
	}

	public void setPlayerUsername(String playerUsername) {
		this.playerUsername = playerUsername;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
