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

    <title>Check Highscore</title>
  </head>
  <body>
	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="login.jsp">PlayRoom</a><br>
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
  

  	<body>
  		<div class="container">
    		<h1>Check Highscore</h1>
    		<form action="CheckHighscoreServlet" method="get">
  				
  				<input type="submit" name="azione" value="update">
  				<div class="form-floating">
  					
  					
			</div>
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
								
								<td>${highscore.highscore}</td>
								<td>${highscore.playerUN}</td>
								<td>${highscore.tournament}</td>
						<td>
							<form action="CheckHighscoreServlet" method="get">
									<input type="submit" name="azione" value="confirm">
									<input type="hidden" name="uname" value="${highscore.playerUN}">
									<input type="hidden" name="score" value="${highscore.highscore}">
									<input type="hidden" name="tournament" value="${highscore.tournament}">
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