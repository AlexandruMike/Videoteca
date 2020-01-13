<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Film" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@ include file="../css/styles.css"%>
</style>


<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Acme&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Permanent+Marker&display=swap"
	rel="stylesheet">
<script type="text/javascript">
	// Prevent dropdown menu from closing when click inside the form
	$(document).on("click", ".navbar-right .dropdown-menu", function(e) {
		e.stopPropagation();
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default navbar-expand-lg navbar-light">
		<div class="navbar-header d-flex col">
			<a class="navbar-brand" href="#">Video<b>Tech</b></a>
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
				<span class="navbar-toggler-icon"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse"
			class="collapse navbar-collapse justify-content-start">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a href="#" class="nav-link">Home</a></li>
				<li class="nav-item"><a href="chi-siamo" class="nav-link">Chi
						Siamo</a></li>

				<li class="nav-item"><a href="#" class="nav-link">Contatti</a></li>
			</ul>
			<form class="navbar-form form-inline">
				<div class="input-group search-box">
					<input type="text" id="search" class="form-control"
						placeholder="Cerca un film..."> <span
						class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right ml-auto">
				<li class="nav-item">
					<form action="logOut" method="GET">
						<ul class="nav navbar-nav navbar-right ml-auto mt-auto">
							<li class="nav-item">
								<button type="submit" class="btn btn-danger mt-2">Log
									Out</button>
							</li>
						</ul>
					</form>
				</li>
			</ul>
		</div>
	</nav>
	<!--FINE NAVBAR-->
	
	<div class="container">
		  <div class="row">
		  	<h1 id="scrittacentrale">Welcome ${email} </h1>
				<br>
		    <div class="col-12 col-sm-6 col-md-6 col-lg-6">
				<div style="background-color: white;">
	<% List<Film> film = (List<Film>) request.getAttribute("listaFilm");%>
<table class="table table-bordered table-striped text-center">
<tr>
<th>titolo</th>
<th>durata</th>
<th>copie</th>
</tr>
  <%for(int i=0; i < film.size();i++){%>
            <tr>
                <td><%=film.get(i).getTitolo() %></td>
                <td><%=film.get(i).getDurata() %></td>
                <td><%=film.get(i).getCopie() %></td>
             	<td>
             	<form method="POST" action="AggiungiFilm?val=remove">
					<input type="hidden" value=<%=film.get(i).getId()%> name="idSet">
					<input type="submit" value="elimina">
				</form>
				<form action="AggiungiFilm?val=modify" method="POST">
					<input type="hidden" value=<%=film.get(i).getId()%> name="idSet">
					<input type="submit" value="modifica">
				</form>
				</td>	
            </tr>
            <%} %>
</table>

			</div>
		</div>
	</div>
</div>
</html>