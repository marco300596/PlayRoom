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


import logic.bean.RegistrationBean;
import logic.controller.ManagementController;
import logic.exception.MyRuntimeException;
import logic.exception.StringIsEmptyException;
import logic.exception.UserDoesNotExist;
import logic.view.BookRoomViewController;
import logic.view.ManagementViewController;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagementController controller = ManagementController.getInstance();
		ArrayList<RegistrationBean> players;
		String page="DeletePlayer.jsp";
		players = new ArrayList<>();
		
    	String users = "users";
    	if(request.getParameter("azione").equals("Search")) {
    		try {
    			players.addAll(controller.updatePlayers());
    		} catch(SQLException | MyRuntimeException e) {
    			Logger.getLogger(BookRoomViewController.class.getName()).log(Level.SEVERE, null, e);
    		}
    		request.setAttribute(users, players);
    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    		dispatcher.forward(request, response);
    	}
    	
    	if(request.getParameter("azione").equals("Delete")) {
    		try {
    			if(!request.getParameter("usname").equals("")) {
    				controller.getRegBean().setUsername(request.getParameter("usname"));
        			if(controller.delPlayer(controller.getRegBean())){
        				request.setAttribute("message", "User deleted!");
    	    			response.sendRedirect(request.getHeader("Referer"));
        			} else {
        				throw new UserDoesNotExist();
        			}
    			} else {
    				throw new StringIsEmptyException();
    			}
    			
    			
    		} catch (MyRuntimeException | SQLException | UserDoesNotExist | StringIsEmptyException  e1) {
				Logger.getLogger(ManagementViewController.class.getName()).log(Level.SEVERE, null, e1);
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    		dispatcher.forward(request, response);
			}
    		
    	}
	
    	
    	
	}



}
