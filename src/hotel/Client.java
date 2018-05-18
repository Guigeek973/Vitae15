package hotel;

import main.Connection;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String CP;
	private String tel;
	private Boolean isExternal;
	
	public Client(int id, String nom, String prenom, String adresse, String cP, String tel) { //Client interne
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.CP = cP;
		this.tel = tel;
		this.isExternal = false;
	}
	
	public Client(int id, String nom, String prenom, String tel) { //Client externe
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.isExternal = true;
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getCP() {
		return CP;
	}
	public String getTel() {
		return tel;
	}
	public Boolean getIsExternal() {
		return isExternal;
	}
	
	
	
	public void setNom(String nom) {
		if (this.nom != nom) {
			this.nom = nom;
			Connection.execSQL("UPDATE client SET lastname = '" + this.nom + "'");
		}
	}
	public void setPrenom(String prenom) {
		if (this.prenom != prenom) {
			this.prenom = prenom;
			Connection.execSQL("UPDATE client SET firstname = '" + this.prenom + "'");
		}
	}
	public void setAdresse(String adresse) {
		if (this.adresse != adresse) {
			this.adresse = adresse;
			Connection.execSQL("UPDATE client SET adress = '" + this.adresse + "'");
		}
	}
	public void setCP(String CP) {
		if (this.CP != CP) {
			this.CP = CP;
			Connection.execSQL("UPDATE client SET postal_code = '" + this.CP + "'");
		}
	}
	public void setTel(String tel) {
		if (this.tel != tel) {
			this.tel = tel;
			Connection.execSQL("UPDATE client SET tel = '" + this.tel + "'");
		}
	}
	public void setIsExternal(Boolean isExternal) {
		if (this.isExternal != isExternal) {
			this.isExternal = isExternal;
			Connection.execSQL("UPDATE client SET isExternal = " + this.isExternal);
		}
	}
}