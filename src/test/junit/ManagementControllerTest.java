package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import logic.bean.RegistrationBean;
import logic.controller.ManagementController;
import logic.dao.PlayerDAO;
import logic.exception.MyRuntimeException;


class ManagementControllerTest {
	//Alessandro Picco
	ManagementController controller = ManagementController.getInstance();
	RegistrationBean regBean = new RegistrationBean();
	
	
	@Before
	void insert() throws MyRuntimeException, SQLException {
		
		String name = CreateTournamentControllerTest.getAlphaNumericString(9);
		regBean.setFirstname(name);
		regBean.setLastname("Picco");
		regBean.setUsername("ale95");
		PlayerDAO.insertPlayer(regBean);
	}
	
	@Test
	void deleteTest() throws MyRuntimeException, SQLException {
		insert();
		boolean res = controller.delPlayer(regBean);
		assertTrue(res);
	}

}
