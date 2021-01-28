package logic.model;

public class Highscore {
	
	//attributes
	private int score;
	private String tournament;
	private String playerUN;
	private boolean hStatus;
	

	public Highscore(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Highscore(String tournament,int score, boolean hStatus)
	{
		this.setTournament(tournament);
		this.setScore(score);
		this.sethStatus(hStatus);
	}
	
	public Highscore(String tournament, boolean hStatus) {
		this.tournament = tournament;
		this.hStatus = hStatus;
	}

	public Highscore(String tournament, String playerUN) {
		this.tournament = tournament;
		this.playerUN = playerUN;
	}

	//setter&getter
	
	public int getScore()
	{
		return score;
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

	public void setScore(int score)
	{
		this.score = score;
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
