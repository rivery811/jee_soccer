package com.soccer.web.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;

import sun.net.www.content.text.plain;

public interface Playerservice {
	public boolean join(PlayerBean param);
	public PlayerBean login(PlayerBean param);
	
	 //2. 포지션 종류(중복제거,없으면 빈공간)
	
	public List<String> findPositions();
	// 4. 수원팀 골키퍼
	public List<PlayerBean> findByTeamidPosition(PlayerBean param);
	
	public List<PlayerBean> findByTeamidHeightName(PlayerBean param);

}
