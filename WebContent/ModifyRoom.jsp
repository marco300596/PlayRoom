<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
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
    		<form action="CreateTournamentServlet">
  				Your Username: <input type="text" name="uname"><br>
				Name: <input type="text" name="name"><br>
				Genre: <input type="text" name="genre"><br>
				Quantity:<input type="text" name="quantity"><br>
				Description: <input type="text" name="description"><br>
				
				<input	type="radio" name="Hardware" value=hard>Hardware
				<input  type="radio" name="Game" value=game>Game
  				
  				<input type="submit" value="Add Component">
  				<div class="form-floating">
  				</form>		
				</div>
				
		 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>


 </body>
</html>


	





