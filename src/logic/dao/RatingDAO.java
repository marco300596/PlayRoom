package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Rating;

public class RatingDAO {
	
	public Rating getRating(String roomName) throws MyRuntimeException, SQLException {
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn= ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM rating WHERE roomName=" + roomName);
			
			if(rs.next()) {
				return extractRatingFromResultSet(rs);
			}
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
            }
		}
		return null;
	}
	
	private Rating extractRatingFromResultSet(ResultSet rs) throws SQLException{
		
		Rating rating = new Rating();
		
		rating.setRoomName(rs.getString("roomName"));
		rating.setRate(rs.getInt("rate"));
		rating.setComment(rs.getString("comment"));
		
		
		return rating;
	}
}
