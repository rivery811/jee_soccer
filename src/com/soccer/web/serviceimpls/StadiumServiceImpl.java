package com.soccer.web.serviceimpls;

import com.soccer.web.services.SchduleService;

public class StadiumServiceImpl implements SchduleService{
	private static StadiumServiceImpl instance = new StadiumServiceImpl();

	public static StadiumServiceImpl getInstance() {
		return instance;
	}
	
	private StadiumServiceImpl() {}

}
