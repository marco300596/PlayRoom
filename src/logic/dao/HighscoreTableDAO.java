package logic.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import logic.exception.MyRuntimeException;
import logic.model.HighscoreTable;

public class HighscoreTableDAO {
	public HighscoreTable getHighscoreTable(int htid) throws MyRuntimeException, SQLException {
		
		Statement stmtHt = null;
		Connection connHt = null;
		try {
			connHt= ConnectionFactory.getConnection();
			stmtHt = connHt.createStatement();
			ResultSet rs = stmtHt.executeQuery("SELECT * FROM highscoreTable WHERE htid=" + htid);
			
			if(rs.next()) {
				return extractHardwareFromResultSet(rs);
			}
			stmtHt.close();
			connHt.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtHt != null) {
				stmtHt.close();
			}
			if (connHt != null) {
				connHt.close();
            }
		}
		return null;
	}
	
public boolean insertHighscoreTable(HighscoreTable hTable) throws MyRuntimeException, SQLException{
		
		PreparedStatement psHt = null;
		Connection connHt = null;
		
		try {
			connHt= ConnectionFactory.getConnection();
			psHt = connHt.prepareStatement("INSERT INTO highscoreTable VALUES (NULL,?,?,?)");
			psHt.setArray(1,(Array) hTable.getHighscoreList());
			psHt.setString(2, hTable.getHighscore());
			psHt.setString(3, hTable.getTournamentName());
			int i = psHt.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psHt.close();
			connHt.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psHt != null) {
				psHt.close();
			}
			if (connHt != null) {
				connHt.close();
            }
		}
		return false;
	}
	
	private HighscoreTable extractHardwareFromResultSet(ResultSet rs) throws SQLException{
		
		HighscoreTable hTable = new HighscoreTable();
		
		hTable.setHtid(rs.getInt("htid"));
		hTable.setHighscoreList((List<String>)rs.getArray("highscoreList"));
		hTable.setTournamentName(rs.getString("tournamentName"));
		hTable.setHighscore(rs.getString("highscore"));
		
		
		return hTable;
	}
}
