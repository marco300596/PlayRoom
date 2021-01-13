package logic.bean;



public class PollBean {
	
	private String pollName;
	private String question;
	private String tournamentName;
	
	
	public PollBean() {
		this.pollName = "";
		this.question = "";
		this.tournamentName = "";
		
	}
	
	public PollBean(String pollName,String question,String tournamentName) {
		this.pollName =pollName;
		this.question = question;
		this.tournamentName =tournamentName;
		
	}
	
	
	
	public void setPollName(String pollName) {
		
		this.pollName=pollName;
	}
	
	
	public void setQuestion(String question) {
		
		this.question=question;
	}
	
	
	public void setTournamentName(String tournamentName) {
	
	this.tournamentName=tournamentName;
}
	
	public String getPollName() {
		
		return pollName;
	}
	
	
	public String getQuestion() {
		
		return question;
	}
	
	public String getTournamentName() {
		
		return tournamentName;
	}
	
	
	
	
}
