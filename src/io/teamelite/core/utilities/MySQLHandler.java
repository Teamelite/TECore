package src.io.teamelite.core.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLHandler {
	static final String DBName = "jdbc:mysql://teamelite.io:3306/staff";
	static final String DBUser = "liam";
	static final String DBPass = "tedev200498";
	static Connection c;
	static Statement s;
	
	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(DBName, DBUser, DBPass);
			s = c.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Statement getStatement() {
		return s;
	}
}
