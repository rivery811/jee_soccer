package com.soccer.web.daoimpls;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.soccer.web.daos.PlayerDAO;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pool.Constants;
import com.soccer.web.enums.*;

public class PlayerDAOImpl implements PlayerDAO{
	private static PlayerDAOImpl instance = new PlayerDAOImpl();


	public static PlayerDAOImpl getInstance() {return instance;}
	private PlayerDAOImpl() {}
	
	@Override
	public PlayerBean selectByplayeridsolar(PlayerBean param) {
		System.out.println("다오진입");
		PlayerBean player = null;
		String sql = "SELECT * FROM PLAYER\r\n" + 
				"WHERE PLAYER_ID LIKE ?\r\n" + 
				"AND SOLAR LIKE ?";
		System.out.println(sql);
		System.out.println(param.getPlayerId());

		
		try {
			System.out.println("벤더"+ Constants.VENDOR);
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection().prepareStatement(sql);
			stmt.setString(1, param.getPlayerId());
			stmt.setString(2, param.getSolar());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				player = new PlayerBean();
				player.setPlayerId(rs.getString("PLAYER_ID"));
				player.setBackNo(rs.getString("BACK_NO"));
				player.setBirthDate(rs.getString("BIRTH_DATE"));
				player.setEPlayerName(rs.getString("E_PLAYER_NAME"));
				player.setHeight(rs.getString("HEIGHT"));
				player.setJoinYYYY(rs.getString("JOIN_YYYY"));
				player.setNation(rs.getString("NATION"));
				player.setNickName(rs.getString("NICKNAME"));
				player.setPlayerName(rs.getString("PLAYER_NAME"));
				player.setPosition(rs.getString("POSITION"));
				player.setSolar(rs.getString("SOLAR"));
				player.setTeamId(rs.getString("TEAM_ID"));
				player.setWeight(rs.getString("WEIGHT"));
		
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("결과값"+player.toString());
		return player;
	}

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
	@Override
	public List<PlayerBean> selectByMany(PlayerBean param) {
		List<PlayerBean> players = new ArrayList<PlayerBean>();
		String sql="????";
		try {
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			stmt.setString(1, param.getBackNo());
			stmt.setString(2, param.getBirthDate());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}

	
}

