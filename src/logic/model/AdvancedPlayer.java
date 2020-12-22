package logic.model;

public class AdvancedPlayer extends Player
{	
	//attribute
	private boolean isAdv;

	//method
	//non-default constructor
	public AdvancedPlayer(String firstname,	String lastname, String email, String username, String password, boolean isAdv)
	{
		super(firstname, lastname, email, username, password);
		isAdv = true;	
	}
	
	//setter&getter
	public boolean getisAdv()
	{
		return isAdv;
	}

	public void setAdv(boolean isAdv)
	{
		this.isAdv = isAdv;
	}
	
}