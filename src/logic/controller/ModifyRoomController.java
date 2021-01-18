package logic.controller;

import java.sql.SQLException;
import logic.bean.RoomBean;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;


public class ModifyRoomController {

		private static ModifyRoomController inst;
		
		private RoomBean bean = new RoomBean();
		
		public static ModifyRoomController getInstance() {
			if (inst == null) {
				inst = new ModifyRoomController();
			}
			return inst;
		}

		public RoomBean getBean() {
			return bean;
		}

		public void setBean(RoomBean bean) {
			this.bean = bean;
		}
		
		public void addComponentH(RoomBean bean) throws MyRuntimeException, SQLException {
			
			
			
			RoomDAO.hardwareInfo();
		}
		
		
		
		public void addComponentV(RoomBean bean) throws MyRuntimeException, SQLException {
			
			
			RoomDAO.gameInfo();
			
		}
		
		
	}


