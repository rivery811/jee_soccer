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
		System.out.println("�α���Ŀ�ǵ�"+param.getPlayerId());
		System.out.println("�α���Ŀ�ǵ�"+param.getSolar());
		param = PlayerServiceImple.getInstance().login(param);
		System.out.println("��񿡼� Ŀ�ǵ�� ���޵� �α��ΰ�ü"+param.toString());
		if(!param.getPlayerId().equals("")) {
			setPage(request.getParameter("page"));
		}else {
			setPage("index.jsp");
		}
		System.out.println("�α���Ŀ�ǵ�"+request.getServletPath());
		
		
	   super.execute();

	}

}
