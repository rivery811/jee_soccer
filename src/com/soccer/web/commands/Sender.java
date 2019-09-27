package com.soccer.web.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sender {

		
		public static void forward(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(Reciever.command.getView());
			try {
			request
			.getRequestDispatcher(Reciever.command.getView())
			.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public static void redirect(HttpServletRequest request, HttpServletResponse response) {
		try {
			response
			.sendRedirect("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
