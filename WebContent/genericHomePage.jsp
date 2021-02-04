<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 bg-dark">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
<form action="GenericServlet" name= "form">
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
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
  </body>
</html>
