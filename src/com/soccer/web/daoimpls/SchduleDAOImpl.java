package com.soccer.web.daoimpls;

import com.soccer.web.daos.ScheduleDAO;
import com.soccer.web.domains.ScheduleBean;

public class SchduleDAOImpl implements ScheduleDAO {
	private static SchduleDAOImpl instance = new SchduleDAOImpl();
	

	public static SchduleDAOImpl getInstance() {
		return instance;
	}
	private SchduleDAOImpl() {}


	@Override
	public void insertScheduleBean(ScheduleBean param) {
		// TODO Auto-generated method stub
		
	}

}
