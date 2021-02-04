package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.CreateTournamentController;
import logic.exception.MyRuntimeException;

@WebServlet("/CreateTournamentServlet")
public class CreateTournamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room = request.getParameter("rname");
		String tournament = request.getParameter("tname");
		String partecipants = request.getParameter("part");
		String game = request.getParameter("game");
		String hardware = request.getParameter("hw");
		CreateTournamentController controller = CreateTournamentController.getInstance();
		controller.getBean().setTournamentRoom(room);
    	controller.getBean().setTournamentName(tournament);
    	controller.getBean().setTournamentGame(game);
    	controller.getBean().setTournamentHardware(hardware);
    	int num = Integer.parseInt(partecipants);
    	controller.getBean().setTournamentPartecipants(num);
    	try {
			controller.insertNewTournament(controller.getBean());
		} catch (MyRuntimeException | SQLException e) {
    		Logger.getLogger(CreateTournamentServlet.class.getName()).log(Level.SEVERE, null, e);
		}
	}



}
