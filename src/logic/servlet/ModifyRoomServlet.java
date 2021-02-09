package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.LoginController;
import logic.controller.ModifyRoomController;
import logic.exception.MyRuntimeException;


@WebServlet("/ModifyRoomServlet")
public class ModifyRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = request.getParameter("name");
    	String genre= request.getParameter("genre");
    	String quantity= request.getParameter("quantity");
    	String description= request.getParameter("description");
    	ModifyRoomController controller = ModifyRoomController.getInstance();
    	LoginController logc=LoginController.getInstance();
    	
    	try {
    		
    		if(request.getParameter("type").equals("hard")) {
    				
    				controller.getHVBean().setOrgUserName(logc.getBean().getUsername());
    				controller.getHVBean().setHardwareName(name);
    				controller.getHVBean().setHardwareGenre(genre);
    				int hardwareQuantity = Integer.parseInt(quantity);
    				controller.getHVBean().setHardwareQuantity(hardwareQuantity);
    				controller.getHVBean().setHardwareDescription(description);
    				controller.addComponentH(controller.getHVBean());
    				String nextJSP = "/Organizer.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request,response);
    			} 
    		
    			else if(request.getParameter("type").equals("game")) {
    				
    					controller.getHVBean().setOrgUserName(logc.getBean().getUsername());
    					controller.getHVBean().setGameName(name);
    					controller.getHVBean().setGameGenre(genre);
    					int hardwareQuantity = Integer.parseInt(quantity);
    					controller.getHVBean().setGameQuantity(hardwareQuantity);
    					controller.getHVBean().setGameDescription(description);
    					controller.addComponentV(controller.getHVBean());
	    				String nextJSP = "/Organizer.jsp";
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
						dispatcher.forward(request,response);
					}
    			}
    	catch (MyRuntimeException | SQLException  e) {
    					
			
		
    					e.printStackTrace();
			}
    		
    	
    	
    	
    	
		
		
		
		
	}	
	}

	
	


