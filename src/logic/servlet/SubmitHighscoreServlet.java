package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.HighscoreBean;
import logic.controller.LoginController;
import logic.controller.SubmitHighscoreController;
import logic.exception.MyRuntimeException;
import logic.exception.UserDoesNotExist;

/**
 * Servlet implementation class SubmitHighscoreServlet
 */
@WebServlet("/SubmitHighscoreServlet")
public class SubmitHighscoreServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private SubmitHighscoreController controller = SubmitHighscoreController.getInstance();
	private LoginController logc = LoginController.getInstance();
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page="SubmitHighscore.jsp";
		List<HighscoreBean> hal = new ArrayList<>();
		
		try {
			hal.addAll(controller.showHighscore());
	    	if(!hal.isEmpty()) {
	    		
	    		request.setAttribute("highscores", hal);
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);
	    	}else {
	    		
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
				dispatcher.forward(request, response);	
	    	}
		}catch(MyRuntimeException | SQLException e){
			
			Logger.getLogger(SubmitHighscoreServlet.class.getName()).log(Level.SEVERE, null, e);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page="SubmitHighscore.jsp";
    	controller.getHighscoreBean().setHighscore(Integer.parseInt(request.getParameter("highscore")));
			
		try {
			if (logc.findPlayerIdentity()) {
				if (controller.checkTournamentAdehesion()) {
					if(controller.submitHighscore()) {
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(page);
						dispatcher.forward(request, response);
						
					}else {
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(page);
						dispatcher.forward(request, response);
					}
					
				}else {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(page);
					dispatcher.forward(request, response);
				}
			}
		}catch(UserDoesNotExist u) {
			
			Logger.getLogger(SubmitHighscoreServlet.class.getName()).log(Level.SEVERE, null, u);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.forward(request, response);
			
		}catch(NumberFormatException n) {
			
			Logger.getLogger(SubmitHighscoreServlet.class.getName()).log(Level.SEVERE, null, n);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		
		} catch (MyRuntimeException m) {
			
			Logger.getLogger(SubmitHighscoreServlet.class.getName()).log(Level.SEVERE, null, m);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			
			Logger.getLogger(SubmitHighscoreServlet.class.getName()).log(Level.SEVERE, null, e);
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}
}