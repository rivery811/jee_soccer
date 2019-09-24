package com.soccer.web.daoimpls;

import com.soccer.web.daos.StadiumDAO;
import com.soccer.web.domains.StadiumBean;

public class StadiumDAOimpl implements StadiumDAO {
	private static StadiumDAOimpl instance = new StadiumDAOimpl();
	

	public static StadiumDAOimpl getInstance() {
		return instance;
	}
	private StadiumDAOimpl() {}

	@Override
	public void insertStadiumBean(StadiumBean param) {
		// TODO Auto-generated method stub
		
	}

}
