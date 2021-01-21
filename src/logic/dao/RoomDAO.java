package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.GameHardwareBean;
import logic.bean.RoomBean;
import logic.exception.MyRuntimeException;
import logic.model.Hardware;
import logic.model.Room;
import logic.model.VideoGame;

public class RoomDAO {
	
public static int getRoomId(String roomName, String location) throws MyRuntimeException, SQLException {
		
		Statement stmtR = null;
		Connection connR = null;
		try {
			connR= ConnectionFactory.getConnection();
			stmtR = connR.createStatement();
			ResultSet rs = stmtR.executeQuery("SELECT roomid FROM room WHERE roomname =" + roomName + " and location =" + location + ";");
			
			if(rs.next()) {
				return extractRoomIDFromResultSet(rs);
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
		return 0;
	}

public static int getRoomIdFromOrgUsername(String orgUserName) throws MyRuntimeException, SQLException {
	
	Statement stmtR = null;
	Connection connR = null;
	try {
		connR= ConnectionFactory.getConnection();
		stmtR = connR.createStatement();
		ResultSet rs = stmtR.executeQuery("SELECT roomid FROM organizer WHERE orgusername =" + orgUserName + ";");
		
		if(rs.next()) {
			return extractRoomIDFromResultSet(rs);
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
	return 0;
}




	
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
	
	public static ObservableList<RoomBean> getAllRoomsAvailable(String date, String hour, Integer nOP) throws MyRuntimeException, SQLException{
		
		PreparedStatement pStmtR = null;
		Connection connR = null;
		ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
		
		try {
			connR= ConnectionFactory.getConnection();
			pStmtR = connR.prepareStatement("SELECT * FROM room r WHERE numseat >= ? and NOT EXISTS (SELECT FROM reservation WHERE roomid = r.roomid and date = ? and hour = ?)");
			pStmtR.setInt(1, nOP);
			pStmtR.setString(2, date);
			pStmtR.setString(3, hour);
			ResultSet rs =  pStmtR.executeQuery();
		 	
			while(rs.next()) {
				RoomBean room = extractRoomBeanFromResultSet(rs);
				rooms.add(room);
				}
			
			pStmtR.close();
			connR.close();
			return rooms;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (pStmtR != null) {
				pStmtR.close();
			}
			if (connR != null) {
				connR.close();
            }
		}
		return rooms;
	}
	
public static ObservableList<RoomBean> getAllRoomsAvailableForHW(String date, String hour, int nOP,  String hwName) throws MyRuntimeException, SQLException{
		
		Statement stmtR = null;
		Connection connR = null;
		ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
		
		try {
			connR= ConnectionFactory.getConnection();
			stmtR = connR.createStatement();
			ResultSet rs = stmtR.executeQuery("SELECT * FROM room WHERE numseat = ?" + nOP);
			
			while(rs.next()) {
				RoomBean room = extractRoomBeanFromResultSet(rs);
				rooms.add(room);
			}
			
			stmtR.close();
			connR.close();
			return rooms;
			
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
		return rooms;
	}

public static ObservableList<RoomBean> getAllRoomsAvailableForVG(String date, String hour, int nOP, String vgName) throws MyRuntimeException, SQLException{
	
	Statement stmtR = null;
	Connection connR = null;
	ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
	
	try {
		connR= ConnectionFactory.getConnection();
		stmtR = connR.createStatement();
		ResultSet rs = stmtR.executeQuery("SELECT * FROM room WHERE numseat>=?" + nOP);
		
		while(rs.next()) {
			RoomBean room = extractRoomBeanFromResultSet(rs);
			rooms.add(room);
		}
		
		stmtR.close();
		connR.close();
		return rooms;
		
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
	return rooms;
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
				psR.setInt(2, room.getNumSeat());
				psR.setInt(3, room.getPrice());
				psR.setString(4, room.getLocation());
				psR.setString(5, room.getPhoto());
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
	
private static int extractRoomIDFromResultSet(ResultSet rs) throws MyRuntimeException, SQLException{
		
		int i = 0;
		
		i = rs.getInt("roomid");
		
		
		return i;
	}
	
private Room extractRoomFromResultSet(ResultSet rs) throws MyRuntimeException, SQLException{
		
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
		
		
		return room;
	}


public static Boolean  hardwareInfo(int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psR = null;
	Connection connR = null;
	GameHardwareBean  gh= new GameHardwareBean();

	try {
		connR= ConnectionFactory.getConnection();
		psR = connR.prepareStatement("INSERT INTO hardware VALUES (?,?,?,?,?)");
		psR.setString(1, gh.getHardwareName());
		psR.setInt(2, gh.getHardwareQuantity());
		psR.setString(3, gh.getHardwareDescription());
		psR.setString(4, gh.getHardwareGenre());
		psR.setInt(5, id);
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





public static Boolean gameInfo(int id) throws  MyRuntimeException,SQLException{
	
	PreparedStatement psR = null;
	Connection connR = null;
	GameHardwareBean  gh= new GameHardwareBean();
	
	try {
		connR= ConnectionFactory.getConnection();
		psR = connR.prepareStatement("INSERT INTO videogame VALUES (?,?,?,?,?)");
		psR.setString(1, gh.getGameName());
		psR.setString(2, gh.getGameGenre());
		psR.setInt(3, gh.getGameQuantity());
		psR.setString(4, gh.getGameDescription());
		psR.setInt(5, id);
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


}

