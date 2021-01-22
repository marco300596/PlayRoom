package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.dao.HighscoreDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

public class SubmitHighscoreController {
	
	private static ObservableList<HighscoreBean> beanList = FXCollections.observableArrayList();
	private static SubmitHighscoreController inst;
    private static HighscoreBean bean = new HighscoreBean();
	public static SubmitHighscoreController getInstance() {

        if (inst == null)

            inst = new SubmitHighscoreController();

        return inst;

    }
	
	public HighscoreBean getHighscoreBean() {
		return bean;
	}
	
	public static boolean checkTournamentAdehesion() throws MyRuntimeException, SQLException {
		boolean res = TournamentDAO.checkAdehesion(bean.getPlayerUN(), bean.getTournament());
		return res;
	}
	
	public static ObservableList<HighscoreBean> submitHighscoreAndShow() throws MyRuntimeException, SQLException{
		HighscoreDAO.insertHighscore(bean);
		beanList = HighscoreDAO.showAllHighscoreForTournament(bean.getTournament());
		return beanList;
	}
}
