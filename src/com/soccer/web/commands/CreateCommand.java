package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.pool.Constants;
import com.soccer.web.serviceimpls.PlayerServiceImple;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		
		execute();
	}
	public void execute() {
		System.out.println("크리에이트커맨드진입");
		PlayerBean player = new PlayerBean();
		player.setBackNo(request.getParameter("backNo"));
		player.setBirthDate(request.getParameter("birthDate"));
		player.setEPlayerName(request.getParameter("ePlayerName"));
		player.setHeight(request.getParameter("height"));
		player.setJoinYYYY(request.getParameter("joinYYYY"));
		player.setNation(request.getParameter("nation"));
		player.setNickName(request.getParameter("nickName"));
		player.setPlayerId(request.getParameter("playerId"));
		player.setPlayerName(request.getParameter("playerName"));
		player.setPosition(request.getParameter(""));
		player.setSolar(request.getParameter("solar"));
		player.setTeamId(request.getParameter("teamId"));
		player.setWeight(request.getParameter("weight"));
		if(PlayerServiceImple.getInstance().join(player)) {
			System.out.println("회원가입성공");
		}else {
			System.out.println("회원가입실패");
		}
		this.view = String.format(Constants.DOUBLE_PATH, "facade","main");
	
	}

}
