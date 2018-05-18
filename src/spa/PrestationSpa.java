package spa;

import java.util.Date;

import main.Connection;

public class PrestationSpa {
	private int id;
	private String libelle;
	private double prix;
	private Date duree;
	public PrestationSpa(int id, String libelle, double prix, Date duree) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.duree = duree;
	}
	//GETTER
	public int getId() {
		return id;
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
