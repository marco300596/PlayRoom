package logic.controller;

import java.sql.SQLException;

import logic.bean.LoginBean;
import logic.dao.EventOrganizerDAO;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;
import logic.model.Player;

public class LoginController {
	
	private static LoginController inst;

    private Player player;

    
    private static LoginBean bean = new LoginBean();

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
		LoginController.bean = bean;
	}
	
	public static boolean findPlayerIdentity() throws MyRuntimeException, SQLException{
		if (bean.getUsername().isEmpty() && bean.getPassword().isEmpty()) {
			return (bean.getUsername() == null);
		}
		bean = PlayerDAO.getPlayerByUserNameAndPassword(bean.getUsername(),bean.getPassword());
		return (bean.getUsername() != null);
		
	}
	
	public boolean findOrgIdentity() throws MyRuntimeException, SQLException{
		if (LoginController.bean.getUsername().isEmpty() && LoginController.bean.getPassword().isEmpty()) {
			return (LoginController.bean.getUsername() == null);
		}
		LoginController.bean = EventOrganizerDAO.getOrgByUserNameAndPassword(LoginController.bean.getUsername(),LoginController.bean.getPassword());
		return (LoginController.bean.getUsername() != null);
	}
}
