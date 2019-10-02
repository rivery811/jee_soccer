package com.soccer.web.daos;

import java.util.List;

import com.soccer.web.domains.PlayerBean;
import com.soccer.web.domains.ScheduleBean;
import com.soccer.web.domains.StadiumBean;
import com.soccer.web.domains.TeamBean;

public interface PlayerDAO {
	
	public boolean insertPlayer(PlayerBean param);
	public PlayerBean selectByplayeridsolar(PlayerBean param);
	public List<String> selectPositions() ;
	public List<PlayerBean> selectByTeamidPosition(PlayerBean param);
	public List<PlayerBean> selectByTeamidHeightName(PlayerBean param);
	public List<PlayerBean> selectByMany(PlayerBean param);


	
}
