<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 bg-dark">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>User Management</title>
  </head>
  <body>
	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="Organizer.jsp">PlayRoom</a><br>
    		<a class="navbar-brand" href="login.jsp">logout</a><br>
				<ul class="list-group list-group-horizontal" style="margin-left: 0%; margin-right: 0%" >
  					<li><a href="RoomRegistration.jsp" class="list-group-item list-group-item-action list-group-item-primary">Room Registration</a></li>
 					<li><a href="CreateTournament.jsp" class="list-group-item list-group-item-action list-group-item-primary">Create Tournament</a></li>
  					<li><a href="CheckHighscore.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Highscore</a></li>
  					<li><a href="CheckReservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Reservation</a></li>
  					<li><a href="DeletePlayer.jsp" class="list-group-item list-group-item-action list-group-item-primary">Delete Player</a></li>
  					<li><a href="ModifyRoom.jsp" class="list-group-item list-group-item-action list-group-item-primary">Modify Room</a></li>
				</ul>
		</div>
	</nav>
  
    <!-- Required meta tags -->
  	<body>
   		<div class="container">
    		<h1>User Management</h1>
    		<%
    		if(request.getSession().getAttribute("message") != null){
    			request.getSession().getAttribute("message");
    		} %>
    		<form action="ManagementServlet" method="get">
  				
  				<div class="form-floating">	
				</div>
				<input type="submit" name="azione" value="Search">
				</form>
				<table class="table table-bordered">
					<thead>
					  	<tr>
					      <th scope="col">Username</th>
					      <th scope="col">Email</th>
					      <th scope="col">Firstname</th>
					      <th scope="col">Lastname</th>
					    </tr>
					 </thead>
					 <tbody>
					 
						<c:forEach var="user" items="${users}" >
							<tr>
								
								<td>${user.username}</td>
								<td>${user.email}</td>
								<td>${user.firstname}</td>
								<td>${user.lastname}</td>
								<td>
									<form action="ManagementServlet" method="get">
									<input type="submit" name="azione" value="Delete">
								
									<input type="hidden" name="usname" value="${user.username}">
									<input type="hidden" name="email" value="${user.email}">
									<input type="hidden" name="fname" value="${user.firstname}">
									<input type="hidden" name="lname" value="${user.lastname}">
									</form>
								</td>
							</tr>
						</c:forEach>
					  </tbody>
					</table>
				
			</div>
					    <!-- Optional JavaScript; choose one of the two! -->
					
					    <!-- Option 1: Bootstrap Bundle with Popper -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
					
					    <!-- Option 2: Separate Popper and Bootstrap JS -->
					    <!--
					    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
					    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
					    -->
	 </body>
</html>