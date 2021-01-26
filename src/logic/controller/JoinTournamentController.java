package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.LoginBean;
import logic.bean.RoomBean;
import logic.bean.TournamentBean;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class JoinTournamentController {
	
	
	
	private static JoinTournamentController inst;
	private ObservableList<TournamentBean> beanList = FXCollections.observableArrayList();
	private TournamentBean bean = new TournamentBean();
	private RoomBean rbean = new RoomBean();
	private LoginBean logBean = LoginController.getInstance().getBean();
	
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
	
	
	public ObservableList<TournamentBean> searchTournament(RoomBean rbean) throws MyRuntimeException, SQLException  {
		
	
		this.beanList=TournamentDAO.getRoomIDbyCity(rbean.getCity());
		return this.beanList;
		
		
	}
	
	
	public void joinTournament(String tournamentName) throws MyRuntimeException, SQLException  {
		
		String playerus;
		playerus=logBean.getUsername();
		TournamentDAO.setTournamentNameByPlayerUsername(playerus,tournamentName);
		
		
		
	}
	
}

