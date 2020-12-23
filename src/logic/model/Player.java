package logic.model;

public class Player {
	
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	public Player(String firstname, String lastname, String email, String username, String password) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

}
