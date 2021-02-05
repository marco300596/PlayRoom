package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.GameHardwareBean;
import logic.exception.MyRuntimeException;
import logic.model.Hardware;


public class HardwareDAO {
	

public static boolean  hardwareInfo(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psRhi = null;
	Connection connRhi = null;

	try {
		connRhi = ConnectionFactory.getConnection();
		psRhi = connRhi.prepareStatement("INSERT INTO hardware VALUES (?,?,?,?,?)");
		psRhi.setString(1, gh.getHardwareName());
		psRhi.setInt(2, gh.getHardwareQuantity());
		psRhi.setString(3, gh.getHardwareGenre());
		psRhi.setString(4, gh.getHardwareDescription());
		psRhi.setInt(5, id);
		int i = psRhi.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psRhi.close();
		connRhi.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psRhi != null) {
			psRhi.close();
		}
		if (connRhi != null) {
			connRhi.close();
    	}
	}
	return false;
	
}

public static Boolean  hardwareUpdate(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psRu = null;
	Connection connRhu = null;

	try {
		connRhu= ConnectionFactory.getConnection();
		psRu = connRhu.prepareStatement("UPDATE hardware SET quantity = quantity + 1 WHERE hardwarename =? and roomid=?");
		psRu.setString(1, gh.getHardwareName());
		psRu.setInt(2, id);
		int i = psRu.executeUpdate();
	
		if(i == 1) {
			return true;
		}
		psRu.close();
		connRhu.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psRu != null) {
			psRu.close();
		}
		if (connRhu != null) {
			connRhu.close();
    	}
	}
	return false;
	
}

public static boolean  hardwareCheck(GameHardwareBean gh, int id) throws  MyRuntimeException,SQLException{
	PreparedStatement psRc = null;
	Connection connRhc = null;

	try {
		connRhc= ConnectionFactory.getConnection();
		psRc = connRhc.prepareStatement("Select * FROM hardware WHERE roomid = ? and hardwarename=?");
		psRc.setInt(1, id);
		psRc.setString(2, gh.getHardwareName());
		ResultSet i = psRc.executeQuery();
	
		if(i !=null) {
			return true;
		}
		psRc.close();
		connRhc.close();
	
	}catch(SQLException ex){
		ex.printStackTrace();
	}
	finally {
		if (psRc != null) {
			psRc.close();
		}
		if (connRhc != null) {
			connRhc.close();
    	}
	}
	return false;
	
}
	
	public Hardware getHardware(String hardwareName, int id) throws MyRuntimeException, SQLException {
		
		Statement stmtH = null;
		Connection connH = null;
		try {
			connH= ConnectionFactory.getConnection();
			stmtH = connH.createStatement();
			ResultSet rs = stmtH.executeQuery("SELECT * FROM hardware WHERE hardwareName='" + hardwareName + "'roomid = " + id + ";");
			
			if(rs.next()) {
				return extractHardwareFromResultSet(rs);
			}
			stmtH.close();
			connH.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtH != null) {
				stmtH.close();
			}
			if (connH != null) {
				connH.close();
            }
		}
		return null;
	}
	
public static ObservableList<GameHardwareBean> getAllHardwareForRoom(int id) throws MyRuntimeException, SQLException {
		
		Statement stmtH = null;
		Connection connH = null;
		ObservableList<GameHardwareBean> hardwares = FXCollections.observableArrayList();
		try {
			connH= ConnectionFactory.getConnection();
			stmtH = connH.createStatement();
			ResultSet rs = stmtH.executeQuery("SELECT * FROM hardware WHERE roomid = " + id + ";");
			
			while(rs.next()) {
				GameHardwareBean hardware = extractHardwareBeanFromResultSet(rs);
				hardwares.add(hardware);
				}
			
			stmtH.close();
			connH.close();
			return hardwares;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtH != null) {
				stmtH.close();
			}
			if (connH != null) {
				connH.close();
            }
		}
		return hardwares;
	}
	
public boolean insertHardware(Hardware hardware, int id) throws MyRuntimeException, SQLException{
		
		PreparedStatement psH = null;
		Connection connH = null;
		
		try {
			connH= ConnectionFactory.getConnection();
			psH = connH.prepareStatement("INSERT INTO hardware VALUES (?,?,?,?)");
			psH.setInt(1, hardware.getQuantity());
			psH.setBoolean(2, hardware.getAvailability());
			psH.setString(3, hardware.getDescription());
			psH.setInt(4, id);
			int i = psH.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psH.close();
			connH.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psH != null) {
				psH.close();
			}
			if (connH != null) {
				connH.close();
            }
		}
		return false;
	}
	
	private Hardware extractHardwareFromResultSet(ResultSet rs) throws SQLException{
		
		Hardware hardware = new Hardware();
		
		hardware.setHardwareName(rs.getString("hardwareName"));
		hardware.setQuantity(rs.getInt("quantity"));
		hardware.setAvailability(rs.getBoolean("availability"));
		hardware.setDescription(rs.getString("description"));
		
		
		return hardware;
	}
	
private static GameHardwareBean extractHardwareBeanFromResultSet(ResultSet rs) throws SQLException{
		
		GameHardwareBean hardware = new GameHardwareBean();
		
		hardware.setHardwareName(rs.getString("hardwareName"));
		hardware.setHardwareGenre(rs.getString("hardwareGenre"));
		hardware.setHardwareQuantity(rs.getInt("hardwareQuantity"));
		
		return hardware;
	}

}
