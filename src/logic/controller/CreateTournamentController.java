package logic.controller;

import java.sql.SQLException;

import logic.bean.LoginBean;
import logic.bean.TournamentBean;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class CreateTournamentController {
	
	private static CreateTournamentController inst;
	
	private TournamentBean bean = new TournamentBean();
	private LoginBean logBean = LoginController.getInstance().getBean();
	
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
		int id = 0;
		id = RoomDAO.getRoomIdFromOrgUsername(logBean.getUsername());
		TournamentDAO.insertTournament(bean,id);	
	}
	
}
