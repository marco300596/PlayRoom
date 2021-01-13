package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.Reservation;
import logic.exception.MyRuntimeException;

public class ReservationDAO {
	public Reservation getReservation(int rsid) throws MyRuntimeException, SQLException {
		
		Statement stmtRS = null;
		Connection connRS = null;
		try {
			connRS= ConnectionFactory.getConnection();
			stmtRS = connRS.createStatement();
			ResultSet rs = stmtRS.executeQuery("SELECT * FROM reservation WHERE rsid=" + rsid);
			
			if(rs.next()) {
				return extractReservationFromResultSet(rs);
			}
			stmtRS.close();
			connRS.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtRS != null) {
				stmtRS.close();
			}
			if (connRS != null) {
				connRS.close();
            }
		}
		return null;
	}
	
public boolean insertReservation(Reservation reservation) throws MyRuntimeException, SQLException{
		
		PreparedStatement psRS = null;
		Connection connRS = null;
		
		try {
			connRS= ConnectionFactory.getConnection();
			psRS = connRS.prepareStatement("INSERT INTO reservation VALUES (NULL,?,?,?,?,?)");
			psRS.setInt(1, reservation.getReservationStatus());
			psRS.setInt(2, reservation.getNumberOfPlayer());
			psRS.setString(3, reservation.getReservationRoom());
			psRS.setString(4, reservation.getPlayerUsername());
			psRS.setString(5,  reservation.getDate());
			
			int i = psRS.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psRS.close();
			connRS.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psRS != null) {
				psRS.close();
			}
			if (connRS != null) {
				connRS.close();
            }
		}
		return false;
	}
	
	private Reservation extractReservationFromResultSet(ResultSet rs) throws SQLException{
		
		Reservation reservation = new Reservation();
		
		reservation.setRsid(rs.getInt("rsid"));
		reservation.setReservationStatus(rs.getInt("reservationStatus"));
		reservation.setNumberOfPlayer(rs.getInt("numberOfPlayer"));
		reservation.setReservationRoom(rs.getString("reservationRoom"));
		reservation.setPlayerUsername(rs.getString("playerUsername"));
		reservation.setDate(rs.getString("date"));
		
		
		return reservation;
	}
}
