package logic.model;

public class Tournament {
	
	//attributes
	private String tournamentName;
	private String tournamentRoom;
	private String tournamentGame;
	private String tournamentHardware;
	private int	tournamentPartecipants;
	
	public Tournament(){
		// default constructor for dao impl
	}
	
	//methods
	//non-default constructor
	public Tournament(String tournamentName, String tournamentRoom, String tournamentGame, String tournamentHardware,int tournamentPartecipants)
	{
		this.setTournamentName(tournamentName);
		this.setTournamentRoom(tournamentRoom);
		this.setTournamentGame(tournamentGame);
		this.setTournamentHardware(tournamentHardware);
		this.setTournamentPartecipants(tournamentPartecipants);
	}
	
	//setter&getter
	public String getTournamentName()
	{
		return tournamentName;
		
	}
	
	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
		
	}
	
	public String getTournamentGame()
	{
		return tournamentGame;
		
	}
	
	public void setTournamentGame(String tournamentGame)
	{
		this.tournamentGame = tournamentGame;
		
	}
	
	
	public String getTournamentHardware()
	{
		return tournamentHardware;
		
	}
	
	public void setTournamentHardware(String tournamentHardware)
	{
		this.tournamentHardware = tournamentHardware;
		
	}
	
	
	public int getTournamentPartecipants() {
		return tournamentPartecipants;
	}

	
	public void setTournamentPartecipants(int tournamentPartecipants) {
		this.tournamentPartecipants = tournamentPartecipants;
	}
	
	public String getTournamentRoom()
	{
		return tournamentRoom;
		
	}
	
	public void setTournamentRoom(String tournamentRoom)
	{
		this.tournamentRoom = tournamentRoom;
		
	}
	
}
