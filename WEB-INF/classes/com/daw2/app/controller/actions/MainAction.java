package com.daw2.app.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daw2.app.Game;


public class MainAction extends Action{
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

			List<Game> listGames = Game.showAll();
			
			request.setAttribute("showAll", listGames);
			return "Main.jsp";
		

	}
}
