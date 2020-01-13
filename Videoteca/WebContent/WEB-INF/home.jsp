<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
    <%@include file="../css/styles.css" %>
    
</style>


<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Acme&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Permanent+Marker&display=swap" rel="stylesheet">
<script type="text/javascript">
	// Prevent dropdown menu from closing when click inside the form
	$(document).on("click", ".navbar-right .dropdown-menu", function(e){
		e.stopPropagation();
	});
</script>
</head>
<body>
<nav class="navbar navbar-default navbar-expand-lg navbar-light">
	<div class="navbar-header d-flex col">
		<a class="navbar-brand" href="#">Video<b>Tech</b></a>  		
		<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
			<span class="navbar-toggler-icon"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
	</div>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		<ul class="nav navbar-nav">
			<li class="nav-item"><a href="#" class="nav-link">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right ml-auto">			
			<li class="nav-item">
				<a data-toggle="dropdown" class="nav-link dropdown-toggle" href="#">Login</a>
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="LogIn" method="post">

							<div class="form-group">
								<input type="email" name="email" class="form-control" placeholder="Email" required="required">
							</div>
							<div class="form-group">
								<input type="password" name="password" class="form-control" placeholder="Password" required="required">
							</div>
							<input type="submit" class="btn btn-primary btn-block" value="Login">

						</form>
					</li>
				</ul>
			</li>
			<li class="nav-item">
				<a href="#" data-toggle="dropdown" class="btn btn-primary dropdown-toggle get-started-btn mt-1 mb-1">Registrati</a>
				<ul class="dropdown-menu form-wrapper">					
					<li>
						<form action="register-servlet" method="post">
							<p class="hint-text">Crea il tuo Account!</p>
							<div class="form-group">
								<input type="email" name="email" class="form-control" placeholder="Email" required="required">
							</div>
							<div class="form-group">
								<input type="password" name="pass" class="form-control" placeholder="Password" required="required">
							</div>
							<div class="form-group">
								<input type="password" name="confirmPass" class="form-control" placeholder="Reinserisci la tua Password" required="required">
							</div>
							<input type="submit" class="btn btn-primary btn-block" value="Sign up">
						</form>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>
<!--FINE NAVBAR-->



<div class="container">
        <h2 id="scrittacentrale">FILM APPENA INSERITI</h2>  
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
      
          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item active">
             <img src="https://pad.mymovies.it/filmclub/2016/08/074/locandina.jpg" alt="zombieland" style="width:100%;"/>
            </div>
      
            <div class="item">
              <img src="https://pad.mymovies.it/filmclub/2019/08/038/locandina.jpg" alt="ilprimonatale" style="width:100%;">
            </div>
          
            <div class="item">
              <img src="https://images-na.ssl-images-amazon.com/images/I/A1FJ5175oaL._SY445_.jpg" alt="frozen2" style="width:100%;">
            </div>
          </div>
      
          <!-- Left and right controls -->
          <a class="left carousel-control" id="sinistra" href="#myCarousel"  data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Precedente</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" id="destra" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Successivo</span>
          </a>
        </div>
      </div>



<!-- JS Scripts -->


</body>
</html>