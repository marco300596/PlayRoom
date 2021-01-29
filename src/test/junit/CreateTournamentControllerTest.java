package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.TournamentBean;
import logic.controller.CreateTournamentController;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

class CreateTournamentControllerTest {

	@Test
	void test() throws MyRuntimeException, SQLException {
		CreateTournamentController controller = CreateTournamentController.getInstance();
		TournamentBean bean = new TournamentBean();
		bean.setTournamentName("torneo c");
		bean.setTournamentPartecipants(2);
		bean.setTournamentDate("");
		bean.setTournamentGame("call of duty");
		bean.setTournamentHardware("xbox one");
		bean.setTournamentRoom("stanza di a");
		controller.setBean(bean);
		boolean res = controller.insertNewTournament(bean);
		assertTrue(res);
	}

}
