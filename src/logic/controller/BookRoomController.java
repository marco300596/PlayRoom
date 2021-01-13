package logic.controller;

import java.sql.SQLException;

import logic.bean.ReservationBean;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.dao.ReservationDAO;
import logic.exception.MyRuntimeException;
import logic.model.Room;
import logic.model.Reservation;

public class BookRoomController {
	
	private static BookRoomController inst;

    private Room room;

    private ReservationBean bean = new ReservationBean();
    
    private RoomBean robean = new RoomBean();

	public static BookRoomController getInstance() {

        if (inst == null)

            inst = new BookRoomController();

        return inst;

    }
	
	public Room getRoom() {
		return room;
	}



	public ReservationBean getReservationBean() {
		return bean;
	}
	
	public RoomBean getRoomBean() {
		return robean;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	public void setReservationBean(ReservationBean bean) {
		this.bean = bean;
	}
	
	public void setRoomBean(RoomBean robean) {
		this.robean = robean;
	}
	
	
	public RoomBean findRoomForPreno() throws MyRuntimeException, SQLException{
		robean = RoomDAO.getRoomFromName(this.robean.getRoomName());
		return robean;
	}
}
