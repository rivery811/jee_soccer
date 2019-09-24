package com.soccer.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.serviceimpls.PlayerServiceImple;
import com.soccer.web.services.Playerservice;


@WebServlet("/player.do")
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerBean player = null;
		
		switch (request.getParameter("action")) {
		case "move":
			List<String> list = PlayerServiceImple.getInstance().findPositions();
			
			
			request.setAttribute("positions", list);

			break;
		case "2_position":
		
			request.setAttribute("positions",  PlayerServiceImple.getInstance().findPositions());
	
			break;
		case "4_find_by_teamid_position":
			String teamId= request.getParameter("teamId");
			String position = request.getParameter("position");
			player = new PlayerBean();
			
			player.setTeamId(teamId);
			player.setPosition(position);
			System.out.println(player.getTeamId()+player.getPosition());
			request.setAttribute("players",PlayerServiceImple.getInstance().findByTeamidPosition(player));
			

			break;
			
		case "5_find_by_teamid_height_name":
			player = new PlayerBean();
			player.setTeamId(request.getParameter("teamId"));
			player.setHeight(request.getParameter("height"));
			player.setPlayerName(request.getParameter("playerName"));
	
			request.setAttribute("players",PlayerServiceImple.getInstance().findByTeamidHeightName(player));
			
			

			break;
	

		default:
			break;
			
		}
	
		request.getRequestDispatcher
		(String.format("WEB-INF/views/%s.jsp",request.getParameter("page"))).forward(request, response);
	
	}


}
