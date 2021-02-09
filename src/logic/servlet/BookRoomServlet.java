package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import logic.bean.RoomBean;
import logic.controller.BookRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.TimeException;
import logic.view.BookRoomViewController;


@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookRoomController controller = BookRoomController.getInstance();
		String page="BookRoom.jsp";
		
		if(request.getParameter("azione").equals("Search")) {
			try {
    			
    			String formattedStringt = (request.getParameter("date"));
    			String[] partst = formattedStringt.split("/");
    			int yeart = Integer.parseInt(partst[2]);
    			int montht = Integer.parseInt(partst[1])-1;
    			int dayt = Integer.parseInt(partst[0]);
    			Calendar calt = Calendar.getInstance();
    			calt.clear();
    			calt.setLenient(false);
    			calt.set(yeart, montht, dayt, 0, 0,0);

    			Calendar compt = Calendar.getInstance();
    			Date datet = new Date();
    			compt.setTimeInMillis(datet.getTime());
    			calt.getTime();

    			if(calt.getTime().after(compt.getTime())) {
    				
    				method(request, response, formattedStringt);
    				
    			}else {
    	    		throw new TimeException("invalid date selected");
    	    	}
	    	}catch(TimeException t) {
	    		Logger.getLogger(BookRoomServlet.class.getName()).log(Level.SEVERE, null, t);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
	    			
	    	}catch(NumberFormatException n) {
	    		Logger.getLogger(BookRoomServlet.class.getName()).log(Level.SEVERE, null, n);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
				
	    	} catch (MyRuntimeException e) {
	    		Logger.getLogger(BookRoomServlet.class.getName()).log(Level.SEVERE, null, e);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
				
			} catch (SQLException |IOException s) {
				Logger.getLogger(BookRoomServlet.class.getName()).log(Level.SEVERE, null, s);
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}
		}

		else if(request.getParameter("azione").equals("Reserve")) {
				
			try {
					controller.getRoomBean().setRoomName(request.getParameter("roomNo"));
					controller.getRoomBean().setLocation(request.getParameter("roomLoc"));
					controller.createReservation();
					
			} catch (MyRuntimeException | SQLException e) {
				Logger.getLogger(BookRoomServlet.class.getName()).log(Level.SEVERE, null, e);
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}finally {
			
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}
	    }
    }

    private void method(HttpServletRequest request, HttpServletResponse response, String formattedStringt) throws MyRuntimeException, SQLException, ServletException, IOException {
	    
    	BookRoomController controller = BookRoomController.getInstance();
    	String gname="gname";
		String page="BookRoom.jsp";
		String rooms="rooms";
		List<RoomBean> ral = new ArrayList<>();
    	
		controller.getReservationBean().setDate(formattedStringt);
		controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(request.getParameter("gsize")));
		controller.getReservationBean().setHour(request.getParameter("hour"));
		controller.getReservationBean().setCity(request.getParameter("city").toLowerCase());
		
		//PORCA EVA
		if(!request.getParameter(gname).isEmpty() && !request.getParameter("hard").isEmpty()) {
			controller.getGHBean().setGameName(request.getParameter(gname).toLowerCase());
			controller.getGHBean().setHardwareName(request.getParameter("hard").toLowerCase());
	
			ral.addAll(controller.findRoomForPrenoByGameandHardware());    					
			request.setAttribute(rooms, ral);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		}else if(!request.getParameter(gname).isEmpty()) {
			controller.getGHBean().setGameName(request.getParameter(gname).toLowerCase());
			
			ral.addAll(controller.findRoomForPrenoByVideoGame());
			request.setAttribute(rooms, ral);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		}else if (!request.getParameter("hard").isEmpty()) {
			controller.getGHBean().setHardwareName(request.getParameter("hard").toLowerCase());
			
			ral.addAll(controller.findRoomForPrenoByHardware());
			request.setAttribute(rooms, ral);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		}else if (!request.getParameter("city").isEmpty()) {
			
			ral.addAll(controller.findRoomForPreno());
			request.setAttribute(rooms, ral);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
    }

}
