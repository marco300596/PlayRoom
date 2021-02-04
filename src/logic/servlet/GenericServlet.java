package logic.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenericServlet")

public class GenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextJSP = "";
		RequestDispatcher dispatcher;
		if(request.getParameter("menu").equals("join")) {
			nextJSP = "/JoinTournament.jsp";
			request.setAttribute("menu", nextJSP);
			dispatcher = request.getRequestDispatcher("genericHomePage.jsp");
			dispatcher.forward(request,response);
		}
		if(request.getParameter("menu").equals("submit")) {
			nextJSP = "/SubmitHighscore.jsp";
		 	dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		 	dispatcher.forward(request,response);
		}
		if(request.getParameter("menu").equals("book")) {
			nextJSP = "/BookRoom.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}	
		if(request.getParameter("menu").equals("reservation")) {
			nextJSP = "/Reservation.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
