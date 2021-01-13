package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.bean.RoomBean;
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
			ResultSet rs = stmtR.executeQuery("SELECT * FROM room WHERE roomname=" + roomName);
			
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

public static RoomBean getRoomFromName(String roomName) throws MyRuntimeException, SQLException{
	PreparedStatement psR = null;
	Connection connR = null;
	
	
	try {
		connR= ConnectionFactory.getConnection();
		psR = connR.prepareStatement("SELECT * FROM room WHERE roomname=?");
		psR.setString(1, roomName);
		ResultSet rs = psR.executeQuery();
		
		if(rs.next()) {
			
			return extractRoomBeanFromResultSet(rs);
			
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
	return null;
}
	
public static boolean insertRoom(RoomBean room) throws MyRuntimeException, SQLException{
		
		PreparedStatement psR = null;
		Connection connR = null;
		
		try {
			connR= ConnectionFactory.getConnection();
			psR = connR.prepareStatement("INSERT INTO room VALUES (?,?,?,?,?,?,?)");
			psR.setString(1, room.getRoomName());
			psR.setInt(1, room.getNumSeat());
			psR.setInt(3, room.getPrice());
			psR.setString(4, room.getLocation());
			psR.setString(5, room.getPhoto());
			//psR.setArray(6, (Array) room.getHw());
			//psR.setArray(7, (Array) room.getVg());
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
		
		room.setRoomName(rs.getString("roomname"));
		room.setNumSeat(rs.getInt("numseat"));
		room.setPrice(rs.getInt("price"));
		room.setLocation(rs.getString("location"));
		room.setPhoto(rs.getString("photo"));
		room.addGame((VideoGame) rs.getArray("vg"));
		room.addHardware((Hardware) rs.getArray("hw"));
		
		
		return room;
	}
	
private static RoomBean extractRoomBeanFromResultSet(ResultSet rs) throws SQLException{
		
		RoomBean room = new RoomBean();
		
		room.setRoomName(rs.getString("roomname"));
		room.setNumSeat(rs.getInt("numseat"));
		room.setPrice(rs.getInt("price"));
		room.setLocation(rs.getString("location"));
		room.setPhoto(rs.getString("photo"));
		//room.addGame((VideoGame) rs.getArray("vg"));
		//room.addHardware((Hardware) rs.getArray("hw"));
		
		
		return room;
	}
}

