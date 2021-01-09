package logic.dao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Hardware;
import logic.model.Room;
import logic.model.VideoGame;


public class RoomDAO {
	
	public Room getRoom(String roomName) throws MyRuntimeException, SQLException {
		
		Statement stmtR = null;
		Connection connR = null;
		try {
			connR= ConnectionFactory.getConnection();
			stmtR = connR.createStatement();
			ResultSet rs = stmtR.executeQuery("SELECT * FROM room WHERE roomName=" + roomName);
			
			if(rs.next()) {
				return extractRoomFromResultSet(rs);
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
	
public boolean insertRoom(Room room) throws MyRuntimeException, SQLException{
		
		PreparedStatement psR = null;
		Connection connR = null;
		
		try {
			connR= ConnectionFactory.getConnection();
			psR = connR.prepareStatement("INSERT INTO room VALUES (NULL,?,?,?,?,?,?)");
			psR.setInt(1, room.getNumSeat());
			psR.setInt(2, room.getPrice());
			psR.setString(3, room.getLocation());
			psR.setString(4, room.getPhoto());
			psR.setArray(5, (Array) room.getHw());
			psR.setArray(6, (Array) room.getVg());
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

