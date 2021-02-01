package test.junit;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.RegistrationBean;
import logic.dao.EventOrganizerDAO;
import logic.exception.MyRuntimeException;

class OrganizerRegistrationTest {
	//Flavio Pucci
	@Test
	void registrationTest() throws MyRuntimeException, SQLException {
		
		String username=CreateTournamentControllerTest.getAlphaNumericString(5);
		RegistrationBean bean=new RegistrationBean();
		
		bean.setOrgFirstname("Mario");
		bean.setOrgLastname("Rossi");
		bean.setOrgUsername(username);
		bean.setOrgPassword("ciao");
		bean.setOrgEmail("Mario-Rossi@gmail.com");
		boolean result =EventOrganizerDAO.insertOrganizer(bean);
		assertTrue(result);
		
		
	}

}
