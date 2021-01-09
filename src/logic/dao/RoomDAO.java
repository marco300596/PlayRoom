package logic.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Hardware;
import logic.model.Room;
import logic.model.VideoGame;


public class RoomDAO {
	
	public Room getRoom(String roomName) throws MyRuntimeException, SQLException {
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn= ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM room WHERE roomName=" + roomName);
			
			if(rs.next()) {
				return extractRoomFromResultSet(rs);
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
	
	private Room extractRoomFromResultSet(ResultSet rs) throws SQLException{
		
		Room room = new Room();
		
		room.setRoomName(rs.getString("roomName"));
		room.setNumSeat(rs.getInt("numSeat"));
		room.setPrice(rs.getInt("price"));
		room.setLocation(rs.getString("location"));
		room.setPhoto(rs.getString("photo"));
		room.addGame((VideoGame) rs.getArray("vg"));
		room.addHardware((Hardware) rs.getArray("hw"));
		
		
		return room;
	}
}

