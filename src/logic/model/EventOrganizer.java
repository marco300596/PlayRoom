package logic.model;

public class EventOrganizer {
	
	private String orgFirstname;
	private String orgLastname;
	private String orgEmail;
	private String orgOwnRoom;
	
	public String getOrgFirstname()
	{
		return orgFirstname;
	}
	
	public String getOrgLastname()
	{
		return orgLastname;
	}
	
	public String getOrgEmail()
	{
		return orgEmail;
	}
	
	public String getOrgOwnRoom()
	{
		return orgOwnRoom;
	}
	
	public void setOrgFirstname(String orgFirstname)
	{
		this.orgFirstname = orgFirstname;
	}
	
	public void setOrgLastname(String orgLastname)
	{
		this.orgLastname = orgLastname;
	}
	
	public void setOrgEmail(String orgEmail)
	{
		this.orgEmail = orgEmail;
	}
	public void setOrgOwnRoom(String orgOwnRoom)
	{
		this.orgOwnRoom = orgOwnRoom;
	}
	
	
}
