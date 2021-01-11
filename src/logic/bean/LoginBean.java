package logic.bean;

public class LoginBean {

	private String password;
	private String username;
	
	
	public LoginBean() {
		
		this.password = "";
		this.username = "";
	}
	
	public void setUsername(String user) {
		
		this.username=user;
	}
	
	public String getUsername() {
		
		return username;
	}
	
	
	
	public void setPassword(String pwd) {
		
		this.password=pwd;	
	}
	
	
	public String getPassword() {
		
		return password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
