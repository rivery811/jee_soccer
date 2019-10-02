package com.soccer.web.commands;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.pool.Constants;
import com.soccer.web.serviceimpls.PlayerServiceImple;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		
		execute();
	}
	
	public void execute() {
		PlayerBean player = new PlayerBean();
		switch (request.getParameter("word")) {
		case "find2":
			request.setAttribute("positions", PlayerServiceImple.getInstance().findPositions());
			break;
		case "find4":
	
			player.setTeamId(request.getParameter("teamId"));
			player.setPosition(request.getParameter("position"));
			
			request.setAttribute("players", PlayerServiceImple.getInstance().findByTeamidPosition(player));
			break;
		case "find5":
			player.setTeamId(request.getParameter("teamId"));
			player.setHeight(request.getParameter("height"));
			player.setPlayerName(request.getParameter("playerName"));
			request.setAttribute("players",PlayerServiceImple.getInstance().findByTeamidHeightName(player));

			
			break;

		default:
			break;
		}
		
		this.view = String.format(Constants.DOUBLE_PATH, "player","main");
	}

}
