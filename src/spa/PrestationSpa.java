package spa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import main.Connection;

public class PrestationSpa {
	private int id;
	private String libelle;
	private double prix;
	private Date duree;
	
	
	public PrestationSpa(String libelle, double prix, Date duree) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.duree = duree;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	//GETTER
	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM prestation"
					+ " WHERE label = " + this.libelle
					+ " AND price = " + this.prix
					+ " AND duration = " + this.duree);
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
	}
	public String getLibelle() {
		return libelle;
	}
	public double getPrix() {
		return prix;
	}
	public Date getDuree() {
		return duree;
	}
	
	//SETTER
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE prestation SET label = '" + this.libelle + "'");
		}
	}
	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE prestation SET price = '" + this.prix + "'");
		}
	}
	public void setDuree(Date duree) {
		if (this.duree != duree) {
			this.duree = duree;
			Connection.execSQL("UPDATE prestation SET duration = '" + this.duree + "'");
		}
	}
}
