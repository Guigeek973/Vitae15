package hotel;

import java.util.List;

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
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setLesEmployes(List<Personnel> lesEmployes) {
		this.lesEmployes = lesEmployes;
	}
	
	
	
}
