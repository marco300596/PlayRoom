package logic.model;

public class Reservation {
	private int reservationStatus;
	private String reservationRoom;
	private String playerUsername;
	private String organizerMail;
	
	public int getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
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
	public String getOrganizerMail() {
		return organizerMail;
	}
	public void setOrganizerMail(String organizerMail) {
		this.organizerMail = organizerMail;
	}
	
	
}
