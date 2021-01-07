package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Hardware;

public class HardwareDAO {
	
	public Hardware getHardware(String username) throws MyRuntimeException {
		
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM hardware WHERE username=" + username);
			
			if(rs.next()) {
				return extractHardwareFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
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
