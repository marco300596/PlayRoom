package logic.controller;

import java.sql.SQLException;

import logic.bean.GameHardwareBean;
import logic.dao.RoomDAO;
import logic.exception.MyRuntimeException;


public class ModifyRoomController {

		private static ModifyRoomController inst;
		
		private GameHardwareBean bean = new GameHardwareBean();
		
		public static ModifyRoomController getInstance() {
			if (inst == null) {
				inst = new ModifyRoomController();
			}
			return inst;
		}


		public GameHardwareBean getHVBean() {
			return bean;
		}

		
		public void setBean(GameHardwareBean bean) {
			this.bean = bean;
		}
		
		public void addComponentH(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			
			
			
			RoomDAO.hardwareInfo();
		}
		
		
		
		public void addComponentV(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			
			
			RoomDAO.gameInfo();
			
		}
		
		
	}


