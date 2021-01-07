package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Rating;

public class RatingDAO {
	
	public Rating getRating(String roomName) throws MyRuntimeException {
		
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM rating WHERE roomName=" + roomName);
			
			if(rs.next()) {
				return extractRatingFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
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
