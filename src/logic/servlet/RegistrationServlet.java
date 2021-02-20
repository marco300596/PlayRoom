package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.controller.LoginController;
import logic.controller.RegistrationController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;
import logic.view.RegisterRoomViewController;



@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fname");
    	String lastname = request.getParameter("lname");
    	String email = request.getParameter("email");
    	String username = request.getParameter("uname");
    	String password = request.getParameter("pass");
		RegistrationController reg=RegistrationController.getInstance();
		reg.getBean().setFirstname(firstname);
    	reg.getBean().setLastname(lastname);
    	reg.getBean().setEmail(email);
    	reg.getBean().setUsername(username);
    	reg.getBean().setPassword(password);
    	try {	
    		if(request.getParameter("user").equals("player") && !LoginController.getInstance().findPlayerIdentity()) {
    				
    			reg.insertNewPlayer(reg.getBean());
				String nextJSP = "/login.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
    		} else if(request.getParameter("user").equals("org") && !LoginController.getInstance().findOrgIdentity()) {
					
				reg.insertNewOrganizer(reg.getBean());
				String nextJSP = "/login.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
			}
    		
    		}catch (MyRuntimeException | SQLException|UserDoesNotExist e) {
    			
    			
    			e.printStackTrace();
			}catch(IOException i ) { 
				Logger.getLogger(RegisterRoomViewController.class.getName()).log(Level.SEVERE, null, i);
    		
    		
    	
	} 
	
    		
		
    		
    		
    	
	}
}

	
	


