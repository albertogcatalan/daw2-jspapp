package com.daw2.app.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

	public abstract String execute(HttpServletRequest request,
			HttpServletResponse response);

	//obtenemos accion
	public  static Action getAction(String tipo) {

		Action action = null;
		try {
			action = (Action) Class.forName(getPackage()+"."+tipo+"Action").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return action;

	}
	
	private static  String getPackage() {
		
		
		return Action.class.getPackage().getName();
	}
}
