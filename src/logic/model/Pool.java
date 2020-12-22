package logic.model;

public class Pool {

	//attributes
	private String poolName;
	private String question;
	private String answer;
	private String tournamentName;
	
	//methods
	//setter&getter
	public String getPoolName()
	{
		return poolName;
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

	public void setPoolName(String poolName)
	{
		this.poolName = poolName;
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
