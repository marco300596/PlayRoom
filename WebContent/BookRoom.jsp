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

    <title>Player Page</title>
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

    <title>Book Room</title>
 	</head>
  	<body>
  		<div class="container">
    		<h1>Room Booking</h1>
    		<form action="CreateTournamentServlet">
  				Insert the Game Name:<br> 	<input type="text" name="gname"><br>
  				Insert your group size:<br> 	<input type="text" name="gsize"><br>
  				Insert the specific Hardware:<br> 	<input type="text" name="hard"><br>
  				Insert the Specific City:<br> 	<input type="text" name="city"><br>
  				Insert reservation's hour:<select>
  					<option value="11">11</option>
  					<option value="12">12</option>
  					<option value="13">13</option>
  					<option value="14">14</option>
  					<option value="15">15</option>
  					<option value="16">16</option>
  					<option value="17">17</option>
  					<option value="18">18</option>
  					<option value="19">19</option>
  				
  				</select>
  				
  				<input type="submit" value="Search">
  				<input type="submit" value="Book it">
  				<div class="form-floating">
  					
  					
				</div>
 <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Room's Name</th>
      <th scope="col">Max Group Size</th>
      <th scope="col">Price</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
  <tbody>
    <tr>
     
      <td></td>
      <td></td>
      <td></td>
       <td></td>
    </tr>
    <tr>
     
      <td></td>
      <td></td>
      <td></td>
       <td></td>
    </tr>
    <tr>
     
       <td></td>
      <td></td>
      <td></td>
       <td></td>
    </tr>
    <tr>
    
       <td></td>
      <td></td>
      <td></td>
       <td></td>
    </tr>
  </tbody>
</table>
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