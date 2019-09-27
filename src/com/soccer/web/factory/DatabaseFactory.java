package com.soccer.web.factory;

import com.soccer.web.enums.*;
public class DatabaseFactory {
	public static Database createDatabase(String vendor) {
		Database db = null;
		
		switch (DB.valueOf(vendor)) {
		case ORACLE:
			db = new Oracle();
			break;
		case MARIADB :
			db = new Mariadb();
			break;
		case MYSQL :	
			break;
		case H2 :	
			break;
		case DB2 :	
			break;
				
		default:
			break;
		}
		
		
		return db;
		}

}
