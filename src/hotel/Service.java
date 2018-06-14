package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.Connection;

public class Service {
	private int id;
	private String nom;

	public Service(String nom) {
		this.nom = nom;
	}

	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection
					.getResultSetSQL("SELECT id FROM servicejob" + " WHERE label = '" + this.nom + "'");
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (this.nom != nom) {
			if (!Connection.existSQL("SELECT id FROM servicejob WHERE label = '" + nom + "'")) {
				this.nom = nom;
				Connection.execSQL("UPDATE servicejob SET label = '" + nom + "' WHERE id = " + this.getId());
			}
		}
	}

}
