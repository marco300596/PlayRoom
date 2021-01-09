package logic.model;

public class EventOrganizer {
	
	private String orgUsername;
	private String orgFirstname;
	private String orgLastname;
	private String orgEmail;
	private String orgOwnRoom;
	
	public EventOrganizer(){
		// default constructor for dao impl
	}
	
	public EventOrganizer(String orgUsername,String orgFirstname, String orgLastname, String orgEmail, String orgOwnRoom) {
		this.setOrgUsername(orgUsername);
		this.setOrgFirstname(orgFirstname);
		this.setOrgLastname(orgLastname);
		this.setOrgEmail(orgEmail);
		this.setOrgOwnRoom(orgOwnRoom);
	}
	
	public String getOrgUsername()
	{
		return orgUsername;
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
	
	public void setOrgUsername(String orgUsername)
	{
		this.orgUsername = orgUsername;
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
