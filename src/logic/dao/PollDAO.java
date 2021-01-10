package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Poll;

public class PollDAO {

public Poll getPoll(String pollname) throws MyRuntimeException, SQLException {
		
		Statement stmtPo = null;
		Connection connPo = null;
		try {
			connPo= ConnectionFactory.getConnection();
			stmtPo = connPo.createStatement();
			ResultSet rs = stmtPo.executeQuery("SELECT * FROM poll WHERE pollname=" + pollname);
			
			if(rs.next()) {
				return extractPollFromResultSet(rs);
			}
			stmtPo.close();
			connPo.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtPo != null) {
				stmtPo.close();
			}
			if (connPo != null) {
				connPo.close();
            }
		}
		return null;
	}
	public boolean insertPoll(Poll poll) throws MyRuntimeException, SQLException{
	
		PreparedStatement psPo = null;
		Connection connPo = null;
	
		try {
			connPo= ConnectionFactory.getConnection();
			psPo = connPo.prepareStatement("INSERT INTO poll VALUES (NULL,?,?,?)");
			psPo.setString(1, poll.getQuestion());
			psPo.setString(2, poll.getAnswer());
			psPo.setString(3, poll.getTournamentName());
			int i = psPo.executeUpdate();
		
			if(i == 1) {
				return true;
			}
			psPo.close();
			connPo.close();
		
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psPo != null) {
				psPo.close();
			}
			if (connPo != null) {
				connPo.close();
			}
		}
		return false;
	}
	
	public boolean deletePoll(String pollname) throws MyRuntimeException, SQLException {
		
		Statement stmtPo = null;
		Connection connPo = null;
		try {
			connPo = ConnectionFactory.getConnection();
			stmtPo = connPo.createStatement();
			int i = stmtPo.executeUpdate("DELETE FROM poll WHERE username=" + pollname);
			
			if (i == 1) {
				return true;
			}
			
			stmtPo.close();
			connPo.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtPo != null) {
				stmtPo.close();
			}
			if (connPo != null) {
				connPo.close();
            }
		}
		return false;
	}
	
	

	private Poll extractPollFromResultSet(ResultSet rs) throws SQLException{
	
		Poll poll = new Poll();
	
		poll.setPollName(rs.getString("pollName"));
		poll.setQuestion(rs.getString("question"));
		poll.setAnswer(rs.getString("answer"));
		poll.setTournamentName(rs.getString("tournamentName"));
	
	
		return poll;
	}
}