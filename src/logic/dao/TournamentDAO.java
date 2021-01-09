package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Tournament;


public class TournamentDAO {
public Tournament getTournament(String tournamentName) throws MyRuntimeException, SQLException {
		
		Statement stmtR = null;
		Connection connR = null;
		try {
			connR= ConnectionFactory.getConnection();
			stmtR = connR.createStatement();
			ResultSet rs = stmtR.executeQuery("SELECT * FROM tournament WHERE tournamentName=" + tournamentName);
			
			if(rs.next()) {
				return extractTournamentFromResultSet(rs);
			}
			stmtR.close();
			connR.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtR != null) {
				stmtR.close();
			}
			if (connR != null) {
				connR.close();
            }
		}
		return null;
	}
	
public boolean insertTournament(Tournament tournament) throws MyRuntimeException, SQLException{
		
		PreparedStatement psR = null;
		Connection connR = null;
		
		try {
			connR= ConnectionFactory.getConnection();
			psR = connR.prepareStatement("INSERT INTO tournament VALUES (NULL,?,?,?)");
			psR.setString(1, tournament.getTournamentName());
			psR.setString(2, tournament.getTournamentRoom());
			psR.setString(3, tournament.getTournamentGame());
			psR.setString(4, tournament.getTournamentHardware());
			int i = psR.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psR.close();
			connR.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psR != null) {
				psR.close();
			}
			if (connR != null) {
				connR.close();
            }
		}
		return false;
	}
	
	private Tournament extractTournamentFromResultSet(ResultSet rs) throws SQLException{
		
		Tournament tournament = new Tournament();
		
		tournament.setTournamentName(rs.getString("tournamentName"));
		tournament.setTournamentRoom(rs.getString("tournamentRoom"));
		tournament.setTournamentGame(rs.getString("tournamentGame"));
		tournament.setTournamentHardware(rs.getString("tournamentHardware"));
		
		return tournament;
	}
}
