package pe.hazael.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.hazael.utils.Database;

public class UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());
	
	public Boolean login(String username, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = Database.getDBConnection();
			String query = "SELECT * FROM user where username = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next() ? true : false;
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} finally {
			if (null != statement) statement.close();
			if (null != connection) connection.close();
		}
		
		return false;
	}
}
