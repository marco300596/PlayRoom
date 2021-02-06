package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.bean.GameHardwareBean;
import logic.exception.MyRuntimeException;
import logic.model.VideoGame;

public class VideoGameDAO {
	

public static boolean  gameInfo(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psRgi = null;
	Connection connRgi = null;

	try {
		connRgi= ConnectionFactory.getConnection();
		psRgi = connRgi.prepareStatement("INSERT INTO videogame VALUES (?,?,?,?,?)");
		psRgi.setString(1, gh.getGameName());
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
		
		videogame.setGameName(rs.getString("gamename"));
		videogame.setGenre(rs.getString("genre"));
		videogame.setAvailability(rs.getBoolean("availability"));
		videogame.setQuantity(rs.getInt("quantity"));
		videogame.setDescription(rs.getString("description"));
		
		return videogame;
	}
	
	private static GameHardwareBean extractVideoGameBeanFromResultSet(ResultSet rs) throws SQLException{
		
		GameHardwareBean videogame = new GameHardwareBean();
		
		videogame.setGameName(rs.getString("gamename"));
		videogame.setGameGenre(rs.getString("genre"));
		videogame.setGameQuantity(rs.getInt("quantity"));
		
		return videogame;
	}
}
