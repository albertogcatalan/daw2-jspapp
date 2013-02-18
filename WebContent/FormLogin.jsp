<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    
    if (session.getAttribute("email") != null){
    	//System.out.println(email);
    	response.sendRedirect("Main.do");
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
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    </head>

  <body>

    <div class="container">
	    
	  
      <form class="form-signin" method="post" action="Login.do">
        <h2 class="form-signin-heading">Gestión Videojuegos</h2>
     
			<c:forEach var="item" items="${errors}">
			  <c:if test="${item eq 'email'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  <strong>Error!</strong> Introduce un email.
				</div>
			  </c:if>
			  
			  <c:if test="${item eq 'pass'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  <strong>Error!</strong> Introduce una contraseña.
				</div>
			  </c:if>
			  
			  <c:if test="${item eq 'notfound'}">
			    <c:set var="contains" value="true" />
			    <div class="alert alert-error">
				  <strong>Error!</strong> Usuario inválido.
				</div>
			  </c:if>
			</c:forEach>
			
        <input type="text" class="input-block-level" placeholder="Email" name="email">
        <input type="password" class="input-block-level" placeholder="Contraseña" name="pass">
      
        <button class="btn btn-large btn-primary" type="submit">Iniciar sesión</button>
        <a class="btn btn-large" href="FormRegister.do">Registrarme</a>
      </form>
    </div> <!-- /container -->

  

</body></html>