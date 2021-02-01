package test.junit;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;


class RoomExistanceTest {
	//Flavio Pucci
	
	@Test
	void roomExistancetest() throws MyRuntimeException, SQLException {
		
		String nome=CreateTournamentControllerTest.getAlphaNumericString(5);
		
		int id;
		id=RoomDAO.getRoomIdFromOrgUsername("b");
		RoomBean room=new RoomBean();
		room.setRoomName(nome);
		room.setNumSeat(Integer.parseInt("5"));
		room.setPrice(Integer.parseInt("0"));
		room.setLocation("via si");
		room.setPhoto("");
		room.setCity("roma");
		
		boolean res=RoomDAO.insertRoom(room, id);
		
		assertTrue(res);
		
	}

}
