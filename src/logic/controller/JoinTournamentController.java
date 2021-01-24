package logic.controller;

import java.sql.SQLException;

import logic.bean.RoomBean;
import logic.bean.TournamentBean;
import logic.dao.PlayerDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class JoinTournamentController {
	
	private static JoinTournamentController inst;
	private LoginController logc = LoginController.getInstance();
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
	
	
	
	/*public Boolean checkPlayerExistance() throws MyRuntimeException, SQLException{
		return PlayerDAO.checkPlayer(logc.getBean().getUsername());
	}*/
	
	
	
	public void joinTournament(TournamentBean bean,RoomBean rbean) throws MyRuntimeException, SQLException {
		
		TournamentDAO.getRoomIdFromCity(bean,rbean);
		
		
	}
	
}

