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
		<title>Insert title here</title>
	</head>
	<body>
		<h1><%=request.getSession().getAttribute("message")%></h1>
			<form action="LoginServlet">
			Username: <input type="text" name="uname"><br>
			Password: <input type="password" name="pass"><br>
			<input	type="radio" name="user" value=player>Player
			<input  type="radio" name="user" value=org>Event Organizer<br>
			<input type="submit" value="login">
			</form>


	</body>
</html>