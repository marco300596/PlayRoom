package logic.bean;

public class TournamentBean {
	
	private String tournamentName;
	private String tournamentRoom;
	private String tournamentGame;
	private String tournamentHardware;
	private int	tournamentPartecipants;


	public TournamentBean() {
		this.tournamentName = "";
		this.tournamentRoom = "";
		this.tournamentGame = "";
		this.tournamentHardware = "";
	}
	
	
	
	public TournamentBean(String tournamentName, String tournamentRoom, String tournamentGame,
			String tournamentHardware, int tournamentPartecipants) {
		this.tournamentName = tournamentName;
		this.tournamentRoom = tournamentRoom;
		this.tournamentGame = tournamentGame;
		this.tournamentHardware = tournamentHardware;
		this.tournamentPartecipants = tournamentPartecipants;
	}


	public String getTournamentName() {
		return tournamentName;
		
	}
	
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
		
	}
	
	
	public String getTournamentRoom() {
		return tournamentRoom;
		
	}
	
	public void setTournamentRoom(String tournamentRoom) {
		this.tournamentRoom = tournamentRoom;
		
	}
	
	
	public String getTournamentGame() {
		return tournamentGame;
		
	}
	
	public void setTournamentGame(String tournamentGame) {
		this.tournamentGame = tournamentGame;
		
	}
	
	public int getTournamentPartecipants() {
		return tournamentPartecipants;
		
	}
	
	public void setTournamentPartecipants(int tournamentPartecipants) {
		this.tournamentPartecipants = tournamentPartecipants;
		
	}
	
	public String getTournamentHardware() {
		return tournamentHardware;
		
	}
	
	
	
	public void setTournamentHardware(String tournamentHardware) {
		this.tournamentHardware = tournamentHardware;
		
	}
	
	
	
}
