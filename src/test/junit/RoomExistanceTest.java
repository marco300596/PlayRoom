package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;
import logic.model.Room;

class RoomExistanceTest {

	@Test
	void RoomExistancetest() throws MyRuntimeException, SQLException {
		
		Room room=new Room();
		room.setRoomName("stanza x");
		room.setNumSeat(Integer.parseInt("5"));
		room.setPrice(Integer.parseInt("0"));
		room.setLocation("via si");
		room.setPhoto("");
		room.setCity("roma");
		Room result=new Room();
		result=RoomDAO.getRoom("stanza x");
		assertEquals(room,result);
		
		
	}

}
