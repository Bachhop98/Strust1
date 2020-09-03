package bachtuanhop.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bachtuanhop.constant.Constant;

public class DBConnect {

	static ResourceBundle resourceBundle = ResourceBundle.getBundle(Constant.DB);

	public static Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString(Constant.DRIVER_DB));
			String url = resourceBundle.getString(Constant.URL_DB);
			String user = resourceBundle.getString(Constant.USER_DB);
			String password = resourceBundle.getString(Constant.PASSWORD_DB);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
}
