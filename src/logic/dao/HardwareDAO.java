package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Hardware;

public class HardwareDAO {
	
	public Hardware getHardware(String hardwareName) throws MyRuntimeException, SQLException {
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn= ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM hardware WHERE hardwareName=" + hardwareName);
			
			if(rs.next()) {
				return extractHardwareFromResultSet(rs);
			}
			stmt.close();
			conn.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
            if (stmt != null) 
            	stmt.close();
            if (conn != null) 
            	conn.close();
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
