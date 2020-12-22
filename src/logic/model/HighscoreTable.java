package logic.model;

import java.util.ArrayList;

public class HighscoreTable {
	
	private ArrayList<String> highscoreList;
	private String highscore;
	private String tournamentName;
	
	public ArrayList<String> getHighscoreList() {
		return highscoreList;
	}
	public void setHighscoreList(ArrayList<String> highscoreList) {
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
