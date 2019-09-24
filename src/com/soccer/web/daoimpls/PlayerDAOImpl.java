package com.soccer.web.daoimpls;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.soccer.web.daos.PlayerDAO;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pool.Constants;


public class PlayerDAOImpl implements PlayerDAO{
	private static PlayerDAOImpl instance = new PlayerDAOImpl();

	//private static Connection conn;

	public static PlayerDAOImpl getInstance() {return instance;}
	private PlayerDAOImpl() {}

	@Override
	public List<String> selectPositions() {
		List <String> positions = new ArrayList<>(); 
		try {
			String sql = "SELECT DISTINCT POSITION as position \n" + 
					"FROM PLAYER";
			 ResultSet rs = DatabaseFactory
						.createDatabase(Constants.VENDOR)
						.getConnection()
						.prepareStatement(sql).executeQuery();
			 while(rs.next()) {
				 positions.add(rs.getString("position"));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	

		return positions;
	}

	@Override
	public List<PlayerBean> selectByTeamidPosition(PlayerBean param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<PlayerBean> selectByTeamidHeightName(PlayerBean param) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

