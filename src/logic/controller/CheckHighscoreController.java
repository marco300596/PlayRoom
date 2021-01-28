package logic.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.HighscoreBean;
import logic.dao.HighscoreDAO;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.model.Highscore;
import logic.view.BookRoomViewController;

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
		
		try {
			
			logc.getBean().setUsername(this.hibean.getPlayerUN());
			if(logc.findPlayerIdentity()) {
				Highscore high = new Highscore(this.hibean.getTournament(), this.hibean.getPlayerUN());
				return HighscoreDAO.newHighscore(high);
			}
		}catch(UserDoesNotExist u){
			
			Logger.getLogger(CheckHighscoreController.class.getName()).log(Level.SEVERE, null, u);
    		new Thread(()-> JOptionPane.showMessageDialog(null, "the User selected has been cancelled!","Attention!", JOptionPane.INFORMATION_MESSAGE)).start();
    		return false;
		}
		return false;
	}
	
}