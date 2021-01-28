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
	
public static boolean insertReservation(ReservationBean reservation, int id) throws MyRuntimeException, SQLException{
		
		PreparedStatement psRS = null;
		Connection connRes = null;
		
		try {
			connRes= ConnectionFactory.getConnection();
			psRS = connRes.prepareStatement("INSERT INTO reservation VALUES (0,?,?,?,?,?,?)");
			psRS.setInt(1, reservation.getNumberOfPlayer());
			psRS.setString(2, reservation.getPlayerUsername());
			psRS.setString(3,  reservation.getDate());
			psRS.setInt(4, id);
			psRS.setString(5, reservation.getHour());
			psRS.setString(6, reservation.getReservationRoom());
			
			
			int i = psRS.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psRS.close();
			connRes.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psRS != null) {
				psRS.close();
			}
			if (connRes != null) {
				connRes.close();
            }
		}
		return false;
	}

public static ObservableList<ReservationBean> getAllUncheckReservations(int roomid) throws MyRuntimeException, SQLException{
	
	Statement stmtP = null;
	Connection connP = null;
	ObservableList<ReservationBean> reservations = FXCollections.observableArrayList();
	
	try {
		connP= ConnectionFactory.getConnection();
		stmtP = connP.createStatement();
		ResultSet rs = stmtP.executeQuery("SELECT * FROM reservation WHERE reservationstatus = 0 and roomid=" + roomid +";");
		
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

	public static boolean checkReservation(String player,String hour,String date) throws MyRuntimeException, SQLException {
		PreparedStatement psRes = null;
		Connection connRS = null;
		
		try {
			connRS= ConnectionFactory.getConnection();
			psRes = connRS.prepareStatement("UPDATE reservation SET reservationstatus=1 WHERE playerusername ='"+player+"' and hour='"+hour+"' and date='"+date+"'");
			int i = psRes.executeUpdate();
			
			if(i == 1) {
				return true;
			}
			psRes.close();
			connRS.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			if (psRes != null) {
				psRes.close();
			}
			if (connRS != null) {
				connRS.close();
            }
		}
		return false;
	}
	
	private static ReservationBean extractReservationFromResultSet(ResultSet rs) throws SQLException{
		
		ReservationBean reservation = new ReservationBean();
		
		reservation.setRoomid(rs.getInt("roomid"));
		reservation.setReservationStatus(rs.getInt("reservationstatus"));
		reservation.setNumberOfPlayer(rs.getInt("numberofplayer"));
		reservation.setReservationRoom(rs.getString("roomname"));
		reservation.setPlayerUsername(rs.getString("playerusername"));
		reservation.setDate(rs.getString("date"));
		reservation.setHour(rs.getString("hour"));
		
		
		return reservation;
	}
}
