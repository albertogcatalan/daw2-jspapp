<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

//comprobamos si esta logeado el usuario
if (session.getAttribute("email") == null){
	response.sendRedirect("FormLogin.do");
} else {
	int type = Integer.parseInt(session.getAttribute("type").toString());
	if (type != 1){
		response.sendRedirect("Main.do");
	}
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
              <li><a href="Main.do">Inicio</a></li>
              <li><a href="FormInsertGame.do">Añadir juego</a></li>
              <c:if test="${type == 1}">
                  <li class="active"><a href="ListUsers.do">Usuarios</a></li>
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
        <h1>Listado de usuarios</h1>
        <p>Gestión de usuarios</p>
        <table class="table table-bordered table-hover">
    	<thead>
            <th>Email</th>
            <th>Contraseña (MD5)</th>
            <th>Tipo</th>
            <th>Opciones</th>
            
        </thead>
        <tbody>
        	<c:forEach var="user" items="${showAll}">
        	 <tr>
        	 
            	<td>${user.email}</td>
                <td>${user.pass}</td>
                <c:choose>
	                <c:when test="${user.type == 0}">
					   <td>Usuario</td>
					   <td><a href="DeleteUser.do?id=${user.id}" class="btn btn-danger">Eliminar</a></td>
					</c:when>
					<c:when test="${user.type == 1}">
					   <td>Administrador</td>
					   <td></td>
					</c:when>
				</c:choose>
                
				
			</tr>
			</c:forEach>
            
        </tbody>
    </table>
	<p><a href="FormRegister.do" class="btn btn-primary btn-large">Registrar usuario</a></p>
       
      </div>

   
      <hr>

      <footer>
        <p>&copy; Company 2012</p>
      </footer>

    </div> <!-- /container -->
<script src="js/bootstrap-dropdown.js"></script>
</body>
</html>