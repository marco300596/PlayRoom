package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.dao.HighscoreDAO;
import logic.dao.PlayerDAO;
import logic.dao.TournamentDAO;
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
	/*public boolean checkPlayerExistance() throws MyRuntimeException, SQLException{
		return PlayerDAO.checkPlayer(bean.getPlayerUN());
	}*/
	
	public boolean checkTournamentAdehesion() throws MyRuntimeException, SQLException {
		return TournamentDAO.checkAdehesion(bean.getPlayerUN(), bean.getTournament());
	}
	
	public ObservableList<HighscoreBean> submitHighscoreAndShow() throws MyRuntimeException, SQLException{
		HighscoreDAO.insertHighscore(bean);
		beanList = HighscoreDAO.showAllHighscoreForTournament(bean.getTournament());
		return beanList;
	}
}
