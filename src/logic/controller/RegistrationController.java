package logic.controller;

import java.sql.SQLException;

import logic.bean.RegistrationBean;
import logic.dao.EventOrganizerDAO;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;
import logic.model.Player;

public class RegistrationController {
	
	private static RegistrationController inst;
	private LoginController logc = LoginController.getInstance();
    private Player player;

    
    private RegistrationBean bean = new RegistrationBean();
    
    private RegistrationController(){
    	//private constr
    }

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
	
	public void insertNewPlayer(RegistrationBean bean) throws MyRuntimeException, SQLException {
		PlayerDAO.insertPlayer(bean);
		logc.setBeanFromReg(bean.getUsername());
	}
	
	public void insertNewOrganizer(RegistrationBean bean) throws MyRuntimeException, SQLException {
		EventOrganizerDAO.insertOrganizer(bean);
		logc.setBeanFromReg(bean.getUsername());
	}
}
