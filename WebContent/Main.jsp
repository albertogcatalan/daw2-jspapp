<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

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
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

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
              <li class="active"><a href="Main.do">Inicio</a></li>
              <li><a href="FormInsertGame.do">Añadir juego</a></li>
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
        <h1>Listado de videojuegos</h1>
        <p>Gestión de los registros de la base de datos</p>
        <table class="table table-bordered table-hover">
    	<thead>
            <th>Título</th>
            <th>Fecha publicación</th>
            <th>Desarrollador</th>
            <th>Plataforma</th>
            <th>Valoración</th>
            <th>Jugadores</th>
            <th></th>
        </thead>
        <tbody>
        	
        	<c:forEach var="game" items="${showAll}">
        	 <tr>
        	 
            	<td>${game.title}</td>
                <td>${game.release_date}</td>
                <td>${game.publisher}</td>
                <td>${game.system}</td>
                <td>${game.rating}</td>
                <td>${game.num_players}</td>
                <td><a href="FormUpdateGame.do?id=${game.id}" class="btn">Editar</a> <a href="DeleteGame.do?id=${game.id}" class="btn btn-danger">Eliminar</a></td>
				
			</tr>
			</c:forEach>
    
        </tbody>
    </table>

        <p><a href="FormInsertGame.do" class="btn btn-primary btn-large">Añadir videojuego</a></p>
      </div>

   
      <hr>

      <footer>
        <p>&copy; Company 2012</p>
      </footer>

    </div> <!-- /container -->

<script src="js/bootstrap-dropdown.js"></script>
</body>
</html>