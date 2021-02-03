package logic.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenericServlet")

public class GenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GenericServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("menu").equals("join"))
			String nextJSP = "/JoinTournament.jsp";
		
		if(request.getParameter("menu").equals("submit"))
			String nextJSP = "/SubmitHighscore.jsp";
			
		if(request.getParameter("menu").equals("book"))
			String nextJSP = "/BookRoom.jsp";
			
		if(request.getParameter("menu").equals("reservation"))
			String nextJSP = "/Reservation.jsp";
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
