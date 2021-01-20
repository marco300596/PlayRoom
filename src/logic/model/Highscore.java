package logic.model;

public class Highscore {
	
	//attributes
	private String best;
	private String highscore;
	private String tournament;
	private boolean hStatus;
	

	public Highscore(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Highscore(String best, String tournament,String highscore, boolean hStatus)
	{
		this.setBest(best);
		this.setTournament(tournament);
		this.setHighscore(highscore);
		this.sethStatus(hStatus);
	}
	
	//setter&getter
	public String getBest()
	{
		return best;
	}
	
	public String getHighscore()
	{
		return highscore;
	}

	public String getTournamentid()
	{
		return tournament;
	}
	
	public boolean gethStatus() {
		return hStatus;
	}

	public void setBest(String best)
	{
		this.best = best;
	}
	
	public void setHighscore(String highscore)
	{
		this.highscore = highscore;
	}

	public void setTournament(String tournament)
	{
		this.tournament = tournament;
	}

	public void sethStatus(boolean hStatus) {
		this.hStatus = hStatus;
	}
}
