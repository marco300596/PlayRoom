package test.junit;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.LoginBean;
import logic.bean.RoomBean;
import logic.bean.TournamentBean;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

class JoinTournamentSearchTest {
	//Flavio Pucci
	@Test
	void joinTournamentTest() throws MyRuntimeException, SQLException {
		
		String nometorneo=CreateTournamentControllerTest.getAlphaNumericString(5);
		
		TournamentBean bean=new TournamentBean();
		RoomBean rbean=new RoomBean();
		bean.setTournamentName(nometorneo);
		bean.setTournamentGame("gta5");
		bean.setTournamentPartecipants(5);
		bean.setTournamentDate("");
		bean.setTournamentRoom("stanza bella");
		bean.setTournamentHardware("ps4");
		
		
		int id=RoomDAO.getRoomIdFromOrgUsername("b");
		TournamentDAO.insertTournament(bean, id);
		rbean.setCity("roma");
		LoginBean lbean=new LoginBean();
		lbean.setUsername("a");
		boolean res =TournamentDAO.setTournamentNameByPlayerUsername(lbean.getUsername(),nometorneo);
		assertTrue(res);
		
		
		
	}

}
