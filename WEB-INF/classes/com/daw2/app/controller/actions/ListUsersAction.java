package com.daw2.app.controller.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.User;

public class ListUsersAction extends Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

			
		List<User> listUsers = User.showAll();
		
		request.setAttribute("showAll", listUsers);
		
		return "ListUsers.jsp";
	}
}
