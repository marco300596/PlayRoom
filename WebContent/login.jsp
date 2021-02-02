<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="LoginServlet">
	Username: <input type="text" name="uname"><br>
			
			<input	type="radio" name="user" value=player>Player
			<input  type="radio" name="user" value=org>Event Organizer
	Password: <input type="password" name="pass"><br>
	<input type="submit" value="login">
</form>

</body>
</html>