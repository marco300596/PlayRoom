package logic.model;

public class Poll {

	//attributes
	private String pollName;
	private String question;
	private String answer;
	private String tournamentName;
	
	public Poll(){
		// default constructor for dao impl
	}
		
	public Poll(String pollName, String question, String answer, String tournamentName) {
		this.setPollName(pollName);
		this.setQuestion(question);
		this.setAnswer(answer);
		this.setTournamentName(tournamentName);
	}

	//methods
	//setter&getter
	public String getPollName()
	{
		return pollName;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public String getTournamentName()
	{
		return tournamentName;
	}

	public void setPollName(String pollName)
	{
		this.pollName = pollName;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
	}
	
}
