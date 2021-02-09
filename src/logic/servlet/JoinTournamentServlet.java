package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			htab.addAll(controller.searchTournament(controller.getrBean()));    					
			request.setAttribute("tournaments", htab);
			RequestDispatcher dispatcher = request.getRequestDispatcher("JoinTournament.jsp");
			dispatcher.forward(request, response);	
			
		} catch (MyRuntimeException | SQLException e) {
		
		e.printStackTrace();
	}
		}
		if(request.getParameter("azione").equals("Join")) {
			try {
    			controller.getBean().setTournamentName(request.getParameter("tname"));		
    			controller.joinTournament(controller.getBean().getTournamentName());
    			
    			RequestDispatcher dispatcher = request.getRequestDispatcher("Player.jsp");
    			dispatcher.forward(request, response);	
			} catch (MyRuntimeException | SQLException e) {
				e.printStackTrace();
			}
		}
		if(city.equals("")) {
			try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("JoinTournament.jsp");
			dispatcher.forward(request, response);	
		}	catch (IOException | ServletException e) {
			
			e.printStackTrace();
		}
			
		}
}
}
