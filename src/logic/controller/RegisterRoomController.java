package logic.controller;
import java.sql.SQLException;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;
import logic.model.Room;
public class RegisterRoomController {

	private static RegisterRoomController inst;

    private Room room;

    private RoomBean bean = new RoomBean();

    
    private RegisterRoomController(){
    	//private constr
    }
    
	public static RegisterRoomController getInstance() {

        if (inst == null)

            inst = new RegisterRoomController();

        return inst;

    }
	
	public Room getRoom() {
		return room;
	}



	public RoomBean getBean() {
		return bean;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	public void setBean(RoomBean bean) {
		this.bean = bean;
	}
	
	public void insertnewRoom(RoomBean bean)throws MyRuntimeException, SQLException{
		int i = RoomDAO.getRoomIdFromOrgUsername(LoginController.getInstance().getBean().getUsername());
		RoomDAO.insertRoom(bean, i);
		
	}
}
