package com.daw2.app.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.User;

public class DeleteUserAction extends Action{
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		User user = new User(Integer.parseInt(id));
		user.delete();
		
		return "ListUsers.do";
	}
}
