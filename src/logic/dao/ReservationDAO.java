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
	
public static boolean insertReservation(ReservationBean reservation, int id, int status) throws MyRuntimeException, SQLException{
		
		PreparedStatement psRS = null;
		Connection connRes = null;
		
		try {
			connRes= ConnectionFactory.getConnection();
			psRS = connRes.prepareStatement("INSERT INTO reservation VALUES (?,?,?,?,?,?,?)");
			psRS.setInt(1,status);
			psRS.setInt(2, reservation.getNumberOfPlayer());
			psRS.setString(3, reservation.getPlayerUsername());
			psRS.setString(4,  reservation.getDate());
			psRS.setInt(5, id);
			psRS.setString(6, reservation.getHour());
			psRS.setString(7, reservation.getReservationRoom());
			
			
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
	
	Statement stmtPu = null;
	Connection connPu = null;
	ObservableList<ReservationBean> reservations = FXCollections.observableArrayList();
	
	try {
		connPu= ConnectionFactory.getConnection();
		stmtPu = connPu.createStatement();
		ResultSet rs = stmtPu.executeQuery("SELECT * FROM reservation WHERE reservationstatus = 0 and roomid=" + roomid +";");
		
		while(rs.next()) {
			ReservationBean reservation = extractReservationFromResultSet(rs);
			reservations.add(reservation);
		}
		
		stmtPu.close();
		connPu.close();
		return reservations;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (stmtPu != null) {
			stmtPu.close();
		}
		if (connPu != null) {
			connPu.close();
        }
	}
	return reservations;
}

public static ObservableList<ReservationBean> getAllCheckedReservations(int roomid) throws MyRuntimeException, SQLException{
	
	Statement stmtPc = null;
	Connection connPc = null;
	ObservableList<ReservationBean> reservations = FXCollections.observableArrayList();
	
	try {
		connPc = ConnectionFactory.getConnection();
		stmtPc = connPc.createStatement();
		ResultSet rs = stmtPc.executeQuery("SELECT * FROM reservation WHERE reservationstatus = 1 and roomid="+roomid+";");
		
		while(rs.next()) {
			ReservationBean reservation = extractReservationFromResultSet(rs);
			reservations.add(reservation);
		}
		
		stmtPc.close();
		connPc.close();
		return reservations;
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	finally {
		if (stmtPc != null) {
			stmtPc.close();
		}
		if (connPc != null) {
			connPc.close();
        }
	}
	return reservations;
}

public static ObservableList<ReservationBean> getAllCheckedPlayerReservations(String username) throws MyRuntimeException, SQLException{
	
	Connection connPc = null;
	
	Statement stmtPc = null;
	
	
	ObservableList<ReservationBean> reservations = FXCollections.observableArrayList();
	
	try {
		connPc = ConnectionFactory.getConnection();
		
		stmtPc = connPc.createStatement();
		ResultSet rs = stmtPc.executeQuery("SELECT * FROM reservation WHERE reservationstatus = 1 and playerusername='"+username+"';");
		
		while(rs.next()) {
			ReservationBean reservation = extractReservationFromResultSet(rs);
			reservations.add(reservation);
		}
		
		stmtPc.close();
		connPc.close();
		return reservations;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			if (stmtPc != null) {
			stmtPc.close();
			}
			if (connPc != null) {
				connPc.close();
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
