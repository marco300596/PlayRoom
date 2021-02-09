package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import logic.bean.ReservationBean;
import logic.controller.CheckReservationController;

import logic.exception.MyRuntimeException;


/**
 * Servlet implementation class CheckReservationServlet
 */
@WebServlet("/CheckReservationServlet")
public class CheckReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ACT = "azione";   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckReservationController controller = CheckReservationController.getInstance();
		ArrayList<ReservationBean> reservations;
		String page="CheckReservation.jsp";
		reservations = new ArrayList<>();
		
    	String res = "reservations";
    	if(request.getParameter(ACT).equals("update")) {
    		try {
    			reservations.addAll(controller.updateReservation());
    		} catch(SQLException | MyRuntimeException e) {
    			Logger.getLogger(CheckReservationServlet.class.getName()).log(Level.SEVERE, null, e);
    		}
    		request.setAttribute(res, reservations);
    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    		dispatcher.forward(request, response);
    	}
    	if(request.getParameter(ACT).equals("confirm")) {
    		controller.getResBean().setPlayerUsername(request.getParameter("uname"));
    		controller.getResBean().setDate(request.getParameter("date"));
    		controller.getResBean().setHour(request.getParameter("hour"));
    		
    		try {
    			if(controller.confirmReservation()) {
    				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            		dispatcher.forward(request, response);
    			}
    			
    		}catch(SQLException | MyRuntimeException e){
    			Logger.getLogger(CheckReservationServlet.class.getName()).log(Level.SEVERE, null, e);
    			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        		dispatcher.forward(request, response);
    		}
    		
    		
    	}
    	
    	if(request.getParameter(ACT).equals("confirmed")) {
    		try {
    			reservations.addAll(controller.confirmed());
    		}catch(SQLException | MyRuntimeException e){
    			Logger.getLogger(CheckReservationServlet.class.getName()).log(Level.SEVERE, null, e);
    		}
    		request.setAttribute(res, reservations);
    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    		dispatcher.forward(request, response);
    	}
    	
	}


}
