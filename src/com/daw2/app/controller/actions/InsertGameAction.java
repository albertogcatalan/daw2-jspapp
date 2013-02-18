package com.daw2.app.controller.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.Game;

public class InsertGameAction extends Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String returnAction = null;
		
		//obtenemos los parametros
		String title = request.getParameter("title");
		String release_dateOri = request.getParameter("release_date");
		String publisher = request.getParameter("publisher");
		String system = request.getParameter("system");
		String rating = request.getParameter("rating");
		String num_players = request.getParameter("num_players");
		
		//comprobamos si vienen vacios los campos para retornar error
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> errors = new ArrayList();
		if (title.isEmpty()){errors.add("title");};
		if (release_dateOri.isEmpty()){errors.add("release_date");};
		if (publisher.isEmpty()){errors.add("publisher");};
		if (system.isEmpty()){errors.add("system");};
		if (rating.isEmpty()){errors.add("rating");};
		if (num_players.isEmpty()){errors.add("num_players");};
		
		if (errors.isEmpty()){
		
			// convertimos la fecha de String a Date
			SimpleDateFormat formatText = new SimpleDateFormat("yyyy-MM-dd");
			Date release_date = null;
			try {
				release_date = formatText.parse(release_dateOri);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			java.sql.Date sqldate = new java.sql.Date(release_date.getTime());
			
			//creamos el objeto con los valores e insertamos en la BD
			Game game = new Game(title, sqldate, publisher, system, Integer.parseInt(rating), Integer.parseInt(num_players));
			game.add();
			
			returnAction = "Main.do";
		} else {
			
			//retorno por errores
			request.setAttribute("errors", errors);
			returnAction = "FormInsertGame.do";
		}
		
		return returnAction;
	}

}
