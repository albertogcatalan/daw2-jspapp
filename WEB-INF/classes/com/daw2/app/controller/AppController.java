package com.daw2.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.controller.actions.Action;

public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//obtenemos GET para enviar la accion
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		String url=request.getServletPath();
		Action action= Action.getAction(getNameAction(url));
		dispatcher = request.getRequestDispatcher(action.execute(request, response));
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String getNameAction(String url) {
		
		
		return url.substring(1,url.length()-3);
		
	}

}