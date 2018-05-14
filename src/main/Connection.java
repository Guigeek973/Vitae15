package main;

import java.sql.*;

public final class Connection {
		
	private static Connection instance = null;
	private static java.sql.Connection connection = null;
	
	private Connection(String nomBase, String user, String password) {
		String url = "jdbc:mysql://localhost/"+nomBase+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
			
			if (this.connection != null) {
				System.out.println("Connexion établie !");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		Connection conn = null;
		if (Connection.instance == null) {
			conn = new Connection("tomkhakai","root","");
		}
		return conn;
	}
	
	public static ResultSet getResultSetSQL(String req) {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void execSQL(String req) {
		Statement st = null;
		try {
			st = connection.createStatement();
			st.executeQuery(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}