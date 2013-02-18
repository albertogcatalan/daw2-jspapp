package com.daw2.app.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.Game;

public class FormUpdateGameAction extends Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		Game game = Game.getFromId(Integer.parseInt(id));
		
		request.setAttribute("game", game);
		return "FormUpdateGame.jsp";
	}
}
