package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import logic.exception.MyRuntimeException;
import logic.model.Player;

public class PlayerDAO {
	
	public Player getPlayer(String username) throws MyRuntimeException, SQLException {
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn= ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM player WHERE username=" + username);
			
			if(rs.next()) {
				return extractPlayerFromResultSet(rs);
			}
			stmt.close();
			conn.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
            }
		}
		return null;
	}
	
	public Player getPlayerByUserNameAndPassword(String username, String password) throws MyRuntimeException, SQLException{
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			conn= ConnectionFactory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM player WHERE username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return extractPlayerFromResultSet(rs);
			}
			ps.close();
			conn.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
            }
		}
		return null;
	}
	
	public Set<Player> getAllPlayers() throws MyRuntimeException, SQLException{
		
		Statement stmt = null;
		Connection conn = null;
		try {
			conn= ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM player");
			
			Set<Player> players = new HashSet<>();
			
			while(rs.next()) {
				Player player = extractPlayerFromResultSet(rs);
				players.add(player);
			}
			
			stmt.close();
			conn.close();
			return players;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
            }
		}
		return new HashSet<>();
	}
	
	public boolean insertPlayer(Player player) throws MyRuntimeException, SQLException{
		
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			conn= ConnectionFactory.getConnection();
			ps = conn.prepareStatement("INSERT INTO player VALUES (NULL,?,?,?,?)");
			ps.setString(1, player.getFirstname());
			ps.setString(2, player.getLastname());
			ps.setString(3, player.getEmail());
			ps.setString(4, player.getPassword());
			int i = ps.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			ps.close();
			conn.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
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
