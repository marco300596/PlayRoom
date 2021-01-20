package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.ReservationBean;
import logic.exception.MyRuntimeException;

public class ReservationDAO {
	public ReservationBean getReservation(int rsid) throws MyRuntimeException, SQLException {
		
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
	
public static boolean insertReservation(ReservationBean reservation) throws MyRuntimeException, SQLException{
		
		PreparedStatement psRS = null;
		Connection connRS = null;
		
		try {
			connRS= ConnectionFactory.getConnection();
			psRS = connRS.prepareStatement("INSERT INTO reservation VALUES (1,?,?,?,?,?)");
			psRS.setInt(1, reservation.getNumberOfPlayer());
			psRS.setString(2, reservation.getReservationRoom());
			psRS.setString(3, reservation.getPlayerUsername());
			psRS.setString(4,  reservation.getDate());
			psRS.setString(5, reservation.getHour());
			
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

public static ObservableList<ReservationBean> getAllUncheckReservations() throws MyRuntimeException, SQLException{
	
	Statement stmtP = null;
	Connection connP = null;
	ObservableList<ReservationBean> reservations = FXCollections.observableArrayList();
	
	try {
		connP= ConnectionFactory.getConnection();
		stmtP = connP.createStatement();
		ResultSet rs = stmtP.executeQuery("SELECT * FROM reservation WHERE reservationstatus=0");
		
		while(rs.next()) {
			ReservationBean reservation = extractReservationFromResultSet(rs);
			reservations.add(reservation);
		}
		
		stmtP.close();
		connP.close();
		return reservations;
		
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
	return reservations;
}
	
	private static ReservationBean extractReservationFromResultSet(ResultSet rs) throws SQLException{
		
		ReservationBean reservation = new ReservationBean();
		
		reservation.setRoomid(rs.getInt("roomid"));
		reservation.setReservationStatus(rs.getInt("reservationstatus"));
		reservation.setNumberOfPlayer(rs.getInt("numberofplayer"));
		reservation.setReservationRoom(rs.getString("reservationroom"));
		reservation.setPlayerUsername(rs.getString("playerusername"));
		reservation.setDate(rs.getString("date"));
		reservation.setHour(rs.getString("hour"));
		
		
		return reservation;
	}
}
