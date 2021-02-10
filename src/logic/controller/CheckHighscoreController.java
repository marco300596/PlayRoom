package logic.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.bean.TournamentBean;
import logic.dao.HighscoreDAO;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.model.Highscore;

public class CheckHighscoreController {

	private static CheckHighscoreController inst;
	private HighscoreBean hibean = new HighscoreBean();
	private LoginController logc = LoginController.getInstance();
	
	private CheckHighscoreController() {
		//private constr
	}

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
		int i = RoomDAO.getRoomIdFromOrgUsername(logc.getBean().getUsername());
		ObservableList<TournamentBean> x = TournamentDAO.getAllTournamentsAvailable(i);
		ObservableList<HighscoreBean> hbol = FXCollections.observableArrayList();
		ArrayList<String> toru = new ArrayList<>();
		
		for(TournamentBean j : x) {

			toru.add(j.getTournamentName());
		}
		
		for(String s : toru) {
			hibean.setTournament(s);
			Highscore high = new Highscore(this.hibean.getTournament(), false);
			hbol.addAll(HighscoreDAO.showAllHighscoreForTournament(high));
		}
		
		return hbol;
	}
	
	public boolean confirmHighscore() throws MyRuntimeException, SQLException{
		
		try {
			if(logc.checkPlayer(this.hibean.getPlayerUN())) {
				Highscore high = new Highscore(this.hibean.getTournament(), this.hibean.getPlayerUN(), this.hibean.getHighscore());
				return HighscoreDAO.setHighscoreTrue(high);
			}
		}catch(UserDoesNotExist u){
			
			Logger.getLogger(CheckHighscoreController.class.getName()).log(Level.SEVERE, null, u);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "the User selected has been cancelled!","Attention!", JOptionPane.INFORMATION_MESSAGE)).start();
    		return false;
		}
		return false;
	}
	
}