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

    <title>Check Reservation</title>
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
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Check Reservation</title>
 	</head>
  	<body>
  		<div class="container">
    		<h1>Check Reservation</h1>
    		<form action="CheckReservationServlet">
  				<input type="submit" name="azione" value="Update">
  				<div class="form-floating">
  					
  					
				</div>
 <table class="table table-bordered">
					<thead>
					  	<tr>
					      <th scope="col">Username</th>
					      <th scope="col">Date</th>
					      <th scope="col">Hour</th>
					      <th scope="col">Numseat</th>
					      <th scope="col">Roomname</th>
					    </tr>
					 </thead>
					 <tbody>
						<c:forEach var="reservation" items="${reservations}">
							<tr>
								<td>${reservation.playerusername}</td>
								<td>${reservation.date}</td>
								<td>${reservation.hour}</td>
								<td>${resrvation.numberofplayer}</td>
								<td>${resrvation.roomname}</td>
								<td>
									<input type="submit" name="azione" value="confirm">
									<input type="submit" name="azione" value="update">
									<input type="hidden" name="uname" value="${reservation.playerusername}">
									<input type="hidden" name="date" value="${reservation.date}">
									<input type="hidden" name="hour" value="${reservation.hour}">
									<input type="hidden" name="numseat" value="${resrvation.numberofplayer}">
									<input type="hidden" name="rname" value="${resrvation.roomname}">
								</td>
							</tr>
						</c:forEach>
					  </tbody>
					</table>
			</form>
		</div>
		
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


</body>
</html>