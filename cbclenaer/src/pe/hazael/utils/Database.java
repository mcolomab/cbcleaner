package pe.hazael.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	private static final Logger LOGGER = Logger.getLogger(Database.class.getName());
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/cbcleaner";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	public static Connection getDBConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		try {
			return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return connection;
	}

}
