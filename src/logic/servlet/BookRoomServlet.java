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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logic.bean.RoomBean;
import logic.controller.BookRoomController;
import logic.exception.MyRuntimeException;
import logic.exception.TimeException;
import logic.view.BookRoomViewController;

/**
 * Servlet implementation class BookRoomServlet
 */
@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRoomServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookRoomController controller = BookRoomController.getInstance();
    	ObservableList<RoomBean> rol = FXCollections.observableArrayList();
    	List<RoomBean> ral = new ArrayList<RoomBean>();
    	if(request.getParameter("azione").equals("Search")) {
    	try {
    			
    			LocalDate localDate = LocalDate.parse(request.getParameter("date"));//For reference
    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    			String formattedString = localDate.format(formatter);
    			System.out.println(formattedString);
    			String[] parts = formattedString.split("-");
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
    				System.out.println(controller.getReservationBean().getDate());
    				controller.getReservationBean().setNumberOfPlayer(Integer.parseInt(request.getParameter("gsize")));
    				System.out.println(controller.getReservationBean().getNumberOfPlayer());
    				controller.getReservationBean().setHour(request.getParameter("hour"));
    				System.out.println(controller.getReservationBean().getHour());
    				controller.getReservationBean().setCity(request.getParameter("city"));
    				System.out.println(controller.getReservationBean().getCity());

    				//PORCA EVA
    				if(!request.getParameter("gname").isEmpty() && !request.getParameter("hard").isEmpty()) {
    					controller.getGHBean().setGameName(request.getParameter("gname"));
    					controller.getGHBean().setHardwareName(request.getParameter("hard"));
    					rol = controller.findRoomForPrenoByGameandHardware();
    					for(RoomBean j : rol) {
    						
    						ral.add(j);
    					}
    					
    					request.setAttribute("rooms", ral);
    					RequestDispatcher dispatcher = request.getRequestDispatcher("BookRoom.jsp");
    					dispatcher.forward(request, response);
    					
    				}else if(!request.getParameter("gname").isEmpty()) {
    					controller.getGHBean().setGameName(request.getParameter("gname"));
    		    		rol = controller.findRoomForPrenoByVideoGame();
    		    		for(RoomBean j : rol) {
    						
    						ral.add(j);
    					}
    					
    		    		request.setAttribute("rooms", ral);
    					RequestDispatcher dispatcher = request.getRequestDispatcher("BookRoom.jsp");
    					dispatcher.forward(request, response);
    					
    				}else if (!request.getParameter("hard").isEmpty()) {
    					controller.getGHBean().setHardwareName(request.getParameter("hard"));
    					rol = controller.findRoomForPrenoByHardware();
    					for(RoomBean j : rol) {
    						
    						ral.add(j);
    					}
    					
    					request.setAttribute("rooms", ral);
    					RequestDispatcher dispatcher = request.getRequestDispatcher("BookRoom.jsp");
    					dispatcher.forward(request, response);
    					
    				}else if (!request.getParameter("city").isEmpty()) {
    					rol = controller.findRoomForPreno();
    					for(RoomBean j : rol) {
    						
    						ral.add(j);
    					}
    					
    					request.setAttribute("rooms", ral);
    					RequestDispatcher dispatcher = request.getRequestDispatcher("BookRoom.jsp");
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
    		
		} catch (SQLException s) {
			Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, s);
		}
    }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
