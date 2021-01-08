package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Rating;

public class RatingDAO {
	
	public Rating getRating(String roomName) throws MyRuntimeException {
		
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
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
            	se.printStackTrace();
            }
            try {
            	if (conn != null)
            		conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
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
