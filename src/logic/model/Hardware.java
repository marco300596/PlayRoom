package logic.model;

public class Hardware {

	private String hardwareName;
	private int quantity;
	private int availability;
	private String description;
	
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
	
	public void setAvaibility(int avaibility)
	{
		this.availability = avaibility;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
}

