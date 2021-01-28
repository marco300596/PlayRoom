package logic.controller;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.dao.HighscoreDAO;
import logic.exception.MyRuntimeException;
import logic.model.Highscore;

public class CheckHighscoreController {

	private static CheckHighscoreController inst;
	private HighscoreBean hibean = new HighscoreBean();
	private LoginController logc = LoginController.getInstance();

	public static CheckHighscoreController getInstance() {

        if (inst == null)

            inst = new CheckHighscoreController();

        return inst;
	}
	
	public HighscoreBean getHighscoreBean() {
		return hibean;
	}

	public void setHighscoreBean(HighscoreBean bean) {
		this.hibean = bean;
	}
	
	public ObservableList<HighscoreBean> findPendingHighscoreForTournament() throws MyRuntimeException, SQLException{
		
		Highscore high = new Highscore(this.hibean.getTournament(), false);
		return HighscoreDAO.showAllHighscoreForTournament(high);
	}
	
	public boolean confirmHighscore() throws MyRuntimeException, SQLException{
		
		Highscore high = new Highscore(this.hibean);
		return HighscoreDAO.showAllHighscoreForTournament();
	}
	
}