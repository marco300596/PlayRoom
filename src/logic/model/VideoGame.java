package logic.model;

public class VideoGame {
	private String nameGame;
	private String genre;
	private Boolean aivailability;
	private int quantity;
	private String description;
	
	public String getNameGame() {
		return nameGame;
	}
	public void setNameGame(String nameGame) {
		this.nameGame = nameGame;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getAivailability() {
		return aivailability;
	}
	public void setAivailability(Boolean aivailability) {
		this.aivailability = aivailability;
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
