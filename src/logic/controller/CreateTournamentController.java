package logic.controller;

import java.sql.SQLException;

import logic.bean.TournamentBean;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class CreateTournamentController {
	
	private static CreateTournamentController inst;
	
	private TournamentBean bean = new TournamentBean();
	
	public static CreateTournamentController getInstance() {
		if (inst == null) {
			inst = new CreateTournamentController();
		}
		return inst;
	}

	public TournamentBean getBean() {
		return bean;
	}

	public void setBean(TournamentBean bean) {
		this.bean = bean;
	}
	
	public void insertNewTournament(TournamentBean bean) throws MyRuntimeException, SQLException {
		
		TournamentDAO.insertTournament(bean);
		
	}
	
}
