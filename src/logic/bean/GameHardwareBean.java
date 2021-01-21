package logic.bean;


public class GameHardwareBean {
	
	private String hardwareName;
	private String hardwareGenre;
	private int hardwareQuantity;
	private String hardwareDescription;
	private String gameGenre;
	private String gameDescription;
	private String gameName;
	private int gameQuantity;
	private Boolean hardwareAvailability;
	private Boolean gameAvailability;
	private String orgUserName;	
	
	
	

	public GameHardwareBean() {
		this.orgUserName= "";
		this.hardwareName = "";
		this.hardwareGenre = "";
		this.hardwareQuantity = 0;
		this.hardwareDescription = "";
		this.gameGenre = "";
		this.gameDescription = "";
		this.gameName = "";
		this.gameQuantity = 0;
	}
	
	
	public String getOrgUserName() {
		return orgUserName;
	}

	public void setOrgUserName(String orgUserName) {
		this.orgUserName = orgUserName;
	}
	
	
	
	public Boolean getHardwareAvailability() {
		return hardwareAvailability;
	}
	public Boolean getGameAvailability() {
		return gameAvailability;
	}
	public void setHardwareAvailability(Boolean hardwareAvailability) {
		this.hardwareAvailability = hardwareAvailability;
	}
	public void setGameAvailability(Boolean gameAvailability) {
		this.gameAvailability = gameAvailability;
	}
	public String getHardwareName() {
		return hardwareName;
	}
	public String getHardwareGenre() {
		return hardwareGenre;
	}
	public int getHardwareQuantity() {
		return hardwareQuantity;
	}
	public String getHardwareDescription() {
		return hardwareDescription;
	}
	public String getGameGenre() {
		return gameGenre;
	}
	public String getGameDescription() {
		return gameDescription;
	}
	public String getGameName() {
		return gameName;
	}
	public int getGameQuantity() {
		return gameQuantity;
	}
	public void setHardwareName(String hardwareName) {
		this.hardwareName = hardwareName;
	}
	public void setHardwareGenre(String hardwareGenre) {
		this.hardwareGenre = hardwareGenre;
	}
	public void setHardwareQuantity(int hardwareQuantity) {
		this.hardwareQuantity = hardwareQuantity;
	}
	public void setHardwareDescription(String hardwareDescription) {
		this.hardwareDescription = hardwareDescription;
	}
	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setGameQuantity(int gameQuantity) {
		this.gameQuantity = gameQuantity;
	}
	
	
}
