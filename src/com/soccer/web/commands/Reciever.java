package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Reciever {
	public static Command command = new Command();
	public static void init(HttpServletRequest request) {
		System.out.println("���ù� ����");
		 command = Commander.direct(request);
		 System.out.println("���ù�");
	}

}
