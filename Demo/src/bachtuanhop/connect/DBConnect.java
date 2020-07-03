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
			Class.forName(resourceBundle.getString(Constant.DRIVER));
			String url = resourceBundle.getString(Constant.URL);
			String user = resourceBundle.getString(Constant.USERDB);
			String password = resourceBundle.getString(Constant.PASSWORDDB);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
}
