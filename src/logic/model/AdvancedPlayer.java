package logic.model;

public class AdvancedPlayer extends Player
{	
	//attribute
	private boolean isAdv;

	//method
	//non-default constructor
	public AdvancedPlayer(String firstname,	String lastname, String email, String username, String password)
	{
		super(firstname, lastname, email, username, password);
		this.setAdv(true);	
	}

	public boolean isAdv() {
		return isAdv;
	}

	public void setAdv(boolean isAdv) {
		this.isAdv = isAdv;
	}
	
}