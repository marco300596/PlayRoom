package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.EventOrganizer;

public class EventOrganizerDAO {
	public EventOrganizer getOrganizer(String orgUsername) throws MyRuntimeException, SQLException {
		
		Statement stmtO = null;
		Connection connO = null;
		try {
			connO= ConnectionFactory.getConnection();
			stmtO = connO.createStatement();
			ResultSet rs = stmtO.executeQuery("SELECT * FROM organizer WHERE orgUsername=" + orgUsername);
			
			if(rs.next()) {
				return extractRatingFromResultSet(rs);
			}
			stmtO.close();
			connO.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtO != null) {
				stmtO.close();
			}
			if (connO != null) {
				connO.close();
            }
		}
		return null;
	}
	
public boolean insertOrganizer(EventOrganizer org) throws MyRuntimeException, SQLException{
		
		PreparedStatement psO = null;
		Connection connO = null;
		
		try {
			connO= ConnectionFactory.getConnection();
			psO = connO.prepareStatement("INSERT INTO organizer VALUES (NULL,?,?,?,?)");
			psO.setString(1, org.getOrgFirstname());
			psO.setString(2, org.getOrgLastname());
			psO.setString(3, org.getOrgEmail());
			psO.setString(4, org.getOrgOwnRoom());
			int i = psO.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psO.close();
			connO.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psO != null) {
				psO.close();
			}
			if (connO != null) {
				connO.close();
            }
		}
		return false;
	}
	
	private EventOrganizer extractRatingFromResultSet(ResultSet rs) throws SQLException{
		
		EventOrganizer org = new EventOrganizer();
		
		org.setOrgUsername(rs.getString("orgUsername"));
		org.setOrgFirstname(rs.getString("orgFirstname"));
		org.setOrgLastname(rs.getString("orgLastname"));
		org.setOrgEmail(rs.getString("orgEmail"));
		org.setOrgOwnRoom(rs.getString("orgOwnRoom"));
		
		return org;
	}
}
