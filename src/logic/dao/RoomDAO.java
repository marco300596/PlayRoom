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
		
		PreparedStatement pStmtR = null;
		Connection connR = null;
		
		try {
			connR= ConnectionFactory.getConnection();
			pStmtR = connR.prepareStatement("SELECT roomid FROM public.room WHERE roomname= ? and location= ? ;");
			pStmtR.setString(1, roomName);
			pStmtR.setString(2, location);
			ResultSet rs =  pStmtR.executeQuery();
			
			if(rs.next()) {
				return extractRoomIDFromResultSet(rs);
			}
			pStmtR.close();
			connR.close();
			
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
		return 0;
	}

public static int getRoomIdFromOrgUsername(String orgUserName) throws MyRuntimeException, SQLException {
	
	Statement stmtR = null;
	Connection connR = null;
	try {
		connR= ConnectionFactory.getConnection();
		stmtR = connR.createStatement();
		ResultSet rs = stmtR.executeQuery("SELECT roomid FROM organizer WHERE orgusername ='" + orgUserName + "';");
		
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
	
	public static ObservableList<RoomBean> getAllRoomsAvailable(String date, String hour, Integer nOP, String city) throws MyRuntimeException, SQLException{
		
		PreparedStatement pStmtRm = null;
		Connection connR = null;
		ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
		
		try {
			connR= ConnectionFactory.getConnection();
			pStmtRm = connR.prepareStatement("SELECT * FROM room r WHERE city = ? and numseat >= ? and NOT EXISTS (SELECT FROM reservation WHERE roomid = r.roomid and date = ? and hour = ?)");
			pStmtRm.setString(1, city);
			pStmtRm.setInt(2, nOP);
			pStmtRm.setString(3, date);
			pStmtRm.setString(4, hour);
			ResultSet rs =  pStmtRm.executeQuery();
		 	
			while(rs.next()) {
				RoomBean room = extractRoomBeanFromResultSet(rs);
				rooms.add(room);
				}
			
			pStmtRm.close();
			connR.close();
			return rooms;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (pStmtRm != null) {
				pStmtRm.close();
			}
			if (connR != null) {
				connR.close();
            }
		}
		return rooms;
	}
	
public static ObservableList<RoomBean> getAllRoomsAvailableForHW(String date, String hour, int nOP,  String hwName, String city) throws MyRuntimeException, SQLException{
		
	PreparedStatement pStmtRh = null;
	Connection connR = null;
	ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
	
	try {
		connR= ConnectionFactory.getConnection();
		pStmtRh = connR.prepareStatement("SELECT * FROM room r WHERE city = ? and numseat >= ? and NOT EXISTS (SELECT FROM reservation WHERE roomid = r.roomid and date = ? and hour = ?) and EXISTS (SELECT FROM hardware WHERE hardwarename = ? and roomid = r.roomid);");
		pStmtRh.setString(1, city);
		pStmtRh.setInt(2, nOP);
		pStmtRh.setString(3, date);
		pStmtRh.setString(4, hour);
		pStmtRh.setString(5, hwName);
		
		ResultSet rs =  pStmtRh.executeQuery();
	 	
		while(rs.next()) {
			RoomBean room = extractRoomBeanFromResultSet(rs);
			rooms.add(room);
			}
		
		pStmtRh.close();
		connR.close();
		return rooms;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (pStmtRh != null) {
			pStmtRh.close();
		}
		if (connR != null) {
			connR.close();
        }
	}
	return rooms;
}

public static ObservableList<RoomBean> getAllRoomsAvailableForVG(String date, String hour, int nOP, String vgName, String city) throws MyRuntimeException, SQLException{
	
	PreparedStatement pStmtRv = null;
	Connection connR = null;
	ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
	
	try {
		connR= ConnectionFactory.getConnection();
		pStmtRv = connR.prepareStatement("SELECT * FROM room r WHERE city = ? and numseat >= ? and NOT EXISTS (SELECT FROM reservation WHERE roomid = r.roomid and date = ? and hour = ?) and EXISTS (SELECT FROM videogame WHERE gamename = ? and roomid = r.roomid);");
		pStmtRv.setString(1, city);
		pStmtRv.setInt(2, nOP);
		pStmtRv.setString(3, date);
		pStmtRv.setString(4, hour);
		pStmtRv.setString(5, vgName);
		ResultSet rs =  pStmtRv.executeQuery();
	 	
		while(rs.next()) {
			RoomBean room = extractRoomBeanFromResultSet(rs);
			rooms.add(room);
			}
		
		pStmtRv.close();
		connR.close();
		return rooms;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (pStmtRv != null) {
			pStmtRv.close();
		}
		if (connR != null) {
			connR.close();
        }
	}
	return rooms;
}

public static ObservableList<RoomBean> getAllRoomsAvailableForVGAndHW(String date, String hour, int nOP, String vgName,  String hwName, String city) throws MyRuntimeException, SQLException{
	
	PreparedStatement pStmtRvh = null;
	Connection connR = null;
	ObservableList<RoomBean> rooms = FXCollections.observableArrayList();
	
	try {
		connR= ConnectionFactory.getConnection();
		pStmtRvh = connR.prepareStatement("SELECT * FROM room r WHERE city = ? and numseat >= ? and NOT EXISTS (SELECT FROM reservation WHERE roomid = r.roomid and date = ? and hour = ?) and EXISTS (SELECT FROM hardware WHERE hardwarename = ? and roomid = r.roomid) and EXISTS (SELECT FROM videogame WHERE gamename = ? and roomid = r.roomid);");
		pStmtRvh.setString(1, city);
		pStmtRvh.setInt(2, nOP);
		pStmtRvh.setString(3, date);
		pStmtRvh.setString(4, hour);
		pStmtRvh.setString(5, hwName);
		pStmtRvh.setString(6, vgName);
		ResultSet rs =  pStmtRvh.executeQuery();
	 	
		while(rs.next()) {
			RoomBean room = extractRoomBeanFromResultSet(rs);
			rooms.add(room);
			}
		
		pStmtRvh.close();
		connR.close();
		return rooms;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (pStmtRvh != null) {
			pStmtRvh.close();
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
	
	public static boolean insertRoom(RoomBean room, int id) throws MyRuntimeException, SQLException{
		
			PreparedStatement psR = null;
			Connection connRm = null;
		
			try {
				connRm= ConnectionFactory.getConnection();
				psR = connRm.prepareStatement("INSERT INTO room VALUES (?,?,?,?,?,?,?)");
				psR.setString(1, room.getRoomName());
				psR.setInt(2, room.getNumSeat());
				psR.setInt(3, room.getPrice());
				psR.setString(4, room.getLocation());
				psR.setString(5, room.getPhoto());
				psR.setInt(6, id);
				psR.setString(7, room.getCity());
				int i = psR.executeUpdate();
				
				if(i == 1) {
					return true;
				}
				psR.close();
				connRm.close();
			
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			finally {
				if (psR != null) {
					psR.close();
				}
				if (connRm != null) {
					connRm.close();
            	}
			}
			return false;
		}
	
private static int extractRoomIDFromResultSet(ResultSet rs) throws SQLException{
		
		int i = 0;
		
		i = rs.getInt("roomid");
		
		
		return i;
	}
	
private Room extractRoomFromResultSet(ResultSet rs) throws  SQLException{
		
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
		room.setCity(rs.getString("city"));
		
		
		return room;
	}


public static Boolean  hardwareInfo(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psR = null;
	Connection connRh = null;

	try {
		connRh= ConnectionFactory.getConnection();
		psR = connRh.prepareStatement("INSERT INTO hardware VALUES (?,?,?,?,?)");
		psR.setString(1, gh.getHardwareName());
		psR.setInt(2, gh.getHardwareQuantity());
		psR.setString(3, gh.getHardwareGenre());
		psR.setString(4, gh.getHardwareDescription());
		psR.setInt(5, id);
		int i = psR.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psR.close();
		connRh.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psR != null) {
			psR.close();
		}
		if (connRh != null) {
			connRh.close();
    	}
	}
	return false;
	
}





public static Boolean gameInfo(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	
	PreparedStatement psR = null;
	Connection connRv = null;
	
	try {
		connRv= ConnectionFactory.getConnection();
		psR = connRv.prepareStatement("INSERT INTO videogame VALUES (?,?,?,?,?)");
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
		connRv.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psR != null) {
			psR.close();
		}
		if (connRv != null) {
			connRv.close();
    	}
	}
	return false;
	
}


}

