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
		
		Statement stmtR = null;
		Connection connR = null;
		try {
			connR= ConnectionFactory.getConnection();
			stmtR = connR.createStatement();
			ResultSet rs = stmtR.executeQuery("SELECT * FROM videogame WHERE gameName=" + gameName);
			
			if(rs.next()) {
				return extractVideoGameFromResultSet(rs);
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
	
public boolean insertTournament(VideoGame videogame) throws MyRuntimeException, SQLException{
		
		PreparedStatement psR = null;
		Connection connR = null;
		
		try {
			connR= ConnectionFactory.getConnection();
			psR = connR.prepareStatement("INSERT INTO videogame VALUES (NULL,?,?,?,?)");
			psR.setString(1, videogame.getGameName());
			psR.setString(2, videogame.getGenre());
			psR.setBoolean(3, videogame.getAvailability());
			psR.setInt(4, videogame.getQuantity());
			psR.setString(5, videogame.getDescription());
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
