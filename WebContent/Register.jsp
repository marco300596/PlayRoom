<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%   if(request.getSession().getAttribute("message") == null) {
    	request.getSession().setAttribute("message", "Registration page");
    	}
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("message")%></h1>
<form action="RegistrationServlet">
	Firstname:<br>     <input type="text" name="fname"><br>
	Lastname:<br>      <input type="text" name="lname"><br>
	Email:<br>         <input type="text" name="email"><br>
	Username:<br>      <input type="text" name="uname"><br>
	Password:<br>      <input type="password" name="pass"><br>
	Confirm Password:<br>  <input type="password" name="confpass"><br>
	
	<input	type="radio" name="user" value=player>Player
	<input  type="radio" name="user" value=org>Event Organizer
	
	<input type="submit" value="Register">
</form>


</body>
</html>