<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1 bg-dark">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Room Registration</title>
  </head>
  
  	<body>
  		<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="login.jsp">PlayRoom</a><br>
				<ul class="list-group list-group-horizontal" style="margin-left: 0%; margin-right: 0%" >
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Room Registration</a></li>
 					<li><a href="CreateTournament.jsp" class="list-group-item list-group-item-action list-group-item-primary">Create Tournament</a></li>
  					<li><a href="SubmitHighscore.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Highscore</a></li>
  					<li><a href="BookRoom.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Reservation</a></li>
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Delete Player</a></li>
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Modify Room</a></li>
				</ul>
		</div>
	</nav>
  		<div class="container">
    		<h1>Room Registration</h1>
    		<!-- viene preso il messaggio dalla servlet e stampato sul jsp (get) -->
    		<form action="RoomRegistrationServlet">
  				Name of the Room:<br> 		    <input type="text" name="rname"><br>
  				Number of seat:<br> 	   		<input type="text" name="nseat"><br>
  				<label for="desc">Description:</label><br>

				<textarea id="ds" name="description"
         		 rows="5" cols="33">
				</textarea><br>
			
  				Add city:<br> 		<input type="text" name="city"><br>
  				Add address:<br>		<input type="text" name="address"><br>
  				Add price:<br>				<input type="text" name="price"><br>
  				
  				 <label for="img">Select image:</label><br>
 				 <input type="file" id="img" name="img" accept="image/*"><br>
  				 <input type="submit" value="Add image"><br>
  				
  				<input type="submit" value="Register Room">
  				
 
			</form>
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