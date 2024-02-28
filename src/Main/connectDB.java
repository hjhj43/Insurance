package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {
	protected static Connection connect = null;
	protected static Statement statement = null;
	protected static ResultSet resultSet = null;
	
	public connectDB() {
		sstart();
		connect();
	}

	public void sstart() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?serverTimezone=UTC&&useSSL=false", "root", "rkskek5997");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean execute(String str) {
		try {
			statement = connect.createStatement();
			statement.executeUpdate(str);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean read(String str) {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(str);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
