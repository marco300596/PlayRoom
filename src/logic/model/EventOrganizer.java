package logic.model;

public class EventOrganizer {
	
	private String orgFirstname;
	private String orgLastname;
	private String orgEmail;
	private String orgOwnRoom;
	
	public EventOrganizer(String orgFirstname, String orgLastname, String orgEmail, String orgOwnRoom) {
		this.setOrgFirstname(orgFirstname);
		this.setOrgLastname(orgLastname);
		this.setOrgEmail(orgEmail);
		this.setOrgOwnRoom(orgOwnRoom);
	}

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
