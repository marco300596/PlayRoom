package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.controller.BookRoomController;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;

class BookRoomTest {

	@Test
	void bookTestT() throws MyRuntimeException, SQLException {
		BookRoomController controllert = BookRoomController.getInstance();
		LoginController logc = LoginController.getInstance();
		controllert.getRoomBean().setRoomName("lalla");
		controllert.getRoomBean().setLocation("via fiorano 15");
		controllert.getReservationBean().setCity("roma");
		controllert.getReservationBean().setDate("12-01-2022");
		controllert.getReservationBean().setHour("10");
		controllert.getReservationBean().setNumberOfPlayer(2);
		logc.getBean().setUsername("a");
		Boolean con = controllert.createReservation();
		assertTrue(con);

	}
	
	@Test
	void bookTestF() throws MyRuntimeException, SQLException {
		BookRoomController controllerf = BookRoomController.getInstance();
		LoginController logc = LoginController.getInstance();
		controllerf.getRoomBean().setRoomName("allo");
		controllerf.getRoomBean().setLocation("via floria 12");
		controllerf.getReservationBean().setCity("altamura");
		controllerf.getReservationBean().setDate("12-02-2000");
		controllerf.getReservationBean().setHour("10");
		controllerf.getReservationBean().setNumberOfPlayer(2);
		logc.getBean().setUsername("a");
		Boolean con = controllerf.createReservation();
		assertFalse(con);

	}

}
