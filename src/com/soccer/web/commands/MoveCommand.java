package com.soccer.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command {
	public MoveCommand(HttpServletRequest request) throws Exception {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		
		execute();
		
	}
	public void execute() {
		setPage(request.getParameter("page"));
		super.execute();
		System.out.println(request.getServletPath());
		
	
	}


}
