package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
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
	
	
    private SubmitHighscoreController(){
    	//private constr
    }
    
    public static SubmitHighscoreController getInstance() {

        if (inst == null)

            inst = new SubmitHighscoreController();

        return inst;

    }
	
	public HighscoreBean getHighscoreBean() {
		return bean;
	}
	
	public boolean checkTournamentAdehesion() throws MyRuntimeException, SQLException {		
		return TournamentDAO.checkAdehesion(bean.getPlayerUN(), bean.getTournament());
	}
	
	public ObservableList<HighscoreBean> showHighscore() throws MyRuntimeException, SQLException{
		ObservableList<HighscoreBean> highscores = FXCollections.observableArrayList();
		bean.setPlayerUN(logc.getBean().getUsername());
		bean.setTournament(TournamentDAO.getTournamentNameByPlayerUsername(bean.getPlayerUN()));
		if (bean.getTournament()!=null) {
			Highscore high = new Highscore(bean.getTournament(), true);
			highscores = HighscoreDAO.showAllHighscoreForTournament(high);
			return highscores;
		}else {
			return highscores;
		}
	}
	
	public boolean submitHighscore() throws MyRuntimeException, SQLException{

		return HighscoreDAO.insertHighscore(bean);
		
	}
}
