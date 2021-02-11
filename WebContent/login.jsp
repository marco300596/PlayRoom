<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   
    <%   if(request.getSession().getAttribute("message") == null) {
    	request.getSession().setAttribute("message", "Welcome!");
    	}
    %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h1><%=request.getSession().getAttribute("message")%></h1>
			<form action="LoginServlet">
			Username:<br>  <input type="text" name="uname"><br>
			Password:<br>  <input type="password" name="pass"><br>
			<input	type="radio" name="user" value=player>Player
			<input  type="radio" name="user" value=org>Event Organizer<br>
			<input type="submit" value="login">
			<a href="Register.jsp">Register</a>
			</form>
	
	</body>
</html>