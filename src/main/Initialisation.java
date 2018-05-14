package main;
import main.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import direction.Hotel;
import hotel.Client;

public class Initialisation {
	
	private static String reqClients = "SELECT * FROM Client";

	public static void initialisation() {
		Hotel hotel = new Hotel(null, null, recupererClients());
	}
	
	private static List<Client> recupererClients() {
		List<Client> lesClients = new ArrayList<Client>();
		ResultSet rs = Connection.getResultSetSQL(reqClients);
		try {
			while (rs.next()) {
				lesClients.add(new Client((int)rs.getInt(1), (String)rs.getString(2), (String)rs.getString(3), (String)rs.getString(4), (String)rs.getString(5), (String)rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lesClients;
	}
}