<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%

//comprobamos si esta logeado el usuario
if (session.getAttribute("email") == null){
	response.sendRedirect("FormLogin.do");
} else {
	int type = Integer.parseInt(session.getAttribute("type").toString());	
}

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Gestión Videojuegos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
     <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="Main.do">GestiónApp</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="Main.do">Inicio</a></li>
              <li class="active"><a href="FormInsertGame.do">Añadir juego</a></li>
            <c:if test="${type == 1}">
                  <li><a href="ListUsers.do">Usuarios</a></li>
             </c:if>
             
            </ul>
            <div class="btn-group pull-right">
            
          	<a class="btn btn-info" href="Signout.do"><i class="icon-white icon-off"></i></a>          	
          </div>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>


    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        
        	<form action="InsertGame.do" method="post">
        	
        
        	<div class="row-fluid">
			  <div class="span12">
				  
			    <div class="row-fluid">
			      <div class="span4"></div>
			      <div class="span4">
			      <h1>Añadir</h1>
				  <label for="title">Título</label>
				
            <input id="title" name="title" class="input-xlarge" type="text" placeholder="Escribe el título" value="">
        	
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'title'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce un título.
				</div>
			  </c:if>
			</c:forEach>
			
        	<label for="release_date">Fecha publicación</label>
            <input id="release_date" class="input-xlarge" type="text" name="release_date" placeholder="YYYY-DD-MM" value="">
        
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'release_date'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce una fecha.
				</div>
			  </c:if>
			</c:forEach>
        
        
        	<label for="publisher">Desarrollador</label>
            <input id="publisher" class="input-xlarge" type="text" name="publisher" placeholder="Konami, Capcom, Square Enix..." value="">
        
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'publisher'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce un desarrollador.
				</div>
			  </c:if>
			</c:forEach>
        
        	<label for="system">Plataforma</label>
            <input id="system" class="input-xlarge" type="text" name="system" placeholder="PS3, PC, Wii, Xbox..." value="">
        
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'system'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce una plataforma.
				</div>
			  </c:if>
			</c:forEach>
        
        	<label for="rating">Valoración</label>
            <input id="rating" class="input-xlarge" type="text" name="rating" placeholder="10" value="">
        
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'rating'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce una valoración.
				</div>
			  </c:if>
			</c:forEach>
        
        	<label for="num_players">Jugadores</label>      
            <input id="num_players" class="input-xlarge" type="text" name="num_players" placeholder="2" value="">
        	
        	<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'num_players'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  
				  <strong>Error!</strong> Introduce un número de jugadores.
				</div>
			  </c:if>
			</c:forEach>
        
             <p></p>
            <button type="submit" class="btn btn-primary">Guardar</button>
		  <button type="button" class="btn">Cancelar</button>
        
			      <div class="span3"></div>
			    </div>
		

			  </div>
			</div>
        	
		 </div>
        
        
    </form>

        
      </div>

   
      <hr>

      <footer>
        <p>&copy; Company 2012</p>
      </footer>

    </div> <!-- /container -->


<script src="js/bootstrap-dropdown.js"></script>
</body>
</html>