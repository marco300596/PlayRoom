package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.RegistrationBean;
import logic.bean.ReservationBean;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.dao.ReservationDAO;
import logic.exception.MyRuntimeException;
import logic.model.Room;
import logic.model.Reservation;

public class BookRoomController {
	
	private ObservableList<RoomBean> beanList = FXCollections.observableArrayList();
	
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
	
	public ObservableList<RoomBean> findRoomForPreno() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailable(this.bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByHardware() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForHW(this.bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer(), this.hwbean.getHardwareName());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByVideoGame() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForVG(this.bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer(), this.vgbean.getVCideogameName());
		return beanList;
	}
	
	public boolean createReservation(String roomName, String date, String hour) throws MyRuntimeException, SQLException{
		boolean chk ;
		LoginController logc = LoginController.getInstance();
		this.bean.setPlayerUsername(logc.getBean().getUsername());
		chk = ReservationDAO.insertReservation(this.bean);
		return chk;
	}
}
