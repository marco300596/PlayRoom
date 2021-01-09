package logic.dao;

import java.sql.Connection;
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
	
	private Hardware extractHardwareFromResultSet(ResultSet rs) throws SQLException{
		
		Hardware hardware = new Hardware();
		
		hardware.setHardwareName(rs.getString("hardwareName"));
		hardware.setQuantity(rs.getInt("quantity"));
		hardware.setAvailability(rs.getInt("availability"));
		
		
		return hardware;
	}

}
