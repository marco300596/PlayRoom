package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.TournamentBean;
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
	
public static boolean checkAdehesion(String playerUN, String tournamentName) throws MyRuntimeException, SQLException{
		
		PreparedStatement psTm = null;
		Connection connT = null;
		
		try {
			connT= ConnectionFactory.getConnection();
			psTm = connT.prepareStatement("SELECT * FROM PLAYER WHERE username = ? and tournamentname = ?");
			psTm.setString(1, playerUN);
			psTm.setString(2, tournamentName);
			int i = psTm.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psTm.close();
			connT.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psTm != null) {
				psTm.close();
			}
			if (connT != null) {
				connT.close();
            }
		}
		return false;
	}
	
public static boolean insertTournament(TournamentBean tournament) throws MyRuntimeException, SQLException{
		
		PreparedStatement psT = null;
		Connection connTm = null;
		
		try {
			connTm= ConnectionFactory.getConnection();
			psT = connTm.prepareStatement("INSERT INTO tournament VALUES (?,?,?,?,?)");
			psT.setString(1, tournament.getTournamentName());
			psT.setString(2, tournament.getTournamentRoom());
			psT.setString(3, tournament.getTournamentGame());
			psT.setString(4, tournament.getTournamentHardware());
			psT.setInt(5, tournament.getTournamentPartecipants());
			int i = psT.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psT.close();
			connTm.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psT != null) {
				psT.close();
			}
			if (connTm != null) {
				connTm.close();
            }
		}
		return false;
	}


public static int getRoomIdFromCity(String city) throws MyRuntimeException, SQLException {
	
	Statement stmtT = null;
	Connection connT = null;
	try {
		connT= ConnectionFactory.getConnection();
		stmtT = connT.createStatement();
		ResultSet rs = stmtT.executeQuery("SELECT * FROM  tournament WHERE roomid IN (SELECT roomid FROM room WHERE city='" + city + "');" );
		
		if(rs.next()) {
			return extractRoomIDFromResultSet(rs);
			
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
	return 0;
}




	
	private static Tournament extractTournamentFromResultSet(ResultSet rs) throws SQLException{
		
		Tournament tournament = new Tournament();
		
		tournament.setTournamentName(rs.getString("tournamentName"));
		tournament.setTournamentRoom(rs.getString("tournamentRoom"));
		tournament.setTournamentGame(rs.getString("tournamentGame"));
		tournament.setTournamentHardware(rs.getString("tournamentHardware"));
		tournament.setTournamentPartecipants(rs.getInt("tournamentPartecipants"));
		
		return tournament;
	}
	
	
	
	
private static int extractRoomIDFromResultSet(ResultSet rs) throws SQLException{
		
		int i = 0;
		
		i = rs.getInt("roomid");
		
		
		return i;
	}
	
	
public static ObservableList<TournamentBean> getAllTournamentsAvailable(int roomid) throws MyRuntimeException, SQLException{
	
	Statement stmtP = null;
	Connection connP = null;
	ObservableList<TournamentBean> tournaments = FXCollections.observableArrayList();
	
	try {
		connP= ConnectionFactory.getConnection();
		stmtP = connP.createStatement();
		ResultSet rs = stmtP.executeQuery("SELECT * FROM tournament WHERE  roomid=" + roomid+ ";");
		
		while(rs.next()) {
			TournamentBean tournament = extractTournamentsFromResultSet(rs);
			tournaments.add(tournament);
		}
		
		stmtP.close();
		connP.close();
		return tournaments;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (stmtP != null) {
			stmtP.close();
		}
		if (connP != null) {
			connP.close();
        }
	}
	return tournaments;
}
	
	
	
private static TournamentBean extractTournamentsFromResultSet(ResultSet rs) throws SQLException{
	
	TournamentBean tournament = new TournamentBean();
	
	tournament.setTournamentName(rs.getString("tournamentName"));
	tournament.setTournamentRoom(rs.getString("tournamentRoom"));
	tournament.setTournamentGame(rs.getString("tournamentGame"));
	tournament.setTournamentHardware(rs.getString("tournamentHardware"));
	
	
	return tournament;
}
	
	
	
	
}
