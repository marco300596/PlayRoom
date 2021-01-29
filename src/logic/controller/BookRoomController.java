package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.GameHardwareBean;
import logic.bean.ReservationBean;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.dao.ReservationDAO;
import logic.exception.MyRuntimeException;

public class BookRoomController {
	
	private ObservableList<RoomBean> beanList = FXCollections.observableArrayList();
	private static BookRoomController inst;
    private ReservationBean bean = new ReservationBean();
    private RoomBean robean = new RoomBean();
	private LoginController logc = LoginController.getInstance();
	private GameHardwareBean ghbean = new GameHardwareBean();

	public static BookRoomController getInstance() {

        if (inst == null)

            inst = new BookRoomController();

        return inst;

    }
	
	public GameHardwareBean getGHBean() {
		return ghbean;
	}
	
	public ReservationBean getReservationBean() {
		return bean;
	}
	
	public RoomBean getRoomBean() {
		return robean;
	}

	public void setReservationBean(ReservationBean bean) {
		this.bean = bean;
	}
	
	public void setRoomBean(RoomBean robean) {
		this.robean = robean;
	}
	
	
	public ObservableList<RoomBean> findRoomForPreno() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailable(bean.getDate(), bean.getHour(), bean.getNumberOfPlayer(), bean.getCity());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByHardware() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForHW(bean.getDate(), bean.getHour(), bean.getNumberOfPlayer(), ghbean.getHardwareName(), bean.getCity());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByVideoGame() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForVG(bean.getDate(), bean.getHour(), bean.getNumberOfPlayer(), ghbean.getGameName(), bean.getCity());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByGameandHardware() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForVGAndHW(bean.getDate(), bean.getHour(), bean.getNumberOfPlayer(), ghbean.getGameName(), ghbean.getHardwareName(), bean.getCity());
		return beanList;
	}
	
	public boolean createReservation() throws MyRuntimeException, SQLException{
		boolean chk ;
		int id;
		int status = 0;
		this.bean.setPlayerUsername(logc.getBean().getUsername());
		id = RoomDAO.getRoomId(this.robean.getRoomName(), this.robean.getLocation());
		this.bean.setReservationRoom(this.robean.getRoomName());
		chk = ReservationDAO.insertReservation(this.bean, id, status);
		return chk;
		}
}
