package com.soccer.web.serviceimpls;


import java.util.List;

import com.soccer.web.daoimpls.PlayerDAOImpl;
import com.soccer.web.daos.PlayerDAO;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.Playerservice;



public class PlayerServiceImple implements Playerservice{
	private static PlayerServiceImple instance = new PlayerServiceImple();
	

	public static PlayerServiceImple getInstance() {
		return instance;
	}
	private PlayerServiceImple() {}

	@Override
	public List<String> findPositions() {
	
		return PlayerDAOImpl.getInstance().selectPositions();
	}

	@Override
	public List<PlayerBean> findByTeamidPosition(PlayerBean param) {
		List<PlayerBean> players = PlayerDAOImpl.getInstance().selectByTeamidPosition(param);
		return players;
	}

	@Override
	public List<PlayerBean> findByTeamidHeightName(PlayerBean param) {
		List<PlayerBean> players = PlayerDAOImpl.getInstance().selectByTeamidHeightName(param);	
		return players;
	}

}
