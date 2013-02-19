package com.daw2.app.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		return "FormRegister.jsp";
	}
}
