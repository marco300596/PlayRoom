package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import logic.bean.RoomBean;
import logic.bean.TournamentBean;

import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class JoinTournamentController {
	
	
	
	private static JoinTournamentController inst;
	private ObservableList<TournamentBean> beanList = FXCollections.observableArrayList();
	//private LoginController logc = LoginController.getInstance();
	private TournamentBean bean = new TournamentBean();
	private RoomBean rbean = new RoomBean();
	
	public static JoinTournamentController getInstance() {
		if (inst == null) {
			inst = new JoinTournamentController();
		}
		return inst;
	}

	public TournamentBean getBean() {
		return bean;
	}

	public RoomBean getrBean() {
		return rbean;
	}

	
	
	public void setBean(TournamentBean bean) {
		this.bean = bean;
	}
	
	public void setrBean(RoomBean rbean) {
		this.rbean = rbean;
	}
	
	
	public ObservableList<TournamentBean> getBeanList() {
		return beanList;
	}



	public void setBeanList(ObservableList<TournamentBean> beanList) {
		this.beanList = beanList;
	}
	
	
	
	/*public Boolean checkPlayerExistance() throws MyRuntimeException, SQLException{
		return PlayerDAO.checkPlayer(logc.getBean().getUsername());
	}*/
	
	
	
	public ObservableList<TournamentBean> joinTournament(RoomBean rbean) throws MyRuntimeException, SQLException  {
		
	
		this.beanList=TournamentDAO.getRoomIDbyCity(rbean.getCity());
		return this.beanList;
		
		
	}
	
}

