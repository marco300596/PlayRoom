package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import logic.exception.StringIsEmptyException;
import logic.exception.TimeException;
import logic.view.BookRoomViewController;


@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookRoomController controller = BookRoomController.getInstance();
		String gname="gname";
		String page="BookRoom.jsp";
		String rooms="rooms";
		
    	List<RoomBean> ral = new ArrayList<>();
    	if(request.getParameter("azione").equals("Search")) {
    	try {
    			
    			LocalDate localDate = LocalDate.parse(request.getParameter("date"));//For reference
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    			String formattedString = localDate.format(formatter);
    			String[] parts = formattedString.split("/");
    			int year = Integer.parseInt(parts[2]);
    			int month = Integer.parseInt(parts[1])-1;
    			int day = Integer.parseInt(parts[0]);
    			Calendar cal = Calendar.getInstance();
    			cal.clear();
    			cal.setLenient(false);
    			cal.set(year, month, day, 0, 0,0);

    			Calendar comp = Calendar.getInstance();
    			Date date = new Date();
    			comp.setTimeInMillis(date.getTime());
    			cal.getTime();

    			if(cal.getTime().after(comp.getTime())) {
    				
    				controller.getReservationBean().setDate(formattedString);
    				controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(request.getParameter("gsize")));
    				controller.getReservationBean().setHour(request.getParameter("hour"));
    				controller.getReservationBean().setCity(request.getParameter("city").toLowerCase());
    				
    				//PORCA EVA
    				if(!request.getParameter(gname).isEmpty() && !request.getParameter("hard").isEmpty()) {
    					controller.getGHBean().setGameName(request.getParameter("gname").toLowerCase());
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
    					
    				}
    				
    			}else {
    	    		throw new TimeException("invalid date selected");
    	    	}
    	}catch(TimeException t) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, t);
    			
    	}catch(NumberFormatException n) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, n);
    		
    		
    	} catch (MyRuntimeException e) {
    		Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, e);
    		
		} catch (SQLException |IOException s) {
			Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, s);
		}
    	 
    
    	}if(request.getParameter("reserveButton").equals("Reserve")) {
    		try {
    			controller.getRoomBean().setRoomName(request.getParameter("roomNo"));
    			controller.getRoomBean().setLocation(request.getParameter("roomLoc"));
				controller.createReservation();
			} catch (MyRuntimeException | SQLException e) {
				e.printStackTrace();
			}
    		
    	}
    }
}
	


