package com.soccer.web.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soccer.web.enums.DBDriver;
import com.soccer.web.enums.DBUrl;
import com.soccer.web.pool.Constants;

public class ConnTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;

		try {
			Class.forName(DBDriver.ORACLE_DRIVER.toString());
			conn = DriverManager.getConnection(DBUrl.ORACLE_URL.toString(),Constants.USERNAME,Constants.PASSWORD);
			if(conn != null) {
				System.out.println("연결성공");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT T.TEAM_NAME 소속팀, P.POSITION 포지션, P.BACK_NO 백넘버, P.PLAYER_NAME 선수명, P.HEIGHT 키\r\n" + 
						"FROM PLAYER P JOIN TEAM T\r\n" + 
						"    ON P.TEAM_ID LIKE T.TEAM_ID\r\n" + 
						"WHERE T.TEAM_NAME IN ('드래곤즈','FC서울','일화천마')\r\n" + 
						"    AND P.POSITION IN ('GK','MF')\r\n" + 
						"ORDER BY 1,2");
				List<String>  list =  new ArrayList<>();
				while(rs.next()) {
					
					list.add(rs.getNString("선수명"));
					//count = rs.getString("COUNT");
				}
				System.out.println("선수들의수: \n"+list);
			}else {
				System.out.println("연결실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
