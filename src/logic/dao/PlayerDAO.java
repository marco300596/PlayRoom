package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.exception.MyRuntimeException;
import logic.model.Player;

public class PlayerDAO {
	
	public Player getPlayer(String username) throws MyRuntimeException {
		
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM player WHERE username=" + username);
			
			if(rs.next()) {
				return extractPlayerFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Player getPlayerByUserNameAndPassword(String username, String password) throws MyRuntimeException{
		
		Connection connection = ConnectionFactory.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM player WHERE username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return extractPlayerFromResultSet(rs);
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private Player extractPlayerFromResultSet(ResultSet rs) throws SQLException{
		Player player = new Player();
		
		player.setUsername(rs.getString("username"));
		player.setFirstname(rs.getString("firstname"));
		player.setLastname(rs.getString("lastname"));
		player.setEmail(rs.getString("email"));
		player.setPassword(rs.getString("password"));
		
		return player;
	}
}
