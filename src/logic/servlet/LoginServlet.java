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
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("uname");
    	String password = request.getParameter("pass");
    	
    	LoginController logc = LoginController.getInstance();
    	logc.getBean().setUsername(username);
    	logc.getBean().setPassword(password);
    	
    	try {
    		if(request.getParameter("user").equals("player")){
    			if(logc.findPlayerIdentity()) {
					String nextJSP = "/genericHomePage.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request,response);
    			}
			}else if (request.getParameter("user").equals("org")) {
				if(logc.findOrgIdentity()) {
					String nextJSP = "/Organizer.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
					dispatcher.forward(request,response);		
				}
			}
		} catch (MyRuntimeException | SQLException | UserDoesNotExist e) {
			
				request.getSession().setAttribute("message", "Error. User not registered yet.");
				response.sendRedirect(request.getHeader("Referer"));
				//vedere a cosa fa riferimento.
			
			e.printStackTrace();
		}
	}


}
