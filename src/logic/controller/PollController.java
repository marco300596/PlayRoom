package logic.controller;
import java.sql.SQLException;

import logic.bean.PollBean;
import logic.dao.PollDAO;
import logic.exception.MyRuntimeException;
import logic.model.Poll;

public class PollController {
	private static PollController inst;

    private Poll poll;


    private PollBean bean = new PollBean();


	public static PollController getInstance() {

        if (inst == null)

            inst = new PollController();

        return inst;

    }
	
	public Poll getPoll() {
		return poll;
	}



	public PollBean getBean() {
		return bean;
	}



	public void setPoll(Poll poll) {
		this.poll=poll;
	}



	public void setBean(PollBean bean) {
		this.bean = bean;
	}
	
	public void insertnewPoll(PollBean bean)throws MyRuntimeException, SQLException{
		
		PollDAO.insertPoll(bean);
		
	}
}
