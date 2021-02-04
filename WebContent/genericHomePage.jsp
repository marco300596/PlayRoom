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
  <form action="GenericServlet" method="get">
  	<nav class="navbar navbar-dark bg-primary">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="#">PlayRoom</a><br>
       	</div>
       	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
  			<input type="submit" class="btn btn-primary" name="menu" value="join">Join Tournament
  			<input type="submit" class="btn btn-primary" name="menu" value="submit">submit Highscore
			<input type="submit" class="btn btn-primary" name="menu" value="book">Book Room
  			<input type="submit" class="btn btn-primary" name="menu" value="reservation">Your Booking
		</div>
		</nav>
			<%
				if(request.getParameter("menu").getValue() != null){
			%>
					<jsp:include page= "CreateTournament.jsp">
			<%
			}
			%>
	</form>	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
  </body>
</html>
