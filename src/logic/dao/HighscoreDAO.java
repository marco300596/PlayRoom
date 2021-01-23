package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.exception.MyRuntimeException;
import logic.model.Highscore;

public class HighscoreDAO {
	public Highscore getHighscoreTable(int htid) throws MyRuntimeException, SQLException {
		
		Statement stmtHt = null;
		Connection connHt = null;
		try {
			connHt= ConnectionFactory.getConnection();
			stmtHt = connHt.createStatement();
			ResultSet rs = stmtHt.executeQuery("SELECT * FROM highscoreTable WHERE htid=" + htid);
			
			if(rs.next()) {
				return extractHighscoreFromResultSet(rs);
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
	
public static ObservableList<HighscoreBean> showAllHighscoreForTournament(String tournamentName) throws MyRuntimeException, SQLException {
	
	PreparedStatement pStmtH = null;
	Connection connH = null;
	ObservableList<HighscoreBean> highscores = FXCollections.observableArrayList();
	
	try {
		connH= ConnectionFactory.getConnection();
		pStmtH = connH.prepareStatement("SELECT * FROM highscore r WHERE tournamentname = ? and highscorestatus = ? ;");
		pStmtH.setString(1, tournamentName);
		pStmtH.setInt(1, 1);	
		ResultSet rs =  pStmtH.executeQuery();
	 	
		while(rs.next()) {
			HighscoreBean highscore = extracHighscoreBeanFromResultSet(rs);
			highscores.add(highscore);
			}
		
		pStmtH.close();
		connH.close();
		return highscores;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (pStmtH != null) {
			pStmtH.close();
		}
		if (connH != null) {
			connH.close();
        }
	}
	return highscores;
}
	
public static boolean insertHighscore(HighscoreBean hTable) throws MyRuntimeException, SQLException{
		
		PreparedStatement psHt = null;
		Connection connHt = null;
		
		try {
			connHt= ConnectionFactory.getConnection();
			psHt = connHt.prepareStatement("INSERT INTO highscore VALUES (0,?,?,?)");
			psHt.setInt(1, hTable.getHighscore());
			psHt.setString(2, hTable.getTournament());
			psHt.setString(3, hTable.getPlayerUN());
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
	
private Highscore extractHighscoreFromResultSet(ResultSet rs) throws SQLException{
		
		Highscore hTable = new Highscore();
		
		hTable.setTournament(rs.getString("tournamentName"));
		hTable.setScore(rs.getInt("highscore"));
		hTable.setPlayerUserName(rs.getString("username"));
		
		return hTable;
	}
	
private static HighscoreBean extracHighscoreBeanFromResultSet(ResultSet rs) throws SQLException{
		
		HighscoreBean highscore = new HighscoreBean();
		
		highscore.setPlayerUN(rs.getString("username"));
		highscore.setHighscore(rs.getInt("score"));
		
		
		return highscore;
	}
}
