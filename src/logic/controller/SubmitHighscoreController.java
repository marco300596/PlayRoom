package logic.controller;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.dao.HighscoreDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;
import logic.model.Highscore;

public class SubmitHighscoreController {

	private static SubmitHighscoreController inst;
    private HighscoreBean bean = new HighscoreBean();
    private LoginController logc = LoginController.getInstance();
	ObservableList<HighscoreBean> highscores;
	
    public static SubmitHighscoreController getInstance() {

        if (inst == null)

            inst = new SubmitHighscoreController();

        return inst;

    }
	
	public HighscoreBean getHighscoreBean() {
		return bean;
	}
	
	public boolean checkTournamentAdehesion() throws MyRuntimeException, SQLException {		
		System.out.println(bean.getTournament() + "," + bean.getPlayerUN());
		return TournamentDAO.checkAdehesion(bean.getPlayerUN(), bean.getTournament());
	}
	
	public ObservableList<HighscoreBean> showHighscore() throws MyRuntimeException, SQLException{
		bean.setPlayerUN(logc.getBean().getUsername());
		bean.setTournament(TournamentDAO.getTournamentNameByPlayerUsername(bean.getPlayerUN()));
		System.out.println(bean.getTournament() + "," + bean.getPlayerUN());
		if (!(bean.getTournament().isEmpty())) {
			Highscore high = new Highscore(bean.getTournament(), true);
			highscores = HighscoreDAO.showAllHighscoreForTournament(high);
			return highscores;
		}else {
			return highscores;
		}
	}
	
	public ObservableList<HighscoreBean> submitHighscoreAndShow() throws MyRuntimeException, SQLException{

		HighscoreDAO.insertHighscore(bean);
		Highscore high = new Highscore(bean.getTournament(), true);
		return HighscoreDAO.showAllHighscoreForTournament(high);
	}
}
