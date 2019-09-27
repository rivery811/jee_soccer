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
				System.out.println("���Ἲ��");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT T.TEAM_NAME �Ҽ���, P.POSITION ������, P.BACK_NO ��ѹ�, P.PLAYER_NAME ������, P.HEIGHT Ű\r\n" + 
						"FROM PLAYER P JOIN TEAM T\r\n" + 
						"    ON P.TEAM_ID LIKE T.TEAM_ID\r\n" + 
						"WHERE T.TEAM_NAME IN ('�巡����','FC����','��ȭõ��')\r\n" + 
						"    AND P.POSITION IN ('GK','MF')\r\n" + 
						"ORDER BY 1,2");
				List<String>  list =  new ArrayList<>();
				while(rs.next()) {
					
					list.add(rs.getNString("������"));
					//count = rs.getString("COUNT");
				}
				System.out.println("�������Ǽ�: \n"+list);
			}else {
				System.out.println("�������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
