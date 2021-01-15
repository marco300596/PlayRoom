package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.bean.RatingBean;
import logic.exception.MyRuntimeException;
import logic.model.Rating;

public class RatingDAO {
	
	public Rating getRating(String roomName) throws MyRuntimeException, SQLException {
		
		Statement stmtRt = null;
		Connection connRt = null;
		try {
			connRt= ConnectionFactory.getConnection();
			stmtRt = connRt.createStatement();
			ResultSet rs = stmtRt.executeQuery("SELECT * FROM rating WHERE roomName=" + roomName);
			
			if(rs.next()) {
				return extractRatingFromResultSet(rs);
			}
			stmtRt.close();
			connRt.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtRt != null) {
				stmtRt.close();
			}
			if (connRt != null) {
				connRt.close();
            }
		}
		return null;
	}
	
public static boolean insertRating(RatingBean rating) throws MyRuntimeException, SQLException{
		
		PreparedStatement psRt = null;
		Connection connRt = null;
		
		try {
			connRt= ConnectionFactory.getConnection();
			psRt = connRt.prepareStatement("INSERT INTO room VALUES (?,?,?)");
			psRt.setString(1, rating.getRoomName());
			psRt.setDouble(2, rating.getRate());
			psRt.setString(3, rating.getComment());
			int i = psRt.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psRt.close();
			connRt.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psRt != null) {
				psRt.close();
			}
			if (connRt != null) {
				connRt.close();
            }
		}
		return false;
	}
	
	private Rating extractRatingFromResultSet(ResultSet rs) throws SQLException{
		
		Rating rating = new Rating();
		
		rating.setRoomName(rs.getString("roomName"));
		rating.setRate(rs.getDouble("rate"));
		rating.setComment(rs.getString("comment"));
		
		
		return rating;
	}
}
