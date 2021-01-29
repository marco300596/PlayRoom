package logic.model;

public class Hardware {

	private String hardwareName;
	private String genre;
	private int quantity;
	private boolean availability;
	private String description;
	
	public Hardware(){
		// default constructor for dao impl
	}
	
	public Hardware(String hardwareName, int quantity, boolean availability, String description) {
		
		this.setHardwareName(hardwareName);
		this.setQuantity(quantity);
		this.setAvailability(availability);
		this.setDescription(description);
	}

	public String getHardwareName()
	{
		return hardwareName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getQuantity()
	{
		return quantity;
	}

	public boolean getAvailability() {
		return availability;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setHardwareName(String hardwareName)
	{
		this.hardwareName = hardwareName;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setAvailability(boolean availability)
	{
		this.availability = availability;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}

