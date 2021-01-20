package logic.bean;

public class HighscoreBean {
	
	//attributes
	private String highscore;
	private String tournament;
	private boolean hStatus;
	private String playerUN;
	
	public HighscoreBean() {
		this.highscore = "";
		this.tournament = "";
		}

	public String getHighscore() {
		return highscore;
	}
	
	public String getTournament() {
		return tournament;
	}
	
	public boolean getHStatus() {
		return hStatus;
	}

	public String getPlayerUN() {
		return playerUN;
	}
		
	public void setHighscore(String highscore) {
		this.highscore = highscore;
	}
	
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	
	public void setHStatus(boolean hStatus) {
		this.hStatus = hStatus;
	}

	public void setPlayerUN(String playerUn) {
		playerUN = playerUn;
	}
	
	
	
}
