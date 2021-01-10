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
		
		Statement stmtT = null;
		Connection connT = null;
		try {
			connT= ConnectionFactory.getConnection();
			stmtT = connT.createStatement();
			ResultSet rs = stmtT.executeQuery("SELECT * FROM tournament WHERE tournamentName=" + tournamentName);
			
			if(rs.next()) {
				return extractTournamentFromResultSet(rs);
			}
			stmtT.close();
			connT.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtT != null) {
				stmtT.close();
			}
			if (connT != null) {
				connT.close();
            }
		}
		return null;
	}
	
public boolean insertTournament(Tournament tournament) throws MyRuntimeException, SQLException{
		
		PreparedStatement psT = null;
		Connection connT = null;
		
		try {
			connT= ConnectionFactory.getConnection();
			psT = connT.prepareStatement("INSERT INTO tournament VALUES (NULL,?,?,?)");
			psT.setString(1, tournament.getTournamentRoom());
			psT.setString(2, tournament.getTournamentGame());
			psT.setString(3, tournament.getTournamentHardware());
			int i = psT.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psT.close();
			connT.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psT != null) {
				psT.close();
			}
			if (connT != null) {
				connT.close();
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
