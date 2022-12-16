package game.connection;

import java.sql.*;
// import com.mysql.jdbc.Driver;

public class Connections {
	Connection connect;
	String url = "jdbc:mysql://localhost:3306/erpegiedb";
	String username = "root";
	String password = "";
	Statement statement;

	public void koneksi(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url, username, password);

			statement = connect.createStatement();
		} catch (Exception e) {
			System.out.println("Failed to Connect!");
		}
	}

	public Connection getConnection () {
		return connect;
	}

	public Statement getStatement () {
		return statement;
	}
}
