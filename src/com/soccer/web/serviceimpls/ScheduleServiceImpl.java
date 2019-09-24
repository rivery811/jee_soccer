package com.soccer.web.serviceimpls;

import com.soccer.web.services.SchduleService;

public class ScheduleServiceImpl implements SchduleService{
	private static ScheduleServiceImpl instance = new ScheduleServiceImpl();

	public static ScheduleServiceImpl getInstance() {
		return instance;
	}
	private ScheduleServiceImpl() {}

}
