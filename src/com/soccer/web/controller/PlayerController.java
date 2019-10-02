package com.soccer.web.controller;

import com.soccer.web.enums.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.commands.Commander;
import com.soccer.web.commands.Reciever;
import com.soccer.web.commands.SearchCommand;
import com.soccer.web.commands.Sender;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImple;
import com.soccer.web.services.Playerservice;


@WebServlet("/player.do")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("플레이어컨트롤러진입");
	System.out.println(request.getParameter("playerId"));
	System.out.println(request.getParameter("solar"));
	System.out.println(request.getParameter("teamId"));
	System.out.println(request.getParameter("position"));
	System.out.println(request.getParameter("action"));
	System.out.println(request.getParameter("page"));
		//Commander commander = new Commander();
		Reciever.init(request);
       // Reciever.command.execute();
		System.out.println("플레이어 컨트롤러스위치직전");
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case CREATE: request.setAttribute("page", "login");
			break;
		case LOGIN: request.setAttribute("page", "login");
			break;
				
		}
		request.setAttribute("word", 
				request.getParameter("word")==null
					?"main"
						:request.getParameter("word"));
		System.out.println("단어"+request.getAttribute("word"));


		System.out.println("플레이어 컨트롤러센더직전");
		Sender.forward(request, response);

	
	
	}


}
