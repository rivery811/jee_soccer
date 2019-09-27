package com.soccer.web.services;

import java.util.List;

import com.soccer.web.domains.PlayerBean;

public interface Playerservice {
	public PlayerBean login(PlayerBean param);
	
	 //2. ������ ����(�ߺ�����,������ �����)
	
	public List<String> findPositions();
	// 4. ������ ��Ű��
	public List<PlayerBean> findByTeamidPosition(PlayerBean param);
	
	public List<PlayerBean> findByTeamidHeightName(PlayerBean param);

}
