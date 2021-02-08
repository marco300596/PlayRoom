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

    <title>Check Highscore Page</title>
  </head>
  <body>
	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="login.jsp">PlayRoom</a><br>
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

    <title>Check Highscore</title>
 	</head>
  	<body>
  		<div class="container">
    		<h1>Check Highscore</h1>
    		<form action="CheckHighscoreServlet">
  				Update:<br> 	
  				<input type="submit" name="update" value="update"><br>
  			</form>
				<table class="table table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">N°</th>
				      <th scope="col">Player's Username</th>
				      <th scope="col">Values</th>
				    </tr>
				  </thead>
				  <tbody>
				  		<c:forEach var="highscore" items="${highscores}" >
						<tr>
								<td>${highscore.score}</td>
								<td>${highscore.username}</td>
								<td>
								<form action="CreateTournamentServlet">
										<input type="submit" name="Check" value="Check">
										<input type="hidden" name="score" value="${highscore.score}">
										<input type="hidden" name="plUN" value="${highscore.playerUN}">
										<input type="hidden" name="tournamentN" value="${highscore.tournament}">
								</td>
							</tr>
						</c:forEach>
				 	
				  </tbody>
				</table>
		</div>

</body>
</html>