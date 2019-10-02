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
		System.out.println("������"+getDomain());
		System.out.println("�α���Ŀ�ǵ�"+request.getServletPath());
	}
	
	@Override
	public void execute() {
		PlayerBean param = new PlayerBean();
		
		param.setPlayerId(request.getParameter("playerId"));
		param.setSolar(request.getParameter("solar"));
		System.out.println("�α���Ŀ�ǵ�"+param.getPlayerId());
		System.out.println("�α���Ŀ�ǵ�"+param.getSolar());
		param = PlayerServiceImple.getInstance().login(param);
		//System.out.println("��񿡼� Ŀ�ǵ�� ���޵� �α��ΰ�ü"+param.toString());

			
		//setPage((param!=null) ?request.getParameter("page"):("main"));
		
		System.out.println("�α���Ŀ�ǵ�"+request.getServletPath());
		if(param!=null) {
			this.view = String.format(Constants.DOUBLE_PATH, "player","main");
		}else {
			this.view = String.format(Constants.DOUBLE_PATH, "facade","main");
		}

		
		
		//request.setAttribute("page", request.getParameter("page"));
		//this.view = String.format(Constants.DOUBLE_PATH, "player",page);
		
	   

	}

}
