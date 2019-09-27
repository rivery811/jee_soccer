package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.pool.Constants;
import com.soccer.web.serviceimpls.PlayerServiceImple;

public class LoginCommand extends Command{
	
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		execute();
	}
	
	@Override
	public void execute() {
		PlayerBean param = new PlayerBean();
		
		param.setPlayerId(request.getParameter("playerId"));
		param.setSolar(request.getParameter("solar"));
		System.out.println("로그인커맨드"+param.getPlayerId());
		System.out.println("로그인커맨드"+param.getSolar());
		param = PlayerServiceImple.getInstance().login(param);
		System.out.println("디비에서 커맨드로 전달된 로그인객체"+param.toString());
		if(!param.getPlayerId().equals("")) {
			setPage(request.getParameter("page"));
		}else {
			setPage("index.jsp");
		}
		System.out.println("로그인커맨드"+request.getServletPath());
		
		
	   super.execute();

	}

}
