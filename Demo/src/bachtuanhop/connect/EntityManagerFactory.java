package bachtuanhop.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bachtuanhop.constant.Constant;
public class EntityManagerFactory {
static ResourceBundle resourceBundle = ResourceBundle.getBundle(Constant.DB);
public static final EntityManagerFactory instance = new EntityManagerFactory();
public static EntityManagerFactory getInstance() {
	return instance;
}
private EntityManagerFactory() {
	
}
public Connection getConnection() {
	try {
		Class.forName(Constant.DRIVER_DB);
		return DriverManager.getConnection(Constant.URL_DB, Constant.USER_DB,Constant.PASSWORD_DB);
	} catch (ClassNotFoundException|SQLException e) {
		e.printStackTrace();
	}
	return null;
}
}
