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
import javax.swing.JOptionPane;



import logic.bean.HighscoreBean;

import logic.controller.CheckHighscoreController;
import logic.exception.MyRuntimeException;


/**
 * Servlet implementation class CheckHighscoreServlet
 */
@WebServlet("/CheckHighscoreServlet")
public class CheckHighscoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckHighscoreController controller = CheckHighscoreController.getInstance();
		ArrayList<HighscoreBean> highscores;
		String page="CheckHighscore.jsp";
		highscores = new ArrayList<>();
		String high = "highscores";
		
		 if(request.getParameter("azione").equals("update")) {
	    		try {
	    			highscores.addAll(controller.findPendingHighscoreForTournament());
	    		}catch(MyRuntimeException | SQLException e) {
	    			Logger.getLogger(CheckHighscoreServlet.class.getName()).log(Level.SEVERE, null, e);
	    		}
	    		request.setAttribute(high, highscores);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    		dispatcher.forward(request, response);	
	    }
		 
		if(request.getParameter("azione").equals("confirm")) {
			try{
	    		int score = Integer.parseInt(request.getParameter("score"));
				controller.getHighscoreBean().setPlayerUN(request.getParameter("uname"));
		    	controller.getHighscoreBean().setHighscore(score);
		    	controller.getHighscoreBean().setTournament(request.getParameter("tournament"));
	    	
	    		if(controller.confirmHighscore()) {
	    			new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore Confirmed!","Success", JOptionPane.INFORMATION_MESSAGE)).start();
		    	} else {
		    		new Thread(()-> JOptionPane.showMessageDialog(null, "Highscore non-acceptable!","Failed", JOptionPane.INFORMATION_MESSAGE)).start();
		    	}
	    		
	    	
	    		} catch(MyRuntimeException | SQLException e){
	    			Logger.getLogger(CheckHighscoreServlet.class.getName()).log(Level.SEVERE, null, e);
	    	}	
			request.setAttribute(high, highscores);
    		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    		dispatcher.forward(request, response);
		} 		
			
	    
	}

	

}
