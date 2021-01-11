package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import logic.bean.LoginBean;
import logic.exception.MyRuntimeException;
import logic.model.Player;

public class PlayerDAO {
	
	public Player getPlayer(String username) throws MyRuntimeException, SQLException {
		
		Statement stmtP = null;
		Connection connP = null;
		try {
			connP= ConnectionFactory.getConnection();
			stmtP = connP.createStatement();
			ResultSet rs = stmtP.executeQuery("SELECT * FROM player WHERE username=" + username);
			
			if(rs.next()) {
				return extractPlayerFromResultSet(rs);
			}
			stmtP.close();
			connP.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtP != null) {
				stmtP.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return null;
	}
	
	public static LoginBean getPlayerByUserNameAndPassword(String username, String password) throws MyRuntimeException, SQLException{
		
		PreparedStatement psP = null;
		Connection connP = null;
		
		
		try {
			connP= ConnectionFactory.getConnection();
			psP = connP.prepareStatement("SELECT * FROM player WHERE username=? AND password=?");
			psP.setString(1, username);
			psP.setString(2, password);
			ResultSet rs = psP.executeQuery();
			
			if(rs.next()) {
				
				LoginBean player = new LoginBean();
				
				player.setUsername(rs.getString("username"));
				player.setPassword(rs.getString("password"));
				
				return player;
			}
			psP.close();
			connP.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psP != null) {
				psP.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return null;
	}
	
	public Set<Player> getAllPlayers() throws MyRuntimeException, SQLException{
		
		Statement stmtP = null;
		Connection connP = null;
		try {
			connP= ConnectionFactory.getConnection();
			stmtP = connP.createStatement();
			ResultSet rs = stmtP.executeQuery("SELECT * FROM player");
			
			Set<Player> players = new HashSet<>();
			
			while(rs.next()) {
				Player player = extractPlayerFromResultSet(rs);
				players.add(player);
			}
			
			stmtP.close();
			connP.close();
			return players;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtP != null) {
				stmtP.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return new HashSet<>();
	}
	
	public boolean insertPlayer(Player player) throws MyRuntimeException, SQLException{
		
		PreparedStatement psP = null;
		Connection connP = null;
		
		try {
			connP= ConnectionFactory.getConnection();
			psP = connP.prepareStatement("INSERT INTO player VALUES (NULL,?,?,?,?)");
			psP.setString(1, player.getFirstname());
			psP.setString(2, player.getLastname());
			psP.setString(3, player.getEmail());
			psP.setString(4, player.getPassword());
			int i = psP.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psP.close();
			connP.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psP != null) {
				psP.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return false;
	}
	
	public boolean deletePlayer(String username) throws MyRuntimeException, SQLException {
		
		Statement stmtP = null;
		Connection connP = null;
		try {
			connP= ConnectionFactory.getConnection();
			stmtP = connP.createStatement();
			int i = stmtP.executeUpdate("DELETE FROM player WHERE username=" + username);
			
			if (i == 1) {
				return true;
			}
			
			stmtP.close();
			connP.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtP != null) {
				stmtP.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return false;
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
