package logic.model;

import java.util.List;

public class HighscoreTable {
	
	//attributes
	private int htid;
	private List<String> highscoreList;
	private String highscore;
	private String tournamentName;
	
	public HighscoreTable(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public HighscoreTable(int htid,List<String> highscoreList, String tournamentName,String highscore)
	{
		this.setHtid(htid);
		this.setHighscoreList(highscoreList);
		this.setTournamentName(tournamentName);
		this.setHighscore(highscore);
	}
	
	//setter&getter
	public int getHtid() {
		return htid;
	}
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
	
	public void setHtid(int id) {
		this.htid = id;
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
