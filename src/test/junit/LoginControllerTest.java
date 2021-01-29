package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.LoginBean;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;

class LoginControllerTest {

	@Test
	void loginTest() throws MyRuntimeException, SQLException, UserDoesNotExist {
		
		LoginController c = LoginController.getInstance();
		LoginBean bean = new LoginBean();
		bean.setUsername("ale95");
		bean.setPassword("ciao");
		c.setBean(bean);
		boolean result = c.findPlayerIdentity();
		assertTrue(result);
	}

}
