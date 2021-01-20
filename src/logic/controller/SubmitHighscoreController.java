package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;

public class SubmitHighscoreController {
	
	private ObservableList<HighscoreBean> beanList = FXCollections.observableArrayList();
	private static SubmitHighscoreController inst;
    private HighscoreBean bean = new HighscoreBean();
	public static SubmitHighscoreController getInstance() {

        if (inst == null)

            inst = new SubmitHighscoreController();

        return inst;

    }
	
	public HighscoreBean getHighscoreBean() {
		return bean;
	}
	
	public void setHighscoreBean(HighscoreBean bean) {
		this.bean = bean;
	}
	public static boolean checkTournamentAdehesion() {
		res = TournamentDAO.checkAdehesion(bean.getPlayerUN(), bean.getTournament());
		return res;
	}
	
	public ObservableList<HighscoreBean> submitHighscoreAndShow() throws MyRuntimeException, SQLException{
		HighscoreDAO.submitHighscore(bean.getHighscore(), bean.getPlayerUN(), bean.getTournament(), bean.setHStatus(false));
		beanList = HighscoreDAO.showHighscoreForTournament(bean.getTournament());
		return beanList;
	}
}
