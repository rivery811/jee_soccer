package com.soccer.web.enums;

public enum DBDriver {
	ORACLE_DRIVER,
	MYSQL_DRIVER,
	MARIA_DRIVER;
	
@Override
public String toString() {
	String driver= "";
	switch (this) {
	case ORACLE_DRIVER:
		driver = "oracle.jdbc.OracleDriver";		
		break;
	case MARIA_DRIVER:
		driver = "jdbc:oracle:thin:@localhost:1521:xe";		
		break;

	default:
		break;
	}
	return driver;
}
	

}
