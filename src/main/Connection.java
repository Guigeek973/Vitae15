package main;

import java.sql.*;

public final class Connection {
		
	private static Connection instance = null;
	private static java.sql.Connection connection = null;
	
	private Connection(String nomBase, String user, String password) {
		String url = "jdbc:mysql://localhost/"+nomBase+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String uaM = "jdbc:mariadb://mysql-tomkhakhai.alwaysdata.net/"+ nomBase + "_db";

		String driverSQL = "com.mysql.cj.jdbc.Driver";
		String driverMaria = "org.mariadb.jdbc.Driver";
		            
		try {
			Class.forName(driverMaria);
			Connection.connection = DriverManager.getConnection(uaM, user, password);
			
			if (Connection.connection != null) {
				System.out.println("Connexion établie !");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		if (Connection.instance == null) {
			Connection.instance = new Connection("tomkhakhai","159495","vitae15");
		}
		return Connection.instance;
	}
	
	public static ResultSet getResultSetSQL(String req) {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = Connection.connection.createStatement();
			rs = st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static boolean existSQL(String requete) {
		ResultSet rs = null;
		Statement st = null;
		try {
			st = Connection.connection.createStatement();
			rs = st.executeQuery(requete);
		
			// Si un résultat est renvoyé
			if (rs.getFetchSize() > 0) {
				return true;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void execSQL(String req) {
		Statement st = null;
		try {
			st = Connection.connection.createStatement();
			st.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}