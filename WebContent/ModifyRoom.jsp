<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 bg-dark">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Organizer Page</title>
  </head>
  <body>
	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="login.jsp">PlayRoom</a><br>
				<ul class="list-group list-group-horizontal" style="margin-left: 0%; margin-right: 0%" >
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Room Registration</a></li>
 					<li><a href="JoinTournament.jsp" class="list-group-item list-group-item-action list-group-item-primary">Create Tournament</a></li>
  					<li><a href="SubmitHighscore.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Highscore</a></li>
  					<li><a href="BookRoom.jsp" class="list-group-item list-group-item-action list-group-item-primary">Check Reservation</a></li>
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Delete Player</a></li>
  					<li><a href="Reservation.jsp" class="list-group-item list-group-item-action list-group-item-primary">Modify Room</a></li>
				</ul>
		</div>
	</nav>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Modify Room</title>
 	</head>
  	<body>
  		<div class="container">
    		<h1>Modify Room</h1>
    		<form action="ModifyRoomServlet">
  				Your Username:<br>     <input type="text" name="uname"><br>
				Name:<br>              <input type="text" name="name"><br>
				Genre:<br>             <input type="text" name="genre"><br>
				Quantity:<br>          <input type="text" name="quantity"><br>
				<label for="desc">Description:</label><br>

				<textarea id="ds" name="description"
         		 rows="5" cols="33">
				</textarea><br>
				
				<input	type="radio" name="type" value=hard>Hardware
				<input  type="radio" name="type" value=game>Game
  				
  				<input type="submit" value="Add Component">
  				<div class="form-floating">
  				</form>		
				</div>
				
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


 </body>
</html>


	





