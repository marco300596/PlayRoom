package logic.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import logic.bean.LoginBean;
import logic.dao.EventOrganizerDAO;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.model.Player;

public class LoginController {
	
	private static LoginController inst;

    private Player player;

    
    private LoginBean bean = new LoginBean();

    /*singleton*/
	public static LoginController getInstance() {

        if (inst == null)

            inst = new LoginController();

        return inst;

    }
	
	public Player getPlayer() {
		return player;
	}



	public LoginBean getBean() {
		return bean;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setBeanFromReg(String str) {
		bean.setUsername(str);
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}
	
	public boolean findPlayerIdentity() throws MyRuntimeException, SQLException, UserDoesNotExist{
		if (this.bean.getUsername().isEmpty() && this.bean.getPassword().isEmpty()) {
			return false;
		}
		this.bean = PlayerDAO.getPlayerByUserNameAndPassword(this.bean.getUsername(),this.bean.getPassword());
		if(this.bean.getUsername().isEmpty()) {
			 throw new UserDoesNotExist();
		}
		return !(this.bean.getUsername().isEmpty());
	}
	
	public boolean findOrgIdentity() throws MyRuntimeException, SQLException, UserDoesNotExist{
		if (this.bean.getUsername().isEmpty() && this.bean.getPassword().isEmpty()) {
			return false;
		}
		this.bean = EventOrganizerDAO.getOrgByUserNameAndPassword(this.bean.getUsername(),this.bean.getPassword());
		if(this.bean.getUsername().isEmpty()) {
			 throw new UserDoesNotExist();
		}
		return !(this.bean.getUsername().isEmpty());
	}
}
