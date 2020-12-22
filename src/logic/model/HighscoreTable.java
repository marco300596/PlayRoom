package logic.model;

import java.util.Vector;

public class HighscoreTable {
	
	private Vector<String> highscoreList;
	private String highscore;
	private String tournamentName;
	
	public Vector<String> getHighscoreList() {
		return highscoreList;
	}
	public void setHighscoreList(Vector<String> highscoreList) {
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
