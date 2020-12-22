package logic.model;

import java.util.List;

public class HighscoreTable {
	
	//attributes
	private List<String> highscoreList;
	private String highscore;
	private String tournamentName;
	
	//methods
	//non-default constructor
	public HighscoreTable(List<String> highscoreList, String tournamentName)
	{
		this.setHighscoreList(highscoreList);
		this.setTournamentName(tournamentName);
	}
	
	//setter&getter
	public List<String> getHighscoreList()
	{
		return highscoreList;
	}
	
	public String getHighscore()
	{
		return highscore;
	}

	public String getTournamentName()
	{
		return tournamentName;
	}

	public void setHighscoreList(List<String> highscoreList)
	{
		this.highscoreList = highscoreList;
	}
	
	public void setHighscore(String highscore)
	{
		this.highscore = highscore;
	}

	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
	}
	
}
