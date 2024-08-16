package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/student";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "@Lucky123";

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public DBConnection() {
		try {
			Connection conn=DBConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
