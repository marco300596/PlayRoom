package logic.model;

import java.util.List;

public class HighscoreTable {
	
	private List<String> highscoreList;
	private String highscore;
	private String tournamentName;
	
	public List<String> getHighscoreList() {
		return highscoreList;
	}
	public void setHighscoreList(List<String> highscoreList) {
		this.highscoreList = highscoreList;
	}
	public String getHighscore() {
		return highscore;
	}
	public void setHighscore(String highscore) {
		this.highscore = highscore;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	
}
