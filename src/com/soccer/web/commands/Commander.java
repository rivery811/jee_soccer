package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;
import com.soccer.web.enums.*;
public class Commander {
	public static Command direct(HttpServletRequest request) {
		System.out.println("Ä¿¸Ç´õ");
		Command o = null;
		
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case SEARCH:
			
			o = new SearchCommand();
			break;
		case LOGIN:
			o= new LoginCommand(request);
			break;
		case MOVE:
			try {
				o = new MoveCommand(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	

		return o;
	}


}
