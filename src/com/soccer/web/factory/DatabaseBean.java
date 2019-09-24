package com.soccer.web.factory;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import lombok.Data;
@Data
public class DatabaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String  url, userid, password, driver;
	private Connection conn;
	public DatabaseBean(String url, String userid,String password,String driver) {
		this.url = url;
		this.userid = userid;
		this.password = password;
		this.driver = driver;
		
		
		
		
	}
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,userid,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	

}
