package logic.controller;

import java.sql.SQLException;

import logic.bean.TournamentBean;
import logic.dao.PlayerDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class JoinTournamentController {
	
	private static JoinTournamentController inst;
	private LoginController logc = LoginController.getInstance();
	private TournamentBean bean = new TournamentBean();
	
	public static JoinTournamentController getInstance() {
		if (inst == null) {
			inst = new JoinTournamentController();
		}
		return inst;
	}

	public TournamentBean getBean() {
		return bean;
	}

	public void setBean(TournamentBean bean) {
		this.bean = bean;
	}
	
	public Boolean CheckPlayerExistance() throws MyRuntimeException, SQLException{
		return PlayerDAO.checkPlayer(logc.getBean().getUsername());
	}
	
	public void JoinTournament(TournamentBean bean) throws MyRuntimeException, SQLException {
		
		TournamentDAO.joinTournament(bean);
		
	}
	
}

