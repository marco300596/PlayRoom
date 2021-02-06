package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.GameHardwareBean;
import logic.exception.MyRuntimeException;
import logic.model.VideoGame;

public class VideoGameDAO {
	
public static ObservableList<GameHardwareBean> getAllVideoGameForRoom(int id) throws MyRuntimeException, SQLException {
		
		Statement stmtH = null;
		Connection connH = null;
		ObservableList<GameHardwareBean> videoGames = FXCollections.observableArrayList();
		try {
			connH= ConnectionFactory.getConnection();
			stmtH = connH.createStatement();
			ResultSet rs = stmtH.executeQuery("SELECT * FROM videogame WHERE roomid = " + id + ";");
			
			while(rs.next()) {
				GameHardwareBean videoGame = extractVideoGameBeanFromResultSet(rs);
				videoGames.add(videoGame);
				}
			
			stmtH.close();
			connH.close();
			return videoGames;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtH != null) {
				stmtH.close();
			}
			if (connH != null) {
				connH.close();
            }
		}
		return videoGames;
	}

public static boolean  gameInfo(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psRgi = null;
	Connection connRgi = null;

	try {
		connRgi= ConnectionFactory.getConnection();
		psRgi = connRgi.prepareStatement("INSERT INTO videogame VALUES (?,?,?,?,?)");
		psRgi.setString(1, gh.getGameName());
		//System.out.println(gh.getGameQuantity());
		psRgi.setString(2, gh.getGameGenre());
		psRgi.setInt(3, gh.getGameQuantity());
		psRgi.setString(4, gh.getGameDescription());
		psRgi.setInt(5, id);
		int i = psRgi.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psRgi.close();
		connRgi.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psRgi != null) {
			psRgi.close();
		}
		if (connRgi != null) {
			connRgi.close();
    	}
	}
	return false;
	
}

public static boolean  gameUpdate(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psGu = null;
	Connection connGu = null;

	try {
		connGu= ConnectionFactory.getConnection();
		psGu = connGu.prepareStatement("UPDATE videogame SET quantity = quantity + 1 WHERE gamename =? and roomid=?");
		psGu.setString(1, gh.getGameName());
		psGu.setInt(2, id);
		int i = psGu.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psGu.close();
		connGu.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psGu != null) {
			psGu.close();
		}
		if (connGu != null) {
			connGu.close();
    	}
	}
	return false;
	
}

public static boolean  gameCheck(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psGc = null;
	Connection connGc = null;

	try {
		connGc= ConnectionFactory.getConnection();
		psGc = connGc.prepareStatement("Select * FROM videogame WHERE roomid = ? and gamename=?");
		psGc.setInt(1, id);
		psGc.setString(2, gh.getGameName());
		int i = psGc.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psGc.close();
		connGc.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psGc != null) {
			psGc.close();
		}
		if (connGc != null) {
			connGc.close();
    	}
	}
	return false;
	
}


	
	public VideoGame getVideoGame(String gameName) throws MyRuntimeException, SQLException {
		
		Statement stmtV = null;
		Connection connV = null;
		try {
			connV= ConnectionFactory.getConnection();
			stmtV = connV.createStatement();
			ResultSet rs = stmtV.executeQuery("SELECT * FROM videogame WHERE gameName=" + gameName);
			
			if(rs.next()) {
				return extractVideoGameFromResultSet(rs);
			}
			stmtV.close();
			connV.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtV != null) {
				stmtV.close();
			}
			if (connV != null) {
				connV.close();
            }
		}
		return null;
	}
	
public boolean insertVideoGame(VideoGame videogame) throws MyRuntimeException, SQLException{
		
		PreparedStatement psV = null;
		Connection connV = null;
		
		try {
			connV= ConnectionFactory.getConnection();
			psV = connV.prepareStatement("INSERT INTO videogame VALUES (NULL,?,?,?,?)");
			psV.setString(1, videogame.getGenre());
			psV.setBoolean(2, videogame.getAvailability());
			psV.setInt(3, videogame.getQuantity());
			psV.setString(4, videogame.getDescription());
			int i = psV.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psV.close();
			connV.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psV != null) {
				psV.close();
			}
			if (connV != null) {
				connV.close();
            }
		}
		return false;
	}
	
	private VideoGame extractVideoGameFromResultSet(ResultSet rs) throws SQLException{
		
		VideoGame videogame = new VideoGame();
		
		videogame.setGameName(rs.getString("gameName"));
		videogame.setGenre(rs.getString("genre"));
		videogame.setAvailability(rs.getBoolean("availability"));
		videogame.setQuantity(rs.getInt("quantity"));
		videogame.setDescription(rs.getString("description"));
		
		return videogame;
	}
	
	private static GameHardwareBean extractVideoGameBeanFromResultSet(ResultSet rs) throws SQLException{
		
		GameHardwareBean videogame = new GameHardwareBean();
		
		videogame.setGameName(rs.getString("gameName"));
		videogame.setGameGenre(rs.getString("gameGenre"));
		videogame.setGameQuantity(rs.getInt("gameQuantity"));
		
		return videogame;
	}
}
