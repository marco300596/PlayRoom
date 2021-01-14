package logic.controller;

import java.sql.SQLException;

import logic.bean.LoginBean;
import logic.bean.RegistrationBean;
import logic.dao.EventOrganizerDAO;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;
import logic.model.Player;

public class RegistrationController {
	
	private static RegistrationController inst;

    private Player player;

    
    private RegistrationBean bean = new RegistrationBean();

    /*singleton*/
	public static RegistrationController getInstance() {

        if (inst == null)

            inst = new RegistrationController();

        return inst;

    }
	
	public Player getPlayer() {
		return player;
	}



	public RegistrationBean getBean() {
		return bean;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}



	public void setBean(RegistrationBean bean) {
		this.bean = bean;
	}
	
	public boolean findPlayerIdentity() throws MyRuntimeException, SQLException{
		if (this.bean.getUsername().isEmpty() && this.bean.getPassword().isEmpty()) {
			return (this.bean.getUsername() == null);
		}
		this.bean = PlayerDAO.getPlayerByUserNameAndPassword(this.bean.getUsername(),this.bean.getPassword());
		return (this.bean.getUsername() != null);
		
	}
	
	public boolean findOrgIdentity() throws MyRuntimeException, SQLException{
		if (this.bean.getUsername().isEmpty() && this.bean.getPassword().isEmpty()) {
			return (this.bean.getUsername() == null);
		}
		this.bean = EventOrganizerDAO.getOrgByUserNameAndPassword(this.bean.getUsername(),this.bean.getPassword());
		return (this.bean.getUsername() != null);
	}
}
