package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.ReservationBean;
import logic.bean.RoomBean;
import logic.bean.VideoGameBean;
import logic.bean.HardwareBean;
import logic.dao.RoomDAO;
import logic.dao.ReservationDAO;
import logic.exception.MyRuntimeException;

public class BookRoomController {
	
	private ObservableList<RoomBean> beanList = FXCollections.observableArrayList();
	private static BookRoomController inst;
    private ReservationBean bean = new ReservationBean();
    private RoomBean robean = new RoomBean();
    private VideoGameBean vgbean = new VideoGameBean();
    private HardwareBean hwbean = new HardwareBean();
	private LoginController logc = LoginController.getInstance();

	public static BookRoomController getInstance() {

        if (inst == null)

            inst = new BookRoomController();

        return inst;

    }
	
	public ReservationBean getReservationBean() {
		return bean;
	}
	
	public RoomBean getRoomBean() {
		return robean;
	}
	
	public VideoGameBean getVGBean() {
		return vgbean;
	}

	public HardwareBean getHWBean() {
		return hwbean;
	}

	public void setReservationBean(ReservationBean bean) {
		this.bean = bean;
	}
	
	public void setRoomBean(RoomBean robean) {
		this.robean = robean;
	}
	
	public void setVideoGameBean(VideoGameBean vgbean) {
		this.vgbean = vgbean;
	}
	
	public void setHardwareBean(HardwareBean hwbean) {
		this.hwbean = hwbean;
	}
	
	public ObservableList<RoomBean> findRoomForPreno() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailable(bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByHardware() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForHW(this.bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer(), this.hwbean.getHardwareName());
		return beanList;
	}
	
	public ObservableList<RoomBean> findRoomForPrenoByVideoGame() throws MyRuntimeException, SQLException{
		beanList = RoomDAO.getAllRoomsAvailableForVG(this.bean.getDate(), this.bean.getHour(), this.bean.getNumberOfPlayer(), this.vgbean.getGameName());
		return beanList;
	}
	
	public boolean createReservation() throws MyRuntimeException, SQLException{
		boolean chk ;
		this.bean.setPlayerUsername(logc.getBean().getUsername());
		chk = ReservationDAO.insertReservation(this.bean);
		return chk;
	}
}
