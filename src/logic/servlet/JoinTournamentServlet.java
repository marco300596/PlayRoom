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

import logic.bean.TournamentBean;
import logic.controller.JoinTournamentController;
import logic.exception.MyRuntimeException;


@WebServlet("/JoinTournamentServlet")
public class JoinTournamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<TournamentBean> htab = new ArrayList<>();
		JoinTournamentController controller = JoinTournamentController.getInstance();
		String city=request.getParameter("city");
		controller.getrBean().setCity(city);
		if(request.getParameter("azione").equals("Search Tournament")) {
			try {
				if(city.equals("")) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JoinTournament.jsp");
					dispatcher.forward(request, response);	
				}
				htab.addAll(controller.searchTournament(controller.getrBean()));    					
				request.setAttribute("tournaments", htab);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JoinTournament.jsp");
				dispatcher.forward(request, response);	
				
			} catch (MyRuntimeException | SQLException | IOException | ServletException e) {
			
				e.printStackTrace();
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Player.jsp");
    			dispatcher.forward(request, response);
			
			}
		}if(request.getParameter("azione").equals("Join")) {
			try {
    			controller.getBean().setTournamentName(request.getParameter("tname"));		
    			controller.joinTournament(controller.getBean().getTournamentName());
    			
    			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Player.jsp");
    			dispatcher.forward(request, response);	
			} catch (MyRuntimeException | SQLException e) {
				Logger.getLogger(JoinTournamentServlet.class.getName()).log(Level.SEVERE, null, e);
			}
		}
			
		}
}
