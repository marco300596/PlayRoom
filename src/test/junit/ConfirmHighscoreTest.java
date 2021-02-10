package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import logic.bean.HighscoreBean;
import logic.bean.RegistrationBean;
import logic.bean.TournamentBean;
import logic.controller.CheckHighscoreController;
import logic.dao.HighscoreDAO;
import logic.dao.PlayerDAO;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;
import logic.model.Highscore;

class ConfirmHighscoreTest {
	//Casentini Marco
	CheckHighscoreController controller = CheckHighscoreController.getInstance();
	
	String nometorneo = CreateTournamentControllerTest.getAlphaNumericString(5);
	String nomeuser = CreateTournamentControllerTest.getAlphaNumericString(7);
	
	@Before
	void preLoadTournament() throws MyRuntimeException, SQLException {
		
		TournamentBean tb = new TournamentBean();
		tb.setTournamentName(nometorneo);
		tb.setTournamentGame("rFactor2");
		tb.setTournamentHardware("Acer Predator Orion 3000");
		tb.setTournamentPartecipants(20);
		tb.setTournamentRoom("stanza di prova");
		tb.setTournamentDate("");
		int id=RoomDAO.getRoomIdFromOrgUsername("b");
		TournamentDAO.insertTournament(tb, id);
		RegistrationBean pb = new RegistrationBean();
		pb.setFirstname("elio");
		pb.setLastname("alessandri");
		pb.setEmail("el.alessandri@gmail.com");
		pb.setUsername(nomeuser);
		PlayerDAO.insertPlayer(pb);
		TournamentDAO.setTournamentNameByPlayerUsername(pb.getUsername(),tb.getTournamentName());
		HighscoreBean hb = new HighscoreBean();
		hb.setPlayerUN("elissandro");
		hb.setHighscore(14);
		hb.setTournament("RaceDay");
		HighscoreDAO.insertHighscore(hb);
		
		
	}
	
	@Test
	void confirmHighscoreTestT() throws MyRuntimeException, SQLException {
		
		preLoadTournament();
		controller.getHighscoreBean().setTournament(nometorneo);
		controller.getHighscoreBean().setPlayerUN(nomeuser);
		controller.getHighscoreBean().setHighscore(14);
		Highscore high = new Highscore(controller.getHighscoreBean().getTournament(), controller.getHighscoreBean().getPlayerUN(), controller.getHighscoreBean().getHighscore());
		boolean contr = HighscoreDAO.setHighscoreTrue(high);
		assertTrue(contr);
	
	}
}
