package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.VideoGame;
public class VideoGameDAO {
	
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
			psV.setString(2, videogame.getGenre());
			psV.setBoolean(3, videogame.getAvailability());
			psV.setInt(4, videogame.getQuantity());
			psV.setString(5, videogame.getDescription());
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
}
