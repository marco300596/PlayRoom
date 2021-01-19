package logic.bean;

public class VideoGameBean {
	
	private String gameName;
	private String genre;
	private Boolean availability;
	private int quantity;
	private String description;
	
	public VideoGameBean() {
		this.gameName = "";
	}

	
	public String getGameName() {
		return gameName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Boolean getAvailability() {
		return availability;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
