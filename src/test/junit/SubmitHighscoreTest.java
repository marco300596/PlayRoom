package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.HighscoreBean;
import logic.bean.LoginBean;
import logic.bean.RoomBean;
import logic.bean.TournamentBean;
import logic.dao.HighscoreDAO;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

class SubmitHighscoreTest {
//Casentini Marco
	@Test
	void submitHighscoreTTest() throws MyRuntimeException, SQLException {
		String nometorneo1=CreateTournamentControllerTest.getAlphaNumericString(5);
		
		TournamentBean tbean=new TournamentBean();
		RoomBean rbean=new RoomBean();
		tbean.setTournamentName(nometorneo1);
		tbean.setTournamentGame("gta5");
		tbean.setTournamentPartecipants(5);
		tbean.setTournamentRoom("stanza bella");
		tbean.setTournamentHardware("ps4");
		
		
		int id=RoomDAO.getRoomIdFromOrgUsername("b");
		
		TournamentDAO.insertTournament(tbean, id);
		
		rbean.setCity("roma");
		
		LoginBean lbean=new LoginBean();
		lbean.setUsername("a");
		
		HighscoreBean highscorebean = new HighscoreBean();
		highscorebean.setPlayerUN(lbean.getUsername());
		highscorebean.setHighscore(150);
		highscorebean.setTournament(nometorneo1);
		boolean con = HighscoreDAO.insertHighscore(highscorebean);
		assertTrue(con);
	}

}
