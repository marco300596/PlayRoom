package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.controller.BookRoomController;
import logic.controller.LoginController;
import logic.exception.MyRuntimeException;

class BookRoomTest {

	@Test
	void BookTestT() throws MyRuntimeException, SQLException {
		BookRoomController controller = BookRoomController.getInstance();
		LoginController logc = LoginController.getInstance();
		controller.getRoomBean().setRoomName("lalla");
		controller.getRoomBean().setLocation("via fiorano 15");
		controller.getReservationBean().setCity("roma");
		controller.getReservationBean().setDate("12-01-2000");
		controller.getReservationBean().setHour("10");
		controller.getReservationBean().setNumberOfPlayer(2);
		logc.getBean().setUsername("a");
		Boolean con = controller.createReservation();
		assertTrue(con);

	}
	
	@Test
	void BookTestF() throws MyRuntimeException, SQLException {
		BookRoomController controller = BookRoomController.getInstance();
		LoginController logc = LoginController.getInstance();
		controller.getRoomBean().setRoomName("allo");
		controller.getRoomBean().setLocation("via floria 12");
		controller.getReservationBean().setCity("altamura");
		controller.getReservationBean().setDate("12-02-2000");
		controller.getReservationBean().setHour("10");
		controller.getReservationBean().setNumberOfPlayer(2);
		logc.getBean().setUsername("a");
		Boolean con = controller.createReservation();
		assertFalse(con);

	}

}
