<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User added</title>
</head>
<body>
		<h1>User added!</h1>
<p>
First Name: <% String fName = request.getParameter("fname"); out.print(fName); %><br/>
Last Name: <% String lName = request.getParameter("lname"); out.print(lName); %><br/>
Email Name: <% String email = request.getParameter("email"); out.print(email); %><br/>
User Name: <% String uName = request.getParameter("uname"); out.print(uName); %><br/>
Password: <% String pass = request.getParameter("pass"); out.print(pass); %><br/>
</p>
</body>
</html>
