package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.RegistrationBean;
import logic.bean.ReservationBean;
import logic.dao.PlayerDAO;
import logic.dao.ReservationDAO;
import logic.exception.MyRuntimeException;

public class CheckBookingController {
	private static CheckBookingController inst;
    
    private ObservableList<ReservationBean> beanList = FXCollections.observableArrayList();
    private ReservationBean regBean = new ReservationBean();

    /*singleton*/
	public static CheckBookingController getInstance() {

        if (inst == null)

            inst = new CheckBookingController();

        return inst;

    }
	


	public ObservableList<ReservationBean> getBeanList() {
		return beanList;
	}



	public void setBeanList(ObservableList<ReservationBean> beanList) {
		this.beanList = beanList;
	}



	public ReservationBean getRegBean() {
		return regBean;
	}



	public void setRegBean(ReservationBean regBean) {
		this.regBean = regBean;
	}



	public ObservableList<ReservationBean> updateReservation() throws MyRuntimeException, SQLException {
		this.beanList = ReservationDAO.getAllUncheckReservations();
		return this.beanList;
	}
	//TODO conferma la prenotazione 
	public boolean checkReservation(ReservationBean regBean) throws MyRuntimeException, SQLException {
		 return ReservationDAO.insertReservation(regBean);
	}
}
