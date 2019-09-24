package com.soccer.web.daoimpls;

import com.soccer.web.daos.TeamDAO;
import com.soccer.web.domains.TeamBean;

public class TeamDAOImpl implements TeamDAO {
	private static TeamDAOImpl instance = new TeamDAOImpl();
	

	public static TeamDAOImpl getInstance() {
		return instance;
	}
private TeamDAOImpl() {}


	@Override
	public void insertTeamBean(TeamBean param) {
		// TODO Auto-generated method stub
		
	}

}
