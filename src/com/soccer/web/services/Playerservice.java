package com.soccer.web.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.soccer.web.domains.PlayerBean;

import sun.net.www.content.text.plain;

public interface Playerservice {
	public boolean join(PlayerBean param);
	public PlayerBean login(PlayerBean param);
	
	 //2. ������ ����(�ߺ�����,������ �����)
	
	public List<String> findPositions();
	// 4. ������ ��Ű��
	public List<PlayerBean> findByTeamidPosition(PlayerBean param);
	
	public List<PlayerBean> findByTeamidHeightName(PlayerBean param);

}
