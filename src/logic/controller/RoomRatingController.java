package logic.controller;
import java.sql.SQLException;

import logic.bean.RatingBean;
import logic.dao.RatingDAO;
import logic.exception.MyRuntimeException;
import logic.model.Rating;


public class RoomRatingController {
	private static RoomRatingController inst;

    private Rating rating;


    private RatingBean bean = new RatingBean();


	public static RoomRatingController getInstance() {

        if (inst == null)

            inst = new RoomRatingController();

        return inst;

    }
	
	public Rating getRating() {
		return rating;
	}



	public RatingBean getBean() {
		return bean;
	}



	public void setRating(Rating rating) {
		this.rating=rating;
	}



	public void setBean(RatingBean bean) {
		this.bean = bean;
	}
	
	public void insertnewRating(RatingBean bean)throws MyRuntimeException, SQLException{
		
		RatingDAO.insertRating(bean);
		
	}
}