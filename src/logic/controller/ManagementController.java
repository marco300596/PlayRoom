package logic.controller;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.RegistrationBean;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;

public class ManagementController {
	
	private static ManagementController inst;
    
    private ObservableList<RegistrationBean> beanList = FXCollections.observableArrayList();
    private RegistrationBean regBean = new RegistrationBean();

    /*singleton*/
	public static ManagementController getInstance() {

        if (inst == null)

            inst = new ManagementController();

        return inst;

    }
	


	public ObservableList<RegistrationBean> getBeanList() {
		return beanList;
	}



	public void setBeanList(ObservableList<RegistrationBean> beanList) {
		this.beanList = beanList;
	}



	public RegistrationBean getRegBean() {
		return regBean;
	}



	public void setRegBean(RegistrationBean regBean) {
		this.regBean = regBean;
	}



	public ObservableList<RegistrationBean> updatePlayers() throws MyRuntimeException, SQLException {
		this.beanList = PlayerDAO.getAllPlayers();
		return this.beanList;
	}
	
}
