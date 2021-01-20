package logic.bean;

public class ReservationBean {

	private int roomid;
	private int reservationStatus;
	private int numberOfPlayer;
	private String reservationRoom;
	private String playerUsername;
	private String date;
	private String hour;

	public ReservationBean() {
		//this is empty
	}

	public int getRoomid() {
		return roomid;
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

	public String getHour() {
		return hour;
	}

	public void setRoomid(int rsid) {
		this.roomid = rsid;
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
	
	public void setHour(String hour) {
		this.hour = hour;
	}	
	
}
