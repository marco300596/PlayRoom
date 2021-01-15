package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.bean.LoginBean;
import logic.bean.RegistrationBean;
import logic.exception.MyRuntimeException;
import logic.model.EventOrganizer;

public class EventOrganizerDAO {
	public EventOrganizer getOrganizer(String orgUsername) throws MyRuntimeException, SQLException {
		
		Statement stmtO = null;
		Connection connO = null;
		try {
			connO= ConnectionFactory.getConnection();
			stmtO = connO.createStatement();
			ResultSet rs = stmtO.executeQuery("SELECT * FROM organizer WHERE orgusername=" + orgUsername);
			
			if(rs.next()) {
				return extractEventOrganizerFromResultSet(rs);
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
	
	public static LoginBean getOrgByUserNameAndPassword(String username, String password) throws MyRuntimeException, SQLException{
		
		PreparedStatement psO = null;
		Connection connO = null;
		
		
		try {
			connO= ConnectionFactory.getConnection();
			psO = connO.prepareStatement("SELECT * FROM organizer WHERE orgusername=? AND orgpassword=?");
			psO.setString(1, username);
			psO.setString(2, password);
			ResultSet rs = psO.executeQuery();
			
			if(rs.next()) {
				
				LoginBean eventOrganizer = new LoginBean();
				
				eventOrganizer.setUsername(rs.getString("orgUsername"));
				eventOrganizer.setPassword(rs.getString("orgPassword"));
				
				return eventOrganizer;
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
		return null;
	}
	
public static boolean insertOrganizer(RegistrationBean org) throws MyRuntimeException, SQLException{
		
		PreparedStatement psO = null;
		Connection connO = null;
		
		try {
			connO= ConnectionFactory.getConnection();
			psO = connO.prepareStatement("INSERT INTO organizer VALUES (?,?,?,?,?,?)");
			psO.setString(1, org.getOrgUsername());
			psO.setString(2, org.getOrgFirstname());
			psO.setString(3, org.getOrgLastname());
			psO.setString(4, org.getOrgPassword());
			psO.setString(5, org.getOrgEmail());
			psO.setString(6, org.getOrgOwnRoom());
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
	
	private EventOrganizer extractEventOrganizerFromResultSet(ResultSet rs) throws SQLException{
		
		EventOrganizer org = new EventOrganizer();
		
		org.setOrgUsername(rs.getString("orgUsername"));
		org.setOrgFirstname(rs.getString("orgFirstname"));
		org.setOrgLastname(rs.getString("orgLastname"));
		org.setOrgPassword(rs.getString("orgPassword"));
		org.setOrgEmail(rs.getString("orgEmail"));
		org.setOrgOwnRoom(rs.getString("orgOwnRoom"));
		
		return org;
	}
}
