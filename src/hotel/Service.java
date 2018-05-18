package hotel;

import java.util.List;

import main.Connection;

public class Service {
	private int id;
	private String nom;
	private List<Personnel> lesEmployes;
	
	public Service(int id, String nom, List<Personnel> lesEmployes) {
		super();
		this.id = id;
		this.nom = nom;
		this.lesEmployes = lesEmployes;
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public List<Personnel> getLesEmployes() {
		return lesEmployes;
	}
	
	
	public void setNom(String nom) {
		
		
		if(this.nom != nom) 
		{
			this.nom = nom;
			Connection.execSQL("UPDATE servicejob SET laber = '" + this.nom + "'");
		}
	}
	public void setLesEmployes(List<Personnel> lesEmployes) {
		this.lesEmployes = lesEmployes;
	}
	
	
	
}
