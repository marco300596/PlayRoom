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
	void RegistrationTest() throws MyRuntimeException, SQLException {
		
		RegistrationBean bean=new RegistrationBean();
		
		bean.setOrgFirstname("Mario");
		bean.setLastname("Rossi");
		bean.setOrgUsername("Mario497");
		bean.setPassword("ciao");
		bean.setOrgEmail("Mario-Rossi@gmail.com");
		boolean result =EventOrganizerDAO.insertOrganizer(bean);
		assertTrue(result);
		
		
	}

}
