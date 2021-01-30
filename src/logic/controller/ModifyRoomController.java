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
		
		public void addComponentH(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			
			int id;
			id=RoomDAO.getRoomIdFromOrgUsername(bean.getOrgUserName());
			if(HardwareDAO.hardwareCheck(bean, id)) {
				HardwareDAO.hardwareUpdate(bean,id);
			}else {
				HardwareDAO.hardwareInfo(bean,id);
			}
		}
		
		
		
		public void addComponentV(GameHardwareBean bean) throws MyRuntimeException, SQLException {
			int id;
			id=RoomDAO.getRoomIdFromOrgUsername(bean.getOrgUserName());
			if(VideoGameDAO.gameCheck(bean, id)) {
				VideoGameDAO.gameUpdate(bean,id);
			}else {
				VideoGameDAO.gameInfo(bean,id);
			}
		}
		
		
	}


