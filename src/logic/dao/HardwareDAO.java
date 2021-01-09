package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Hardware;


public class HardwareDAO {
	
	public Hardware getHardware(String hardwareName) throws MyRuntimeException, SQLException {
		
		Statement stmtH = null;
		Connection connH = null;
		try {
			connH= ConnectionFactory.getConnection();
			stmtH = connH.createStatement();
			ResultSet rs = stmtH.executeQuery("SELECT * FROM hardware WHERE hardwareName=" + hardwareName);
			
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
	
public boolean insertHardware(Hardware hardware) throws MyRuntimeException, SQLException{
		
		PreparedStatement psH = null;
		Connection connH = null;
		
		try {
			connH= ConnectionFactory.getConnection();
			psH = connH.prepareStatement("INSERT INTO room VALUES (NULL,?,?,?)");
			psH.setInt(1, hardware.getQuantity());
			psH.setInt(2, hardware.getAvailability());
			psH.setString(3, hardware.getDescription());
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
		hardware.setAvailability(rs.getInt("availability"));
		hardware.setDescription(rs.getString("description"));
		
		
		return hardware;
	}

}
