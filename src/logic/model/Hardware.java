package logic.model;

public class Hardware {

	private String hardwareName;
	private int quantity;
	private int availability;
	private String description;
	
	
	
	public Hardware(String hardwareName, int quantity, int availability, String description) {
		
		this.setHardwareName(hardwareName);
		this.setQuantity(quantity);
		this.setAvailability(availability);
		this.setDescription(description);
	}

	public String getHardwareName()
	{
		return hardwareName;
	}
	
	public int getQuantity()
	{
		return quantity;
	}

	public int getAvaibility() {
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
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setAvailability(int availability)
	{
		this.availability = availability;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}

