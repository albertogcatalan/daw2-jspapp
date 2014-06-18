daw2-jspapp
===========

Webapp demostrativa en JavaEE utilizando Bootstrap, Hibernate, JSTL y el patrón MVC.

===================================
GestiónVideojuegos
===================================
		
:Fecha: 19 de Febrero de 2013
:Autor: Alberto González
:Version: 0.1 Beta
		
		
		
Índice
=======
		
* Estructura_
* Componentes_
* Instalar_
		
		
.. _Estructura:
		
Estructura
===============
				 
La **estructura** de la app esta definida con las siguientes secciones: 
		
* **Inicio**: es la página principal de la Web donde se puede ver el listado de videojuegos.
		
* **Añadir juegos**: permite añadir videojuegos a la BD.

* **Editar/Eliminar**: permite editar/eliminar el videojuego seleccionado en el listado principal.

* **Listado de usuarios**: permite ver los usuarios registrados.
		
* **Nuevo usuario**: permite crear usuarios siempre que estés logeado.


.. _Componentes:

Componentes
===============

La aplicación está desarrollada en la parte backend con **Java** e **Hibernate** y **Bootstrap** con **JSTL** a nivel frontend, con un patrón MVC a nivel completo de la aplicación.

El funcionamiento de acciones hace que tengamos por un lado las clases Game y User enlazados a través de el controlador AppController con las acciones que queramos.

Esta aplicación corre en Tomcat.
		


.. _Instalar:

Instalar
===============

* Para instalar esta aplicación debes primero crear la base de datos en mysql, importar el archivo videogames.sql o ejecutarlo en tu phpmyadmin.

* Una vez esté creada la BD, copia todo el contenido de la carpeta de la aplicación a tu localhost o hosting teniendo en cuenta Tomcat. En el fichero **hibernate.cfg.xml** podrás añadir los datos de acceso y el nombre de tu BD.

* Si accedes a la aplicación aparecerá el formulario de Login/Registro. Ten en cuenta que por defecto se crea el usuario **admin@admin.com** con contraseña **admin7007** para tener acceso al panel de visualización de usuarios.
