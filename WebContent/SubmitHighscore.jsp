<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 bg-dark">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Submit Highscore</title>
  </head>
  <body>
	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="Player.jsp">PlayRoom</a><br>
    		<a class="navbar-brand" href="login.jsp">logout</a><br>
				<ul class="list-group list-group-horizontal" style="margin-left: 0%; margin-right: 0%" >
 					<li><a href="JoinTournament.jsp" class="list-group-item list-group-item-action list-group-item-primary">join Tournament</a></li>
  					<li><a href="SubmitHighscore.jsp" class="list-group-item list-group-item-action list-group-item-primary">Submit Highscore</a></li>
  					<li><a href="BookRoom.jsp" class="list-group-item list-group-item-action list-group-item-primary">Book a Room</a></li>
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Your Reservation</a></li>
				</ul>
		</div>
	</nav>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Submit Highscore</title>
 	</head>
  	<body>
  		<h1>Submit Highscore</h1>

   		<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
    		 <div class="btn-group me-2" role="group" aria-label="First group">
    			<form action="SubmitHighscoreServlet" method="post">
  				Insert Highscore: 	
  					<input type="text" name="highscore">
  					<input type="submit" value="Submit Highscore" style = "margin-left: 5px; margin-right: 10px">
				</form>
			</div>
			<form action="SubmitHighscoreServlet" method="get">
				<input type="submit" value="Update View">
			</form>
		</div>
		<div>
			<table class="table table-bordered">
			  <thead>
			    <tr>
			      <th scope="col">Player's Username</th>
			      <th scope="col">Values</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="highscore" items="${highscores}" >
			  	<tr>
					<td>${highscore.highscore}</td>
					<td>${highscore.playerUN}</td>
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