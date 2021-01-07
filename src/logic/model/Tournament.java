package logic.model;

public class Tournament {
	
	//attributes
	private String tournamentName;
	private String tournamentRoom;
	private String tournamentGame;
	private String tournamentHardware;
	
	public Tournament(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Tournament(String tournamentName, String tournamentRoom, String tournamentGame, String tournamentHardware)
	{
		this.setTournamentName(tournamentName);
		this.setTournamentRoom(tournamentRoom);
		this.setTournamentGame(tournamentGame);
		this.setTournamentHardware(tournamentHardware);
	}
	
	//setter&getter
	public String getTournamentName()
	{
		return tournamentName;
	}
	
	public String getTournamentRoom()
	{
		return tournamentRoom;
	}
	
	public String getTournamentGame()
	{
		return tournamentGame;
	}
	
	public String getTournamentHardware()
	{
		return tournamentHardware;
	}
	
	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
	}
	
	public void setTournamentRoom(String tournamentRoom)
	{
		this.tournamentRoom = tournamentRoom;
	}
	
	public void setTournamentGame(String tournamentGame)
	{
		this.tournamentGame = tournamentGame;
	}
	
	public void setTournamentHardware(String tournamentHardware)
	{
		this.tournamentHardware = tournamentHardware;
	}
	
}
