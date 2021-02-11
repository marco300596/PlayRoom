package test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import logic.bean.TournamentBean;
import logic.dao.RoomDAO;
import logic.dao.TournamentDAO;
import logic.exception.MyRuntimeException;

class CreateTournamentControllerTest {
	//Alessandro Picco
	TournamentBean bean = new TournamentBean();
	static Random r = new Random();
	@Before
	int id() throws MyRuntimeException, SQLException {
		
		int id;
		id = RoomDAO.getRoomIdFromOrgUsername("b");
		return id;
	}
	
	/*using this method to avoid equals tournaments name 
	 * that must be unique.
	 */
	@Before
    static String getAlphaNumericString(int n){ 
  
        // chose a Character random from this String 
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
          
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
        	
            int index 
                = r.nextInt(50); 
           
            // add Character one by one in end of sb 
            sb.append(alphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
	
	@Test
	void createTest() throws MyRuntimeException, SQLException {
		
		bean.setTournamentName(getAlphaNumericString(9));
		bean.setTournamentPartecipants(2);
		bean.setTournamentGame("call of duty");
		bean.setTournamentHardware("xbox one");
		bean.setTournamentRoom("stanza di b");
		
		boolean res = TournamentDAO.insertTournament(bean, id());
		assertTrue(res);
	}

}
