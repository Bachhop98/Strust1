package bachtuanhop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bachtuanhop.connect.DBConnect;
import bachtuanhop.connect.EntityManagerFactory;

public class T001DAO {

	public int count(String userId, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC checkUserPassword ?, ?";
		int count = 0;
		try {
			connection = EntityManagerFactory.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;

		} catch (Exception e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}

	public String getUserName(String userId, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "EXEC getUserName ?, ?";
		String userName = "";
		try {
			connection = DBConnect.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userName = resultSet.getString(1);
			}
			return userName;

		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

	}

}
