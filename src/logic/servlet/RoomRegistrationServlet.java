package logic.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.controller.RegisterRoomController;
import logic.exception.MyRuntimeException;


@WebServlet("/RoomRegistrationServlet")
public class RoomRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String room=request.getParameter("rname");
		String nseat=request.getParameter("nseat");
		String description=request.getParameter("description");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		String price=request.getParameter("price");
	//	String image=request.getParameter("img");
		
		RegisterRoomController controller = RegisterRoomController.getInstance();
		try {
			controller.getBean().setRoomName(room);
			int seat = Integer.parseInt(nseat);
			controller.getBean().setNumSeat(seat);
			controller.getBean().setDescription(description);
			controller.getBean().setCity(city);
			controller.getBean().setLocation(address);
			int pric = Integer.parseInt(price);
			controller.getBean().setPrice(pric);
			controller.insertnewRoom(controller.getBean());
			String nextJSP = "/Organizer.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
	}
		catch (MyRuntimeException | SQLException  e) {
			
			e.printStackTrace();
}

	
		
	}
	
}
