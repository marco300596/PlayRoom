package logic.model;

public class VideoGame {
	private String gameName;
	private String genre;
	private Boolean availability;
	private int quantity;
	private String description;
	
	public String getNameGame() {
		return gameName;
	}
	public void setNameGame(String nameGame) {
		this.gameName = nameGame;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
