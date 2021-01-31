package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.LoginBean;
import logic.bean.RegistrationBean;
import logic.exception.MyRuntimeException;


public class PlayerDAO {
	
	public static RegistrationBean getPlayer(String username) throws MyRuntimeException, SQLException {
		
		Statement stmtP = null;
		Connection connP = null;
		try {
			connP= ConnectionFactory.getConnection();
			stmtP = connP.createStatement();
			ResultSet rs = stmtP.executeQuery("SELECT * FROM player WHERE username = '" + username + "';");
			
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
		return new LoginBean();
	}
	/*mi serve per riempire la table in management*/
	public static ObservableList<RegistrationBean> getAllPlayers() throws MyRuntimeException, SQLException{
		
		Statement stmtP = null;
		Connection connP = null;
		ObservableList<RegistrationBean> players = FXCollections.observableArrayList();
		
		try {
			connP= ConnectionFactory.getConnection();
			stmtP = connP.createStatement();
			ResultSet rs = stmtP.executeQuery("SELECT * FROM player");
			
			while(rs.next()) {
				RegistrationBean player = extractPlayerFromResultSet(rs);
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
		return players;
	}
	
	public static boolean insertPlayer(RegistrationBean player) throws MyRuntimeException, SQLException{
		
		PreparedStatement psPl = null;
		Connection connP = null;
		
		try {
			connP= ConnectionFactory.getConnection();
			psPl = connP.prepareStatement("INSERT INTO player VALUES (?,?,?,?,?)");
			psPl.setString(1, player.getUsername());
			psPl.setString(2, player.getFirstname());
			psPl.setString(3, player.getLastname());
			psPl.setString(4, player.getEmail());
			psPl.setString(5, player.getPassword());
			int i = psPl.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psPl.close();
			connP.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psPl != null) {
				psPl.close();
			}
			if (connP != null) {
				connP.close();
            }
		}
		return false;
	}
	
	public static boolean deletePlayer(RegistrationBean player) throws MyRuntimeException, SQLException {
		
		PreparedStatement psP = null;
		Connection connPl = null;
		try {
			connPl= ConnectionFactory.getConnection();
			psP = connPl.prepareStatement("DELETE FROM player WHERE username=?");
			psP.setString(1, player.getUsername());
			int i = psP.executeUpdate();
			
			if (i == 1) {
				return true;
			}
			
			psP.close();
			connPl.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (psP != null) {
				psP.close();
			}
			if (connPl != null) {
				connPl.close();
            }
		}
		return false;
	}
	
	private static RegistrationBean extractPlayerFromResultSet(ResultSet rs) throws SQLException{
		RegistrationBean player = new RegistrationBean();
		
		player.setUsername(rs.getString("username"));
		player.setFirstname(rs.getString("firstname"));
		player.setLastname(rs.getString("lastname"));
		player.setEmail(rs.getString("email"));
		player.setPassword(rs.getString("password"));
		
		return player;
	}
}
