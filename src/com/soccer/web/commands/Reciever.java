package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Reciever {
	public static Command command = new Command();
	public static void init(HttpServletRequest request) {
		System.out.println("리시버 진입");
		 command = Commander.direct(request);
		 System.out.println("리시버");
	}

}
