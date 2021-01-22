package logic.model;

public class Highscore {
	
	//attributes
	private int highscore;
	private String tournament;
	private String playerUN;
	private boolean hStatus;
	

	public Highscore(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Highscore(String tournament,int highscore, boolean hStatus)
	{
		this.setTournament(tournament);
		this.setHighscore(highscore);
		this.sethStatus(hStatus);
	}
	
	//setter&getter
	
	public int getHighscore()
	{
		return highscore;
	}

	public String getTournament()
	{
		return tournament;
	}
	
	public String getPlayerUserName()
	{
		return playerUN;
	}
	
	public boolean gethStatus() {
		return hStatus;
	}

	public void setHighscore(int highscore)
	{
		this.highscore = highscore;
	}

	public void setTournament(String tournament)
	{
		this.tournament = tournament;
	}
	
	public void setPlayerUserName(String username)
	{
		this.playerUN = username;
	}

	public void sethStatus(boolean hStatus) {
		this.hStatus = hStatus;
	}
}
