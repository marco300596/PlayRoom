package logic.controller;

import java.sql.SQLException;

import logic.bean.GameHardwareBean;
import logic.dao.HardwareDAO;
import logic.dao.RoomDAO;
import logic.dao.VideoGameDAO;
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
		
		public boolean addComponentH(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			
			int id;
			id=RoomDAO.getRoomIdFromOrgUsername(bean.getOrgUserName());
			return HardwareDAO.hardwareInfo(bean,id);
			}
		
		
		
		
		public boolean addComponentV(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			int id;
			id=RoomDAO.getRoomIdFromOrgUsername(bean.getOrgUserName());
			return VideoGameDAO.gameInfo(bean,id);
			}
		}
		
		
	


