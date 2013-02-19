package com.daw2.app.controller.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daw2.app.User;
import com.daw2.app.MD5;

public class LoginAction extends Action {
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String returnAction = null;
		
		//obtenemos los parametros
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		//comprobamos si vienen vacios los campos para retornar error
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> errors = new ArrayList();
		if (email.isEmpty()){errors.add("email");};
		if (pass.isEmpty()){errors.add("pass");};
		
		if (errors.isEmpty()){
			
			MD5 md5 = new MD5();
			
			try {
				pass = md5.convert(pass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Boolean ok = User.login(email, pass);

			if (ok == true){
				//login ok, enviamos datos
				String type = String.valueOf(User.getTypeFromEmail(email));

				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setAttribute("type", type);
				
				returnAction = "Main.do";
			} else {
				//retorno por errores
				errors.add("notfound");
				
				request.setAttribute("errors", errors);
				returnAction = "FormLogin.do";
			}
			
			
			
		} else {
			//retorno por errores
			request.setAttribute("errors", errors);
			returnAction = "FormLogin.do";
		}
		
		return returnAction;
	}
}
