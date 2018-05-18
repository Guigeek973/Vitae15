package spa;

import java.util.Date;

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
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}
	
}
