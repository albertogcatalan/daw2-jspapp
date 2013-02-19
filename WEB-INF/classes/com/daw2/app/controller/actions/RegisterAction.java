package com.daw2.app.controller.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daw2.app.User;
import com.daw2.app.MD5;


public class RegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String returnAction = null;
		boolean userRegistered = false;
		
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
			
			//comprobamos que ya existe el usuario
			List<User> listUsers = User.showAll();
			for (User registered : listUsers) {
			     // System.out.println("Me gusta " + registered.getEmail());
			      if (registered.getEmail().equals(email)){
			    	userRegistered = true;
			      }
			}  
			
			if (userRegistered == true){
				//retorno por errores
				errors.add("registered");
				request.setAttribute("errors", errors);
				returnAction = "FormRegister.do";
			} else {
				//registramos el usuario
				User user = new User(email, pass);
				user.add();
				returnAction = "Main.do";
			}
			
		} else {
			//retorno por errores
			request.setAttribute("errors", errors);
			returnAction = "FormRegister.do";
		}
		
		
		return returnAction;
	}
}
