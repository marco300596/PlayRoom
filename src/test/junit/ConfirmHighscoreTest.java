package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.controller.CheckHighscoreController;
import logic.exception.MyRuntimeException;

class ConfirmHighscoreTest {

	@Test
	void confirmHighscoreTestT() throws MyRuntimeException, SQLException {
		CheckHighscoreController controller = CheckHighscoreController.getInstance();
		
		controller.getHighscoreBean().setTournament("YfFLiRbL8");
		controller.getHighscoreBean().setPlayerUN("al");
		controller.getHighscoreBean().setHighscore(14);
		Boolean contr = controller.confirmHighscore();
		assertTrue(contr);
	}
	
	@Test
	void confirmHighscoreTestF() throws MyRuntimeException, SQLException {
		CheckHighscoreController controller = CheckHighscoreController.getInstance();
		
		controller.getHighscoreBean().setTournament("YfFiRbL8");
		controller.getHighscoreBean().setPlayerUN("al");
		controller.getHighscoreBean().setHighscore(14);
		Boolean contr = controller.confirmHighscore();
		assertFalse(contr);
	}

}
