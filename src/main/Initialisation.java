package main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hotel.Client;

public class Initialisation {

	public static void Initialisation() {

	}
	
	private void RecupererClients() {
		List<Client> lesClients = new ArrayList<Client>();
		
		ResultSet rs = Connection.getResultSetSQL("SELECT * FROM Client");
		try {
			while (rs.next()) {
				lesClients.add(new Client( (int)rs.getInt(0), (String)rs.getString(1), (String)rs.getString(2), (String)rs.getString(3), (String)rs.getString(4), (String)rs.getString(5) ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
