package administrate.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connection;

	public static Connection getConnction() {
		if (connection == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "root");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}


			
		}
		return connection;
	}
}
