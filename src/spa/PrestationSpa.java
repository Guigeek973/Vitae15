package spa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.Connection;

public class PrestationSpa {
	private int id;
	private String libelle;
	private double prix;
	private Date duree;
	
	public PrestationSpa(String libelle, double prix, Date duree) {
		this.libelle = libelle;
		this.prix = prix;
		this.duree = duree;
	}
	
	//GETTER
	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM prestation WHERE label = '" + this.libelle + "'");
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.id;
	}
	public String getLibelle() {
		return libelle;
	}
	public double getPrix() {
		return prix;
	}
	public Date getDuree() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("k:m");
		String parsedDate = dateFormat.format(this.getDuree());
		return duree;
	}
	
	//SETTER
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			if (!Connection.existSQL("SELECT id FROM prestation WHERE label = '" + libelle + "'")) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE prestation SET label = '" + libelle + "'");
			}
		}
	}
	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE prestation SET price = " + prix);
		}
	}
	public void setDuree(Date duree) {
		if (this.duree != duree) {
			this.duree = duree;
			Connection.execSQL("UPDATE prestation SET duration = '" + duree + "'");
		}
	}
}
