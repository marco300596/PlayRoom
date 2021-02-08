package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.LoginBean;
import logic.bean.ReservationBean;
import logic.dao.ReservationDAO;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;

public class CheckReservationController {
	
	private static CheckReservationController inst;
    
    private ObservableList<ReservationBean> beanList = FXCollections.observableArrayList();
    private ReservationBean resBean = new ReservationBean();
    private LoginBean logBean = LoginController.getInstance().getBean();

    /*singleton*/
	public static CheckReservationController getInstance() {

        if (inst == null)

            inst = new CheckReservationController();

        return inst;

    }
	


	public ObservableList<ReservationBean> getBeanList() {
		return beanList;
	}



	public void setBeanList(ObservableList<ReservationBean> beanList) {
		this.beanList = beanList;
	}



	public ReservationBean getResBean() {
		return resBean;
	}



	public void setResBean(ReservationBean resBean) {
		this.resBean = resBean;
	}
	
	public ObservableList<ReservationBean> updateReservation() throws MyRuntimeException, SQLException {
		int roomid;
		roomid = RoomDAO.getRoomIdFromOrgUsername(logBean.getUsername());
		this.beanList = ReservationDAO.getAllUncheckReservations(roomid);
		return this.beanList;
	}
	
	public ObservableList<ReservationBean> confirmed() throws MyRuntimeException, SQLException{
		
		int roomid;
		roomid = RoomDAO.getRoomIdFromOrgUsername(logBean.getUsername());
		this.beanList = ReservationDAO.getAllCheckedReservations(roomid);
		return this.beanList;
	}

	public boolean confirmReservation() throws MyRuntimeException, SQLException {
		 return ReservationDAO.checkReservation(resBean.getPlayerUsername(),resBean.getHour(),resBean.getDate());
	}
}
