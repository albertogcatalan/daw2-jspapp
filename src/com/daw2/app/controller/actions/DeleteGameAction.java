package com.daw2.app.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daw2.app.Game;

public class DeleteGameAction extends Action{

	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		Game game = new Game(Integer.parseInt(id));
		game.delete();
		
		return "Main.do";
	}
}
